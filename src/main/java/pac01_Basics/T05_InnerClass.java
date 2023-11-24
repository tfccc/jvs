package pac01_Basics;

/**
 * @author TFC
 * @date   2019年6月12日 下午11:26:52
 * @note   内部类测试
 */
public class T05_InnerClass {

	/*非静态内部类示例*/
	static class out {
		private int age=20;
		
		public int getName() {
			return age;
		}

		public void setName(int name) {
			this.age = name;
		}

		//内部类(in在out内部)
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
		//定义内部类
		
		out.in inner=new out().new in();
		inner.setname();
		inner.showname();
	}
}
