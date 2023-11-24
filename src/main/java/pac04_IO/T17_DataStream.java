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
 * @date   2019��7��10�� ����2:09:30
 * @note   ������
 * 
 * 1.�������Ĳ��������ǻ�����������(String char...)
 * 2.��������ʱҪ����"��д˳��һ��"
 */
public class T17_DataStream {

	public static void main(String[] args) throws IOException {
	
		ByteArrayOutputStream baout=new ByteArrayOutputStream();
		DataOutputStream dout=
				new DataOutputStream(
						new BufferedOutputStream(baout));
		//д������
		dout.writeInt(123);
		dout.writeUTF("ABC");
		dout.writeBoolean(true);
		dout.flush();
		byte data[]=baout.toByteArray();
		
		DataInputStream di=
				new DataInputStream(
						new BufferedInputStream(
								new ByteArrayInputStream(data)));
		//��ȡ����
		int a=di.readInt();
		String s=di.readUTF();
		boolean b=di.readBoolean();
		
		System.out.println(b);

	}

}
