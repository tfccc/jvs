package pac16_Thread_Juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Frank.Tang
 * @date 2023-12-12 14:27
 * @desc
 **/
public class T12_ThreadPool0 {

    public static void main(String[] args) {
        ThreadPoolExecutor cachedPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        System.out.println(cachedPool.allowsCoreThreadTimeOut());
        System.out.println(cachedPool.getMaximumPoolSize());

    }

}
