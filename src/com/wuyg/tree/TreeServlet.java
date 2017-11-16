package com.wuyg.tree;

import java.util.ArrayList;
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
import com.wuyg.common.util.SystemConstant;
import com.wuyg.tree.obj.TreeObj;
import com.wuyg.tree.obj.ZTreeNode;
import com.wuyg.tree.service.TreeService;

public class TreeServlet extends AbstractBaseServletTemplate
{
	private Logger logger = Logger.getLogger(getClass());
	private TreeService service = new TreeService();

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
		return com.wuyg.tree.obj.TreeObj.class;
	}

	@Override
	public Class getDomainSearchConditionClz()
	{
		return com.wuyg.tree.searchcondition.TreeSearchCondition.class;
	}

	// 查询
	public void list4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.list(request, response);
	}

	// 检查ID是否已录入系统
	public void checkId4this(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.checkId(request, response);
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

	// 查询
	public void list4select(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		TreeObj treeObj = (TreeObj) domainInstance;

		ZTreeNode ztreeNode = service.getZtreeNode(treeObj.getName(), treeObj.getData_soure(), treeObj.getOpen(), treeObj.getSelect_ids());

		request.setAttribute("ztreeNode", ztreeNode);
		request.setAttribute(DOMAIN_INSTANCE, domainInstance);

		request.getRequestDispatcher("/" + getBasePath() + "/" + BASE_METHOD_LIST + "4select.jsp").forward(request, response);
	}

}
