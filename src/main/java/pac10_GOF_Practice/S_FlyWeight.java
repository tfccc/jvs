package pac10_GOF_Practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 18:53
 * @note: 享元模式
 **/
public class S_FlyWeight {
    public static void main(String[] args) {
        Chess white1 = ChessFac.getChess("白色");
        Chess white2 = ChessFac.getChess("白色");
        Chess black1 = ChessFac.getChess("黑色");

        white1.display(20, 30);
        white2.display(30, 50);
        black1.display(40, 20);

    }
}

interface Chess {
    void display(int x, int y);
}

class ConcreteChess implements Chess {
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("哈希:" + this.hashCode() +
                "   颜色:" + color + "   坐标:(" + x + "," + y + ")");
    }
}

class ChessFac {
    private static Map<String, Chess> chessMap = new HashMap<>();

    public static Chess getChess(String color) {
        if (chessMap.get(color) != null)
            return chessMap.get(color);
        else {
            Chess chess = new ConcreteChess(color);
            chessMap.put(color, chess);
            return chess;
        }
    }
}