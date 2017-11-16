<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage=""%>
<%@page import="com.wuyg.common.util.SystemConstant"%>
<%@page import="com.wuyg.common.licence.LicenceUtil"%>
<%@page import="com.wuyg.common.util.StringUtil"%>
<%@page import="com.wuyg.auth.obj.AuthUserObj"%>
<%@page import="com.wuyg.tree.obj.ZTreeNode"%>
<%@page import="com.wuyg.tree.service.TreeService"%>
<%@page import="java.util.List"%>
<%@page import="com.wuyg.system.util.SystemMenuUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/css-1.7.0.min.js"></script>
		<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
		<style type="text/css">
<!--
a {
	color: #ffffff;
	text-decoration: none;
}
body,td,th {
	color: #FFFFFF;
}
-->
</style>
		<script type="text/javascript" src="js/utils.js"></script>
	</head>
	<%
		// ��ǰ������·�� 
		String contextPath = request.getContextPath();
	
		AuthUserObj user = (AuthUserObj) request.getSession().getAttribute(SystemConstant.AUTH_USER_INFO);
	
		String systemEnName=StringUtil.getNotEmptyStr(LicenceUtil.getLicencedMachine().getEnName(),"default");
		
		ZTreeNode zTreeNode = new TreeService().getZtreeNode("����ϵͳ�˵�", SystemConstant.DEFAULT_DB, false, true, null);
		List<ZTreeNode> menus = zTreeNode.getChildren();
	%>
	<body>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="header_bottom">
			<tr>
				<!-- ���logo -->
				<td width="190" height="45" valign="middle" style="vertical-align: middle">
					<img style="vertical-align: middle" src="images/SystemName-01.png"/>
				</td>
				
				<!-- �м�˵� -->
				<td align="center" valign="bottom" style="padding: 0px 0px 0px 0px">
				
					
					<%=SystemMenuUtil.buildHeaderMenuHtml(zTreeNode,contextPath,user)%>
				</td>
				
				<!-- �Ҳ� -->
				<td width="190" align="right" valign="middle" style="padding:0px 10px 0px 10px">
					<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right"><%=user.getName()%></td>
							<td width="20" align="right"></td>
							<td width="1" align="right" bgcolor="#ffffff"></td>
							<td width="30" align="right">
								<img src="images/svg/light/green/16/text_document.png" title="ϵͳ��Ϣ" style="cursor: pointer" onclick="openBigModalDialog('system_info.jsp?')" />
							</td>
							<td width="30" align="right" style="display: none">
								<form id="downloadForm" action="<%=request.getContextPath()%>/System/Servlet?method=downloadManual" method="post">
									<img src="images/svg/light/green/16/text_document.png" title="ʹ���ֲ�" style="cursor: pointer" onclick="$('#downloadForm').submit()" />
								</form>
							</td>
							<td width="30" align="right">
								<img src="images/svg/light/green/16/arrow_left.png" title="�˳�" style="cursor: pointer" onclick="logout()" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="8" colspan="3" class="header_bottom"></td>
			</tr>
	</table>

	<!-- �����ϲ˵����js -->
	<script type="text/javascript" src="js/header.js"></script>
	
	<script type="text/javascript">
		// ģ�����ϲ˵��ĵ�һ�������˵� 
		$(document).find("#top_menu_table td:first").click();
	</script>

	</body>
</html>
