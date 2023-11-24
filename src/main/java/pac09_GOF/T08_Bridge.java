package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-07 19:00
 * @note: 桥接模式
 *
 * 1.继承式关系模式，以电脑品牌的分类为例：每次增加产品族，需要在每
 * 一个产品族下依次增加，扩展性、复用性较复杂，违反单一职责原则。
 *
 * 2.桥接模式,即从原本的以继承为主（类家谱图）的关系，转变为多维关系
 * （以电脑为例:类型维度（ 台式、笔记本..），品牌维度（联想、戴尔..）
 * 分开），使用时将目标维度关联起来。
 *
 **/
public class T08_Bridge {
    public static void main(String[] args) {
        //1.继承关系
        HP1.HPDesktop1 hpDesktop=new HP1.HPDesktop1();
        hpDesktop.info();

        //2.桥接模式(桥接品牌对象，产品族对象)
        ComputerType computer = new Laptop(new Lenovo());
        computer.printInfo();
        ComputerType computer2 = new DeskTop(new HP());
        computer2.printInfo();
        DeskTop deskTop = new DeskTop(new Lenovo());
        deskTop.printInfo();
    }
}


/**
 * 1.继承式关系
 * */
interface Computer {
    void info();
}

class Desktop1 implements Computer {
    @Override
    public void info() {
        System.out.println("1.台式电脑");
    }
}
class Laptop1 implements Computer {
    @Override
    public void info() {
        System.out.println("2.笔记本电脑");
    }
}
class Pad1 implements Computer {
    @Override
    public void info() {
        System.out.println("3.平板电脑");
    }
}

//1.联想产品
class Lenovo1 {
    static class LenovoDesktop1 extends Desktop1 {
        @Override
        public void info() {
            System.out.println("1.1联想台式电脑");
        }
    }

    static class LenovoLaptop1 extends Laptop1 {
        @Override
        public void info() {
            System.out.println("2.1联想台式电脑");
        }
    }

    static class LenovoPad1 extends Pad1 {
        @Override
        public void info() {
            System.out.println("3.1联想平板电脑");
        }
    }
}
//2.惠普产品
class HP1 {
    static class HPDesktop1 extends Desktop1 {
        @Override
        public void info() {
            System.out.println("1.2惠普台式电脑");
        }
    }

    static class HPLaptop1 extends Laptop1 {
        @Override
        public void info() {
            System.out.println("2.2惠普笔记本电脑");
        }
    }

    static class HPPad1 extends Pad1 {
        @Override
        public void info() {
            System.out.println("3.2惠普平板电脑");
        }
    }
}
//3.戴尔产品
class Dell1 {
    static class DellDesktop1 extends Desktop1 {
        @Override
        public void info() {
            System.out.println("1.3戴尔台式电脑");
        }
    }

    static class DellLaptop1 extends Laptop1 {
        @Override
        public void info() {
            System.out.println("2.3戴尔笔记本电脑");
        }
    }

    static class DellPad1 extends Pad1 {
        @Override
        public void info() {
            System.out.println("3.3戴尔平板电脑");
        }
    }
}


/**
 * 2.桥接模式
 * */
//品牌
interface Brand {
    void info();
}

class Lenovo implements Brand {
    @Override
    public void info() {
        System.out.print("品牌:联想");
    }
}

class HP implements Brand {
    @Override
    public void info() {
        System.out.print("品牌:惠普");
    }
}

class Dell implements Brand {
    @Override
    public void info() {
        System.out.print("品牌:戴尔");
    }
}

//产品类型
class ComputerType {
    private Brand brand;

    ComputerType(Brand brand) {
        this.brand = brand;
    }

    void printInfo() {
        System.out.println("电脑信息如下:");
        brand.info();
    }
}

class DeskTop extends ComputerType {
    public DeskTop(Brand brand) {
        super(brand);
    }

    void printInfo() {
        super.printInfo();
        System.out.println("类型:台式电脑");
    }
}

class Laptop extends ComputerType {
    Laptop(Brand brand) {
        super(brand);
    }

    void printInfo() {
        super.printInfo();
        System.out.println(",  类型:笔记本电脑");
    }
}
