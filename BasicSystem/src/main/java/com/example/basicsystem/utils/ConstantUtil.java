package com.example.basicsystem.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConstantUtil {


    public static String getPrimaryKey() {
        String uuid = UUID.randomUUID().toString();
        // StringUtils 引用 org.apache.commons.lang3.StringUtils
        return StringUtils.replace(uuid, "-", "");
    }
    //    将长整形转换成时间
    public static String longToDate(Long time, String sdf) {
        Locale localeCN = Locale.SIMPLIFIED_CHINESE;
        SimpleDateFormat format = new SimpleDateFormat(sdf, localeCN);
        return format.format(time);
    }

    //    规定格式的字符串转换成长整形
    public static Long stringDateToLong(String data, String sdf) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat(sdf);
        try {
            date = formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    //    获得今天0点的时间戳
    public static Long getTimesZeroStamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static Long getTimesZeroStamp(Integer hour, Integer min, Integer second, Integer mill) {
        Calendar cal = Calendar.getInstance();
        if (hour != null)
            cal.set(Calendar.HOUR_OF_DAY, hour);
        if (second != null)
            cal.set(Calendar.SECOND, second);
        if (min != null)
            cal.set(Calendar.MINUTE, min);
        if (mill != null)
            cal.set(Calendar.MILLISECOND, mill);
        return cal.getTimeInMillis();
    }


    //获得昨天凌晨的时间戳
    public static Long getYesterdayZeroStamp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    //    获得明天的凌晨时间戳
    public static Long getTomorrowZeroStamp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    //    根据当前时间获得某天的
    public static Long getDayTemp(int date, int hour, int minute, int second, int millSecond) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, minute);
        cal.set(Calendar.MINUTE, second);
        cal.set(Calendar.MILLISECOND, millSecond);
        return cal.getTimeInMillis();
    }

    //    获取当前时间的时间戳
    public static Long getCurrentTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    //    获取某个时间的时间戳
    public static Long hourTimeStamp(int hour, int min, int second, int millSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millSecond);
        return calendar.getTimeInMillis();
    }

    //    获取规定格式的规定时间的时间戳
    public static Long timeStamp(Date date1, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String timeMS = sdf.format(date1);
        Date date = null;
        try {
            date = sdf.parse(timeMS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long time = date.getTime();

        return time;
    }

    //    获得当前时间前后XX分钟的时间戳
    public static Long getTimeByMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTimeInMillis();
    }

    //    获得当前时间前后XX小时的时间戳
    public static Long getTimeByHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return calendar.getTimeInMillis();
    }


    /**
     * 获取0点时间戳，day:距离今天0点的天数
     *
     * @param day day=1：获取明天0点， day=-1 获取昨天0点
     * @return
     */
    public static Long getZeroStamp(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 将时间戳按照指定的格式返回时间字符串
     * "yyyy-MM-dd" // ConstantUtil.ONLY_DATE;
     * "HH:mm:ss" // ConstantUtil.ONLY_TIME;
     * author：liyaoheng
     */
    public static String timestampToString(Long timestamp, String type) {
        if (timestamp != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type, Locale.CHINA);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date date = new Date(timestamp);
            return simpleDateFormat.format(date);
        } else {
            return "";
        }
    }

    /**
     * * 将字符串按照指定的格式返回时间戳
     * "yyyy-MM-dd" // ConstantUtil.ONLY_DATE;
     * "HH:mm:ss" // ConstantUtil.ONLY_TIME;
     * author:liyaoheng
     */
    public static Long stringToTimestamp(String time, String type) {
        Long startTimeDLong;
        try {
//            SimpleDateFormat f = new SimpleDateFormat(type);
            SimpleDateFormat f = new SimpleDateFormat(type, Locale.CHINA);
            f.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            f.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date date = f.parse(time);
            startTimeDLong = date.getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return startTimeDLong;
    }

    /**
     * 判断是否为全数字
     *
     * @param strNum
     * @return
     */
    public static boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }

    /**
     * 改为小数点后一位
     *
     * @param dou
     * @return
     */
    public static Double changeDouble(Double dou) {
        NumberFormat nf = new DecimalFormat("0.0");
        dou = Double.parseDouble(nf.format(dou));
        return dou;
    }

    public static boolean firstDigit(String strNum) {
        strNum = strNum.substring(0, 1);
        return isDigit(strNum);
    }

    /**
     * 转换 12'12"
     *
     * @param figure
     * @return
     */
    public static String figureTransition(Integer figure, String lan) {
        if (figure == null) {
            return null;
        }
        boolean flag = false;
        if (figure < 0) {
            flag = true;
        }
        figure = Math.abs(figure);
        Integer min = figure / 60;
        Integer sec = figure % 60;
        if (flag) {
            min = -1 * min;
        }
        String data = null;
        if (null == lan) {
            data = min + "'" + (sec < 10 && sec != 0 ? "0" + sec : sec) + "\"";
        } else if ("CN".equals(lan)) {
            data = min + "分" + (sec < 10 && sec != 0 ? "0" + sec : sec) + "秒";

        }
        return data;
    }

    public static String figureTransition(Integer figure) {
        return figureTransition(figure, null);
    }

    /**
     * 312 转换为 2'12"
     *
     * @param time
     * @return
     */
    public static String formatTime(Double time) {
        int min = Double.valueOf(time / 60).intValue();
        int second = Long.valueOf(Math.round(Double.valueOf(time % 60))).intValue();
        String strTime = second + "\"";
        if (min != 0) {
            strTime = min + "'" + second + "\"";
        }
        return strTime;
    }

    public static String formatTime(String timeString, String lan) {
        if (StringUtils.isEmpty(timeString)) {
            return "-'--\"";
        }
        double time = Double.parseDouble(timeString);
        int min = Double.valueOf(time / 60).intValue();
        int second = Long.valueOf(Math.round(Double.valueOf(time % 60))).intValue();
        String strTime = second + "\"";
        if (min != 0) {
            if (null == lan) {
                strTime = min + "'" + second + "\"";
            } else if ("CN".equals(lan)) {
                strTime = min + "分" + (second == 0 ? "00" : (second < 10 && second != 0 ? "0" + second : second)) + "秒";
            }
        }
        return strTime;
    }

    public static String formatTime(String timeString) {
        return formatTime(timeString, null);
    }

    public static Long roundFig(Double time) {
        long round = Math.round(time);
        return round;
    }

    public static String keepDecimal(double value, Integer digits) {
        BigDecimal b = new BigDecimal(value);
        String v = b.setScale(digits, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
        return v;
    }

    public static boolean listIsEmpty(List<? extends Object> list) {
        return list == null || list.size() == 0;
    }

    public static boolean listIsNotEmpty(List<? extends Object> list) {
        return !listIsEmpty(list);
    }

    public static boolean setIsEmpty(Set<? extends Object> set) {
        return set == null || set.size() == 0;
    }

    public static boolean setIsNotEmpty(Set<? extends Object> set) {
        return !setIsEmpty(set);

    }

    /**
     * 去除多余小数点
     *
     * @param number
     * @return
     */
    public static Double getPrettyNumber(Double number) {
        return Double.valueOf(BigDecimal.valueOf(number).stripTrailingZeros().toPlainString());
    }

    public static Double getDoubleZero(Double number) {
        return Double.valueOf(new DecimalFormat("###.0").format(number));
    }

    public static Double keepTheDecimalPoint(Double number, Integer num) {
        if (num == null) {
            num = 2;
        }
        try {
            BigDecimal bg = new BigDecimal(number);
            return bg.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            return number;
        }
    }

    /**
     * String 转Ascii
     *
     * @param value
     * @return
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();

    }

    /**
     * Ascii转String
     *
     * @param value
     * @return
     */
    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    /**
     * 转换日期 年龄
     *
     * @param birthday
     * @return
     */
    public static Integer getAgeByBirth(Date birthday) {
        if (birthday == null) {
            return null;
        }
        Integer age = null;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            //如果传入的时间，在当前时间的后面，返回0岁
            if (!birth.after(now)) {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {
            return age;
        }
    }

    /**
     * 判断字符串是否含有重复的字符
     *
     * @param str
     * @return
     */
    public static boolean containRepeatChar(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] elements = str.toCharArray();
        for (char e : elements) {
            if (str.indexOf(e) != str.lastIndexOf(e)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getZeroStamp(15));
        System.out.println(unescape("%u6D4B%u8BD5%23"));
        System.out.println(unescape("测试"));
        System.out.println(Double.valueOf("1"));
        System.out.println(keepDecimal(11, 1));
        System.out.println(getFirstDayOfMonth());
    }


    public static boolean stringContain(String listString, String s) {
        if (StringUtils.isNotBlank(listString)) {
            List<String> list = new ArrayList<>(List.of(listString.split(",")));
            if (!CollectionUtils.isEmpty(list)) {
                return list.contains(s);
            }
        }
        return false;
    }

    public static Long getFirstDayDateOfMonth(Long time) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTimeInMillis();

    }

    public static Long getLastDayOfMonth(Long time) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTimeInMillis();

    }

    public static Long getMin(Long time) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTimeInMillis();
    }

    /**
     * 求两个月份的日期
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws Exception
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 求两个月份的日期
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws Exception
     */
    public static List<String> getMonthBetween(Long minDate, Long maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(new Date(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(new Date(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    /**
     * 两个时间相差几个月
     *
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }

    /**
     * 两个时间相差几个月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSpace(Long date1, Long date2) {

        int result = 0;

        if (date1 != null && date2 != null) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();

            c1.setTime(new Date(date1));
            c2.setTime(new Date(date2));

            result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;
        }

        return result == 0 ? 1 : Math.abs(result);

    }

    /**
     * 获取下个月第一天
     *
     * @param date
     * @return
     */
    public static Long getNextMonthDay(Long date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date(date));

        c1.set(Calendar.DAY_OF_MONTH, 1);
        c1.add(Calendar.MONTH, 1);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.MILLISECOND, 0);
        c1.getTimeInMillis();
        return c1.getTimeInMillis();

    }

    /**
     * 判断是不是数字正则判断
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^-?[0-9]+"); //这个也行
//        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");//这个也行 包含小数点
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static Integer maxSchoolYear() {
        String s = ConstantUtil.longToDate(System.currentTimeMillis(), "yyyy-MM");
        String[] split = s.split("-");
        String month = split[1];
        Integer year = Integer.valueOf(split[0]);
        Integer _month = Integer.valueOf(month);
        if (_month < 8) {
            year = year - 1;
        }
        return year;
    }

    public static List<Long> getWorkingDaysBetweenTwoDates(Long startDate, Long endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(new Date(startDate));
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(new Date(endDate));
        List<Long> timeList = new ArrayList<>();
        do {
//            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
//            }
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        return timeList;
    }

    public static List<Long> getWorkingDaysBetweenTwoDates(Long startDate, Long endDate, List<Integer> weekList) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(new Date(startDate));
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(new Date(endDate));
        List<Long> timeList = new ArrayList<>();
        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && weekList.contains(1)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY && weekList.contains(2)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && weekList.contains(3)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && weekList.contains(4)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && weekList.contains(5)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && weekList.contains(6)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && weekList.contains(7)) {
                timeList.add(ConstantUtil.stringToTimestamp(ConstantUtil.timestampToString(startCal.getTimeInMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
            }
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        return timeList;
    }

    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);

        for (i = 0; i < src.length(); i++) {

            j = src.charAt(i);

            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static Long getMondayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 0);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);
        return c.getTimeInMillis();
    }

    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static Long getSundayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 0);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7);
        return c.getTimeInMillis();
    }

    /**
     * 获取本月的第一天
     *
     * @return
     */
    public static Long getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);

        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return cal.getTimeInMillis();
    }


    /**
     * 获取本月最后一天
     *
     * @return
     */
    public static Long getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTimeInMillis();
    }

    public static String[] xdForNj(String flag) {
        if ("junior".equals(flag)) {
            String[] njArr = {"1", "2", "3"};
            return njArr;
        } else if ("senior".equals(flag)) {
            String[] njArr = {"4", "5", "6"};
            return njArr;
        } else if ("all".equals(flag)) {
            String[] njArr = {"1", "2", "3", "4", "5", "6"};
            return njArr;
        }
        return null;
    }

    public static Map<String, Long> getTimeByFlag(String flag) {
        Map<String, Long> timeMap = new HashMap<>();
        if ("day".equals(flag)) {
            timeMap.put("beginTime", ConstantUtil.getTimesZeroStamp());
            timeMap.put("endTime", ConstantUtil.getTimesZeroStamp());
        } else if ("month".equals(flag)) {
            timeMap.put("beginTime", ConstantUtil.getFirstDayOfMonth());
            timeMap.put("endTime", ConstantUtil.getLastDayOfMonth());
        } else if ("week".equals(flag)) {
            timeMap.put("beginTime", ConstantUtil.getMondayOfThisWeek());
            timeMap.put("endTime", ConstantUtil.getSundayOfThisWeek());
        } else if ("cycle".equals(flag)) {
            timeMap.put("beginTime", ConstantUtil.getMondayOfThisWeek());
            timeMap.put("endTime", ConstantUtil.getSundayOfThisWeek());
        }
        return timeMap;
    }

    public static Map<String, Object> objectToMap(Object obj) {

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                map.put(fieldName, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    public static List<Map<String, Object>> objecListToMapList(List<Object> objList) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (Object obj : objList) {
            dataList.add(objectToMap(obj));
        }
        return dataList;
    }

    public static String switchScoreLevel(Integer score) {
        String level = "";
        if (score >= 90) {
            level = "优秀";
        } else if (score >= 80) {
            level = "良好";
        } else if (score >= 60) {
            level = "及格";
        } else {
            level = "不及格";
        }
        return level;

    }
}
