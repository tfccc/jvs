package utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author TFC
 * @date 2019��6��16�� ����8:42:58
 * @note ����Set, Map, List������
 */
@SuppressWarnings("unused")
public class TravelCollection {

    /**
     * @Desc ����List����
     * @param list List��������
     * @param lineBreak �Ƿ���(true:���� / false:������)
     * @return: void
     */
    public static <E> void travelList(List<E> list, boolean lineBreak) {
        if (overLength(list.size()))
            return;
        StringBuilder res = new StringBuilder();
        if (!lineBreak)
            res.append("[");
        for (E e : list) {
            if (!lineBreak) res.append(e).append(", ");
            else res.append(e).append("\n");
        }
        if (!lineBreak) {
            res.delete(res.length() - 2, res.length());
            res.append("]");
        }
        System.out.println(res);
    }
    /**
     * @Desc ����travelList, Ĭ�ϻ���
     * @param list List��������
     * @return: void
     */
    public static <E> void travelList(List<E> list) {
        travelList(list,true);
    }

    /**
     * @Desc ����Map����
     * @param map Map��������
     * @param lineBreak �Ƿ���(true:���� / false:������)
     * @return void
     */
    public static <K, V> void travelMap(Map<K, V> map, boolean lineBreak) {
        if (overLength(map.size()))
            return;
        //�ȷ���set�ٱ���
        Set<Map.Entry<K, V>> set = map.entrySet();
        StringBuilder res = new StringBuilder();
        if (!lineBreak)
            res.append("{ ");
        for (Map.Entry<K, V> kvEntry : set) {
            if (lineBreak) res.append("[").append(kvEntry).append("]").append("\n");
            else res.append("[").append(kvEntry).append("], ");
        }
        if (lineBreak) {
            res.delete(res.length() - 1, res.length());
        } else {
            res.delete(res.length() - 2, res.length());
            res.append(" }");
        }
        System.out.println(res);
    }
    /**
     * @Desc ����travelMap, Ĭ�ϻ���
     * @param map Map��������
     * @return: void
     */
    public static <K, V> void travelMap(Map<K, V> map) {
        travelMap(map,true);
    }

    /**
     * @Desc ����Set����
     * @param set Set��������
     * @param lineBreak �Ƿ���(true:���� / false:������)
     * @return void
     */
    public static <E> void travelSet(Set<E> set, boolean lineBreak) {
        if (overLength(set.size()))
            return;
        StringBuilder res = new StringBuilder();
        if (!lineBreak)
            res.append("[");
        for (E e : set) {
            if (!lineBreak) res.append(e).append(", ");
            else res.append(e).append("\n");
        }
        if (!lineBreak) {
            res.delete(res.length() - 2, res.length());
            res.append("]");
        }
        System.out.println(res);
    }

    /**
     * @Desc ����travelSet, Ĭ�ϻ���
     * @param set Set������
     * @return: void
     */
    public static <E> void travelSet(Set<E> set) {
        travelSet(set,true);
    }


    /**
     * @Desc ������������Ƿ����
     * @param len ����������
     * @return boolean
     */
    private static boolean overLength(int len) {
        if (len > Integer.MAX_VALUE - 1) {
            System.out.println("��������������");
            return true;
        }
        return false;
    }

}
