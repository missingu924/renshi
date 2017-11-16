package com.wuyg.calendar.obj;

import java.util.ArrayList;
import java.util.List;

public class WeekObj
{
	private int year;
	private int month;
	private int weekOfMonth;

	public WeekObj(int year, int month, int weekOfMonth)
	{
		this.year = year;
		this.month = month;
		this.weekOfMonth = weekOfMonth;
	}

	private List<DayObj> days = new ArrayList<DayObj>();

	public int getWeekOfMonth()
	{
		return weekOfMonth;
	}

	public void setWeekOfMonth(int weekOfMonth)
	{
		this.weekOfMonth = weekOfMonth;
	}

	public List<DayObj> getDays()
	{
		return days;
	}

	public void setDays(List<DayObj> days)
	{
		this.days = days;
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

	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer("第" + weekOfMonth + "周\n");
		for (int i = 0; i < days.size(); i++)
		{
			DayObj day = days.get(i);
			s.append(day.toString()).append("\n");
		}
		return s.toString();
	}
}
