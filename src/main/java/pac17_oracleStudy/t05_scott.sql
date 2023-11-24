/*************************************************************************
                             一.scott练习
  1.单行函数
  2.多行函数
  3.条件表达式
**************************************************************************/
/*
 单行函数: 作用于单行, 返回一个值
*/
--1.字符函数
select upper('upper')
from dual;
select lower('LOWER')
from dual;

--2.数值函数
select round(26.94, 1)
from dual;
select trunc(26.9, 3)
from dual;

--3.日期函数
----3.1查询入职距今天数
select sysdate - e.HIREDATE
from emp e;
----查询当前系统时间
select sysdate
from dual;
----3.2查询入职距今月数
select months_between(sysdate, e.HIREDATE) / 12
from emp e;
----3.3自定义格式
select to_char(sysdate, 'yyyy-mm_dd hh24:mi:ss')
from DUAL;
----3.4字符转date类型
select to_date('2020-10-10 16:30:00', 'yyyy-mm-dd hh24:mi:ss') as d
from DUAL;
----3.5计算年终工资 (if null)
select e.SAL * 12 + nvl(e.COMM, 0)
from EMP e;


/*
 多行函数: 作用于多行, 返回一个值
    1.count()
    2.max()
    3.min()
    4.sum()
    5.avg()
*/
--1.总数量
select count(1)
from EMP;



/*
 条件表达式
*/
--给员工起中文名
select e.ENAME,
    /* 等值型 */
       case e.ENAME
           when 'SMITH' then '史密斯'
           when 'ALLEN' then '艾伦'
           else '其他人'
           end as chineseName
from EMP e;

--判断工资, >3000高收入, 1500~3000中收入, <1500低收入
select e.SAL,
    /* 范围型 */
       case
           when e.SAL >= 3000 then '高收入'
           when e.SAL >= 1500 then '中收入'
           else '低收入'
           end as sal_type
from EMP e
order by SAL;