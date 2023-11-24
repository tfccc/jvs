package pac01_Basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 22:46
 * @desc: ��ʽ���ַ���
 *
 * һ��˵��
 *   1.���ڴ�����ʽ�����ַ�����
 *   2.�������Ӷ���ַ�������
 *
 * ����ת����
 *   (1) %s : �ַ���
 *   (2) %c : �ַ�
 *   (3) %b : ����
 *   (4) %d : ����(10����)
 *   (5) %x : ����(16����)
 *   (6) %o : ����(8����)
 *   (7) %f : ����
 *   (8) %a : ����(16����)
 *   (9) %e : ָ��
 *   (10)%g : ͨ�ø�����(f��e�м�)
 *   (11)%% : �ٷֱ�
 *   (12)%n : ���з�
 *   (13)%tx: ������ʱ��
 *   (14)%h : ��ϣ��
 *
 * ������־
 *   (1)+  : Ϊ�������߸�����ӷ���
 *   (2)-  : �����
 *   (3)0  : ����ǰ�油0
 *   (4)" ": ������֮ǰ���ָ�������Ŀո�
 *   (5),  : �ԡ�,�������ַ���
 *   (6)(  : ʹ�����Ű�������
 *   (7)#  : ����Ǹ����������С���㣬�����16���ƻ�8���������0x��0
 *   (8)<  : ��ʽ��ǰһ��ת�����������Ĳ���
 *   (9)$  : ����ʽ���Ĳ�������
 *
 **/

public class T14_StringFormat {

    public static void main(String[] args) {
        System.out.printf("3>7�Ľ���ǣ�%b %n", 3 > 7);
        System.out.printf("100��һ���ǣ�%d%d %n", 100 / 2, 50);
        System.out.printf("100��16�������ǣ�%x %n", 100);
        String st = "100��8�������ǣ�%o %n";
        System.out.println(st);
        System.out.printf("50Ԫ�����8.5�ۿ��ǣ�%f Ԫ%n", 50 * 0.85);
    }

    /**����ת��������*/
    @Test
    public void testConversions() {
        System.out.printf("{%s}--{%s}--{%10d} %n", "A", "BSDF", -1000000);
        String str;
        str = String.format("Hi,%s", "TFC");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "TFC", "TAT", "OVO");
        System.out.println(str);
        System.out.printf("��ĸa�Ĵ�д�ǣ�%c %n", 'A');
        System.out.printf("3>7�Ľ���ǣ�%b %n", 3 > 7);
        System.out.printf("100��һ���ǣ�%d%d %n", 100 / 2, 50);
        System.out.printf("100��16�������ǣ�%x %n", 100);
        System.out.printf("100��8�������ǣ�%o %n");
        System.out.printf("50Ԫ�����8.5�ۿ��ǣ�%f Ԫ%n", 50 * 0.85);
        System.out.printf("����۸��16�������ǣ�%a %n", 50 * 0.85);
        System.out.printf("����۸��ָ����ʾ��%e %n", 50 * 0.85);
        System.out.printf("����۸��ָ���͸���������ĳ��Ƚ϶̵��ǣ�%g %n", 50 * 0.85);
        System.out.printf("������ۿ���%d%% %n", 85);
        System.out.printf("��ĸA��ɢ�����ǣ�%h %n", 'A');
    }

    /**������־����*/
    @Test
    public void testSign() {
        String str = null;
        //$ʹ��
        str = String.format("��ʽ����$��ʹ�ã�%1$d,%2$s", 99, "abc");
        System.out.println(str);
        //+ʹ��
        System.out.printf("��ʾ�������ķ��ţ�%+d��%d%n", 99, -99);
        //��Oʹ��
        System.out.printf("��ţ�ı���ǣ�%03d%n", 7);
        //�ո�ʹ��
        System.out.printf("Tab����Ч���ǣ�% 8d%n", 7);
        //.ʹ��
        System.out.printf("���������Ч���ǣ�%,d%n", 9989997);
        //�ո��С����������
        System.out.printf("һ����ļ۸��ǣ�% 20.5fԪ%n", 49.8);
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
                    throw new Exception("str.length() > totalLen: �ܳ���С���ַ�������");
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
