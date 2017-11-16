package com.u8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.u8.obj.HrHiPersonObj4Show;
import com.wuyg.common.dao.DefaultBaseDAO;
import com.wuyg.common.dao.IBaseDAO;
import com.wuyg.common.servlet.AbstractBaseServletTemplate;
import com.wuyg.common.util.ImageUtil;
import com.wuyg.common.util.MySqlUtil;
import com.wuyg.common.util.SystemConstant;

public class HrHiPersonServlet extends AbstractBaseServletTemplate
{
	private Logger logger = Logger.getLogger(getClass());

	@Override
	public String getBasePath()
	{
		return domainInstance.getBasePath();
	}

	@Override
	public IBaseDAO getDomainDao()
	{
		return new DefaultBaseDAO(getDomainInstanceClz(), SystemConstant.U8_DB);
	}

	@Override
	public Class getDomainInstanceClz()
	{
		return com.u8.obj.HrHiPersonObj.class;
	}

	@Override
	public Class getDomainSearchConditionClz()
	{
		return com.u8.searchcondition.HrHiPersonSearchCondition.class;
	}

	// 查询
	public void list4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.list(request, response, HrHiPersonObj4Show.class);
	}

	// 选择
	public void select4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.select(request, response, HrHiPersonObj4Show.class);
	}

	// 检查ID是否已录入系统
	public void checkId4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.checkId(request, response);
	}

	// 增加 or 修改
	public void addOrModify4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.addOrModify(request, response, HrHiPersonObj4Show.class);
	}

	// 修改前查询领域对象信息
	public void preModify4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.preModify(request, response, HrHiPersonObj4Show.class);
	}

	// 详情
	public void detail4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 获取照片
		getPicture(request, response);

		super.detail(request, response, HrHiPersonObj4Show.class);
	}

	// 判断是否能够删除，默认可以删除
	public void allowDelete4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.allowDelete(request, response);
	}

	// 删除
	public void delete4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.delete(request, response);
	}

	// 批量删除
	public void batchDelete4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.batchDelete(request, response);
	}

	// 删除 按前台条件查出的所有数据
	public void deleteAll4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.deleteAll(request, response);
	}

	// 导出
	public void export4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.exportFromHtml(request, response);
	}

	public void getPicture(HttpServletRequest request, HttpServletResponse response)
	{
		Connection connection = null;
		try
		{
			connection = MySqlUtil.getConnection(SystemConstant.U8_DB);

			ResultSet rst = connection.createStatement().executeQuery("select * from hr_hi_person where cpsn_num='" + domainInstanceKeyValue + "'");

			while (rst.next())
			{
				String filePath = request.getRealPath("/picture/") + "/" + domainInstanceKeyValue + ".jpg";
				File picFile = new File(filePath);

				if (!picFile.getParentFile().exists())
				{
					picFile.getParentFile().mkdirs();
				}

				InputStream ins = rst.getBinaryStream("MPicture");
				if (ins != null)
				{
					int tmpi = 0;

					OutputStream out = new FileOutputStream(picFile);
					while ((tmpi = ins.read()) != -1)
					{
						out.write(tmpi);
					}
					out.close();
				} else
				{
					picFile.delete();
				}

				if (picFile.length() == 0)
				{
					picFile.delete();
				} else
				{
					// 生成小文件
					ImageUtil.resize(picFile, new File(picFile.getAbsolutePath() + ".min"), 260, 1);
				}
			}

		} catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		} finally
		{
			MySqlUtil.closeConnection(connection);
		}
	}
}
