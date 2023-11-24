package pac13_Lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 13:49
 * @desc: Lambda�﷨
 *
 * һ�������﷨
 *   1. ->   : ��ͷ������
 *   2. ��� : ���ʽ�����б�
 *   3. �Ҳ� : ���ʽִ�еĹ���
 *
 * ��������ʽ�ӿ�
 *   1.ֻ��һ�����󷽷��Ľӿ�
 *   2.Lambda��Ҫ����ʽ�ӿ�֧��
 *
 * �����﷨��ʽ
 *   1.�޲��޷���ֵ
 *      () ->
 *   2.һ������,�޷���ֵ(a�����ſ�ʡ��)
 *      (a) ->
 *   3.�л�ֵ,�������
 *      (a) -> { return; }
 *   4.�л�ֵ,һ�����
 *      (a) -> ������ֵ���
 *   5.�������Ϳɲ�д: jvm��ͨ���������Զ��ƶ�(Ҫд��д)
 *
 * �ġ��Զ���ʵ��
 *
 **/
public class T03_LambdaSyntax {

    /**********************************************************
     *                      �����﷨��ʽ
     ***********************************************************/
    /*1.�޲�,�޷���ֵ*/
    @Test
    public void test1() {
        Runnable run = (() -> System.out.println("ApproveFlowDemo Case1"));
        run.run();
    }

    /*2.һ������,�޷���ֵ*/
    @Test
    public void test2() {
        Consumer<String> com = str -> System.out.println(str);
        com.accept("ApproveFlowDemo Case2");
    }

    /*3.�з���ֵ,�������*/
    @Test
    public void test3() {
        Comparator<Integer> comp = (x, y) -> {
            System.out.println("ApproveFlowDemo Case3");
            System.out.println("ApproveFlowDemo Case3");
            return Integer.compare(x, y);
        };
    }

    /*4.�л�ֵ,һ�����*/
    @Test
    public void test4() {
        Comparator<Integer> comp = (a, b) -> Integer.compare(a, b);
        TreeSet<Integer> set = new TreeSet<>(comp);
    }

    /**********************************************************
     *                       �ġ��Զ���ʵ��
     ***********************************************************/
    @Test
    public void test5() {
        int x = 10;
        int a = doCalculation(x, (op) -> (x + 4));
        System.out.println(a);
    }

    private int doCalculation(int a, Calculator cal) {
        return cal.getNum(a);
    }
}

@FunctionalInterface
interface Calculator {
    int getNum(int a);
}


