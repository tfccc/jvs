package pac15_Keyword;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 15:16
 * @desc: assert �ؼ���(�迪��IDE�Ķ��Թ���)
 *
 * һ.����
 *   1.�������ͨ��,����ִ��
 *   2.������Բ�ͨ��,���׳��쳣,��ִֹ��
 *
 * ��.��ʽ
 *   1.assert [boolean ���ʽ]
 *   2.assert [boolean ���ʽ : ������ʽ ����־��]
 *
 **/
public class T08_Assert {

    public static void main(String[] args) {
        format1();
        format2();
    }

    static void format1() {
        int a = 1;
        int b = 2;
        // ��ʽ1��assert [boolean ���ʽ]
        assert a > b;
    }

    static void format2() {
        int a = 1;
        int b = 2;
        // ��ʽ2��assert [boolean ���ʽ] : [������ʽ ����־��]
        assert a > b : "����a������b";
    }

}
