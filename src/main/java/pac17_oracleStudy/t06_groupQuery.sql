/*************************************************************************
                               �����ѯ

 * where�ڷ���ǰ����, having�ڷ�������
**************************************************************************/
--1.��ѯ������ƽ������
select e.deptno, avg(e.sal) avg_sal
from emp e
group by e.deptno;


--2.��ѯƽ�����ʸ���2000�Ĳ���
select e.deptno, avg(e.sal) avg_sal
from emp e
group by e.deptno
/* ������������ */
having avg(e.sal) >= 2000;


--3.ÿ������~���ʸ���1500��Ա��~��ƽ������
select e.deptno, avg(e.sal) avg_sal
from emp e
where e.sal >= 1500
group by e.deptno;

--4.ÿ������~���ʸ���1500��Ա��~��ƽ������, ���й��ʴ���2500�Ĳ���
select e.deptno, round(avg(e.sal), 2) avg_sal
from emp e
where e.sal >= 1500
group by e.deptno
having avg(e.sal)  > 2500
order by deptno;