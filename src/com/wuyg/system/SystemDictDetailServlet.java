package com.wuyg.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;

import com.wuyg.common.dao.DefaultBaseDAO;
import com.wuyg.common.dao.IBaseDAO;
import com.wuyg.common.obj.PaginationObj;
import com.wuyg.common.servlet.AbstractBaseServletTemplate;
import com.wuyg.common.util.StringUtil;
import com.wuyg.dictionary.DictionaryUtil;
import com.wuyg.system.obj.SystemDictDetailObj;
import com.wuyg.system.obj.SystemDictObj;

public class SystemDictDetailServlet extends AbstractBaseServletTemplate
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
		return com.wuyg.system.obj.SystemDictDetailObj.class;
	}

	@Override
	public Class getDomainSearchConditionClz()
	{
		return com.wuyg.system.searchcondition.SystemDictDetailSearchCondition.class;
	}

	// 查询
	public void list4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		searchDict(request);

		super.list(request, response);
	}

	private void searchDict(HttpServletRequest request)
	{
		SystemDictDetailObj detai = (SystemDictDetailObj) domainInstance;

		SystemDictObj systemDict = new SystemDictObj();
		Object obj = systemDict.searchBykey(detai.getI_dict_id() + "");
		if (obj != null)
		{
			systemDict = (SystemDictObj) obj;
		}
		request.setAttribute("systemDict", systemDict);
	}

	// 检查ID是否已录入系统
	public void checkId4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.checkId(request, response);
	}

	public void select4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		searchDict(request);
		super.select(request, response);
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
		searchDict(request);
		super.delete(request, response);
	}

	// 批量删除
	public void batchDelete4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// super.batchDelete(request, response);

		searchDict(request);

		String[] keys = request.getParameterValues(domainInstance.findKeyColumnName());

		int successCount = getDomainDao().deleteByKeys(Arrays.asList(keys));

		// 转向
		if (successCount > 0)
		{
			// 传递needRefresh
			request.setAttribute("needRefresh", true);
			list4this(request, response);
		} else
		{
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
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
		super.exportFromHtml(request, response);
	}
	
	// 停用
	public void disable4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		SystemDictDetailObj o = (SystemDictDetailObj)domainInstance;
		o.setIn_use("否");
		boolean rst = o.update();
		
		response.getWriter().print(rst);
	}
	
	// 启用
	public void enable4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		SystemDictDetailObj o = (SystemDictDetailObj)domainInstance;
		o.setIn_use("是");
		boolean rst = o.update();
		response.getWriter().print(rst);
	}

}
