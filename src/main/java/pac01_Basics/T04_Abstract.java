package pac01_Basics;

/**
 * @author TFC
 * @date   2019��6��12�� ����11:18:31
 * @note   abstract�ؼ���; ������
 *
 * 1.�����ķ���δ��ʵ��
 * 2.��������������̳�
 * 3.Ϊ�����ṩһ��ģ�壬�������б���ʵ��
 * 4.�����෽������������ʵ��
 *
 */
public abstract class T04_Abstract {

	abstract public void shout();
	
	public static class TestAbstract2 extends T04_Abstract{
		//�̳к��Զ���ӵķ���
		@Override
		public void shout() {
		}

	}
}
