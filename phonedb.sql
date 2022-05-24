/********** ����Ŭ �����ͺ��̽� *******************/




/*  1. �������� ( ������ : phonedb / �н����� : phonedb ) 
    ? ����� ����: CREATE phonedb user IDENTIFIED BY phonedb;
    ? ��й�ȣ ����: ALTER phonedb user IDENTIFIED BY phonedb;
    ���������Ʈ�� SQL> grant connect, resource to phonedb;
    
    2. ��ũ��Ʈ �ۼ� 
       ��. ���̺� ���� �� ���� */ 
        create table person (
        person_id     number(5),
        name   varchar2(30) not null,
        hp   varchar2(20),
        company varchar2(20),
        primary key (person_id)
        ); 
        
        select * from person;--���̺� ����Ȯ�� 
        
        drop table person;
        
    /* ��. ������ ���� �� ���� */
        create sequence seq_person_id
        increment by 1 
        start with 1 
        nocache;
        
        drop sequence seq_person_id;
    
/*  3. ��. insert / select ��
        */ 
       
        insert into person
        values (seq_person_id.nextval, '��ȿ��','010-1111-1111','02-1111-1111');
        
        insert into person
        values (seq_person_id.nextval, '���켺','010-2222-2222','02-2222-2222');
    
        insert into person
        values (seq_person_id.nextval, '���缮','010-3333-3333','02-3333-3333');
        
        insert into person
        values (seq_person_id.nextval, '������','010-4444-4444','02-4444-4444');
        
        insert into person
        values (seq_person_id.nextval, '������','010-5555-5555','02-5555-5555');
        
        select * from person;
      
       -- ��. update / delete ��
       update person
       set HP = '010-9999-9999',
           COMPANY = '02-9999-9999'
       where person_id = 4;
       
       delete from person
       where person_id = 5;
       
       
       