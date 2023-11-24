package pac02_Advance;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-21 14:04
 * @desc: ScriptEngine
 *
 * 1.���ã�ʵ�ֶ�̬����,���ַ���ת��Ϊ��ִ�ж���
 *
 **/
public class T08_ScriptEngine {
    public static void main(String[] args) {
        test01();
    }

    static void test01() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        String str = "1+2*2+6";
        Object result = null;
        try {
            result =  se.eval(str);
        } catch (ScriptException ignored) {
            System.out.println("ת��ʧ��");
        }
        System.out.println(result);
    }
}
