package pac01_Basics;

/**
 * @author TFC
 * @date   2019��6��12�� ����11:26:52
 * @note   �ڲ������
 */
public class T05_InnerClass {

	/*�Ǿ�̬�ڲ���ʾ��*/
	static class out {
		private int age=20;
		
		public int getName() {
			return age;
		}

		public void setName(int name) {
			this.age = name;
		}

		//�ڲ���(in��out�ڲ�)
		class in{
			void showname() {
				System.out.println(out.this.age);
			}
			void setname() {
				out.this.age=18;
			}
		}
	}

	public static void main(String[] args) {
		//�����ڲ���
		
		out.in inner=new out().new in();
		inner.setname();
		inner.showname();
	}
}
