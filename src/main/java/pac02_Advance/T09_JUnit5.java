package pac02_Advance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 21:11
 * @desc: JUnit5
 *
 * 一、说明
 *   1.目标方法可通过指定注解直接运行,而不通过实例化、主函数等方式
 *
 * 二、常用注解
 *   1.@ApproveFlowDemo : 测试方法
 *      (a) expected=XXException.class (不抛出异常则不不通过)
 *      (b) timeout=100 (超时则不不通过)
 *   2.@Disabled   : 被忽略的测试方法,暂不运行
 *   3.@BeforeEach : 测试前运行
 *   4.@AfterEach  : 测试后运行
 *   5.@BeforeAll  : 方法必须必须是static声明,所有测试开始之前运行
 *   6.@AfterAll   : 方法必须必须是static声明,所有测试结束之后运行
 *   7.@ParameterizedTest : 表示该方法是参数化测试
 *
 **/
public class T09_JUnit5 {

    @BeforeEach
    public void before(){
        System.out.println("beforeEach");
    }

    @Test
    public void test(){
        System.out.println("test");
    }
}
