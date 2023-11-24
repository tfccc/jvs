package utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-28 11:16
 * @desc: �Ӽ��̶�������
 **/
public class Input {

    /**
     * @Desc �Ӽ��̶�ȡ�����ַ���(�Կո񡢻س��Ƚ���)
     * @return ����������ַ���
     */
    public static String getStr() {
        return new Scanner(System.in).next();
    }

    /**
     * @Desc �Ӽ��̶�ȡ����һ���ַ���(�س�����)
     * @return ���������һ���ַ���
     */
    public static String getLine() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * @Desc �Ӽ��̶�ȡһ���Կո�ָ����ַ���
     * @return �ַ�������
     */
    public static String[] getStrs() {
        return getLine().split("\\s+");
    }


    /**
     * @Desc �Ӽ��̶�ȡ����
     * @return �������������
     */
    public static int getInteger() {
        return Integer.parseInt(getStr());
    }

    /**
     * @Desc �Ӽ��̶�ȡһ���Կո�ָ�������
     * @return ��������
     */
    public static int[] getIntegers() {
        String strs = getLine();
        String[] strArr = strs.split("\\s+");
        return Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
    }

}
