package pac04_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SocketChannel;

/**
 * @author TFC
 * @date 2019年7月6日 下午3:16:32
 * @note practice
 */
public class Practice {

    public static void main(String[] args) {
        File f1 = new File("IOtest1");
        InputStream in = null;
        try {
            in = new FileInputStream(f1);
            int data = 0;
            while ((data = in.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
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
