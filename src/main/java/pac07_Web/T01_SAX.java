package pac07_Web;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Objects;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author TFC
 * @date   2019年7月27日 下午2:19:19
 * @note   SAX对XML解析，并分析数据
 * 
 * SAX解析：
 * 1.获取解析工厂
 * 2.从工厂获取解析器
 * 3.自己编写处理器
 * 4.加载文档注册处理器
 * 
 */
public class T01_SAX {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		long a=System.currentTimeMillis();
		//1
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2
		SAXParser parser=factory.newSAXParser();
		//3
		//4
		PersonHandler handler=new PersonHandler();
		parser.parse(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().
				getResourceAsStream("pac07_Web/data1.xml")),handler);
		handler.travel();
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a));
	}
}
//解析数据，把数据加到容器里
class PersonHandler extends DefaultHandler{
	private List <Person>persons;
	private Person person;
	private String tag;
	@Override
	public void startDocument() throws SAXException {
		System.out.println("**************************");
		persons = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("开始解析:"+qName);
		tag=qName;
		if(qName.equals("person")) 
			person=new Person();
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data=new String(ch,start,length).trim();
		/*if(data.length()>0) { System.out.println("内容为:"+data);  }
		else { System.out.println(); }*/
		if(tag!=null) {
			if(tag.equals("name")) 
				person.setName(data);
			else if(tag.equals("age")) 
				person.setAge(Integer.parseInt(data));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName!=null) {
			if(qName.equals("person"))
				persons.add(person);
		}
		System.out.println("结束解析:"+qName);
		tag=null;
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("**************************");
	}
	
	void travel() {
		for(Person p:persons) {
			System.out.println("[name:"+p.getName()+" , age:"
								+p.getAge()+"]");
		}
	}
	
}

class Person{
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
