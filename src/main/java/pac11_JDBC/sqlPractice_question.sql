# 学生表
create table student
(
    id            int primary key auto_increment not null,
    student_number varchar(20),
    student_name   varchar(10)
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

# 教师表
create table teacher
(
    id          int primary key auto_increment not null,
    teacher_name varchar(10)
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

# 课程表
create table course
(
    id         int primary key auto_increment not null,
    course_name varchar(10),
    teacher_ID  int,
    constraint course_teacher_fk foreign key (teacher_ID)
        references teacher (id) on update cascade on delete cascade
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

# 选课关系表
create table courseSelection
(
    id        int primary key auto_increment not null,
    score     int,
    student_ID int,
    course_ID  int,
    constraint cs_student_fk foreign key (student_ID)
        references student (id) on update cascade on delete cascade,
    constraint cs_course_fk foreign key (course_ID)
        references course (id) on update cascade on delete cascade
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

/******************************** sql练习 ********************************
                               practice
  1) 选了'离散数学'的学生
  2) 所有学生的平均成绩
  3) 所有学生的平均成绩中最大值(查询结果为一个最大值)
  4) 所有学生的平均成绩中最大值(相同情况查询结果为多个)
  5) '唐老师'平均成绩最高的课
  6) 选了'徐老师'的学生
  7) 没选'张老师'课的学生
  8) '大学英语'成绩最好的学生(查询结果为一个最大值)
  9) '大学英语'成绩最好的学生(相同情况结果为多个)
  10) 张老师教的课程中，平均成绩大于70的课
  11) 选课数量大于3门课的学生，且该学生平均成绩大于60
  12) 有哪些课程没有人选
  13) 返回2行，1列数据。第一行，所有学生的平均成绩；第二行，老师平均教几门课
  14) 平均成绩最高的前5个学生中，选了信息安全，且该课程成绩最好的人
  15) 平均成绩倒数第三的学生
  16) 返回1行，3列数据。第一列，所有学生的平均成绩；第二列，老师平均教几门课；第三列, 对应第二列该老师的名字
  17) 返回n行，3列数据。第一列，课程的平均成绩；第二列，课程名称；第三列，选了这门课的学生(以逗号分隔)
  18) 同一门课成绩相同，但学生不同的情况，结果包含课程+成绩+学生1+学生2
  19) 查询出学生的平均成绩中，相同的平均成绩
  20) 按学生的平均成绩进行升序排名。第一列，该学生的排名(从1~n)；第二列，平均成绩；第三列，学生名
  21) 选课总人数最多的老师，并返回该老师名字+选课总人数
  22) '张老师'的所有课程平均成绩，大于'唐老师'的所有课程平均成绩? 返回一个布尔值来表示结果
  23) 如果学生1只选了A,B,C三门课，学生2也只选了A,B,C三门课，将这类情况(两个人选的所有课程都相同)查询出来
  24) 统计每个课程各个分段的人数, s<60,不及格 / 60<=s<70,及格 / 70<=s<90,良好 / s>=90,优秀

**************************************************************************/

# 1)
select *
from student
where id in (select student_id
             from courseselection
             where course_id = (select id
                                from course
                                where course_name = '离散数学'));
select t2.*
from courseselection t1,
     student t2
where t1.student_id = t2.id
  and t1.course_id = (select id from course where course_name = '离散数学');

# 2)
select t1.student_name, avg(t3.score)
from student t1,
     course t2,
     courseselection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
group by t1.student_name;

# 3)
select avg(t3.score) as avgScores, t1.student_name as names
from student t1,
     course t2,
     courseselection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
group by t1.student_name
order by avgScores desc
limit 1;

# 4)
desc
select t_avg1.*
from (select avg(t3.score) as avgScores, t1.student_name as names
      from student t1,
           courseselection t3
      where t1.id = t3.student_id
      group by t1.student_name) as t_avg1,
     (select max(t_avg2.avgScores) as max
      from (select avg(t3.score) as avgScores, t1.student_name as names
            from student t1,
                 courseselection t3
            where t1.id = t3.student_id
            group by t1.student_name) t_avg2) as t_maxScore
where t_avg1.avgScores = t_maxScore.max;

# 5)
select avg(t3.score) avg, t2.course_name courseName
from teacher t1,
     course t2,
     courseselection t3
where t1.id = t2.teacher_id
  and t2.id = t3.course_id
  and t1.teacher_name = '唐老师'
group by t2.id
order by avg desc
limit 1;

# 6)
select t2.student_name
from teacher t1,
     student t2,
     course t3,
     courseselection t4
where t1.id = t3.teacher_id
  and t2.id = t4.student_id
  and t3.id = t4.course_id
  and t1.teacher_name != '徐老师'
group by t2.id;

# 7)
select tt1.id all_id, tt1.student_name all_student_name
from student tt1
         left join
     (select t2.id as zhang_id
      from teacher t1,
           student t2,
           course t3,
           courseselection t4
      where t1.id = t3.teacher_id
        and t2.id = t4.student_id
        and t3.id = t4.course_id
        and t1.teacher_name = '张老师'
      group by t2.id) tt2
     on tt1.id = tt2.zhang_id
where tt2.zhang_id IS NULL;

# 8)
select max(t3.score)
from student t1,
     course t2,
     courseselection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
  and t2.course_name = '大学英语';

# 10)
select t4.course_ID,
       t3.course_name,
       avg(t4.score)
from teacher t1,
     student t2,
     course t3,
     courseselection t4
where t1.id = t3.teacher_id
  and t2.id = t4.student_id
  and t3.id = t4.course_id
  and t1.teacher_name = '张老师'
group by t4.course_ID
having avg(t4.score) >= 70;

# 11)
select res.stuName,
       res.courseCount,
       res.avgScore
from (select t2.student_name stuName,
             count(t4.id)    courseCount,
             avg(t4.score)   avgScore
      from teacher t1,
           student t2,
           course t3,
           courseselection t4
      where t1.id = t3.teacher_id
        and t2.id = t4.student_id
        and t3.id = t4.course_id
      group by t4.student_id) res
where avgScore > 60
  and courseCount > 3;

# 12)
select t1.id,
       t1.course_name
from course t1
         left join
     courseselection t2
     on t1.id = t2.course_ID
where t2.id is null;

# 13)
select avg(t4.score)
from student t2,
     course t3,
     courseselection t4
where t2.id = t4.student_id
  and t3.id = t4.course_id
union all
select avg(ttt.count)
from (select count(t3.id) count
      from teacher t2,
           course t3
      where t2.id = t3.teacher_ID
      group by t3.teacher_ID) ttt;

# 14)
select t1.id,
       t1.student_name,
       t3.score
from student t1,
     course t2,
     courseselection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
  and t2.course_name = '信息安全'
  and t1.id in (select id
                from (select t1.id as id
                      from student t1,
                           course t2,
                           courseselection t3
                      where t1.id = t3.student_id
                        and t2.id = t3.course_id
                      group by t1.student_name
                      order by avg(t3.score) desc
                      limit 5) top5)
order by t3.score desc
limit 1;

# 15)
select t1.student_name,
       avg(t3.score)
from student t1,
     course t2,
     courseselection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
group by t1.student_name
order by avg(t3.score)
limit 2,1;

# 16)
select res1.r1,
       res2.r2_count,
       res2.r2_teacherName
from (select avg(t4.score) r1
      from student t2,
           course t3,
           courseselection t4
      where t2.id = t4.student_id
        and t3.id = t4.course_id) res1,
     (select avg(ttt.count)      r2_count,
             ttt.teacher_name as r2_teacherName
      from (select count(t3.id) count,
                   t2.teacher_name
            from teacher t2,
                 course t3
            where t2.id = t3.teacher_ID
            group by t3.teacher_ID) ttt) res2;

# 17)
select t3.course_name,
       avg(t4.score),
       group_concat(t2.student_name)
from teacher t1,
     student t2,
     course t3,
     courseselection t4
where t1.id = t3.teacher_id
  and t2.id = t4.student_id
  and t3.id = t4.course_id
group by t4.course_ID;

# 18)
select t1.course_ID    as '课程id',
       t1.score        as '成绩',
       t3.student_name as '学生1',
       t4.student_name as '学生2'
from courseselection t1,
     courseselection t2,
     student t3,
     student t4
where t1.course_ID = t2.course_ID
  and t1.student_ID = t3.id
  and t2.student_ID = t4.id
  and t1.score = t2.score
  and t1.student_ID != t2.student_ID
group by t1.course_ID, t1.score;

# 19
select res.avg
from (select avg(t3.score) as avg
      from student t1,
           course t2,
           courseselection t3
      where t1.id = t3.student_id
        and t2.id = t3.course_id
      group by t1.student_name
      order by avg(t3.score)) res
group by res.avg
having count(*) > 1;

# 20)
select @idx := @idx + 1,
       avg,
       studentName
from (select avg(t3.score)   as avg,
             t1.id           as studentId,
             t1.student_name as studentName
      from student t1,
           course t2,
           courseselection t3
      where t1.id = t3.student_id
        and t2.id = t3.course_id
      group by t1.student_name
      order by avg(t3.score)) res
         inner join
     (select @idx := 0) idx;

# 21)
select t2.teacher_name teacherName,
       count(t1.id)    courseCount
from courseselection t1,
     teacher t2,
     course t3
where t1.course_ID = t3.id
  and t2.id = t3.teacher_ID
group by t2.id
order by courseCount desc
limit 1;

# 22)
select (select avg(t1.score)
        from courseselection t1,
             course t2,
             teacher t3
        where t1.course_ID = t2.id
          and t2.teacher_ID = t3.id
          and t3.teacher_name = '张老师')
           >
       (select avg(t1.score)
        from courseselection t1,
             course t2,
             teacher t3
        where t1.course_ID = t2.id
          and t2.teacher_ID = t3.id
          and t3.teacher_name = '唐老师') as '王老师>=唐老师?';

# 23)
select distinct if(r1.student_ID > r2.student_ID, r2.student_ID, r1.student_ID) student1,
                if(r1.student_ID > r2.student_ID, r1.student_ID, r2.student_ID) student2,
                r1.gc
from (select cs.student_ID,
             group_concat(cs.course_ID order by cs.course_ID) gc
      from courseselection cs
      group by cs.student_ID) r1,
     (select cs.student_ID,
             group_concat(cs.course_ID order by cs.course_ID) gc
      from courseselection cs
      group by cs.student_ID) r2
where r1.student_ID != r2.student_ID
  and r1.gc = r2.gc;

# 24)
select t2.course_name                  as '课程名称',
       sum(if(score >= 90, 1, 0))      as '优秀',
       sum(if(70 <= score < 90, 1, 0)) as '良好',
       sum(if(60 <= score < 70, 1, 0)) as '及格',
       sum(if(score < 60, 1, 0))       as '不及格'
from course t2
         left join
     courseselection t1
     on t1.course_ID = t2.id
group by t2.id;


