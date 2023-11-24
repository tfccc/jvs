package utils;

import java.sql.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-01 20:54
 * @desc: MySQL 工具类
 *
 * 一、说明
 *   1.使用前需导入JDBC驱动(jar包)
 *   2.使用前需要开启数据库、数据库密码
 *
 * 二、方法列表：
 *   1.loadDriver()           //加载驱动(静态代码块)
 *   2.connectDataBase()      //建立数据库连接
 *   3.createStatement()      //创建数据库语句执行对象
 *   4.executeStatement()     //执行数据库语句
 *   4.getResultSet()         //返回查询结果集合
 *
 * 三、用法示例：
 *   (1)查询
 *      MySQLMethod ms = new MySQLMethod(数据库地址, 用户名, 密码);
 *      ResultSet res = ms.getResultSet(DQL语句);
 *      while (res.next()) {
 *          String name = res.getString(字段);
 *      }
 *   (2)增加(删除、修改类似)
 *      MySQLMethod ms = new MySQLMethod(数据库地址, 用户名, 密码);
 *      ms.executeStatement(DML语句);
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
            "URL格式: (jdbc:数据库类型:+URL)",
            "数据库连接失败：检查URL地址 / 数据库是否开启 / 账号密码是否正确",
            "数据库执行语句对象创建失败",
            "语句执行失败：检查语法错误 / 对象不存在",
            "结果集合生成失败",
            "JDBC驱动加载失败：检查驱动格式或名称 / 是否导入驱动包"
    };

    /* 1.加载驱动(静态代码块) */
    static {
        try {
            long a = System.currentTimeMillis();
            Class.forName("com.mysql.cj.jdbc.Driver");
            long b = System.currentTimeMillis();
            System.out.println("驱动加载成功, 耗时: " + (b - a) + "ms");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC驱动加载失败：检查驱动格式或名称 / 是否导入驱动包");
        }
    }

    /**
     * @Desc 构造器, 传入db文件的URL;初始化数据库
     */
    public MySQLMethod(String dbURL, String userName, String password) {
        this.dbURL = dbURL;
        this.userName = userName;
        this.Password = password;
        this.connectDataBase();
        this.createStatement();
    }

    /**
     * @Desc: 建立数据库连接
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
     * @Desc: 创建数据库语句执行对象
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
     * @Desc: 执行语句
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
     * @Desc: 执行语句, 返回结果集
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

