package pac01_Basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 22:46
 * @desc: 格式化字符串
 *
 * 一、说明
 *   1.用于创建格式化的字符串以
 *   2.用于连接多个字符串对象
 *
 * 二、转换符
 *   (1) %s : 字符串
 *   (2) %c : 字符
 *   (3) %b : 布尔
 *   (4) %d : 整数(10进制)
 *   (5) %x : 整数(16进制)
 *   (6) %o : 整数(8进制)
 *   (7) %f : 浮点
 *   (8) %a : 浮点(16进制)
 *   (9) %e : 指数
 *   (10)%g : 通用浮点型(f和e中间)
 *   (11)%% : 百分比
 *   (12)%n : 换行符
 *   (13)%tx: 日期与时间
 *   (14)%h : 哈希码
 *
 * 三、标志
 *   (1)+  : 为正数或者负数添加符号
 *   (2)-  : 左对齐
 *   (3)0  : 数字前面补0
 *   (4)" ": 在整数之前添加指定数量的空格
 *   (5),  : 以“,”对数字分组
 *   (6)(  : 使用括号包含负数
 *   (7)#  : 如果是浮点数则包含小数点，如果是16进制或8进制则添加0x或0
 *   (8)<  : 格式化前一个转换符所描述的参数
 *   (9)$  : 被格式化的参数索引
 *
 **/

public class T14_StringFormat {

    public static void main(String[] args) {
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d%d %n", 100 / 2, 50);
        System.out.printf("100的16进制数是：%x %n", 100);
        String st = "100的8进制数是：%o %n";
        System.out.println(st);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
    }

    /**二、转换符测试*/
    @Test
    public void testConversions() {
        System.out.printf("{%s}--{%s}--{%10d} %n", "A", "BSDF", -1000000);
        String str;
        str = String.format("Hi,%s", "TFC");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "TFC", "TAT", "OVO");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d%d %n", 100 / 2, 50);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n");
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }

    /**三、标志测试*/
    @Test
    public void testSign() {
        String str = null;
        //$使用
        str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);
        //补O使用
        System.out.printf("最牛的编号是：%03d%n", 7);
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        //.使用
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 20.5f元%n", 49.8);
    }

    @Test
    public void alignCenter(/*String str, char ch, int totalLen*/) {

        for (int i = 0; i < 15; i++) {
            String str = "abcdef";
            char ch = '*';
            int totalLen = i+5;
            final int strLen = str.length();
            StringBuilder res = new StringBuilder();

            if (strLen > totalLen) {
                try {
                    throw new Exception("str.length() > totalLen: 总长度小于字符串长度");
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            int numLeft  = (totalLen -strLen) / 2 ;
            int numRight = totalLen - strLen - numLeft;

            /*res.append(String.valueOf(ch).repeat(numLeft))
                    .append(str)
                    .append(String.valueOf(ch).repeat(numRight));*/

            System.out.println(res.toString());
        }

    }
}
