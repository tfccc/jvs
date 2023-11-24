package pac11_JDBC;

import java.sql.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 15:03
 * @desc: SQLlite方法抽象类 (采用模板方法模式)
 *
 * 一、说明
 *   1.使用前需导入JDBC驱动(jar包)
 *   2.使用前需要一个可用的DB文件
 *
 * 二、子类说明(模板方法的具体实现类)
 *   1.SQLiteInsert (增加类)
 *   2.SQLiteDelete (删除类)
 *   3.SQLiteUpdate (修改类)
 *   4.SQLiteSelect (查询类)
 *
 * 三、方法列表：
 *   1.loadDriver()           //加载驱动(静态代码块)
 *   2.connectDataBase()      //建立数据库连接
 *   3.createStatement()      //创建数据库语句执行对象
 *   4.executeStatement()     //钩子方法,执行数据库语句;子类中具体实现
 *
 * 四、用法示例：
 * (1)增加(删除、修改类似)
 *   String dbURL  = "jdbc:sqlite:" + db文件的url;
 *   String insert = sql的插入(修改、删除)语句;
 *   SQLiteInsert in = new SQLiteInsert(dbURL);
 *   in.executeStatement(insert);
 * (2)查询
 *   String dbURL  = "jdbc:sqlite:" + db文件的url;
 *   String select = sql的查询语句;
 *   SQLiteSelect se = new SQLiteSelect(dbURL);
 *   ResultSet rs = se.getResultSet(select);
 *   while (rs.next()) {
 *       System.out.print(rs.getString(列名));
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
            "URL格式: (jdbc:sqlite:+URL)",
            "db文件连接失败：检查url地址 / db文件是否可访问",
            "数据库执行语句对象创建失败",
            "语句执行失败：检查语法错误 / 对象不存在"
    };

    //1.加载驱动(静态代码块)
    static {
        long a = System.currentTimeMillis();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC驱动加载失败：检查驱动格式或名称 / 是否导入驱动包");
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        System.out.println("驱动加载完成, 耗时: " + (b - a) + "ms");
    }

    /**
     * @Desc 构造器,传入db文件的URL;初始化数据库
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
     * @Desc:
     *  (1).钩子方法,子类中实现具体细节
     *  (2).执行数据库语句
     * @return: void
     */
    public abstract void executeStatement(String sqlStatement);
}

