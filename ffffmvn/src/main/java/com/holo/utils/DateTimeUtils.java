package com.holo.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateTimeUtils
 * @Description: 日期时间工具类，分为Date<->String<->Timestamp之间的转换和日期计算两部分
 * @author 刘小龙
 * @version 2016年9月13日 11:43:10
 */
public final class DateTimeUtils {

	public static final String FORMAT_DATE_DEFAULT = "yyyy-MM-dd";
	
	public static final String FORMAT_DATE_SHORT = "yyyy-MM";

	/**
	 * @Description: 将日期转成自定义日期格式的字符串
	 */
	public static String date2String(final Date date, final String pattern) {
		final DateFormat df = new SimpleDateFormat(pattern);
		df.setLenient(false);
		return df.format(date);
	}

	/**
	 * @Description: 将日期转成特定日期格式的字符串(yyyy-MM-dd)
	 */
	public static String date2String(final Date date) {
		return date2String(date, FORMAT_DATE_DEFAULT);
	}

	/**
	 * @Description: 将特定格式(yyyy-MM-dd HH:mm)的字符串转成日期
	 */
	public static Date string2DatetimeShort(final String str) throws ParseException{
		return string2Date(str, FORMAT_DATE_DEFAULT);
	}

	/**
	 * @Description: 将自定义格式的字符串转成日期
	 */
	public static Date string2Date(final String str, final String pattern) throws ParseException{
		final DateFormat df = new SimpleDateFormat(pattern);
		df.setLenient(false);
		return df.parse(str);
	}
	 
	/** 
	 * @Description 获取当前时间所在周第一天
	 */
	public static String getFirstDayOfWeek(Date date){
        Calendar cDate = Calendar.getInstance();
        cDate.setFirstDayOfWeek(Calendar.MONDAY);
        cDate.setTime(date);
        Calendar firstDate = Calendar.getInstance();
        firstDate.setFirstDayOfWeek(Calendar.MONDAY);
        firstDate.setTime(date);
        if (cDate.get(Calendar.WEEK_OF_YEAR) == 1 && cDate.get(Calendar.MONTH) == 11) {
            firstDate.set(Calendar.YEAR, cDate.get(Calendar.YEAR) + 1);
        }
        int typeNum = cDate.get(Calendar.WEEK_OF_YEAR);
        firstDate.set(Calendar.WEEK_OF_YEAR, typeNum);
        firstDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        // 所在周开始日期
        String beginDate = new SimpleDateFormat(FORMAT_DATE_DEFAULT).format(firstDate.getTime());
        return beginDate;
	}
	
	/** 
	 * @Description 获取当前时间所在周最后一天
	 */
	public static String getLastDayOfWeek(Date date){
        Calendar cDate = Calendar.getInstance();
        cDate.setFirstDayOfWeek(Calendar.MONDAY);
        cDate.setTime(date);
        Calendar lastDate = Calendar.getInstance();
        lastDate.setFirstDayOfWeek(Calendar.MONDAY);
        lastDate.setTime(date);
        if (cDate.get(Calendar.WEEK_OF_YEAR) == 1 && cDate.get(Calendar.MONTH) == 11) {
            lastDate.set(Calendar.YEAR, cDate.get(Calendar.YEAR) + 1);
        }
        int typeNum = cDate.get(Calendar.WEEK_OF_YEAR);
        lastDate.set(Calendar.WEEK_OF_YEAR, typeNum);
        lastDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        // 所在周结束日期
        String endDate = new SimpleDateFormat(FORMAT_DATE_DEFAULT).format(lastDate.getTime());
        return endDate;
	}
	
	 
	/** 
	 * @throws ParseException 
	 * @Description 获取当前时间所在月第一天
	 */
	public static String getFirstDayOfMonth(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance(); 
        cale.setTime(date);
        cale.add(Calendar.MONTH, 0);  
        cale.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(cale.getTime());
	}
	
	/** 
	 * @throws ParseException 
	 * @Description 获取当前时间所在月最后一天
	 */
	public static String getLastDayOfMonth(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();
		cale = Calendar.getInstance();  
        cale.setTime(date);
        cale.add(Calendar.MONTH, 1);  
        cale.set(Calendar.DAY_OF_MONTH, 0); 
		return format.format(cale.getTime());
	}
	
	public static void main(String[] args) throws Exception {
		Date monthTime=string2Date("2017-04",FORMAT_DATE_SHORT);
		System.out.println(getFirstDayOfMonth(monthTime));
		System.out.println(getLastDayOfMonth(monthTime));
	}
}
