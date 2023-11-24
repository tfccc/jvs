package pac04_IO;

import utils.IOStream;

import java.io.*;

/**
 * @author TFC
 * @date 2019��7��10�� ����11:08:27
 * @note ������װ���ļ�IO����ʵ���ı����������ִ��Ч�ʡ�
 */
public class T24_FileCopy3_BufferedByte {


    public static void copy(String path1, String path2) {
        File pre = new File(path1);
        File now = new File(path2);
        InputStream in = null;
        OutputStream out = null;
        try {
            //����װ����
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
