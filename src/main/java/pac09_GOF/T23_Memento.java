package pac09_GOF;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-28 15:26
 * @note: 备忘录模式 (以恢复修改后的雇员信息为例)
 *
 * 1.模式概要：记录用户的操作，以达到可退回、可撤销的目的。
 *
 * 2.场景
 * （1）回退上一步操作
 * （2）自动逐步保存操作
 * （3）消息发送后的撤回
 *
 * 3.角色分类
 * （1）Originator(源发器：被保存对象)
 * （2）Memento   (备忘录类：存储对象的拷贝)
 * （3）CareTaker (负责人类：集中存储、管理备忘录对象)
 *
 * 4.实际应用
 * （1）棋类游戏中的悔棋
 * （2）文档，输入框的撤销
 * （3）数据库中，rollback操作
 *  (4) IDEA的history功能
 *
 **/
class T23_Memento {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        //新建对象
        Employee e1 = new Employee(18, "tfc");
        System.out.println("新建对象：");
        printEmpInfo(e1);
        taker.setMemento(e1.memento());

        //修改操作
        System.out.println("修改对象：");
        e1.setAge(100);
        e1.setName("cft");
        printEmpInfo(e1);

        //恢复操作
        System.out.println("恢复对象：");
        e1.recovery(taker.getMemento());
        printEmpInfo(e1);

    }

    static void printEmpInfo(Employee emp) {
        System.out.println("雇员信息: " + emp.getAge() + ", " + emp.getName() + "\n");
    }
}

//1.源发器类
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

    //备忘操作:创建新的备忘录
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    //数据恢复
    public void recovery(EmpMemento memento) {
        this.age = memento.getAge();
        this.name = memento.getName();
    }

}

//2.备忘录类(字段相同)
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

//3.负责人类
class CareTaker {
    // 单个备忘录模拟
    private EmpMemento memento;
    // 数据结构存放多个备忘录(实际常用)
    /* private List<EmpMemento> meList=new ArrayList<>();
       private Stack<EmpMemento> meList=new Stack<>();*/

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }

}