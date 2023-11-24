/*************************************************************************
                                  分页查询

  * rownum: 查询时, 对每条记录加上行号, 从1开始递增, 不能跳着走
**************************************************************************/

--查询工资前三
select rownum, t1.ENAME, t1.SAL
from (select rownum, e.*
      from EMP e
      order by e.SAL desc) t1
where rownum < 4;


--1.分页[有排序] (固定格式)
select *
from (select rownum rownum0, t1.*
      from (select *
            from emp
            order by sal desc) t1
      where rownum <= 10)
where rownum0 >= 1;

--2.分页[无排序]
select *
from (select rownum as rownum0, e.*
      from emp e
      where rownum <= 20) t1
where t1.rownum0 >= 11;


