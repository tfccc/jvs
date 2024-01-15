package pac00_Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-06-23 19:52
 * @desc:
 **/
public class Tester {


    public static void main(String[] args) throws ParseException {
//        date();
        localDateTime();
    }

    private static void date() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date target = dateFormat.parse("2024-01-10 15:43:50");
        System.out.println("target = " + dateFormat.format(target));

        for (int i = 1; i <= 30; i++) {
            Date crt = new Date();
            if (target.equals(crt)) {
                System.out.println("crt    = " + dateFormat.format(crt) + ", match");
            } else {
                System.out.println("crt    = " + dateFormat.format(crt) + ", not match");
            }

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static void localDateTime() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime target = LocalDateTime.of(2024, 1, 10, 15, 48, 12);
        System.out.println("target = " + target);

        for (int i = 1; i <= 30; i++) {
            LocalDateTime crt = LocalDateTime.now();
            //crt = crt.withNano(0);
            if (target.equals(crt)) {
                System.out.println("crt    = " + crt + ", match");
            } else {
                System.out.println("crt    = " + crt + ", not match");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}