package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-25 11:49
 * @desc: 字符串格式化输出工具
 *
 * 一.方法汇总
 *   1.alignCenter() 居中打印
 *   2.alignLeft()   居左打印
 *   3.alignRight()  居右打印
 *   4.print()       根据标识符,格式化打印
 *
 **/
@SuppressWarnings("unused")
public class Formatter {


    /************************************************************
     *                   打印"居中,居右,居左"字符串
     ************************************************************/
    //默认填充字符
    public static final char DEFAULT_CHAR_1 = ' ';
    public static final char DEFAULT_CHAR_2 = '*';
    //默认填充长度
    public static final int DEFAULT_LENGTH = 55;

    /**
     * @Desc 居中打印, 简少调用代码(用于控制台分割显示结果)
     * @param str 待填充字符串
     * @return void
     */
    public static void printMedially(String str) {
        System.out.println(alignCenter(str, DEFAULT_CHAR_2, DEFAULT_LENGTH));
    }
    /**
     * @Desc 居中打印, 简少调用代码(用于控制台分割显示结果)
     * @param str 待填充字符串
     * @param ch 填充字符
     * @return void
     */
    public static void printMedially(String str, char ch) {
        System.out.println(alignCenter(str, ch, DEFAULT_LENGTH));
    }

    /**
     * @Desc 根据给定字符串, 居中填充(由于中文的显示长度比英文长,所以
     *       对带中文的字符串,会缩短总长度来达到视觉上的等长效果)
     * @param str 待填充字符串
     * @param ch  填充字符
     * @param totalLen 结果的总长度
     * @return 填充后的字符串
     */
    public static String alignCenter(String str, char ch, int totalLen) {
        return selectAlignmentType(str, ch, totalLen, 1);
    }

    /**
     * @Desc 重载alignCenter(), 默认字符
     * @param str 待填充字符串
     * @param totalLen 结果的总长度
     * @return 填充后的字符串
     */
    public static String alignCenter(String str, int totalLen) {
        return alignCenter(str, DEFAULT_CHAR_1, totalLen);
    }

    /**
     * @Desc 重载alignCenter(), 默认长度
     * @param str 待填充字符串
     * @param ch 填充字符
     * @return 填充后的字符串
     */
    public static String alignCenter(String str, char ch) {
        return alignCenter(str, ch, DEFAULT_LENGTH);
    }

    /**
     * @Desc 重载alignCenter(), 默认字符、长度
     * @param str 待填充字符串
     * @return 填充后的字符串
     */
    public static String alignCenter(String str) {
        return alignCenter(str, DEFAULT_CHAR_1, DEFAULT_LENGTH);
    }

    /**
     * @Desc 根据给定字符串, 居左填充(由于中文的显示长度比英文长,
     *       所以对带中文的字符串,会缩短总长度来达到视觉上的等长效果)
     * @param str 待填充字符串
     * @param ch  填充字符
     * @param totalLen 结果的总长度
     * @return 填充后的字符串
     */
    public static String alignLeft(String str, char ch, int totalLen) {
        return selectAlignmentType(str, ch, totalLen, 2);
    }

    /**
     * @Desc 重载alignLeft(), 默认字符
     * @param str 待填充字符串
     * @param totalLen 结果的总长度
     * @return 填充后的字符串
     */
    public static String alignLeft(String str, int totalLen) {
        return alignLeft(str, DEFAULT_CHAR_1, totalLen);
    }

    /**
     * @Desc 重载alignLeft(), 默认长度
     * @param str 待填充字符串
     * @param ch  填充字符
     * @return 填充后的字符串
     */
    public static String alignLeft(String str, char ch) {
        return alignLeft(str, ch, DEFAULT_LENGTH);
    }

    /**
     * @Desc 重载alignLeft(), 默认字符、长度
     * @param str 待填充字符串
     * @return 填充后的字符串
     */
    public static String alignLeft(String str) {
        return alignLeft(str, DEFAULT_CHAR_1, DEFAULT_LENGTH);
    }

    /**
     * @Desc 根据给定字符串, 居右填充
     * @param str 待填充字符串
     * @param ch  填充字符
     * @param totalLen 结果的总长度
     * @return 填充后的字符串
     */
    public static String alignRight(String str, char ch, int totalLen) {
        return selectAlignmentType(str, ch, totalLen, 3);
    }

    /**
     * @Desc 重载alignRight(), 默认字符
     * @param str 待填充字符串
     * @param totalLen 结果的总长度
     * @return 填充后的字符串
     */
    public static String alignRight(String str, int totalLen) {
        return alignRight(str, DEFAULT_CHAR_1, totalLen);
    }

    /**
     * @Desc 重载alignRight(), 默认长度
     * @param str 待填充字符串
     * @param ch  填充字符
     * @return 填充后的字符串
     */
    public static String alignRight(String str, char ch) {
        return alignRight(str, ch, DEFAULT_LENGTH);
    }

    /**
     * @Desc 重载alignRight(), 默认字符、长度
     * @param str 待填充字符串
     * @return 填充后的字符串
     */
    public static String alignRight(String str) {
        return alignRight(str, DEFAULT_CHAR_1, DEFAULT_LENGTH);
    }

    /**
     * @Desc 判断字符串中是否包含中文
     * @param str 待校验字符串
     * @return 是否包含中文
     */
    private static boolean containChinese(String str) {
        return Pattern.compile("[\u4e00-\u9fa5]").matcher(str).find();
    }

    /**
     * @Desc 统计字符串中文个数
     * @param str 待校统计符串
     * @return 字符串中文个数
     */
    private static int getChineseNum(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) >= '\u4e00' && str.charAt(i) <= '\u9fa5')
                count++;
        return count;
    }

    /**
     * @Desc 居中、居右、居左的具体算法实现
     * @param str  待填充字符串
     * @param ch   填充字符
     * @param totalLen 总长度
     * @param choice 填充方式
     *               1:居中
     *               2:居左
     *               3:居右
     * @return 填充后的字符串
     */
    private static String selectAlignmentType(String str, char ch, int totalLen, int choice) {
        return "";
    }

}
