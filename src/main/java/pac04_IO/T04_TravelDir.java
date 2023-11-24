package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date 2019��7��4�� ����10:43:42
 * @note �õݹ鷽����ӡ�Ӽ�Ŀ¼
 */
public class T04_TravelDir {

    public static void main(String[] args) {
        File f3 = new File("C:/Users/82818/Desktop/Java/IO_test");
        printName(f3);
    }

    //�ݹ鷽��
    static void printName(File f) {
        if (f.isDirectory()) {
            System.out.println("Ŀ¼:" + f.getName() + "{");
        } else {
            System.out.println("�ļ�:" + f.getName());
        }
        //�ݹ鲿��
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
