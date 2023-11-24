create table student
(
    id       bigint primary key auto_increment comment 'PK',
    age      int         null comment '年龄',
    height   int         null comment '身高',
    nickname varchar(50) null comment '姓名',
    phone    varchar(50) null comment '电话'
);

create index idx_age_height_nickname on student (age, height, nickname);
create index idx_nickname on student (nickname asc);
drop index idx_age_height_nickname on student;
drop index idx_nickname on student;
show index from student;


#order by 优化, 遵循最左前前缀+无过滤不索引
desc
select *
from student
where age = 25
order by age, height;

desc
select *
from student
order by age, height, nickname;


# group by 优化, 遵循最左前前缀; where和group by可连接最左前缀法则
desc
select height, count(id)
from student
where age = 30
group by height, nickname
order by nickname;


# limit 优化, 覆盖索引+子查询的形式, 提升1.8~2倍, 提升不大但只能这样了
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


# count 优化, 思路: 自己计数, 借用redis等动态存储
desc
select count(age) #count字段=统计非null数据
from student;

desc
select count(*)
from student;


# update优化, 对目标字段: 索引会形成行锁, 非索引会形成表锁, 要尽量去用索引字段去更新
