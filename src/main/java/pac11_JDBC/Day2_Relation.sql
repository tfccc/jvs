use day2;
/*************************************************************
                        三.多表间的关系
1.多表关系分类
    (1)一对一 (一般不涉及多表,用一张表解决问题)
        (a)举例:人和身份证
        (a)运用:可在任意一方添加外键, 指向另一方主键
    (2)一对多
        (a)举例:部门有多个员工, 一个员工对应一个部门
        (b)运用:在"多"建立外键, 指向"一"的主键
    (3)多对多
        (a)举例:选课, 一个学生选多门课, 课程被多人选择
        (b)运用:建立"中间表", 至少包含两表的主键

2.实际案例: 以旅游网站为例
    (1)旅游地点类型A: 多种不同类型的旅游地点
    (2)旅游地点信息B: 具体地点的信息
    (3)用户信息C: 用户的信息、选择的旅游点等

  分析:
    (1)a和b之间,a建立主键,b建立外键指向a的主键
    (1)b和c之间,建立中间表,关联两者的地点id
**************************************************************/

