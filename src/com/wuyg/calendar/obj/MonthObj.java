package com.wuyg.calendar.obj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wuyg.common.util.CalendarUtil;
import com.wuyg.common.util.TimeUtil;

public class MonthObj
{
	private int year;
	private int month;
	private List<WeekObj> weeks = new ArrayList<WeekObj>();

	public MonthObj(int year, int month)
	{
		this.year = year;
		this.month = month;

		try
		{
			List<String> calendar = CalendarUtil.getCalendar(year, month);
			int n = 1;
			for (int i = 0; i < calendar.size(); i += 7)
			{
				// 第n周
				WeekObj weekObj = new WeekObj(year, month, n);

				// 一周为周期
				for (int j = 0; j < 7; j++)
				{
					int index = i + j;

					DayObj dayObj = new DayObj(TimeUtil.str2date(calendar.get(index), "yyy-MM-dd"));
					weekObj.getDays().add(dayObj);
				}
				n++;

				weeks.add(weekObj);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public List<WeekObj> getWeeks()
	{
		return weeks;
	}

	public void setWeeks(List<WeekObj> weeks)
	{
		this.weeks = weeks;
	}

	// 把一个对象实例放到某一天中
	public boolean putOneObj(Date theDay, Object obj)
	{
		for (int i = 0; i < weeks.size(); i++)
		{
			WeekObj week = weeks.get(i);
			List<DayObj> days = week.getDays();
			for (int j = 0; j < days.size(); j++)
			{
				DayObj day = days.get(j);
				if (TimeUtil.date2str(theDay, "yyyy-MM-dd").equals(TimeUtil.date2str(day.getDate(), "yyyy-MM-dd")))
				{
					day.getObjList().add(obj);
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer(year + "年" + month + "月\n\n");
		for (int i = 0; i < weeks.size(); i++)
		{
			WeekObj week = weeks.get(i);
			s.append(week.toString()).append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args)
	{
		MonthObj month = new MonthObj(2017, 11);
		
		month.putOneObj(new Date(), "");

		System.out.println(month);
	}
}
