package pac09_GOF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-20 14:00
 * @note: 迭代器模式(AKA : 游标模式)
 *
 * 角色分类(数据结构)：
 *   1.聚合类：存储数据 (实际的 map、set、list等容器对象)
 *   2.抽象迭代器
 *   3.具体迭代器：遍历数据 (一般定义为内部类，可共享聚合类的属性)
 *
 * 实际应用：
 *   1.Java等语言自带的迭代器
 *
 **/
public class T14_Iterator {
    public static void main(String[] args) {
        Aggregate ag = new Aggregate();
        ag.add(1);
        ag.add("a");
        ag.add(2);
        ag.add("b");
        ag.add(3);
        ag.add("c");

        AbsIterator iter = ag.createIterator();
        while (iter.hasNext()) {
            System.out.println(iter.getCurrentObj());
            iter.next();
        }
    }
}

//1.自定义聚合类(例如Map、Set、List等容器对象)
class Aggregate {
    private List<Object> list = new ArrayList<>();

    Aggregate() {
    }

    public Aggregate(List<Object> list) {
        super();
        this.list = list;
    }

    public List<Object> getList() { return list; }
    public void setList(List<Object> list) { this.list = list; }
    public void add(Object obj) { this.list.add(obj); }
    public void remove(Object obj) { this.list.remove(obj); }

    AbsIterator createIterator() { return new MyIterator(); }

    //内部类：具体迭代器类(可共享外部类属性)
    private class MyIterator implements AbsIterator {
        private int cursor;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (cursor < list.size())
                cursor++;
        }

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == (list.size() - 1);
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}

//2.迭代器接口
interface AbsIterator {
    void first();            //指向第一个元素
    void next();             //指向下一个元素
    boolean hasNext();       //是否存在下一个元素
    boolean isFirst();       //是否第一个元素
    boolean isLast();        //是否第二个元素
    Object getCurrentObj();  //获取当前游标指向的对象
}
