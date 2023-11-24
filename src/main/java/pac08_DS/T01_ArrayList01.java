package pac08_DS;

import java.util.Arrays;

/**
 * @author TFC
 * @date 2019��8��8�� ����10:43:45
 * @note �Զ���ʵ��ArrayList01
 */
//@SuppressWarnings("all")
public class T01_ArrayList01<E> {
    private static final int DEFUALT_SIZE = 5;
    private int p;    //Ԫ��λ��
    private Object eleData[];

    public T01_ArrayList01() {
        eleData = new Object[DEFUALT_SIZE];
    }

    //1.���Ԫ��
    public void add(E element) {
        if (p == eleData.length)
            capacityExpansion();
        eleData[p++] = element;
    }

    //2.����(x+x/2)
    public void capacityExpansion() {
        eleData = Arrays.copyOf(eleData, eleData.length + (eleData.length >> 1));
    }

    //3.����
    public void travel() {
        StringBuilder strb = new StringBuilder();
        strb.append("[");
        for (Object obj : eleData) {
            if (obj == null)
                break;
            strb.append(obj + ",");
        }
        strb.setCharAt(strb.length() - 1, ']');
        System.out.println(strb);
    }

    //4.��ȡ���鳤��
    public void getSize() {
        System.out.println(eleData.length);
    }

    //5.��ȡָ��λ��Ԫ��
    public void getElement(int index) {
        if (index >= 1 && index <= getCount())
            System.out.println(eleData[index - 1]);
    }

    //6.�滻ָ��Ԫ��
    public void replaceEle(E newEle, int index) {
        if (index >= 1 && index <= getCount())
            eleData[index - 1] = newEle;
    }

    //7.����Ԫ��
    public void insertEle(E newEle, int index) {
        int count = getCount();
        if (index >= 0 && index < count) {
            for (int i = getCount(); i > index; i--) {
                eleData[i] = eleData[i - 1];
            }
            eleData[index] = newEle;
        }
    }

    //8.��ȡԪ�ظ���
    public int getCount() {
        int count = 0;
        for (Object e : eleData) {
            if (e == null)
                break;
            count++;
        }
        return count;
    }

    //9.ɾ��Ԫ��(βԪ��)
    public void remove() {
        eleData[getCount() - 1] = null;
    }

    //10.ɾ��ָ��λ��
    public void remove(int index) {
        int count = getCount();
        if (index > 0 && index <= count) {
            for (int i = index; i < count; i++) {
                eleData[i - 1] = eleData[i];
            }
            eleData[count - 1] = null;
        }
    }

    public static void main(String[] args) {
        T01_ArrayList01<Integer> list1 = new T01_ArrayList01<Integer>();
        for (int i = 1; i <= 16; i++)
            list1.add(i);

        list1.travel();
        System.out.print("size:");
        list1.getSize();
        System.out.println("count:" + list1.getCount());

    }
}
