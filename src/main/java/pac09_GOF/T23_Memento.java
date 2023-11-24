package pac09_GOF;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-28 15:26
 * @note: ����¼ģʽ (�Իָ��޸ĺ�Ĺ�Ա��ϢΪ��)
 *
 * 1.ģʽ��Ҫ����¼�û��Ĳ������Դﵽ���˻ء��ɳ�����Ŀ�ġ�
 *
 * 2.����
 * ��1��������һ������
 * ��2���Զ��𲽱������
 * ��3����Ϣ���ͺ�ĳ���
 *
 * 3.��ɫ����
 * ��1��Originator(Դ���������������)
 * ��2��Memento   (����¼�ࣺ�洢����Ŀ���)
 * ��3��CareTaker (�������ࣺ���д洢��������¼����)
 *
 * 4.ʵ��Ӧ��
 * ��1��������Ϸ�еĻ���
 * ��2���ĵ��������ĳ���
 * ��3�����ݿ��У�rollback����
 *  (4) IDEA��history����
 *
 **/
class T23_Memento {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        //�½�����
        Employee e1 = new Employee(18, "tfc");
        System.out.println("�½�����");
        printEmpInfo(e1);
        taker.setMemento(e1.memento());

        //�޸Ĳ���
        System.out.println("�޸Ķ���");
        e1.setAge(100);
        e1.setName("cft");
        printEmpInfo(e1);

        //�ָ�����
        System.out.println("�ָ�����");
        e1.recovery(taker.getMemento());
        printEmpInfo(e1);

    }

    static void printEmpInfo(Employee emp) {
        System.out.println("��Ա��Ϣ: " + emp.getAge() + ", " + emp.getName() + "\n");
    }
}

//1.Դ������
class Employee {
    private int age;
    private String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //��������:�����µı���¼
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    //���ݻָ�
    public void recovery(EmpMemento memento) {
        this.age = memento.getAge();
        this.name = memento.getName();
    }

}

//2.����¼��(�ֶ���ͬ)
class EmpMemento {
    private int age;
    private String name;

    EmpMemento(Employee employee) {
        this.age = employee.getAge();
        this.name = employee.getName();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//3.��������
class CareTaker {
    // ��������¼ģ��
    private EmpMemento memento;
    // ���ݽṹ��Ŷ������¼(ʵ�ʳ���)
    /* private List<EmpMemento> meList=new ArrayList<>();
       private Stack<EmpMemento> meList=new Stack<>();*/

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }

}