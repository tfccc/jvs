package pac11_JDBC;

import java.sql.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 15:03
 * @desc: SQLlite���������� (����ģ�巽��ģʽ)
 *
 * һ��˵��
 *   1.ʹ��ǰ�赼��JDBC����(jar��)
 *   2.ʹ��ǰ��Ҫһ�����õ�DB�ļ�
 *
 * ��������˵��(ģ�巽���ľ���ʵ����)
 *   1.SQLiteInsert (������)
 *   2.SQLiteDelete (ɾ����)
 *   3.SQLiteUpdate (�޸���)
 *   4.SQLiteSelect (��ѯ��)
 *
 * ���������б�
 *   1.loadDriver()           //��������(��̬�����)
 *   2.connectDataBase()      //�������ݿ�����
 *   3.createStatement()      //�������ݿ����ִ�ж���
 *   4.executeStatement()     //���ӷ���,ִ�����ݿ����;�����о���ʵ��
 *
 * �ġ��÷�ʾ����
 * (1)����(ɾ�����޸�����)
 *   String dbURL  = "jdbc:sqlite:" + db�ļ���url;
 *   String insert = sql�Ĳ���(�޸ġ�ɾ��)���;
 *   SQLiteInsert in = new SQLiteInsert(dbURL);
 *   in.executeStatement(insert);
 * (2)��ѯ
 *   String dbURL  = "jdbc:sqlite:" + db�ļ���url;
 *   String select = sql�Ĳ�ѯ���;
 *   SQLiteSelect se = new SQLiteSelect(dbURL);
 *   ResultSet rs = se.getResultSet(select);
 *   while (rs.next()) {
 *       System.out.print(rs.getString(����));
 *   }
 *
 **/

public abstract class SQLiteMethod {
    private Connection connection;
    private String dbURL;
    Statement statement;
    ResultSet resSet;
    boolean executable;
    String[] errorMessage = {
            "URL��ʽ: (jdbc:sqlite:+URL)",
            "db�ļ�����ʧ�ܣ����url��ַ / db�ļ��Ƿ�ɷ���",
            "���ݿ�ִ�������󴴽�ʧ��",
            "���ִ��ʧ�ܣ�����﷨���� / ���󲻴���"
    };

    //1.��������(��̬�����)
    static {
        long a = System.currentTimeMillis();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC��������ʧ�ܣ����������ʽ������ / �Ƿ���������");
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        System.out.println("�����������, ��ʱ: " + (b - a) + "ms");
    }

    /**
     * @Desc ������,����db�ļ���URL;��ʼ�����ݿ�
     */
    public SQLiteMethod(String dbURL) {
        this.dbURL = dbURL;
        this.connectDataBase();
        this.createStatement();
    }

    /**
     * @Desc: �������ݿ�����
     * @return: void
     */
    private void connectDataBase() {
        try {
            this.connection = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            System.out.println(errorMessage[1] + "\n" + errorMessage[0]);
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
     * @Desc:
     *  (1).���ӷ���,������ʵ�־���ϸ��
     *  (2).ִ�����ݿ����
     * @return: void
     */
    public abstract void executeStatement(String sqlStatement);
}

