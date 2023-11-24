package pac09_GOF;

import java.util.Date;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-22 12:37
 * @note: 中介者模式:以公司各部门交互为例
 *
 * 一.说明
 *    1.用一个中介对象来封装一系列的对象交互，将各对象之间的网状结构分
 *      离为星型结构。即对象之间通过中介者交互。
 *    2.中介者使各对象不需要显式地相互引用，从而使其耦合松散，且可以独
 *      立地改变它们之间的交互。
 *
 * 二.角色分类：
 *   1.抽象中介者
 *   2.抽象同事类
 *   3.具体中介者
 *   4.具体同事类 (交互的对象)
 *
 * 三.实际应用：
 *   1.MVC框架
 *   2.窗口游戏程序的窗口大小
 *   3.java.lang.reflect中的Method.invoke()方法
 **/
public class T15_Mediator {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");
        User tom = new User("Tom");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
        tom.sendMessage("Hello!");
    }
}

//中介者
class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}

//同事类
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
