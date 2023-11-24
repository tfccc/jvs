package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 13:48
 * @note: ��������
 **/
public class C_FacMethod {
    public static void main(String[] args) {
        Product p1 = new ConcreteCreator01().createProduct();
        Product p2 = new ConcreteCreator02().createProduct();
        p1.showInfo();
        p2.showInfo();
    }
}

interface Product{
    void showInfo();
}

class Product01 implements Product{
    @Override
    public void showInfo() {
        System.out.println("��Ʒ01");
    }
}
class Product02 implements Product{
    @Override
    public void showInfo() {
        System.out.println("��Ʒ02");
    }
}

abstract class Creator{
    public abstract Product createProduct();
}

class ConcreteCreator01 extends Creator{
    @Override
    public Product createProduct() {
        System.out.println("������Ʒ01");
        return new Product01();
    }
}
class ConcreteCreator02 extends Creator{
    @Override
    public Product createProduct() {
        System.out.println("������Ʒ02");
        return new Product02();
    }
}
