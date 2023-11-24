/*************************************************************************
                               分组查询

 * where在分组前过滤, having在分组后过滤
**************************************************************************/
--1.查询各部门平均工资
select e.deptno, avg(e.sal) avg_sal
from emp e
group by e.deptno;


--2.查询平均工资高于2000的部门
select e.deptno, avg(e.sal) avg_sal
from emp e
group by e.deptno
/* 别名不做条件 */
having avg(e.sal) >= 2000;


--3.每个部门~工资高于1500的员工~的平均工资
select e.deptno, avg(e.sal) avg_sal
from emp e
where e.sal >= 1500
group by e.deptno;

--4.每个部门~工资高于1500的员工~的平均工资, 其中工资大于2500的部门
select e.deptno, round(avg(e.sal), 2) avg_sal
from emp e
where e.sal >= 1500
group by e.deptno
having avg(e.sal)  > 2500
order by deptno;