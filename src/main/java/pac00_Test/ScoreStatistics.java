package pac00_Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Frank.Tang
 * @date 2023-04-17 20:37
 * @desc
 **/
public class ScoreStatistics {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal oh = new BigDecimal("100");
        BigDecimal rest = new BigDecimal("100");

        List<BigDecimal> score = new ArrayList<>();
        List<BigDecimal> percent = Arrays.asList(
                new BigDecimal("80"),
                new BigDecimal("85"),
                new BigDecimal("90"),
                new BigDecimal("95"),
                oh
        );

        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                System.out.println(rest);
                BigDecimal multiply = rest.divide(oh, 10, RoundingMode.HALF_UP).multiply(percent.get(i));
                score.add(multiply);
            } else {
                BigDecimal bigDecimal = scanner.nextBigDecimal();
                rest = rest.subtract(bigDecimal);
                BigDecimal multiply = bigDecimal.divide(oh, 10, RoundingMode.HALF_UP).multiply(percent.get(i));
                score.add(multiply);
            }
        }

        BigDecimal res = score.stream()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        System.out.println(res.doubleValue());
    }
}
