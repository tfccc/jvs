package pac04_IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import utils.IOStream;
 
/**
 * @author TFC
 * @date   2019��7��12�� ����4:56:56
 * @note   ��ӡ��(�����ӡ��������)
 */
public class T19_PrintStream{
	
	public static void main(String[] args) throws FileNotFoundException {
		//��ӡ���ݵ��ı���
		PrintStream pStream=
				new PrintStream(
						new BufferedOutputStream(
								//true��ʾ�Զ�ˢ��
								new FileOutputStream("printstream.txt")),true);
		
		pStream.println(123);
		pStream.println("abc");
		IOStream.close(pStream);
	}
	
}
