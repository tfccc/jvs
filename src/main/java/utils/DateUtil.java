package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author TFC
 * @date 2019年6月13日 下午9:26:18
 * @note 时间工具类
 */
@SuppressWarnings("unused")
public class DateUtil {

    /**
     * @Desc 返回当前系统时间
     * @return 当前时间
     */
    public static String getFullDate() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int mont = cal.get(Calendar.MONTH) + 1;
        int days = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minu = cal.get(Calendar.MINUTE);
        int seco = cal.get(Calendar.SECOND);
        return (year + "年" + mont + "月" + days + "日 " + hour + "时" + minu + "分" + seco + "秒");
    }

    /**
     * 返回当前日期的年 月，当前月的第几周
     *
     * @param date 日期
     */
    public static Map<String, Integer> getWeekAndYear(Date date) {
        Map<String, Integer> result = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat formatMon = new SimpleDateFormat("MM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        cal.setTime(date);
        int month = Integer.parseInt(formatMon.format(date));
        int year = Integer.parseInt(formatYear.format(date));
        int week = cal.get(Calendar.WEEK_OF_MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        result.put("day", day);
        result.put("week", week);
        if (week == 1 && month == 12) {
            result.put("year", year + 1);
        } else {
            result.put("year", year);
        }
        result.put("month", month);
        return result;
    }


    /**
     * 日期字符串转Date
     * @author Frank.Tang
     * @param dateStr "yyyy-MM-dd HH:mm:ss"格式
     * @return *
     */
    public static Date dateStrToDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
    private static final String YEAR_MONTH_DAY_HOUR = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取指定月份的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(YEAR_MONTH_DAY);
        String lastDayOfMonth = null;
        try {
            Calendar cale = Calendar.getInstance();

            cale.setTime(date);
            cale.add(Calendar.MONTH, 0);

            cale.set(Calendar.DAY_OF_MONTH, 1);

            cale.add(Calendar.MONTH, 1);

            cale.set(Calendar.DAY_OF_MONTH, 0);
            lastDayOfMonth = format.format(cale.getTime());
            return format.parse(lastDayOfMonth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Desc 返回年-月-日
     * @return 年-月-日
     */
    public static String getDate(){
        return getFullDate().split(" ")[0];
    }

    /**
     * @Desc 返回时-分-秒
     * @return 时-分-秒
     */
    public static String getTime(){
        return getFullDate().split(" ")[1];
    }

    /**
     * @Desc 返回年份
     * @return 年份
     */
    public static String getYear(){
        return getDate().split("年")[0];
    }

    /**
     * @Desc 返回月份
     * @return 月份
     */
    public static String getMonth(){
        return getDate().split("年")[1].split("月")[0];
    }

    /**
     * @Desc 返回日份
     * @return 日份
     */
    public static String getDay(){
        return getDate().split("月")[1].split("日")[0];
    }



    /**
     * @desc 获取当前年月日
     * @return 格式: 年-月-日
     */
    public static String getYMD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * @desc 获取当前时分秒
     * @return 格式: 时-分-秒
     */
    public static String getHMS() {
        return new SimpleDateFormat("HH-mm-ss").format(new Date());
    }

    /**
     * @desc 比较时间字符串大小
     * @param d1 时间1
     * @param d2 时间2
     * @return -1 --> d2大
     *          0 --> 相等
     *          1 --> d1大
     */
    public static int compareDate(String d1, String d2){
        return d1.compareTo(d2);
    }

}
