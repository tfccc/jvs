package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 14:22
 * @note: ����ģʽ
 **/
public class C_Singleton {
    public static void main(String[] args) {
        //1.����ʽ
        Hungry hungry = Hungry.getInstance();
        System.out.println(hungry.description);

        //2.����ʽ
        Lazy lazy = Lazy.getInstance();
        System.out.println(lazy.description);

        //3.��̬�ڲ���ʽ
        StaticInner inner = StaticInner.getInstance();
        System.out.println(inner.description);
    }
}

/**
 * 1.����ʽ
 */
class Hungry {
    String description = "1.����ʽ:��ʼ������������ʵ��;Ч�ʸ�;�̲߳���ȫ;";
    private static Hungry instance = new Hungry(); //ֱ�ӳ�

    public static Hungry getInstance() {
        return instance;
    }
}

/**
 * 2.����ʽ
 */
class Lazy {
    String description = "2.����ʽ:���򲻼���,������ض�;��Ч�ʵ�;�̰߳�ȫ;ʵ���ӳټ���";
    private static Lazy instance;

    public static synchronized Lazy getInstance() {
        if (instance == null)       //��
            instance = new Lazy();  //��
        return instance;
    }
}

/**
 * 3.��̬�ڲ���ʽ
 */
class StaticInner {
    String description = "3.��̬�ڲ���ʽ:�ۺ������ŵ�;Ч�ʸ�;�̰߳�ȫ;ʵ���ӳټ���";

    private static class InnerClass {
        //�����ʵ�����ŵ���̬�ڲ�����,������ʽ�����̰߳�ȫ,��Ч�ʸ�
        private static final StaticInner instance = new StaticInner();
    }

    public static StaticInner getInstance() {
        return InnerClass.instance;
    }
}
