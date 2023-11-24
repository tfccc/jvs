package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date 2019年7月4日 上午10:43:42
 * @note 用递归方法打印子级目录
 */
public class T04_TravelDir {

    public static void main(String[] args) {
        File f3 = new File("C:/Users/82818/Desktop/Java/IO_test");
        printName(f3);
    }

    //递归方法
    static void printName(File f) {
        if (f.isDirectory()) {
            System.out.println("目录:" + f.getName() + "{");
        } else {
            System.out.println("文件:" + f.getName());
        }
        //递归部分
        if (!f.exists()) {
            return;
        } else if (f.isDirectory()) {
            for (File s : f.listFiles()) {
                printName(s);
            }
            System.out.println("}");
        }

    }
}
