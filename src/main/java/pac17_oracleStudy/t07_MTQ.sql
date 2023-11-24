/*************************************************************************
                               多表查询
  内连接, 外连接, 自连接
**************************************************************************/

------------------------------------1.内连接
----1.1隐式内连接(等值连接)
select e.EMPNO, e.ENAME, d.DEPTNO
from EMP e,
     DEPT d
where e.DEPTNO = d.DEPTNO
order by d.DEPTNO;

----1.2显示内连接
select e.EMPNO, e.ENAME, d.DEPTNO
from EMP e
         inner join
     DEPT d
     on e.DEPTNO = d.DEPTNO
order by d.DEPTNO;


------------------------------------2.外连接: 查询所有员工及其部门
select *
from emp e
         left join DEPT D
                   on e.DEPTNO = D.DEPTNO;


------------------------------------3.自连接(一张表看成多张表)
----3.1查询员工姓名, 及其所属领导
select emp.ename as emp_name,
       emp.EMPNO as emp_id,
       ''           describe,
       mgr.ename as mgr_name,
       mgr.EMPNO as mgr_id
from EMP emp,
     EMP mgr
where emp.mgr = mgr.empno(+);

----3.2查询员工姓名, 员工部门, 员工领导, 员工领导部门
select emp.ename       as emp_name,
       dept_emp.DEPTNO as dept_emp_id,
       mgr.ename       as mgr_name,
       dept_mgr.DEPTNO as dept_mgr_id
from EMP emp,
     EMP mgr,
     DEPT dept_emp,
     DEPT dept_mgr
where emp.mgr = mgr.empno(+)
  and emp.DEPTNO = dept_emp.DEPTNO(+)
  and mgr.DEPTNO = dept_mgr.DEPTNO(+);

----3.3查询员工姓名, 员工部门, 员工工资等级, 员工领导, 员工领导部门, 员工领导工资等级
select emp.ename         as emp_name,
       dept_emp.DEPTNO   as dept_emp_id,
       case
           when emp.SAL >= 3000 then '四级'
           when emp.SAL >= 2000 then '三级'
           when emp.SAL >= 1000 then '二级'
           else '一级' end as emp_sal_level,
       mgr.ename         as mgr_name,
       dept_mgr.DEPTNO   as dept_mgr_id,
       case
           when mgr.SAL >= 3000 then '四级'
           when mgr.SAL >= 2000 then '三级'
           when mgr.SAL >= 1000 then '二级'
           else '一级' end as mgr_sal_level
from EMP emp,
     EMP mgr,
     DEPT dept_emp,
     DEPT dept_mgr
where emp.mgr = mgr.empno(+)
  and emp.DEPTNO = dept_emp.DEPTNO(+)
  and mgr.DEPTNO = dept_mgr.DEPTNO(+)
order by emp.SAL;
