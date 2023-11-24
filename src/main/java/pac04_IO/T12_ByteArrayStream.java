package pac04_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TFC
 * @date   2019��7��9�� ����2:17:09
 * @note   �ֽ�������
 * 
 * ByteArrayInputStream/ByteArrayOutputStream
 * 1.����Ҫ��close()����
 * 2.���Է�װ�ַ����ֽڡ�����ȵ��ֽ������У�����IO����
 * 3.IO��Դ���ֽ�����
 * 4.���������ǵ����ڴ�
 */
public class T12_ByteArrayStream {
	
	public static void main(String[] args) {
		ByteArrayOutputStream();
			
	}
	static void ByteArrayInputStream() {
		byte[] src ="123456789".getBytes();
		InputStream in=null;
		
		try {
			in=new ByteArrayInputStream(src);
			byte[] buffer =new byte[1024];
			int len=-1;
			while((len=in.read(buffer))!=-1) {
				String s1=new String(buffer,0,len);
				System.out.println(s1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ByteArrayOutputStream() {
		ByteArrayOutputStream out=null;
		byte[] dest =null;
		try {
			//д������
			out=new ByteArrayOutputStream();
			byte[] src="ABCDEFGH".getBytes();
			out.write(src, 0, src.length);
			out.flush();
			//��ȡ����
			dest= out.toByteArray();
			System.out.println(new String(dest,0,dest.length));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
