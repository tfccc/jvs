package pac01_Basics;

/**
 * @author TFC
 * @date   2019��6��15�� ����7:02:30
 * @note   ��ϣ�����
 *
 * 1.��ͬ���������͵Ĺ�ϣ����㷽����ͬ
 * 2.java�涨equals����true��ʱ�����ߵĹ�ϣ��Ҫ��ͬ
 * 3.����õ���ϣ�����ͨ���㷨�����㣬���������ɢ����
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
