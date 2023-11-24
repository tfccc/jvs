/*************************************************************************
                               PLSQL
  1.变量
  2.条件判断
  3.循环
  4.游标
  5.存储过程
  6.存储函数
  7.触发器
**************************************************************************/
------------------------------------1.变量定义 / 赋值
declare
    num      number(10)   := 100;
    str      varchar2(10) := '6';
    /* 引用型变量 (这里定义了, 没有赋值) */
    emp_name EMP.ename % type;
    /* 记录型变量 (这里定义了, 没有赋值) */
    emp_row  EMP % rowtype;
begin
    DBMS_OUTPUT.PUT_LINE(num);
    DBMS_OUTPUT.PUT_LINE(str);
    select ENAME into emp_name from EMP where EMPNO = 7788;
    DBMS_OUTPUT.PUT_LINE(emp_name);

    select * into emp_row from EMP where EMPNO = 7788;
    DBMS_OUTPUT.PUT_LINE('姓名--> ' || emp_row.ENAME || ', 编号--> ' || emp_row.EMPNO);
end;


------------------------------------2.条件判断: 输入数字,输出结果
declare
    age number(3) := &age;
begin
    if age < 18 then
        dbms_output.put_line('未成年');
    elsif age >= 18 and age < 30 then
        dbms_output.put_line('青年人');
    elsif age >= 30 and age < 40 then
        dbms_output.put_line('中年人');
    else
        dbms_output.put_line('老年人');
    end if;
end;


------------------------------------3.循环
--3.1 while
declare
    i number := 1;
begin
    while i < 10
        loop
            dbms_output.put_line(i);
            i := i + 1;
        end loop;
end;

--3.2 loop
declare
    i number := 1;
begin
    loop
        dbms_output.put_line(i);
        exit when i > 10;
        i := i + 1;
    end loop;
end;

--3.3 for
declare

begin
    for i in 1..10
        loop
            dbms_output.put_line(i);
        end loop;
end;


------------------------------------4.游标: 类似指针, 可存放多行记录
--4.1输出emp所有员工的姓名
declare
    cursor c1 is select *
                 from emp;
    emp_row emp%rowtype;
begin
    open c1;
    loop
        fetch c1 into emp_row;
        exit when c1%notfound;
        dbms_output.put_line(emp_row.ENAME);
    end loop;
    close c1;
end;


------------------------------------5.存储过程(void): 写好的plsql代码段, 可在数据库直接调用
--5.1 根据员工id, 加工资
create or replace procedure rise_income(eno EMP.EMPNO%type, sal0 number)
    is
begin
    update EMP set EMP.SAL = EMP.SAL + sal0 where EMPNO = eno;
    commit;
end;

--5.2调用
declare
begin
    rise_income(7788, 500);
end;


------------------------------------6.存储函数(return): 计算年薪
/* 型参的in和out的区别: 参数涉及到:=和into都必须用out */
create or replace function count_yearly_income(eno EMP.EMPNO%type) return number
    is
    res number;
begin
    select SAL * 12 + nvl(comm, 0) into res from EMP where EMPNO = eno;
    return res;
end;

declare
    res number;
begin
    res := COUNT_YEARLY_INCOME(7788);
    dbms_output.put_line(res);
end;


------------------------------------7.触发器: 制定规则, 满足规则就执行(仅限增删改)
--7.1语句触发器: 新增员工, 输出'新员工入职'
create or replace trigger t1_statement
    after
        insert
    on EMP
declare
begin
    dbms_output.put_line('一个新员工入职了');
end;
----7.1.1触发t1
insert into EMP
values (9000, 'Tang', 'engineer', null, to_date('2020-12-12 14:00:00'), 1, 1, 10);
commit;


--7.2行级触发器: 不能给员工降薪
create or replace trigger t2_line
    before
        update
    on EMP
    for each row
declare
begin
    if :old.sal > :new.sal then
        raise_application_error(-20001, 'error: 不能执行降薪操作');
    end if;
end;

update EMP
set SAL = SAL - 100
where EMP.EMPNO = 7788;

--7.3触发器实现主键自增
create or replace trigger person_auto_increase
    before
        insert
    on PERSON
    for each row
declare
begin
    select S_PERSON.nextval into :new.ID from dual;
end;

select *
from PERSON;

insert into PERSON (NAME)
values ('bbb');
commit;
