package pac09_GOF;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-06 10:16
 * @note: ��̬����: ������������й����ж�̬����
 *
 * ʵ�ַ�ʽ/���ã�
 * 1.JDK�Դ�
 * 2.javassist�ֽ��������
 * 3.CGUB
 * 4.ASM��ܵײ�ָ��
 *
 **/
public class T07_Proxy_Dynamic {
    public static void main(String[] args) {
        AbstractRole star = new Star();
        StarHandler handler = new StarHandler(star);
        //��̬���ɴ����ɫ��agent
        AbstractRole agent = (AbstractRole) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{AbstractRole.class},
                handler
        );
        agent.show();
    }
}

class StarHandler implements InvocationHandler {
    private AbstractRole star;

    StarHandler(AbstractRole star) {
        this.star = star;
    }

    @Override
    //o: ���ø÷����Ĵ���ʵ��
    //method: ִ�еķ���
    //objects: �������Ĳ���
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("***" + method.getName());
        //���ǰ��ִ�з���
        switch (method.getName()) {
            case "show":
                System.out.println("������-->��̸");
                System.out.println("������-->ǩ��ͬ");
                method.invoke(star, objects);
                System.out.println("������-->�տ�");
                break;
            case "****":
                System.out.println("�����������");
                break;
        }
        return null;
    }
}
