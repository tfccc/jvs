package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date   2019年6月28日 下午11:10:55
 * @note   创建File对象
 */

public class T02_CrateFileObject {
	public static void main(String[] args) {
		String path="C:\\Users\\82818\\Desktop\\Java\\JAVA_IO\\test02";
		
		//1.创建方法1
		File f1=new File(path);
		
		//2.创建方法2
		File f2=new File("C:\\Users\\82818\\Desktop\\壁纸","10");
		
		//3.创建方法3
		File f3=new File(new File(path),"1");
	}
}
