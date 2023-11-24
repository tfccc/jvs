package pac13_Lambda;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-24 11:30
 * @desc:
 **/
public class T02_FilterBySalary implements T02_FilterStrategy<Worker> {
    @Override
    public boolean filter(Worker worker) {
        return worker.getSalary()>=3500;
    }

}
