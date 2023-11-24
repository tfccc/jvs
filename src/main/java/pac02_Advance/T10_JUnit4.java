package pac02_Advance;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-23 21:17
 * @desc: JUnit4
 *
 * 一、说明
 *   1.目标方法可通过指定注解直接运行,而不通过实例化、主函数等方式
 *   2.方法权限只能是public，不能用static修饰
 *
 * 二、常用注解
 *   1.@ApproveFlowDemo: 测试方法
 *      (a) expected=XXException.class (不抛出异常则不不通过)
 *      (b) timeout=100 (超时则不不通过)
 *   2.@Ignore: 被忽略的测试方法,暂不运行
 *   3.@Before: 测试前运行
 *   4.@After : 测试后运行
 *   5.@BeforeClass: 方法必须必须是static声明,所有测试开始之前运行
 *   6.@AfterClass : 方法必须必须是static声明,所有测试结束之后运行
 *   7.@Parameters : 表示该方法是参数化测试
 *
 **/
public class T10_JUnit4 {
    public static void main(String[] args) {
        System.out.println("主方法");
    }

    /**1.在Test之前执行*/
    @Before
    public void before() {
        System.out.println("before");
    }

    /**2.一个Test Case*/
    @Test
    public void test1() {
        System.out.println("test1");
    }

    /**3.另一个Test Case*/
    @Test
    public void test2() {
        System.out.println("test2");
    }

    /**4.在Test之后执行*/
    @After
    public void after() {
        System.out.println("after");
    }
}
