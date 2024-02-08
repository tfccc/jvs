package pac00_Test;

import java.awt.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static pac00_Test.RobotTest.RobotUtils.*;

/**
 * @author: Frank.Tang
 * @date: 2020-09-27 11:47
 * @desc:
 **/
@SuppressWarnings("unused")
public class RobotTest {
    static Robot robot = getRobot();

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            clickLeft(robot, 1000, 200 + (i % 100), true);

            int sleepTime = i % 5 + 60;
            System.out.println(i + "\t" + new Date().toLocaleString() + " sleep-" + sleepTime);

            sleep(sleepTime);
        }
    }


    /**
     * ��ȡ���λ��
     * @author Frank.
     *
     * @return *
     */
    public static double[] getMouseLocation() {
        Point location = MouseInfo.getPointerInfo().getLocation();
        return new double[]{location.getX(), location.getY()};
    }

    private static void inputWithIndex(String str, int index, int delay) {
        pressByString(robot, str, delay);
        if (index >= 10)
            pressKeys(robot, new int[]{48 + index / 10, 48 + index % 10}, delay);
        else
            pressKeys(robot, new int[]{48 + index}, delay);
    }

    /** ˯��: ���� */
    @SuppressWarnings("all")
    private static void sleep(int seconds) {
        try {
            seconds = (seconds <= 0) ? 1 : seconds;
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class RobotUtils {
        private static final int DELAY_BEFORE_CLICK = 500;

        /**
         * @desc ����
         * @param robot --------> robot����
         * @param keys ---------> ��Ҫ�İ���(��˳��)
         * @param delay --------> ÿ�ΰ��������ʱ
         * @return *
         */
        public static void pressKeys(Robot robot, int[] keys, int delay) {
            for (int key : keys) {
                robot.keyPress(key);
                robot.keyRelease(key);
                robot.delay(delay);
            }
        }

        /**
         * @desc �����ַ�������
         * @param robot --------> robot����
         * @param str ----------> �ַ�������
         * @param delay --------> ÿ�ΰ��������ʱ
         * @return *
         */
        public static void pressByString(Robot robot, String str, int delay) {
            char[] keys = str.toUpperCase().toCharArray();
            for (int key : keys) {
                robot.keyPress(key);
                robot.keyRelease(key);
                robot.delay(delay);
            }
        }

        /**
         * @desc ��������� (���ƶ�, ��ʱ'DELAY_BEFORE_CLICK', �ٵ��)
         * @param robot --------> robot����
         * @param x ------------> �������Ļ�ϵ�x����
         * @param y ------------> �������Ļ�ϵ�y����
         * @param doubleClick --> �Ƿ�˫��
         * @return *
         */
        public static void clickLeft(Robot robot, int x, int y, boolean doubleClick) {
            robot.mouseMove(x, y);
            robot.delay(DELAY_BEFORE_CLICK);
            int delay = 200;
            if (doubleClick) {
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

        /**
         * @desc �������Ҽ� (���ƶ�, ��ʱ'DELAY_BEFORE_CLICK', �ٵ��)
         * @param robot --------> robot����
         * @param x ------------> �������Ļ�ϵ�x����
         * @param y ------------> �������Ļ�ϵ�y����
         * @param doubleClick --> �Ƿ�˫��
         * @return *
         */
        public static void clickRight(Robot robot, int x, int y, boolean doubleClick) {
            robot.mouseMove(x, y);
            robot.delay(DELAY_BEFORE_CLICK);
            int delay = 500;
            if (doubleClick) {
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

        /**
         * @desc ������껬��
         * @param robot --------> robot����
         * @param wheelAmt --------> ��������
         * @return *
         */
        public static void rollMouseWheel(Robot robot, int wheelAmt) {
            robot.mouseWheel(wheelAmt);
        }

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

        /**
         * @desc ö��, ��ȡRobot��������
         */
        public static Robot getRobot() {
            return RobotEnum.INSTANCE.getInstance();
        }
    }

}