package pac01_Basics;

/**
 * @author TFC
 * @date 2019��6��12�� ����11:57:33
 * @note �����ز��ԣ��ַ����Ƚϣ�
 *
 * ����:�ַ����Ƚ���Ҫ��equals()����, ������==
 */
public class T06_ConstantPool {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        StringBuilder s4 = new StringBuilder("123");

        //s1,s2�����123�ڳ�����������ͬһ������
        //�����������
        System.out.println(s1 == s2);
        //s3 new���½���һ������
        //�������߲����
        System.out.println(s1 == s3);

		System.out.println(s1 == s4.toString());

		System.out.println(s3 == s4.toString());

		System.out.println(s1 == s4.toString());

    }
}
