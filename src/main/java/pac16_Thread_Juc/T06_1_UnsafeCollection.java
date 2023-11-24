package pac16_Thread_Juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 19:41
 * @desc: ���߳���, �����Ĳ���ȫ�� (���߳��ǰ�ȫ��)
 **/
public class T06_1_UnsafeCollection {

    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>(1000);

        for (int i = 1; i <= 100; i++) {
            list1.add(new Random().nextInt(90) + 10 + "");

            String s = list1.get(i-1);
        }

        //TimeUnit.SECONDS.sleep(1);
        System.out.println("���ս��: " + list1);
        System.out.println("��С: " + list1.size());
    }

}
