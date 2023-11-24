package utils;

/**
 * @author TFC
 * @date 2019年8月4日 下午8:00:35
 * @note 遍历各类数组
 *
 * 方法说明:
 *   1.travelWrapperType()--->遍历包装类数组
 *   2.travelBasicType()----->遍历基本类型数组
 */
@SuppressWarnings("all")
public class TravelArray {

    /**
     * @Desc 遍历包装类、对象数组
     * @param arr:包装类数组(Integer[], Double[]等)
     * @param lineBreak :是否换行(true:换行 / false:不换行)
     * @return void
     */
    public static void travelWrapperType(Object[] arr, boolean lineBreak) {
        if (arr.length > Integer.MAX_VALUE - 1) {
            System.out.println("数组过大");
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
     *   1.遍历基本类型数组
     *   2.以下包含8个方法,分别对应8种基本数据类型的数组
     *   3.将传入的基本类型数组转为Object数组,再调用travelWrapperType方法
     * @param arr 8种基本类型数组(int[], double[]等)
     * @param lineBreak 是否换行(true:换行 / false:不换行)
     * @return void
     */
    //遍历byte[]
    public static void travelBasicType(byte[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历short[]
    public static void travelBasicType(short[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历int[]
    public static void travelBasicType(int[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历long[]
    public static void travelBasicType(long[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历float[]
    public static void travelBasicType(float[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历double[]
    public static void travelBasicType(double[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历char[]
    public static void travelBasicType(char[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }

    //遍历boolean[]
    public static void travelBasicType(boolean[] arr, boolean lineBreak) {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        travelWrapperType(objs, lineBreak);
    }
}
