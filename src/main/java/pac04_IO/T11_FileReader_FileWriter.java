package pac04_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author TFC
 * @date   2019年7月7日 上午11:30:39
 * @note   字符流读写文本内容(当包含中文字符时，避免乱码)
 */

public class T11_FileReader_FileWriter {
	
	public static void main(String[] args) {
		FileWriter();
	}
	
	static void FileReader() {
		File f1=new File("IOtest1");
		Reader reader=null;
		try {
			reader=new FileReader(f1);
			//byte改为char
			char[] buffer =new char[1024];
			int len=-1;
			while((len=reader.read(buffer))!=-1) {
				String s1=new String(buffer, 0, len);
				System.out.println(s1);
			}
			
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader!=null) {
					reader.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void FileWriter() {
		File f1=new File("IOtest2");
		Writer writer=null;
		try {
			writer=new FileWriter(f1);
			
			//写入方法1:直接写入指定字符串
			String s1="\n测试数据1";
			writer.write(s1);
			
			//写入方法2:字符串转字符数组,再写入
			/*String s2="\n测试数据2";
			char data[]=s2.toCharArray();
			writer.write(data, 0, data.length);*/
			
			//写入方法3:append方法追加内容
			/*writer.append("123").append("\nabc").append("ABC");*/
			
			writer.flush();
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer!=null) {
					writer.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
