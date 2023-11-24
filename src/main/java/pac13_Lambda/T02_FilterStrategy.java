package pac13_Lambda;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 10:58
 * @desc: 策略模式:抽象策略接口
 **/
public interface T02_FilterStrategy<T> {
    boolean filter(T t);
}
