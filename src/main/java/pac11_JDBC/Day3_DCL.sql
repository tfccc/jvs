use mysql; # 位于mysql的user表中
/*************************************************************
                    三.DCL(数据库控制语句)
  1.说明
      (1)作用:管理数据库用户
      (2)一般由数据库管理员执行DCL
  2.管理用户
      (1)添加用户
      (2)删除用户
      (3)修改密码
      (4)查询用户
  3.授权(权限管理)
      (1)查询权限
      (2)授予权限
      (3)撤销权限
**************************************************************/
# 3.1 查询权限
show grants for '2017441549'@'%';
