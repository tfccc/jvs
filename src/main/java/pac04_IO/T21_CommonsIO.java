package pac04_IO;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * @author TFC
 * @date   2019年7月12日 下午7:14:02
 * @note   CommonsIO常用样例
 * 1.输出文件大小
 * 2.列出子目录
 * 3.读取文本
 * 4.写入文本
 * 5.拷贝文件
 * 6.爬取网页内容
 */
public class T21_CommonsIO {
	static File f1=new File("img/ball.png");
	static File f2=new File("C:\\Users\\82818\\Desktop\\Java\\IO_test");
	static File f3=new File("F:\\JavaWorkspace\\workspace\\Java_2019.06.10");
	static File f4=new File("F:\\JavaWorkspace\\workspace\\Java_2019.06.10\\test1");
	public static void main(String[] args) throws IOException {
		sizeOf();
		//fileList();
		//readFile();
		//writeFile();
		//copyFile();
		//getHtml();
	}
	
	//1.文件大小
	static void sizeOf() {
		long size1=FileUtils.sizeOf(f1);
		System.out.println(size1);
	}
	//2.列出子目录
	static void fileList() {
		//listFiles(文件对象,是否空文件,列出子目录)
		Collection<File> files=FileUtils.listFiles(f2,
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		
		//列出所有
		for (File file : files) {
			System.out.println(file.getName());
		}
		System.out.println("——————————————————");
		//筛选一种类型
		files=FileUtils.listFiles(f3,
				new SuffixFileFilter("png"), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getName());
		}
		System.out.println("——————————————————");
		//筛选多种类型
		//or至少满足一种，and条件全满足
		files=FileUtils.listFiles(f3,
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("png")), 
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	//3.读取文档
	static void readFile() throws IOException {
		//整体读取
		String str=FileUtils.readFileToString(f4,"gbk");
		System.out.println(str);
		System.out.println("——————————————————");
		//逐行读取
		List<String> data=FileUtils.readLines(f4,"gbk");
		for (String string : data) {
			System.out.println(string);
		}
	}
	//4.写出文件
	static void writeFile() throws IOException {
		String str="123456789";
		File f=new File("newtxt");
		//方法1：写入字符串
		FileUtils.write(f, str,"gbk");
		//方法2：写入字节数组
		FileUtils.writeByteArrayToFile(f, str.getBytes(),true);	
		//写出list里的数据到文本
	
		List<String> data=new ArrayList<String>();
		data.add("1");data.add("2");data.add("3");
		FileUtils.writeLines(f, "gbk", data);
	}
	//5.拷贝文件
	static void copyFile() throws IOException {
		FileUtils.copyFile(f1,new File("9demo.jpg"));
	}
	//6.爬取网页html
	static void getHtml() throws MalformedURLException, IOException {
		System.out.println(IOUtils.
				toString(new URL("http://www.baidu.com"),"gbk"));
	}
}
