package pac04_IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import utils.IOStream;

/**
 * @author TFC
 * @date   2019��7��12�� ����5:23:39
 * @note   �����
 */
public class T20_RandomAccessFile {
	public static void main(String[] args) throws IOException {
		testRandom2();
	}
	
	//���ĵ��ĵ�seek(n)���ַ���ʼ��ȫ����ȡ
	public static void testRandom1() throws IOException {
		File file=new File("test1");
		RandomAccessFile raf=new RandomAccessFile(file,"r");
		
		raf.seek(2);
		byte buffer[]=new byte[100];
		int len=-1; 
		while((len=raf.read(buffer))!=-1) {
			System.out.println(new String(buffer,0,len));
		}
		IOStream.close(raf);
	}
	
	//��ȡ�ĵ���һ��������
	public static void testRandom2() throws IOException{
		File file=new File("test1");
		RandomAccessFile raf=new RandomAccessFile(file,"r");
		//��ʼλ��
		int begin   =2;
		//��Ҫ���ĳ���
		int tempsize=10;
		raf.seek(begin);
		byte buffer[]=new byte[4];
		int len=-1; 
		while((len=raf.read(buffer))!=-1) {
			if (tempsize>len) {
				System.out.println(new String(buffer,0,len));
				tempsize-=len;
			}
			else {
				System.out.println(new String(buffer,0,tempsize));
				break;
			}
		}
		IOStream.close(raf);
	}
}
