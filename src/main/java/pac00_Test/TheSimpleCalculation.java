package pac00_Test;

import utils.Input;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @author Frank.Tang
 * @date 2024-05-09 17:08
 * @desc 加减法运算游戏
 **/
public class TheSimpleCalculation {

    private static final Pattern PATTERN_NUMBER = Pattern.compile("[-+]?\\d+");

    public static String name = "frankie";

    private static final String[] OPERATIONAL_SYMBOL = new String[]{
            "+",
            "-"
    };

    //运行入口
    public static void main(String[] args) {
        onlyAdd();
        System.out.println("5秒后下一个......");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addAndSub();
    }

    /** 纯加法 **/
    private static void onlyAdd() {
        System.out.println("---------根据题目，输入计算结果---------");

        int range = 100;
        int problemCount = 10   ;
        int correctCount = 0;
        int incorrectCount = 0;
        long sTime = System.currentTimeMillis();
        List<Integer> incorrectIndex = new ArrayList<>();

        // n道题目
        Random random = new Random();
        for (int i = 1; i <= problemCount; i++) {
            int random1 = random.nextInt(range) + 1;
            int random2 = random.nextInt(range) + 1;
            String os = OPERATIONAL_SYMBOL[0];

            // 计算正确结果
            int res = random1 + random2;

            // 输出题目
            System.out.print(random1 + " " + os + " " + random2 + " = ");

            // 获取输入值
            String input = Input.getStr();
            // 输入校验，只能输入整数
            if (!checkInput(input)) {
                System.out.println("请输入整数");
            }

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
            System.out.println("错误的题目序号: " + incorrectIndex);
        } else {
            System.out.printf("所有题目全对, 耗时%s秒\n", second);
        }
        System.out.println("----------------结束----------------");
    }

    /** 加减混合 **/
    private static void addAndSub() {
        System.out.println("---------根据题目，输入计算结果---------");

        int range = 100;
        int problemCount = 10   ;
        int correctCount = 0;
        int incorrectCount = 0;
        long sTime = System.currentTimeMillis();
        List<Integer> incorrectIndex = new ArrayList<>();

        // 保证5道加法，5道减法
        int subCount = 0;
        int addCount = 0;
        int countLimit = problemCount / 2;

        String appOP = OPERATIONAL_SYMBOL[0];
        String subOP = OPERATIONAL_SYMBOL[1];

        // n道题目
        Random random = new Random();
        for (int i = 1; i <= problemCount; i++) {
            int random1 = random.nextInt(range) + 1;
            int random2 = random.nextInt(range) + 1;
            int osIndex = random.nextInt(OPERATIONAL_SYMBOL.length);
            String os = OPERATIONAL_SYMBOL[osIndex];

            // 计算正确结果
            int res;
            if (os.equals(appOP)) {
                // 转减法
                if (addCount >= countLimit) {
                    res = random1 - random2;
                    os = subOP;
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
                    os = appOP;
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
            if (!checkInput(input)) {
                System.out.println("请输入整数");
            }

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
            System.out.println("错误的题目序号: " + incorrectIndex);
        } else {
            System.out.printf("所有题目全对, 耗时%s秒\n", second);
        }
        System.out.println("----------------结束----------------");
    }

    /**
     * @desc 检查输入的大小、范围,并输出描述
     * @param input 待检查的输入
     * @return void
     */
    private static boolean checkInput(String input) {
        if (!PATTERN_NUMBER.matcher(input).matches()) {
            System.out.println("请输入正整数");
            return false;
        }
        return true;
    }

}
