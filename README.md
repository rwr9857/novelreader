# NovelReader

## 프로젝트 개요

### ✅ **프로젝트 소개**  
**NovelReader**는 웹소설, 라이트노벨, 클래식 문학 등을 편리하게 읽을 수 있는 **소설 웹뷰어 서비스 플랫폼**입니다.  
독자들이 원하는 소설을 쉽게 찾아 읽고, 작가들은 더 나은 환경에서 창작할 수 있도록 지원하는 다양한 기능을 제공합니다.

### ✅ **프로젝트 필요성(배경)**  
웹소설과 전자책 시장의 급성장에 따라 많은 소설 웹뷰어 서비스가 등장했습니다.  
하지만 아직까지 **작가와 독자**가 원하는 **기능에 쉽게 접근**할 수 있는 유저 친화적인 서비스는 부족한 상황입니다.  
**NovelReader**는 이러한 시장의 요구를 충족시킬 수 있는 **직관적이고 효율적인 플랫폼**을 제공합니다.

### ✅ **프로젝트 목표**  
- **다양한 소설 콘텐츠**를 한 곳에서 **편리하게** 읽을 수 있는 통합 뷰어 제공  
- **직관적인 디자인**으로 원하는 기능에 쉽게 접근할 수 있는 **페이지 이동** 설계  
- **독자와 작가**가 원하는 맞춤형 기능을 **쉽고 빠르게 사용할 수 있도록** 최적화된 인터페이스 제공


## 팀 소개

|  |  |  |  |  |
|--|--|--|--|--|
| <img src="https://avatars.githubusercontent.com/u/74402423?v=4" width="120"/><br/>**김준기**<br/>[@rwr9857](https://github.com/rwr9857)<br/><br/>**팀장** | <img src="https://avatars.githubusercontent.com/u/77829975?v=4" width="120"/><br/>**강민수**<br/>[@Dongmool](https://github.com/Dongmool)<br/><br/>**백엔드 개발**| <img src="https://avatars.githubusercontent.com/u/67631164?v=4" width="120"/><br/>**류익현**<br/>[@ikcon97](https://github.com/ikcon97)<br/><br/>**백엔드 개발**| <img src="https://avatars.githubusercontent.com/u/96859074?v=4" width="120"/><br/>**박승은**<br/>[@noqo23](https://github.com/noqo23)<br/><br/>**프론트엔드 개발**| <img src="https://avatars.githubusercontent.com/u/96814509?v=4" width="120"/><br/>**안태균**<br/>[@taekyun01](https://github.com/taekyun01)<br/><br/>**프론트엔드 개발**|


## 기술 스택

| 구분  | 사용 기술   |
|------|-----------|
| **프론트엔드** | ![jQuery](https://img.shields.io/badge/jQuery-%230769AD?style=for-the-badge&logo=jquery&logoColor=white) ![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white) |
| **백엔드** | ![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![MyBatis](https://img.shields.io/badge/MyBatis-DB0000?style=for-the-badge&logoColor=white) |
| **데이터베이스** | ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)|
| **형상관리** | ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)|
| **개발 도구** | ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white) ![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white) |

## 주요 기능

- ✅ 간편한 SNS 로그인 시스템
- ✅ 회원끼리 팔로우 가능한 시스템
- ✅ 회원 프로필 관리 시스템
- ✅ 관리자와 소통할 수 있는 문의게시판
- ✅ 작가의 연재 관리를 위한 글등록 시스템
- ✅ 짧은 회차 기반의 소설 뷰어 기능
- ✅ 회차마다 독자가 리뷰을 남길 수 있는 기능

## ERD (Entity Relationship Diagram)

```mermaid
erDiagram

MEMBER {
  NUMBER(8) M_NUM PK
  VARCHAR2(40) M_ID
  VARCHAR2(20) M_PW
  VARCHAR2(40) M_EMAIL
  NUMBER(1) M_EMAIL_AGREE
  VARCHAR2(20) M_NICKNAME
  VARCHAR2(10) M_SEX
  VARCHAR2(100) M_HOMEPAGE_ADDRESS
  VARCHAR2(20) M_CITY
  DATE M_REGISTER_DATE
  VARCHAR2(10) M_PERMISSION
  VARCHAR2(500) M_PHOTO_NAME
  VARCHAR2(1000) M_PHOTO_PATH
  LONG M_PHOTO_SIZE
  VARCHAR2(200) M_INFO
  DATE M_BIRTHDAY
  NUMBER(1) M_HOMEPAGE_PUBLIC
  NUMBER(1) M_SEX_PUBLIC
  NUMBER(1) M_CITY_PUBLIC
  NUMBER(1) M_BIRTHDAY_PUBLIC
  NUMBER(1) M_INFO_PUBLIC
  VARCHAR2(20) M_PLATFORM
  VARCHAR2(500) M_SNS_ID
}

NOVEL_HOME {
  NUMBER(8) N_NUM PK
  VARCHAR2(4000) N_TITLE
  VARCHAR2(1000) N_SUMMARY
  VARCHAR2(500) N_IMAGE_NAME
  VARCHAR2(1000) N_IMAGE_PATH
  LONG N_IMAGE_SIZE
  DATE N_PUB_DATE
  NUMBER(2) N_REPORT
  NUMBER(8) M_NUM FK
}

NOVEL_POST {
  NUMBER(8) N_POST_NUM PK
  NUMBER(8) N_NUM FK
  VARCHAR2(50) N_POST_TITLE
  VARCHAR2(4000) N_POST_CONTENT
  NUMBER(8) N_POST_LIKE
  NUMBER(8) N_POST_DISLIKE
  NUMBER(8) N_POST_VIEWCOUNT
  DATE N_POST_TIME
}

COMMENT {
  NUMBER(10) COMMENT_NUM PK
  NUMBER(8) M_NUM FK
  VARCHAR(1000) COMMENT_CONTENT
  DATE COMMENT_TIME
  NUMBER(8) N_POST_NUM FK
}

FOLLOW {
  NUMBER(8) M_NUM FK
  NUMBER(8) FOLLOWING FK
  DATE FOLLOWING_TIME
}

QUESTION {
  NUMBER(8) Q_NUM PK
  NUMBER(8) M_NUM FK
  VARCHAR(100) Q_TITLE
  VARCHAR(1000) Q_CONTENT
  NUMBER(8) Q_VIEWCOUNT
  DATE Q_TIME
  VARCHAR(50) Q_CATEGORY
}

QUESTION_REPLY {
  NUMBER(8) QR_NUM PK
  NUMBER(8) M_NUM FK
  VARCHAR(100) QR_TITLE
  VARCHAR(1000) QR_CONTENT
  DATE QR_TIME
}

NOTICE {
  NUMBER(8) NOT_NUM PK
  NUMBER(8) M_NUM FK
  VARCHAR(100) NOT_TITLE
  VARCHAR(1000) NOT_CONTENT
  NUMBER(8) NOT_VIEWCOUNT
  DATE NOT_TIME
}

FAQ {
  NUMBER(8) FAQ_NUM PK
  NUMBER(8) M_NUM FK
  VARCHAR(100) FAQ_TITLE
  VARCHAR(1000) FAQ_CONTENT
  NUMBER(8) FAQ_VIEWCOUNT
  DATE FAQ_TIME
}

CATEGORY {
  NUMBER(8) C_CATEGORY_ID PK
  VARCHAR(50) C_CATEGORY_NAME
}

NOVEL_CATEGORY {
  NUMBER(8) C_CATEGORY_ID FK
  NUMBER(8) N_NUM FK
}

MEMBER ||--o{ NOVEL_HOME : "has"
MEMBER ||--o{ FOLLOW : "follows"
MEMBER ||--o{ QUESTION : "asks"
MEMBER ||--o{ QUESTION_REPLY : "replies"
MEMBER ||--o{ COMMENT : "writes"
MEMBER ||--o{ NOTICE : "posts"
MEMBER ||--o{ FAQ : "adds"
NOVEL_HOME ||--o{ NOVEL_POST : "contains"
NOVEL_POST ||--o{ COMMENT : "has"
NOVEL_HOME ||--o{ NOVEL_CATEGORY : "tagged"
CATEGORY ||--o{ NOVEL_CATEGORY : "categorized"
```

## 클래스 다이어그램

![ClassDiagram](https://github.com/Vulpes94/novelreader/assets/74402423/a63267aa-5937-4f45-bc60-4c63d1ea7c03)

## 화면 디자인

<img width="1470" alt="화면디자인" src="https://github.com/user-attachments/assets/22d83d21-d0b9-4047-b3b9-d24b00e73dc2" />





