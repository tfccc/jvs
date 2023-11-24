create table student
(
    id       bigint primary key auto_increment comment 'PK',
    age      int         null comment '����',
    height   int         null comment '���',
    nickname varchar(50) null comment '����',
    phone    varchar(50) null comment '�绰'
);

create index idx_age_height_nickname on student (age, height, nickname);
create index idx_nickname on student (nickname asc);
drop index idx_age_height_nickname on student;
drop index idx_nickname on student;
show index from student;


#order by �Ż�, ��ѭ����ǰǰ׺+�޹��˲�����
desc
select *
from student
where age = 25
order by age, height;

desc
select *
from student
order by age, height, nickname;


# group by �Ż�, ��ѭ����ǰǰ׺; where��group by����������ǰ׺����
desc
select height, count(id)
from student
where age = 30
group by height, nickname
order by nickname;


# limit �Ż�, ��������+�Ӳ�ѯ����ʽ, ����1.8~2��, ��������ֻ��������
desc
select *
from student
limit 5000000, 100;

select main.*
from student main
         inner join
     (select id
      from student
      limit 5000000, 100) id_tb
where main.id = id_tb.id;


# count �Ż�, ˼·: �Լ�����, ����redis�ȶ�̬�洢
desc
select count(age) #count�ֶ�=ͳ�Ʒ�null����
from student;

desc
select count(*)
from student;


# update�Ż�, ��Ŀ���ֶ�: �������γ�����, ���������γɱ���, Ҫ����ȥ�������ֶ�ȥ����
