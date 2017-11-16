<!DOCTYPE html> 
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%> 
<!-- 引入类 --> 
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="com.wuyg.common.util.StringUtil"%> 
<%@page import="com.wuyg.common.util.TimeUtil"%> 
<%@page import="com.wuyg.common.obj.PaginationObj"%> 
<%@page import="com.wuyg.dictionary.DictionaryUtil"%> 
<%@page import="com.u8.obj.HrHiPersonObj4Show"%> 
<%@page import="com.u8.searchcondition.HrHiPersonSearchCondition"%> 
<%@page import="com.wuyg.auth.obj.AuthUserObj"%> 
<%@page import="com.wuyg.common.util.SystemConstant"%>  
<!-- 基本信息 --> 
<% 
	// 当前上下文路径 
	String contextPath = request.getContextPath(); 
 
	// 该功能对象实例 
	HrHiPersonObj4Show domainInstance = (HrHiPersonObj4Show) request.getAttribute("domainInstance"); 
	// 该功能对象查询条件实例 
	HrHiPersonSearchCondition domainSearchCondition = (HrHiPersonSearchCondition) request.getAttribute("domainSearchCondition"); 
	// 用户信息 
	AuthUserObj user = (AuthUserObj) request.getSession().getAttribute(SystemConstant.AUTH_USER_INFO); 
	// 该功能路径 
	String basePath = domainInstance.getBasePath(); 
 
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
		<base target="_self" /> 
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
			<input type="hidden" id="otherWhere" name="otherWhere" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getOtherWhere(), "")%>"> 
			 
			<!-- 工具栏 --> 
			<table class="search_table" align="center" width="98%"> 
				<tr> 
					<td><%=domainInstance.getCnName() %></td>  
					<td>
						<%=domainInstance.getPropertyCnName("cpsn_name") %>
						<input name="cpsn_name" type="text" id="cpsn_name" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_name(),"")%>" size="20" > 
						
						<%=domainInstance.getPropertyCnName("cdept_num") %>
						<%=DictionaryUtil.getInputHtml("department", "cdept_num", StringUtil.getNotEmptyStr(domainInstance.getCdept_num(), ""),20)%> 
						
						<%=domainInstance.getPropertyCnName("cpsnmobilephone") %>
						<input name="cpsnmobilephone" type="text" id="cpsnmobilephone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnmobilephone(),"")%>" size="20" > 
					</td> 
					<td> 
						<input name="searchButton" type="button" class="button button_set" value="条件" onClick="$('#search_condition_table').toggle();$('#showSearchConditionTable').val(!$('#search_condition_table').is(':hidden'));">
						<input name="searchButton" type="button" class="button button_search" value="查询" onClick="toPage(1)"> 
						
						&nbsp;&nbsp; 
						<input name="helpButton" type="button" class="button button_comment" title="提示" onClick="$('#help_info_table').toggle();$('#showHelpInfoTable').val(!$('#help_info_table').is(':hidden'));"> 
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
						<td><%=domainInstance.getPropertyCnName("cpsndutname") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT995", "cpsndutname", StringUtil.getNotEmptyStr(domainInstance.getCpsndutname(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnysjb") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT987", "cpsnysjb", StringUtil.getNotEmptyStr(domainInstance.getCpsnysjb(), ""),20)%> 
						</td>
				</tr>
				<tr>  
						<td><%=domainInstance.getPropertyCnName("cpsnzylb") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT993", "cpsnzylb", StringUtil.getNotEmptyStr(domainInstance.getCpsnzylb(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnzykm") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT888", "cpsnzykm", StringUtil.getNotEmptyStr(domainInstance.getCpsnzykm(), ""),20)%> 
						</td> 
				</tr>
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnjoblevel") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT997", "cpsnjoblevel", StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblevel(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsntopredd") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT002", "cpsntopredd", StringUtil.getNotEmptyStr(domainInstance.getCpsntopredd(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rpersontype") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT000", "rpersontype", StringUtil.getNotEmptyStr(domainInstance.getRpersontype(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("weishengjishu") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT777", "weishengjishu", StringUtil.getNotEmptyStr(domainInstance.getWeishengjishu(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rsex") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT001", "rsex", StringUtil.getNotEmptyStr(domainInstance.getRsex(), ""),20)%> 
						</td>
						<td></td>
						<td></td>
				</tr> 
			</table> 
 
			<!-- 数据信息 -->  
			<table id="export_table" class="table table-bordered" align="center" width="98%"> 
				<thead> 
					<tr> 
						<th>序号</th> 
						<th onClick="sortBy(this)" db_col="cpsn_name" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsn_name")%>"><%=domainInstance.getPropertyCnName("cpsn_name") %></th> 
						<th onClick="sortBy(this)" db_col="cdept_num" class="<%=domainSearchCondition.getSortClassByDbColumn("cdept_num")%>"><%=domainInstance.getPropertyCnName("cdept_num") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndut" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndut")%>"><%=domainInstance.getPropertyCnName("cpsndut") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndutname" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndutname")%>"><%=domainInstance.getPropertyCnName("cpsndutname") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnysjb" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnysjb")%>"><%=domainInstance.getPropertyCnName("cpsnysjb") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzylb" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzylb")%>"><%=domainInstance.getPropertyCnName("cpsnzylb") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzykm" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzykm")%>"><%=domainInstance.getPropertyCnName("cpsnzykm") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnjoblevel" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnjoblevel")%>"><%=domainInstance.getPropertyCnName("cpsnjoblevel") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopredd" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopredd")%>"><%=domainInstance.getPropertyCnName("cpsntopredd") %></th> 
						<th onClick="sortBy(this)" db_col="rsex" class="<%=domainSearchCondition.getSortClassByDbColumn("rsex")%>"><%=domainInstance.getPropertyCnName("rsex") %></th> 
						<th onClick="sortBy(this)" db_col="dbirthdate" class="<%=domainSearchCondition.getSortClassByDbColumn("dbirthdate")%>"><%=domainInstance.getPropertyCnName("dbirthdate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnmobilephone" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnmobilephone")%>"><%=domainInstance.getPropertyCnName("cpsnmobilephone") %></th> 
						<th onClick="sortBy(this)" db_col="weishengjishu" class="<%=domainSearchCondition.getSortClassByDbColumn("weishengjishu")%>"><%=domainInstance.getPropertyCnName("weishengjishu") %></th> 
						<th onClick="sortBy(this)" db_col="rpersontype" class="<%=domainSearchCondition.getSortClassByDbColumn("rpersontype")%>"><%=domainInstance.getPropertyCnName("rpersontype") %></th> 
					</tr> 
				</thead> 
				<% 
					for (int i = 0; i < list.size(); i++) 
						{ 
							HrHiPersonObj4Show o = (HrHiPersonObj4Show) list.get(i); 
				%> 
				<tr> 
					<td style="width:30px;text-align:right"><%=i+1 %></td> 
					<td>
						<a href="#" onClick="winOpen('<%=contextPath%>/Proxy/Servlet?servlet=<%=basePath%>&method=detail4this&<%=o.findKeyColumnName()%>=<%=o.findKeyValue()%>')">
						<%=StringUtil.getNotEmptyStr(o.getCpsn_name())%>
						</a>
					</td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("department",o.getCdept_num()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsndut())%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT995",o.getCpsndutname()+"",false)%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT987",o.getCpsnysjb()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT993",o.getCpsnzylb()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT888",o.getCpsnzykm()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT997",o.getCpsnjoblevel()+"",false)%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT002",o.getCpsntopredd()+"",false)%></td>
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT001",o.getRsex()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getDbirthdate())%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnmobilephone())%></td>   
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT777",o.getWeishengjishu()+"",false)%></td>
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT000",o.getRpersontype()+"",false)%></td>    
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
 
	</body> 
</html> 
