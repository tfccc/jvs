package pac09_GOF;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-15 12:09
 * @note: 享元模式：以棋子为例：大小、形状相同，坐标不同
 *
 * *开发场景：多个完全相同或相似的对象，通过享元模式可以节省内存空间
 * *以共享的方式高效地支持大量相似对象
 *
 * *1.内部状态(可共享)
 * *2.外部状态(不可共享)
 *
 * 角色分类：
 * 1.FlyWeightFactory           (享元工厂：创建、管理享元对象)
 * 2.FlyWeight                  (抽象享元类)
 * 3.ConcreteFlyWeight          (具体享元类)
 * 4.UnsharedConcreteFlyWeight  (非共享享元类)
 *
 * 实际应用：
 * 1.线程池、数据库连接池
 * 2.String类
 **/
public class T12_FlyWeight {
    public static void main(String[] args) {
        ChessFlyWeight chess_white1 = ChessFlyWeightFac.getChess("白色");
        ChessFlyWeight chess_white2 = ChessFlyWeightFac.getChess("白色");
        ChessFlyWeight chess_black1 = ChessFlyWeightFac.getChess("黑色");

        //创建的为享元池内的同一对象
        System.out.println("c1: " + chess_white1.hashCode());
        System.out.println("c2: " + chess_white2.hashCode());
        System.out.println("c3: " + chess_black1.hashCode());
        System.out.println(chess_white1.equals(chess_white2));
        //创建的为享元池内的不同对象
        System.out.println(chess_white1.equals(chess_black1));

        //外部具体细节处理
        chess_white1.display(new Coordinate(10, 20));
        chess_white2.display(new Coordinate(30, 40));
    }
}

//1.享元工厂
class ChessFlyWeightFac {
    //享元池：Map避免重复
    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {
        ChessFlyWeight chess = map.get(color);
        if (chess != null)
            return chess;
        else {
            ChessFlyWeight newChess = new ConcreteChess(color);
            map.put(color, newChess);
            return newChess;
        }
    }
}

//2.抽象享元类
interface ChessFlyWeight {
    String getColor();

    void display(Coordinate c);
}

//3.具体享元类
class ConcreteChess implements ChessFlyWeight {
    private String color;

    ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.print("颜色:" + this.color);
        System.out.println(" --- 坐标:(" + c.getX() + "," + c.getY() + ")");
    }
}

//4.非共享享元类
//棋子坐标
class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}