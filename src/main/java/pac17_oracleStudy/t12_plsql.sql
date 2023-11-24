/*************************************************************************
                               PLSQL
  1.����
  2.�����ж�
  3.ѭ��
  4.�α�
  5.�洢����
  6.�洢����
  7.������
**************************************************************************/
------------------------------------1.�������� / ��ֵ
declare
    num      number(10)   := 100;
    str      varchar2(10) := '6';
    /* �����ͱ��� (���ﶨ����, û�и�ֵ) */
    emp_name EMP.ename % type;
    /* ��¼�ͱ��� (���ﶨ����, û�и�ֵ) */
    emp_row  EMP % rowtype;
begin
    DBMS_OUTPUT.PUT_LINE(num);
    DBMS_OUTPUT.PUT_LINE(str);
    select ENAME into emp_name from EMP where EMPNO = 7788;
    DBMS_OUTPUT.PUT_LINE(emp_name);

    select * into emp_row from EMP where EMPNO = 7788;
    DBMS_OUTPUT.PUT_LINE('����--> ' || emp_row.ENAME || ', ���--> ' || emp_row.EMPNO);
end;


------------------------------------2.�����ж�: ��������,������
declare
    age number(3) := &age;
begin
    if age < 18 then
        dbms_output.put_line('δ����');
    elsif age >= 18 and age < 30 then
        dbms_output.put_line('������');
    elsif age >= 30 and age < 40 then
        dbms_output.put_line('������');
    else
        dbms_output.put_line('������');
    end if;
end;


------------------------------------3.ѭ��
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


------------------------------------4.�α�: ����ָ��, �ɴ�Ŷ��м�¼
--4.1���emp����Ա��������
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


------------------------------------5.�洢����(void): д�õ�plsql�����, �������ݿ�ֱ�ӵ���
--5.1 ����Ա��id, �ӹ���
create or replace procedure rise_income(eno EMP.EMPNO%type, sal0 number)
    is
begin
    update EMP set EMP.SAL = EMP.SAL + sal0 where EMPNO = eno;
    commit;
end;

--5.2����
declare
begin
    rise_income(7788, 500);
end;


------------------------------------6.�洢����(return): ������н
/* �Ͳε�in��out������: �����漰��:=��into��������out */
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


------------------------------------7.������: �ƶ�����, ��������ִ��(������ɾ��)
--7.1��䴥����: ����Ա��, ���'��Ա����ְ'
create or replace trigger t1_statement
    after
        insert
    on EMP
declare
begin
    dbms_output.put_line('һ����Ա����ְ��');
end;
----7.1.1����t1
insert into EMP
values (9000, 'Tang', 'engineer', null, to_date('2020-12-12 14:00:00'), 1, 1, 10);
commit;


--7.2�м�������: ���ܸ�Ա����н
create or replace trigger t2_line
    before
        update
    on EMP
    for each row
declare
begin
    if :old.sal > :new.sal then
        raise_application_error(-20001, 'error: ����ִ�н�н����');
    end if;
end;

update EMP
set SAL = SAL - 100
where EMP.EMPNO = 7788;

--7.3������ʵ����������
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
