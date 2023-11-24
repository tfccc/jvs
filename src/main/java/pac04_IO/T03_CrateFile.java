package pac04_IO;

import java.io.File;
import java.io.IOException;

/**
 * @author TFC
 * @date 2019��7��4�� ����10:00:13
 * @note �ļ���/�ļ��������ļ�Ŀ¼����
 */
public class T03_CrateFile {
    public static void main(String[] args) throws IOException {
        //����text�ĵ�
        File f = new File("C:/Users/82818/Desktop/Java/IO_test/"
                + "test.txt");
        f.createNewFile();//f.delete();


        /* �����ļ���(Ŀ¼)
         * 1.mkdirs()�ϼ�Ŀ¼�ɲ�����(�Ƽ�ʹ��)
         * 2.mkdir() �ϼ�Ŀ¼������ڲ��ܴ���
         */
        File f2 = new File("C:/Users/82818/Desktop/Java/IO_test/dir1");
        f2.mkdirs();


        /* �г���һ��
         * 1.list()     �г���һ����������
         * 2.listFiles()�г���һ�����ж���
         */
        // 1.list����
        File f3 = new File("C:/Users/82818/Desktop/Java/IO_test");
        String[] filenames = f3.list();

        for (String s : filenames) {
            System.out.println(s);
        }
        System.out.println();
        // 2.listFiles����
        File[] fc = f3.listFiles();
        for (File s : fc) {
            System.out.println(s);
        }
    }
}
