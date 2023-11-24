package pac01_Basics;


/**
 * @author TFC
 * @date   2019年6月13日 下午7:51:17
 * @note   Integer类里面的缓存机制
 */
public class T11_Cache {

	public static void main(String[] args) {
		/*1.创建Integer对象时，虚拟机会自动生成一个
		  (-128——127的缓存数组)，即如果定义的值在
		    这个区间，就将数组的值赋给创建的对象，比
		    较时两者相同。
		  2.如果不在该区间，则新建一个对象并赋值，比
		    较时由于对象不同，两者就不等。
		  3.缓存机制主要为了生成一个常用的区间范围，
		    让对象少占用系统资源。
		*/
		Integer n1=500;
		Integer n2=500;
		System.out.println(n1==n2);
		
		Integer n3=1;
		Integer n4=1;
		System.out.println(n3==n4);
		
	}

}
