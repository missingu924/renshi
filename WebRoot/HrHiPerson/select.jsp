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
		<title><%=domainInstance.getCnName() %>选择</title> 
		<link href="../css/global.css" rel="stylesheet" type="text/css"> 
		<script type="text/javascript" src="../js/jquery-2.0.3.min.js"></script> 
		<script type="text/javascript" src="../js/utils.js"></script> 
		<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script> 
		<script type="text/javascript" src="../js/jquery.freezeheader.js"></script> 
		<script type="text/javascript">$(document).ready(function () {$("#data_table").freezeHeader();})</script> 
	</head> 
	<body> 
		<form name="pageForm" id="pageForm" method="post" action="<%=request.getContextPath()%>/Proxy/Servlet?servlet=<%=basePath%>&method=select4this"> 
			<input type="hidden" id="showSearchConditionTable" name="showSearchConditionTable" value="<%=domainSearchCondition.isShowSearchConditionTable()%>"> 
			<input type="hidden" id="showHelpInfoTable" name="showHelpInfoTable" value="<%=domainSearchCondition.isShowHelpInfoTable()%>"> 
			<input type="hidden" id="showSearchConditionTable" name="showSearchConditionTable" value="<%=domainSearchCondition.isShowSearchConditionTable()%>"> 
			<input type="hidden" id="orderBy" name="orderBy" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getOrderBy(), "")%>"> 
			 
			<!-- 工具栏 --> 
			<table class="search_table" align="center" width="98%"> 
				<tr> 
					<td><%=domainInstance.getCnName() %></td>  
					<td></td> 
					<td> 
						<input name="searchButton" type="button" class="button button_set" value="条件" onClick="$('#search_condition_table').toggle();$('#showSearchConditionTable').val(!$('#search_condition_table').is(':hidden'));">
						<input name="searchButton" type="button" class="button button_search" value="查询" onClick="toPage(1)"> 
					</td> 
				</tr> 
			</table> 
			<!-- 查询条件 -->  
			<table id="search_condition_table" class="search_condition_table" align="center" width="98%" style='display: <%=domainSearchCondition.isShowSearchConditionTable() ? "" : "none"%>'> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsn_name") %></td> 
						<td>
						<input name="cpsn_name" type="text" id="cpsn_name" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_name(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cdept_num") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("department", "cdept_num", StringUtil.getNotEmptyStr(domainInstance.getCdept_num(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("irecordid") %></td> 
						<td>
						<input name="irecordid_min" type="text" id="irecordid_min" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getIrecordid_min(),"")%>" size="9" >- 
						<input name="irecordid_max" type="text" id="irecordid_max" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getIrecordid_max(),"")%>" size="9" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rpersontype") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT000", "rpersontype", StringUtil.getNotEmptyStr(domainInstance.getRpersontype(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("rsex") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT001", "rsex", StringUtil.getNotEmptyStr(domainInstance.getRsex(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("dbirthdate") %></td> 
						<td>
						<input name="dbirthdate" type="text" id="dbirthdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDbirthdate(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rnativeplace") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT007", "rnativeplace", StringUtil.getNotEmptyStr(domainInstance.getRnativeplace(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("rnational") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT005", "rnational", StringUtil.getNotEmptyStr(domainInstance.getRnational(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("rhealthstatus") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT008", "rhealthstatus", StringUtil.getNotEmptyStr(domainInstance.getRhealthstatus(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rmarristatus") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT009", "rmarristatus", StringUtil.getNotEmptyStr(domainInstance.getRmarristatus(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("vidno") %></td> 
						<td>
						<input name="vidno" type="text" id="vidno" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVidno(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("mpicture") %></td> 
						<td>
						<input name="mpicture" type="text" id="mpicture" value="<%=StringUtil.getNotEmptyStr(domainInstance.getMpicture(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rperresidence") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT007", "rperresidence", StringUtil.getNotEmptyStr(domainInstance.getRperresidence(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("valianame") %></td> 
						<td>
						<input name="valianame" type="text" id="valianame" value="<%=StringUtil.getNotEmptyStr(domainInstance.getValianame(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("djoinworkdate") %></td> 
						<td>
						<input name="djoinworkdate" type="text" id="djoinworkdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDjoinworkdate(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("denterdate") %></td> 
						<td>
						<input name="denterdate" type="text" id="denterdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDenterdate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("dregulardate") %></td> 
						<td>
						<input name="dregulardate" type="text" id="dregulardate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDregulardate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("vssno") %></td> 
						<td>
						<input name="vssno" type="text" id="vssno" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVssno(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rworkattend") %></td> 
						<td>
						<input name="rworkattend" type="text" id="rworkattend" value="<%=StringUtil.getNotEmptyStr(domainInstance.getRworkattend(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("vcardno") %></td> 
						<td>
						<input name="vcardno" type="text" id="vcardno" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVcardno(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("rtbmrule") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("hr_tm_Rule", "rtbmrule", StringUtil.getNotEmptyStr(domainInstance.getRtbmrule(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rcheckinflag") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT059", "rcheckinflag", StringUtil.getNotEmptyStr(domainInstance.getRcheckinflag(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("dlastdate") %></td> 
						<td>
						<input name="dlastdate" type="text" id="dlastdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDlastdate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("hrts") %></td> 
						<td>
						<input name="hrts" type="text" id="hrts" value="<%=StringUtil.getNotEmptyStr(domainInstance.getHrts(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("vstatus1") %></td> 
						<td>
						<input name="vstatus1" type="text" id="vstatus1" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVstatus1(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("nstatus2") %></td> 
						<td>
						<input name="nstatus2_min" type="text" id="nstatus2_min" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getNstatus2_min(),"")%>" size="9" >- 
						<input name="nstatus2_max" type="text" id="nstatus2_max" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getNstatus2_max(),"")%>" size="9" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("bpsnperson") %></td> 
						<td>
						<input name="bpsnperson" type="text" id="bpsnperson" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBpsnperson(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnmobilephone") %></td> 
						<td>
						<input name="cpsnmobilephone" type="text" id="cpsnmobilephone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnmobilephone(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnfphone") %></td> 
						<td>
						<input name="cpsnfphone" type="text" id="cpsnfphone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfphone(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnophone") %></td> 
						<td>
						<input name="cpsnophone" type="text" id="cpsnophone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnophone(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsninphone") %></td> 
						<td>
						<input name="cpsninphone" type="text" id="cpsninphone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsninphone(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnemail") %></td> 
						<td>
						<input name="cpsnemail" type="text" id="cpsnemail" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnemail(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnpostaddr") %></td> 
						<td>
						<input name="cpsnpostaddr" type="text" id="cpsnpostaddr" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpostaddr(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnpostcode") %></td> 
						<td>
						<input name="cpsnpostcode" type="text" id="cpsnpostcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpostcode(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnfaddr") %></td> 
						<td>
						<input name="cpsnfaddr" type="text" id="cpsnfaddr" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfaddr(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnqqcode") %></td> 
						<td>
						<input name="cpsnqqcode" type="text" id="cpsnqqcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnqqcode(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnurl") %></td> 
						<td>
						<input name="cpsnurl" type="text" id="cpsnurl" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnurl(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnoseat") %></td> 
						<td>
						<input name="cpsnoseat" type="text" id="cpsnoseat" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnoseat(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("denterunitdate") %></td> 
						<td>
						<input name="denterunitdate" type="text" id="denterunitdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDenterunitdate(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnproperty") %></td> 
						<td>
						<input name="cpsnproperty" type="text" id="cpsnproperty" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnproperty(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnbankcode") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("aa_bank", "cpsnbankcode", StringUtil.getNotEmptyStr(domainInstance.getCpsnbankcode(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnaccount") %></td> 
						<td>
						<input name="cpsnaccount" type="text" id="cpsnaccount" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnaccount(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("pk_hr_hi_person") %></td> 
						<td>
						<input name="pk_hr_hi_person" type="text" id="pk_hr_hi_person" value="<%=StringUtil.getNotEmptyStr(domainInstance.getPk_hr_hi_person(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("bprobation") %></td> 
						<td>
						<input name="bprobation" type="text" id="bprobation" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBprobation(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cdutyclass") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("hr_tm_DutyClass", "cdutyclass", StringUtil.getNotEmptyStr(domainInstance.getCdutyclass(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("btaketm") %></td> 
						<td>
						<input name="btaketm" type="text" id="btaketm" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBtaketm(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("mpictureqpb") %></td> 
						<td>
						<input name="mpictureqpb" type="text" id="mpictureqpb" value="<%=StringUtil.getNotEmptyStr(domainInstance.getMpictureqpb(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("ridtype") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("hr_CT156", "ridtype", StringUtil.getNotEmptyStr(domainInstance.getRidtype(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rcountry") %></td> 
						<td>
						<input name="rcountry" type="text" id="rcountry" value="<%=StringUtil.getNotEmptyStr(domainInstance.getRcountry(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("dleavedate") %></td> 
						<td>
						<input name="dleavedate" type="text" id="dleavedate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDleavedate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("rfigure") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT157", "rfigure", StringUtil.getNotEmptyStr(domainInstance.getRfigure(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("rworkstatus") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT158", "rworkstatus", StringUtil.getNotEmptyStr(domainInstance.getRworkstatus(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("employmentform") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT803", "employmentform", StringUtil.getNotEmptyStr(domainInstance.getEmploymentform(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("rpersonparameters") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("hr_tm_PersonParameters", "rpersonparameters", StringUtil.getNotEmptyStr(domainInstance.getRpersonparameters(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("bdutylock") %></td> 
						<td>
						<input name="bdutylock" type="text" id="bdutylock" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBdutylock(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("bpsnshop") %></td> 
						<td>
						<input name="bpsnshop" type="text" id="bpsnshop" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBpsnshop(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cardstate") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT322", "cardstate", StringUtil.getNotEmptyStr(domainInstance.getCardstate(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("firsthtbegindate") %></td> 
						<td>
						<input name="firsthtbegindate" type="text" id="firsthtbegindate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getFirsthtbegindate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("lasthtenddate") %></td> 
						<td>
						<input name="lasthtenddate" type="text" id="lasthtenddate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getLasthtenddate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsn_nameen") %></td> 
						<td>
						<input name="cpsn_nameen" type="text" id="cpsn_nameen" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_nameen(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("sysage") %></td> 
						<td>
						<input name="sysage_min" type="text" id="sysage_min" value="<%=StringUtil.formatDouble(domainSearchCondition.getSysage_min(),2)%>" size="9" >- 
						<input name="sysage_max" type="text" id="sysage_max" value="<%=StringUtil.formatDouble(domainSearchCondition.getSysage_max(),2)%>" size="9" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("syscompage") %></td> 
						<td>
						<input name="syscompage_min" type="text" id="syscompage_min" value="<%=StringUtil.formatDouble(domainSearchCondition.getSyscompage_min(),2)%>" size="9" >- 
						<input name="syscompage_max" type="text" id="syscompage_max" value="<%=StringUtil.formatDouble(domainSearchCondition.getSyscompage_max(),2)%>" size="9" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("sysworkage") %></td> 
						<td>
						<input name="sysworkage_min" type="text" id="sysworkage_min" value="<%=StringUtil.formatDouble(domainSearchCondition.getSysworkage_min(),2)%>" size="9" >- 
						<input name="sysworkage_max" type="text" id="sysworkage_max" value="<%=StringUtil.formatDouble(domainSearchCondition.getSysworkage_max(),2)%>" size="9" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cregion") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT270", "cregion", StringUtil.getNotEmptyStr(domainInstance.getCregion(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("natruetype") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("hr_ct010", "natruetype", StringUtil.getNotEmptyStr(domainInstance.getNatruetype(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("jobnumber") %></td> 
						<td>
						<input name="jobnumber" type="text" id="jobnumber" value="<%=StringUtil.getNotEmptyStr(domainInstance.getJobnumber(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("persondepart") %></td> 
						<td>
						<input name="persondepart" type="text" id="persondepart" value="<%=StringUtil.getNotEmptyStr(domainInstance.getPersondepart(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cardeffectivebegintime") %></td> 
						<td>
						<input name="cardeffectivebegintime" type="text" id="cardeffectivebegintime" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCardeffectivebegintime(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cardeffectiveendtime") %></td> 
						<td>
						<input name="cardeffectiveendtime" type="text" id="cardeffectiveendtime" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCardeffectiveendtime(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("keyperson") %></td> 
						<td>
						<input name="keyperson" type="text" id="keyperson" value="<%=StringUtil.getNotEmptyStr(domainInstance.getKeyperson(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cleavereson") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("hr_ct011", "cleavereson", StringUtil.getNotEmptyStr(domainInstance.getCleavereson(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("shenfen") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT1000", "shenfen", StringUtil.getNotEmptyStr(domainInstance.getShenfen(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("weishengjishu") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT777", "weishengjishu", StringUtil.getNotEmptyStr(domainInstance.getWeishengjishu(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("gonglingqisuan") %></td> 
						<td>
						<input name="gonglingqisuan" type="text" id="gonglingqisuan" value="<%=StringUtil.getNotEmptyStr(domainInstance.getGonglingqisuan(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnppt") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT998", "cpsnppt", StringUtil.getNotEmptyStr(domainInstance.getCpsnppt(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnjoblevel") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT997", "cpsnjoblevel", StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblevel(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsncom") %></td> 
						<td>
						<input name="cpsncom" type="text" id="cpsncom" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncom(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsntopred") %></td> 
						<td>
						<input name="cpsntopred" type="text" id="cpsntopred" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopred(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsncollege") %></td> 
						<td>
						<input name="cpsncollege" type="text" id="cpsncollege" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncollege(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsntopdegree") %></td> 
						<td>
						<input name="cpsntopdegree" type="text" id="cpsntopdegree" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegree(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsncoll2") %></td> 
						<td>
						<input name="cpsncoll2" type="text" id="cpsncoll2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll2(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnincumred") %></td> 
						<td>
						<input name="cpsnincumred" type="text" id="cpsnincumred" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumred(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnincumcoll") %></td> 
						<td>
						<input name="cpsnincumcoll" type="text" id="cpsnincumcoll" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumcoll(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnjoblvldate") %></td> 
						<td>
						<input name="cpsnjoblvldate" type="text" id="cpsnjoblvldate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblvldate(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsntopredft") %></td> 
						<td>
						<input name="cpsntopredft" type="text" id="cpsntopredft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredft(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsntopdegreeft") %></td> 
						<td>
						<input name="cpsntopdegreeft" type="text" id="cpsntopdegreeft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegreeft(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsncoll4") %></td> 
						<td>
						<input name="cpsncoll4" type="text" id="cpsncoll4" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll4(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsncoll3") %></td> 
						<td>
						<input name="cpsncoll3" type="text" id="cpsncoll3" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll3(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsndegreeft") %></td> 
						<td>
						<input name="cpsndegreeft" type="text" id="cpsndegreeft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreeft(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnredft") %></td> 
						<td>
						<input name="cpsnredft" type="text" id="cpsnredft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnredft(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnincred") %></td> 
						<td>
						<input name="cpsnincred" type="text" id="cpsnincred" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincred(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnincdegree") %></td> 
						<td>
						<input name="cpsnincdegree" type="text" id="cpsnincdegree" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincdegree(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsntopredcode") %></td> 
						<td>
						<input name="cpsntopredcode" type="text" id="cpsntopredcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredcode(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsntopdegcode") %></td> 
						<td>
						<input name="cpsntopdegcode" type="text" id="cpsntopdegcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegcode(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsndut") %></td> 
						<td>
						<input name="cpsndut" type="text" id="cpsndut" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndut(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsndutdate") %></td> 
						<td>
						<input name="cpsndutdate" type="text" id="cpsndutdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnjoblvldate2") %></td> 
						<td>
						<input name="cpsnjoblvldate2" type="text" id="cpsnjoblvldate2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblvldate2(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnparty") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT119", "cpsnparty", StringUtil.getNotEmptyStr(domainInstance.getCpsnparty(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnrdate") %></td> 
						<td>
						<input name="cpsnrdate" type="text" id="cpsnrdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnrdate(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnpartysec") %></td> 
						<td>
						<input name="cpsnpartysec" type="text" id="cpsnpartysec" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpartysec(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnpartythd") %></td> 
						<td>
						<input name="cpsnpartythd" type="text" id="cpsnpartythd" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpartythd(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsndutname") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT995", "cpsndutname", StringUtil.getNotEmptyStr(domainInstance.getCpsndutname(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsndegreedate") %></td> 
						<td>
						<input name="cpsndegreedate" type="text" id="cpsndegreedate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreedate(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsndutdate2") %></td> 
						<td>
						<input name="cpsndutdate2" type="text" id="cpsndutdate2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate2(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsndate") %></td> 
						<td>
						<input name="cpsndate_min" type="text" id="cpsndate_min" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getCpsndate_min(),"")%>" size="9" >- 
						<input name="cpsndate_max" type="text" id="cpsndate_max" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getCpsndate_max(),"")%>" size="9" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnyear") %></td> 
						<td>
						<input name="cpsnyear_min" type="text" id="cpsnyear_min" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getCpsnyear_min(),"")%>" size="9" >- 
						<input name="cpsnyear_max" type="text" id="cpsnyear_max" value="<%=StringUtil.getNotEmptyStr(domainSearchCondition.getCpsnyear_max(),"")%>" size="9" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnlvl") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT121", "cpsnlvl", StringUtil.getNotEmptyStr(domainInstance.getCpsnlvl(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsntopredd") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT002", "cpsntopredd", StringUtil.getNotEmptyStr(domainInstance.getCpsntopredd(), ""),20)%> 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnzyzt") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT994", "cpsnzyzt", StringUtil.getNotEmptyStr(domainInstance.getCpsnzyzt(), ""),20)%> 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnzbzsbm") %></td> 
						<td>
						<input name="cpsnzbzsbm" type="text" id="cpsnzbzsbm" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzbzsbm(),"")%>" size="20" > 
						</td> 
						<td><%=domainInstance.getPropertyCnName("cpsnzyzbbm") %></td> 
						<td>
						<input name="cpsnzyzbbm" type="text" id="cpsnzyzbbm" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzyzbbm(),"")%>" size="20" > 
						</td> 
				</tr> 
				<tr> 
						<td><%=domainInstance.getPropertyCnName("cpsnysjb") %></td> 
						<td>
						<%=DictionaryUtil.getInputHtml("HR_CT987", "cpsnysjb", StringUtil.getNotEmptyStr(domainInstance.getCpsnysjb(), ""),20)%> 
						</td> 
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
						<td><%=domainInstance.getPropertyCnName("cpsnpzdate") %></td> 
						<td>
						<input name="cpsnpzdate" type="text" id="cpsnpzdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpzdate(),"")%>" size="20" > 
						</td> 
					<td></td><td></td> 
					<td></td><td></td> 
				</tr> 
			</table> 
 
			<!-- 数据信息 -->  
			<table id="data_table" class="table table-bordered" align="center" width="98%"> 
				<thead> 
					<tr> 
						<th>序号</th> 
						<th onClick="sortBy(this)" db_col="cpsn_name" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsn_name")%>"><%=domainInstance.getPropertyCnName("cpsn_name") %></th> 
						<th onClick="sortBy(this)" db_col="cdept_num" class="<%=domainSearchCondition.getSortClassByDbColumn("cdept_num")%>"><%=domainInstance.getPropertyCnName("cdept_num") %></th> 
						<th onClick="sortBy(this)" db_col="irecordid" class="<%=domainSearchCondition.getSortClassByDbColumn("irecordid")%>"><%=domainInstance.getPropertyCnName("irecordid") %></th> 
						<th onClick="sortBy(this)" db_col="rpersontype" class="<%=domainSearchCondition.getSortClassByDbColumn("rpersontype")%>"><%=domainInstance.getPropertyCnName("rpersontype") %></th> 
						<th onClick="sortBy(this)" db_col="rsex" class="<%=domainSearchCondition.getSortClassByDbColumn("rsex")%>"><%=domainInstance.getPropertyCnName("rsex") %></th> 
						<th onClick="sortBy(this)" db_col="dbirthdate" class="<%=domainSearchCondition.getSortClassByDbColumn("dbirthdate")%>"><%=domainInstance.getPropertyCnName("dbirthdate") %></th> 
						<th onClick="sortBy(this)" db_col="rnativeplace" class="<%=domainSearchCondition.getSortClassByDbColumn("rnativeplace")%>"><%=domainInstance.getPropertyCnName("rnativeplace") %></th> 
						<th onClick="sortBy(this)" db_col="rnational" class="<%=domainSearchCondition.getSortClassByDbColumn("rnational")%>"><%=domainInstance.getPropertyCnName("rnational") %></th> 
						<th onClick="sortBy(this)" db_col="rhealthstatus" class="<%=domainSearchCondition.getSortClassByDbColumn("rhealthstatus")%>"><%=domainInstance.getPropertyCnName("rhealthstatus") %></th> 
						<th onClick="sortBy(this)" db_col="rmarristatus" class="<%=domainSearchCondition.getSortClassByDbColumn("rmarristatus")%>"><%=domainInstance.getPropertyCnName("rmarristatus") %></th> 
						<th onClick="sortBy(this)" db_col="vidno" class="<%=domainSearchCondition.getSortClassByDbColumn("vidno")%>"><%=domainInstance.getPropertyCnName("vidno") %></th> 
						<th onClick="sortBy(this)" db_col="mpicture" class="<%=domainSearchCondition.getSortClassByDbColumn("mpicture")%>"><%=domainInstance.getPropertyCnName("mpicture") %></th> 
						<th onClick="sortBy(this)" db_col="rperresidence" class="<%=domainSearchCondition.getSortClassByDbColumn("rperresidence")%>"><%=domainInstance.getPropertyCnName("rperresidence") %></th> 
						<th onClick="sortBy(this)" db_col="valianame" class="<%=domainSearchCondition.getSortClassByDbColumn("valianame")%>"><%=domainInstance.getPropertyCnName("valianame") %></th> 
						<th onClick="sortBy(this)" db_col="djoinworkdate" class="<%=domainSearchCondition.getSortClassByDbColumn("djoinworkdate")%>"><%=domainInstance.getPropertyCnName("djoinworkdate") %></th> 
						<th onClick="sortBy(this)" db_col="denterdate" class="<%=domainSearchCondition.getSortClassByDbColumn("denterdate")%>"><%=domainInstance.getPropertyCnName("denterdate") %></th> 
						<th onClick="sortBy(this)" db_col="dregulardate" class="<%=domainSearchCondition.getSortClassByDbColumn("dregulardate")%>"><%=domainInstance.getPropertyCnName("dregulardate") %></th> 
						<th onClick="sortBy(this)" db_col="vssno" class="<%=domainSearchCondition.getSortClassByDbColumn("vssno")%>"><%=domainInstance.getPropertyCnName("vssno") %></th> 
						<th onClick="sortBy(this)" db_col="rworkattend" class="<%=domainSearchCondition.getSortClassByDbColumn("rworkattend")%>"><%=domainInstance.getPropertyCnName("rworkattend") %></th> 
						<th onClick="sortBy(this)" db_col="vcardno" class="<%=domainSearchCondition.getSortClassByDbColumn("vcardno")%>"><%=domainInstance.getPropertyCnName("vcardno") %></th> 
						<th onClick="sortBy(this)" db_col="rtbmrule" class="<%=domainSearchCondition.getSortClassByDbColumn("rtbmrule")%>"><%=domainInstance.getPropertyCnName("rtbmrule") %></th> 
						<th onClick="sortBy(this)" db_col="rcheckinflag" class="<%=domainSearchCondition.getSortClassByDbColumn("rcheckinflag")%>"><%=domainInstance.getPropertyCnName("rcheckinflag") %></th> 
						<th onClick="sortBy(this)" db_col="dlastdate" class="<%=domainSearchCondition.getSortClassByDbColumn("dlastdate")%>"><%=domainInstance.getPropertyCnName("dlastdate") %></th> 
						<th onClick="sortBy(this)" db_col="hrts" class="<%=domainSearchCondition.getSortClassByDbColumn("hrts")%>"><%=domainInstance.getPropertyCnName("hrts") %></th> 
						<th onClick="sortBy(this)" db_col="vstatus1" class="<%=domainSearchCondition.getSortClassByDbColumn("vstatus1")%>"><%=domainInstance.getPropertyCnName("vstatus1") %></th> 
						<th onClick="sortBy(this)" db_col="nstatus2" class="<%=domainSearchCondition.getSortClassByDbColumn("nstatus2")%>"><%=domainInstance.getPropertyCnName("nstatus2") %></th> 
						<th onClick="sortBy(this)" db_col="bpsnperson" class="<%=domainSearchCondition.getSortClassByDbColumn("bpsnperson")%>"><%=domainInstance.getPropertyCnName("bpsnperson") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnmobilephone" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnmobilephone")%>"><%=domainInstance.getPropertyCnName("cpsnmobilephone") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnfphone" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnfphone")%>"><%=domainInstance.getPropertyCnName("cpsnfphone") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnophone" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnophone")%>"><%=domainInstance.getPropertyCnName("cpsnophone") %></th> 
						<th onClick="sortBy(this)" db_col="cpsninphone" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsninphone")%>"><%=domainInstance.getPropertyCnName("cpsninphone") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnemail" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnemail")%>"><%=domainInstance.getPropertyCnName("cpsnemail") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnpostaddr" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnpostaddr")%>"><%=domainInstance.getPropertyCnName("cpsnpostaddr") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnpostcode" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnpostcode")%>"><%=domainInstance.getPropertyCnName("cpsnpostcode") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnfaddr" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnfaddr")%>"><%=domainInstance.getPropertyCnName("cpsnfaddr") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnqqcode" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnqqcode")%>"><%=domainInstance.getPropertyCnName("cpsnqqcode") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnurl" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnurl")%>"><%=domainInstance.getPropertyCnName("cpsnurl") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnoseat" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnoseat")%>"><%=domainInstance.getPropertyCnName("cpsnoseat") %></th> 
						<th onClick="sortBy(this)" db_col="denterunitdate" class="<%=domainSearchCondition.getSortClassByDbColumn("denterunitdate")%>"><%=domainInstance.getPropertyCnName("denterunitdate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnproperty" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnproperty")%>"><%=domainInstance.getPropertyCnName("cpsnproperty") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnbankcode" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnbankcode")%>"><%=domainInstance.getPropertyCnName("cpsnbankcode") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnaccount" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnaccount")%>"><%=domainInstance.getPropertyCnName("cpsnaccount") %></th> 
						<th onClick="sortBy(this)" db_col="pk_hr_hi_person" class="<%=domainSearchCondition.getSortClassByDbColumn("pk_hr_hi_person")%>"><%=domainInstance.getPropertyCnName("pk_hr_hi_person") %></th> 
						<th onClick="sortBy(this)" db_col="bprobation" class="<%=domainSearchCondition.getSortClassByDbColumn("bprobation")%>"><%=domainInstance.getPropertyCnName("bprobation") %></th> 
						<th onClick="sortBy(this)" db_col="cdutyclass" class="<%=domainSearchCondition.getSortClassByDbColumn("cdutyclass")%>"><%=domainInstance.getPropertyCnName("cdutyclass") %></th> 
						<th onClick="sortBy(this)" db_col="btaketm" class="<%=domainSearchCondition.getSortClassByDbColumn("btaketm")%>"><%=domainInstance.getPropertyCnName("btaketm") %></th> 
						<th onClick="sortBy(this)" db_col="mpictureqpb" class="<%=domainSearchCondition.getSortClassByDbColumn("mpictureqpb")%>"><%=domainInstance.getPropertyCnName("mpictureqpb") %></th> 
						<th onClick="sortBy(this)" db_col="ridtype" class="<%=domainSearchCondition.getSortClassByDbColumn("ridtype")%>"><%=domainInstance.getPropertyCnName("ridtype") %></th> 
						<th onClick="sortBy(this)" db_col="rcountry" class="<%=domainSearchCondition.getSortClassByDbColumn("rcountry")%>"><%=domainInstance.getPropertyCnName("rcountry") %></th> 
						<th onClick="sortBy(this)" db_col="dleavedate" class="<%=domainSearchCondition.getSortClassByDbColumn("dleavedate")%>"><%=domainInstance.getPropertyCnName("dleavedate") %></th> 
						<th onClick="sortBy(this)" db_col="rfigure" class="<%=domainSearchCondition.getSortClassByDbColumn("rfigure")%>"><%=domainInstance.getPropertyCnName("rfigure") %></th> 
						<th onClick="sortBy(this)" db_col="rworkstatus" class="<%=domainSearchCondition.getSortClassByDbColumn("rworkstatus")%>"><%=domainInstance.getPropertyCnName("rworkstatus") %></th> 
						<th onClick="sortBy(this)" db_col="employmentform" class="<%=domainSearchCondition.getSortClassByDbColumn("employmentform")%>"><%=domainInstance.getPropertyCnName("employmentform") %></th> 
						<th onClick="sortBy(this)" db_col="rpersonparameters" class="<%=domainSearchCondition.getSortClassByDbColumn("rpersonparameters")%>"><%=domainInstance.getPropertyCnName("rpersonparameters") %></th> 
						<th onClick="sortBy(this)" db_col="bdutylock" class="<%=domainSearchCondition.getSortClassByDbColumn("bdutylock")%>"><%=domainInstance.getPropertyCnName("bdutylock") %></th> 
						<th onClick="sortBy(this)" db_col="bpsnshop" class="<%=domainSearchCondition.getSortClassByDbColumn("bpsnshop")%>"><%=domainInstance.getPropertyCnName("bpsnshop") %></th> 
						<th onClick="sortBy(this)" db_col="cardstate" class="<%=domainSearchCondition.getSortClassByDbColumn("cardstate")%>"><%=domainInstance.getPropertyCnName("cardstate") %></th> 
						<th onClick="sortBy(this)" db_col="firsthtbegindate" class="<%=domainSearchCondition.getSortClassByDbColumn("firsthtbegindate")%>"><%=domainInstance.getPropertyCnName("firsthtbegindate") %></th> 
						<th onClick="sortBy(this)" db_col="lasthtenddate" class="<%=domainSearchCondition.getSortClassByDbColumn("lasthtenddate")%>"><%=domainInstance.getPropertyCnName("lasthtenddate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsn_nameen" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsn_nameen")%>"><%=domainInstance.getPropertyCnName("cpsn_nameen") %></th> 
						<th onClick="sortBy(this)" db_col="sysage" class="<%=domainSearchCondition.getSortClassByDbColumn("sysage")%>"><%=domainInstance.getPropertyCnName("sysage") %></th> 
						<th onClick="sortBy(this)" db_col="syscompage" class="<%=domainSearchCondition.getSortClassByDbColumn("syscompage")%>"><%=domainInstance.getPropertyCnName("syscompage") %></th> 
						<th onClick="sortBy(this)" db_col="sysworkage" class="<%=domainSearchCondition.getSortClassByDbColumn("sysworkage")%>"><%=domainInstance.getPropertyCnName("sysworkage") %></th> 
						<th onClick="sortBy(this)" db_col="cregion" class="<%=domainSearchCondition.getSortClassByDbColumn("cregion")%>"><%=domainInstance.getPropertyCnName("cregion") %></th> 
						<th onClick="sortBy(this)" db_col="natruetype" class="<%=domainSearchCondition.getSortClassByDbColumn("natruetype")%>"><%=domainInstance.getPropertyCnName("natruetype") %></th> 
						<th onClick="sortBy(this)" db_col="jobnumber" class="<%=domainSearchCondition.getSortClassByDbColumn("jobnumber")%>"><%=domainInstance.getPropertyCnName("jobnumber") %></th> 
						<th onClick="sortBy(this)" db_col="persondepart" class="<%=domainSearchCondition.getSortClassByDbColumn("persondepart")%>"><%=domainInstance.getPropertyCnName("persondepart") %></th> 
						<th onClick="sortBy(this)" db_col="cardeffectivebegintime" class="<%=domainSearchCondition.getSortClassByDbColumn("cardeffectivebegintime")%>"><%=domainInstance.getPropertyCnName("cardeffectivebegintime") %></th> 
						<th onClick="sortBy(this)" db_col="cardeffectiveendtime" class="<%=domainSearchCondition.getSortClassByDbColumn("cardeffectiveendtime")%>"><%=domainInstance.getPropertyCnName("cardeffectiveendtime") %></th> 
						<th onClick="sortBy(this)" db_col="keyperson" class="<%=domainSearchCondition.getSortClassByDbColumn("keyperson")%>"><%=domainInstance.getPropertyCnName("keyperson") %></th> 
						<th onClick="sortBy(this)" db_col="cleavereson" class="<%=domainSearchCondition.getSortClassByDbColumn("cleavereson")%>"><%=domainInstance.getPropertyCnName("cleavereson") %></th> 
						<th onClick="sortBy(this)" db_col="shenfen" class="<%=domainSearchCondition.getSortClassByDbColumn("shenfen")%>"><%=domainInstance.getPropertyCnName("shenfen") %></th> 
						<th onClick="sortBy(this)" db_col="weishengjishu" class="<%=domainSearchCondition.getSortClassByDbColumn("weishengjishu")%>"><%=domainInstance.getPropertyCnName("weishengjishu") %></th> 
						<th onClick="sortBy(this)" db_col="gonglingqisuan" class="<%=domainSearchCondition.getSortClassByDbColumn("gonglingqisuan")%>"><%=domainInstance.getPropertyCnName("gonglingqisuan") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnppt" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnppt")%>"><%=domainInstance.getPropertyCnName("cpsnppt") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnjoblevel" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnjoblevel")%>"><%=domainInstance.getPropertyCnName("cpsnjoblevel") %></th> 
						<th onClick="sortBy(this)" db_col="cpsncom" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsncom")%>"><%=domainInstance.getPropertyCnName("cpsncom") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopred" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopred")%>"><%=domainInstance.getPropertyCnName("cpsntopred") %></th> 
						<th onClick="sortBy(this)" db_col="cpsncollege" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsncollege")%>"><%=domainInstance.getPropertyCnName("cpsncollege") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopdegree" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopdegree")%>"><%=domainInstance.getPropertyCnName("cpsntopdegree") %></th> 
						<th onClick="sortBy(this)" db_col="cpsncoll2" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsncoll2")%>"><%=domainInstance.getPropertyCnName("cpsncoll2") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnincumred" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnincumred")%>"><%=domainInstance.getPropertyCnName("cpsnincumred") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnincumcoll" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnincumcoll")%>"><%=domainInstance.getPropertyCnName("cpsnincumcoll") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnjoblvldate" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnjoblvldate")%>"><%=domainInstance.getPropertyCnName("cpsnjoblvldate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopredft" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopredft")%>"><%=domainInstance.getPropertyCnName("cpsntopredft") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopdegreeft" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopdegreeft")%>"><%=domainInstance.getPropertyCnName("cpsntopdegreeft") %></th> 
						<th onClick="sortBy(this)" db_col="cpsncoll4" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsncoll4")%>"><%=domainInstance.getPropertyCnName("cpsncoll4") %></th> 
						<th onClick="sortBy(this)" db_col="cpsncoll3" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsncoll3")%>"><%=domainInstance.getPropertyCnName("cpsncoll3") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndegreeft" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndegreeft")%>"><%=domainInstance.getPropertyCnName("cpsndegreeft") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnredft" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnredft")%>"><%=domainInstance.getPropertyCnName("cpsnredft") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnincred" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnincred")%>"><%=domainInstance.getPropertyCnName("cpsnincred") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnincdegree" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnincdegree")%>"><%=domainInstance.getPropertyCnName("cpsnincdegree") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopredcode" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopredcode")%>"><%=domainInstance.getPropertyCnName("cpsntopredcode") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopdegcode" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopdegcode")%>"><%=domainInstance.getPropertyCnName("cpsntopdegcode") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndut" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndut")%>"><%=domainInstance.getPropertyCnName("cpsndut") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndutdate" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndutdate")%>"><%=domainInstance.getPropertyCnName("cpsndutdate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnjoblvldate2" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnjoblvldate2")%>"><%=domainInstance.getPropertyCnName("cpsnjoblvldate2") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnparty" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnparty")%>"><%=domainInstance.getPropertyCnName("cpsnparty") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnrdate" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnrdate")%>"><%=domainInstance.getPropertyCnName("cpsnrdate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnpartysec" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnpartysec")%>"><%=domainInstance.getPropertyCnName("cpsnpartysec") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnpartythd" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnpartythd")%>"><%=domainInstance.getPropertyCnName("cpsnpartythd") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndutname" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndutname")%>"><%=domainInstance.getPropertyCnName("cpsndutname") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndegreedate" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndegreedate")%>"><%=domainInstance.getPropertyCnName("cpsndegreedate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndutdate2" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndutdate2")%>"><%=domainInstance.getPropertyCnName("cpsndutdate2") %></th> 
						<th onClick="sortBy(this)" db_col="cpsndate" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsndate")%>"><%=domainInstance.getPropertyCnName("cpsndate") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnyear" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnyear")%>"><%=domainInstance.getPropertyCnName("cpsnyear") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnlvl" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnlvl")%>"><%=domainInstance.getPropertyCnName("cpsnlvl") %></th> 
						<th onClick="sortBy(this)" db_col="cpsntopredd" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsntopredd")%>"><%=domainInstance.getPropertyCnName("cpsntopredd") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzyzt" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzyzt")%>"><%=domainInstance.getPropertyCnName("cpsnzyzt") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzbzsbm" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzbzsbm")%>"><%=domainInstance.getPropertyCnName("cpsnzbzsbm") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzyzbbm" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzyzbbm")%>"><%=domainInstance.getPropertyCnName("cpsnzyzbbm") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnysjb" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnysjb")%>"><%=domainInstance.getPropertyCnName("cpsnysjb") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzylb" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzylb")%>"><%=domainInstance.getPropertyCnName("cpsnzylb") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnzykm" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnzykm")%>"><%=domainInstance.getPropertyCnName("cpsnzykm") %></th> 
						<th onClick="sortBy(this)" db_col="cpsnpzdate" class="<%=domainSearchCondition.getSortClassByDbColumn("cpsnpzdate")%>"><%=domainInstance.getPropertyCnName("cpsnpzdate") %></th> 
					</tr> 
				</thead> 
				<% 
					for (int i = 0; i < list.size(); i++) 
						{ 
							HrHiPersonObj4Show o = (HrHiPersonObj4Show) list.get(i); 
				%> 
				<tr onclick='confirmSelect(this)' value='<%=o.toString() %>'> 
					<td style="width:30px;text-align:right"><%=i+1 %></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsn_name())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("department",o.getCdept_num()+"",false)%></td>  
					<td style="text-align:right"><%=StringUtil.getNotEmptyStr(o.getIrecordid())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT000",o.getRpersontype()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT001",o.getRsex()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getDbirthdate())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT007",o.getRnativeplace()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT005",o.getRnational()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT008",o.getRhealthstatus()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT009",o.getRmarristatus()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getVidno())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getMpicture())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT007",o.getRperresidence()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getValianame())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getDjoinworkdate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getDenterdate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getDregulardate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getVssno())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getRworkattend())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getVcardno())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("hr_tm_Rule",o.getRtbmrule()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT059",o.getRcheckinflag()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getDlastdate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getHrts())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getVstatus1())%></td> 
					<td style="text-align:right"><%=StringUtil.getNotEmptyStr(o.getNstatus2())%></td> 
					<td><%="true".equalsIgnoreCase(o.getBpsnperson()+"")?"是":"否"%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnmobilephone())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnfphone())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnophone())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsninphone())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnemail())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnpostaddr())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnpostcode())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnfaddr())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnqqcode())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnurl())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnoseat())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getDenterunitdate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnproperty())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("aa_bank",o.getCpsnbankcode()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnaccount())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getPk_hr_hi_person())%></td> 
					<td><%="true".equalsIgnoreCase(o.getBprobation()+"")?"是":"否"%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("hr_tm_DutyClass",o.getCdutyclass()+"",false)%></td>  
					<td><%="true".equalsIgnoreCase(o.getBtaketm()+"")?"是":"否"%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getMpictureqpb())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("hr_CT156",o.getRidtype()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getRcountry())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getDleavedate())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT157",o.getRfigure()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT158",o.getRworkstatus()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT803",o.getEmploymentform()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("hr_tm_PersonParameters",o.getRpersonparameters()+"",false)%></td>  
					<td><%="true".equalsIgnoreCase(o.getBdutylock()+"")?"是":"否"%></td> 
					<td><%="true".equalsIgnoreCase(o.getBpsnshop()+"")?"是":"否"%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT322",o.getCardstate()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getFirsthtbegindate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getLasthtenddate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsn_nameen())%></td> 
					<td style="text-align:right"><%=StringUtil.formatDouble(o.getSysage(),2)%></td> 
					<td style="text-align:right"><%=StringUtil.formatDouble(o.getSyscompage(),2)%></td> 
					<td style="text-align:right"><%=StringUtil.formatDouble(o.getSysworkage(),2)%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT270",o.getCregion()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("hr_ct010",o.getNatruetype()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getJobnumber())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getPersondepart())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCardeffectivebegintime())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCardeffectiveendtime())%></td> 
					<td><%="true".equalsIgnoreCase(o.getKeyperson()+"")?"是":"否"%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("hr_ct011",o.getCleavereson()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT1000",o.getShenfen()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT777",o.getWeishengjishu()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getGonglingqisuan())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT998",o.getCpsnppt()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT997",o.getCpsnjoblevel()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsncom())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsntopred())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsncollege())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsntopdegree())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsncoll2())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnincumred())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnincumcoll())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnjoblvldate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsntopredft())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsntopdegreeft())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsncoll4())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsncoll3())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsndegreeft())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnredft())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnincred())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnincdegree())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsntopredcode())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsntopdegcode())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsndut())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsndutdate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnjoblvldate2())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT119",o.getCpsnparty()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnrdate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnpartysec())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnpartythd())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT995",o.getCpsndutname()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsndegreedate())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsndutdate2())%></td> 
					<td style="text-align:right"><%=StringUtil.getNotEmptyStr(o.getCpsndate())%></td> 
					<td style="text-align:right"><%=StringUtil.getNotEmptyStr(o.getCpsnyear())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT121",o.getCpsnlvl()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT002",o.getCpsntopredd()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT994",o.getCpsnzyzt()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnzbzsbm())%></td> 
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnzyzbbm())%></td> 
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT987",o.getCpsnysjb()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT993",o.getCpsnzylb()+"",false)%></td>  
					<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT888",o.getCpsnzykm()+"",false)%></td>  
					<td><%=StringUtil.getNotEmptyStr(o.getCpsnpzdate())%></td> 
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
