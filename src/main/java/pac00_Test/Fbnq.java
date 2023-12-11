package pac00_Test;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-12-05 17:38
 * @desc
 **/
public class Fbnq {


    public static void main(String[] args) {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int n = 1000;

        long sTime = System.currentTimeMillis();
        System.out.println(iteration(n));
        //System.out.println(recursion(n));
        long eTime = System.currentTimeMillis();

        System.out.println("ºÄÊ±: " + (eTime - sTime) + "ms");
    }

    /** µÝ¹é */
    private static long recursion(int n) {
        if (n <= 1L) {
            return n;
        }
        long r1 = recursion(n - 1);
        long r2 = recursion(n - 2);
        return r1 + r2;
    }


    /** µü´ú */
    private static BigDecimal iteration(int n) {
        if (n <= 2) {
            return new BigDecimal(1);
        }

        BigDecimal pre = new BigDecimal(1);
        BigDecimal crt = new BigDecimal(1);

        for (int i = 1; i <= n - 2; i++) {
            BigDecimal add = crt.add(pre);
            pre = crt;
            crt = add;
        }
        return crt;
    }

}
