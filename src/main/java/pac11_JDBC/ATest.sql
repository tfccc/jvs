create table Employee
(
    id           int auto_increment primary key,
    name         varchar(100),
    salary       decimal(10, 2),
    departmentId int
);

create table Department
(
    id   int auto_increment primary key,
    name varchar(100)
);

truncate department;
truncate employee;

insert into department
values (1, 'IT')/*,
       (2, 'Sales')*/;

insert into employee (id, name, salary, departmentId)
values (1, 'Joe', 60000, 1),/*
       (2, 'Henry', 80000, 2),
       (3, 'Sam', 60000, 2),
       (4, 'Max', 90000, 1),*/
       (5, 'Janet', 30000, 1),
       (6, 'Randy', 50000, 1),
       (7, 'Will', 55000, 1);


select *
from Employee e1
         inner join (select *
                     from Employee
                     group by salary, departmentId
                     order by salary desc
                     limit 3) e2
                    on e1.id = e2.id;

SELECT (select name
        from department
        where e.departmentId = id
        limit 1) Department,
       e.name    Employee,
       e.salary  Salary
FROM Employee e
WHERE 3 >= (SELECT COUNT(id)
            FROM Employee
            WHERE departmentId = e.departmentId
              and salary > e.salary
)
ORDER BY e.departmentId, e.salary DESC

