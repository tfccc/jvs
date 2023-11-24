use day2;
/************************************************************
                        一.DQL
(a)排序查询
(b)聚合查询
(c)分组查询
(d)分页查询
*************************************************************/

/**********************************************************
                1.排序查询
(1)语法: order by 子句(字段1,方式1, 字段2,方式2)
(2)升序(ASC); 降序(DESC). 默认升序
***********************************************************/
# 按成绩排序单个数据
SELECT *
FROM day2_stu
ORDER BY math DESC;
# 默认升序

# 按成绩排序多个数据
SELECT *
FROM day2_stu
ORDER BY math, chinese DESC;


/**********************************************************
                 2.聚合函数
(1)说明: 将一个数据作为一个整体, 进行纵向计算的内置函数; 会排除NULL
                 (但通过IFNULL()可计算空)
(2)常用函数说明
    (a)count: 计算数量(一般计算主键所在列)
    (b)max  : 计算最大值
    (c)min  : 计算最小值
    (d)sum  : 求和
    (e)avg  : 求平均
***********************************************************/

# 2.1.a
SELECT COUNT(math)
FROM day2_stu;
SELECT COUNT(IFNULL(math, 0))
FROM day2_stu;
# 2.1.b
SELECT MAX(math)
FROM day2_stu;
# 2.1.d
SELECT AVG(math)
FROM day2_stu;


/************************************************************
                          3.分组查询
(1)说明: 根据特征将查询数据分组
(2)语法: group by 分组字段
(3)注意:
    (a)分组后查询的字段: 1.分组字段、2.聚合函数
    (b)where , having 的区别
            1.where在分组前筛选,不满足则不参与分组
            2.having在分组后筛选,不满足则不被查询
            3.where不跟聚合函数, having可跟
    (c)
*************************************************************/
# 按照性别分组,计算两组平均分
SELECT sex, AVG(math), COUNT(number)
FROM day2_stu
GROUP BY sex;

# WHERE限定分组条件(分数小于100),排除某些,再分组
SELECT sex, AVG(math), COUNT(number)
FROM day2_stu
WHERE math >= 100
GROUP BY sex;

# HAVING限定分组后的查询条件(组内人数小于4则不查询)
# 写法1
SELECT sex, AVG(math), COUNT(number)
FROM day2_stu
WHERE math >= 100
GROUP BY sex
HAVING COUNT(number) > 3;
# 写法2(给COUNT(number)取别名)
SELECT sex, AVG(math), COUNT(number) sum_day2_stu
FROM day2_stu
WHERE math >= 100
GROUP BY sex
HAVING sum_day2_stu > 3;


/************************************************************
                        4.分页查询
(1)概念: 对表中的数据进行限定,保证数据的正确、有效、完整.
(2)语法: limit 开始的索引, 每页数量
(3)注意: 实际要结合服务端逻辑代码实现
*************************************************************/

# 从0开始,每页3条
SELECT *
from day2_stu
limit 0,3;
# 第一页
SELECT *
from day2_stu
limit 3,3;
