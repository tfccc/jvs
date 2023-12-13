package pac01_Basics;

/**
 * @author Frank.Tang
 * @date 2023-12-13 11:22
 * @desc 位运算符
 **/
public class T23_Bitwise {

    public static void main(String[] args) {
        //and();
        //or();
        ory();
        //left();
        //right();
    }


    /*****************************************************************
     *                             与
     *****************************************************************/
    private static void and() {
        System.out.println("------------and------------");
        int a = 6;
        int b = 10;
        System.out.println("pre a: " + a + " / " + Integer.toBinaryString(a));
        System.out.println("pre b: " + b + " / " + Integer.toBinaryString(b));

        int c = a & b;
        System.out.println("res c: " + c + " / " + Integer.toBinaryString(c));
    }

    /*****************************************************************
     *                             或
     *****************************************************************/
    private static void or() {
        System.out.println("------------or------------");
        int a = 14;
        int b = 5;
        System.out.println("pre a: " + a + " / " + Integer.toBinaryString(a));
        System.out.println("pre b: " + b + " / " + Integer.toBinaryString(b));

        int c = a | b;
        System.out.println("res c: " + c + " / " + Integer.toBinaryString(c));
    }

    /*****************************************************************
     *                    异或 (不同位->1, 同位->0)
     *****************************************************************/
    private static void ory() {
        System.out.println("------------or------------");
        int a = 14;
        int b = 5;
        System.out.println("pre a: " + a + " / " + Integer.toBinaryString(a));
        System.out.println("pre b: " + b + " / " + Integer.toBinaryString(b));

        int c = a ^ b;
        System.out.println("res c: " + c + " / " + Integer.toBinaryString(c));
    }

    /*****************************************************************
     *                           左移运算
     *****************************************************************/
    private static void left() {
        System.out.println("------------left------------");
        int a = 15;
        System.out.println("pre: " + a + " / " + Integer.toBinaryString(a));

        a = a << 9;
        System.out.println("now: " + a + " / " + Integer.toBinaryString(a));
    }

    /*****************************************************************
     *                           右移运算
     *****************************************************************/
    private static void right() {
        System.out.println("------------right------------");
        int a = 123456;
        System.out.println("pre: " + a + " / " + Integer.toBinaryString(a));

        a = a >> 4;
        System.out.println("now: " + a + " / " + Integer.toBinaryString(a));
    }

}
