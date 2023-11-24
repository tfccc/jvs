package pac04_IO;

import utils.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TFC
 * @date 2019��7��5�� ����3:53:34
 * @note io, �ı���ȡ��׼����
 *
 * ���裺
 * 1.����Դ
 * 2.ѡ����
 * 3.����Դ
 * 4.�ͷ���Դ
 */
public class T07_ReadFile {

    public static void main(String[] args) {
        File f1 = new File("test1");
        //�ⲿ��ʼ��
        InputStream in = null;
        try {

            in = new FileInputStream(f1);
            int tempData;
            //����Ϊ�շ���-1
            //����1
            while ((tempData = in.read()) != -1) {
                System.out.print((char) tempData);
            }
            //����2
			/*while(true) {
				tempData=in.read();
				if(tempData==-1) { break; }
				System.out.print((char)tempData);
			}*/

        } catch (IOException e) {
            e.printStackTrace();
        }//finally�����ָ���쳣
        finally {
            IOStream.close(in);
        }
    }

}
