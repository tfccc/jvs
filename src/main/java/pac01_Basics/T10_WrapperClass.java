package pac01_Basics;


/**
 * @author TFC
 * @date   2019��6��13�� ����7:36:40
 * @note   ��װ���ʹ��
 */
@SuppressWarnings("all")
public class T10_WrapperClass {

	public static void main(String[] args) {
		//������תΪ��װ�����(3��)
		Integer a=new Integer(3);
		//�Ƽ�����
		Integer b=Integer.valueOf(3);
		//�Զ�װ��(�൱��Integer b=Integer.valueOf(3))
		Integer c=3;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(Integer.MAX_VALUE);

		// ����-128��127֮�����������л���. ����-128~127�Ļ��Զ�new����
		Integer x = 1000;
		Integer y = 1000;
		System.out.println(x == y);

	}


}
