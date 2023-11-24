package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date 2019年6月28日 下午10:21:32
 * @note 名称分隔符
 */
public class T01_FileSeparator {

    public static void main(String[] args) {
        String path = "C:\\Users\\82818\\Desktop\\Java\\JAVA_IO";
        char sep = File.separatorChar;

        //写法1:绝对路径
        path = "C:/Users/82818/Desktop/Java/JAVA_IO";
        System.out.println(path);

        //写法2:常量拼接(动态拼接)
        path = "C:" + sep + "Users" + sep + "82818" + sep +
                "Desktop" + sep + "Java" + sep + "JAVA_IO";
        System.out.println(path);
    }
}
