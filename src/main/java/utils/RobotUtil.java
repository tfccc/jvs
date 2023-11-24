/*
package utils;

import java.awt.*;

*/
/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-27 12:14
 * @desc: Robot������
 **//*

@SuppressWarnings("unused")
public class RobotUtil {

    private static final int DELAY_BEFORE_CLICK = 500;

    */
/**
     * @desc ����
     * @param robot --------> robot����
     * @param keys ---------> ��Ҫ�İ���(��˳��)
     * @param delay --------> ÿ�ΰ��������ʱ
     * @return *
     *//*

    public static void pressKeys(Robot robot, int[] keys, int delay) {
        for (int key : keys) {
            robot.keyPress(key);
            robot.keyRelease(key);
            robot.delay(delay);
        }
    }

    */
/**
     * @desc �����ַ�������
     * @param robot --------> robot����
     * @param str ----------> �ַ�������
     * @param delay --------> ÿ�ΰ��������ʱ
     * @return *
     *//*

    public static void pressByString(Robot robot, String str, int delay) {
        char[] keys = str.toUpperCase().toCharArray();
        for (int key : keys) {
            robot.keyPress(key);
            robot.keyRelease(key);
            robot.delay(delay);
        }

    }

    */
/**
     * @desc ��������� (���ƶ�, ��ʱ'DELAY_BEFORE_CLICK', �ٵ��)
     * @param robot --------> robot����
     * @param x ------------> �������Ļ�ϵ�x����
     * @param y ------------> �������Ļ�ϵ�y����
     * @param delay --------> ÿ�ε�������ʱ
     * @param doubleClick --> �Ƿ�˫��
     * @return *
     *//*

    public static void clickLeft(Robot robot, int x, int y, int delay, boolean doubleClick) {
        robot.mouseMove((int) (x / 1.25), (int) (y / 1.25));
        robot.delay(DELAY_BEFORE_CLICK);
        if (doubleClick) {
            delay = delay > 500 ? 300 : delay;
            for (int i = 0; i < 2; i++) {
                robot.mousePress(16);
                robot.mouseRelease(16);
                robot.delay(delay);
            }
        } else {
            robot.mousePress(16);
            robot.mouseRelease(16);
            robot.delay(delay);
        }
    }

    */
/**
     * @desc �������Ҽ� (���ƶ�, ��ʱ'DELAY_BEFORE_CLICK', �ٵ��)
     * @param robot --------> robot����
     * @param x ------------> �������Ļ�ϵ�x����
     * @param y ------------> �������Ļ�ϵ�y����
     * @param delay --------> ÿ�ε�������ʱ
     * @param doubleClick --> �Ƿ�˫��
     * @return *
     *//*

    public static void clickRight(Robot robot, int x, int y, int delay, boolean doubleClick) {
        robot.mouseMove((int) (x / 1.25), (int) (y / 1.25));
        robot.delay(DELAY_BEFORE_CLICK);
        if (doubleClick) {
            delay = delay > 500 ? 300 : delay;
            for (int i = 0; i < 2; i++) {
                robot.mousePress(4096);
                robot.mouseRelease(4096);
                robot.delay(delay);
            }
        } else {
            robot.mousePress(4096);
            robot.mouseRelease(4096);
            robot.delay(delay);
        }
    }

    */
/**
     * @desc ������껬��
     * @param robot --------> robot����
     * @param wheelAmt --------> ��������
     * @return *
     *//*

    public static void rollMouseWheel(Robot robot, int wheelAmt) {
        robot.mouseWheel(wheelAmt);
    }


    // singleton
    enum RobotEnum {
        INSTANCE;
        private Robot instance;

        RobotEnum() {
            try {
                instance = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

        public Robot getInstance() {
            return instance;
        }
    }

    */
/**
     * @desc ö��, ��ȡRobot��������
     *//*

    public static Robot getRobot() {
        return RobotEnum.INSTANCE.getInstance();
    }
}
*/
