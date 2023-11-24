package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 19:35
 * @note: �Ž�ģʽ
 **/
public class S_Bridge {
    public static void main(String[] args) {
        Computer HP_DeskTop = new DeskTop(new HuiPu());
        HP_DeskTop.Info();

        Computer Le_LapTop = new LapTop(new Lenovo());
        Le_LapTop.Info();
    }
}

interface Brand {
    void printInfo();
}

class HuiPu implements Brand {
    @Override
    public void printInfo() {
        System.out.println("Ʒ�ƣ�����");
    }
}
class Lenovo implements Brand {
    @Override
    public void printInfo() {
        System.out.println("Ʒ�ƣ�����");
    }
}

class Computer {
    Brand brand;
    String type;

    Computer(Brand brand) {
        this.brand = brand;
    }
    void Info() {
        brand.printInfo();
        System.out.println(this.type);
    }

}

class DeskTop extends Computer {

    DeskTop(Brand brand) {
        super(brand);
        this.type = "̨ʽ����";
    }
    public void printInfo() {
        super.Info();
    }
}

class LapTop extends Computer {

    LapTop(Brand brand) {
        super(brand);
        this.type = "�ʼǱ�����";
    }
    public void printInfo() {
        super.Info();
    }
}