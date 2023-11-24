package pac04_IO;

/**
 * @author TFC
 * @date   2019年7月9日 下午8:02:22
 * @note   IO类实现原理——装饰器设计模式演示
 * 
 */
public class T13_Decoration {

	public static void main(String[] args) {
		Person person=new Person();
		person.say();
		
		//装饰person
		Amplifier amplifier=new Amplifier(person);
		amplifier.say();
	}

}
//接口(或需要装饰的对象)
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
		System.out.println("现在声音大小是:"+voice+"分贝");
	}
}
//装饰类
class Amplifier implements Say{
	private Person person;
	//构造器，在初始化装饰类时，传入被装饰类
	public Amplifier(Person person) {
		this.person=person;
	}
	@Override
	public void say() {
		System.out.println("扩音后的声音是:"+person.getVoice()*10+"分贝");
	}
	
}