use day3;
/**************************************************************
                        一.多表查询
  1.概述:从多张表中查询数据

  2.语法
        select 字段列表 from 表名列表 where... ;

  3.笛卡尔积(多表查询的所有组合情况)

  4.查询分类
    (1)内连接查询
        (a)隐式内连接: where语句
        (b)显示内连接: select 字段列表 from 表名1 inner join 表名2 on 条件
    (2)外连接查询(两者无实质区别)
        (a)左外连接(查询左表所有数据,以及两表交集):
            select 字段列表 from 表1 left join 表2 on 条件
        (b)右外连接(查询右表所有数据,以及两表交集):
            select 字段列表 from 表1 right join 表2 on 条件
    (3)子查询(查询里面嵌套查询)
        (a)子查询结果:单行单列
            *子查询可以作为条件,用运算符判断(<,>,=等)
        (b)子查询结果:多行单列
            *语法: in (多行单列查询结果)
        (c)子查询结果:多行多列
            *子查询作为虚拟表

**************************************************************/

# 建表
create table dept
(
    id   int primary key auto_increment,
    name varchar(10)
);
insert into dept (name)
values ('研发部'),
       ('销售部'),
       ('市场部');
create table emp
(
    id        int primary key auto_increment,
    name      varchar(10),
    gender    char(1),
    salary    double,
    join_date date,
    dept_id   int,
    constraint emp_dept_fk foreign key (dept_id) references dept (id)
);
insert into emp
values (null, '小王', '男', 3500, '2017-02-20', 1);
insert into emp
values (null, '小唐', '男', 4000, '2015-05-15', 1);
insert into emp
values (null, '小张', '女', 3200, '2018-05-20', 2);
insert into emp
values (null, '小李', '女', 4000, '2017-11-05', 3);
insert into emp
values (null, '小徐', '男', 3700, '2017-07-22', 2);

# 3.笛卡尔积(多表的所有组合情况)
select *
from emp,
     dept;


/*************************************************************
                        # 4.1 内连接查询
**************************************************************/
# 4.1.a 隐式内连接
# 查询所有员工及其部门的信息
select *
from emp,
     dept
where emp.dept_id = dept.id;
# 查询所有员工的name,gender;部门的name
select t1.name, t1.gender, t2.name
from emp as t1,
     dept as t2
where t1.dept_id = t2.id;

# 4.1.b 显示内连接
# 查询所有员工的name,gender;部门的name(这种方法空数据不会显示)
select t1.*, t2.name
from emp as t1
         inner join dept as t2
                    on t1.dept_id = t2.id;


/*************************************************************
                        # 4.2 外连接查询
**************************************************************/
# 4.2.a 左外连接
# 查询员工所有信息,如果员工有部门,则查询部门1;没有部门则不显示
select t1.*, t2.name
from emp as t1
         left join dept as t2
                   on t1.dept_id = t2.id;
# 4.2.b 右外连接
# 查询员工所有信息,如果员工有部门,则查询部门1;没有部门则不显示
select t1.*, t2.name
from emp as t2
         left join dept as t1
                   on t1.id = t2.dept_id;


/*************************************************************
                        # 4.3子查询
**************************************************************/
# 4.3.a 查询工资最高的员工的信息
select *
from emp
where emp.salary =
      (select max(salary) from emp);
# 4.3.b 所有财务部+研发部员工信息
select *
from emp
where dept_id in (
    select dept.id
    from dept
    where name = '研发部' or name = '销售部');
# 4.3.c 查询入职日期是2017-01-01的员工+部门信息
select *
from dept t1,
     (select * from emp where join_date > '2017-01-01') t2
where t1.id = t2.dept_id;
# 也可用内连接:
select t1.*, t2.*
from emp t1,
     dept t2
where t1.dept_id = t2.id
  and t1.join_date > '2017-01-01';