package pac09_GOF;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-15 12:09
 * @note: ��Ԫģʽ��������Ϊ������С����״��ͬ�����겻ͬ
 *
 * *���������������ȫ��ͬ�����ƵĶ���ͨ����Ԫģʽ���Խ�ʡ�ڴ�ռ�
 * *�Թ���ķ�ʽ��Ч��֧�ִ������ƶ���
 *
 * *1.�ڲ�״̬(�ɹ���)
 * *2.�ⲿ״̬(���ɹ���)
 *
 * ��ɫ���ࣺ
 * 1.FlyWeightFactory           (��Ԫ������������������Ԫ����)
 * 2.FlyWeight                  (������Ԫ��)
 * 3.ConcreteFlyWeight          (������Ԫ��)
 * 4.UnsharedConcreteFlyWeight  (�ǹ�����Ԫ��)
 *
 * ʵ��Ӧ�ã�
 * 1.�̳߳ء����ݿ����ӳ�
 * 2.String��
 **/
public class T12_FlyWeight {
    public static void main(String[] args) {
        ChessFlyWeight chess_white1 = ChessFlyWeightFac.getChess("��ɫ");
        ChessFlyWeight chess_white2 = ChessFlyWeightFac.getChess("��ɫ");
        ChessFlyWeight chess_black1 = ChessFlyWeightFac.getChess("��ɫ");

        //������Ϊ��Ԫ���ڵ�ͬһ����
        System.out.println("c1: " + chess_white1.hashCode());
        System.out.println("c2: " + chess_white2.hashCode());
        System.out.println("c3: " + chess_black1.hashCode());
        System.out.println(chess_white1.equals(chess_white2));
        //������Ϊ��Ԫ���ڵĲ�ͬ����
        System.out.println(chess_white1.equals(chess_black1));

        //�ⲿ����ϸ�ڴ���
        chess_white1.display(new Coordinate(10, 20));
        chess_white2.display(new Coordinate(30, 40));
    }
}

//1.��Ԫ����
class ChessFlyWeightFac {
    //��Ԫ�أ�Map�����ظ�
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

//2.������Ԫ��
interface ChessFlyWeight {
    String getColor();

    void display(Coordinate c);
}

//3.������Ԫ��
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
        System.out.print("��ɫ:" + this.color);
        System.out.println(" --- ����:(" + c.getX() + "," + c.getY() + ")");
    }
}

//4.�ǹ�����Ԫ��
//��������
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