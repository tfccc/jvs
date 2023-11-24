package pac01_Basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author TFC
 * @date   2019��1��30�� ����12:40:31
 * @note   ���Ʊ�ʾ
 *
 * 1.��  : 0b
 * 2.��  : 0
 * 3.ʮ��: 0x
 *
 */
public class T19_System {

    @Test
    @DisplayName("2")
    public void test1() {
        System.out.println(0b111);
    }

    @Test
    @DisplayName("8")
    public void test2() {
        System.out.println(013);
    }

    @Test
    @DisplayName("16")
    public void test3() {
        System.out.println(0xff);
    }
}




