package pac01_Basics;

/**
 * @author TFC
 * @date 2019��6��12�� ����2:26:53
 * @note ��̬��ͬһ���������ж����ͬ������ʽ��
 */
public class T03_Polymorphic {

    private static void shout(Animal a) {
        a.shout();
    }

    static class Animal {
        void shout() {
            System.out.println("�����");
        }

    }

    public static class Dog extends Animal {
        void shout() {
            System.out.println("����");
        }
    }

    public static class Cat extends Animal {
        void shout() {
            System.out.println("è��");
        }
    }

    public static void main(String[] args) {
        shout(new Cat());
        shout(new Dog());
    }

}
