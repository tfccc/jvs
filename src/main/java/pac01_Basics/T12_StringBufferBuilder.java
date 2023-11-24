package pac01_Basics;

/**
 * @author TFC
 * @date   2019年6月13日 下午8:08:57
 * @note   StringBuffer、StringBuilder测试
 */
public class T12_StringBufferBuilder {

	public static void main(String[] args) {
		/*String为“不可变字符串”
		 *StringBuffer、StringBuilder两者都是“可变字符串”
		 *StringBuffer安全高、效率低
		 *StringBuilder安全低、效率高(推荐使用)
		 * */
		
		StringBuilder sBuilder=new StringBuilder("ABCDE");
		System.out.println("修改前:"+sBuilder);
		sBuilder.setCharAt(0, '1');
		System.out.println("修改后:"+sBuilder);
		
	}

}
