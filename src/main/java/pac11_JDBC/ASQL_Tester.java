package pac11_JDBC;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static utils.Formatter.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-08 14:40
 * @desc: SQL����������
 **/
@SuppressWarnings("all")
public class ASQL_Tester {

    static String user = "root";
    static String pawd = "123456";
    static String dbURL1 = "jdbc:mysql://localhost:3306/javatest?serverTimezone=GMT";
    static String select1 = "select * from stuinfo";
    static String insert1 = "INSERT INTO stuinfo VALUES('ovo',27,2017441536,130,140,150,'����',CURRENT_TIMESTAMP)";
    static String delete1 = "delete from stuinfo where name = 'sss'";
    static String update1 = "update stuinfo set english = 1 where name = 'tfc' ";

    static String dbURL2 = "jdbc:sqlite:C:/Users/82818/Desktop/Java/DataBase/AccountData.db";
    static String select2 = "select * from Account";
    static String insert2 = "insert or ignore into Account(userName,password) values ('2017441549','123')";
    static String delete2 = "delete from ��ʦ�˺����� where �˺� = '�Ʒ糾' ";
    static String update2 = "update Account set userName = '2017441548' where userName = '1111'";

    /*************************************************************
     *                       MySQL����
     *************************************************************/
    @Test
    @DisplayName("MySQL����")
    public void testMySQL() throws SQLException {
        long a = System.currentTimeMillis();
        MySQLMethod ms = new MySQLMethod(dbURL1, user, pawd);
        //ms.executeStatement(delete1);
        ResultSet res = ms.getResultSet(select1);
        printMedially("���");
        while (res.next()) {
            String name = res.getString("name");
            String age = res.getString("age");
            String number = res.getString("number");
            String math = res.getString("math");
            String chinese = res.getString("chinese");
            String english = res.getString("english");
            String city = res.getString("city");
            String time = res.getString("time");
        }
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }


    /*************************************************************
     *                       SQLite����
     *************************************************************/
    @Test
    @DisplayName("SQLite����")
    public void testSQLite() throws SQLException {
        long a = System.currentTimeMillis();
        //update2();
        //insert2();
        //insert2();
        //delete2();
        select2();
        long b = System.currentTimeMillis();
        System.out.println("ִ��ʱ��: " + (b - a));
    }

    private static void select2() throws SQLException {
        SQLiteSelect se = new SQLiteSelect(dbURL2);
        ResultSet rs = se.getResultSet(select2);

        while (rs.next()) {
            System.out.print(rs.getString("userName"));
            System.out.print("\t");
            System.out.println(rs.getString("password"));
        }
    }

    private static void insert2() {
        SQLiteInsert in = new SQLiteInsert(dbURL2);
        in.executeStatement(insert2);
    }

    private static void delete2() {
        SQLiteDelete de = new SQLiteDelete(dbURL2);
        de.executeStatement(delete2);
    }

    private static void update2() {
        SQLiteUpdate up = new SQLiteUpdate(dbURL2);
        up.executeStatement(update2);
    }
}
