package com.hcp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;

import com.hcp.obj.HcpDataSourceBaseInfoObj;
import com.wuyg.common.dao.DefaultBaseDAO;
import com.wuyg.common.dao.IBaseDAO;
import com.wuyg.common.obj.PaginationObj;
import com.wuyg.common.servlet.AbstractBaseServletTemplate;
import com.wuyg.common.util.StringUtil;

public class HcpDataSourceBaseInfoServlet extends AbstractBaseServletTemplate
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
		return new DefaultBaseDAO(getDomainInstanceClz());
	}

	@Override
	public Class getDomainInstanceClz()
	{
		return com.hcp.obj.HcpDataSourceBaseInfoObj.class;
	}

	@Override
	public Class getDomainSearchConditionClz()
	{
		return com.hcp.searchcondition.HcpDataSourceBaseInfoSearchCondition.class;
	}

	// 查询
	public void list4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.list(request, response);
	}

	// 检查ID是否已录入系统
	public void checkId4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// super.checkId(request,response);
		HcpDataSourceBaseInfoObj baseInfo = (HcpDataSourceBaseInfoObj) domainInstance;

		int num = getDomainDao().countByClause("( base_info_name ='" + baseInfo.getBase_info_name() + "' or (ds_code='" + baseInfo.getDs_code() + "' and base_info_type_code='" + baseInfo.getBase_info_type_code() + "'))");
		if (num > 0)
		{
			response.getWriter().write("true");
		} else
		{
			response.getWriter().write("false");
		}
		response.flushBuffer();
	}

	// 增加 or 修改
	public void addOrModify4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.addOrModify(request, response);
	}

	// 修改前查询领域对象信息
	public void preModify4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.preModify(request, response);
	}

	// 详情
	public void detail4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.detail(request, response);
	}

	// 删除
	public void delete4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.delete(request, response);
	}

	public void allowDelete4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.allowDelete(request, response);
	} // 删除 按前台条件查出的所有数据

	public void deleteAll4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.deleteAll(request, response);
	}

	// 导出
	public void export4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.export(request, response);
	}

}
