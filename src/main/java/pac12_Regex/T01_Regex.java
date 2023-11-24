package pac12_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TFC
 * @date   2019��8��15�� ����11:21:14
 * @note   Java������ʽӦ��
 *
 * �����б�
 *	 1.test1()�� matchesƥ�������ַ���
 *	 2.test2()�� find�����Ӵ�
 *	 3.test3()�� find�����Ӵ�,group��ӡ
 *	 4.test4()�� find���Ҳ�����,group(index)��ӡ
 * 	 5.test5()�� replace�滻
 *
 */
public class T01_Regex {
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
	}

	//1.matchesƥ�������ַ���
	private static void test1() {
		String str="abcdef123456";
		Pattern pattern=Pattern.compile("\\w+");
		Matcher matcher= pattern.matcher(str);
		//ƥ�������ַ���
		boolean isMatch= matcher.matches();
		System.out.println(isMatch);
	}

	//2.find�����Ӵ�
	private static void test2() {
		String str = "abcdef && 123456 & 1";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		//��ָ�����ʽ����ƥ���Ӵ�
		boolean isMatch1 = matcher.find();
		boolean isMatch2 = matcher.find();
		//ƥ�����κ�,�����ڿ�ƥ�����
		boolean isMatch3 = matcher.find();
		boolean isMatch4 = matcher.find();
		System.out.println(isMatch1);
		System.out.println(isMatch2);
		System.out.println(isMatch3);
		System.out.println(isMatch4);
	}

	//3.find�����Ӵ�,group��ӡ
	private static void test3() {
		String str = "abcdef && 123456 & 1";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		//����ƥ���Ӵ�,��ӡ�Ӵ�
		/*matcher.find();
		  System.out.println(matcher.group());*/
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	//4.find���Ҳ�����,group(index)��ӡ
	private static void test4() {
		String str = "abc123 && tfc556";
		Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
		Matcher matcher = pattern.matcher(str);
		//����ƥ���Ӵ�,��ӡ�Ӵ�

		while (matcher.find()) {
			System.out.println("������: " + matcher.group(0));
			System.out.println("�������Ӵ�1: " + matcher.group(1));
			System.out.println("�������Ӵ�2: " + matcher.group(2));
		}
	}

	//5.replace�滻
	private static void test5() {
		String str = "abc123 && tfc556";
		Pattern pattern = Pattern.compile("([0-9])");
		Matcher matcher = pattern.matcher(str);
		//����ƥ���Ӵ�,��ӡ�Ӵ�

		//String newStr = matcher.replaceAll("#");
		String newStr = matcher.replaceFirst("#");
		System.out.println(newStr);
	}
}
