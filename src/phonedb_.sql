/********** 오라클 데이터베이스 *******************/




/*  1. 계정생성 ( 계정명 : phonedb / 패스워드 : phonedb ) 
    • 사용자 생성: CREATE phonedb user IDENTIFIED BY phonedb;
    • 비밀번호 변경: ALTER phonedb user IDENTIFIED BY phonedb;
    명령프롬프트에 SQL> grant connect, resource to phonedb;
    
    2. 스크립트 작성 
       ㄱ. 테이블 생성 및 삭제 */ 
        create table person (
						        person_id     number(5),
						        name   varchar2(30) not null,
						        hp   varchar2(20),
						        company varchar2(20),
						        primary key (person_id)
						        ); 
						        
        select * from person;--테이블 생성확인 
        
        drop table person;
        
    /* ㄴ. 시퀀스 생성 및 삭제 */
        create sequence seq_person_id
        increment by 1 
        start with 1 
        nocache;
        
        drop sequence seq_person_id;
    
/*  3. ㄱ. insert / select 문
        */ 
       
        insert into person
        values (seq_person_id.nextval, '이효리','010-1111-1111','02-1111-1111');
        
        insert into person
        values (seq_person_id.nextval, '정우성','010-2222-2222','02-2222-2222');
    
        insert into person
        values (seq_person_id.nextval, '유재석','010-3333-3333','02-3333-3333');
        
        insert into person
        values (seq_person_id.nextval, '이정재','010-4444-4444','02-4444-4444');
        
        insert into person
        values (seq_person_id.nextval, '서장훈','010-5555-5555','02-5555-5555');
        
        select * from person;
      
       -- ㄴ. update / delete 문
       update person
       set HP = '010-9999-9999',
           COMPANY = '02-9999-9999'
       where person_id = 4;
       
       delete from person
       where person_id = 5;
       
       
       