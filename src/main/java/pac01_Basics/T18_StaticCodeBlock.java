package pac01_Basics;

/**
 * @program: Java_Study
 * @author: TFC
 * @date: 2019-12-27 22:33
 * @note: ��̬�����
 *
 *  ִ��˳�򣺾�̬����� > �������� > ���캯�� > ��ͨ����顡
 *
 *  ����:��Ҫ���ڳ�ʼ����,�����
 *
 **/
public class T18_StaticCodeBlock {

    //��������������ִ�У������ڳ�ʼ���������ļ���
    static {
        System.out.println("1.��̬��������");
    }

    //�蹹�����飬ʵ����������Ż�ִ��
    {
        System.out.println("3.��ͨ��������");
    }

    public static void main(String[] args) {
        System.out.println("2.���������");
        T18_StaticCodeBlock scb = new T18_StaticCodeBlock();

    }

    //Constructor
    private T18_StaticCodeBlock() {
        System.out.println("4.��������ʼ������");
    }
}
