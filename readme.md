1.data파싱한 후 db에 insert, mybatis sql mapper사용
-mysql-connector 의존성 추가
-db생성 및 테이블 생성(sql파일 생성)   
-application.properties에 mysql연결을 위한 spring.datasurce 설정
-mybatis 의존성 추가   
-mapper 작성, 인터페이스 추가, spring이 mapper를 찾을 수 있게 mapperscan설정
2.db에서 데이터 조회 > 데이터 처리 > 페이지 응답   