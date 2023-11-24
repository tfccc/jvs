package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-08-29 12:56
 * @note: ������ģʽ
 *
 * 1.�����˶���������ĵ�������(Builder)��װ��(Director),�����ڹ��������ӵ������
 * 2.ʵ���˽����װ��Ľ���,��ͬ��װ���߼������齨��ͬ�Ķ���
 *
 **/
public class T03_Builder {

    public static void main(String[] args) {
        shipBuilder sb = new shipBuilder();
        shipDirector sd = new shipDirector(sb);
        AirShip ship = sd.directorAirShip();
        /*System.out.println(ship.getEngine().getName()+"/"+
                ship.getEscapeTower().getName());*/
        ship.launch();
    }
}

//�ɴ�
class AirShip {
    private Engines engine;
    private EscapeTower escapeTower;

    public void launch() {
        if (engine != null && escapeTower != null) {
            System.out.print("����ɴ�: [");
            System.out.print(engine.getName() + "/");
            System.out.println(escapeTower.getName() + "]");
        } else {
            System.out.println("�ɴ�δ�������");
        }
    }

    public Engines getEngine() {
        return engine;
    }

    public void setEngine(Engines engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }

}

//���
class Engines {
    private String name;

    public Engines(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class EscapeTower {
    private String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//Builder
class shipBuilder implements Builder {

    @Override
    public Engines buildEngine() {
        System.out.println("builder: ���췢����01");
        return new Engines("������01");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("builder: ����������01");
        return new EscapeTower("������01");
    }
}

//Director
class shipDirector implements Director {
    private shipBuilder airShipBuilder;

    public shipDirector(shipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }

    @Override
    public AirShip directorAirShip() {
        //����
        Engines engine = airShipBuilder.buildEngine();
        EscapeTower escapeTower = airShipBuilder.buildEscapeTower();
        //��װ
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        System.out.println("director: �ɴ���װ���");
        return airShip;
    }
}

//Builder�ӿ�
interface Builder {
    Engines buildEngine();

    EscapeTower buildEscapeTower();
}

//Director�ӿ�
interface Director {
    AirShip directorAirShip();
}

