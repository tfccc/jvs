package pac01_Basics;


/**
 * @author TFC
 * @date   2019��6��13�� ����7:51:17
 * @note   Integer������Ļ������
 */
public class T11_Cache {

	public static void main(String[] args) {
		/*1.����Integer����ʱ����������Զ�����һ��
		  (-128����127�Ļ�������)������������ֵ��
		    ������䣬�ͽ������ֵ���������Ķ��󣬱�
		    ��ʱ������ͬ��
		  2.������ڸ����䣬���½�һ�����󲢸�ֵ����
		    ��ʱ���ڶ���ͬ�����߾Ͳ��ȡ�
		  3.���������ҪΪ������һ�����õ����䷶Χ��
		    �ö�����ռ��ϵͳ��Դ��
		*/
		Integer n1=500;
		Integer n2=500;
		System.out.println(n1==n2);
		
		Integer n3=1;
		Integer n4=1;
		System.out.println(n3==n4);
		
	}

}
