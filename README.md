# TrenD
> 한 줄 설명
## 프로젝트 링크
## 소개
기호 1번.  
실시간 검색어를 한눈에 파악하고 관심있는 검색어에 대해 이야기 나눌 수 있는 커뮤니티입니다.  
[Google Trends](https://trends.google.com/trends/trendingsearches/daily?geo=KR&hl=ko) 데이터를 이용하여 실시간 검색어를 목록 형태로 보여줍니다.  
사용자는 커뮤니티를 통해 실시간 검색어에 대한 의견을 자유롭게 나눌 수 있습니다.  
주제를 직접 등록하여 대화를 시작할 수 있으며, 성별, 나이, 지역에 관련된 유의미한 통계 데이터를 확인할 수 있습니다.

기호 2번.  
실시간 검색어를 목록에서 확인하고 관심있는 주제를 선택하여 이야기를 나눌 수 있는 커뮤니티입니다.  
Google Trends 데이터를 이용해 실시간 정보를 불러오며 사용자가 원하는 주제를 직접 등록하여 의견을 공유할 수도 있습니다.  
의견이 일정 갯수 이상 등록이 되면 성별, 나이, 지역에 대한 통계가 출력됩니다.  

<기능 나열>  
오늘의 인기 검색어를 확인하고, 관심있는 주제를 선택하여 댓글로 이야기를 나눌 수 있는 스레드 커뮤니티입니다.  
Google Trends 데이터를 이용해 가져온 실시간 목록 또는 사용자가 원하는 주제에 대해 의견을 나눌 수 있습니다.  
자유 주제의 카테고리별로 성별, 나이, 지역에 대한 통계가 출력됩니다.  

<위에걸 초심플하게 정리만한거>  
Google Trends 데이터를 이용해 가져온 실시간 오늘의 인기 검색어를 확인하고, 관심있는 주제를 선택하여 이야기를 나눌 수 있는 댓글 커뮤니티입니다.  
사용자가 원하는 주제를 직접 등록해 의견을 나눌 수도 있으며, 각 주제의 큰 카테고리로 참여자들의 성별, 연령대, 지역별 통계가 집계됩니다.  

<플랫폼 설명식>  
최근의 트랜드, 혹은 다른 사람들과 나눠보고 싶었던 이야기들을 스레드 형식으로 자유롭게 나누는 커뮤니티 TrenD 입니다.  
실시간으로 제공되는 오늘의 트랜드를 확인하고, 당신의 의견을 남겨주세요.  
같은 카테고리에 대해 관심을 가진 사람들의 성별, 연령대, 지역의 통계를 확인해보세요.  

<개발목적 설명식>  
본 프로젝트는 실시간 트랜드에 관심 있는 사용자들을 위한 댓글형 스레드 커뮤니티로 자유롭게 의견을 나눌 수 있는 새로운 소셜 경험을 제공하고자 합니다.  
Google Trends를 활용하여 오늘의 실시간 트랜드와 그와 관련된 뉴스링크를 제공하며, 댓글로 커뮤니티에 참여하는 사용자들의 성별 및 연령대, 지역별 통계를 통해 어떤 사용자들이 주로 관심을 갖는지 파악할 수 있습니다.  

## 프로젝트 구조도
## DB 설계
![TrenD-Database](https://github.com/JunHyeokSeo/trenD/assets/55777781/d6d4da99-90f7-4e04-88e0-f8dcd3d51233)

## 주요기능 설명
| 기능 | 담당자 | 상세설명 |
| --- | --- | --- |
| 실시간 검색어 크롤링 | 함혜선 | -Rest API 형태로 Serp api를 사용하여 Google Trends 페이지 크롤링 </br> -openAI Api 연결하여 챗봇 구현(답변 내용을 반응형 stream 구현/server side event 기술 사용  |
| OAuth2.0 기반 소셜로그인 | 백대현 |  |
| 마이페이지 | 정소옥 |  |
| 목록 페이지 및 게시판 내부 검색 | 여인범 | REST API형태로 게시판별 데이터 목록 및 조건에 해당하는 데이터 조회 구현</br>JPA Repository에서 제공하는 Page Interface를 활용한 게시판 목록 페이징 구현 |
| 게시글 CRUD 및 통합 검색 | 김선홍 | Google Trends 리스트 조회 시 글 자동 등록</br>RestAPI 적용하여 검색결과를 한 페이지 내에서 트렌드/커뮤니티 개별 페이징 구현 |
| 통계 페이지 | 빈상욱 |  |
| 댓글 CRUD | 서준혁 | REST API 형태로 댓글 CRUD 구현</br>댓글 목록 페이징 구현|

## 담당작업
