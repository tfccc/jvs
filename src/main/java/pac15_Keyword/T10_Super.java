package pac15_Keyword;

/**
 * @author TFC
 * @date   2019��6��13�� ����6:23:37
 * @note   super�ؼ��ֲ���
 */
public class T10_Super {

	class Father{
		public int age;
		void showAge() {
			age=40;
			System.out.println("���׵�����:"+age);
		}
	}
	
	class Son extends Father{
		private int age;
		void showAge() {
			//���ø������ķ���(super.showage()�൱��ֱ���ø���ķ���)
			super.showAge();
			age=18;
			System.out.println("���ӵ�����:"+age);
			//super.age���ø����Ա����
			System.out.println("ͨ��super���ʸ��׵�����:"+super.age);
		}
	}
	
	public static void main(String[] args) {
		//�ڲ�����ã�û���ⲿ����Ϊʵ�����޷������ڲ���
		T10_Super tSuper=new T10_Super();
		Father father=tSuper.new Father();
		father.showAge();
		
		T10_Super tSuper2=new T10_Super();
		Son son=tSuper2.new Son();
		son.showAge();
	}
}
