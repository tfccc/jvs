package pac09_GOF;

import java.util.Date;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-04 19:52
 * @note: ԭ��ģʽ(��¡ģʽ)
 *
 * 1.һ����Ϲ�������ģʽģʽʹ��
 * 2.��ĳ������Ϊԭ�ͣ����Ƴ��µĶ�������½������Ч�ʡ�
 * 3.����������new�ؼ��֣�����ͬ��new��
 * 4.�����ԭ�������Ӱ�죬ͨ����¡���ٶԿ�¡����ֵ���в�����
 *
 * ģʽ���ࣺ
 *     1.ǳ��¡(A�����ڸ���ʱ���õ�ʱͬһ������,A����û�з�����¡,�ı����������)
 *     2.���¡(��������һ���¶���,��ǳ��¡�෴,�����ԭ��������ֵ���Ӱ��,�ı��޹���)
 *     3.���л��ͷ����л�ʵ�����¡(IO)(�����ܶԱȲ���)
 *
 **/

public class T04_ProtoType {

    public static void main(String[] args) throws CloneNotSupportedException {
        //1.ǳ��¡����
        switchCloneType(1);

        //2.���¡����
        //switchCloneType(2);

        //3.���л��ͷ����л�ʵ�����¡
    }

    /**
     * ����˵����
     * choice-->1 : ����ǳ��¡
     * choice-->2 : �������¡
     * */
    private static void switchCloneType(int choice) throws CloneNotSupportedException {
        Date birDay = new Date(123456);
        ReferencedObj r1 = new ReferencedObj(1);
        ReferencedObj r2 = new ReferencedObj(2);
        Sheep s1 = new Sheep("sheep_proto", birDay, r1);
        System.out.println("ԭʼ����S1:  " + s1);
        Sheep s2 = null;
        if (choice == 1) {
            s2 = (Sheep) s1.shallowClone();
        } else if (choice == 2) {
            s2 = (Sheep) s1.deepClone();
        }
        System.out.println("��¡����S2:  " + s2 + "\n----------------------------------------------\n");

        //�ı�Date(ǳ��¡�����ı䣬��Ϊǳ��¡S2���õ���S1��Date����)
        System.out.println("��¡���s1.Date: " + s1.getBirDay().hashCode());
        System.out.println("��¡���s2.Date: " + s2.getBirDay().hashCode());
        birDay.setTime(987654 * 100);
        System.out.println("<�ı����ö���>");
        System.out.println("�ı���S1.Date----" + s1.getBirDay().hashCode());
        System.out.println("�ı���S2.Date----" + s2.getBirDay().hashCode() + "\n");


        //�ı�Referenced
        System.out.println("��¡���s1.Referenced: " + s1.referenced.hashCode());
        System.out.println("��¡���s2.Referenced: " + s2.referenced.hashCode());
        s1.referenced = r2;
        System.out.println("<�ı����ö���>");
        System.out.println("�ı���s1.Referenced----" + s1.referenced.hashCode());
        System.out.println("�ı���s2.Referenced----" + s2.referenced.hashCode());
    }

}

//1.����¡���� (ʵ��Cloneable�ӿڵĶ�����ܽ��п�¡)
class Sheep implements Cloneable {
    private String name;
    private Date birDay;
    public ReferencedObj referenced;

    Sheep(String name, Date birDay, ReferencedObj referenced) {
        this.name = name;
        this.birDay = birDay;
        this.referenced = referenced;
    }

    Date getBirDay() {
        return birDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirDay(Date birDay) {
        this.birDay = birDay;
    }

    public void printInfo() {
        System.out.println(name + "/" + birDay);
    }

    /**
     * 1.ǳ��¡ (ֱ�ӵ���Object���clone����)
     */
    Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 2.���¡ (����clone����,ͬʱ��¡Sheep�����Date����)
     */
    Object deepClone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Sheep sheep = (Sheep) obj;
        sheep.birDay = (Date) this.birDay.clone();
        sheep.referenced = (ReferencedObj) this.referenced.clone();
        return sheep;
    }

}

class ReferencedObj implements Cloneable {
    String desc = "�����ö���, ����չʾ��ͬ��¡������";
    int target;

    ReferencedObj(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    // TODO: 2020/10/11  unresolved
    public Object clone() {
        ReferencedObj c = null;
        try {
            c = (ReferencedObj) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return c;
    }
}