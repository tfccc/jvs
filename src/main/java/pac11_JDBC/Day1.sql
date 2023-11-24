use day1;
/*********************************************************
                         day1内容
	一.数据库的概念
		
	二.MySQL软件安装、卸载等

	三.SQL的内容概要(基本语句等)

**********************************************************/

SELECT * FROM day1_stu;

SELECT * FROM day1_stu WHERE id=2;

SELECT name,age from day1_stu ;		# 指定列查询

SELECT DISTINCT score from day1_stu ; # 去重

SELECT # 计算两个字段和
       score,
       id,
       id + IFNULL(score, 0) AS sum
FROM
    day1_stu;

SELECT # 计算两个字段和
       score,
       id,
       id + IFNULL(score, 0) AS sum
FROM
    day1_stu;

#运算符
SELECT * from day1_stu where score>=120 and id=5;

SELECT * from day1_stu where score>=120 or id>7;

SELECT * from day1_stu where score=150 or score=120;

SELECT * from day1_stu where score is NULL;

SELECT * from day1_stu where score is not NULL;

/*******************************************************
模糊查询: LIKE
    占位符
        1. _任意单个字符
        2. %任意多个字符
********************************************************/

SELECT * from day1_stu where name LIKE '___'; 	# 三个字名字

SELECT * from day1_stu where name LIKE 't%';	# 第一个为t的名字

SELECT * from day1_stu where name LIKE '%t%';  # 包含t字

