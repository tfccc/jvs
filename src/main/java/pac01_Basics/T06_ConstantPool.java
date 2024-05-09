package pac01_Basics;

/**
 * @author TFC
 * @date 2019年6月12日 下午11:57:33
 * @note 常量池测试（字符串比较）
 *
 * 所以:字符串比较需要用equals()方法, 而不是==
 */
public class T06_ConstantPool {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        StringBuilder s4 = new StringBuilder("123");

        //s1,s2定义后，123在常量池中引用同一个对象
        //所以两者相等
        System.out.println(s1 == s2);
        //s3 new后，新建了一个对象
        //所以两者不相等
        System.out.println(s1 == s3);

		System.out.println(s1 == s4.toString());

		System.out.println(s3 == s4.toString());

		System.out.println(s1 == s4.toString());

    }
}
