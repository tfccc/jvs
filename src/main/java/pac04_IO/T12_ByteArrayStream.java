package pac04_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TFC
 * @date   2019年7月9日 下午2:17:09
 * @note   字节数组流
 * 
 * ByteArrayInputStream/ByteArrayOutputStream
 * 1.不需要用close()方法
 * 2.可以封装字符、字节、对象等到字节数组中，进行IO操作
 * 3.IO的源是字节数组
 * 4.操作对象是电脑内存
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
			//写出数据
			out=new ByteArrayOutputStream();
			byte[] src="ABCDEFGH".getBytes();
			out.write(src, 0, src.length);
			out.flush();
			//获取数据
			dest= out.toByteArray();
			System.out.println(new String(dest,0,dest.length));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
