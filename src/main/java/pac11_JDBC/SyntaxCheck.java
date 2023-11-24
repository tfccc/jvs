package pac11_JDBC;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 18:47
 * @desc: 函数式接口: 检查语法类别是否合理
 **/
@FunctionalInterface
public interface SyntaxCheck {

    /**
     * @Desc 抽象方法,检查sqlStatement是否符合type
     * @param sqlStatement 待检查语句
     * @param type 数据库语句类型
     * @return boolean
     */
    boolean check(String sqlStatement, String type);

    /**
     * @Desc 检查语法
     * @param sqlStatement 待检查语句
     * @param type 数据库语句类型
     * @param pre  语法检查接口
     * @return boolean
     */
    static boolean checkType(String sqlStatement, String type, SyntaxCheck pre) {
        return pre.check(sqlStatement, type)
                || pre.check(sqlStatement, type.toUpperCase());
    }

    /**
     * @Desc Lambda表达式实现语法类别检查, 重载checkType()
     * @param sqlStatement 待检查语句
     * @param type 语法类型(例如: select, insert)
     * @return boolean
     */
    static boolean checkType(String sqlStatement, String type) {
        return checkType(sqlStatement, type, String::contains);
    }
}
