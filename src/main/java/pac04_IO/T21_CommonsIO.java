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
 * @date   2019��7��12�� ����7:14:02
 * @note   CommonsIO��������
 * 1.����ļ���С
 * 2.�г���Ŀ¼
 * 3.��ȡ�ı�
 * 4.д���ı�
 * 5.�����ļ�
 * 6.��ȡ��ҳ����
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
	
	//1.�ļ���С
	static void sizeOf() {
		long size1=FileUtils.sizeOf(f1);
		System.out.println(size1);
	}
	//2.�г���Ŀ¼
	static void fileList() {
		//listFiles(�ļ�����,�Ƿ���ļ�,�г���Ŀ¼)
		Collection<File> files=FileUtils.listFiles(f2,
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		
		//�г�����
		for (File file : files) {
			System.out.println(file.getName());
		}
		System.out.println("������������������������������������");
		//ɸѡһ������
		files=FileUtils.listFiles(f3,
				new SuffixFileFilter("png"), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getName());
		}
		System.out.println("������������������������������������");
		//ɸѡ��������
		//or��������һ�֣�and����ȫ����
		files=FileUtils.listFiles(f3,
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("png")), 
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	//3.��ȡ�ĵ�
	static void readFile() throws IOException {
		//�����ȡ
		String str=FileUtils.readFileToString(f4,"gbk");
		System.out.println(str);
		System.out.println("������������������������������������");
		//���ж�ȡ
		List<String> data=FileUtils.readLines(f4,"gbk");
		for (String string : data) {
			System.out.println(string);
		}
	}
	//4.д���ļ�
	static void writeFile() throws IOException {
		String str="123456789";
		File f=new File("newtxt");
		//����1��д���ַ���
		FileUtils.write(f, str,"gbk");
		//����2��д���ֽ�����
		FileUtils.writeByteArrayToFile(f, str.getBytes(),true);	
		//д��list������ݵ��ı�
	
		List<String> data=new ArrayList<String>();
		data.add("1");data.add("2");data.add("3");
		FileUtils.writeLines(f, "gbk", data);
	}
	//5.�����ļ�
	static void copyFile() throws IOException {
		FileUtils.copyFile(f1,new File("9demo.jpg"));
	}
	//6.��ȡ��ҳhtml
	static void getHtml() throws MalformedURLException, IOException {
		System.out.println(IOUtils.
				toString(new URL("http://www.baidu.com"),"gbk"));
	}
}
