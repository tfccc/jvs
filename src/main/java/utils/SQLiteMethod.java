package utils;

import java.sql.*;
/**
 * @author: Tang.F.C
 * @date: 2020-01-20 14:14
 * @desc: SQLite工具类
 *
 * 一、说明
 *   1.使用前需导入JDBC驱动(jar包)
 *   2.使用前需要一个可用的DB文件
 *
 * 二、方法列表：
 *   1.loadDriver()           //加载驱动(静态代码块)
 *   2.connectDataBase()      //建立数据库连接
 *   3.createStatement()      //创建数据库语句执行对象
 *   4.executeStatement()     //执行数据库语句
 *   5.executeQueryStatement()//查询,返回结果集合
 *
 * 三、用法示例：
 * (1)增加(删除、修改类似)
 *   String dbURL  = "jdbc:sqlite" + db文件的URL;
 *   String insert = SQL语句;
 *   SQLiteMethod sql = new SQLiteMethod(dbURL);
 *   sql.executeStatement(insert);
 *
 * (2)查询
 *   String dbURL  = "jdbc:sqlite" + db文件的URL;
 *   String select = SQL语句;
 *   SQLiteMethod sql = new SQLiteMethod(dbURL);
 *   ResultSet rs = sql.getQuerySet(select);
 *   while (rs.next()) {
 *      System.out.print(rs.getString(列名));
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
            "URL格式: (jdbc:sqlite:+URL)",
            "db文件连接失败：检查url地址 / db文件是否可访问",
            "数据库执行语句对象创建失败",
            "语句执行失败：检查语法错误 / 对象不存在",
            "查询集合生成失败",
            "executeStatement方法只执行“非查询类”语句",
            "getQuerySet方法只执行“查询类”语句"
    };

    //1.加载驱动(静态代码块)
    static {
        long a = System.currentTimeMillis();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC驱动加载失败：检查驱动格式或名称 / 是否导入驱动包");
        }
        long b = System.currentTimeMillis();
        System.out.println("驱动加载完成, 耗时: " + (b - a) + "ms");
    }

    /**
     * @Desc 构造器,传入db文件的URL;初始化数据库
     * @param dbURL db文件的地址
     */
    public SQLiteMethod(String dbURL) {
        this.dbURL = dbURL;
        this.connectDataBase();
        this.createStatement();
    }

    /**
     * @Desc: 建立数据库连接
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
     * @Desc: 创建数据库语句执行对象
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
     * @Desc: 执行数据库语句(增,删,改等操作语句)
     * @param sqlStatement 可执行的SQL语句
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
     * @Desc: 执行数据库语句(查询语句)
     * @param sqlStatement 可执行的SQL语句
     * @return: ResultSet:查询结果集合
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
     * @Desc: 判断是否是Select类语句
     * @param sqlStatement 可执行的SQL语句
     * @return: boolean
     */
    private boolean isSelectStatement(String sqlStatement) {
        String upper = "SELECT";
        String lower = "select";
        return sqlStatement.contains(upper) || sqlStatement.contains(lower);
    }
}
