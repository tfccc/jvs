/*************************************************************************
                                子查询
  1.返回一个值
  2.返回一列值
  3.返回一张表 (临时表/虚拟表)
  * '='需保证主键 (唯一非空字段)
**************************************************************************/

--1.返回一个值
select *
from EMP e2
where e2.SAL = (select e1.SAL
                from EMP e1
                where e1.EMPNO = 7788);

--2.返回一列值
select *
from EMP e2
where e2.SAL in (
    select e1.SAL
    from EMP e1
    where e1.DEPTNO = 10
);


--3.返回一张表(临时表/虚拟表)
select *
from (select *
      from EMP
      where ENAME = ''),
     (select d1.DNAME
      from DEPT d1
      where d1.DEPTNO = 10) t1
where ?;