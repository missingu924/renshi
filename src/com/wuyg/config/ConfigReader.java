/*
 * Copyright (c) 2003 - 2005 Langchao LG Information Systems Co.,Ltd.
 * All Rights Reserved.
 */
package com.wuyg.config;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;

import org.apache.commons.fileupload.FileUpload;
import org.apache.log4j.Logger;

import com.wuyg.common.dao.DefaultBaseDAO;
import com.wuyg.common.dao.IBaseDAO;
import com.wuyg.common.util.StringUtil;
import com.wuyg.common.util.SystemConstant;
import com.wuyg.system.obj.SystemConfigDbObj;

public class ConfigReader
{
	public static Logger logger = Logger.getLogger(ConfigReader.class);

	private synchronized static void loadProperties()
	{
		// if (properties == null)
		{
			// Create a manager with the full path to the xml config file.
			try
			{
				// get the config
				URI filepath = Thread.currentThread().getContextClassLoader().getResource(CONFIG_PATH).toURI();
				// properties = new XMLProperties("file:///" + filepath);
				properties = new XMLProperties(filepath);
				// properties = new XMLProperties(filepath);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public static String getProperties(String key)
	{
		if (properties == null)
		{
			loadProperties();
		}
		String value = properties.getPorperty(key);
		// if (StringUtil.isEmpty(value))
		// {
		// logger.debug("从数据库中读取配置："+key);
		// SystemConfigDbObj o = new SystemConfigDbObj(key, null);
		// SystemConfigDbObj keyValue = (SystemConfigDbObj) configDao.searchByUniqueIndex(o);
		// if (keyValue != null)
		// {
		// value = keyValue.getValue();
		// }
		// }
		return value;
	}

	public static void setProperties(String key, String value) throws IOException
	{
		if (properties == null)
		{
			loadProperties();
		}

		properties.setProperty(key, value);
	}

	private static XMLProperties properties;
	private static final String CONFIG_PATH = "SystemConfig.xml";

	private static IBaseDAO configDao = new DefaultBaseDAO(SystemConfigDbObj.class, SystemConstant.DEFAULT_DB);
}
