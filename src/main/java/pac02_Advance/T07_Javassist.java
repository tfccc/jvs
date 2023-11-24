package pac02_Advance;

import javassist.*;

import javax.sql.PooledConnection;
import java.io.IOException;

/**
 * @author TFC
 * @date 2019��8��13�� ����11:20:40
 * @note Javassist�����ֽ���, �������ļ�
 */
public class T07_Javassist {
    private static String outPutPath = "F:\\1.WorkSpaces\\IDEA_2019.2.4\\Java_Study\\src\\pac00_outPut";
    private static String className = "GenerateByJavassist";

    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass c1 = pool.makeClass(className);

		//�����������
        CtField f1 = CtField.make("private int age;", c1);
        CtField f2 = CtField.make("private String name;", c1);
        c1.addField(f1);
        c1.addField(f2);
        //��������
        CtMethod.make("public int getAge(){return age;}", c1);
        CtMethod.make("public void setAge(int age){this.age=age;}", c1);
        //������
        CtConstructor con = new CtConstructor(
                new CtClass[]{CtClass.intType,
                        pool.get("java.lang.String")}, c1);
        con.setBody("{this.name=name;this.age=age;}");
        c1.addConstructor(con);
        c1.writeFile(outPutPath);
    }
}
