# bookProject
오픈 API 를 이용하여 “책 검색 서비스”를 구현

기본요구사항
2.1 회원가입/로그인
	사용자는 회원가입을 통해 아이디와 비번을 등록합니다.
	회원가입 후 사용자의 아이디와 비번으로 로그인을 할 수 있어야 합니다.
	비밀번호는 암호화해서 저장해 주세요.
2.2 책검색
	키워드를 통해 책을 검색할 수 있어야 합니다.
	검색 결과는 Pagination 형태로 제공해 주세요.
	검색소스는카카오API의책검색을활용합니다. https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-book
2.3 검색된 책의 상세 조회
	검색된 결과에서 원하는 책을 선택하여 상세 정보를 확인할 수 있어야 합니다.
	상세 정보에는 제목, 도서 썸네일, 소개, ISBN, 저자, 출판사, 출판일, 정가, 판매가가
	포함되어야 합니다.
2.4 내 검색 히스토리
	나의 검색 히스토리(키워드, 검색 일시)를 최신 순으로 보여 주세요. 2.5 인기 키워드 목록
	사용자들이 많이 검색한 순서대로, 최대 10 개의 검색 키워드를 제공합니다.
	키워드 별로 검색된 횟수도 함께 표기해 주세요.
	
	
- 주사용 기술 : Java, Java Script, JQuery, HTML5, CSS, spring-boot, H in-memory db(H2), 
lombok, Spring Security, jstl

- 오픈소스 : 
1. spring-boot-starter-security
	Spring 기반 어플리케이션 인증 보안 기능 제공
2. spring-boot-starter-data-jpa
	Spring에서 JPA를 추상화 하여 사용할수 있도록 제공하는 모듈
	추상화된 Repository 인터페이스 기반으로 사용한다.
3. lombok
	어노테이션 기반로 Class에 반복적인 기능을 깔끔하고 쉽게 도와주는 Library
	Getter, Setter, Construct, Builder 등을 어노테이션으로 쉽게 구현할수 있음
	컴파일 시점에 AnnotationProcessor를 이용하여 실제 코드를 생성한다.
	사용 개발 툴에서 별도의 플러그인을 설치해야함.
