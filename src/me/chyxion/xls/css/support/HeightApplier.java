package me.chyxion.xls.css.support;

import java.util.HashMap;
import java.util.Map;

import me.chyxion.xls.css.CssApplier;
import me.chyxion.xls.css.CssUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 * @version 0.0.1
 * @since 0.0.1
 * @author Shaun Chyxion <br>
 *         chyxion@163.com <br>
 *         Oct 24, 2014 5:18:57 PM
 */
public class HeightApplier implements CssApplier
{

	/**
	 * {@inheritDoc}
	 */
	public Map<String, String> parse(Map<String, String> style)
	{
		Map<String, String> mapRtn = new HashMap<String, String>();
		String height = style.get(HEIGHT);
		if (CssUtils.isNum(height))
		{
			mapRtn.put(HEIGHT, height);
		}
		return mapRtn;
	}

	/**
	 * {@inheritDoc}
	 */
	public void apply(HSSFCell cell, HSSFCellStyle cellStyle, Map<String, String> style)
	{
		int height = Math.round(CssUtils.getInt(style.get(HEIGHT)) * 255 / 12.75F);
		HSSFRow row = cell.getRow();
		if (height > row.getHeight())
		{
			row.setHeight((short) height);
		}
	}
}
