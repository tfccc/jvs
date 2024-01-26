package pac16_Thread_Juc;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author Frank.Tang
 * @date 2024-01-18 15:17
 * @desc 验证线程池的等待队列可以超时吗?
 **/
public class T12_ThreadPool_IsQueueTimeable {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                // 1.normal size
                2,
                // 2.max size
                2,
                // 3.keep-alive-time
                0,
                // 4.keep-alive-time unit
                TimeUnit.SECONDS,
                // 5.task wait queue
                new LinkedBlockingDeque<>(3),
                // 6.线程池
                Executors.defaultThreadFactory(),
                // 7.拒绝策略
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        Timer timer = new Timer(false);
        MyTaskTest myTaskTest = new MyTaskTest();
        pool.submit(() -> {
            timer.schedule(myTaskTest, 2000, 1000);
        });

    }

}

class MyTaskTest extends TimerTask{

    @Override
    public void run() {
        System.out.println("Schedule " + LocalDateTime.now());
    }

}
