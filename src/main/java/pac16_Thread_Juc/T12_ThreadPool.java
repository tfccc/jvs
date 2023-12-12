package pac16_Thread_Juc;

import bean.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;
import java.util.concurrent.*;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 20:11
 * @desc: ????
 *
 * (1)???????????
 *      1.?????------->???????????????
 *      2.??????------->???????????????(new ThreadPoolExecutor())
 *      3.??????????:
 *          (1)AbortPolicy(???????,???????): ???????????????,?????
 *          (2)CallerRunsPolicy(????????)    : ?????????????§Ö????
 *          (3)DiscardPolicy(????????)         : ?????,??????????????????,????????
 *          (4)DiscardPolicyOld(??????????)  : ?????,????????????????(????),????????
 *
 * (2)???:
 *      1.???????????
 *      2.??????????????§¹??
 *      3.???????
 *
 * (3)??????(maxPoolSize)??¦Æ??ÕÇ
 *      1.CPU?????: cpu??????? (Runtime.getRuntime().availableProcessors())
 *      2.IO?????: ?§Ø??????io???????????, ?????????????2??
 *
 *
 **/
public class T12_ThreadPool {

    public static ExecutorService orderVerifyPool = new ThreadPoolExecutor(
            4,
            4,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(1),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    /*************************************************************************
     * ??????max?????, ???????????poolSize?????, ???????waiting??
     *************************************************************************/
    public static void main(String[] args) throws InterruptedException {
        List<Future<List<Student>>> futures = new ArrayList<>();

        printThread();

        for (int i = 1; i <= 10; i++) {
            Future<List<Student>> future = orderVerifyPool.submit(() -> {
                Random random = new Random();

                int time = random.nextInt(3000) + 5000;
                System.out.println(Thread.currentThread().getName() + " -- ??? -- " + time);
                TimeUnit.MILLISECONDS.sleep(time);

                List<Student> res = new ArrayList<>();
                for (int x = 1; x <= 1000; x++) {
                    Student customer = new Student();
                    customer.setAge(1);
                    customer.setName("tfc");
                    res.add(customer);
                }
                return res;
            });
            futures.add(future);
        }

        printThread();

        for (Future<List<Student>> future : futures) {
            try {
                List<Student> tCustomers = future.get(1, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + "--" + tCustomers.size());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true);
                e.printStackTrace();
            } finally {
                System.out.println();
            }
        }

        TimeUnit.MILLISECONDS.sleep(5000);
        printThread();

        System.out.println("done...");
    }

    private static void printThread() {
        Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
        Set<Thread> threads = maps.keySet();
        System.out.println("-------------------------------------------------------------------");
        for (Thread thread : threads) {
            System.out.println(thread.getId() + " | " + thread.getName() + "|" + thread.getState());
        }
        System.out.println("-------------------------------------------------------------------");
    }


    /*****************************************************************
     *                            ?????
     *****************************************************************/
    @Test
    @DisplayName("1.1??????????")
    public void test1() throws InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        //??????????
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + (" --> task" + finalI));
            });
        }
        pool.shutdown();
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    @Test
    @DisplayName("1.2?????????????")
    public void test2() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        //?????5?????
        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + (" --> task" + finalI));
            });
        }
        pool.shutdown();
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    @Test
    @DisplayName("1.3??????(????)")
    public void test3() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + (" --> task" + finalI));
            });
        }
        pool.shutdown();
        TimeUnit.MILLISECONDS.sleep(1000);
    }


    /*****************************************************************
     *                       ??????+??????????
     *****************************************************************/
    @Test
    @DisplayName("")
    public void test4() throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                // 1.normal size
                3,
                // 2.max size
                5,
                // 3.keep-alive-time
                1,
                // 4.keep-alive-time unit
                TimeUnit.SECONDS,
                // 5.task wait queue
                new LinkedBlockingDeque<>(3),
                // 6.Ïß³Ì³Ø
                Executors.defaultThreadFactory(),
                // 7.¾Ü¾ø²ßÂÔ
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        pool.allowCoreThreadTimeOut(true);

        // 'LinkedBlockingDeque.capacity + maximumPoolSize'
        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + (" --> task" + finalI));
            });
        }
        pool.shutdown();
        TimeUnit.MILLISECONDS.sleep(2000);
    }

}
