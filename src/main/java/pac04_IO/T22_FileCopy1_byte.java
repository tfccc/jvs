package pac04_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author TFC
 * @date   2019年7月6日 下午4:05:12
 * @note   拷贝文件内容(FileInputStream/FileOutputStream)
 *
 * 	(只能拷贝非中文等内容)
 * 	思路：先读取原件内容，再写入新文本
 */
public class T22_FileCopy1_byte {
	
	public static void copy(File file_pre,File file_new){
		InputStream  in =null;
		OutputStream out=null;
		try {
			in =new FileInputStream (file_pre);
			out=new FileOutputStream(file_new);
			
			byte buffer[]=new byte[1024];
			int len=-1;
			
			while((len=in.read(buffer))!=-1) {
				out.write(buffer, 0,len);
			}
			
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//先打开的后关闭
				if(out!=null) { out.close(); }
				if(in !=null) { in.close(); }

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
