package pac01_Basics;

/**
 * @author TFC
 * @date 2019��6��15�� ����11:26:42
 * @note ����
 *
 * һ.˵��
 *   1.����ú���ʵ������ʱ����Ҫָ�����ͣ��ٲ���
 *   2.���ַ������Ա������ʱ����Ҫת�͵����⡣����ʹ��
 *
 * ��.�������:
 *   1.<? extends T> : �ü����д�Ķ�������T������,����T�Լ���
 *   2.<? super T>   : �ü����д�Ķ�������T�ĸ���,����T�Լ���
 *
 */
//����õ�һ��������
public class T17_Generic<G> {

    Object object[] = new Object[10];

    public void setData(G g, int index) {
        object[index] = g;
    }

    public G getData(int index) {
        return (G) object[index];

    }

    public static void main(String[] args) {

        T17_Generic<String> str = new T17_Generic<>();
        str.setData("�ַ���123", 0);
        System.out.println(str.getData(0));

        T17_Generic<Integer> str2 = new T17_Generic<>();
        str2.setData(123, 0);
        System.out.println(str2.getData(0));
    }

    public <A,B,C,W> void test(A a, B b){

	}


}
