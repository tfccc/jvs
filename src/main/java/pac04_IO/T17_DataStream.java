package pac04_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author TFC
 * @date   2019年7月10日 下午2:09:30
 * @note   数据流
 * 
 * 1.数据流的操作对象是基本数据类型(String char...)
 * 2.处理数据时要保持"读写顺序一致"
 */
public class T17_DataStream {

	public static void main(String[] args) throws IOException {
	
		ByteArrayOutputStream baout=new ByteArrayOutputStream();
		DataOutputStream dout=
				new DataOutputStream(
						new BufferedOutputStream(baout));
		//写出数据
		dout.writeInt(123);
		dout.writeUTF("ABC");
		dout.writeBoolean(true);
		dout.flush();
		byte data[]=baout.toByteArray();
		
		DataInputStream di=
				new DataInputStream(
						new BufferedInputStream(
								new ByteArrayInputStream(data)));
		//读取数据
		int a=di.readInt();
		String s=di.readUTF();
		boolean b=di.readBoolean();
		
		System.out.println(b);

	}

}
