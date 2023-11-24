use day2;
/***********************************************************
                         ��.Լ��
	(1)����
        (a)�ǿ�Լ��: not null
        (b)ΨһԼ��: unique (�����ж��NULL)
        (c)����Լ��: primary key
        (d)���Լ��: foreign key
    (2)��������: ������������ֶη����޸�,�����ֶ�һ���޸�
        (a)�������� on update cascade
        (b)����ɾ�� on delete cascade
*************************************************************/


/*************************************************************
 *                       (c)�ǿ�Լ��
 *************************************************************/
# 1.����ʱ��ӷǿ�Լ��
create table not_null
(
    id     int,
    number int,
    name   varchar(15) not null
);
insert into not_null value (1, 2017441549, null);
# 2.�������ֶν����޸�
alter table not_null
    modify name varchar(20) not null;


/*************************************************************
 *                       (b)ΨһԼ��
 *************************************************************/
# 1.����ʱ���ΨһԼ��
create table unique_test
(
    id     int,
    number int unique,
    name   varchar(15) not null
);
insert into unique_test value (2, 2017441548, 'aaa');
# 2.ɾ��ΨһԼ��(�﷨�Ƚ�����)
alter table unique_test
    drop index number;
# 3.���ΨһԼ��
alter table unique_test
    modify number int unique;


/*************************************************************
                        (c)����Լ��
1.˵��
    1.����:�ǿ���Ψһ
    2.һ�ű�ֻ����һ������
    3.��������һ����� "Ψһ��ʾ"
2.�Զ�����(һ�����int������ʹ��)

**************************************************************/
# 1.����ʱ�������
create table primary_test
(
    id   int primary key,
    name varchar(15),
    sex  varchar(2)
);
# 2.ɾ������
alter table primary_test
    drop primary key;
# 3.�������
alter table primary_test
    modify id int primary key;

# 4.1 �Զ�����(���int������ʹ��)
create table primary_test_auto
(
    id   int primary key auto_increment,
    name varchar(15),
    sex  varchar(2)
);
insert into primary_test_auto value (null, 'aaa', '��');
insert into primary_test_auto value (null, 'bbb', '��');
select *
from primary_test_auto;
# 4.2 ����Զ�����
alter table primary_test_auto
    modify id int auto_increment;
# 4.3 ɾ���Զ�����
alter table primary_test_auto
    modify id int;


/*************************************************************
                        (d)���Լ��
1.����: ���ֶ�������,������֮�������ϵ,�Ӷ���֤���ݵ���ȷ��
2.�﷨:
    create table tb(
        ....
        constraint ������� foreign key (�������)
        references ����(���������ֶ�����)
    );
3.����Ч��
    1.�������Լ���ı��������,����ֶ�ֵ��������һ�ű��Ѵ��ڵ�ֵ
    2.��Լ�����ֵ,�����������,���޷�ɾ�����޸�

**************************************************************/
create table emp0
(
    id       int primary key auto_increment,
    name     varchar(10),
    age      int,
    dep_name varchar(10),
    dep_city varchar(15)
);
# ���:�������ֶ�������
insert into emp0 (name, age, dep_name, dep_city)
values ('����', 20, '�з���', '����');
insert into emp0 (name, age, dep_name, dep_city)
values ('����', 21, '�з���', '����');
insert into emp0 (name, age, dep_name, dep_city)
values ('����', 20, '���۲�', '����');
insert into emp0 (name, age, dep_name, dep_city)
values ('����', 22, '���۲�', '����');
select *
from emp0;
# �������:
# �����������,Ա������,�����ֱ�ʾ����.
# �����������,�����޸Ĳ���,Ա����Ҳ��Ҫ�ֶ����
# �������Ϊ�˽����������

# 1.ʹ�����:
# �������ű�
create table dept
(
    id       int primary key auto_increment,
    dep_name varchar(10),
    dep_city varchar(15)
);
insert into dept
values (1, '�з���', '����');
insert into dept
values (2, '�г���', '�Ϻ�');
insert into dept
values (3, '���۲�', '����');
create table emp
(
    id     int primary key auto_increment,
    name   varchar(20),
    age    int,
    dep_id int,
    # ��dep_id��Ϊ���ö���,�½���Ϊemp_dept_fk�����-->����dept���id
    constraint emp_dept_fk foreign key (dep_id) references dept (id)
);
insert into emp (name, age, dep_id)
values ('����', 20, 1);
insert into emp (name, age, dep_id)
values ('����', 21, 1);
insert into emp (name, age, dep_id)
values ('����', 20, 2);
insert into emp (name, age, dep_id)
values ('����', 22, 3);
insert into emp (name, age, dep_id)
values ('С��', 25, 3);

# 2.ɾ�����:
alter table emp
    drop foreign key emp_dept_fk;
# 3.������
alter table emp
    add constraint emp_dept_fk foreign key (dep_id) references dept (id);

# ��������: ������������ֶη����޸�,�����ֶ�һ���޸�
# 1.���ü�������(������ʱ�������)
alter table emp
    add constraint emp_dept_fk foreign key (dep_id)
        references dept (id)
        on update cascade;

select *
from emp;
select *
from dept;