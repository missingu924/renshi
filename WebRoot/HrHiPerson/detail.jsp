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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no" />		<title><%=domainInstance.getCnName()%>详情</title> 
		<link href="../css/global.css" rel="stylesheet" type="text/css" /> 
		<link href="../css/table.css" rel="stylesheet" type="text/css" /> 
		<script src="../js/jquery-2.0.3.min.js"></script> 
		<script src="../js/utils.js"></script> 
	    <style type="text/css">
<!--
.big_black_bold_font {
font-size: 18px;
font-weight:bold;
color:#000000;
padding:6px;
}

.middle_black_bold_font {
font-size: 14px;
font-weight:bold;
color:#000000;
padding:6px;
}
.little_black_bold_font {
font-size: 12px;
font-weight:bold;
color:#000000;
padding:6px;
}

.little_black_font {
font-size: 12px;
color:#000000;
padding:6px;
}

.split_table {
  margin-top: 20px;
  max-width: 100%;
  /*background-color: #ffffff;*/
  border: 0;
}

.split_table td {
  padding: 8px;
  vertical-align: left;
  text-align: left;
  font-size: 14px;
  font-weight: bold;
  color: #2281c8;
  border-bottom: 1px solid #2281c8;
}

.list_table
{
	margin-top:8px;
	background-color:#FFFFFF;
}

.list_table td
{
	padding:8px;
	text-align: left;
	font-size:12px;
	background:#FFFFFF;
}

-->

        </style>
</head> 
	<body> 
		<!-- 表格标题 --> 
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="title_table"> 
			<tr bgcolor="#f9f9f9"> 
				<td>
					<div class="big_black_bold_font">
						<%=DictionaryUtil.getDictValueByDictKey("department",domainInstance.getCdept_num()+"",false)%>：
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsn_name())%></div>
					<div class="middle_black_bold_font">
						<%=DictionaryUtil.getDictValueByDictKey("HR_CT993",domainInstance.getCpsnzylb()+"",false)%>&nbsp;/&nbsp;
						<%=DictionaryUtil.getDictValueByDictKey("HR_CT888",domainInstance.getCpsnzykm()+"",false)%>&nbsp;/&nbsp;
						<%=DictionaryUtil.getDictValueByDictKey("HR_CT987",domainInstance.getCpsnysjb()+"",false)%>&nbsp;/&nbsp;
						<%=DictionaryUtil.getDictValueByDictKey("HR_CT995",domainInstance.getCpsndutname()+"",false)%>
					</div>
				</td> 
			</tr> 
		</table> 
		<!-- 详细信息 --> 
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:8px" > 
			<tr> 
				<td valign="top">
				
				<div class="little_black_bold_font">
					<%=DictionaryUtil.getDictValueByDictKey("HR_CT000",domainInstance.getRpersontype()+"",false)%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=DictionaryUtil.getDictValueByDictKey("HR_CT001",domainInstance.getRsex()+"",false)%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=DictionaryUtil.getDictValueByDictKey("HR_CT005",domainInstance.getRnational()+"",false)%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=StringUtil.getNotEmptyStr(StringUtil.formatDouble(domainInstance.getSysage(),0))%>岁(<%=StringUtil.getNotEmptyStr(domainInstance.getDbirthdate())%>)&nbsp;&nbsp;&nbsp;&nbsp;
					<%=DictionaryUtil.getDictValueByDictKey("HR_CT002",domainInstance.getCpsntopredd()+"",false)%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=DictionaryUtil.getDictValueByDictKey("HR_CT119",domainInstance.getCpsnparty()+"",false)%>
				</div>
				<br>
				<div class="little_black_font">
					<font color="#999999">手机：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnmobilephone(),"-")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">内线：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsninphone(),"-")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">工作电话：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnophone(),"-")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">家庭电话：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfphone(),"-")%>
				</div>
				<br>
				<div class="little_black_font">
					<font color="#999999">参加工作时间：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getDjoinworkdate(),"-")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">来院时间：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getDenterdate(),"-")%></div>
				<br>
				<div class="little_black_font">
					<font color="#999999">身份证：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getVidno(),"-")%>
				</div>
				<br>
				<div class="little_black_font">
					<font color="#999999">家庭住址：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnfaddr(),"-")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">籍贯：</font>
						<%=DictionaryUtil.getDictValueByDictKey("HR_CT007",domainInstance.getRnativeplace()+"",false)%></div>
				<br>
				<div class="little_black_font">
					<font color="#999999">用工形式：</font>
						<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT803",domainInstance.getEmploymentform()+"",false),"-")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">工龄：</font>
						<%=StringUtil.getNotEmptyStr(StringUtil.formatDouble(domainInstance.getSysworkage(),0) ,"-")%></div>
				</td> 
				<td align="right" class="big_black_font"><img src="../picture/<%=domainInstance.findKeyValue()%>.jpg.min"></td> 
			</tr> 
		</table> 
		
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="split_table">
          <tr bgcolor="#f9f9f9">
            <td><div class="">职务信息</div></td>
          </tr>
        </table>
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="list_table" >
			<tr>
				<td style="text-align:left">
					<font color="#999999">职务名称：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndut(),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">工作单位及职务：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncom(),"-")%></td>
				<td style="text-align:right">
					<font color="#999999">任职时间：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate(),"-")%></td>
			</tr>
        </table>
        
        <table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="split_table">
          <tr bgcolor="#f9f9f9">
            <td><div class="">职称信息</div></td>
          </tr>
        </table>
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="list_table" >
			<tr>
				<td style="text-align:leftr">
					<font color="#999999">职称：</font>
					<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT995",domainInstance.getCpsndutname()+"",false),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">级别：</font>
					<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT997",domainInstance.getCpsnjoblevel()+"",false),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">取得时间：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndutdate2(),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">聘任时间：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndate(),"-")%></td>
				<td style="text-align:right">
					<font color="#999999">聘任年限：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnyear(),"-")%></td>
			</tr>
        </table>
		
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="split_table">
          <tr bgcolor="#f9f9f9">
            <td><div class="">执业信息</div></td>
          </tr>
        </table>
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="list_table" >
			<tr>
				<td style="text-align:left">
					<font color="#999999">医师级别：</font>
					<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT987",domainInstance.getCpsnysjb()+"",false),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">执业证书编码：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzyzbbm(),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">执业类别：</font>
						<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT993",domainInstance.getCpsnzylb()+"",false),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">执业科目：</font>
					<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT888",domainInstance.getCpsnzykm()+"",false),"-")%></td>
				<td style="text-align:right">
					<font color="#999999">执业状态：</font>
					<%=StringUtil.getNotEmptyStr(DictionaryUtil.getDictValueByDictKey("HR_CT994",domainInstance.getCpsnzyzt()+"",false),"-")%></td>
			<tr>
        </table>
        
        <table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="split_table">
          <tr bgcolor="#f9f9f9">
            <td><div class="">资格证书</div></td>
          </tr>
        </table>
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="list_table" >
			<tr>
				<td style="text-align:left">
					<font color="#999999">资格证书编码：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnzbzsbm(),"-")%></td>
				<td style="text-align:right">
					<font color="#999999">批准日期：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsnpzdate(),"-")%></td>
				<tr>
        </table>

		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="split_table">
          <tr bgcolor="#f9f9f9">
            <td><div class="">教育信息</div></td>
          </tr>
        </table>
		<table width="880" border="0" align="center" cellpadding="0" cellspacing="0" class="list_table" >
			<tr>
				<td style="text-align:left">
					<font color="#999999">院系：</font>
						<%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll3(),StringUtil.getNotEmptyStr(domainInstance.getCpsncoll4()))%></td>
				<td style="text-align:center">
					<font color="#999999">学历：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredcode(),"-")%></td>
				<td style="text-align:center">
					<font color="#999999">学位：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegcode(),"-")%></td>
				<td style="text-align:right">
					<font color="#999999">毕业时间：</font>
					<%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreedate(),"-")%></td>
			<tr>
		<!-- 
			<tr>
				<td></td>
				<td>学历</td>
				<td>学位</td>
				<td>学校</td>
				<td>院系</td>
				<td>毕业时间</td>
			<tr>
			<tr>
				<td>最高学历</td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopredcode())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsntopdegcode())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll4())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll3())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreedate())%></td>
			<tr>
			<tr>
				<td>全日制学历</td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnredft())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsndegreeft())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncoll2())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsncollege())%></td>
				<td></td>
			<tr>
			<tr>
				<td>在职学历</td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincred())%></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincdegree())%></td>
				<td></td>
				<td><%=StringUtil.getNotEmptyStr(domainInstance.getCpsnincumcoll())%></td>
				<td></td>
			<tr>
		 -->
        </table>
		<!-- 工具栏 --> 
		<jsp:include page="../ToolBar/detail_toolbar.jsp"/> 
	</body> 
</html> 
