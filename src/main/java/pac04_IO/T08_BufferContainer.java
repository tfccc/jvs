package pac04_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TFC
 * @date 2019年7月6日 下午2:42:12
 * @note 利用byte[]缓存，分段读取文本内容
 */
public class T08_BufferContainer {

    public static void main(String[] args) {
        File f1 = new File("test1");
        //外部初始化
        InputStream in = null;
        try {

            in = new FileInputStream(f1);
            byte[] buffer = new byte[4];//缓冲容器(表示每一次缓存多少个字节)
            int len = -1;    //接收缓存的长度
            while ((len = in.read(buffer)) != -1) {
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }//finally避免空指针异常
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
