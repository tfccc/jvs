package pac08_DS;

import java.util.Arrays;

/**
 * @author TFC
 * @date   2019��6��13�� ����7:11:59
 * @note   ð�������Ż�
 */
public class T04_BubbleSort {
	
	static void BubbleSort(int values[]) {
		int temp=0;
		for(int i=0;i<values.length-1;i++) {
			//�Ż�:ͨ����ǰ�жϣ�ѭ����û�н������ݣ�
			boolean flag=true;
			for (int j = 0; j < values.length-i-1; j++) {
				//ð�ݣ��Ƚ����ڴ�С������˳��
				if(values[j]>values[j+1]) {
					flag=false;
					temp=values[j];
					values[j]=values[j+1];
					values[j+1]=temp;
				}
				//System.out.println(Arrays.toString(values));
				
			}
			if(flag) {
				//System.out.println("�Ż�������ǰ����");
				break;
			}
			//System.out.println("--------------------");
		}
		//System.out.println("\n"+"ð��������Ϊ:");
		System.out.println(Arrays.toString(values));
	}
	
	public static void main(String[] args) {
		int values1[]= {8,9,5,1,0,4,3,7,2,6};
		//int values2[]= {9,8,7,6,5,4,1,3,2,0};
		BubbleSort(values1);
	}

}
