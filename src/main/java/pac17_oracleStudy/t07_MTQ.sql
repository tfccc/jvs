/*************************************************************************
                               ����ѯ
  ������, ������, ������
**************************************************************************/

------------------------------------1.������
----1.1��ʽ������(��ֵ����)
select e.EMPNO, e.ENAME, d.DEPTNO
from EMP e,
     DEPT d
where e.DEPTNO = d.DEPTNO
order by d.DEPTNO;

----1.2��ʾ������
select e.EMPNO, e.ENAME, d.DEPTNO
from EMP e
         inner join
     DEPT d
     on e.DEPTNO = d.DEPTNO
order by d.DEPTNO;


------------------------------------2.������: ��ѯ����Ա�����䲿��
select *
from emp e
         left join DEPT D
                   on e.DEPTNO = D.DEPTNO;


------------------------------------3.������(һ�ű��ɶ��ű�)
----3.1��ѯԱ������, ���������쵼
select emp.ename as emp_name,
       emp.EMPNO as emp_id,
       ''           describe,
       mgr.ename as mgr_name,
       mgr.EMPNO as mgr_id
from EMP emp,
     EMP mgr
where emp.mgr = mgr.empno(+);

----3.2��ѯԱ������, Ա������, Ա���쵼, Ա���쵼����
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

----3.3��ѯԱ������, Ա������, Ա�����ʵȼ�, Ա���쵼, Ա���쵼����, Ա���쵼���ʵȼ�
select emp.ename         as emp_name,
       dept_emp.DEPTNO   as dept_emp_id,
       case
           when emp.SAL >= 3000 then '�ļ�'
           when emp.SAL >= 2000 then '����'
           when emp.SAL >= 1000 then '����'
           else 'һ��' end as emp_sal_level,
       mgr.ename         as mgr_name,
       dept_mgr.DEPTNO   as dept_mgr_id,
       case
           when mgr.SAL >= 3000 then '�ļ�'
           when mgr.SAL >= 2000 then '����'
           when mgr.SAL >= 1000 then '����'
           else 'һ��' end as mgr_sal_level
from EMP emp,
     EMP mgr,
     DEPT dept_emp,
     DEPT dept_mgr
where emp.mgr = mgr.empno(+)
  and emp.DEPTNO = dept_emp.DEPTNO(+)
  and mgr.DEPTNO = dept_mgr.DEPTNO(+)
order by emp.SAL;
