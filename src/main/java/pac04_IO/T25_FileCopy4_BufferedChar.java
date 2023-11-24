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
 * @date   2019��7��10�� ����11:40:28
 * @note   ���ַ��������ļ�����(��readline(),newline()����)
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
			
			//һ��һ�еض�ȡ����һ�λ���
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
