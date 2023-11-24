package pac02_Advance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 21:11
 * @desc: JUnit5
 *
 * һ��˵��
 *   1.Ŀ�귽����ͨ��ָ��ע��ֱ������,����ͨ��ʵ�������������ȷ�ʽ
 *
 * ��������ע��
 *   1.@ApproveFlowDemo : ���Է���
 *      (a) expected=XXException.class (���׳��쳣�򲻲�ͨ��)
 *      (b) timeout=100 (��ʱ�򲻲�ͨ��)
 *   2.@Disabled   : �����ԵĲ��Է���,�ݲ�����
 *   3.@BeforeEach : ����ǰ����
 *   4.@AfterEach  : ���Ժ�����
 *   5.@BeforeAll  : �������������static����,���в��Կ�ʼ֮ǰ����
 *   6.@AfterAll   : �������������static����,���в��Խ���֮������
 *   7.@ParameterizedTest : ��ʾ�÷����ǲ���������
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
