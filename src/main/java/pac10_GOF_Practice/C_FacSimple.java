package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 14:05
 * @note: �򵥹���
 **/
public class C_FacSimple {
    public static void main(String[] args) {
        NewCar audi = CarFactory.createCar("�µ�");
        NewCar byd  = CarFactory.createCar("���ǵ�");
        NewCar LBGN = CarFactory.createCar("��������");

        audi.run();

    }
}

interface NewCar {
    void run();
}

class CarFactory{
    public static NewCar createCar(String name){
        switch (name) {
            case "�µ�":
                return new Cars.Audi();
            case "���ǵ�":
                return new Cars.Byd();
            case "��������":
                return new Cars.LBGN();
            default:
                return null;
        }
    }
}
class Cars{
    static class Audi implements NewCar {
        String name="�µ�";

        @Override
        public void run() {
            System.out.println("��ʻ"+this.name);
        }
    }
    static class Byd implements NewCar {
        String name="���ǵ�";
        @Override
        public void run() {
            System.out.println("��ʻ"+this.name);
        }
    }
    static class LBGN implements NewCar {
        String name="��������";
        @Override
        public void run() {
            System.out.println("��ʻ"+this.name);
        }
    }

}