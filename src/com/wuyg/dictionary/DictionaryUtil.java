package com.wuyg.dictionary;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.IdClass;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.inspur.common.dictionary.Dictionary;
import com.inspur.common.dictionary.pojo.Dict;
import com.inspur.common.dictionary.pojo.DictItem;
import com.wuyg.common.util.MySqlUtil;
import com.wuyg.common.util.StringUtil;
import com.wuyg.common.util.SystemConstant;
import com.wuyg.dictionary.obj.DictionaryObj;
import com.wuyg.dictionary.service.DictionaryService;

public class DictionaryUtil
{
	private static Logger logger = Logger.getLogger(DictionaryUtil.class);

	/**
	 * 根据字典数据生成html的select元素
	 * 
	 * @param items
	 * @param selectName
	 * @param selectedItemKey
	 * @return
	 */
	public static String getSelectHtml(String dictName, String selectName)
	{
		return getSelectHtml(dictName, selectName, null);
	}

	/**
	 * 根据是否字典获取checkbox
	 * 
	 * @param selectName
	 * @param selectedItemKey
	 * @param disabled
	 * @return
	 */
	public static String getCheckboxHtml(String selectName, String selectedItemKey, boolean disabled)
	{
		String html = "";
		html += "<input name=\"" + selectName + "_checkbox\" id=\"" + selectName + "_checkbox\" type=\"checkbox\" " + ("是".equalsIgnoreCase(selectedItemKey) ? "checked" : "") + " onchange=\"$('#" + selectName + "').val($(this).is(':checked')?'是':'否')\" " + (disabled ? "disabled" : "") + "> \n";
		if (!disabled)
		{
			html += "<input name=\"" + selectName + "\" id=\"" + selectName + "\" type=\"hidden\" value=\"" + selectedItemKey + "\"/> \n";
		}
		return html;
	}

	/**
	 * 根据字典数据生成html的select元素
	 * 
	 * @param items
	 * @param selectName
	 * @param selectedItemKey
	 * @return
	 */
	public static String getSelectHtml(String dictName, String selectName, String selectedItemKey, boolean isMultiple)
	{
		List<DictItem> items = new DictionaryService().getDictItemsByDictName(dictName, true);

		if (isMultiple)
		{
			items.remove(0);// 多选时，去掉'--请选择--'的提示
			selectedItemKey = "," + selectedItemKey + ",";
		}

		return getSelectHtml(items, selectName, selectedItemKey, isMultiple);
	}

	public static String getSelectHtml(String dictName, String selectName, String selectedItemKey, String dbFilter)
	{
		return getSelectHtml(dictName, selectName, selectedItemKey, dbFilter, false);
	}

	public static String getSelectHtml(List<DictItem> items, String selectName, String selectedItemKey, boolean isMultiple)
	{
		StringBuffer sb = new StringBuffer();

		sb.append("<select name='" + selectName + "' " + (isMultiple ? "multiple='multiple'" : "") + "size='" + (isMultiple ? 5 : 1) + "' id='" + selectName + "' >");

		for (int i = 0; i < items.size(); i++)
		{
			DictItem item = items.get(i);

			boolean selected = false;
			if (isMultiple)
			{
				selected = selectedItemKey.contains("," + item.getK() + ",");
			} else
			{
				selected = item.getK().equals(selectedItemKey);
			}

			sb.append("<option value='" + item.getK() + "' " + (selected ? "selected='selected'" : "") + ">" + item.getV() + "</option>");
		}
		sb.append("</select>");

		return sb.toString();
	}

	public static String getSelectHtml(String dictName, String selectName, String selectedItemKey, String dbFilter, boolean isMultiple)
	{
		List<DictItem> items = new DictionaryService().getDictItemsByDictName(dictName, dbFilter, false);

		StringBuffer sb = new StringBuffer();

		sb.append("<select name='" + selectName + "' " + (isMultiple ? "multiple='multiple'" : "") + "size='" + (isMultiple ? items.size() : 1) + "' id='" + selectName + "' >");
		for (int i = 0; i < items.size(); i++)
		{
			DictItem item = items.get(i);

			boolean selected = false;
			if (isMultiple)
			{
				selected = selectedItemKey.contains("," + item.getK() + ",");
			} else
			{
				selected = item.getK().equals(selectedItemKey);
			}

			sb.append("<option value='" + item.getK() + "' " + (selected ? "selected='selected'" : "") + ">" + item.getKV() + "</option>");
		}
		sb.append("</select>");

		return sb.toString();
	}

	public static String getSelectHtml(String dictName, String selectName, String selectedItemKey)
	{
		return getSelectHtml(dictName, selectName, selectedItemKey, false);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, int size)
	{
		return getInputHtml(dictName, inputName, inputValue, null, null, size, true);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, int size, boolean multiSelect)
	{
		return getInputHtml(dictName, inputName, inputValue, null, null, size, multiSelect);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, String dbFilter, int size, boolean multiSelect)
	{
		return getInputHtml(dictName, inputName, inputValue, null, null, dbFilter, size, multiSelect, null);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, boolean multiSelect)
	{
		return getInputHtml(dictName, inputName, inputValue, null, null, 40, multiSelect);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, String dbFilter, boolean multiSelect)
	{
		return getInputHtml(dictName, inputName, inputValue, null, null, dbFilter, 40, multiSelect, null);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, boolean multiSelect, String callBack)
	{
		return getInputHtml(dictName, inputName, inputValue, null, null, null, 40, multiSelect, callBack);
	}

	public static String getInputHtmlReadOnly(String dictName, String inputName, String inputValue, int size)
	{
		StringBuffer sb = new StringBuffer();

		String inputName4show = inputName + "_4show";
		sb.append("<input type=\"text\" id=\"" + inputName4show + "\" name=\"" + inputName4show + "\" value=\"" + getValueByKey(dictName, inputValue) + "\" readOnly size=\"" + size + "\" style=\"background: #eeeeee;\"> \n");
		sb.append("<input type=\"hidden\" id=\"" + inputName + "\" name=\"" + inputName + "\" value=\"" + inputValue + "\"> \n");

		return sb.toString();
	}

	/**
	 * 获取输入及显示内容html
	 * 
	 * @param dictName
	 *            字典名
	 * @param inputName
	 *            输入input字段名
	 * @param inputValue
	 *            输入input字段值
	 * @param parentDictName
	 *            父字典名
	 * @param parentDictInputName
	 *            父字典的input字段名
	 * @param dbFilter
	 *            据库过滤条件
	 * @param size
	 *            input宽度
	 * @return
	 */
	public static String getInputHtml(String dictName, String inputName, String inputValue, String parentDictName, String parentDictInputName, String dbFilter, int size, boolean multiSelect, String callBack)
	{
		StringBuffer sb = new StringBuffer();

		String inputName4show = inputName + "_4show";
		sb.append("<input type=\"text\" id=\"" + inputName4show + "\" name=\"" + inputName4show + "\" value=\"" + getValueByKey(dictName, inputValue) + "\" onclick=\"selectFromDictionary('" + dictName + "','" + inputName + "','" + inputName4show + "',"
				+ (!StringUtil.isEmpty(parentDictName) ? ("'" + parentDictName + "',$('#" + parentDictInputName) + "').val()," : "'','',") + (!StringUtil.isEmpty(dbFilter) ? ("'" + dbFilter + "'") : "''") + ",'" + multiSelect + "','" + callBack + "')\" readOnly size=\"" + size + "\"><input id=\""
				+ inputName + "_clear_btn\" type=\"button\" class=\"button button_clear\" title=\"重置\" onclick=\"$('#" + inputName + "').val('');$('#" + inputName4show + "').val('');\"> \n");
		sb.append("<input type=\"hidden\" id=\"" + inputName + "\" name=\"" + inputName + "\" value=\"" + inputValue + "\"> \n");

		return sb.toString();
	}

	public static String getInputHtmlFromJavaClass(String dictName, String inputName, String inputValue, boolean muliti)
	{
		return getInputHtmlFromJavaClass(dictName, inputName, inputValue);
	}

	public static String getInputHtmlFromJavaClass(String dictName, String inputName, String inputValue, String callBack)
	{
		return getInputHtmlFromJavaClass(dictName, inputName, inputValue, 40, callBack, null);
	}

	public static String getInputHtmlFromJavaClass(String dictName, String inputName, String inputValue, String callBack, String urlExtra)
	{
		return getInputHtmlFromJavaClass(dictName, inputName, inputValue, 40, callBack, urlExtra);
	}

	public static String getInputHtmlFromJavaClass(String dictName, String inputName, String inputValue, int size, String callBack, String urlExtra)
	{
		StringBuffer sb = new StringBuffer();

		Dict dict = new Dictionary().getDictByName(dictName);

		// filter转换为url，例如从 name='1001' and code='2002' 转换为 name=1001&code=2002
		String objFilterString = dict.getFilter().replaceAll("\\s+", "").replaceAll("and", "&").replaceAll("'", "");
		if (!StringUtil.isEmpty(urlExtra))
		{
			// 附加的url，传递到具体的查询url中，例如 name=wyg&age=35
			objFilterString += "&" + urlExtra;
		}

		String inputName4show = inputName + "_4show";
		String inputName4all = inputName + "_4all";
		sb.append("<input type=\"text\" id=\"" + inputName4show + "\" name=\"" + inputName4show + "\" value=\"" + getValueByKey(dictName, inputValue) + "\" onclick=\"selectFromDictionaryByJavaClass('" + StringUtil.toClassName(dict.getDictTable()) + "','" + inputName + "','" + inputName4show + "',"
				+ "'" + dict.getDictKeyCol() + "','" + dict.getDictValueCol() + "','" + objFilterString + "','" + callBack + "')\" readOnly size=\"" + size + "\"><input id=\"" + inputName + "_clear_btn\" type=\"button\" class=\"button button_clear\" title=\"重置\" onclick=\"$('#" + inputName
				+ "').val('');$('#" + inputName4show + "').val('');\"> \n");
		sb.append("<input type=\"hidden\" id=\"" + inputName + "\" name=\"" + inputName + "\" value=\"" + inputValue + "\"> \n");
		sb.append("<input type=\"hidden\" id=\"" + inputName4all + "\" name=\"" + inputName4all + "\" value=\"\"> \n");

		return sb.toString();
	}

	public static String getInputHtmlFromJavaClass(String dictName, String inputName, String inputValue)
	{
		return getInputHtmlFromJavaClass(dictName, inputName, inputValue, 40, null, null);
	}

	public static String getInputHtmlFromJavaClass(String dictName, String inputName, String inputValue, int size)
	{
		return getInputHtmlFromJavaClass(dictName, inputName, inputValue, size, null, null);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, String parentDictName, String parentDictInputName, int size, boolean multiSelect)
	{
		return getInputHtml(dictName, inputName, inputValue, parentDictName, parentDictInputName, null, size, multiSelect, null);
	}

	public static String getInputHtml(String dictName, String inputName, String inputValue, String parentDictName, String parentDictInputName, boolean multiSelect)
	{
		return getInputHtml(dictName, inputName, inputValue, parentDictName, parentDictInputName, 20, multiSelect);
	}

	public static String getDictValueByDictKey(String dictName, String key)
	{
		return getDictValueByDictKey(dictName, key, false);
	}

	public static String getDictValueByDictKey(String dictName, String key, String dbName)
	{
		return getDictValueByDictKey(dictName, key, false, dbName);
	}

	public static String getDictValueByDictKey(String dictName, String key, boolean showKey)
	{
//		logger.info("====dict:" + dictName + "====");

		String dbName = StringUtil.getNotEmptyStr(new Dictionary().getDictByName(dictName).getDbName(), SystemConstant.DEFAULT_DB);

		return getDictValueByDictKey(dictName, key, showKey, dbName);
	}

	public static String getDictValueByDictKey(String dictName, String keys, boolean showKey, String dbName)
	{
		try
		{
			if (StringUtil.isEmpty(keys))
			{
				return "";
			}

			Dictionary dictionary = new Dictionary();

			String values = "";

			List<String> keyList = StringUtil.getStringListByString(keys.replaceFirst("multi:", ""));

			for (int i = 0; i < keyList.size(); i++)
			{
				String key = keyList.get(i);
				// 先从缓存中取，如果取不到再从数据库中取
				String value = dictionary.getDictValueByDictKeyFromCache(dictName, key);
				if (StringUtil.isEmpty(value))
				{
					List<String> dbNames = StringUtil.getStringListByString(dbName);
					for (int j = 0; j < dbNames.size(); j++)
					{
						DataSource ds = MySqlUtil.getDataSource(dbNames.get(j));
						value = dictionary.getDictValueByDictKeyFromDb(dictName, key, ds);
						if (!StringUtil.isEmpty(value) && !value.equalsIgnoreCase(key))
						{
							break;
						}
					}

				}
				if (showKey && !StringUtil.isEmpty(value) && !key.equalsIgnoreCase(value))
				{
					value = key + " - " + value;
				}

				values += value + ",";
			}

			if (values.length() > 0)
			{
				values = values.substring(0, values.length() - 1);
			}

			return values;
		} catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return "";
	}

	private static String getValueByKey(String dictName, String keys)
	{
		if (keys == null || keys.length() == 0)
		{
			return "";
		}

		List<String> keyList = StringUtil.getStringListByString(keys.replaceFirst("multi:", ""));

		List<DictItem> items = new DictionaryService().getDictItemsByDictName(dictName, false);

		String values = "";
		for (int n = 0; n < keyList.size(); n++)
		{
			String key = keyList.get(n);

			for (int i = 0; i < items.size(); i++)
			{
				DictItem item = items.get(i);

				if (key.equalsIgnoreCase(item.getK()))
				{
					values += item.getV() + ",";
					break;
				}
			}
		}

		if (values.length() > 0)
		{
			values = values.substring(0, values.length() - 1);
		}

		return values;
	}

	/**
	 * 根据前台选择的多个key值返回一个list，如输入multi:01,02,03，输出 {01,02,03}
	 * 
	 * @param keysWithMulti
	 * @return
	 */
	public static List<String> getKeyListFromMultiSelect(String keysWithMulti)
	{
		if (StringUtil.isEmpty(keysWithMulti))
		{
			return new ArrayList<String>();
		}
		return StringUtil.getStringListByString(keysWithMulti.replaceFirst("multi:", ""));
	}

	/**
	 * 清除缓存
	 */
	public static void clearCache()
	{
		new Dictionary().clearCache();
	}

	/**
	 * 清除缓存
	 */
	public static void clearCache(String dictName)
	{
		new Dictionary().clearCache(dictName);
	}

	/**
	 * 清除缓存
	 */
	public static void clearCacheByTablename(String tableName)
	{
		new Dictionary().clearCacheByTablename(tableName);
	}
}
