package pac04_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import bean.Student;

/**
 * @author TFC
 * @date   2019年7月11日 上午11:37:22
 * @note   对象流
 * 
 * 1.input对象需要先序列化(写出)
 * 2.支持Serializable接口的对象才能序列化
 * 3.output需要反序列化     (读取)
 */
public class T18_ObjectStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new BufferedOutputStream(baos));
		//写
		oos.writeInt(1);
		oos.writeBoolean(true);
		Student stu=new Student("TFC",18);
		oos.writeObject(stu);
		oos.flush();
		byte data[]=baos.toByteArray();
		
		ObjectInputStream ois=
				new ObjectInputStream(
						new BufferedInputStream(
								new ByteArrayInputStream(data)));
		//读
		//即使不用，也要读出来
		ois.readInt();
		ois.readBoolean();
		//读取对象
		Object s=ois.readObject();
		//instanceof 表示:name如果是String类型的,返回true
		if(s instanceof Student) {
			//实例化新对象=读到的对象
			Student ss=(Student)s;
			//得到对象的变量
			System.out.println(ss.getAge());
			System.out.println(ss.getName());
		}

	}
}