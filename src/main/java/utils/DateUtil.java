package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author TFC
 * @date 2019��6��13�� ����9:26:18
 * @note ʱ�乤����
 */
@SuppressWarnings("unused")
public class DateUtil {

    /**
     * @Desc ���ص�ǰϵͳʱ��
     * @return ��ǰʱ��
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
        return (year + "��" + mont + "��" + days + "�� " + hour + "ʱ" + minu + "��" + seco + "��");
    }

    /**
     * ���ص�ǰ���ڵ��� �£���ǰ�µĵڼ���
     *
     * @param date ����
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
     * �����ַ���תDate
     * @author Frank.Tang
     * @param dateStr "yyyy-MM-dd HH:mm:ss"��ʽ
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
     * ��ȡָ���·ݵ����һ��
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
     * @Desc ������-��-��
     * @return ��-��-��
     */
    public static String getDate(){
        return getFullDate().split(" ")[0];
    }

    /**
     * @Desc ����ʱ-��-��
     * @return ʱ-��-��
     */
    public static String getTime(){
        return getFullDate().split(" ")[1];
    }

    /**
     * @Desc �������
     * @return ���
     */
    public static String getYear(){
        return getDate().split("��")[0];
    }

    /**
     * @Desc �����·�
     * @return �·�
     */
    public static String getMonth(){
        return getDate().split("��")[1].split("��")[0];
    }

    /**
     * @Desc �����շ�
     * @return �շ�
     */
    public static String getDay(){
        return getDate().split("��")[1].split("��")[0];
    }



    /**
     * @desc ��ȡ��ǰ������
     * @return ��ʽ: ��-��-��
     */
    public static String getYMD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * @desc ��ȡ��ǰʱ����
     * @return ��ʽ: ʱ-��-��
     */
    public static String getHMS() {
        return new SimpleDateFormat("HH-mm-ss").format(new Date());
    }

    /**
     * @desc �Ƚ�ʱ���ַ�����С
     * @param d1 ʱ��1
     * @param d2 ʱ��2
     * @return -1 --> d2��
     *          0 --> ���
     *          1 --> d1��
     */
    public static int compareDate(String d1, String d2){
        return d1.compareTo(d2);
    }

}
