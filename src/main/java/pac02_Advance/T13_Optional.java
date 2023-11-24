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
 * 一.作用
 *   1.封装对象, 可锁定空指针异常
 *   2.不用显式进行空指针检测
 *
 * 二.常用用法
 *   1.of(T t) : 创建一个Optional对象
 *   2.empty() : 创建一个空的Optional对象
 *   3.ofNullable(T t): 若不为空,创建一个Optional对象,否则创建空对象
 *   4.isPresent(T t) : 是否包含值
 *   5.orElse(T t)    : 如果调用对象包含值,则返回值;否则返回t
 *   5.orElseGet(Supplier s): 如果调用对象包含值,则返回该值,否则返回
 *     s获取的值
 *   5.map(Function f): 如果有值对值处理,返回处理后的Optional,
 *     否则返回empty()
 *   6.flatMap(Function mapper): 和map类似
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
