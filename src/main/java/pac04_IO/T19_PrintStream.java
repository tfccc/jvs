package pac04_IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import utils.IOStream;
 
/**
 * @author TFC
 * @date   2019年7月12日 下午4:56:56
 * @note   打印流(方便打印各种数据)
 */
public class T19_PrintStream{
	
	public static void main(String[] args) throws FileNotFoundException {
		//打印数据到文本中
		PrintStream pStream=
				new PrintStream(
						new BufferedOutputStream(
								//true表示自动刷新
								new FileOutputStream("printstream.txt")),true);
		
		pStream.println(123);
		pStream.println("abc");
		IOStream.close(pStream);
	}
	
}
