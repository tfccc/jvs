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
 * @desc 加减法运算游戏
 **/
public class TheSimpleCalculation {

    private static Pattern PATTERN_NUMBER = Pattern.compile("[-+]?\\d+");

    public static String name = "frankie";

    private static final String[] OPERATIONAL_SYMBOL = new String[]{
            "+",
            "-"
    };

    //运行入口
    public static void main(String[] args) {
        startGame();
    }

    /**
     * @desc 运行入口
     * @return void
     */
    private static void startGame() {
        System.out.println("---------根据题目，输入计算结果---------");

        int problemCount = 10;
        int correctCount = 0;
        int incorrectCount = 0;
        long sTime = System.currentTimeMillis();
        List<Integer> incorrectIndex = new ArrayList<>();

        // 保证5道加法，5道减法
        int subCount = 0;
        int addCount = 0;
        int countLimit = problemCount / 2;

        // n道题目
        for (int i = 1; i <= problemCount; i++) {
            int random1 = new Random().nextInt(100) + 1;
            int random2 = new Random().nextInt(100) + 1;
            int osIndex = new Random().nextInt(OPERATIONAL_SYMBOL.length);
            String os = OPERATIONAL_SYMBOL[osIndex];

            // 计算正确结果
            int res;
            if (os.equals("+")) {
                // 转减法
                if (addCount >= countLimit) {
                    res = random1 - random2;
                    os = "-";
                    subCount++;
                }
                // 加法
                else {
                    res = random1 + random2;
                    addCount++;
                }
            } else {
                // 转加法
                if (subCount >= countLimit) {
                    res = random1 + random2;
                    os = "+";
                    addCount++;
                }
                // 减法
                else {
                    res = random1 - random2;
                    subCount++;
                }
            }

            // 输出题目
            System.out.print(random1 + " " + os + " " + random2 + " = ");

            // 获取输入值
            String input = Input.getStr();
            // 输入校验，只能输入整数
            checkInput(input);

            // 判断输入值正确?
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
            System.out.printf("答对%s道题目, 答错%s道题目, 耗时%s秒\n", correctCount, incorrectCount, second);
            System.out.println("错误的题目: " + incorrectIndex);
        } else {
            System.out.printf("所有题目全对, 耗时%s秒\n", second);
        }
        System.out.println("--------------游戏结束--------------");
    }

    /**
     * @desc 检查输入的大小、范围,并输出描述
     * @param input 待检查的输入
     * @return void
     */
    private static void checkInput(String input) {
        if (!PATTERN_NUMBER.matcher(input).matches()) {
            System.out.println("请输入正整数");
        }
    }

}
