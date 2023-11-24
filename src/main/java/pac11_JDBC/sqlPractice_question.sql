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
  10）张老师教的课程中，

**************************************************************************/
# 1
select *
from student
where id in (select student_id
             from course_selection
             where course_id = (select id
                                from course
                                where course_name = '离散数学'));
select t2.*
from course_selection t1,
     student t2
where t1.student_id = t2.id
  and t1.course_id = (select id from course where course_name = '离散数学');

# 2
select t1.student_name, avg(t3.score)
from student t1,
     course t2,
     course_selection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
group by t1.student_name;

# 3
select avg(t3.score) as avgScores, t1.student_name as names
from student t1,
     course t2,
     course_selection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
group by t1.student_name
order by avgScores desc
limit 1;

# 4
select t_avg1.*
from (select avg(t3.score) as avgScores, t1.student_name as names
      from student t1,
           course_selection t3
      where t1.id = t3.student_id
      group by t1.student_name) as t_avg1,
     (select max(t_avg2.avgScores) as max
      from (select avg(t3.score) as avgScores, t1.student_name as names
            from student t1,
                 course_selection t3
            where t1.id = t3.student_id
            group by t1.student_name) t_avg2) as t_maxScore
where t_avg1.avgScores = t_maxScore.max;

# 5
select avg(t3.score) avg, t2.course_name courseName
from teacher t1,
     course t2,
     course_selection t3
where t1.id = t2.teacher_id
  and t2.id = t3.course_id
  and t1.teacher_name = '唐老师'
group by t2.id
order by avg desc
limit 1;

# 6
select t2.student_name
from teacher t1,
     student t2,
     course t3,
     course_selection t4
where t1.id = t3.teacher_id
  and t2.id = t4.student_id
  and t3.id = t4.course_id
  and t1.teacher_name != '徐老师'
group by t2.id;

# 7
select tt1.id all_id, tt1.student_name all_student_name
from student tt1
         left join
     (select t2.id as zhang_id
      from teacher t1,
           student t2,
           course t3,
           course_selection t4
      where t1.id = t3.teacher_id
        and t2.id = t4.student_id
        and t3.id = t4.course_id
        and t1.teacher_name = '张老师'
      group by t2.id) tt2
     on tt1.id = tt2.zhang_id
where tt2.zhang_id IS NULL;

# 8
select max(t3.score)
from student t1,
     course t2,
     course_selection t3
where t1.id = t3.student_id
  and t2.id = t3.course_id
  and t2.course_name = '大学英语'
