package pac04_IO;

import utils.IOStream;

import java.io.*;
import java.net.URL;

/**
 * @author TFC
 * @date 2019��7��10�� ����1:08:29
 * @note ת����(��ת�� �� �ַ��� �� �ֽ���ת���ַ���)
 */
public class T16_ConvertStream {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        generateHtml();
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }

    //�õ�ָ����վ��html
    private static void generateHtml() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            //ָ���ַ�������ֹ���������
                            new URL("https://www.baidu.com").openStream(), "UTF-8"));
            writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("baidu.html"), "UTF-8"));
            String str;
            while ((str = reader.readLine()) != null) {
                writer.write(str);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOStream.close(writer, reader);
        }
    }


}
