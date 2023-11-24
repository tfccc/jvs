/*
package utils;

import java.awt.*;

*/
/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-27 12:14
 * @desc: Robot工具类
 **//*

@SuppressWarnings("unused")
public class RobotUtil {

    private static final int DELAY_BEFORE_CLICK = 500;

    */
/**
     * @desc 按键
     * @param robot --------> robot对象
     * @param keys ---------> 需要的按键(按顺序)
     * @param delay --------> 每次按键后的延时
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
     * @desc 根据字符串按键
     * @param robot --------> robot对象
     * @param str ----------> 字符串对象
     * @param delay --------> 每次按键后的延时
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
     * @desc 点击鼠标左键 (先移动, 延时'DELAY_BEFORE_CLICK', 再点击)
     * @param robot --------> robot对象
     * @param x ------------> 点击的屏幕上的x坐标
     * @param y ------------> 点击的屏幕上的y坐标
     * @param delay --------> 每次点击后的延时
     * @param doubleClick --> 是否双击
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
     * @desc 点击鼠标右键 (先移动, 延时'DELAY_BEFORE_CLICK', 再点击)
     * @param robot --------> robot对象
     * @param x ------------> 点击的屏幕上的x坐标
     * @param y ------------> 点击的屏幕上的y坐标
     * @param delay --------> 每次点击后的延时
     * @param doubleClick --> 是否双击
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
     * @desc 滚动鼠标滑轮
     * @param robot --------> robot对象
     * @param wheelAmt --------> 滚动数量
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
     * @desc 枚举, 获取Robot单例对象
     *//*

    public static Robot getRobot() {
        return RobotEnum.INSTANCE.getInstance();
    }
}
*/
