package pac09_GOF;

/**
 * @project: Java_2019.06.10
 * @author: TFC
 * @date: 2019-10-06 10:50
 * @note: ģ�巽��ģʽ��������ҵ�����Ϊ��
 *
 * *1.ģʽ��Ҫ������һ�������е��㷨��ܣ���ĳЩ�����ӳٵ�����ʵ�֣�
 *    ���������಻�ı��㷨�ṹ��ǰ�������¶�����㷨��ĳЩ�ض����衣
 * *2.ʹ�ó��������岽��̶���С�����ױ䣬��Ҫ�Զ���ʵ�ֵ����
 *
 * ��ɫ���ࣺ
 *      1.����ģ�巽����
 *      2.ʵ������(��ֱ��ʹ������ʵ��)
 *
 * ʵ��Ӧ�ã�
 *      1.���ݿ���ʷ�װ
 *      2.Junit��Ԫ����
 *      3.Servlet��doPost/doGet
 *      4.Spring��JDBCTemplate��HibernateTemplate
 **/
public class T20_TemplateMethod {
    public static void main(String[] args) {
        //1.�Զ�����ʵ��
        BankTemplateMethod dm = new DrawMoney();
        dm.process();
        System.out.println("--------------");

        //2.����ʵ��
        BankTemplateMethod b1 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("ҵ��2�����");
            }
        };
        b1.process();
    }
}

//1.����ģ�巽����
abstract class BankTemplateMethod {
    public void takeNumber() {
        System.out.println("1.ȡ���Ŷ�");
    }

    public abstract void transact();

    public void evaluate() {
        System.out.println("3.��������");
    }

    //ģ�巽���ϼ�
    public final void process() {
        this.takeNumber();
        this.transact();    //���ӷ������������еľ��巽���ҹ�
        this.evaluate();
    }
}

//2.ʵ������
class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("ҵ��1��ȡ��");
    }
}

class DepositMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("ҵ��2�����");
    }
}