package com.wuyg.calendar.obj;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.wuyg.common.util.TimeUtil;

public class DayObj
{
	private int year;
	private int month;
	private int day;

	private int dayOfWeek;
	private int dayOfMonth;
	private List<Object> objList = new ArrayList<Object>();

	private Date date = null;

	// public DayObj(int year, int month, int day, int dayOfWeek)
	// {
	// this.year = year;
	// this.month = month;
	// this.day = day;
	// this.dayOfWeek = dayOfWeek;
	// }

	public DayObj(Date date)
	{
		this.date = date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH) + 1;
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		this.dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	}

	public int getDayOfWeek()
	{
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek)
	{
		this.dayOfWeek = dayOfWeek;
	}

	public int getDayOfMonth()
	{
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth)
	{
		this.dayOfMonth = dayOfMonth;
	}

	public List<Object> getObjList()
	{
		return objList;
	}

	public void setObjList(List<Object> objList)
	{
		this.objList = objList;
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

	public int getDay()
	{
		return day;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		return TimeUtil.date2str(date, "yyyy-MM-dd") + ":保存对象数" + objList.size();
	}
}
