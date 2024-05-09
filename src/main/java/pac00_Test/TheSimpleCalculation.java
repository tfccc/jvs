package pac00_Test;

import utils.Input;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author Frank.Tang
 * @date 2024-05-09 17:08
 * @desc �Ӽ���������Ϸ
 **/
public class TheSimpleCalculation {

    private static Pattern PATTERN_NUMBER = Pattern.compile("[-+]?\\d+");

    public static String name = "frankie";

    private static final String[] OPERATIONAL_SYMBOL = new String[]{
            "+",
            "-"
    };

    //�������
    public static void main(String[] args) {
        startGame();
    }

    /**
     * @desc �������
     * @return void
     */
    private static void startGame() {
        System.out.println("---------������Ŀ�����������---------");

        int problemCount = 10;
        int correctCount = 0;
        int incorrectCount = 0;
        long sTime = System.currentTimeMillis();
        List<Integer> incorrectIndex = new ArrayList<>();

        // ��֤5���ӷ���5������
        int subCount = 0;
        int addCount = 0;
        int countLimit = problemCount / 2;

        // n����Ŀ
        for (int i = 1; i <= problemCount; i++) {
            int random1 = new Random().nextInt(100) + 1;
            int random2 = new Random().nextInt(100) + 1;
            int osIndex = new Random().nextInt(OPERATIONAL_SYMBOL.length);
            String os = OPERATIONAL_SYMBOL[osIndex];

            // ������ȷ���
            int res;
            if (os.equals("+")) {
                // ת����
                if (addCount >= countLimit) {
                    res = random1 - random2;
                    os = "-";
                    subCount++;
                }
                // �ӷ�
                else {
                    res = random1 + random2;
                    addCount++;
                }
            } else {
                // ת�ӷ�
                if (subCount >= countLimit) {
                    res = random1 + random2;
                    os = "+";
                    addCount++;
                }
                // ����
                else {
                    res = random1 - random2;
                    subCount++;
                }
            }

            // �����Ŀ
            System.out.print(random1 + " " + os + " " + random2 + " = ");

            // ��ȡ����ֵ
            String input = Input.getStr();
            // ����У�飬ֻ����������
            checkInput(input);

            // �ж�����ֵ��ȷ?
            if (res == Integer.parseInt(input)) {
                correctCount++;
            } else {
                incorrectIndex.add(i);
                incorrectCount++;
            }
        }
        long eTime = System.currentTimeMillis();
        BigDecimal bigDecimal = new BigDecimal(eTime - sTime);
        String second = bigDecimal.divide(new BigDecimal("1000"), 3, RoundingMode.DOWN).toPlainString();

        if (!incorrectIndex.isEmpty()) {
            System.out.printf("���%s����Ŀ, ���%s����Ŀ, ��ʱ%s��\n", correctCount, incorrectCount, second);
            System.out.println("�������Ŀ: " + incorrectIndex);
        } else {
            System.out.printf("������Ŀȫ��, ��ʱ%s��\n", second);
        }
        System.out.println("--------------��Ϸ����--------------");
    }

    /**
     * @desc �������Ĵ�С����Χ,���������
     * @param input ����������
     * @return void
     */
    private static void checkInput(String input) {
        if (!PATTERN_NUMBER.matcher(input).matches()) {
            System.out.println("������������");
        }
    }

}
