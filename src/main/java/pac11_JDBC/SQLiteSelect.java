package pac11_JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 17:42
 * @desc: SQLlite"��ѯ"������
 *
 **/
public class SQLiteSelect extends SQLiteMethod {

    private String type = "select";

    public SQLiteSelect(String dbURL) {
        super(dbURL);
    }

    @Override
    public void executeStatement(String sqlStatement) {
        if (SyntaxCheck.checkType(sqlStatement, type)) {
            this.generateResultSet(sqlStatement);
            this.executable = true;
        } else {
            System.out.println("�﷨����");
        }
    }

    /**
     * @Desc: ִ�����,���ɽ������
     * @return: void
     */
    private void generateResultSet(String sqlStatement) {
        try {
            this.resSet = statement.executeQuery(sqlStatement);
        } catch (SQLException e) {
            System.out.println(errorMessage[3]);
            e.printStackTrace();
        }
    }

    /**
     * @Desc: ��ȡ������϶���
     * @return: ResultSet
     */
    public ResultSet getResultSet(String sqlStatement) {
        if (!this.executable)
            this.executeStatement(sqlStatement);
        if (SyntaxCheck.checkType(sqlStatement, type))
            return this.resSet;
        else
            return null;
    }

}
