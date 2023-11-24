package pac04_IO;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;

/**
 * @author TFC
 * @date   2019��7��6�� ����3:28:39
 * @note   io,�ı�д���׼����
 *
 * ���裺
 *	 1.����Դ
 *	 2.ѡ����
 *	 3.����Դ
 *	 4.�ͷ���Դ
 */
public class T09_WriteFile {

	public static void main(String[] args) throws IOException {

		File file=new File("IOtest2");

		try (OutputStream out = new FileOutputStream(file, true)) {
			String s = "д���ı��ڶ���\n\t�ڶ���";
			byte[] data = s.getBytes();
			out.write(data, 0, data.length);
			//ˢ�£������ڴ�����
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
