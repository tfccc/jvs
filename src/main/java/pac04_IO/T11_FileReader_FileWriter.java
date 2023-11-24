package pac04_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author TFC
 * @date   2019��7��7�� ����11:30:39
 * @note   �ַ�����д�ı�����(�����������ַ�ʱ����������)
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
			//byte��Ϊchar
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
			
			//д�뷽��1:ֱ��д��ָ���ַ���
			String s1="\n��������1";
			writer.write(s1);
			
			//д�뷽��2:�ַ���ת�ַ�����,��д��
			/*String s2="\n��������2";
			char data[]=s2.toCharArray();
			writer.write(data, 0, data.length);*/
			
			//д�뷽��3:append����׷������
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
