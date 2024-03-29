package pac00_Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-06-23 19:52
 * @desc:
 **/
public class Tester {


    public static void main(String[] args) throws ParseException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                // 1.normal size
                3,
                // 2.max size
                5,
                // 3.keep-alive-time
                10,
                // 4.keep-alive-time unit
                TimeUnit.SECONDS,
                // 5.task wait queue
                new LinkedBlockingDeque<>(1),
                // 6.线程池
                Executors.defaultThreadFactory(),
                // 7.拒绝策略
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
    }

    /**
     * 某几个日期在同一周内 -- true
     * 日期均不在同一周 ----- false
     */
    private static boolean datesInSameWeek(List<Date> dateList) {
        Set<Long> weekDuplicateCheck = new HashSet<>();
        for (Date date : dateList) {
            weekDuplicateCheck.add((date.getTime() - 316800000) / 604800000);
        }
        return dateList.size() != weekDuplicateCheck.size();
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