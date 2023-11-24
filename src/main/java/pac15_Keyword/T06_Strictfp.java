package pac15_Keyword;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-30 19:51
 * @note: strictfp关键字
 *
 * 1.应用于类、接口或方法。
 * 2.让浮点运算更加精确。
 * 3.不会因硬件平台特性，导致结果不一致。
 * 4.float、double表达式都遵守FP-strict限制,符合IEEE-754规范。
 * 5.可修饰类、方法
 *
 **/
public /*strictfp*/ class T06_Strictfp {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        float f = 0.12365f;
        double d = 0.03496421d;
        double sum = f + d;
        System.out.println(sum);
    }
    private static strictfp void test2() {
        float f = 0.12365f;
        double d = 0.03496421d;
        double sum = f + d;
        System.out.println(sum);
    }

}
