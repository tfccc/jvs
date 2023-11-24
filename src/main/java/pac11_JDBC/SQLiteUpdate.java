package pac11_JDBC;

import java.sql.SQLException;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 18:32
 * @desc: SQLlite"�޸�"������
 **/
public class SQLiteUpdate extends SQLiteMethod {

    public SQLiteUpdate(String dbURL) {
        super(dbURL);
    }

    @Override
    public void executeStatement(String sqlStatement) {
        String type = "update";
        if (SyntaxCheck.checkType(sqlStatement, type)) {
            this.update(sqlStatement);
            this.executable = true;
        } else {
            System.out.println("�﷨����");
        }
    }

    /**
     * @Desc: �޸ķ���
     * @return: void
     */
    private void update(String sqlStatement) {
        try {
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
