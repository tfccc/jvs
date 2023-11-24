/*************************************************************************
                               一.序列
  * 序列不属于任何一张表, 但可以做表绑定
**************************************************************************/
------1.创建序列
create sequence s_person;
--其它语法
create sequence s_person
    start with 3
    increment by 1
    maxvalue 999;


------2.查询用户的序列
select *
from dba_sequences
where sequence_owner = 'TFC0';

--递增序列 (dual为了补全语法)
select s_person.nextval
from dual;

--查询当前序列
select s_person.currval
from dual;


------3.实际应用
insert into PERSON (PID, NAME, SEX)
values (s_person.nextval, 'tfc4', 8);
commit;
