package pac04_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TFC
 * @date 2019��7��6�� ����2:42:12
 * @note ����byte[]���棬�ֶζ�ȡ�ı�����
 */
public class T08_BufferContainer {

    public static void main(String[] args) {
        File f1 = new File("test1");
        //�ⲿ��ʼ��
        InputStream in = null;
        try {

            in = new FileInputStream(f1);
            byte[] buffer = new byte[4];//��������(��ʾÿһ�λ�����ٸ��ֽ�)
            int len = -1;    //���ջ���ĳ���
            while ((len = in.read(buffer)) != -1) {
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }//finally�����ָ���쳣
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
