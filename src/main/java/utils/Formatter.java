package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-25 11:49
 * @desc: �ַ�����ʽ���������
 *
 * һ.��������
 *   1.alignCenter() ���д�ӡ
 *   2.alignLeft()   �����ӡ
 *   3.alignRight()  ���Ҵ�ӡ
 *   4.print()       ���ݱ�ʶ��,��ʽ����ӡ
 *
 **/
@SuppressWarnings("unused")
public class Formatter {


    /************************************************************
     *                   ��ӡ"����,����,����"�ַ���
     ************************************************************/
    //Ĭ������ַ�
    public static final char DEFAULT_CHAR_1 = ' ';
    public static final char DEFAULT_CHAR_2 = '*';
    //Ĭ����䳤��
    public static final int DEFAULT_LENGTH = 55;

    /**
     * @Desc ���д�ӡ, ���ٵ��ô���(���ڿ���̨�ָ���ʾ���)
     * @param str ������ַ���
     * @return void
     */
    public static void printMedially(String str) {
        System.out.println(alignCenter(str, DEFAULT_CHAR_2, DEFAULT_LENGTH));
    }
    /**
     * @Desc ���д�ӡ, ���ٵ��ô���(���ڿ���̨�ָ���ʾ���)
     * @param str ������ַ���
     * @param ch ����ַ�
     * @return void
     */
    public static void printMedially(String str, char ch) {
        System.out.println(alignCenter(str, ch, DEFAULT_LENGTH));
    }

    /**
     * @Desc ���ݸ����ַ���, �������(�������ĵ���ʾ���ȱ�Ӣ�ĳ�,����
     *       �Դ����ĵ��ַ���,�������ܳ������ﵽ�Ӿ��ϵĵȳ�Ч��)
     * @param str ������ַ���
     * @param ch  ����ַ�
     * @param totalLen ������ܳ���
     * @return ������ַ���
     */
    public static String alignCenter(String str, char ch, int totalLen) {
        return selectAlignmentType(str, ch, totalLen, 1);
    }

    /**
     * @Desc ����alignCenter(), Ĭ���ַ�
     * @param str ������ַ���
     * @param totalLen ������ܳ���
     * @return ������ַ���
     */
    public static String alignCenter(String str, int totalLen) {
        return alignCenter(str, DEFAULT_CHAR_1, totalLen);
    }

    /**
     * @Desc ����alignCenter(), Ĭ�ϳ���
     * @param str ������ַ���
     * @param ch ����ַ�
     * @return ������ַ���
     */
    public static String alignCenter(String str, char ch) {
        return alignCenter(str, ch, DEFAULT_LENGTH);
    }

    /**
     * @Desc ����alignCenter(), Ĭ���ַ�������
     * @param str ������ַ���
     * @return ������ַ���
     */
    public static String alignCenter(String str) {
        return alignCenter(str, DEFAULT_CHAR_1, DEFAULT_LENGTH);
    }

    /**
     * @Desc ���ݸ����ַ���, �������(�������ĵ���ʾ���ȱ�Ӣ�ĳ�,
     *       ���ԶԴ����ĵ��ַ���,�������ܳ������ﵽ�Ӿ��ϵĵȳ�Ч��)
     * @param str ������ַ���
     * @param ch  ����ַ�
     * @param totalLen ������ܳ���
     * @return ������ַ���
     */
    public static String alignLeft(String str, char ch, int totalLen) {
        return selectAlignmentType(str, ch, totalLen, 2);
    }

    /**
     * @Desc ����alignLeft(), Ĭ���ַ�
     * @param str ������ַ���
     * @param totalLen ������ܳ���
     * @return ������ַ���
     */
    public static String alignLeft(String str, int totalLen) {
        return alignLeft(str, DEFAULT_CHAR_1, totalLen);
    }

    /**
     * @Desc ����alignLeft(), Ĭ�ϳ���
     * @param str ������ַ���
     * @param ch  ����ַ�
     * @return ������ַ���
     */
    public static String alignLeft(String str, char ch) {
        return alignLeft(str, ch, DEFAULT_LENGTH);
    }

    /**
     * @Desc ����alignLeft(), Ĭ���ַ�������
     * @param str ������ַ���
     * @return ������ַ���
     */
    public static String alignLeft(String str) {
        return alignLeft(str, DEFAULT_CHAR_1, DEFAULT_LENGTH);
    }

    /**
     * @Desc ���ݸ����ַ���, �������
     * @param str ������ַ���
     * @param ch  ����ַ�
     * @param totalLen ������ܳ���
     * @return ������ַ���
     */
    public static String alignRight(String str, char ch, int totalLen) {
        return selectAlignmentType(str, ch, totalLen, 3);
    }

    /**
     * @Desc ����alignRight(), Ĭ���ַ�
     * @param str ������ַ���
     * @param totalLen ������ܳ���
     * @return ������ַ���
     */
    public static String alignRight(String str, int totalLen) {
        return alignRight(str, DEFAULT_CHAR_1, totalLen);
    }

    /**
     * @Desc ����alignRight(), Ĭ�ϳ���
     * @param str ������ַ���
     * @param ch  ����ַ�
     * @return ������ַ���
     */
    public static String alignRight(String str, char ch) {
        return alignRight(str, ch, DEFAULT_LENGTH);
    }

    /**
     * @Desc ����alignRight(), Ĭ���ַ�������
     * @param str ������ַ���
     * @return ������ַ���
     */
    public static String alignRight(String str) {
        return alignRight(str, DEFAULT_CHAR_1, DEFAULT_LENGTH);
    }

    /**
     * @Desc �ж��ַ������Ƿ��������
     * @param str ��У���ַ���
     * @return �Ƿ��������
     */
    private static boolean containChinese(String str) {
        return Pattern.compile("[\u4e00-\u9fa5]").matcher(str).find();
    }

    /**
     * @Desc ͳ���ַ������ĸ���
     * @param str ��Уͳ�Ʒ���
     * @return �ַ������ĸ���
     */
    private static int getChineseNum(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) >= '\u4e00' && str.charAt(i) <= '\u9fa5')
                count++;
        return count;
    }

    /**
     * @Desc ���С����ҡ�����ľ����㷨ʵ��
     * @param str  ������ַ���
     * @param ch   ����ַ�
     * @param totalLen �ܳ���
     * @param choice ��䷽ʽ
     *               1:����
     *               2:����
     *               3:����
     * @return ������ַ���
     */
    private static String selectAlignmentType(String str, char ch, int totalLen, int choice) {
        return "";
    }

}
