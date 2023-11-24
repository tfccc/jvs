package pac04_IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import utils.IOStream;

/**
 * @author TFC
 * @date   2019年7月12日 下午5:23:39
 * @note   随机流
 */
public class T20_RandomAccessFile {
	public static void main(String[] args) throws IOException {
		testRandom2();
	}
	
	//从文档的第seek(n)个字符开始，全部读取
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
	
	//读取文档中一部分区域
	public static void testRandom2() throws IOException{
		File file=new File("test1");
		RandomAccessFile raf=new RandomAccessFile(file,"r");
		//起始位置
		int begin   =2;
		//需要读的长度
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
