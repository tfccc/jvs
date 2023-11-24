package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date   2019年7月4日 上午11:20:23
 * @note   计算文件夹大小
 */
public class T05_CountLength {
	public static void main(String[] args) {
		
		File f = new File("C:/Users/82818/Desktop/Java/IO_test");
		System.out.println(getFileLength(f));
	}

	/**
	 * @Desc 获取文件的大小(单位:字节)
	 * @param file: File对象
	 * @return 文件字节大小( 大小 + byte )
	 */
	public static String getFileLength(File file) {
		long len = 0;
		if (file == null || !file.exists()) {
			return "文件异常";
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
