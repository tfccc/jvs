package pac15_Keyword;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-30 19:51
 * @note: strictfp�ؼ���
 *
 * 1.Ӧ�����ࡢ�ӿڻ򷽷���
 * 2.�ø���������Ӿ�ȷ��
 * 3.������Ӳ��ƽ̨���ԣ����½����һ�¡�
 * 4.float��double���ʽ������FP-strict����,����IEEE-754�淶��
 * 5.�������ࡢ����
 *
 **/
public /*strictfp*/ class T06_Strictfp {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        float f = 0.12365f;
        double d = 0.03496421d;
        double sum = f + d;
        System.out.println(sum);
    }
    private static strictfp void test2() {
        float f = 0.12365f;
        double d = 0.03496421d;
        double sum = f + d;
        System.out.println(sum);
    }

}
