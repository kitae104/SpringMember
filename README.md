### 회원등록 주요 기능 
1. 회원 가입 
   - 테이블 생성
   - 회원 테이블
   -  drop table if exists member_table;
   - create table member_table(
     id bigint primary key auto_increment,
     memberEmail varchar(20) unique,
     memberPassword varchar(20),
     memberName varchar(20),
     memberAge int,
     memberMobile varchar(30)
     );    
    - mybatis-config.xml 
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

2. 로그인 
3. 회원목록 출력 
4. 상세조회
5. 수정
6. 삭제
7. ajax를 이용한 이메일 중복체크 