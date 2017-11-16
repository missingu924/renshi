<!DOCTYPE html> 
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%> 
<!-- 引入类 -->  
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="com.wuyg.common.util.StringUtil"%> 
<%@page import="com.wuyg.common.util.TimeUtil"%> 
<%@page import="com.wuyg.dictionary.DictionaryUtil"%> 
<%@page import="com.u8.obj.HrHiPersonObj4Show"%> 
<%@page import="com.wuyg.auth.obj.AuthUserObj"%> 
<%@page import="com.wuyg.common.util.SystemConstant"%>  
<!-- 基本信息 -->  
<% 
	// 上下文路径 
	String contextPath = request.getContextPath(); 
	 
	// 对象实例 
	HrHiPersonObj4Show domainInstance = new HrHiPersonObj4Show(); 
	// 用户信息 
	AuthUserObj user = (AuthUserObj) request.getSession().getAttribute(SystemConstant.AUTH_USER_INFO); 
	// 该功能基本路径 
	String basePath = domainInstance.getBasePath(); 
 
	// 如果是修改，则获取对象信息 
	Object domainInstanceObj = request.getAttribute("domainInstance"); 
	if (domainInstanceObj != null) 
	{ 
		domainInstance = (HrHiPersonObj4Show) domainInstanceObj; 
	} 
 
	// 是否是修改 
	boolean isModify = domainInstance.findKeyValue() > 0; 
 
	// 不能为空的字段 
	List<String> notNullProperties = domainInstance.findNotNullProperties(); 
 
	// 唯一索引字段 
	List<String> uniqueProperties = domainInstance.findUniqueIndexProperties(); 
%> 
<html> 
	<head> 
		<base target="_self" /> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no" />		<title><%=isModify ? "修改" + domainInstance.getCnName() : "增加" + domainInstance.getCnName()%></title> 
		<link href="../css/global.css" rel="stylesheet" type="text/css"> 
		<script type="text/javascript" src="../js/jquery-2.0.3.min.js"></script> 
		<script type="text/javascript" src="../js/utils.js"></script> 
		<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script> 
		<script type="text/javascript" src="../js/autosize.min.js"></script> 
		<script type="text/javascript">$(document).ready(function () {autosize($('textarea'));})</script> 
		<script> 
		//  新增或修改 
		function addOrModify() 
		{	 
			// 做必要的检查 
			<% 
			for(int i=0;i<notNullProperties.size();i++) 
			{ 
				String property=notNullProperties.get(i); 
				out.println("if(!checkNull('"+property+"','"+domainInstance.getPropertyCnName(property)+"')) return false;"); 
			} 
			%> 
					 
			// 修改 
			if("true"=="<%=isModify%>") 
			{ 
				addOrModirySubmit(); 
			} 
			// 新增 
			else 
			{ 
				// 新增时检查唯一性 
				checkUniqueAndSave('<%=basePath%>');
			} 
		} 
		 
		</script> 
	</head> 
	<body> 
		<form name="addOrModifyForm" id="addOrModifyForm" action="<%=contextPath%>/Proxy/Servlet?servlet=<%=basePath%>&method=addOrModify4this" method="post"> 
			<!-- 表格标题 --> 
			<table width="700" align="center" class="title_table"> 
				<tr> 
					<td> 
						<%=isModify ? "修改" : "增加"%><%=domainInstance.getCnName()%> 
					</td> 
				</tr> 
			</table> 
 
			<!-- 详细信息 --> 
			<table width="700" align="center" class="detail_table detail_table-bordered"> 
				<input type="hidden" id="<%=domainInstance.findKeyColumnName()%>" name="<%=domainInstance.findKeyColumnName()%>" value="<%=domainInstance.findKeyValue()%>"> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsn_name") %>: 
					</td> 
					<td> 
						<input name="cpsn_name" type="text" id="cpsn_name" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_name(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cdept_num") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("department", "cdept_num", StringUtil.getNotEmptyStr(domainInstance.getCdept_num(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("irecordid") %>: 
					</td> 
					<td> 
						<input name="irecordid" type="text" id="irecordid" value="<%=StringUtil.getNotEmptyStr(domainInstance.getIrecordid(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rpersontype") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT000", "rpersontype", StringUtil.getNotEmptyStr(domainInstance.getRpersontype(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rsex") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT001", "rsex", StringUtil.getNotEmptyStr(domainInstance.getRsex(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("dbirthdate") %>: 
					</td> 
					<td> 
						<input name="dbirthdate" type="text" id="dbirthdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDbirthdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rnativeplace") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT007", "rnativeplace", StringUtil.getNotEmptyStr(domainInstance.getRnativeplace(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rnational") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT005", "rnational", StringUtil.getNotEmptyStr(domainInstance.getRnational(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rhealthstatus") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT008", "rhealthstatus", StringUtil.getNotEmptyStr(domainInstance.getRhealthstatus(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rmarristatus") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT009", "rmarristatus", StringUtil.getNotEmptyStr(domainInstance.getRmarristatus(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("vidno") %>: 
					</td> 
					<td> 
						<input name="vidno" type="text" id="vidno" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVidno(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("mpicture") %>: 
					</td> 
					<td> 
						<input name="mpicture" type="text" id="mpicture" value="<%=StringUtil.getNotEmptyStr(domainInstance.getMpicture(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rperresidence") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT007", "rperresidence", StringUtil.getNotEmptyStr(domainInstance.getRperresidence(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("valianame") %>: 
					</td> 
					<td> 
						<input name="valianame" type="text" id="valianame" value="<%=StringUtil.getNotEmptyStr(domainInstance.getValianame(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("djoinworkdate") %>: 
					</td> 
					<td> 
						<input name="djoinworkdate" type="text" id="djoinworkdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDjoinworkdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("denterdate") %>: 
					</td> 
					<td> 
						<input name="denterdate" type="text" id="denterdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDenterdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("dregulardate") %>: 
					</td> 
					<td> 
						<input name="dregulardate" type="text" id="dregulardate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDregulardate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("vssno") %>: 
					</td> 
					<td> 
						<input name="vssno" type="text" id="vssno" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVssno(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rworkattend") %>: 
					</td> 
					<td> 
						<input name="rworkattend" type="text" id="rworkattend" value="<%=StringUtil.getNotEmptyStr(domainInstance.getRworkattend(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("vcardno") %>: 
					</td> 
					<td> 
						<input name="vcardno" type="text" id="vcardno" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVcardno(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rtbmrule") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("hr_tm_Rule", "rtbmrule", StringUtil.getNotEmptyStr(domainInstance.getRtbmrule(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rcheckinflag") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT059", "rcheckinflag", StringUtil.getNotEmptyStr(domainInstance.getRcheckinflag(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("dlastdate") %>: 
					</td> 
					<td> 
						<input name="dlastdate" type="text" id="dlastdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDlastdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("hrts") %>: 
					</td> 
					<td> 
						<input name="hrts" type="text" id="hrts" value="<%=StringUtil.getNotEmptyStr(domainInstance.getHrts(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("vstatus1") %>: 
					</td> 
					<td> 
						<input name="vstatus1" type="text" id="vstatus1" value="<%=StringUtil.getNotEmptyStr(domainInstance.getVstatus1(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("nstatus2") %>: 
					</td> 
					<td> 
						<input name="nstatus2" type="text" id="nstatus2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getNstatus2(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("bpsnperson") %>: 
					</td> 
					<td> 
						<input name="bpsnperson" type="text" id="bpsnperson" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBpsnperson(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnmobilephone") %>: 
					</td> 
					<td> 
						<input name="cpsnmobilephone" type="text" id="cpsnmobilephone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnmobilephone(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnfphone") %>: 
					</td> 
					<td> 
						<input name="cpsnfphone" type="text" id="cpsnfphone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfphone(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnophone") %>: 
					</td> 
					<td> 
						<input name="cpsnophone" type="text" id="cpsnophone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnophone(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsninphone") %>: 
					</td> 
					<td> 
						<input name="cpsninphone" type="text" id="cpsninphone" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsninphone(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnemail") %>: 
					</td> 
					<td> 
						<input name="cpsnemail" type="text" id="cpsnemail" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnemail(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnpostaddr") %>: 
					</td> 
					<td> 
						<input name="cpsnpostaddr" type="text" id="cpsnpostaddr" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpostaddr(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnpostcode") %>: 
					</td> 
					<td> 
						<input name="cpsnpostcode" type="text" id="cpsnpostcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpostcode(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnfaddr") %>: 
					</td> 
					<td> 
						<input name="cpsnfaddr" type="text" id="cpsnfaddr" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfaddr(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnqqcode") %>: 
					</td> 
					<td> 
						<input name="cpsnqqcode" type="text" id="cpsnqqcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnqqcode(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnurl") %>: 
					</td> 
					<td> 
						<input name="cpsnurl" type="text" id="cpsnurl" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnurl(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnoseat") %>: 
					</td> 
					<td> 
						<input name="cpsnoseat" type="text" id="cpsnoseat" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnoseat(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("denterunitdate") %>: 
					</td> 
					<td> 
						<input name="denterunitdate" type="text" id="denterunitdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDenterunitdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnproperty") %>: 
					</td> 
					<td> 
						<input name="cpsnproperty" type="text" id="cpsnproperty" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnproperty(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnbankcode") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("aa_bank", "cpsnbankcode", StringUtil.getNotEmptyStr(domainInstance.getCpsnbankcode(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnaccount") %>: 
					</td> 
					<td> 
						<input name="cpsnaccount" type="text" id="cpsnaccount" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnaccount(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("pk_hr_hi_person") %>: 
					</td> 
					<td> 
						<input name="pk_hr_hi_person" type="text" id="pk_hr_hi_person" value="<%=StringUtil.getNotEmptyStr(domainInstance.getPk_hr_hi_person(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("bprobation") %>: 
					</td> 
					<td> 
						<input name="bprobation" type="text" id="bprobation" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBprobation(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cdutyclass") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("hr_tm_DutyClass", "cdutyclass", StringUtil.getNotEmptyStr(domainInstance.getCdutyclass(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("btaketm") %>: 
					</td> 
					<td> 
						<input name="btaketm" type="text" id="btaketm" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBtaketm(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("mpictureqpb") %>: 
					</td> 
					<td> 
						<input name="mpictureqpb" type="text" id="mpictureqpb" value="<%=StringUtil.getNotEmptyStr(domainInstance.getMpictureqpb(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("ridtype") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("hr_CT156", "ridtype", StringUtil.getNotEmptyStr(domainInstance.getRidtype(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rcountry") %>: 
					</td> 
					<td> 
						<input name="rcountry" type="text" id="rcountry" value="<%=StringUtil.getNotEmptyStr(domainInstance.getRcountry(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("dleavedate") %>: 
					</td> 
					<td> 
						<input name="dleavedate" type="text" id="dleavedate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getDleavedate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rfigure") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT157", "rfigure", StringUtil.getNotEmptyStr(domainInstance.getRfigure(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rworkstatus") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT158", "rworkstatus", StringUtil.getNotEmptyStr(domainInstance.getRworkstatus(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("employmentform") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT803", "employmentform", StringUtil.getNotEmptyStr(domainInstance.getEmploymentform(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("rpersonparameters") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("hr_tm_PersonParameters", "rpersonparameters", StringUtil.getNotEmptyStr(domainInstance.getRpersonparameters(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("bdutylock") %>: 
					</td> 
					<td> 
						<input name="bdutylock" type="text" id="bdutylock" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBdutylock(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("bpsnshop") %>: 
					</td> 
					<td> 
						<input name="bpsnshop" type="text" id="bpsnshop" value="<%=StringUtil.getNotEmptyStr(domainInstance.getBpsnshop(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cardstate") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT322", "cardstate", StringUtil.getNotEmptyStr(domainInstance.getCardstate(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("firsthtbegindate") %>: 
					</td> 
					<td> 
						<input name="firsthtbegindate" type="text" id="firsthtbegindate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getFirsthtbegindate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("lasthtenddate") %>: 
					</td> 
					<td> 
						<input name="lasthtenddate" type="text" id="lasthtenddate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getLasthtenddate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsn_nameen") %>: 
					</td> 
					<td> 
						<input name="cpsn_nameen" type="text" id="cpsn_nameen" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_nameen(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("sysage") %>: 
					</td> 
					<td> 
						<input name="sysage" type="text" id="sysage" value="<%=StringUtil.formatDouble(domainInstance.getSysage(),2)%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("syscompage") %>: 
					</td> 
					<td> 
						<input name="syscompage" type="text" id="syscompage" value="<%=StringUtil.formatDouble(domainInstance.getSyscompage(),2)%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("sysworkage") %>: 
					</td> 
					<td> 
						<input name="sysworkage" type="text" id="sysworkage" value="<%=StringUtil.formatDouble(domainInstance.getSysworkage(),2)%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cregion") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT270", "cregion", StringUtil.getNotEmptyStr(domainInstance.getCregion(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("natruetype") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("hr_ct010", "natruetype", StringUtil.getNotEmptyStr(domainInstance.getNatruetype(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("jobnumber") %>: 
					</td> 
					<td> 
						<input name="jobnumber" type="text" id="jobnumber" value="<%=StringUtil.getNotEmptyStr(domainInstance.getJobnumber(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("persondepart") %>: 
					</td> 
					<td> 
						<input name="persondepart" type="text" id="persondepart" value="<%=StringUtil.getNotEmptyStr(domainInstance.getPersondepart(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cardeffectivebegintime") %>: 
					</td> 
					<td> 
						<input name="cardeffectivebegintime" type="text" id="cardeffectivebegintime" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCardeffectivebegintime(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cardeffectiveendtime") %>: 
					</td> 
					<td> 
						<input name="cardeffectiveendtime" type="text" id="cardeffectiveendtime" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCardeffectiveendtime(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("keyperson") %>: 
					</td> 
					<td> 
						<input name="keyperson" type="text" id="keyperson" value="<%=StringUtil.getNotEmptyStr(domainInstance.getKeyperson(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cleavereson") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("hr_ct011", "cleavereson", StringUtil.getNotEmptyStr(domainInstance.getCleavereson(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("shenfen") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT1000", "shenfen", StringUtil.getNotEmptyStr(domainInstance.getShenfen(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("weishengjishu") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT777", "weishengjishu", StringUtil.getNotEmptyStr(domainInstance.getWeishengjishu(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("gonglingqisuan") %>: 
					</td> 
					<td> 
						<input name="gonglingqisuan" type="text" id="gonglingqisuan" value="<%=StringUtil.getNotEmptyStr(domainInstance.getGonglingqisuan(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnppt") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT998", "cpsnppt", StringUtil.getNotEmptyStr(domainInstance.getCpsnppt(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnjoblevel") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT997", "cpsnjoblevel", StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblevel(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsncom") %>: 
					</td> 
					<td> 
						<input name="cpsncom" type="text" id="cpsncom" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncom(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopred") %>: 
					</td> 
					<td> 
						<input name="cpsntopred" type="text" id="cpsntopred" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopred(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsncollege") %>: 
					</td> 
					<td> 
						<input name="cpsncollege" type="text" id="cpsncollege" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncollege(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopdegree") %>: 
					</td> 
					<td> 
						<input name="cpsntopdegree" type="text" id="cpsntopdegree" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegree(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsncoll2") %>: 
					</td> 
					<td> 
						<input name="cpsncoll2" type="text" id="cpsncoll2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll2(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnincumred") %>: 
					</td> 
					<td> 
						<input name="cpsnincumred" type="text" id="cpsnincumred" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumred(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnincumcoll") %>: 
					</td> 
					<td> 
						<input name="cpsnincumcoll" type="text" id="cpsnincumcoll" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumcoll(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnjoblvldate") %>: 
					</td> 
					<td> 
						<input name="cpsnjoblvldate" type="text" id="cpsnjoblvldate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblvldate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopredft") %>: 
					</td> 
					<td> 
						<input name="cpsntopredft" type="text" id="cpsntopredft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredft(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopdegreeft") %>: 
					</td> 
					<td> 
						<input name="cpsntopdegreeft" type="text" id="cpsntopdegreeft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegreeft(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsncoll4") %>: 
					</td> 
					<td> 
						<input name="cpsncoll4" type="text" id="cpsncoll4" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll4(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsncoll3") %>: 
					</td> 
					<td> 
						<input name="cpsncoll3" type="text" id="cpsncoll3" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll3(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndegreeft") %>: 
					</td> 
					<td> 
						<input name="cpsndegreeft" type="text" id="cpsndegreeft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreeft(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnredft") %>: 
					</td> 
					<td> 
						<input name="cpsnredft" type="text" id="cpsnredft" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnredft(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnincred") %>: 
					</td> 
					<td> 
						<input name="cpsnincred" type="text" id="cpsnincred" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincred(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnincdegree") %>: 
					</td> 
					<td> 
						<input name="cpsnincdegree" type="text" id="cpsnincdegree" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincdegree(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopredcode") %>: 
					</td> 
					<td> 
						<input name="cpsntopredcode" type="text" id="cpsntopredcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredcode(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopdegcode") %>: 
					</td> 
					<td> 
						<input name="cpsntopdegcode" type="text" id="cpsntopdegcode" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegcode(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndut") %>: 
					</td> 
					<td> 
						<input name="cpsndut" type="text" id="cpsndut" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndut(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndutdate") %>: 
					</td> 
					<td> 
						<input name="cpsndutdate" type="text" id="cpsndutdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnjoblvldate2") %>: 
					</td> 
					<td> 
						<input name="cpsnjoblvldate2" type="text" id="cpsnjoblvldate2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblvldate2(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnparty") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT119", "cpsnparty", StringUtil.getNotEmptyStr(domainInstance.getCpsnparty(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnrdate") %>: 
					</td> 
					<td> 
						<input name="cpsnrdate" type="text" id="cpsnrdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnrdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnpartysec") %>: 
					</td> 
					<td> 
						<input name="cpsnpartysec" type="text" id="cpsnpartysec" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpartysec(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnpartythd") %>: 
					</td> 
					<td> 
						<input name="cpsnpartythd" type="text" id="cpsnpartythd" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpartythd(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndutname") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT995", "cpsndutname", StringUtil.getNotEmptyStr(domainInstance.getCpsndutname(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndegreedate") %>: 
					</td> 
					<td> 
						<input name="cpsndegreedate" type="text" id="cpsndegreedate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreedate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndutdate2") %>: 
					</td> 
					<td> 
						<input name="cpsndutdate2" type="text" id="cpsndutdate2" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate2(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsndate") %>: 
					</td> 
					<td> 
						<input name="cpsndate" type="text" id="cpsndate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndate(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnyear") %>: 
					</td> 
					<td> 
						<input name="cpsnyear" type="text" id="cpsnyear" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnyear(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnlvl") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT121", "cpsnlvl", StringUtil.getNotEmptyStr(domainInstance.getCpsnlvl(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsntopredd") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT002", "cpsntopredd", StringUtil.getNotEmptyStr(domainInstance.getCpsntopredd(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnzyzt") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT994", "cpsnzyzt", StringUtil.getNotEmptyStr(domainInstance.getCpsnzyzt(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnzbzsbm") %>: 
					</td> 
					<td> 
						<input name="cpsnzbzsbm" type="text" id="cpsnzbzsbm" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzbzsbm(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnzyzbbm") %>: 
					</td> 
					<td> 
						<input name="cpsnzyzbbm" type="text" id="cpsnzyzbbm" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzyzbbm(),"")%>" size="20"  > 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnysjb") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT987", "cpsnysjb", StringUtil.getNotEmptyStr(domainInstance.getCpsnysjb(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnzylb") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT993", "cpsnzylb", StringUtil.getNotEmptyStr(domainInstance.getCpsnzylb(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnzykm") %>: 
					</td> 
					<td> 
						<%=DictionaryUtil.getInputHtml("HR_CT888", "cpsnzykm", StringUtil.getNotEmptyStr(domainInstance.getCpsnzykm(), ""),false)%> 
					</td> 
				</tr> 
				<tr> 
					<td> 
						<%=domainInstance.getPropertyCnName("cpsnpzdate") %>: 
					</td> 
					<td> 
						<input name="cpsnpzdate" type="text" id="cpsnpzdate" value="<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpzdate(),"")%>" size="20"  > 
					</td> 
				</tr> 
			</table> 
			 
			<!-- 工具栏 --> 
			<jsp:include page="../ToolBar/addOrModify_toolbar.jsp" /> 
		</form> 
		
		<!-- 设置修改时哪些字段不可修改 --> 
		<script type="text/javascript"> 
		if(true==<%=isModify%>)  
		{  
			<% 
			for(int i=0;i<uniqueProperties.size();i++) 
			{ 
				String property=uniqueProperties.get(i); 
				out.println("setReadonly('"+property+"');"); 
			} 
			%> 
		} else 
		{ 
			// 唯一索引字段  
			<%  
			for(int i=0;i<uniqueProperties.size();i++)  
			{  
				String property=uniqueProperties.get(i);  
				out.println("$('#"+property+"').after('&nbsp;<font color=\"red\">(不能重复)</font>');");  
			}  
			%>  
		}  
		 
		// 不能为空的字段 
		<% 
		for(int i=0;i<notNullProperties.size();i++) 
		{ 
			String property=notNullProperties.get(i); 
			out.println("$('#"+property+"').after('&nbsp;<font color=\"red\">*</font>');"); 
		} 
		%> 
		</script> 
	</body> 
</html> 
