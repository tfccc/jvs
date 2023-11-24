/*************************************************************************
                               一.增删改查
**************************************************************************/
------1.添加
insert into person (pid, name, sex)
values (1, '唐封成', 1);
/* 需手动提交 */
commit;

------2.修改
update PERSON
set name = 'tfc'
where PID = 1;

------3.删除
delete from PERSON where PID = 3;
delete from PERSON;    -->删除表所有数据
drop table PERSON;     -->删除表
truncate table PERSON; -->删除表, 后再创建表