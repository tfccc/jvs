package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date   2019��7��4�� ����11:20:23
 * @note   �����ļ��д�С
 */
public class T05_CountLength {
	public static void main(String[] args) {
		
		File f = new File("C:/Users/82818/Desktop/Java/IO_test");
		System.out.println(getFileLength(f));
	}

	/**
	 * @Desc ��ȡ�ļ��Ĵ�С(��λ:�ֽ�)
	 * @param file: File����
	 * @return �ļ��ֽڴ�С( ��С + byte )
	 */
	public static String getFileLength(File file) {
		long len = 0;
		if (file == null || !file.exists()) {
			return "�ļ��쳣";
		} else {
			if (file.isFile()) {
				len += file.length();
			} else {
				for (File s : file.listFiles())
					getFileLength(s);
			}
		}
		return len + "byte";
	}
}
