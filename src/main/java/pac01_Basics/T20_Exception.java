package pac01_Basics;

/**
 * @author TFC
 * @date 2019��12��25�� ����12:06:26
 * @note Java�쳣����
 *
 * һ.˵��
 *     1.finally�ɲ���catch,����return��ִ�����
 *     2.throws���쳣�׸�������,catch���쳣���ڲ����д���
 *
 * ��.�쳣����:
 *     1.checkedException  :���﷨���,����ʱ��Ҫ����,�����޷�ͨ��
 *     2.unCheckedException:��������ͨ������,������ʱ���ܻ�����쳣
 *
 */
public class T20_Exception {
    //ѡ����
    private static int aMethod(int i) throws Exception {
        try {
            int a = 10 / i;
            return a;
        } catch (java.lang.Exception ex) {
            throw new java.lang.Exception(" exception in a Method, ");
        } finally {
            System.out.printf(" finally, ");
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        try {
            aMethod(0);
        } catch (java.lang.Exception ex) {
            System.out.println(" exception in a Main, ");
            //throw new Exception(" exception in a Main, ");
        }
        System.out.printf(" finished, ");
    }
}