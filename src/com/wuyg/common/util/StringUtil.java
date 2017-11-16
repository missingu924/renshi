package com.wuyg.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
	/**
	 * 截取字符串
	 * 
	 * @param s
	 * @param startStr
	 * @param endStr
	 * @return
	 */
	public static String substr(String s, String startStr, String endStr)
	{
		return s.substring(s.indexOf(startStr) + startStr.length(), s.indexOf(endStr, s.indexOf(startStr) + startStr.length()));
	}

	/**
	 * 根据String List获得用 号分割的字符串,每个数据项都用单引号引起来
	 * 
	 * @param stringList
	 * @return
	 */
	public static String getStringByListWithQuotation(List stringList)
	{
		return getStringByList(stringList, true);
	}

	/**
	 * 根据String List获得用逗号分割的字符串,每个数据项都不用单引号引起来
	 * 
	 * @param stringList
	 * @return
	 */
	public static String getStringByListNoQuotation(List stringList)
	{
		return getStringByList(stringList, false);
	}

	/**
	 * 根据String List获得用逗号分割的问号字符串,用于数据库操作时的占位符
	 * 
	 * @param stringList
	 * @return
	 */
	public static String getQuestionMarkStringByList(List stringList)
	{
		if (stringList == null || stringList.size() == 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringList.size(); i++)
		{
			sb.append("?");
			if (i != stringList.size() - 1)
			{
				sb.append(",");
			}
		}

		return sb.toString();
	}

	/**
	 * 根据String List获得用逗号分割的字符串，如果withQuotation=true则每个数据项都用单引号引起来
	 * 
	 * 
	 * @param stringList
	 * @param withQuotation
	 * @return
	 */
	public static String getStringByList(List stringList, boolean withQuotation)
	{
		if (stringList == null || stringList.size() == 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringList.size(); i++)
		{
			if (withQuotation)
			{
				sb.append("'");
			}
			sb.append(stringList.get(i));
			if (withQuotation)
			{
				sb.append("'");
			}
			if (i != stringList.size() - 1)
			{
				sb.append(",");
			}
		}

		return sb.toString();
	}

	public static String getStringByList(String[] stringArray, boolean withQuotation)
	{
		if (stringArray == null || stringArray.length == 0)
		{
			return "";
		}

		List<String> stringList = new ArrayList<String>();

		for (int i = 0; i < stringArray.length; i++)
		{
			stringList.add(stringArray[i]);
		}

		return getStringByList(stringList, withQuotation);
	}

	/**
	 * 根据逗号或分号将字符串拆分为list，注意：逗号和分号都会认作是分割符
	 * 
	 * @param listString
	 * @return
	 */
	public static List<String> getStringListByString(String listString)
	{
		List<String> stringList = new ArrayList<String>();
		if (!isEmpty(listString))
		{
			String[] temp = listString.split(",|;|\\|");
			for (int i = 0; i < temp.length; i++)
			{
				if (!isEmpty(temp[i]))
				{
					stringList.add(temp[i]);
				}
			}
		}

		return stringList;
	}

	public static List<String> getStringListByString(String listString, char separator, char quoter)
	{
		List<String> stringList = new ArrayList<String>();
		if (!isEmpty(listString))
		{
			// String[] temp = listString.split(separator);
			//
			// String columnStr = "";
			// boolean inQuotation = false;
			// for (int i = 0; i < temp.length; i++)
			// {
			// columnStr += temp[i];
			// if (temp[i].trim().contains(quoter))
			// {
			// if (inQuotation == false)
			// {
			// inQuotation = true;
			// } else
			// {
			// inQuotation = false;
			// }
			// }
			//
			// if (inQuotation == true)
			// {
			// columnStr += separator;
			// } else
			// {
			// if (!isEmpty(columnStr))
			// {
			// stringList.add(columnStr);
			// }
			// columnStr = "";
			// }
			// }

			char[] chars = listString.toCharArray();
			String s = "";
			boolean inQuotation = false;
			for (int i = 0; i < chars.length; i++)
			{
				if (i == chars.length - 1)
				{
					s += chars[i];
					if (!isEmpty(s.trim()))
					{
						stringList.add(s);
					}
					break;
				}

				if (chars[i] == separator)
				{
					if (inQuotation)
					{
						s += chars[i];
					} else if (!isEmpty(s.trim()))
					{
						stringList.add(s);
						s = "";
					}
				} else
				{
					s += chars[i];

					if (chars[i] == quoter)
					{
						if (inQuotation)
						{
							inQuotation = false;
							if (!isEmpty(s.trim()))
							{
								stringList.add(s);
								s = "";
							}
						} else
						{
							inQuotation = true;
						}
					}
				}
			}
		}

		return stringList;
	}

	/**
	 * 判断ListA中的字符串是否都在ListB??
	 * 
	 * @param listA
	 * @param listB
	 * @return
	 */
	public static boolean isListAInListB(List<String> listA, List<String> listB)
	{
		for (int i = 0; i < listA.size(); i++)
		{
			boolean in = false;
			for (int j = 0; j < listB.size(); j++)
			{
				if (listB.get(j).equalsIgnoreCase(listA.get(i)))
				{
					in = true;
					break;
				}
			}
			if (!in)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否为null或为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str)
	{
		return str == null || str.trim().equals("") || "null".equalsIgnoreCase(str.trim());
	}

	public static String trim(String str)
	{
		if (isEmpty(str))
		{
			return "";
		} else
		{
			return str.trim();
		}
	}

	/**
	 * 根据String List获得用separator分割的字符串
	 * 
	 * @param stringList
	 * @param withQuotation
	 * @return
	 */
	public static String getStringByList(List stringList, String separator)
	{
		if (stringList == null || stringList.size() == 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringList.size(); i++)
		{
			sb.append(stringList.get(i));
			if (i != stringList.size() - 1)
			{
				sb.append(separator);
			}
		}

		return sb.toString();
	}

	/**
	 * 如果字符串为null则返回空字符串，否则返回原字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String getNotEmptyStr(Object checkObj)
	{
		return getNotEmptyStr(checkObj, "");
	}

	public static String getNotEmptyStr(Object checkObj, String returnString)
	{
		if (checkObj == null)
		{
			return returnString;
		} else
		{
			if (isEmpty(checkObj.toString()))
			{
				return returnString;
			} else
			{
				return checkObj.toString();
			}
		}
	}

	/**
	 * 返回最长不超过maxLength的字符串
	 * 
	 * @param checkObj
	 * @param maxLength
	 * @return
	 */
	public static String getNotEmptyStr(Object checkObj, int maxLength)
	{
		String str = getNotEmptyStr(checkObj, "");
		if (str.length() > maxLength)
		{
			return str.substring(0, maxLength) + "…";
		} else
		{
			return str;
		}
	}

	public static String getStringByList(String[] stringArray, String separator)
	{
		if (stringArray == null || stringArray.length == 0)
		{
			return "";
		}

		List<String> stringList = new ArrayList<String>();

		for (int i = 0; i < stringArray.length; i++)
		{
			stringList.add(stringArray[i]);
		}

		return getStringByList(stringList, separator);
	}

	public static int parseInt(String intStr) throws Exception
	{
		return isEmpty(intStr) ? 0 : Integer.parseInt(intStr);
	}

	public static long parseLong(String longStr) throws Exception
	{
		return isEmpty(longStr) ? 0 : Long.parseLong(longStr);
	}

	public static double parseDouble(Object doubleStr) throws Exception
	{
		return isEmpty(doubleStr + "") ? 0 : Double.parseDouble(doubleStr + "");
	}

	// 首字母大写
	public static String upperFirstChar(String name)
	{
		if (!isEmpty(name))
		{
			return name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
		}

		return null;
	}

	// 将输入的名字转换为标准的类名
	public static String toClassName(String name)
	{
		// 首字母大写,下划线去掉，下划线后的第一个字母大写
		String[] tmp = name.split("_");

		String className = "";
		for (int i = 0; i < tmp.length; i++)
		{
			className += upperFirstChar(tmp[i]);
		}

		return className;
	}

	/**
	 * 格式化，保留scale位小数，四舍五入
	 * 
	 * @param value
	 * @param scale
	 * @return
	 */
	public static String formatDouble(Double value, int scale)
	{
		if (value == null)
		{
			return "";
		}
		BigDecimal bg = new BigDecimal(value);
		double f1 = bg.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.format("%." + scale + "f", f1);
	}

	/**
	 * 改造in条件，每1000个数据项组成一个
	 * 
	 * @param columnName
	 * @param values
	 * @return
	 */
	public static String getInSql(String columnName, List<String> values)
	{
		if (values == null || values.size() == 0)
		{
			return "1=1";
		}

		StringBuffer sql = new StringBuffer();

		List<String> inList = new ArrayList<String>();
		String inSql = "";
		for (int i = 0; i < values.size(); i++)
		{
			inSql += "'" + values.get(i) + "',";

			if ((i + 1) % 1000 == 0 || (i == values.size() - 1))
			{
				inList.add(inSql.substring(0, inSql.length() - 1));
				inSql = "";
			}
		}

		for (int i = 0; i < inList.size(); i++)
		{
			if (i > 0)
			{
				sql.append(" or ");
			}
			sql.append(columnName).append(" in (").append(inList.get(i)).append(") ");
		}

		return sql.toString();
	}

	/**
	 * 字符串转换为16进制字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String str2hex(String s)
	{
		String str = "";
		for (int i = 0; i < s.length(); i++)
		{
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 16进制字符串转换为字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String hex2str(String s)
	{
		if (s == null || s.equals(""))
		{
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++)
		{
			try
			{
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			s = new String(baKeyword, "gbk");
			new String();
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * 从左侧填充字符串到指定长度
	 * 
	 * @param srcStr
	 * @param fillWithChar
	 * @param totalLength
	 * @return
	 */
	public static String fillStringFromLeft(String srcStr, char fillWithChar, int totalLength)
	{
		int lenth = srcStr.length();

		for (int i = 0; i < (totalLength - lenth); i++)
		{
			srcStr = fillWithChar + srcStr;
		}

		return srcStr;
	}

	/**
	 * 从右侧填充字符串到指定长度
	 * 
	 * @param srcStr
	 * @param fillWithChar
	 * @param totalLength
	 * @return
	 */
	public static String fillStringFromRight(String srcStr, char fillWithChar, int totalLength)
	{
		int lenth = srcStr.length();

		for (int i = 0; i < (totalLength - lenth); i++)
		{
			srcStr = srcStr + fillWithChar;
		}

		return srcStr;
	}

	public static void main(String[] args)
	{
		// System.out.println(toClassName("a_b"));
		System.out.println(formatDouble(0.1325d, 3));
	}
}
