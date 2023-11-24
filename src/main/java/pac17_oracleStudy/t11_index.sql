/*************************************************************************
                                   索引

  * 概念: 表结构上建立二叉树, 提高查询效率, 降低增删改效率

  1.单列索引
      * 触发规则: 条件必须为该索引列的原始值
  2.复合索引
      * 触发规则: 条件必须包含检索列的原始值
**************************************************************************/

---------------1.创建索单列引
create index index_ename on SCOTT.EMP (ENAME);
/* 触发 */
select *
from SCOTT.EMP
where ENAME = 'SCOTT';
/* 不触发 */
select *
from SCOTT.EMP
where SAL = 3000;


---------------2.创建索复合引
create index index_ename_job on SCOTT.EMP (ENAME, JOB);
/* 触发 */
select *
from SCOTT.EMP
where ENAME = 'SCOTT' and JOB = 'ANALYST';

/* 不触发 */
select *
from SCOTT.EMP
where ENAME = 'SCOTT' OR JOB = 'ANALYST';