package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.regex.Pattern;

/**
 * @author: Tang.F.C
 * @date: 2020-01-10 16:11
 * @note: ������ʽ����
 *
 * �����б�
 *   1.match()��ƥ���ַ���
 *   2.find ()�������ַ���
 *
 **/
@SuppressWarnings("unused")
public class Regex {

    @Test
    @DisplayName("")
    public void test() {
        String str = "...23";
        String exp = "\\d+";
        System.out.println(find(str, exp));
    }

    /**
     * @Desc ������ʽƥ���ַ���
     * @param str ��ƥ���ַ���
     * @param exp ������ʽ
     * @return boolean
     */
    public static boolean match(String str, String exp) {
        return Pattern.compile(exp).matcher(str).matches();
    }

    /**
     * @Desc ������ʽ�����ַ���
     * @param str ��ƥ���ַ���
     * @param exp ������ʽ
     * @return boolean
     */
    public static boolean find(String str, String exp) {
        return Pattern.compile(exp).matcher(str).find();
    }

    /**
     * @Desc ������ʽ�����ַ���
     * @param str ��ƥ���ַ���
     * @param exp ������ʽ
     * @return boolean
     */
    public static String replace(String str, String exp, String replacement) {
        return Pattern.compile(exp).matcher(str).replaceAll(replacement);
    }

}
