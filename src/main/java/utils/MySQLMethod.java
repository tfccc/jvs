package utils;

import java.sql.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-01 20:54
 * @desc: MySQL ������
 *
 * һ��˵��
 *   1.ʹ��ǰ�赼��JDBC����(jar��)
 *   2.ʹ��ǰ��Ҫ�������ݿ⡢���ݿ�����
 *
 * ���������б�
 *   1.loadDriver()           //��������(��̬�����)
 *   2.connectDataBase()      //�������ݿ�����
 *   3.createStatement()      //�������ݿ����ִ�ж���
 *   4.executeStatement()     //ִ�����ݿ����
 *   4.getResultSet()         //���ز�ѯ�������
 *
 * �����÷�ʾ����
 *   (1)��ѯ
 *      MySQLMethod ms = new MySQLMethod(���ݿ��ַ, �û���, ����);
 *      ResultSet res = ms.getResultSet(DQL���);
 *      while (res.next()) {
 *          String name = res.getString(�ֶ�);
 *      }
 *   (2)����(ɾ�����޸�����)
 *      MySQLMethod ms = new MySQLMethod(���ݿ��ַ, �û���, ����);
 *      ms.executeStatement(DML���);
 *
 **/
public class MySQLMethod {
    ResultSet resSet;
    private boolean isConnected = false;
    private Connection connection;
    private Statement statement;
    private String dbURL;
    private String userName;
    private String Password;
    private String[] errorMessage = {
            "URL��ʽ: (jdbc:���ݿ�����:+URL)",
            "���ݿ�����ʧ�ܣ����URL��ַ / ���ݿ��Ƿ��� / �˺������Ƿ���ȷ",
            "���ݿ�ִ�������󴴽�ʧ��",
            "���ִ��ʧ�ܣ�����﷨���� / ���󲻴���",
            "�����������ʧ��",
            "JDBC��������ʧ�ܣ����������ʽ������ / �Ƿ���������"
    };

    /* 1.��������(��̬�����) */
    static {
        try {
            long a = System.currentTimeMillis();
            Class.forName("com.mysql.cj.jdbc.Driver");
            long b = System.currentTimeMillis();
            System.out.println("�������سɹ�, ��ʱ: " + (b - a) + "ms");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC��������ʧ�ܣ����������ʽ������ / �Ƿ���������");
        }
    }

    /**
     * @Desc ������, ����db�ļ���URL;��ʼ�����ݿ�
     */
    public MySQLMethod(String dbURL, String userName, String password) {
        this.dbURL = dbURL;
        this.userName = userName;
        this.Password = password;
        this.connectDataBase();
        this.createStatement();
    }

    /**
     * @Desc: �������ݿ�����
     * @return: void
     */
    private void connectDataBase() {
        try {
            this.connection = DriverManager.getConnection(dbURL, userName, Password);
        } catch (SQLException e) {
            System.out.println(errorMessage[1] + " , (" + errorMessage[0] + ")");
            e.printStackTrace();
        }
    }

    /**
     * @Desc: �������ݿ����ִ�ж���
     * @return: void
     */
    private void createStatement() {
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(errorMessage[2]);
            e.printStackTrace();
        }
    }

    /**
     * @Desc: ִ�����
     * @return: void
     */
    public void executeStatement(String sqlStatement) {
        try {
            this.statement.execute(sqlStatement);
            this.isConnected = true;
        } catch (SQLException e) {
            System.out.println(errorMessage[3]);
            e.printStackTrace();
        }
    }

    /**
     * @Desc: ִ�����, ���ؽ����
     * @return: void
     */
    public ResultSet getResultSet(String sqlStatement) {
        ResultSet set = null;
        if (!isConnected)
            this.executeStatement(sqlStatement);
        try {
            set = this.statement.executeQuery(sqlStatement);
        } catch (SQLException e) {
            System.out.println(errorMessage[4]);
            e.printStackTrace();
        }
        return set;
    }
}

