package pac03_Collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author TFC
 * @date   2019��6��15�� ����7:47:06
 * @note   TreeMap����
 *
 * 1.TreeMap�Դ���ļ�ֵ�ԣ��Զ�����
 * 2.������ֵ������(��comparable�ӿ�ָ��Ҫ����ĳ�Ա����)
 *
 */

public class T05_TreeMap {
	//put����������ʱֱ������
	public static void TreeMap_simpleusage() {
		Map<Integer, String> tree=new TreeMap<>();
		tree.put(8, "��");
		tree.put(2, "��");
		tree.put(5, "��");
		tree.put(1, "��");
		tree.put(1, "aaa");
		System.out.println(tree);
	}
	
	//������ֵ������(��comparable�ӿ�ָ��Ҫ����ĳ�Ա����)
	//�ӿ����Ƽ��Բ�ͬ�ķ���ֵ������(-1,0,1)
	public static void TreeMap_Compare() {
		
	}
	
	public static void main(String[] args) {
		TreeMap_simpleusage();
	}
}
