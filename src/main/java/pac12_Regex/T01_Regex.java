package pac12_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TFC
 * @date   2019年8月15日 上午11:21:14
 * @note   Java正则表达式应用
 *
 * 测试列表
 *	 1.test1()： matches匹配整个字符串
 *	 2.test2()： find查找子串
 *	 3.test3()： find查找子串,group打印
 *	 4.test4()： find查找捕获组,group(index)打印
 * 	 5.test5()： replace替换
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

	//1.matches匹配整个字符串
	private static void test1() {
		String str="abcdef123456";
		Pattern pattern=Pattern.compile("\\w+");
		Matcher matcher= pattern.matcher(str);
		//匹配整个字符串
		boolean isMatch= matcher.matches();
		System.out.println(isMatch);
	}

	//2.find查找子串
	private static void test2() {
		String str = "abcdef && 123456 & 1";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		//以指针的形式依次匹配子串
		boolean isMatch1 = matcher.find();
		boolean isMatch2 = matcher.find();
		//匹配两次后,不存在可匹配对象
		boolean isMatch3 = matcher.find();
		boolean isMatch4 = matcher.find();
		System.out.println(isMatch1);
		System.out.println(isMatch2);
		System.out.println(isMatch3);
		System.out.println(isMatch4);
	}

	//3.find查找子串,group打印
	private static void test3() {
		String str = "abcdef && 123456 & 1";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		//依次匹配子串,打印子串
		/*matcher.find();
		  System.out.println(matcher.group());*/
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	//4.find查找捕获组,group(index)打印
	private static void test4() {
		String str = "abc123 && tfc556";
		Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
		Matcher matcher = pattern.matcher(str);
		//依次匹配子串,打印子串

		while (matcher.find()) {
			System.out.println("捕获组: " + matcher.group(0));
			System.out.println("捕获组子串1: " + matcher.group(1));
			System.out.println("捕获组子串2: " + matcher.group(2));
		}
	}

	//5.replace替换
	private static void test5() {
		String str = "abc123 && tfc556";
		Pattern pattern = Pattern.compile("([0-9])");
		Matcher matcher = pattern.matcher(str);
		//依次匹配子串,打印子串

		//String newStr = matcher.replaceAll("#");
		String newStr = matcher.replaceFirst("#");
		System.out.println(newStr);
	}
}
