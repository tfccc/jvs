/*************************************************************************
                                �Ӳ�ѯ
  1.����һ��ֵ
  2.����һ��ֵ
  3.����һ�ű� (��ʱ��/�����)
  * '='�豣֤���� (Ψһ�ǿ��ֶ�)
**************************************************************************/

--1.����һ��ֵ
select *
from EMP e2
where e2.SAL = (select e1.SAL
                from EMP e1
                where e1.EMPNO = 7788);

--2.����һ��ֵ
select *
from EMP e2
where e2.SAL in (
    select e1.SAL
    from EMP e1
    where e1.DEPTNO = 10
);


--3.����һ�ű�(��ʱ��/�����)
select *
from (select *
      from EMP
      where ENAME = ''),
     (select d1.DNAME
      from DEPT d1
      where d1.DEPTNO = 10) t1
where ?;