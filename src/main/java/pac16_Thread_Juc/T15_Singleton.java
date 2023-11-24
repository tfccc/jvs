package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 13:47
 * @desc: ����ģʽ
 **/
public class T15_Singleton {

    public static void main(String[] args) throws InterruptedException {
        //���̴߳�������������
        //singleThreadCreate();
        //���̴߳���lazy�ᴴ������
        multiThreadCreate();
    }

    //���̴߳���
    static void singleThreadCreate() {
        for (int i = 1; i <= 50; i++) {
            Lazy.getInstance();
            Hungry.getInstance();
            StaticInnerClass.getInstance();
            Enum.getInstance();
        }
    }

    //���̴߳���
    static void multiThreadCreate() {

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                Lazy.getInstance();
                Hungry.getInstance();
                StaticInnerClass.getInstance();
                Enum.getInstance();
            }).start();
        }
    }

}


//1.����ʽ(����ʱ�̰߳�ȫ,û����ʱ����)
class Hungry {

    private Hungry() {
        System.out.println(Thread.currentThread().getName() +
                " -- new hungry");
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }
}

//2.����ʽ
class Lazy {
    private Lazy() {
        System.out.println(Thread.currentThread().getName() +
                " -- new lazy");
    }

    /**
     * ��ֹ���������ָ������(���˳��123��Ϊ132��������)
     * 1.�����ڴ�
     * 2.ִ�й��췽��
     * 3.����ָ��ÿռ�
     */
    private volatile static Lazy lazy;

    //DCL(double checked locking): �������,˫�ؼ��
    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }
}


//3.��̬�ڲ���
class StaticInnerClass {

    private StaticInnerClass() {
        System.out.println(Thread.currentThread().getName() +
                " -- new staticInnerClass");
    }

    public static StaticInnerClass getInstance() {
        return Inner.instance;
    }

    public static class Inner {

        private Inner() {
            System.out.println(Thread.currentThread().getName() +
                    " -- new Inner");
        }

        private static final StaticInnerClass instance = new StaticInnerClass();
    }
}


//4.ö��(�ȫ, �޷�ͨ�������ƽ�)
class Enum {
    //˽�л����캯��
    private Enum() {
    }

    //����һ���ڲ�ö����
    enum SingletonEnum {
        //����һ��ö�ٶ��󣬸ö�������Ϊ����
        INSTANCE;

        private Enum anEnum;
        //ö�ٵĹ��캯��(Ĭ��Ϊ˽��)
        SingletonEnum() {
            anEnum = new Enum();
            System.out.println(Thread.currentThread().getName() +
                    " -- new enum");
        }

        public Enum getInstance() {
            return anEnum;
        }
    }

    //���Ⱪ¶һ����ȡUser����ľ�̬����
    public static Enum getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}

