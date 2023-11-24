package pac00_Test;

import utils.Formatter;
import static utils.Input.getInteger;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-10 15:23
 * @desc: ������Ϸ
 **/
public class TheSwami {
    private static int target = 60;
    private static int input = -1;
    private static int round = 0;

    public static String name = "frankie";

    //�������
    public static void main(String[] args) {
        startGame();
    }

    /**
     * @desc �������
     * @return void
     */
    private static void startGame() {
        Formatter.printMedially(" ������Ϸ ");
        Formatter.printMedially("[����0~100�ڵ�����]", ' ');

        while (input != target) {
            input = getInteger();
            checkInput(input);
        }
        Formatter.printMedially("[�������:" + round
                + " , ����:" + getRank(round) + "]", ' ');
        Formatter.printMedially(" ��Ϸ���� ");
    }

    /**
     * @desc �������Ĵ�С����Χ,���������
     * @param input ����������
     * @return void
     */
    private static void checkInput(int input) {
        round++;
        if (inRange(input))
            System.out.println((input == target) ?
                    "�¶���!!!" : (input > target) ?
                    "����̫��" : "����̫С");
        else
            System.out.println("������0~100������");
    }

    /**
     * @desc ������ַ�Χ
     * @param num �������
     * @return �Ƿ��ڷ�Χ��
     */
    private static boolean inRange(int num) {
        return num >= 0 && num <= 100;
    }

    /**
     * @desc ���ݲ����ִ�������ȼ�
     * @param round ��������
     * @return �ȼ�(S, A, B, C)
     */
    private static String getRank(int round) {
        return (round == 1) ?
                "S" : (round <= 4) ?
                "A" : (round <= 6) ?
                "B" : "C";
    }
}
