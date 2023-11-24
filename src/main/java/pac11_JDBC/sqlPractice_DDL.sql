/*************************************************************************
                               table creating
**************************************************************************/
# 学生表
create table student
(
    id            int primary key auto_increment not null,
    studentNumber varchar(20),
    studentName   varchar(10)
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

# 课程表
create table course
(
    id         int primary key auto_increment not null,
    courseName varchar(10),
    teacherID  int,
    constraint course_teacher_fk foreign key (teacherID)
        references teacher (id) on update cascade on delete cascade
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

# 选课关系表
create table courseSelection
(
    id        int primary key auto_increment not null,
    score     int,
    studentID int,
    courseID  int,
    constraint cs_student_fk foreign key (studentID)
        references student (id) on update cascade on delete cascade,
    constraint cs_course_fk foreign key (courseID)
        references course (id) on update cascade on delete cascade
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

# 教师表
create table teacher
(
    id          int primary key auto_increment not null,
    teacherName varchar(10)
) charset = utf8
  engine = InnoDB
  collate = utf8_general_ci;

/*************************************************************************
                               data simulation
**************************************************************************/

insert into student (student_number, student_name)
values ('554445', '许乐成'),
       ('955846', '唐封成'),
       ('618966', '越永怡'),
       ('777703', '林天恩'),
       ('740806', '毛诗蕾'),
       ('806836', '袁友琴'),
       ('221546', '曾秋艳'),
       ('727360', '军芷兰'),
       ('598404', '门白玉'),
       ('138453', '唐娜兰'),
       ('907577', '释文赋'),
       ('303136', '凤三春'),
       ('213393', '柔文斌'),
       ('085567', '廉圣杰'),
       ('098877', '吕慧君'),
       ('414176', '田迎曼'),
       ('546519', '龙宣艳'),
       ('065755', '孟明凝'),
       ('478233', '范忆山'),
       ('507011', '汪梦月');

insert into teacher (teacher_name)
values ('唐老师'),
       ('贾老师'),
       ('张老师'),
       ('徐老师'),
       ('毛老师');

insert into course (course_name, teacher_id)
values('数据结构', 1),
      ('软件需求', 1),
      ('多媒体技术', 1),
      ('人机交互设计', 1),
      ('信息安全', 1),
      ('Web开发技术', 2),
      ('编译原理', 2),
      ('嵌入式开发', 2),
      ('计算机图形学', 2),
      ('离散数学', 2),
      ('大学英语', 3),
      ('数据库', 3),
      ('数据挖掘', 3),
      ('形势与政策', 3),
      ('毛泽东思想', 3),
      ('理工职场英语', 4),
      ('实用商务翻译', 4),
      ('互联网商业', 4),
      ('移动应用开发技术', 4),
      ('行书教程', 4),
      ('操作系统', 5),
      ('大学英语读写译', 5),
      ('软件项目管理', 5),
      ('人机交互', 5),
      ('面向对象程序设计', 5);

insert into course_selection (score, student_id, course_id)
values (95, 1, 10),
       (80, 1, 15),
       (55, 1, 7),
       (70, 1, 5),
       (99, 1, 8),

       (98, 2, 9),
       (88, 2, 8),
       (59, 2, 7),
       (68, 2, 5),
       (87, 2, 22),

       (68, 3, 23),
       (54, 3, 25),
       (67, 3, 8),
       (42, 3, 14),
       (95, 3, 19),

       (92, 4, 20),
       (60, 4, 13),
       (75, 4, 6),
       (40, 4, 22),
       (95, 4, 19),

       (99, 5, 3),
       (48, 5, 4),
       (99, 5, 5),
       (94, 5, 6),
       (97, 5, 17),

       (84, 6, 18),
       (81, 6, 15),
       (96, 6, 11),
       (96, 6, 16),
       (69, 6, 17),

       (90, 7, 11),
       (78, 7, 23),
       (49, 7, 15),
       (77, 7, 14),
       (74, 7, 5),

       (64, 8, 6),
       (78, 8, 24),
       (57, 8, 8),
       (70, 8, 25),
       (70, 8, 1),

       (62, 9, 9),
       (51, 9, 13),
       (83, 9, 16),
       (81, 9, 24),
       (69, 9, 2),

       (86, 9, 9),
       (95, 9, 13),
       (73, 9, 16),
       (46, 9, 24),
       (74, 9, 2),

       (85, 10, 2),
       (41, 10, 3),
       (74, 10, 4),
       (99, 10, 5),
       (98, 10, 6),

       (49, 11, 8),
       (85, 11, 18),
       (52, 11, 24),
       (94, 11, 25),
       (61, 11, 1),

       (59, 12, 9),
       (57, 12, 7),
       (96, 12, 3),
       (66, 12, 5),
       (58, 12, 11),

       (62, 13, 25),
       (52, 13, 21),
       (82, 13, 12),
       (91, 13, 8),
       (83, 13, 9),

       (51, 14, 19),
       (49, 14, 17),
       (80, 14, 16),
       (84, 14, 18),
       (96, 14, 11),

       (63, 15, 12),
       (97, 15, 13),
       (74, 15, 20),
       (53, 15, 21),
       (85, 15, 7),

       (91, 17, 20),
       (93, 17, 17),
       (80, 17, 16),
       (79, 17, 15),
       (98, 17, 19),

       (49, 18, 10),
       (53, 18, 11),
       (69, 18, 12),
       (62, 18, 23),
       (48, 18, 15),

       (67, 19, 10),
       (71, 19, 3),
       (70, 19, 2),
       (82, 19, 9),
       (84, 19, 8),

       (48, 20, 11),
       (87, 20, 25),
       (67, 20, 21),
       (53, 20, 12),
       (42, 20, 2);


/*************************************************************************
                               practice
**************************************************************************/