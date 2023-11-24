package pac04_IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author TFC
 * @date   2019��7��7�� ����12:20:24
 * @note   �����ļ�����(FileReader/FileWriter)
 * 		     (��Ϊ�õ��ַ������������ı���������)
 */
public class T23_FileCopy2_char {
	
	public static void copy(File fpre,File fnew) {
		Reader reader=null;
		Writer writer=null;
		
		try {
			reader=new FileReader(fpre);
			writer=new FileWriter(fnew);
			char buffer[]=new char[1024];
			int len=-1;
			
			while((len=reader.read(buffer))!=-1) {
				String s1=new String(buffer, 0, len);
				writer.append(s1);
			}
			
			writer.flush();
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer!=null) { writer.close(); }
				if(reader!=null) { reader.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
