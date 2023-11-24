package pac04_IO;

import utils.IOStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author TFC
 * @date   2019年7月10日 上午11:40:28
 * @note   用字符流拷贝文件内容(含readline(),newline()方法)
 */
public class T25_FileCopy4_BufferedChar {
	
	public static void copy(String path1,String path2) {
		File fpre=new File(path1);
		File fnew=new File(path2);
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			reader=new BufferedReader(new FileReader(fpre)) ;
			writer=new BufferedWriter(new FileWriter(fnew)) ;
			String line=null;
			
			//一行一行地读取，读一次换行
			while((line=reader.readLine())!=null) {
				writer.write(line);
				writer.newLine();
			}
			
			writer.flush();
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			IOStream.close(writer,reader);
		}
	}
}
