package pac11_JDBC;

import java.sql.SQLException;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 18:10
 * @desc: SQLlite"插入"方法类
 **/
public class SQLiteInsert extends SQLiteMethod {

    public SQLiteInsert(String dbURL) {
        super(dbURL);
    }

    @Override
    public void executeStatement(String sqlStatement) {
        String type = "insert";
        if (SyntaxCheck.checkType(sqlStatement, type)) {
            this.insert(sqlStatement);
            this.executable = true;
        } else {
            System.out.println("语法错误");
        }
    }

    /**
     * @Desc: 插入方法
     * @return: void
     */
    private void insert(String sqlStatement) {
        try {
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
