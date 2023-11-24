package pac04_IO;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;

/**
 * @author TFC
 * @date   2019年7月6日 下午3:28:39
 * @note   io,文本写入标准样例
 *
 * 步骤：
 *	 1.创建源
 *	 2.选择流
 *	 3.操作源
 *	 4.释放资源
 */
public class T09_WriteFile {

	public static void main(String[] args) throws IOException {

		File file=new File("IOtest2");

		try (OutputStream out = new FileOutputStream(file, true)) {
			String s = "写入文本第二行\n\t第二行";
			byte[] data = s.getBytes();
			out.write(data, 0, data.length);
			//刷新，避免内存滞留
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
