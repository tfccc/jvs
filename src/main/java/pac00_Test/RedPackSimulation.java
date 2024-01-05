package pac00_Test;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-10-04 13:43
 * @desc:
 **/
public class RedPackSimulation {

    public static void main(String[] args) throws InterruptedException {
        RedEnvelope redEnvelope = new RedEnvelope(100.00, 20);

        for (int i = 1; i <= 30; i++) {
            new Thread(redEnvelope::grab, "P" + (i < 10 ? i + " " : i)).start();

        }

        TimeUnit.MILLISECONDS.sleep(600);
        System.out.println(redEnvelope.check);
    }
}


class RedEnvelope {
    //红包金额
    private double totalAmount;
    //红包可抢的次数
    private int number;
    public double check = 0;

    public RedEnvelope(double totalAmount, int number) {
        this.totalAmount = totalAmount;
        this.number = number;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getNumber() {
        return number;
    }

    public synchronized void grab() {
        String currentPlayer = Thread.currentThread().getName();
        if (number == 1) {
            BigDecimal b = new BigDecimal(totalAmount);
            double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println(currentPlayer + " --> 抢到了 --> " + f1);
            totalAmount = 0;
            number--;
            check += f1;
        } else if (number > 0) {
            double random = genRandomAmount();
            System.out.println(currentPlayer + " --> 抢到了 --> " + random);
            totalAmount -= random;
            number--;
            check += random;
        } else {
            System.out.println(currentPlayer + " --> 红包已抢光");
        }
    }

    // (x,y)
    private double genRandomAmount() {
        return BigDecimal.valueOf(Math.random() * (totalAmount / 2 - (number + 1) * 0.01 - 0.01) + 0.01)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
