package pac01_Basics;

/**
 * @author TFC
 * @date   2019年6月15日 下午7:02:30
 * @note   哈希码测试
 *
 * 1.不同的数据类型的哈希码计算方法不同
 * 2.java规定equals返回true的时候，两者的哈希码要相同
 * 3.计算得到哈希码后，再通过算法的运算，将对象存入散列中
 * 
 * */
public class T15_HashCode {

	public static void main(String[] args) {
		Integer integer=12352;
		System.out.println(integer.hashCode());
		
		String string="sadf";
		System.out.println(string.hashCode());
		
		Character character='1';
		System.out.println(character.hashCode());
		
		Long long1=(long) 123;
		System.out.println(long1.hashCode());
	}
}
