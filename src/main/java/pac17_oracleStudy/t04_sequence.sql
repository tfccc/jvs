/*************************************************************************
                               һ.����
  * ���в������κ�һ�ű�, �����������
**************************************************************************/
------1.��������
create sequence s_person;
--�����﷨
create sequence s_person
    start with 3
    increment by 1
    maxvalue 999;


------2.��ѯ�û�������
select *
from dba_sequences
where sequence_owner = 'TFC0';

--�������� (dualΪ�˲�ȫ�﷨)
select s_person.nextval
from dual;

--��ѯ��ǰ����
select s_person.currval
from dual;


------3.ʵ��Ӧ��
insert into PERSON (PID, NAME, SEX)
values (s_person.nextval, 'tfc4', 8);
commit;
