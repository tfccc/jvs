package utils;

/**
 * @author TFC
 * @date 2019��8��4�� ����8:00:35
 * @note ������������
 *
 * ����˵��:
 *   1.travelWrapperType()--->������װ������
 *   2.travelBasicType()----->����������������
 */
@SuppressWarnings("all")
public class TravelArray {

    /**
     * @Desc ������װ�ࡢ��������
     * @param arr:��װ������(Integer[], Double[]��)
     * @param lineBreak :�Ƿ���(true:���� / false:������)
     * @return void
     */
    public static void travelWrapperType(Object[] arr, boolean lineBreak) {
        if (arr.length > Integer.MAX_VALUE - 1) {
            System.out.println("�������");
            return;
        }
        StringBuilder res = new StringBuilder();
        if (!lineBreak) res.append("[");
        for (Object s : arr) {
            if (!lineBreak)
                res.append(s).append(", ");
            else
                res.append(s).append("\n");
        }
        res.delete(res.length() - 2, res.length());
        if (!lineBreak) res.append("]");
        System.out.println(res);
    }

    /**
     * @Desc:
     *   1.����������������
     *   2.���°���8������,�ֱ��Ӧ8�ֻ����������͵�����
     *   3.������Ļ�����������תΪObject����,�ٵ���travelWrapperType����
     * @param arr 8�ֻ�����������(int[], double[]��)
     * @param lineBreak �Ƿ���(true:���� / false:������)
     * @return void
     */
    //����byte[]
    public static void travelBasicType(byte[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����short[]
    public static void travelBasicType(short[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����int[]
    public static void travelBasicType(int[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����long[]
    public static void travelBasicType(long[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����float[]
    public static void travelBasicType(float[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����double[]
    public static void travelBasicType(double[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����char[]
    public static void travelBasicType(char[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //����boolean[]
    public static void travelBasicType(boolean[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }
}
