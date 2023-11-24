use day3;
/**************************************************************
                        һ.����ѯ
  1.����:�Ӷ��ű��в�ѯ����

  2.�﷨
        select �ֶ��б� from �����б� where... ;

  3.�ѿ�����(����ѯ������������)

  4.��ѯ����
    (1)�����Ӳ�ѯ
        (a)��ʽ������: where���
        (b)��ʾ������: select �ֶ��б� from ����1 inner join ����2 on ����
    (2)�����Ӳ�ѯ(������ʵ������)
        (a)��������(��ѯ�����������,�Լ�������):
            select �ֶ��б� from ��1 left join ��2 on ����
        (b)��������(��ѯ�ұ���������,�Լ�������):
            select �ֶ��б� from ��1 right join ��2 on ����
    (3)�Ӳ�ѯ(��ѯ����Ƕ�ײ�ѯ)
        (a)�Ӳ�ѯ���:���е���
            *�Ӳ�ѯ������Ϊ����,��������ж�(<,>,=��)
        (b)�Ӳ�ѯ���:���е���
            *�﷨: in (���е��в�ѯ���)
        (c)�Ӳ�ѯ���:���ж���
            *�Ӳ�ѯ��Ϊ�����

**************************************************************/

# ����
create table dept
(
    id   int primary key auto_increment,
    name varchar(10)
);
insert into dept (name)
values ('�з���'),
       ('���۲�'),
       ('�г���');
create table emp
(
    id        int primary key auto_increment,
    name      varchar(10),
    gender    char(1),
    salary    double,
    join_date date,
    dept_id   int,
    constraint emp_dept_fk foreign key (dept_id) references dept (id)
);
insert into emp
values (null, 'С��', '��', 3500, '2017-02-20', 1);
insert into emp
values (null, 'С��', '��', 4000, '2015-05-15', 1);
insert into emp
values (null, 'С��', 'Ů', 3200, '2018-05-20', 2);
insert into emp
values (null, 'С��', 'Ů', 4000, '2017-11-05', 3);
insert into emp
values (null, 'С��', '��', 3700, '2017-07-22', 2);

# 3.�ѿ�����(��������������)
select *
from emp,
     dept;


/*************************************************************
                        # 4.1 �����Ӳ�ѯ
**************************************************************/
# 4.1.a ��ʽ������
# ��ѯ����Ա�����䲿�ŵ���Ϣ
select *
from emp,
     dept
where emp.dept_id = dept.id;
# ��ѯ����Ա����name,gender;���ŵ�name
select t1.name, t1.gender, t2.name
from emp as t1,
     dept as t2
where t1.dept_id = t2.id;

# 4.1.b ��ʾ������
# ��ѯ����Ա����name,gender;���ŵ�name(���ַ��������ݲ�����ʾ)
select t1.*, t2.name
from emp as t1
         inner join dept as t2
                    on t1.dept_id = t2.id;


/*************************************************************
                        # 4.2 �����Ӳ�ѯ
**************************************************************/
# 4.2.a ��������
# ��ѯԱ��������Ϣ,���Ա���в���,���ѯ����1;û�в�������ʾ
select t1.*, t2.name
from emp as t1
         left join dept as t2
                   on t1.dept_id = t2.id;
# 4.2.b ��������
# ��ѯԱ��������Ϣ,���Ա���в���,���ѯ����1;û�в�������ʾ
select t1.*, t2.name
from emp as t2
         left join dept as t1
                   on t1.id = t2.dept_id;


/*************************************************************
                        # 4.3�Ӳ�ѯ
**************************************************************/
# 4.3.a ��ѯ������ߵ�Ա������Ϣ
select *
from emp
where emp.salary =
      (select max(salary) from emp);
# 4.3.b ���в���+�з���Ա����Ϣ
select *
from emp
where dept_id in (
    select dept.id
    from dept
    where name = '�з���' or name = '���۲�');
# 4.3.c ��ѯ��ְ������2017-01-01��Ա��+������Ϣ
select *
from dept t1,
     (select * from emp where join_date > '2017-01-01') t2
where t1.id = t2.dept_id;
# Ҳ����������:
select t1.*, t2.*
from emp t1,
     dept t2
where t1.dept_id = t2.id
  and t1.join_date > '2017-01-01';