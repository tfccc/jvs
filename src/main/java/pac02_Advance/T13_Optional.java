package pac02_Advance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import pac13_Lambda.Worker;

import java.util.Optional;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 14:55
 * @desc: Java8 . Optional
 *
 * һ.����
 *   1.��װ����, ��������ָ���쳣
 *   2.������ʽ���п�ָ����
 *
 * ��.�����÷�
 *   1.of(T t) : ����һ��Optional����
 *   2.empty() : ����һ���յ�Optional����
 *   3.ofNullable(T t): ����Ϊ��,����һ��Optional����,���򴴽��ն���
 *   4.isPresent(T t) : �Ƿ����ֵ
 *   5.orElse(T t)    : ������ö������ֵ,�򷵻�ֵ;���򷵻�t
 *   5.orElseGet(Supplier s): ������ö������ֵ,�򷵻ظ�ֵ,���򷵻�
 *     s��ȡ��ֵ
 *   5.map(Function f): �����ֵ��ֵ����,���ش�����Optional,
 *     ���򷵻�empty()
 *   6.flatMap(Function mapper): ��map����
 *
 **/
public class T13_Optional {

    @Test
    @DisplayName("1.of(T t)")
    public void test1() {
        Optional<Worker> worker = Optional.of(new Worker());
        System.out.println(worker.get());
    }

    @Test
    @DisplayName("2.empty()")
    public void test2() {
        Optional<Worker> worker = Optional.empty();
        System.out.println(worker.get());
    }

    @Test
    @DisplayName("3.ofNullable(T t)")
    public void test3() {
        Optional<Worker> worker = Optional.ofNullable(null);
        System.out.println(worker.get());
    }

}
