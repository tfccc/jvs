package pac01_Basics;

/**
 * @author TFC
 * @date 2019年6月12日 下午2:26:53
 * @note 多态（同一个方法具有多个不同表现形式）
 */
public class T03_Polymorphic {

    private static void shout(Animal a) {
        a.shout();
    }

    static class Animal {
        void shout() {
            System.out.println("动物叫");
        }

    }

    public static class Dog extends Animal {
        void shout() {
            System.out.println("狗叫");
        }
    }

    public static class Cat extends Animal {
        void shout() {
            System.out.println("猫叫");
        }
    }

    public static void main(String[] args) {
        shout(new Cat());
        shout(new Dog());
    }

}
