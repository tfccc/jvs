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
 * @note: 动态代理: 代理对象在运行过程中动态生成
 *
 * 实现方式/运用：
 * 1.JDK自带
 * 2.javassist字节码操作库
 * 3.CGUB
 * 4.ASM框架底层指令
 *
 **/
public class T07_Proxy_Dynamic {
    public static void main(String[] args) {
        AbstractRole star = new Star();
        StarHandler handler = new StarHandler(star);
        //动态生成代理角色类agent
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
    //o: 调用该方法的代理实例
    //method: 执行的方法
    //objects: 方法带的参数
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("***" + method.getName());
        //添加前后执行方法
        switch (method.getName()) {
            case "show":
                System.out.println("经纪人-->面谈");
                System.out.println("经纪人-->签合同");
                method.invoke(star, objects);
                System.out.println("经纪人-->收款");
                break;
            case "****":
                System.out.println("其它代理策略");
                break;
        }
        return null;
    }
}
