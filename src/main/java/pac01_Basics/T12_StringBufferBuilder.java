package pac01_Basics;

/**
 * @author TFC
 * @date   2019��6��13�� ����8:08:57
 * @note   StringBuffer��StringBuilder����
 */
public class T12_StringBufferBuilder {

	public static void main(String[] args) {
		/*StringΪ�����ɱ��ַ�����
		 *StringBuffer��StringBuilder���߶��ǡ��ɱ��ַ�����
		 *StringBuffer��ȫ�ߡ�Ч�ʵ�
		 *StringBuilder��ȫ�͡�Ч�ʸ�(�Ƽ�ʹ��)
		 * */
		
		StringBuilder sBuilder=new StringBuilder("ABCDE");
		System.out.println("�޸�ǰ:"+sBuilder);
		sBuilder.setCharAt(0, '1');
		System.out.println("�޸ĺ�:"+sBuilder);
		
	}

}
