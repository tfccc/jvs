package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-07 19:00
 * @note: �Ž�ģʽ
 *
 * 1.�̳�ʽ��ϵģʽ���Ե���Ʒ�Ƶķ���Ϊ����ÿ�����Ӳ�Ʒ�壬��Ҫ��ÿ
 * һ����Ʒ�����������ӣ���չ�ԡ������Խϸ��ӣ�Υ����һְ��ԭ��
 *
 * 2.�Ž�ģʽ,����ԭ�����Լ̳�Ϊ���������ͼ���Ĺ�ϵ��ת��Ϊ��ά��ϵ
 * ���Ե���Ϊ��:����ά�ȣ� ̨ʽ���ʼǱ�..����Ʒ��ά�ȣ����롢����..��
 * �ֿ�����ʹ��ʱ��Ŀ��ά�ȹ���������
 *
 **/
public class T08_Bridge {
    public static void main(String[] args) {
        //1.�̳й�ϵ
        HP1.HPDesktop1 hpDesktop=new HP1.HPDesktop1();
        hpDesktop.info();

        //2.�Ž�ģʽ(�Ž�Ʒ�ƶ��󣬲�Ʒ�����)
        ComputerType computer = new Laptop(new Lenovo());
        computer.printInfo();
        ComputerType computer2 = new DeskTop(new HP());
        computer2.printInfo();
        DeskTop deskTop = new DeskTop(new Lenovo());
        deskTop.printInfo();
    }
}


/**
 * 1.�̳�ʽ��ϵ
 * */
interface Computer {
    void info();
}

class Desktop1 implements Computer {
    @Override
    public void info() {
        System.out.println("1.̨ʽ����");
    }
}
class Laptop1 implements Computer {
    @Override
    public void info() {
        System.out.println("2.�ʼǱ�����");
    }
}
class Pad1 implements Computer {
    @Override
    public void info() {
        System.out.println("3.ƽ�����");
    }
}

//1.�����Ʒ
class Lenovo1 {
    static class LenovoDesktop1 extends Desktop1 {
        @Override
        public void info() {
            System.out.println("1.1����̨ʽ����");
        }
    }

    static class LenovoLaptop1 extends Laptop1 {
        @Override
        public void info() {
            System.out.println("2.1����̨ʽ����");
        }
    }

    static class LenovoPad1 extends Pad1 {
        @Override
        public void info() {
            System.out.println("3.1����ƽ�����");
        }
    }
}
//2.���ղ�Ʒ
class HP1 {
    static class HPDesktop1 extends Desktop1 {
        @Override
        public void info() {
            System.out.println("1.2����̨ʽ����");
        }
    }

    static class HPLaptop1 extends Laptop1 {
        @Override
        public void info() {
            System.out.println("2.2���ձʼǱ�����");
        }
    }

    static class HPPad1 extends Pad1 {
        @Override
        public void info() {
            System.out.println("3.2����ƽ�����");
        }
    }
}
//3.������Ʒ
class Dell1 {
    static class DellDesktop1 extends Desktop1 {
        @Override
        public void info() {
            System.out.println("1.3����̨ʽ����");
        }
    }

    static class DellLaptop1 extends Laptop1 {
        @Override
        public void info() {
            System.out.println("2.3�����ʼǱ�����");
        }
    }

    static class DellPad1 extends Pad1 {
        @Override
        public void info() {
            System.out.println("3.3����ƽ�����");
        }
    }
}


/**
 * 2.�Ž�ģʽ
 * */
//Ʒ��
interface Brand {
    void info();
}

class Lenovo implements Brand {
    @Override
    public void info() {
        System.out.print("Ʒ��:����");
    }
}

class HP implements Brand {
    @Override
    public void info() {
        System.out.print("Ʒ��:����");
    }
}

class Dell implements Brand {
    @Override
    public void info() {
        System.out.print("Ʒ��:����");
    }
}

//��Ʒ����
class ComputerType {
    private Brand brand;

    ComputerType(Brand brand) {
        this.brand = brand;
    }

    void printInfo() {
        System.out.println("������Ϣ����:");
        brand.info();
    }
}

class DeskTop extends ComputerType {
    public DeskTop(Brand brand) {
        super(brand);
    }

    void printInfo() {
        super.printInfo();
        System.out.println("����:̨ʽ����");
    }
}

class Laptop extends ComputerType {
    Laptop(Brand brand) {
        super(brand);
    }

    void printInfo() {
        super.printInfo();
        System.out.println(",  ����:�ʼǱ�����");
    }
}
