/*************************************************************************
                                   ����

  * ����: ��ṹ�Ͻ���������, ��߲�ѯЧ��, ������ɾ��Ч��

  1.��������
      * ��������: ��������Ϊ�������е�ԭʼֵ
  2.��������
      * ��������: ����������������е�ԭʼֵ
**************************************************************************/

---------------1.������������
create index index_ename on SCOTT.EMP (ENAME);
/* ���� */
select *
from SCOTT.EMP
where ENAME = 'SCOTT';
/* ������ */
select *
from SCOTT.EMP
where SAL = 3000;


---------------2.������������
create index index_ename_job on SCOTT.EMP (ENAME, JOB);
/* ���� */
select *
from SCOTT.EMP
where ENAME = 'SCOTT' and JOB = 'ANALYST';

/* ������ */
select *
from SCOTT.EMP
where ENAME = 'SCOTT' OR JOB = 'ANALYST';