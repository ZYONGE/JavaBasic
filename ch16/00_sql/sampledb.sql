
CREATE USER sampledb NO AUTHENTICATION
    DEFAULT TABLESPACE users
    QUOTA UNLIMITED ON users;

ALTER SESSION SET CURRENT_SCHEMA = sampledb;

CREATE TABLE student (
    name VARCHAR2(10 CHAR) NOT NULL,
    dept VARCHAR2(20 CHAR) NOT NULL,
    id   CHAR(7)           PRIMARY KEY
);

insert into student (name, dept, id) values ('김철수', '컴퓨터시스템', '1091011');
insert into student (name, dept, id) values ('최고봉', '멀티미디어', '0792012');
insert into student (name, dept, id) values ('이기자', '컴퓨터공학', '0494013');
COMMIT;

select name, dept, id from student where dept='컴퓨터공학';
select * from student where dept='컴퓨터공학';

update student set dept='컴퓨터공학' where name='최고봉';
COMMIT;
select * from student;

delete from student where name='최고봉';
COMMIT;
select * from student;
