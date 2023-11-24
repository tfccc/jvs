package pac15_Keyword;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 15:16
 * @desc: assert 关键字(需开启IDE的断言功能)
 *
 * 一.作用
 *   1.如果断言通过,继续执行
 *   2.如果断言不通过,则抛出异常,终止执行
 *
 * 二.格式
 *   1.assert [boolean 表达式]
 *   2.assert [boolean 表达式 : 错误表达式 （日志）]
 *
 **/
public class T08_Assert {

    public static void main(String[] args) {
        format1();
        format2();
    }

    static void format1() {
        int a = 1;
        int b = 2;
        // 格式1：assert [boolean 表达式]
        assert a > b;
    }

    static void format2() {
        int a = 1;
        int b = 2;
        // 格式2：assert [boolean 表达式] : [错误表达式 （日志）]
        assert a > b : "错误，a不大于b";
    }

}
