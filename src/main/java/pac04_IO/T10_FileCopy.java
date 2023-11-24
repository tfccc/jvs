package pac04_IO;

import java.io.File;

/**
 * @author TFC
 * @date   2019年7月6日 下午3:59:42
 * @note   文件内容拷贝
 */
public class T10_FileCopy {

	public static void main(String[] args) {
		//调用FileCopy1
		File f1=new File("IOtest2");
		File f2=new File("CopiedFile");
		T22_FileCopy1_byte.copy(f1, f2);
		
		//调用FileCopy2
		/*File f11=new File("IOtest1");
		File f22=new File("CopiedFile");
		FileCopy2.copy(f11, f22);*/
	}
}
