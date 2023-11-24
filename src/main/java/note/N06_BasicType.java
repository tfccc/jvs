package note;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-30 21:34
 * @desc: 基本类型的描述
 *
 * 一.图标表
 *   数据类型     占位(字节)     默认值
 *    byte            1           0
 *    short           2           0
 *    int             4           0
 *    long            8           0
 *    float           4           0.0f
 *    double          8           0.0d
 *    char            2           '\u0000'
 *    boolean         4           false
 *
 * 二.说明
 *   1.《Java虚拟机规范》,boolean变量当作int处理,也就是4字节.
 *     而boolean数组当做byte数组处理,即boolean类型的数组里面的
 *     每一个元素占1个字节。
 *   2.但实际情况由JVM而定,有些是占1字节
 *
 **/

class LotsOfBooleans {
    boolean a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
    boolean b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
    boolean c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
    boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
    boolean e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class LotsOfInts {
    int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
    int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
    int c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
    int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
    int e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}


public class N06_BasicType {

    /*************************************************************
     *                   test case from website
     *************************************************************/

    private static final int SIZE = 100000;

    public static void main(String[] args) {
        LotsOfBooleans[] first = new LotsOfBooleans[SIZE];
        LotsOfInts[] second = new LotsOfInts[SIZE];

        System.gc();
        long startMem = getMemory();

        for (int i = 0; i < SIZE; i++) {
            first[i] = new LotsOfBooleans();
        }

        System.gc();
        long endMem = getMemory();
        System.out.println("Size for LotsOfBooleans: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));
        System.gc();
        startMem = getMemory();
        for (int i = 0; i < SIZE; i++) {
            second[i] = new LotsOfInts();
        }
        System.gc();
        endMem = getMemory();

        System.out.println("Size for LotsOfInts: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));

        // Make sure nothing gets collected
        long total = 0;
        for (int i = 0; i < SIZE; i++) {
            total += (first[i].a0 ? 1 : 0) + second[i].a0;
        }
        System.out.println(total);
    }

    private static long getMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

}
