package pac09_GOF;

/**
 * @author TFC
 * @date 2019��8��13�� ����8:05:05
 * @note ����ģʽ
 *
 * *1.��֤һ����ֻ��һ��ʵ�������ṩһ�����ʸ�ʵ����ȫ�ַ��ʵ�
 *
 * ģʽ����:
 * 1.����ʽ
 * 2.����ʽ
 * 3.��̬�ڲ���ʽ
 * 4.ö��ʽ
 *
 * ʵ��Ӧ�ã�
 * 1.windows���������
 * 2.����վ
 * 3.��վ������
 */

public class T01_Singleton {
    public static void main(String[] args) {

    }
}

/**1.����ʽ**/
class Hungry {
    //���ʼ��ʱ�������ض���(����ʱ�̰߳�ȫ,û����ʱ����)
    private static Hungry instance = new Hungry();

    private Hungry() {
    }

    //����û��ͬ��,����Ч�ʸ�
    public static Hungry getInstance() {
        return instance;
    }
}

/**2.����ʽ**/
class Lazy {
    private volatile static Lazy instance;

    private Lazy() {
    }

    //������Ҫͬ��,��ֹͬʱ����,Ч�ʵ�
    public static synchronized Lazy getInstance() {
        if (instance == null) {
        	instance = new Lazy();
		}
        return instance;
    }
}

/**3.��̬�ڲ���(�ۺ�1.2���ŵ㣺�̰߳�ȫ,����Ч�ʸ�,ʵ�����ӳټ���)**/
class StaticInner {
    private static class Inner {
        private static final StaticInner instance = new StaticInner();
    }

    private StaticInner() {
    }

    public static StaticInner getInstance() {
        return Inner.instance;
    }
}

/**4.ö��ʽ*/
enum Enum {
    INSTANCE;

    //���ö��Ԫ�ؽ��в���
    public void operation() {
    }
}
