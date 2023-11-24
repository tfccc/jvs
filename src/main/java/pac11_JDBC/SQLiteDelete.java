package pac11_JDBC;

import java.sql.SQLException;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 18:28
 * @desc: SQLlite"ɾ��"������
 **/
public class SQLiteDelete extends SQLiteMethod {

    public SQLiteDelete(String dbURL) {
        super(dbURL);
    }

    @Override
    public void executeStatement(String sqlStatement) {
        String type = "delete";
        if (SyntaxCheck.checkType(sqlStatement, type)) {
            this.delete(sqlStatement);
            this.executable = true;
        } else {
            System.out.println("�﷨����");
        }
    }

    /**
     * @Desc: ɾ������
     * @return: void
     */
    private void delete(String sqlStatement) {
        try {
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
