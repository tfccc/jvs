package pac03_Collection;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * @author TFC
 * @date 2019��6��15�� ����12:00:49
 * @note List�����÷�
 *
 * 1.��ѯЧ�ʸߣ���ɾ��Ч�ʵͣ��̲߳���ȫ
 * 2.���ʱ����������ͨ�����ݵķ�ʽʵ��(����������)
 *
 * */
public class T02_List {

    public static void main(String[] args) {
        //t1();
        //t2();
        t3();

    }

    //List��һЩ����
    private static void t2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("a");
        //����λ��Ԫ��
        list.set(2, "C");
        //list.sort(String::compareToIgnoreCase);
        //�õ�λ��Ԫ�ص�ֵ
        System.out.println("0��Ԫ��Ϊ:" + list.get(0));
        //���ز���Ԫ�ص���С�±�
        System.out.println("a����С�±�:" + (list.indexOf("a")));
        //���ز���Ԫ�ص�����±�
        System.out.println("a������±�:" + list.lastIndexOf("a"));

        System.out.println(list);
    }

    //Collection�е�һЩ����
    public static void t1() {
        ArrayList<Integer> c = new ArrayList<>();
        //���Ԫ�صķ���
        c.add(1);
        System.out.println(c);
        //�жϿ�
        System.out.println(c.isEmpty());
        //Ԫ�ظ���
        System.out.println(c.size());
        //�Ƴ�Ԫ��
        c.remove(1);

        System.out.println(c);
    }

    //�۲�list����
    private static void t3() {
        List<Object> list = new ArrayList<>(50);
        for (int i = 1; i <= 30; i++) {
            list.add(1);
            printListVolume(list);
        }
        System.out.println("---------------------------");
        List<Object> vector = new Vector<>(100);
        for (int i = 1; i <= 30; i++) {
			vector.add(1);
			printListVolume(vector);
		}
    }


    @SuppressWarnings("all")
    public static void printListVolume(List<?> list) {

        Class<? extends List> strClass = list.getClass();
        Field field = null;
        try {
            field = strClass.getDeclaredField("elementData");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        Object[] elementData = null;
        try {
            elementData = (Object[]) field.get(list);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("����: " + elementData.length +
                " --- Ԫ��:" + list.size());
    }
}
