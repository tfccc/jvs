package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date 2019��6��28�� ����10:21:32
 * @note ���Ʒָ���
 */
public class T01_FileSeparator {

    public static void main(String[] args) {
        String path = "C:\\Users\\82818\\Desktop\\Java\\JAVA_IO";
        char sep = File.separatorChar;

        //д��1:����·��
        path = "C:/Users/82818/Desktop/Java/JAVA_IO";
        System.out.println(path);

        //д��2:����ƴ��(��̬ƴ��)
        path = "C:" + sep + "Users" + sep + "82818" + sep +
                "Desktop" + sep + "Java" + sep + "JAVA_IO";
        System.out.println(path);
    }
}
