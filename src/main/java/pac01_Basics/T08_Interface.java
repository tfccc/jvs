package pac01_Basics;

/**
 * @author TFC
 * @date   2019��6��15�� ����1:11:48
 * @note   �ӿ�: һ�ֹ����Ĺ淶��׼
 *
 * 1.�ӿ������ڳ����࣬�ȳ���������󣬲��ṩ�κ�ʵ�ֵķ���
 * 2.�ӿ���Ҫ���ڶ���һ�ֹ淶
 * 3.ʵ��(�淶)��(����ʵ��)�ķ���
 * 4.��ʵ�ֶ���̳�
 * 5.Ĭ�Ͻӿ�Ϊpublic(�ڵ������ı���)��Ĭ��(��һ��������)
 * 6.Ĭ�ϳ���public static final ����
 * 7.�ӿڷ����� public abstract ����
 *
 */
public class T08_Interface implements inter1,inter2{

	@Override	//��һ���ӿڵķ���
	public void showDetail() {
		System.out.println("name:"+NAME);
		System.out.println("age:"+AGE);
	}
	@Override	//�ڶ����ӿڵķ���
	public void secondMethod() {
		
	}
	public static void main(String[] args) {

		T08_Interface t=new T08_Interface();
		t.showDetail();
		
	}
}

interface inter1{
	int AGE=20;	//�Ǿ�̬����
	String NAME="TFC";
	void showDetail();
}

interface inter2{
	void secondMethod();
}