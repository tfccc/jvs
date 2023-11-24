package pac04_IO;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author TFC
 * @date   2019��7��5�� ����2:59:08
 * @note   ���롢���롢����
 *
 *  ����:�ַ�����>�ֽ�
 *  ����:�ֽڡ���>�ַ�
 *
 */

public class T06_EncodeDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String st="һ��������1";
		//���� getBytes()
		byte[] bytes=st.getBytes();
		System.out.println(bytes.length);
		
		//����(�ַ���ԭΪ�ַ���)
		st=new String(bytes,"gbk");
		System.out.println(st+"\n");
		
		//����
		//1.�ֽ�������
		st=new String(bytes,0,bytes.length-2,"gbk");
		System.out.println(st);
		//2.�ַ�������ȷ
		st=new String(bytes,0,bytes.length-2, StandardCharsets.UTF_8);
		System.out.println(st);
	}

}
