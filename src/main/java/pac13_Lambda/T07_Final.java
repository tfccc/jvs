package pac13_Lambda;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 21:33
 * @desc: ���ڱ�������ʱ��final����
 *
 *
 * ʵ���ϱ������ڲ���Ĺ��췽�������棬���˶�Ӧ���ⲿ������ú����оֲ�������
 * �βΡ��������ⲿ�෽��ִ�����ֲ������������������ڲ��๹�캯���еľֲ�����
 * ʵ����һ�ݡ����ơ�����Ϊ�˷����ⲿ���е�˽�г�Ա�������ⲿ������Ҳ�����˷���
 * ������getX()�ķ�������
 *
 * ����ֲ���������Ϊfinal���ڲ��๹����Ϻ��ⲿ��ľֲ������ָı���,�����
 * һ����һ�µ����⡣
 *
 **/
public class T07_Final {

    public static void main(String[] args) {
        new Out().test("hi");
    }

}

class Out {

    /**
    * �������:
     * 1.final����, �Դ˿���һ�ݱ���(�����޸�ʱ����Ӱ��)
     * 2.�����в����ظ�ֵ��������
     *
    * */
    public void test(String a) {

        class In {
            public void function() {
                System.out.println(a);
            }
        }
        // Error:(19, 36)
        // java: ���ڲ������õı��ر������������ձ���,��ʵ���ϵ����ձ���
        // ע�ʹ����򲻻ᱨ��
        //a = "hello";
        new In().function();
    }

}