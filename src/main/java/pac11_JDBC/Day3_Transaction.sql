use day3;
/*************************************************************
                           二.事务
  1.说明
      (1)概念: 包含多个步骤的业务操作;要么同时成功,要么同时失败
      (2)操作语句
          (a)开始事务: start transaction
          (b)提交: commit
          (c)回滚: rollback(如果错,则回滚)
      (3)手动、自动提交
          (a)自动: 不运用语句, 数据库默认执行一条语句,就会提交
          (b)手动: 运用事务语句
          (c)可通过"select @@autocommit" 查看事务提交方式,
             0为手动提交; 1为自动提交
          (d)设置事务提交方式: set @@autocommit = 1 / 0

  2.四大特征(ACID)
      (1)原子性(Atomicity)  :不可分割的最小操作单位,同时成功/同时失败
      (2)持久性(Consistence):事务结束后,数据库会持久化保存提交的结果
      (3)隔离性(Isolation)  :多个事务间,相互独立
      (4)一致性(Durability) :事务操作前后,数据总量不变(事务的结果完全
                              符合所有的预设规则)
  3.隔离级别(级别越高越安全,但效率低)
      *概念:多个事务间是独立的.但多个事务操作同一批数据,则会引发问题.
            不同的隔离级别就是为了解决这一问题.
      *存在的问题:
         (a)脏读:一个事物,读取到另一个事务中没有提交的数据
         (b)虚读:同一个事务中,读取到的数据不一样
         (c)幻读:A事务操作数据表中所有的记录,另一个B事务添加了一条数据,
                 则A事务查询不到自己的修改(MySQL不存在该情况)
      (1)read uncommitted: 读未提交
           *问题:脏读,虚读,幻读
      (2)read committed: 读已提交(Oracle默认级别)
           *问题:虚读,幻读
      (3)repeatable read: 可重复读(MySQL默认级别)
           *问题:幻读
      (4)serializable: 串行化
           *问题:无问题

**************************************************************/
# 以银行转账为例,体会事务
# 初始化
create table account
(
    id      int primary key auto_increment,
    name    varchar(20),
    balance double
);
insert into account (name, balance)
values ('tom', 1000),
       ('jack', 1000);

/*************************************************************
                          事务模拟
**************************************************************/
update account set balance = 1000;
start transaction ;
# tom 转给 jack 500
update account set balance = balance - 500 where name='tom';
# jack账户增加500
update account set balance = balance + 500 where name='jack';
# 1.2.b 提交
commit ;
# 1.2.c 回滚
rollback ;
