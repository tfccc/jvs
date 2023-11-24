package pac13_Lambda;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 11:29
 * @desc:
 **/
public class T02_FilterByAge implements  T02_FilterStrategy<Worker> {
    @Override
    public boolean filter(Worker worker) {
        return worker.getAge()>=25;
    }
}
