package pac02_Advance;

import java.lang.annotation.Annotation;

/**
 * @author TFC
 * @date   2019��8��6�� ����5:23:50
 * @note   ע��
 * 
 * 1.��һ���ע�Ͳ�ͬ,ע��ɱ�������ʶ��,������һ�����﷨�޶��͹淶����
 * 2.�ؼ���:(@interface)
 * 
 * ������ע�⣺
 * 1.Override			��д
 * 2.Overload			����
 * 3.Deprecated			����
 * 4.SuppressWarnings	���ƾ���
 */
public class T02_Annotation {
	public static void main(String[] args) {

	}
	
	/*1.Override��������߱��������·�������Ϊ�������д,
	 *������಻��������ķ�����,�򲻷���ע��Ĺ淶,�������*/
	@Override	
	public String toString() { return null; }
	
	/*2.Deprecated���εķ���*/
	@Deprecated
	public void Deprecated() {}
	
	/*3.�Զ���ע��*/
	
}
