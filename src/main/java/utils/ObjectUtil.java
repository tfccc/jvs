package utils;

import org.openjdk.jol.info.ClassLayout;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-10-05 21:30
 * @desc:
 **/
public class ObjectUtil {

    /**
     * @desc 打印内存信息
     * @return *
     */
    public static void print(Object o) {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}
