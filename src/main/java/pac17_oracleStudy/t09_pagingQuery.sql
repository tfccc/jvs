/*************************************************************************
                                  ��ҳ��ѯ

  * rownum: ��ѯʱ, ��ÿ����¼�����к�, ��1��ʼ����, ����������
**************************************************************************/

--��ѯ����ǰ��
select rownum, t1.ENAME, t1.SAL
from (select rownum, e.*
      from EMP e
      order by e.SAL desc) t1
where rownum < 4;


--1.��ҳ[������] (�̶���ʽ)
select *
from (select rownum rownum0, t1.*
      from (select *
            from emp
            order by sal desc) t1
      where rownum <= 10)
where rownum0 >= 1;

--2.��ҳ[������]
select *
from (select rownum as rownum0, e.*
      from emp e
      where rownum <= 20) t1
where t1.rownum0 >= 11;


