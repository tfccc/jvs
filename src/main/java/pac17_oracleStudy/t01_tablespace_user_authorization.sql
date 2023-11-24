/*************************************************************************
                                一.表空间
**************************************************************************/
--创建表空间
create tablespace oracle_study
    datafile 'G:\app\82818\tablespace\oracle_study.dbf'
    size 256 m
    autoextend on
    next 10 m;

--删除表空间
drop tablespace ?;


/*************************************************************************
                                二.用户创建
**************************************************************************/
------1.删除用户
drop user tfc0 cascade;

------2.创建用户
create user tfc0
    identified by 123456
    default tablespace oracle_study;



/*************************************************************************
                                三.授权
  1.connect---->连接角色
  2.resource--->开发者角色
  3.dba-------->超级管理员
**************************************************************************/
------1.授权
grant dba to GOA;
