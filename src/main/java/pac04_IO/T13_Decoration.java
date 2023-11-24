package pac04_IO;

/**
 * @author TFC
 * @date   2019��7��9�� ����8:02:22
 * @note   IO��ʵ��ԭ����װ�������ģʽ��ʾ
 * 
 */
public class T13_Decoration {

	public static void main(String[] args) {
		Person person=new Person();
		person.say();
		
		//װ��person
		Amplifier amplifier=new Amplifier(person);
		amplifier.say();
	}

}
//�ӿ�(����Ҫװ�εĶ���)
interface Say{
	void say();
}

class Person implements Say{
	private int voice=10;

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}

	@Override
	public void say() {
		System.out.println("����������С��:"+voice+"�ֱ�");
	}
}
//װ����
class Amplifier implements Say{
	private Person person;
	//���������ڳ�ʼ��װ����ʱ�����뱻װ����
	public Amplifier(Person person) {
		this.person=person;
	}
	@Override
	public void say() {
		System.out.println("�������������:"+person.getVoice()*10+"�ֱ�");
	}
	
}