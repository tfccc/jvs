package pac11_JDBC;

import java.util.Random;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-11-06 20:43
 * @desc:
 **/
public class SqlPractice {
    static Random random = new Random();

    public static void main(String[] args) {
        genRandomScore();
    }


    static void genRandomStudentID() {
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 1; i <= 20; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 1; j <= 6; j++) {
                int randomIndex = random.nextInt(10);
                char randomChar = nums[randomIndex];
                res.append(randomChar);
            }
            System.out.println(res.toString());
        }
    }


    static void genRandomScore() {
        for (int j = 1; j <= 100; j++) {
            int score = random.nextInt(60) + 40;
            System.out.println(score);
        }
    }

}
