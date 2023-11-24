/*************************************************************************
                             一.创建/修改表
**************************************************************************/
------1.创建表 (varchar定长, varchar2可变长)
create table person (
    pid number(20),
    name varchar2(10)
);

--添加列
alter table person add (gender number(1), age number(3));
--改类型
alter table person modify gender int;
--改名称
alter table person rename column gender to sex;
--删除列
alter table person drop column age;



/*************************************************************************
                               一.查询表
**************************************************************************/
------1.tfc0的所有表
select * from all_tables where owner='TFC0';

--查询表
select * from person;