package pac02_Advance;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import static utils.Formatter.printMedially;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 13:55
 * @desc: ForkJoin(��ֺϲ�)
 *
 * һ.ԭ��
 *   1.��һ���������õݹ���ֶ�(��鲢��������),��ֳ����̶߳���,
 *     ÿ�����з����һ��cpu��ִ��.ִ�к��ٰ�С����һһ�ϲ�,
 *   2.��ĳ�����п�ʱ(��ִ�����),�ö��л᳢��ȥ������δִ�����
 *     ���е�������. �Դ����ִ��Ч��. ����Ϊ"������ȡ"
 *
 * ��.����
 *   1.Java7��ForkJoin : ���ڱȽϸ���(�̳�RecursiveTask, ����д
 *     compute����),ʵ���õĽ���
 *   2.Java8�Ĳ����� : ��Java7��ForkJoin���иĽ�,��������(�ײ㲻��)
 *
 * ��.Ӧ��
 *   1.��������(С�����Ƽ�ʹ��)
 *   2.�����ݴ���
 *
 **/
public class T12_ForkJoin extends RecursiveTask<Long> {
    private long start;     //��ʼֵ
    private long end;       //����ֵ
    private static final long THRESHOLD = 100_0000; //�����ֵ(�Լ���ʱ����Ӱ��)
    private static long bound = 10_0000_0000L;

    /**********************************************************
     *                        ��������
     * 1.Java7�ṩ��ForkJoin���
     * 2.һ���forѭ��
     * 3.Java8�Ĳ�����(�ײ�ΪForkJoin)
     *
     ***********************************************************/
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        forkJoin_Java7();
        parallel_Java8();
        forLoop();
    }

    /** JDK7 */
    private static void forkJoin_Java7() {
        printMedially("1.ForkJoin");
        Instant a = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new T12_ForkJoin(0, bound);
        Long sum = pool.invoke(task);
        Instant b = Instant.now();
    }

    /** JDK8 */
    private static void parallel_Java8() {
        printMedially("3.Parallel");
        Instant a = Instant.now();

        long sum = LongStream.rangeClosed(0, bound)
                .parallel()
                .reduce(0, Long::sum);
        Instant b = Instant.now();
    }

    /** For Loop */
    private static void forLoop() {
        printMedially("2.For Loop");
        Instant a = Instant.now();
        long sum = 0;
        for (long i = 0; i <= bound; i++)
            sum += i;
        Instant b = Instant.now();
    }


    /*************************************************************
     *             Java7.ForkJoinʵ��1~1���ۼӺ�����д����
     *************************************************************/
    private T12_ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long len = end - start;
        if (len <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++)
                sum += i;
            return sum;
        } else {
            long middle = (start + end) / 2;
            T12_ForkJoin left = new T12_ForkJoin(start, middle);
            left.fork();
            T12_ForkJoin right = new T12_ForkJoin(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

}
