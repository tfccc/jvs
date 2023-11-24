package pac14_Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-26 12:00
 * @desc: Java8新特性: Stream的概要、创建Stream
 *
 * 一.说明及优势
 *   1.主要用于处理集合; 并行执行操作
 *   2.代码简洁; 可读性强; 简单高效
 *   3.通过简单代码可执行复杂的查找、过滤、映射数据等操作
 *
 * 二.Stream的概念
 *   1.对流对象进行一系列流水线式的操作,产生一个新的流
 *   2.集合关注数据本身,而流关注计算、处理
 *   3.Stream自己不会存储元素
 *   4.Stream不会改变原对象,而会返回一个新的,经过处理的流对象
 *   5.Stream操作是延迟执行的,它会等待终止操作,才执行
 *
 * 三.操作步骤及方法
 *   1.创建(T01_CreateStream)
 *      (a)通过Collection提供的的stream()或parallelStream()
 *      (b)通过Arrays的stream()获取数组流
 *      (c)通过Stream接口中的of方法创建
 *      (d)创建无限流
 *
 *   2.中间操作 (T02_Intermediate)
 *      (a)filter  : 传入Lambda表达式,从流中排除元素
 *      (b)limit(n): 截断流,限制流的元素数量为n
 *      (c)skip(n) : 与limit相反.跳过前n个元素,返回一个去掉了前n个元素
 *                   的流,若不足n个,则返回一个空流
 *      (d)distinct: 需重写类中hashCode()、equals(),去除重复元素
 *      (e)map     : 1.接收Lambda,将元素转换成其它形式,或提取元素信息;
 *                   2.接收一个方法作为参数,该方法,会被应用到每个元素上,
 *                   并将其映射成新的元素(类似于add(),没有合成操作)
 *      (d)flatMap : 接收一个方法作为参数,将流中每个值都转换为另一个流,
 *                   然后把所有流连接成一个流(类似于addAll()有合成操作)
 *
 *   3.终止操作(T04_Termination):当执行终止操作,才会触发中间操作
 *     (称为"惰性求值")
 *      (a)forEach()等方法
 *      (b)查找与分类
 *          1.allMatch  //是否匹配所有
 *          2.anyMatch  //至少匹配一个
 *          3.noneMatch //没有匹配元素
 *          4.findFirst //返回第一个
 *          5.findAny   //任意返回一个
 *          6.count     //元素计数
 *          7.max       //流中最大值
 *          8.min       //流中最小值
 *      (c).归约
 *          1.reduce    //将流中元素反复结合起来,得到一个值
 *      (d).收集
 *          1.collect(Collectors.toList())   //收集元素到集合中
 *          2.collect(Collectors.groupingBy) //分组
 *          3.collect(Collectors.groupingBy) //分区(满足、不满足一组)
 *          4.collect(Collectors.joining)    //连接
 *
 **/
@SuppressWarnings("all")
public class T01_CreateStream {

    @Test
    @DisplayName("1.创建的四种方法")
    public void create1() {
        //1.通过Collection提供的的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        stream1 = list.parallelStream();

        //2.通过Arrays的stream()获取数组流
        Worker[] workers = new Worker[10];
        Stream<Worker> stream2 = Arrays.stream(workers);

        //3.通过Stream接口中的of方法创建
        Stream.of("a", "b", "c", "d");

        //4.创建无限流
        //4.1 迭代方法
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(5).forEach(System.out::println);

        //4.1 generate方法
        /*Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);*/
    }

    @Test
    @DisplayName("")
    public void test2() {
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        Object[] objects = stream4.limit(5).toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    @DisplayName("")
    public void test3() {
        int[] integers = new Random()
                .ints(1,11)
                .limit(10)
                .toArray();
        for (int integer : integers) {
            System.out.println(integer);
        }
    }
}
