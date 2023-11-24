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
 * @date   2019��7��11�� ����11:37:22
 * @note   ������
 * 
 * 1.input������Ҫ�����л�(д��)
 * 2.֧��Serializable�ӿڵĶ���������л�
 * 3.output��Ҫ�����л�     (��ȡ)
 */
public class T18_ObjectStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new BufferedOutputStream(baos));
		//д
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
		//��
		//��ʹ���ã�ҲҪ������
		ois.readInt();
		ois.readBoolean();
		//��ȡ����
		Object s=ois.readObject();
		//instanceof ��ʾ:name�����String���͵�,����true
		if(s instanceof Student) {
			//ʵ�����¶���=�����Ķ���
			Student ss=(Student)s;
			//�õ�����ı���
			System.out.println(ss.getAge());
			System.out.println(ss.getName());
		}

	}
}