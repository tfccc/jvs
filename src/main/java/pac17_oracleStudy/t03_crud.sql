/*************************************************************************
                               һ.��ɾ�Ĳ�
**************************************************************************/
------1.���
insert into person (pid, name, sex)
values (1, '�Ʒ��', 1);
/* ���ֶ��ύ */
commit;

------2.�޸�
update PERSON
set name = 'tfc'
where PID = 1;

------3.ɾ��
delete from PERSON where PID = 3;
delete from PERSON;    -->ɾ������������
drop table PERSON;     -->ɾ����
truncate table PERSON; -->ɾ����, ���ٴ�����