package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date   2019��6��28�� ����11:10:55
 * @note   ����File����
 */

public class T02_CrateFileObject {
	public static void main(String[] args) {
		String path="C:\\Users\\82818\\Desktop\\Java\\JAVA_IO\\test02";
		
		//1.��������1
		File f1=new File(path);
		
		//2.��������2
		File f2=new File("C:\\Users\\82818\\Desktop\\��ֽ","10");
		
		//3.��������3
		File f3=new File(new File(path),"1");
	}
}
