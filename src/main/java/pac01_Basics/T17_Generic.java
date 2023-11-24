package pac01_Basics;

/**
 * @author TFC
 * @date 2019年6月15日 上午11:26:42
 * @note 泛型
 *
 * 一.说明
 *   1.定义好后，在实例化类时，需要指定类型，再操作
 *   2.这种方法可以避免调用时，需要转型的问题。方便使用
 *
 * 二.特殊情况:
 *   1.<? extends T> : 该集合中存的都是类型T的子类,包括T自己。
 *   2.<? super T>   : 该集合中存的都是类型T的父类,包括T自己。
 *
 */
//定义好的一个泛型类
public class T17_Generic<G> {

    Object object[] = new Object[10];

    public void setData(G g, int index) {
        object[index] = g;
    }

    public G getData(int index) {
        return (G) object[index];

    }

    public static void main(String[] args) {

        T17_Generic<String> str = new T17_Generic<>();
        str.setData("字符串123", 0);
        System.out.println(str.getData(0));

        T17_Generic<Integer> str2 = new T17_Generic<>();
        str2.setData(123, 0);
        System.out.println(str2.getData(0));
    }

    public <A,B,C,W> void test(A a, B b){

	}


}
