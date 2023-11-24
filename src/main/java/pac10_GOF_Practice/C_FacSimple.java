package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 14:05
 * @note: ¼òµ¥¹¤³§
 **/
public class C_FacSimple {
    public static void main(String[] args) {
        NewCar audi = CarFactory.createCar("°ÂµÏ");
        NewCar byd  = CarFactory.createCar("±ÈÑÇµÏ");
        NewCar LBGN = CarFactory.createCar("À¼²©»ùÄá");

        audi.run();

    }
}

interface NewCar {
    void run();
}

class CarFactory{
    public static NewCar createCar(String name){
        switch (name) {
            case "°ÂµÏ":
                return new Cars.Audi();
            case "±ÈÑÇµÏ":
                return new Cars.Byd();
            case "À¼²©»ùÄá":
                return new Cars.LBGN();
            default:
                return null;
        }
    }
}
class Cars{
    static class Audi implements NewCar {
        String name="°ÂµÏ";

        @Override
        public void run() {
            System.out.println("¼ÝÊ»"+this.name);
        }
    }
    static class Byd implements NewCar {
        String name="±ÈÑÇµÏ";
        @Override
        public void run() {
            System.out.println("¼ÝÊ»"+this.name);
        }
    }
    static class LBGN implements NewCar {
        String name="À¼²©»ùÄá";
        @Override
        public void run() {
            System.out.println("¼ÝÊ»"+this.name);
        }
    }

}