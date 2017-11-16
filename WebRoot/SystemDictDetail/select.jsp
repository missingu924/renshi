<!DOCTYPE html> 
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%> 
<!-- 引入类 --> 
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="com.wuyg.common.util.StringUtil"%> 
<%@page import="com.wuyg.common.util.TimeUtil"%> 
<%@page import="com.wuyg.common.obj.PaginationObj"%> 
<%@page import="com.wuyg.dictionary.DictionaryUtil"%> 
<%@page import="com.wuyg.system.obj.SystemDictDetailObj"%> 
<%@page import="com.wuyg.system.searchcondition.SystemDictDetailSearchCondition"%> 
<%@page import="com.wuyg.auth.obj.AuthUserObj"%> 
<%@page import="com.wuyg.common.util.SystemConstant"%>
<%@page import="com.wuyg.system.obj.SystemDictObj"%>  
<!-- 基本信息 --> 
<% 
	// 当前上下文路径 
	String contextPath = request.getContextPath(); 
 
	// 该功能对象实例 
	SystemDictDetailObj domainInstance = (SystemDictDetailObj) request.getAttribute("domainInstance"); 
	// 该功能对象查询条件实例 
	SystemDictDetailSearchCondition domainSearchCondition = (SystemDictDetailSearchCondition) request.getAttribute("domainSearchCondition"); 
	// 用户信息 
	AuthUserObj user = (AuthUserObj) request.getSession().getAttribute(SystemConstant.AUTH_USER_INFO); 
	// 该功能路径 
	String basePath = domainInstance.getBasePath(); 
	
	// 字典对象
	SystemDictObj systemDict = (SystemDictObj) request.getAttribute("systemDict"); 
 
	// 查询结果 
	PaginationObj pagination = null; 
	List list = new ArrayList(); 
 
	Object paginationObj = request.getAttribute("domainPagination"); 
	if (paginationObj != null) 
	{ 
		pagination = (PaginationObj) paginationObj; 
		list = (List) pagination.getDataList(); 
	} 
%> 
<html> 
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no" /> 
		<title><%=domainInstance.getCnName() %>列表</title> 
		<link href="../css/global.css" rel="stylesheet" type="text/css"> 
		<script type="text/javascript" src="../js/jquery-2.0.3.min.js"></script> 
		<script type="text/javascript" src="../js/utils.js"></script> 
		<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script> 
		<script type="text/javascript" src="../js/jquery.freezeheader.js"></script> 
		<script type="text/javascript">$(document).ready(function () {$("#data_table").freezeHeader();})</script> 
	</head> 
	<body> 
		<form name="pageForm" id="pageForm" method="post" action="<%=request.getContextPath()%>/Proxy/Servlet?servlet=<%=basePath%>&method=list4this"> 
			<input type="hidden" id="showSearchConditionTable" name="showSearchConditionTable" value="<%=domainSearchCondition.isShowSearchConditionTable()%>"> 
			<input type="hidden" id="showHelpInfoTable" name="showHelpInfoTable" value="<%=domainSearchCondition.isShowHelpInfoTable()%>"> 
			<input type="hidden" id="showSearchConditionTable" name="showSearchConditionTable" value="<%=domainSearchCondition.isShowSearchConditionTable()%>"> 
			<input type="hidden" id="orderBy" name="orderBy" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getOrderBy(), "")%>"> 
			<input type="hidden" id="i_dict_id" name="i_dict_id" value="<%=StringUtil.getNotEmptyStr(domainInstance.getI_dict_id(), "")%>"> 
			
			<!-- 工具栏 --> 
			<table class="search_table" align="center" width="98%"> 
				<tr> 
					<td><%=systemDict.getC_dict_name() %></td>  
					<td></td> 
					<td> 
						<input name="searchButton" type="button" class="button button_set" value="条件" onClick="$('#search_condition_table').toggle();$('#showSearchConditionTable').val(!$('#search_condition_table').is(':hidden'));">
						<input name="searchButton" type="button" class="button button_search" value="查询" onClick="toPage(1)"> 
					</td> 
				</tr> 
			</table> 
			<!-- 提示信息 -->  
			<table id="help_info_table" class="help_info_table" align="center" width="98%" style='display: <%=domainSearchCondition.isShowHelpInfoTable() ? "" : "none"%>'> 
				<tr> 
					<td> 
						<b>【提示】</b> 
						<ul> 
							<li><%=domainInstance.getCnName() %></li> 
						</ul> 
					</td> 
				</tr> 
			</table> 
			<!-- 查询条件 -->  
			<table id="search_condition_table" class="search_condition_table" align="center" width="98%" style='display: <%=domainSearchCondition.isShowSearchConditionTable() ? "" : "none"%>'> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("c_code") %></td> 
						<td>
						<input name="c_code" type="text" id="c_code" value="<%=StringUtil.getNotEmptyStr(domainInstance.getC_code(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("c_name") %></td> 
						<td>
						<input name="c_name" type="text" id="c_name" value="<%=StringUtil.getNotEmptyStr(domainInstance.getC_name(),"")%>" size="20" > 
						</td> 
				</tr> 
			</table> 
 
			<!-- 数据信息 -->  
			<table id="data_table" class="table table-bordered" align="center" width="98%"> 
				<thead> 
					<tr> 
						<th>序号</th> 
						<th onClick="sortBy(this)" db_col="c_code" class="<%=domainSearchCondition.getSortClassByDbColumn("c_code")%>"><%=systemDict.getC_dict_name() %><%=domainInstance.getPropertyCnName("c_code") %></th> 
						<th onClick="sortBy(this)" db_col="c_name" class="<%=domainSearchCondition.getSortClassByDbColumn("c_name")%>"><%=systemDict.getC_dict_name() %><%=domainInstance.getPropertyCnName("c_name") %></th> 
					</tr> 
				</thead> 
				<% 
					for (int i = 0; i < list.size(); i++) 
						{ 
							SystemDictDetailObj o = (SystemDictDetailObj) list.get(i); 
				%> 
				<tr onclick='confirmSelect(this)' value='<%=o.toString() %>'> 
					<td style="width:30px;text-align:right"><%=i+1 %></td>
					<td><%=StringUtil.getNotEmptyStr(o.getC_code())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getC_name())%></td> 
				</tr> 
				<% 
					} 
				%> 
			</table> 
 
			<!-- 翻页操作栏 --> 
			<jsp:include page="../ToolBar/pagination_toolbar.jsp"> 
				<jsp:param name="basePath" value="<%=basePath%>"/> 
			</jsp:include> 
 
		</form>  
		<script type="text/javascript">  
			// 双击选择  
			function confirmSelect(tr)  
			{  
			window.returnValue = $(tr).attr("value");  
			window.close();  
			}  
		</script>  
 
	</body> 
</html> 
