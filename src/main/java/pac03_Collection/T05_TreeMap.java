package pac03_Collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author TFC
 * @date   2019年6月15日 下午7:47:06
 * @note   TreeMap测试
 *
 * 1.TreeMap对存入的键值对，自动排序
 * 2.对象型值的排序(用comparable接口指定要排序的成员变量)
 *
 */

public class T05_TreeMap {
	//put方法，放入时直接排序
	public static void TreeMap_simpleusage() {
		Map<Integer, String> tree=new TreeMap<>();
		tree.put(8, "⑧");
		tree.put(2, "②");
		tree.put(5, "⑤");
		tree.put(1, "①");
		tree.put(1, "aaa");
		System.out.println(tree);
	}
	
	//对象型值的排序(用comparable接口指定要排序的成员变量)
	//接口内推荐以不同的返回值来排序(-1,0,1)
	public static void TreeMap_Compare() {
		
	}
	
	public static void main(String[] args) {
		TreeMap_simpleusage();
	}
}
