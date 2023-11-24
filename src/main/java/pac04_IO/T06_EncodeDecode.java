package pac04_IO;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author TFC
 * @date   2019年7月5日 下午2:59:08
 * @note   编码、解码、乱码
 *
 *  编码:字符——>字节
 *  解码:字节——>字符
 *
 */

public class T06_EncodeDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String st="一二三四五1";
		//编码 getBytes()
		byte[] bytes=st.getBytes();
		System.out.println(bytes.length);
		
		//解码(字符还原为字符串)
		st=new String(bytes,"gbk");
		System.out.println(st+"\n");
		
		//乱码
		//1.字节数不够
		st=new String(bytes,0,bytes.length-2,"gbk");
		System.out.println(st);
		//2.字符集不正确
		st=new String(bytes,0,bytes.length-2, StandardCharsets.UTF_8);
		System.out.println(st);
	}

}
