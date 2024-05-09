package pac00_Test;

import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;
import static utils.Input.getInteger;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-10 15:23
 * @desc: ������Ϸ
 **/
public class TheSwami {
    private static String target = "";
    private static String input = "";
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
        System.out.println("     ������Ϸ     ");
        System.out.println("[����1~100�ڵ�����]");

        target = "" + (new Random().nextInt(100) + 1);

        while (!target.equals(input)) {
            input = getInteger();
            checkInput(input);
        }
        System.out.println("[�������:" + round
                + " , ����:" + getRank(round) + "]");
        System.out.println(" ��Ϸ���� ");
    }

    /**
     * @desc �������Ĵ�С����Χ,���������
     * @param input ����������
     * @return void
     */
    private static void checkInput(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        if (!pattern.matcher(input).matches()) {
            System.out.println("������������");
            return;
        }

        if (inRange(Integer.parseInt(input))) {
            System.out.println((Objects.equals(input, target)) ?
                    "�¶���!!!" : (Integer.parseInt(input) > Integer.parseInt(target)) ?
                    "����̫��" : "����̫С");
            round++;
        } else {
            System.out.println("������1~100������");
        }
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
        return (round <= 5) ?
                "S" : (round <= 7) ?
                "A" : (round <= 10) ?
                "B" : "C";
    }
}
