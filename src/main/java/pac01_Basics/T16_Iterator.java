package pac01_Basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author TFC
 * @date   2019年6月16日 下午7:58:55
 * @note   迭代器(用于遍历Map,Set,List等)
 */
public class T16_Iterator {
	
	// 1.List遍历方法
	static <E> void Iterator_List(List<E> list) {
		for (Iterator<E> iter=list.iterator();iter.hasNext();) {
			System.out.println(iter.next());
		}
	}
	
	// 2.Map遍历方法
	static <K,V> void Iterator_Map(Map<K,V> map) {
		//先放入set再遍历
		Set<Map.Entry<K, V>> set=map.entrySet();
		for (Iterator<Map.Entry<K, V>> iter=set.iterator();iter.hasNext();) {
			System.out.println(iter.next());
		}
	}
	
	// 3.Set遍历方法
	static <E> void Iterator_Set(Set<E> set) {
		for (E e : set) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<>();
		List<String> list=new ArrayList<>();
		Set<Integer> set=new HashSet<>();
		
		list.add("1");	map.put(1, "a");	set.add(10);
		list.add("2");	map.put(2, "b");	set.add(20);
		list.add("3");	map.put(3, "c");	set.add(30);
		list.add("4");	map.put(4, "d");	set.add(40);
		
		System.out.println("遍历结果:");
		//Iterator_List(list);
		//Iterator_Map(map);
		//Iterator_Set(set);	/*Set没有索引，是无序的*/
	}
}
