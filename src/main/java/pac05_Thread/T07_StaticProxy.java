package pac05_Thread;

/**
 * @author TFC
 * @date   2019��7��15�� ����9:37:28
 * @note   �̵߳ľ�̬����(���칫˾����ٰ����Ϊ��)
 * 
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * 
 */
public class T07_StaticProxy {
	public static void main(String[] args) {
		Couple couple=new Couple();
		couple.marry();
		new WeddingCompany(couple).marry();
	}
}

//(Runnable�ӿ�)
interface Marry{ void marry(); }

//��Ҫʵ�ֶ��̵߳���
class Couple implements Marry{

	@Override
	public void marry() {
		System.out.println("1.׼�����");
	}
}
//������
class WeddingCompany implements Marry{
	//��Ҫ����Ľ�ɫ(��ʵ��ɫ)
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}
	@Override
	public void marry() {
		System.out.println("2.�ﱸ����");
	}
}