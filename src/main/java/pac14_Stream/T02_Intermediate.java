package pac14_Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static utils.Formatter.printMedially;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-26 13:31
 * @desc: 中间操作
 *
 * 一.操作方法
 *  筛选与切片:
 *   1.filter  : 传入Lambda表达式,从流中排除元素
 *   2.limit(n): 截断流,限制流的元素数量为n
 *   3.skip(n) : 与limit相反.跳过前n个元素,返回一个去掉了前n个元素
 *               的流,若不足n个,则返回一个空流
 *   4.distinct: 需重写类中hashCode()、equals(),去.除重复元素
 *  映射:
 *   5.map     : (a)接收Lambda,将元素转换成其它形式,或提取元素信息;
 *               (b)接收一个方法作为参数,该方法,会被应用到每个元素上,
 *               并将其映射成新的元素(类似于add(),没有合成操作)
 *   6.flatMap : 接收一个方法作为参数,将流中每个值都转换为另一个流,
 *               然后把所有流连接从一个流(类似于addAll()有合成操作)
 *
 *
 **/
@SuppressWarnings("all")
public class T02_Intermediate {

    @Test
    @DisplayName("1.筛选与切片")
    public void screenSlice() {
        /**1.过滤**/
        printMedially("过滤");
        List<Worker> workerList = Worker.getWorkerList();
        Stream<Worker> stream1 = workerList.stream()
                .filter((w) -> {
                    System.out.println("中间操作");
                    return w.getAge() > 30;
                });
        /**终止操作:当执行终止操作,才会触发上面的中间操作
         * (称为"惰性求值")注释终止操作,则上面语句不会执行*/
        stream1.forEach(System.out::println);

        /**2.切片**/
        printMedially("过滤");
        workerList = Worker.getWorkerList();
        stream1 = workerList.stream()
                .filter((w) -> w.getAge() >= 25)
                .limit(2);
        stream1.forEach(System.out::println);

        /**3.跳过**/
        printMedially("过滤");
        workerList = Worker.getWorkerList();
        stream1 = workerList.stream()
                .filter((w) -> w.getAge() >= 25)
                .skip(2);
        stream1.forEach(System.out::println);

        /**4.去重**/
        printMedially("过滤");
        List<Integer> list = Arrays.asList(1, 1, 1, 2, 3, 4, 4, 5, 5);
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    @DisplayName("2.映射")
    public void mapping() {
        /**1.map**/
        printMedially("map:转换大写");
        List<String> list = Arrays.asList("aa", "Bb", "Cc", "dd", "EE");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        printMedially("map:提取名字");
        Worker.getWorkerList().stream()
                .map(Worker::getName)
                .limit(3)
                .forEach(System.out::println);

        printMedially("map:接收方法(生成多个流,代码较多)");
        Stream<Stream<Character>> s1 = list.stream()
                .map(T02_Intermediate::convertToChar)
                .limit(2);
        s1.forEach((stream)-> stream.forEach(System.out::println));

        /**2.flatMap**/
        printMedially("flatMap:接收方法(生成一个流,对上面的优化)");
        Stream<Character> s2 = list.stream()
                .flatMap(T02_Intermediate::convertToChar)
                .limit(4);
        s2.forEach(System.out::println);
    }

    public static Stream<Character> convertToChar(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }
}
