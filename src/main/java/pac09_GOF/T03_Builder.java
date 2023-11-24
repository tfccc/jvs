package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-08-29 12:56
 * @note: 建造者模式
 *
 * 1.分离了对象子组件的单独构造(Builder)和装配(Director),适用于构建对象复杂的情况。
 * 2.实现了建造和装配的解耦,不同的装配逻辑可以组建不同的对象。
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

//飞船
class AirShip {
    private Engines engine;
    private EscapeTower escapeTower;

    public void launch() {
        if (engine != null && escapeTower != null) {
            System.out.print("发射飞船: [");
            System.out.print(engine.getName() + "/");
            System.out.println(escapeTower.getName() + "]");
        } else {
            System.out.println("飞船未构建完成");
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

//组件
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
        System.out.println("builder: 建造发动机01");
        return new Engines("发动机01");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("builder: 建造逃逸塔01");
        return new EscapeTower("逃逸塔01");
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
        //建造
        Engines engine = airShipBuilder.buildEngine();
        EscapeTower escapeTower = airShipBuilder.buildEscapeTower();
        //组装
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        System.out.println("director: 飞船组装完成");
        return airShip;
    }
}

//Builder接口
interface Builder {
    Engines buildEngine();

    EscapeTower buildEscapeTower();
}

//Director接口
interface Director {
    AirShip directorAirShip();
}

