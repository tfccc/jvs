package pac00_Test;

import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;
import static utils.Input.getInteger;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-10 15:23
 * @desc: 猜数游戏
 **/
public class TheSwami {
    private static String target = "";
    private static String input = "";
    private static int round = 0;

    public static String name = "frankie";

    //运行入口
    public static void main(String[] args) {
        startGame();
    }

    /**
     * @desc 运行入口
     * @return void
     */
    private static void startGame() {
        System.out.println("     猜数游戏     ");
        System.out.println("[输入1~100内的整数]");

        target = "" + (new Random().nextInt(100) + 1);

        while (!target.equals(input)) {
            input = getInteger();
            checkInput(input);
        }
        System.out.println("[输入次数:" + round
                + " , 评级:" + getRank(round) + "]");
        System.out.println(" 游戏结束 ");
    }

    /**
     * @desc 检查输入的大小、范围,并输出描述
     * @param input 待检查的输入
     * @return void
     */
    private static void checkInput(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        if (!pattern.matcher(input).matches()) {
            System.out.println("请输入正整数");
            return;
        }

        if (inRange(Integer.parseInt(input))) {
            System.out.println((Objects.equals(input, target)) ?
                    "猜对了!!!" : (Integer.parseInt(input) > Integer.parseInt(target)) ?
                    "数字太大" : "数字太小");
            round++;
        } else {
            System.out.println("请输入1~100的整数");
        }
    }

    /**
     * @desc 检查数字范围
     * @param num 待检查数
     * @return 是否在范围内
     */
    private static boolean inRange(int num) {
        return num >= 0 && num <= 100;
    }

    /**
     * @desc 根据猜数字次数计算等级
     * @param round 猜数次数
     * @return 等级(S, A, B, C)
     */
    private static String getRank(int round) {
        return (round <= 5) ?
                "S" : (round <= 7) ?
                "A" : (round <= 10) ?
                "B" : "C";
    }
}
