package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月15日 上午9:37:28
 * @note   线程的静态代理(婚庆公司代理举办婚礼为例)
 * 
 * 1.真实角色
 * 2.代理角色
 * 
 */
public class T07_StaticProxy {
	public static void main(String[] args) {
		Couple couple=new Couple();
		couple.marry();
		new WeddingCompany(couple).marry();
	}
}

//(Runnable接口)
interface Marry{ void marry(); }

//需要实现多线程的类
class Couple implements Marry{

	@Override
	public void marry() {
		System.out.println("1.准备结婚");
	}
}
//代理类
class WeddingCompany implements Marry{
	//需要代理的角色(真实角色)
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}
	@Override
	public void marry() {
		System.out.println("2.筹备婚礼");
	}
}