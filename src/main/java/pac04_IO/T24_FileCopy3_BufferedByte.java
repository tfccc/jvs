package pac04_IO;

import utils.IOStream;

import java.io.*;

/**
 * @author TFC
 * @date 2019年7月10日 上午11:08:27
 * @note 缓冲流装饰文件IO流，实现文本拷贝，提高执行效率。
 */
public class T24_FileCopy3_BufferedByte {


    public static void copy(String path1, String path2) {
        File pre = new File(path1);
        File now = new File(path2);
        InputStream in = null;
        OutputStream out = null;
        try {
            //套上装饰流
            in = new BufferedInputStream(new FileInputStream(pre));
            out = new BufferedOutputStream(new FileOutputStream(now));

            byte[] bytes = new byte[1024 * 1024];
            int len = -1;

            while ((len = in.read(bytes)) != -1) {
                out.write(bytes);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOStream.close(out, in);
        }
    }
}
