package com.wuyg.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 获取指定月的日历
 * 
 * @author kojon
 * @date 2014-7-30
 * @version 1.0
 */
public class CalendarUtil
{

	public static void main(String[] args)
	{
		int year = 2014;
		int month = 03;
//		printCalendar(year, month);
//		System.out.println("\n获取集合:" + getCalendar(year, month));
//		System.out.println("\n获取集合:" + getCalendar("2014-06-30"));
		System.out.println("\n以周输出:");
		getCalendarWeek(year, month);

	}

	/**
	 * 根据日期获取当前月数据
	 * 
	 * @param date
	 *            格式2014-07-30
	 * @return 月日期集合
	 */
	static List<String> getCalendar(String date)
	{
		return getCalendar(Integer.valueOf(getTime(date, Calendar.YEAR)), (Integer.valueOf(getTime(date, (Calendar.MONTH))) + 1));
	}

	static void printCalendar(int year, int month)
	{
		System.out.println("Calendar for year/mont:" + year + "/" + (month));
		System.out.println("日  |一 |二 |三 |四  |五 |六");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		// 一个月的天数
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 每一天进行循环加入
		for (int day = 1; day <= maxDay; day++)
		{
			calendar.set(Calendar.DATE, day);
			int weekDay = getWeekDay(calendar);
			if (day == 1)
			{
				// 前一个月的补齐
				if (weekDay != 7)
				{
					calendar.add(Calendar.MONTH, -1);// 上一个月
					int beforMaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 上个月最大天数
					int befordaycount = weekDay;// 第一个月第一天星期几 前面补足几天
					// 倒序补齐
					for (int i = 1; i <= weekDay; i++)
					{
						System.out.print((beforMaxDay + 1 - befordaycount) + "|");
						befordaycount--;
					}
					calendar.set(Calendar.MONTH, month - 1);// 恢复原来的月
				}
			}
			System.out.print((day > 9 ? day : "0" + day) + "|");
			// 保持日历格式 周六换行
			if (weekDay == 6)
			{
				System.out.println();
			}
			// 下个月补齐
			if (day == maxDay)
			{
				if (weekDay != 6)
				{// 非周六才需补齐
					int lastDayCount = weekDay == 7 ? 6 : (6 - weekDay);// 星期天还有6天补齐 其余是6-?
					for (int i = 1; i <= lastDayCount; i++)
					{
						System.out.print((i > 9 ? i : "0" + i) + "|");
					}
				}
			}
		}
	}

	public static List<String> getCalendar(int year, int month)
	{
		List<String> data = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		// 一个月的天数
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 每一天进行循环加入
		for (int day = 1; day <= maxDay; day++)
		{
			calendar.set(Calendar.DATE, day);
			int weekDay = getWeekDay(calendar);
			if (day == 1)
			{
				// 前一个月的补齐
				if (weekDay != 7)
				{
					calendar.add(Calendar.MONTH, -1);// 上一个月
					int beforMaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 上个月最大天数
					int befordaycount = weekDay;// 第一个月第一天星期几 前面补足几天
					// 倒序补齐
					for (int i = 1; i <= weekDay; i++)
					{
						data.add(calendar.get(Calendar.YEAR) + "-" + getValue(calendar.get(Calendar.MONTH) + 1) + "-" + getValue(beforMaxDay + 1 - befordaycount));
						befordaycount--;
					}
					calendar.set(Calendar.MONTH, month - 1);// 恢复原来的月
				}
			}
			data.add(calendar.get(Calendar.YEAR) + "-" + getValue(calendar.get(Calendar.MONTH) + 1) + "-" + getValue(day));
			// 下个月补齐
			if (day == maxDay)
			{
				if (weekDay != 6)
				{// 非周六才需补齐
					int lastDayCount = weekDay == 7 ? 6 : (6 - weekDay);// 星期天还有6天补齐 其余是6-?
					for (int i = 1; i <= lastDayCount; i++)
					{
						data.add(year + "-" + getValue(month + 1) + "-" + getValue(i));
					}
				}
			}
		}
		return data;
	}

	public static void getCalendarWeek(int year, int month)
	{
		try
		{
			List<String> calendar = getCalendar(year, month);
			int n = 1;
			for (int i = 0; i < calendar.size(); i += 7)
			{
				System.out.println("第[" + n + "]周");
				// 一周为周期
				for (int j = 0; j < 7; j++)
				{
					int index = i + j;
					// 亲，在此写你的业务逻辑
					System.out.println(calendar.get(index));
				}
				n++;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 十以下前补0
	 * 
	 * @param num
	 * @return
	 */
	private static String getValue(int num)
	{
		return String.valueOf(num > 9 ? num : ("0" + num));
	}

	/**
	 * 获取星期1-7
	 * 
	 * @param calendar
	 * @return
	 */
	public static int getWeekDay(Calendar calendar)
	{
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDay == 0 ? 7 : weekDay;
	}

	/**
	 * 字符串日期,获取年、月、日、星期等
	 * 
	 * @param date
	 * @param value
	 *            年:Calendar.YEAR 月:Calendar.MONTH 注意:以0开始计算的 日:Calendar.DATE 星期:Calendar.MONDAY 等 参见Calendar中的变量
	 * @return
	 */
	static String getTime(String date, int value)
	{
		Calendar ca = Calendar.getInstance();
		ca.setTime(string2Date(date));
		return String.valueOf(ca.get(value));
	}

	static String date2String(Date date)
	{
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	static Date string2Date(String date)
	{
		try
		{
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}