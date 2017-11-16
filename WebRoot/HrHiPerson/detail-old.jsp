<!DOCTYPE html> 
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%> 
<!-- 引入类 -->  
<%@page import="java.util.List"%> 
<%@page import="com.wuyg.common.util.StringUtil"%> 
<%@page import="com.wuyg.common.util.TimeUtil"%> 
<%@page import="com.wuyg.dictionary.DictionaryUtil"%> 
<%@page import="com.u8.obj.HrHiPersonObj4Show"%> 
<%@page import="com.wuyg.auth.obj.AuthUserObj"%> 
<%@page import="com.wuyg.common.util.SystemConstant"%>  
<% 
	// 当前上下文路径  
	String contextPath = request.getContextPath();  
  
	// 该功能对象实例  
	HrHiPersonObj4Show domainInstance = (HrHiPersonObj4Show) request.getAttribute("domainInstance");  
	// 用户信息 
	AuthUserObj user = (AuthUserObj) request.getSession().getAttribute(SystemConstant.AUTH_USER_INFO); 
	// 该功能路径  
	String basePath = domainInstance.getBasePath();  
%> 
<html> 
	<head> 
		<base target="_self" /> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no" />
		<title><%=domainInstance.getCnName()%>详情</title> 
		<link href="../css/global.css" rel="stylesheet" type="text/css" /> 
		<script src="../js/jquery-2.0.3.min.js"></script> 
		<script src="../js/utils.js"></script> 
	</head> 
	<body> 
		<!-- 表格标题 --> 
		<table width="700" align="center" class="title_table"> 
			<tr> 
				<td> 
					<%=domainInstance.getCnName()%>信息 
				</td> 
			</tr> 
		</table> 
		<!-- 详细信息 --> 
		<table width="700" align="center" class="detail_table detail_table-bordered"> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsn_name") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_name())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cdept_num") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("department",domainInstance.getCdept_num()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("irecordid") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getIrecordid())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rpersontype") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT000",domainInstance.getRpersontype()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rsex") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT001",domainInstance.getRsex()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("dbirthdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDbirthdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rnativeplace") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT007",domainInstance.getRnativeplace()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rnational") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT005",domainInstance.getRnational()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rhealthstatus") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT008",domainInstance.getRhealthstatus()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rmarristatus") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT009",domainInstance.getRmarristatus()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("vidno") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getVidno())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("mpicture") %>: 
				</td> 
					<td>
						<img src="../picture/<%=domainInstance.findKeyValue()%>.jpg.min"/>
					</td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rperresidence") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT007",domainInstance.getRperresidence()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("valianame") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getValianame())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("djoinworkdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDjoinworkdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("denterdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDenterdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("dregulardate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDregulardate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("vssno") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getVssno())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rworkattend") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getRworkattend())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("vcardno") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getVcardno())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rtbmrule") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("hr_tm_Rule",domainInstance.getRtbmrule()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rcheckinflag") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT059",domainInstance.getRcheckinflag()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("dlastdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDlastdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("hrts") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getHrts())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("vstatus1") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getVstatus1())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("nstatus2") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getNstatus2())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("bpsnperson") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getBpsnperson())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnmobilephone") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnmobilephone())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnfphone") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfphone())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnophone") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnophone())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsninphone") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsninphone())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnemail") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnemail())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnpostaddr") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpostaddr())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnpostcode") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpostcode())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnfaddr") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfaddr())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnqqcode") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnqqcode())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnurl") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnurl())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnoseat") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnoseat())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("denterunitdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDenterunitdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnproperty") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnproperty())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnbankcode") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("aa_bank",domainInstance.getCpsnbankcode()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnaccount") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnaccount())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("pk_hr_hi_person") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getPk_hr_hi_person())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("bprobation") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getBprobation())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cdutyclass") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("hr_tm_DutyClass",domainInstance.getCdutyclass()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("btaketm") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getBtaketm())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("mpictureqpb") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getMpictureqpb())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("ridtype") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("hr_CT156",domainInstance.getRidtype()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rcountry") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getRcountry())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("dleavedate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getDleavedate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rfigure") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT157",domainInstance.getRfigure()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rworkstatus") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT158",domainInstance.getRworkstatus()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("employmentform") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT803",domainInstance.getEmploymentform()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("rpersonparameters") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("hr_tm_PersonParameters",domainInstance.getRpersonparameters()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("bdutylock") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getBdutylock())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("bpsnshop") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getBpsnshop())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cardstate") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT322",domainInstance.getCardstate()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("firsthtbegindate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getFirsthtbegindate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("lasthtenddate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getLasthtenddate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsn_nameen") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_nameen())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("sysage") %>: 
				</td> 
					<td><%=StringUtil.formatDouble(domainInstance.getSysage(),2)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("syscompage") %>: 
				</td> 
					<td><%=StringUtil.formatDouble(domainInstance.getSyscompage(),2)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("sysworkage") %>: 
				</td> 
					<td><%=StringUtil.formatDouble(domainInstance.getSysworkage(),2)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cregion") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT270",domainInstance.getCregion()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("natruetype") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("hr_ct010",domainInstance.getNatruetype()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("jobnumber") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getJobnumber())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("persondepart") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getPersondepart())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cardeffectivebegintime") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCardeffectivebegintime())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cardeffectiveendtime") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCardeffectiveendtime())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("keyperson") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getKeyperson())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cleavereson") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("hr_ct011",domainInstance.getCleavereson()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("shenfen") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT1000",domainInstance.getShenfen()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("weishengjishu") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT777",domainInstance.getWeishengjishu()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("gonglingqisuan") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getGonglingqisuan())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnppt") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT998",domainInstance.getCpsnppt()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnjoblevel") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT997",domainInstance.getCpsnjoblevel()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsncom") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncom())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopred") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopred())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsncollege") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncollege())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopdegree") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegree())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsncoll2") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll2())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnincumred") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumred())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnincumcoll") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumcoll())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnjoblvldate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblvldate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopredft") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredft())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopdegreeft") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegreeft())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsncoll4") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll4())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsncoll3") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll3())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndegreeft") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreeft())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnredft") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnredft())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnincred") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincred())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnincdegree") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincdegree())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopredcode") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredcode())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopdegcode") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegcode())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndut") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndut())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndutdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnjoblvldate2") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnjoblvldate2())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnparty") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT119",domainInstance.getCpsnparty()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnrdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnrdate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnpartysec") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpartysec())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnpartythd") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpartythd())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndutname") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT995",domainInstance.getCpsndutname()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndegreedate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreedate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndutdate2") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate2())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsndate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndate())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnyear") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnyear())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnlvl") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT121",domainInstance.getCpsnlvl()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsntopredd") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT002",domainInstance.getCpsntopredd()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnzyzt") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT994",domainInstance.getCpsnzyzt()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnzbzsbm") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzbzsbm())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnzyzbbm") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzyzbbm())%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnysjb") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT987",domainInstance.getCpsnysjb()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnzylb") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT993",domainInstance.getCpsnzylb()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnzykm") %>: 
				</td> 
				<td><%=DictionaryUtil.getDictValueByDictKey("HR_CT888",domainInstance.getCpsnzykm()+"",false)%></td> 
			</tr> 
			<tr> 
				<td> 
					<%=domainInstance.getPropertyCnName("cpsnpzdate") %>: 
				</td> 
					<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpzdate())%></td> 
			</tr> 
		</table> 
		 
		<!-- 工具栏 --> 
		<jsp:include page="../ToolBar/detail_toolbar.jsp"> 
			<jsp:param name="basePath" value="<%=domainInstance.getBasePath() %>"/> 
			<jsp:param name="keyColumnName" value="<%=domainInstance.findKeyColumnName() %>"/> 
			<jsp:param name="keyValue" value="<%=domainInstance.findKeyValue() %>"/> 
		</jsp:include> 
	</body> 
</html> 
