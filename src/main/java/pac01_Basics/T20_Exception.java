package pac01_Basics;

/**
 * @author TFC
 * @date 2019年12月25日 下午12:06:26
 * @note Java异常机制
 *
 * 一.说明
 *     1.finally可不带catch,可在return后执行语句
 *     2.throws将异常抛给调用者,catch将异常在内部进行处理
 *
 * 二.异常分类:
 *     1.checkedException  :有语法检查,编译时需要处理,否则无法通过
 *     2.unCheckedException:不处理即可通过编译,在运行时可能会出现异常
 *
 */
public class T20_Exception {
    //选择题
    private static int aMethod(int i) throws Exception {
        try {
            int a = 10 / i;
            return a;
        } catch (java.lang.Exception ex) {
            throw new java.lang.Exception(" exception in a Method, ");
        } finally {
            System.out.printf(" finally, ");
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        try {
            aMethod(0);
        } catch (java.lang.Exception ex) {
            System.out.println(" exception in a Main, ");
            //throw new Exception(" exception in a Main, ");
        }
        System.out.printf(" finished, ");
    }
}