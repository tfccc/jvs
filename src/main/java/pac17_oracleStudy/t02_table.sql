/*************************************************************************
                             һ.����/�޸ı�
**************************************************************************/
------1.������ (varchar����, varchar2�ɱ䳤)
create table person (
    pid number(20),
    name varchar2(10)
);

--�����
alter table person add (gender number(1), age number(3));
--������
alter table person modify gender int;
--������
alter table person rename column gender to sex;
--ɾ����
alter table person drop column age;



/*************************************************************************
                               һ.��ѯ��
**************************************************************************/
------1.tfc0�����б�
select * from all_tables where owner='TFC0';

--��ѯ��
select * from person;