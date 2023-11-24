package pac03_Collection;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * @author TFC
 * @date 2019年6月15日 下午12:00:49
 * @note List常用用法
 *
 * 1.查询效率高，增删改效率低，线程不安全
 * 2.添加时超过容量，通过扩容的方式实现(容量无限制)
 *
 * */
public class T02_List {

    public static void main(String[] args) {
        //t1();
        //t2();
        t3();

    }

    //List的一些方法
    private static void t2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("a");
        //重置位置元素
        list.set(2, "C");
        //list.sort(String::compareToIgnoreCase);
        //得到位置元素的值
        System.out.println("0号元素为:" + list.get(0));
        //返回查找元素的最小下标
        System.out.println("a的最小下标:" + (list.indexOf("a")));
        //返回查找元素的最大下标
        System.out.println("a的最大下标:" + list.lastIndexOf("a"));

        System.out.println(list);
    }

    //Collection中的一些方法
    public static void t1() {
        ArrayList<Integer> c = new ArrayList<>();
        //添加元素的方法
        c.add(1);
        System.out.println(c);
        //判断空
        System.out.println(c.isEmpty());
        //元素个数
        System.out.println(c.size());
        //移除元素
        c.remove(1);

        System.out.println(c);
    }

    //观察list扩容
    private static void t3() {
        List<Object> list = new ArrayList<>(50);
        for (int i = 1; i <= 30; i++) {
            list.add(1);
            printListVolume(list);
        }
        System.out.println("---------------------------");
        List<Object> vector = new Vector<>(100);
        for (int i = 1; i <= 30; i++) {
			vector.add(1);
			printListVolume(vector);
		}
    }


    @SuppressWarnings("all")
    public static void printListVolume(List<?> list) {

        Class<? extends List> strClass = list.getClass();
        Field field = null;
        try {
            field = strClass.getDeclaredField("elementData");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        Object[] elementData = null;
        try {
            elementData = (Object[]) field.get(list);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("容量: " + elementData.length +
                " --- 元素:" + list.size());
    }
}
