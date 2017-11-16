package com.wuyg.common.util;

import java.io.*;
import java.net.*;

import org.apache.commons.digester.*;
import org.apache.commons.digester.xmlrules.*;
import org.apache.log4j.*;
import org.xml.sax.*;

/**
 * <p>
 * Title: DigesterHelper
 * </p>
 * 
 * <p>
 * Description: Digester��Helper���򣬷�װ��Digester�Ĳ���
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * <p>
 * Company: Langchao LG Information Systems Co.,Ltd
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class DigesterHelper
{
	/**
	 * ��ݹ���xml inputstreamӳ��Ϊ����
	 * 
	 * @param xmlRuleFile
	 *            String
	 * @param is
	 *            InputStream
	 * @return Object
	 * @throws SAXException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static Object parseFromInputStream(URL xmlRuleFile, InputStream is) throws SAXException, MalformedURLException, IOException
	{
		Level level = Logger.getRootLogger().getLevel();
		try
		{
			// �ر�rootLogger����ֹdigester�ĵ�����Ϣ���xml��������rootLogger�ļ���Ӧ�ûָ�����ǰ��״̬
			Logger.getRootLogger().setLevel(Level.OFF);

			// ���xml���õ�ӳ����򴴽�Digester
			Digester dis = DigesterLoader.createDigester(xmlRuleFile);
			// ��֤web����������ʹ��
			dis.setUseContextClassLoader(true);
			// ����xml
			return dis.parse(is);
		} finally
		{
			Logger.getRootLogger().setLevel(level);
			if (is != null)
			{
				is.close();
			}
		}
	}

	/**
	 * ��ݹ���xml fileӳ��Ϊ����
	 * 
	 * @param destObjClz
	 *            Class ����õ��Ķ���������ɴ�����õ����������Ӧ�������ļ��� �����ļ��������ͬһ��Ŀ¼�£�����Ϊ����+Rule.xml��
	 * @param is
	 *            InputStream
	 * @return Object
	 * @throws Exception
	 */
	public static Object parseFromXmlFile(Class destObjClz, InputStream is) throws Exception
	{
		String className = destObjClz.getName();
		String xmlRulePath = className.replace('.', '/') + "Rule.xml";
		URL xmlRuleUrl = Thread.currentThread().getContextClassLoader().getResource(xmlRulePath);
		if (xmlRuleUrl == null)
		{
			throw new Exception("���ڽ���" + className + "�������ļ�" + xmlRulePath + "��ClassPath���治����,����.");
		}
		return parseFromInputStream(xmlRuleUrl, is);
	}

	/**
	 * ��ݹ���xml Stringӳ��Ϊ����
	 * 
	 * @param xmlRuleFile
	 *            URL
	 * @param xmlString
	 *            String
	 * @return Object
	 * @throws Exception
	 */
	public static Object parseFromXmlString(URL xmlRuleFile, String xmlString) throws Exception
	{
		return parseFromInputStream(xmlRuleFile, new ByteArrayInputStream(xmlString.getBytes()));
	}

	/**
	 * ��ݹ���xml Stringӳ��Ϊ����
	 * 
	 * @param destObjClz
	 *            Class ����õ��Ķ���������ɴ�����õ����������Ӧ�������ļ��� �����ļ��������ͬһ��Ŀ¼�£�����Ϊ����+Rule.xml��
	 * @param xmlString
	 *            String
	 * @return Object
	 * @throws Exception
	 */
	public static Object parseFromXmlString(Class destObjClz, String xmlString) throws Exception
	{
		String className = destObjClz.getName();
		String xmlRulePath = className.replace('.', '/') + "Rule.xml";
		URL xmlRuleUrl = Thread.currentThread().getContextClassLoader().getResource(xmlRulePath);
		if (xmlRuleUrl == null)
		{
			throw new Exception("���ڽ���" + className + "�������ļ�" + xmlRulePath + "��ClassPath���治����,����.");
		}
		return parseFromInputStream(xmlRuleUrl, new ByteArrayInputStream(xmlString.getBytes()));
	}

	/**
	 * ��ݹ���xml fileӳ��Ϊ����
	 * 
	 * @param xmlRuleFile
	 *            URL
	 * @param xmlFile
	 *            String
	 * @return Object
	 * @throws Exception
	 */
	public static Object parseFromXmlFile(URL xmlRuleFile, String xmlFile) throws Exception
	{
		return parseFromInputStream(xmlRuleFile, new FileInputStream(xmlFile));
	}

	/**
	 * ��ݹ���xml fileӳ��Ϊ����
	 * 
	 * @param destObjClz
	 *            Class ����õ��Ķ���������ɴ�����õ����������Ӧ�������ļ��� �����ļ��������ͬһ��Ŀ¼�£�����Ϊ����+Rule.xml��
	 * @param xmlFile
	 *            String
	 * @return Object
	 * @throws Exception
	 */
	public static Object parseFromXmlFile(Class destObjClz, String xmlFile) throws Exception
	{
		String className = destObjClz.getName();
		String xmlRulePath = className.replace('.', '/') + "Rule.xml";
		URL xmlRuleUrl = Thread.currentThread().getContextClassLoader().getResource(xmlRulePath);
		if (xmlRuleUrl == null)
		{
			throw new Exception("���ڽ���" + className + "�������ļ�" + xmlRulePath + "��ClassPath���治����,����.");
		}
		return parseFromInputStream(xmlRuleUrl, new FileInputStream(xmlFile));
	}

	/**
	 * ��ݹ���xml fileӳ��Ϊ����
	 * 
	 * @param destObjClz
	 *            Class ����õ��Ķ���������ɴ�����õ����������Ӧ�������ļ��Ͳ��������ļ��� ������������ļ��������ͬһ��Ŀ¼�£�����Ϊ����+Rule.xml�� ���������ļ��������ͬһ��Ŀ¼�£�����Ϊ����+.xml
	 * @return Object
	 * @throws Exception
	 */
	public static Object parseByClzz(Class destObjClz) throws Exception
	{
		String className = destObjClz.getName();
		String xmlRulePath = className.replace('.', '/') + "Rule.xml";
		URL xmlRuleUrl = Thread.currentThread().getContextClassLoader().getResource(xmlRulePath);
		if (xmlRuleUrl == null)
		{
			throw new Exception("���ڽ���" + className + "�������ļ�" + xmlRulePath + "��ClassPath���治����,����.");
		}
		String xmlFilePath = className.replace('.', '/') + ".xml";
		URL xmlFileUrl = Thread.currentThread().getContextClassLoader().getResource(xmlFilePath);
		if (xmlRuleUrl == null)
		{
			throw new Exception(className + "�Ĳ��������ļ���ClassPath���治����,����.");
		}
		return parseFromInputStream(xmlRuleUrl, xmlFileUrl.openStream());
	}

}
