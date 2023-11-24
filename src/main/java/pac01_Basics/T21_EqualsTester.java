package pac01_Basics;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-16 22:54
 * @desc:
 **/
public class T21_EqualsTester {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = new String("123");

        System.out.println("hashCode");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println("address");
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        System.out.println("比较结果");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }

}