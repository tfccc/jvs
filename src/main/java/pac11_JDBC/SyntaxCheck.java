package pac11_JDBC;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-08 18:47
 * @desc: ����ʽ�ӿ�: ����﷨����Ƿ����
 **/
@FunctionalInterface
public interface SyntaxCheck {

    /**
     * @Desc ���󷽷�,���sqlStatement�Ƿ����type
     * @param sqlStatement ��������
     * @param type ���ݿ��������
     * @return boolean
     */
    boolean check(String sqlStatement, String type);

    /**
     * @Desc ����﷨
     * @param sqlStatement ��������
     * @param type ���ݿ��������
     * @param pre  �﷨���ӿ�
     * @return boolean
     */
    static boolean checkType(String sqlStatement, String type, SyntaxCheck pre) {
        return pre.check(sqlStatement, type)
                || pre.check(sqlStatement, type.toUpperCase());
    }

    /**
     * @Desc Lambda���ʽʵ���﷨�����, ����checkType()
     * @param sqlStatement ��������
     * @param type �﷨����(����: select, insert)
     * @return boolean
     */
    static boolean checkType(String sqlStatement, String type) {
        return checkType(sqlStatement, type, String::contains);
    }
}
