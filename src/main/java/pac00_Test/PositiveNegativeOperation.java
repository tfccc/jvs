package pac00_Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-08-23 17:29
 * @desc:
 **/
public class PositiveNegativeOperation {

    @Test
    @DisplayName("")
    public void test() {
        int a = 10;
        int b = a + - - (- + 1);
        System.out.println(b);

    }

}
