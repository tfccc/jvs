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
 * @desc: �̳߳�
 *
 * (1)�̳߳ؼ���֪ʶ��
 *      1.���󷽷�------->���ִ����̳߳صķ���
 *      2.�ߴ����------->�̳߳ع�����߸�����(new ThreadPoolExecutor())
 *      3.���־ܾ�����:
 *          (1)AbortPolicy(��ֹ����,ΪĬ�ϲ���): ��������������쳣,��ִ��
 *          (2)CallerRunsPolicy(ί����ִ��)    : �����񷵻ظ�ί��ִ�е��߳�
 *          (3)DiscardPolicy(��������)         : ���ݺ�,������������������,ִ�������
 *          (4)DiscardPolicyOld(�����ɵĲ���)  : ���ݺ�,���ȶ������������(����),ִ�������
 *
 * (2)�ŵ�:
 *      1.������Դ����
 *      2.�����Ӧ�ٶȺ�����Ч��
 *      3.�������
 *
 * (3)����߳�(maxPoolSize)��ζ��涨
 *      1.CPU�ܼ���: cpu�ĺ����� (Runtime.getRuntime().availableProcessors())
 *      2.IO�ܼ���: �жϳ�����io���Ĵ���߳���, ����Ϊ��������2��
 *
 *
 **/
public class T12_TreadPool {

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
     * �̻߳Ὺ��max���߳�, ����ɺ�ֻ�ᱣ��poolSize���߳�, ���ǻᴦ��waiting״̬
     *************************************************************************/
    public static void main(String[] args) throws InterruptedException {
        List<Future<List<Student>>> futures = new ArrayList<>();

        printThread();

        for (int i = 1; i <= 10; i++) {
            Future<List<Student>> future = orderVerifyPool.submit(() -> {
                Random random = new Random();

                int time = random.nextInt(3000) + 5000;
                System.out.println(Thread.currentThread().getName() + " -- ˯�� -- " + time);
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
     *                            ���󷽷�
     *****************************************************************/
    @Test
    @DisplayName("1.1���̵߳��̳߳�")
    public void test1() throws InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        //����һ���߳�
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
    @DisplayName("1.2�̶��������̳߳�")
    public void test2() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        //ͬʱ���5���߳�
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
    @DisplayName("1.3������(����)")
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
     *                       �ߴ����+���־ܾ�����
     *****************************************************************/
    @Test
    @DisplayName("")
    public void test4() throws InterruptedException {
        // �Ƽ�ʹ��new ThreadPoolExecutor()�����̳߳�
        ExecutorService pool = new ThreadPoolExecutor(
                // 1.����״̬�¿���������
                3,
                // 2.��󿪷�����(��󲢷�)
                5,
                // 3.�ȴ�ʱ��(�������е�)
                1,
                // 4.ʱ�䵥λ
                TimeUnit.SECONDS,
                // 5.�ȴ����е�����
                new LinkedBlockingDeque<>(3),
                // 6.�̳߳ع���
                Executors.defaultThreadFactory(),
                // 7.�ܾ�����(�ﵽ������ִ��)
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        // �˴����ɳ���'LinkedBlockingDeque.capacity + maximumPoolSize'
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
