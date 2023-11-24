package utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-28 11:16
 * @desc: 从键盘读入数据
 **/
public class Input {

    /**
     * @Desc 从键盘读取任意字符串(以空格、回车等结束)
     * @return 键盘输入的字符串
     */
    public static String getStr() {
        return new Scanner(System.in).next();
    }

    /**
     * @Desc 从键盘读取任意一行字符串(回车结束)
     * @return 键盘输入的一行字符串
     */
    public static String getLine() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * @Desc 从键盘读取一行以空格分隔的字符串
     * @return 字符串数组
     */
    public static String[] getStrs() {
        return getLine().split("\\s+");
    }


    /**
     * @Desc 从键盘读取整数
     * @return 键盘输入的整数
     */
    public static int getInteger() {
        return Integer.parseInt(getStr());
    }

    /**
     * @Desc 从键盘读取一行以空格分隔的整数
     * @return 整数数组
     */
    public static int[] getIntegers() {
        String strs = getLine();
        String[] strArr = strs.split("\\s+");
        return Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
    }

}
