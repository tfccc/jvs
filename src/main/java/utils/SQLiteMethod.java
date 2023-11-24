package utils;

import java.sql.*;
/**
 * @author: Tang.F.C
 * @date: 2020-01-20 14:14
 * @desc: SQLite������
 *
 * һ��˵��
 *   1.ʹ��ǰ�赼��JDBC����(jar��)
 *   2.ʹ��ǰ��Ҫһ�����õ�DB�ļ�
 *
 * ���������б�
 *   1.loadDriver()           //��������(��̬�����)
 *   2.connectDataBase()      //�������ݿ�����
 *   3.createStatement()      //�������ݿ����ִ�ж���
 *   4.executeStatement()     //ִ�����ݿ����
 *   5.executeQueryStatement()//��ѯ,���ؽ������
 *
 * �����÷�ʾ����
 * (1)����(ɾ�����޸�����)
 *   String dbURL  = "jdbc:sqlite" + db�ļ���URL;
 *   String insert = SQL���;
 *   SQLiteMethod sql = new SQLiteMethod(dbURL);
 *   sql.executeStatement(insert);
 *
 * (2)��ѯ
 *   String dbURL  = "jdbc:sqlite" + db�ļ���URL;
 *   String select = SQL���;
 *   SQLiteMethod sql = new SQLiteMethod(dbURL);
 *   ResultSet rs = sql.getQuerySet(select);
 *   while (rs.next()) {
 *      System.out.print(rs.getString(����));
 *   }
 *
 **/
@SuppressWarnings("unused")
public class SQLiteMethod {
    private Connection connection;
    private String dbURL;
    private Statement statement;
    boolean isConnected = false;
    private String[] errorMessage = {
            "URL��ʽ: (jdbc:sqlite:+URL)",
            "db�ļ�����ʧ�ܣ����url��ַ / db�ļ��Ƿ�ɷ���",
            "���ݿ�ִ�������󴴽�ʧ��",
            "���ִ��ʧ�ܣ�����﷨���� / ���󲻴���",
            "��ѯ��������ʧ��",
            "executeStatement����ִֻ�С��ǲ�ѯ�ࡱ���",
            "getQuerySet����ִֻ�С���ѯ�ࡱ���"
    };

    //1.��������(��̬�����)
    static {
        long a = System.currentTimeMillis();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC��������ʧ�ܣ����������ʽ������ / �Ƿ���������");
        }
        long b = System.currentTimeMillis();
        System.out.println("�����������, ��ʱ: " + (b - a) + "ms");
    }

    /**
     * @Desc ������,����db�ļ���URL;��ʼ�����ݿ�
     * @param dbURL db�ļ��ĵ�ַ
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
        }
    }

    /**
     * @Desc: ִ�����ݿ����(��,ɾ,�ĵȲ������)
     * @param sqlStatement ��ִ�е�SQL���
     * @return: void
     */
    private void executeStatement(String sqlStatement) {
        if (isSelectStatement(sqlStatement)){
            System.out.println(errorMessage[5]);
            return;
        }
        try {
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(errorMessage[3]);
        }
    }

    /**
     * @Desc: ִ�����ݿ����(��ѯ���)
     * @param sqlStatement ��ִ�е�SQL���
     * @return: ResultSet:��ѯ�������
     */
    public ResultSet getQuerySet(String sqlStatement) {
        if (!isSelectStatement(sqlStatement)){
            System.out.println(errorMessage[6]);
            return null;
        }
        executeStatement(sqlStatement);
        ResultSet resultSet = null;
        try {
            resultSet = statement.getResultSet();
        } catch (SQLException e) {
            System.out.println(errorMessage[4]);
        }
        return resultSet;
    }

    /**
     * @Desc: �ж��Ƿ���Select�����
     * @param sqlStatement ��ִ�е�SQL���
     * @return: boolean
     */
    private boolean isSelectStatement(String sqlStatement) {
        String upper = "SELECT";
        String lower = "select";
        return sqlStatement.contains(upper) || sqlStatement.contains(lower);
    }
}
