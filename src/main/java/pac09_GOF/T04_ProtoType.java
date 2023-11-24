package pac09_GOF;

import java.util.Date;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-04 19:52
 * @note: 原型模式(克隆模式)
 *
 * 1.一般配合工厂方法模式模式使用
 * 2.以某个对象为原型，复制出新的对象，提高新建对象的效率。
 * 3.作用类似于new关键字，但不同于new。
 * 4.不会对原对象造成影响，通过克隆，再对克隆对象值进行操作。
 *
 * 模式分类：
 *     1.浅克隆(A对象在复制时引用的时同一个对象,A本身没有发生克隆,改变是相关联的)
 *     2.深克隆(出来的是一个新对象,和浅克隆相反,不会对原对象属性值造成影响,改变无关联)
 *     3.序列化和反序列化实现深克隆(IO)(及性能对比测试)
 *
 **/

public class T04_ProtoType {

    public static void main(String[] args) throws CloneNotSupportedException {
        //1.浅克隆测试
        switchCloneType(1);

        //2.深克隆测试
        //switchCloneType(2);

        //3.序列化和反序列化实现深克隆
    }

    /**
     * 方法说明：
     * choice-->1 : 运行浅克隆
     * choice-->2 : 运行深克隆
     * */
    private static void switchCloneType(int choice) throws CloneNotSupportedException {
        Date birDay = new Date(123456);
        ReferencedObj r1 = new ReferencedObj(1);
        ReferencedObj r2 = new ReferencedObj(2);
        Sheep s1 = new Sheep("sheep_proto", birDay, r1);
        System.out.println("原始对象S1:  " + s1);
        Sheep s2 = null;
        if (choice == 1) {
            s2 = (Sheep) s1.shallowClone();
        } else if (choice == 2) {
            s2 = (Sheep) s1.deepClone();
        }
        System.out.println("克隆对象S2:  " + s2 + "\n----------------------------------------------\n");

        //改变Date(浅克隆会跟随改变，因为浅克隆S2引用的是S1的Date对象)
        System.out.println("克隆后的s1.Date: " + s1.getBirDay().hashCode());
        System.out.println("克隆后的s2.Date: " + s2.getBirDay().hashCode());
        birDay.setTime(987654 * 100);
        System.out.println("<改变引用对象>");
        System.out.println("改变后的S1.Date----" + s1.getBirDay().hashCode());
        System.out.println("改变后的S2.Date----" + s2.getBirDay().hashCode() + "\n");


        //改变Referenced
        System.out.println("克隆后的s1.Referenced: " + s1.referenced.hashCode());
        System.out.println("克隆后的s2.Referenced: " + s2.referenced.hashCode());
        s1.referenced = r2;
        System.out.println("<改变引用对象>");
        System.out.println("改变后的s1.Referenced----" + s1.referenced.hashCode());
        System.out.println("改变后的s2.Referenced----" + s2.referenced.hashCode());
    }

}

//1.被克隆对象 (实现Cloneable接口的对象才能进行克隆)
class Sheep implements Cloneable {
    private String name;
    private Date birDay;
    public ReferencedObj referenced;

    Sheep(String name, Date birDay, ReferencedObj referenced) {
        this.name = name;
        this.birDay = birDay;
        this.referenced = referenced;
    }

    Date getBirDay() {
        return birDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirDay(Date birDay) {
        this.birDay = birDay;
    }

    public void printInfo() {
        System.out.println(name + "/" + birDay);
    }

    /**
     * 1.浅克隆 (直接调用Object类的clone方法)
     */
    Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 2.深克隆 (调用clone方法,同时克隆Sheep对象和Date对象)
     */
    Object deepClone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Sheep sheep = (Sheep) obj;
        sheep.birDay = (Date) this.birDay.clone();
        sheep.referenced = (ReferencedObj) this.referenced.clone();
        return sheep;
    }

}

class ReferencedObj implements Cloneable {
    String desc = "被引用对象, 用于展示不同克隆的区别";
    int target;

    ReferencedObj(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    // TODO: 2020/10/11  unresolved
    public Object clone() {
        ReferencedObj c = null;
        try {
            c = (ReferencedObj) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return c;
    }
}