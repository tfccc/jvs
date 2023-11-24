package pac00_Test;

import utils.Formatter;
import static utils.Input.getInteger;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-10 15:23
 * @desc: 猜数游戏
 **/
public class TheSwami {
    private static int target = 60;
    private static int input = -1;
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
        Formatter.printMedially(" 猜数游戏 ");
        Formatter.printMedially("[输入0~100内的整数]", ' ');

        while (input != target) {
            input = getInteger();
            checkInput(input);
        }
        Formatter.printMedially("[输入次数:" + round
                + " , 评级:" + getRank(round) + "]", ' ');
        Formatter.printMedially(" 游戏结束 ");
    }

    /**
     * @desc 检查输入的大小、范围,并输出描述
     * @param input 待检查的输入
     * @return void
     */
    private static void checkInput(int input) {
        round++;
        if (inRange(input))
            System.out.println((input == target) ?
                    "猜对了!!!" : (input > target) ?
                    "数字太大" : "数字太小");
        else
            System.out.println("请输入0~100的整数");
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
        return (round == 1) ?
                "S" : (round <= 4) ?
                "A" : (round <= 6) ?
                "B" : "C";
    }
}
