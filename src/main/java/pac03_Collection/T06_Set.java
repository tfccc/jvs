package pac03_Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-28 18:56
 * @desc: Set
 *
 * һ.˵����Ҫ
 *   1.����,�����ظ�
 *   2.����ָ��������ӵ�ʱ���˳��洢
 *
 * ��.����
 *   1.HashSet
 *   2.TreeSet
 *
 **/
public class T06_Set {
    @Test
    @DisplayName("1.HashSet�÷�")
    public void test() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");set1.add("c");
        set1.add("h");set1.add("d");
        set1.add("e");
        System.out.println(set1);

        Set<String> set2 = new HashSet<>();
        set2.addAll(set1);
        System.out.println(set2);
    }
}
