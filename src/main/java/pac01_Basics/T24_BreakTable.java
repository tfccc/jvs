package pac01_Basics;

import org.apache.flink.shaded.guava18.com.google.common.collect.Maps;

/**
 * @author Frank.Tang
 * @date 2024-01-12 16:40
 * @desc \r \t \n
 *
 * windows下:
 *   \r = ?
 *   \n = 回车
 *   \t = 制表
 **/
public class T24_BreakTable {

    public static void main(String[] args) {
        System.out.println("---------------");
        System.out.println("123456\rabc");
        System.out.println("---------------");
        System.out.println("123456\nabcde");
        System.out.println("---------------");
        System.out.println("123456\tabcde");
        System.out.println("---------------");
    }
}
