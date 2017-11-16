package com.wuyg.common.util;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * �ļ�ɾ���̣߳�����ɾ��ָ��Ŀ¼�³���ָ��������ļ���
 * 
 * @author �����
 * 
 */
public class FileDeleteThread extends Thread
{
	private Logger log = Logger.getLogger(getClass());

	private File dir = null;
	private int days = Integer.MAX_VALUE;

	public FileDeleteThread(File dir, int days)
	{
		this.dir = dir;
		this.days = days;
	}

	@Override
	public void run()
	{
		try
		{
			if (dir.exists())
			{
				File[] files = dir.listFiles();
				if (files == null)
				{
					return;
				}
				for (int j = 0; j < files.length; j++)
				{
					File file = files[j];
					if (file.isFile() && file.exists() && ((System.currentTimeMillis() - file.lastModified()) > days * 24 * 3600 * 1000l))
					{
						boolean rst = file.delete();
						log.info("�ļ�����洢ʱ��,ɾ��[" + (rst ? "�ɹ�" : "ʧ��") + "]:" + file.getCanonicalPath());
					}
				}
			}
		} catch (Exception e)
		{
			log.error(e.getMessage(), e);
		}
	}
}
