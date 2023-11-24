package pac08_DS;

import java.util.Arrays;

/**
 * @author TFC
 * @date   2019年6月13日 下午7:11:59
 * @note   冒泡排序及优化
 */
public class T04_BubbleSort {
	
	static void BubbleSort(int values[]) {
		int temp=0;
		for(int i=0;i<values.length-1;i++) {
			//优化:通过提前判断（循环后没有交换数据）
			boolean flag=true;
			for (int j = 0; j < values.length-i-1; j++) {
				//冒泡，比较相邻大小，交换顺序
				if(values[j]>values[j+1]) {
					flag=false;
					temp=values[j];
					values[j]=values[j+1];
					values[j+1]=temp;
				}
				//System.out.println(Arrays.toString(values));
				
			}
			if(flag) {
				//System.out.println("优化排序，提前结束");
				break;
			}
			//System.out.println("--------------------");
		}
		//System.out.println("\n"+"冒泡排序结果为:");
		System.out.println(Arrays.toString(values));
	}
	
	public static void main(String[] args) {
		int values1[]= {8,9,5,1,0,4,3,7,2,6};
		//int values2[]= {9,8,7,6,5,4,1,3,2,0};
		BubbleSort(values1);
	}

}
