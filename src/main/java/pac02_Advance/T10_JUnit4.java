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
 * һ��˵��
 *   1.Ŀ�귽����ͨ��ָ��ע��ֱ������,����ͨ��ʵ�������������ȷ�ʽ
 *   2.����Ȩ��ֻ����public��������static����
 *
 * ��������ע��
 *   1.@ApproveFlowDemo: ���Է���
 *      (a) expected=XXException.class (���׳��쳣�򲻲�ͨ��)
 *      (b) timeout=100 (��ʱ�򲻲�ͨ��)
 *   2.@Ignore: �����ԵĲ��Է���,�ݲ�����
 *   3.@Before: ����ǰ����
 *   4.@After : ���Ժ�����
 *   5.@BeforeClass: �������������static����,���в��Կ�ʼ֮ǰ����
 *   6.@AfterClass : �������������static����,���в��Խ���֮������
 *   7.@Parameters : ��ʾ�÷����ǲ���������
 *
 **/
public class T10_JUnit4 {
    public static void main(String[] args) {
        System.out.println("������");
    }

    /**1.��Test֮ǰִ��*/
    @Before
    public void before() {
        System.out.println("before");
    }

    /**2.һ��Test Case*/
    @Test
    public void test1() {
        System.out.println("test1");
    }

    /**3.��һ��Test Case*/
    @Test
    public void test2() {
        System.out.println("test2");
    }

    /**4.��Test֮��ִ��*/
    @After
    public void after() {
        System.out.println("after");
    }
}
