package pac01_Basics;

/**
 * @author TFC
 * @date 2019��9��10�� ����11:06:26
 * @note Խ���ж�ѭ��: ��ѭ����������ǩ
 */
public class T13_CrossLayerBreak {
	static final  int s=123;

	public static void main(String[] args) {
		//Խ���ж�ѭ��
		target:
		for(int i=0;i<=3;i++) {
			System.out.println(1);
			
			for(int j=0;j<3;j++){
				//System.out.println(".");
				if(i==2)
					break target;
			}
			System.out.println(2);
			
			System.out.println("****");
		}
	}
}
