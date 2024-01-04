package com.td.TrenD.controller;

import com.td.TrenD.model.TrendVO;
import com.td.TrenD.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.td.TrenD.model.StatisticsVO;
import com.td.TrenD.model.UserVO;
import com.td.TrenD.service.StatisticsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/trend")
public class TrendController {

    @Autowired
    private TrendService trendService;
  
    @Autowired
    private StatisticsService staticsService;

    @GetMapping("/trendList")
    public String trend() {
        return "trend/trendList";
    }

    @GetMapping("/list/{page}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getTrendList(
            @PathVariable("page") int page,
            @RequestParam(defaultValue = "") String keyword) {

        System.out.println("TrendList Controller - Page: " + page + ", Keyword: " + keyword);

        int limit = 10;
        PageRequest pageable = PageRequest.of(page - 1, limit);
        System.out.println("pageable : " + pageable);

        try {
            Page<TrendVO> trendPage;
            if (StringUtils.hasText(keyword)) {
                trendPage = trendService.searchTrendList(keyword, pageable);
                System.out.println("Keyword is valid: " + keyword);
                System.out.println("TrendSearchList");
            } else {
                trendPage = trendService.getTrendList(pageable);
                System.out.println("Keyword is invalid or empty.");
                System.out.println("TrendList");
            }

            Map<String, Object> response = new HashMap<>();
            response.put("page", page);
            response.put("keyword", keyword);
            response.put("listCount", trendPage.getTotalElements());
            response.put("trendList", trendPage.getContent());
            response.put("pageCount", trendPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error in TrendList Controller: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @RequestMapping("post")
        public String commContent (HttpServletRequest request, Model model){

            // 트렌드 글 처리 별도 조건문 처리

            UserVO user = new UserVO();

            TrendVO post = new TrendVO();
            int trNo = Integer.parseInt(request.getParameter("trNo"));

            post = trendService.trendContent(trNo);
            if (post.getTrDelYn() == 'n') {
                int readCount = post.getTrReadCount() + 1;
                post.setTrReadCount(readCount);
                trendService.saveTrend(post);


                StatisticsVO statics = new StatisticsVO();
                statics = staticsService.checkStatics(userId, trNo);
                if (statics == null) {
                    statics = new StatisticsVO();
                    statics.setTrNo(trNo);
                    user.setUserId(userId);
                    statics.setUserVO(user);
                    staticsService.saveStatics(statics);
                }
            }

            model.addAttribute("post", post);

            return "trend/trendContent";

    }
}
