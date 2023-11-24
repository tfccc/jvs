package pac10_GOF_Practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 18:53
 * @note: ��Ԫģʽ
 **/
public class S_FlyWeight {
    public static void main(String[] args) {
        Chess white1 = ChessFac.getChess("��ɫ");
        Chess white2 = ChessFac.getChess("��ɫ");
        Chess black1 = ChessFac.getChess("��ɫ");

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
        System.out.println("��ϣ:" + this.hashCode() +
                "   ��ɫ:" + color + "   ����:(" + x + "," + y + ")");
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