package pac01_Basics;

/**
 * @author TFC
 * @date 2019年9月10日 下午11:06:26
 * @note 越层中断循环: 在循环体外加入标签
 */
public class T13_CrossLayerBreak {
	static final  int s=123;

	public static void main(String[] args) {
		//越层中断循环
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
