use day2;
/***********************************************************
                         二.约束
	(1)分类
        (a)非空约束: not null
        (b)唯一约束: unique (但可有多个NULL)
        (c)主键约束: primary key
        (d)外键约束: foreign key
    (2)级联操作: 当被外键关联字段发生修改,关联字段一起修改
        (a)级联更新 on update cascade
        (b)级联删除 on delete cascade
*************************************************************/


/*************************************************************
 *                       (c)非空约束
 *************************************************************/
# 1.建表时添加非空约束
create table not_null
(
    id     int,
    number int,
    name   varchar(15) not null
);
insert into not_null value (1, 2017441549, null);
# 2.对已有字段进行修改
alter table not_null
    modify name varchar(20) not null;


/*************************************************************
 *                       (b)唯一约束
 *************************************************************/
# 1.建表时添加唯一约束
create table unique_test
(
    id     int,
    number int unique,
    name   varchar(15) not null
);
insert into unique_test value (2, 2017441548, 'aaa');
# 2.删除唯一约束(语法比较特殊)
alter table unique_test
    drop index number;
# 3.添加唯一约束
alter table unique_test
    modify number int unique;


/*************************************************************
                        (c)主键约束
1.说明
    1.含义:非空且唯一
    2.一张表只能有一个主键
    3.主键当做一个表的 "唯一表示"
2.自动增长(一般配合int型主键使用)

**************************************************************/
# 1.建表时添加主键
create table primary_test
(
    id   int primary key,
    name varchar(15),
    sex  varchar(2)
);
# 2.删除主键
alter table primary_test
    drop primary key;
# 3.添加主键
alter table primary_test
    modify id int primary key;

# 4.1 自动增长(配合int型主键使用)
create table primary_test_auto
(
    id   int primary key auto_increment,
    name varchar(15),
    sex  varchar(2)
);
insert into primary_test_auto value (null, 'aaa', '男');
insert into primary_test_auto value (null, 'bbb', '男');
select *
from primary_test_auto;
# 4.2 添加自动增长
alter table primary_test_auto
    modify id int auto_increment;
# 4.3 删除自动增长
alter table primary_test_auto
    modify id int;


/*************************************************************
                        (d)外键约束
1.作用: 给字段添加外键,建立表之间关联关系,从而保证数据的正确性
2.语法:
    create table tb(
        ....
        constraint 外键名称 foreign key (外键名称)
        references 主表(主表被关联字段名称)
    );
3.作用效果
    1.对有外键约束的表添加数据,外键字段值必是另外一张表已存在的值
    2.被约束表的值,如果存在引用,则无法删除、修改

**************************************************************/
create table emp0
(
    id       int primary key auto_increment,
    name     varchar(10),
    age      int,
    dep_name varchar(10),
    dep_city varchar(15)
);
# 情况:后两个字段有冗余
insert into emp0 (name, age, dep_name, dep_city)
values ('张三', 20, '研发部', '广州');
insert into emp0 (name, age, dep_name, dep_city)
values ('李四', 21, '研发部', '广州');
insert into emp0 (name, age, dep_name, dep_city)
values ('老王', 20, '销售部', '深圳');
insert into emp0 (name, age, dep_name, dep_city)
values ('大王', 22, '销售部', '深圳');
select *
from emp0;
# 解决方案:
# 降后两个拆分,员工表中,用数字表示部门.
# 但会存在问题,例如修改部门,员工表也需要手动变更
# 外键就是为了解决上述问题

# 1.使用外键:
# 创建部门表
create table dept
(
    id       int primary key auto_increment,
    dep_name varchar(10),
    dep_city varchar(15)
);
insert into dept
values (1, '研发部', '重庆');
insert into dept
values (2, '市场部', '上海');
insert into dept
values (3, '销售部', '深圳');
create table emp
(
    id     int primary key auto_increment,
    name   varchar(20),
    age    int,
    dep_id int,
    # 将dep_id作为引用对象,新建名为emp_dept_fk的外键-->关联dept表的id
    constraint emp_dept_fk foreign key (dep_id) references dept (id)
);
insert into emp (name, age, dep_id)
values ('张三', 20, 1);
insert into emp (name, age, dep_id)
values ('李四', 21, 1);
insert into emp (name, age, dep_id)
values ('老王', 20, 2);
insert into emp (name, age, dep_id)
values ('大王', 22, 3);
insert into emp (name, age, dep_id)
values ('小王', 25, 3);

# 2.删除外键:
alter table emp
    drop foreign key emp_dept_fk;
# 3.添加外键
alter table emp
    add constraint emp_dept_fk foreign key (dep_id) references dept (id);

# 级联操作: 当被外键关联字段发生修改,关联字段一起修改
# 1.设置级联更新(添加外键时加入语句)
alter table emp
    add constraint emp_dept_fk foreign key (dep_id)
        references dept (id)
        on update cascade;

select *
from emp;
select *
from dept;