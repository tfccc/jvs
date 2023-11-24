package pac09_GOF;

import java.util.Date;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-22 12:37
 * @note: �н���ģʽ:�Թ�˾�����Ž���Ϊ��
 *
 * һ.˵��
 *    1.��һ���н��������װһϵ�еĶ��󽻻�����������֮�����״�ṹ��
 *      ��Ϊ���ͽṹ��������֮��ͨ���н��߽�����
 *    2.�н���ʹ��������Ҫ��ʽ���໥���ã��Ӷ�ʹ�������ɢ���ҿ��Զ�
 *      ���ظı�����֮��Ľ�����
 *
 * ��.��ɫ���ࣺ
 *   1.�����н���
 *   2.����ͬ����
 *   3.�����н���
 *   4.����ͬ���� (�����Ķ���)
 *
 * ��.ʵ��Ӧ�ã�
 *   1.MVC���
 *   2.������Ϸ����Ĵ��ڴ�С
 *   3.java.lang.reflect�е�Method.invoke()����
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

//�н���
class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}

//ͬ����
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
