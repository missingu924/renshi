<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@page import="com.wuyg.common.licence.LicenceUtil"%>
<%@page import="com.wuyg.echarts.EchartsUtil"%>
<%@page import="com.wuyg.common.util.StringUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.wuyg.common.util.TimeUtil"%>
<%@page import="com.wuyg.auth.obj.AuthUserObj"%>
<%@page import="com.wuyg.common.util.SystemConstant"%>
<%@page import="com.wuyg.common.obj.PaginationObj"%>
<%@page import="com.wuyg.dictionary.DictionaryUtil"%>
<%@page import="java.util.Date"%>
<html>
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no" />
		<link href="../css/global.css" rel="stylesheet" type="text/css">
		<title>portal</title>
		<script type="text/javascript" src="../js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../js/utils.js"></script>
	</head>
	<%
		// 当前用户
		AuthUserObj user = (AuthUserObj) request.getSession().getAttribute(SystemConstant.AUTH_USER_INFO);
	
		String hr_hi_person = "(select * from hr_hi_person where rpersontype like '10%') t";
		
		String sql = "";
	%>
	<body>
	<form name="pageForm" id="pageForm" method="post" action="<%=request.getContextPath()%>/SaleStat/year_portal.jsp"> 
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					人数统计
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<tr>
				<td width="33%" height="120">
					<p>
						<span class="lcd_greendark_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person), 0)%>
						</span>
					</p>
					<p>
						总人数
					</p>
				</td>
				<td width="33%">
					<p>
						<span class="lcd_greendark_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" where rpersontype='101'"), 0)%>
						</span>
					</p>
					<p>
						在编人数
					</p>
				</td>
				<td width="33%">
					<p>
						<span class="lcd_greendark_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" where rpersontype!='101'"), 0)%>
						</span>
					</p>
					<p>
						非在编人数
					</p>
				</td>
			</tr>
			<!-- 
			<tr>
				<td width="33%" height="120">
					<p>
						<span class="lcd_blue_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" left join HR_CT987 on Cpsnysjb=ccodeid where vdescription like '%医生%' or vdescription like '%医师%'"), 0)%>
						</span>
					</p>
					<p>
						医生人数
					</p>
				</td>
				<td width="33%">
					<p>
						<span class="lcd_blue_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" left join HR_CT987 on Cpsnysjb=ccodeid where vdescription like '%护士%' or vdescription like '%护师%'"), 0)%>
						</span>
					</p>
					<p>
						护士人数
					</p>
				</td>
				<td width="33%">
					<p>
						<span class="lcd_blue_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" left join HR_CT987 on Cpsnysjb=ccodeid where vdescription like '%药师%'"), 0)%>
						</span>
					</p>
					<p>
						药师人数
					</p>
				</td>
			</tr>
			<tr>
				<td width="33%" height="120">
					<p>
						<span class="lcd_purple_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" left join HR_CT993 on Cpsnzylb=ccodeid where vdescription like '%中医%'"), 0)%>
						</span>
					</p>
					<p>
						中医人数
					</p>
				</td>
				<td width="33%">
					<p>
						<span class="lcd_purple_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" left join HR_CT993 on Cpsnzylb=ccodeid where vdescription like '%中西医结合%'"), 0)%>
						</span>
					</p>
					<p>
						中西医结合人数
					</p>
				</td>
				<td width="33%">
					<p>
						<span class="lcd_purple_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" left join HR_CT993 on Cpsnzylb=ccodeid where vdescription like '%临床%'"), 0)%>
						</span>
					</p>
					<p>
						临床人数
					</p>
				</td>
			</tr>
			 -->
			<tr>
				<td width="33%" height="120">
					<p>
						<span class="lcd_organe_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" where Weishengjishu='S'"), 0)%>
						</span>
					</p>
					<p>
						卫生技术人数
					</p>
				</td>
				<td width="33%">
				</td>
				<td width="33%">
					<p>
						<span class="lcd_organe_big">
						<%=StringUtil.formatDouble(EchartsUtil.getValueByInvSql("select count(*) value from "+hr_hi_person+" where Weishengjishu!='S'"), 0)%>
						</span>
					</p>
					<p>
						非卫生技术人数
					</p>
				</td>
			</tr>
		</table>
		
		
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					执业类别分布
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<%sql="select ccodeid code, isnull(vdescription,'其他') name,COUNT(*) value from "+hr_hi_person+" left join HR_CT993 on Cpsnzylb=ccodeid where vdescription is not null group by ccodeid,vdescription"; %>
			<tr>
				<td>
					<%=EchartsUtil.createEchartByInvSql(sql, "value desc", "", new String[]{""}, new String[]{""}, EchartsUtil.PIE, EchartsUtil.THEME_SHINE, EchartsUtil.COLOR_BLUE, 300, 400,  "listByZylb(params.data.code)")%>
				</td>
				<td style="lign:right;vertical-align:middle;">
					<%=EchartsUtil.createTableByInvSql(sql, "value desc","统计","执业类别","人数", 0, 0,  "listByZylb(params.data.code)")%>
				</td>
			</tr>
		</table>
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					执业科目分布
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<%sql="select ccodeid code, isnull(vdescription,'其他') name,COUNT(*) value from "+hr_hi_person+" left join HR_CT888 on Cpsnzykm=ccodeid where vdescription is not null group by ccodeid,vdescription"; %>
			<tr>
				<td>
					<%=EchartsUtil.createEchartByInvSql(sql, "value desc", "", new String[]{""}, new String[]{""}, EchartsUtil.BAR_V, EchartsUtil.THEME_SHINE, EchartsUtil.COLOR_ORANGE, 560, 400,  "listByZykm(params.data.code)")%>
				</td>
				<td style="vertical-align:middle;">
					<%=EchartsUtil.createTableByInvSql(sql, "value desc","统计","执业科目","人数", 0, 0,  "listByZykm(params.data.code)")%>
				</td>
			</tr>
		</table>
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					医师级别分布
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<%sql="select ccodeid code, isnull(vdescription,'其他') name,COUNT(*) value from "+hr_hi_person+" left join HR_CT987 on Cpsnysjb=ccodeid where vdescription is not null group by ccodeid,vdescription"; %>
			<tr>
				<td >
					<%=EchartsUtil.createEchartByInvSql(sql, "value desc", "", new String[]{""}, new String[]{""}, EchartsUtil.PIE, EchartsUtil.THEME_SHINE, EchartsUtil.COLOR_BLUE, 300, 400,  "listByYsjb(params.data.code)")%>
				</td>
				<td style="vertical-align:middle;">
					<%=EchartsUtil.createTableByInvSql(sql, "value desc","统计","医师级别","人数", 0, 0,  "listByYsjb(params.data.code)")%>
				</td>
			</tr>
		</table>
		
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					职称分布
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<%sql="select ccodeid code, isnull(vdescription,'其他') name,COUNT(*) value from "+hr_hi_person+" left join HR_CT995 on Cpsndutname=ccodeid where vdescription is not null group by ccodeid,vdescription"; %>
			<tr>
				<td>
					<%=EchartsUtil.createEchartByInvSql(sql, "value desc", "", new String[]{""}, new String[]{""}, EchartsUtil.BAR_V, EchartsUtil.THEME_SHINE, EchartsUtil.COLOR_BLUE, 900, 400,  "listByDutname(params.data.code)")%>
				</td>
				<td style="vertical-align:middle;">
					<%=EchartsUtil.createTableByInvSql(sql, "value desc","统计","职称","人数", 0, 0,  "listByDutname(params.data.code)")%>
				</td>
			</tr>
		</table>
		
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					部门类别分布
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<%sql="select cDepCode code,isnull(cDepName,'其他') name,COUNT(*) value from "+hr_hi_person+" left join department on substring(cDept_num,1,1)=cDepCode group by cDepCode,cDepName"; %>
			<tr>
				<td>
					<%=EchartsUtil.createEchartByInvSql(sql, "code ", "", new String[]{""}, new String[]{""}, EchartsUtil.PIE, EchartsUtil.THEME_SHINE, EchartsUtil.COLOR_GREEN_DARK, 300, 400,  "listByDept(params.data.code)")%>
				</td>
				<td style="vertical-align:middle;">
					<%=EchartsUtil.createTableByInvSql(sql, "code ","统计","部门类别","人数", 0, 0,  "listByDept(params.data.code)")%>
				</td>
			</tr>
		</table>
		
		<table align="center" width="98%" class="title_table">
			<tr>
				<td style="text-align: left; color: #0055a8; border-bottom: 1px solid #dddddd;">
					<img src="../images/svg/heavy/green/32/pie_chart.png" width="16" height="16" align="middle" />
					部门分布
				</td>
			</tr>
		</table>
		<table id="overview_table" width="98%" align="center" class="table_goal">
			<%sql="select cDepCode code,isnull(cDepName,'其他') name,COUNT(*) value from "+hr_hi_person+" left join department on cDept_num=cDepCode group by cDepCode,cDepName"; %>
			<tr>
				<td>
					<%=EchartsUtil.createEchartByInvSql(sql, "code ", "", new String[]{""}, new String[]{""}, EchartsUtil.BAR_V, EchartsUtil.THEME_SHINE, EchartsUtil.COLOR_GREEN_DARK, 1900, 400,  "listByDept(params.data.code)")%>
				</td>
				<td style="vertical-align:middle;">
					<%=EchartsUtil.createTableByInvSql(sql, "code ","统计","部门","人数", 0, 0,  "listByDept(params.data.code)")%>
				</td>
			</tr>
		</table>
		
		</form>
		<script type="text/javascript">
		function listByYsjb(code)
		{
			winOpen('<%=request.getContextPath()%>/Proxy/Servlet?servlet=HrHiPerson&method=list4this&cpsnysjb='+code);
		}
		
		function listByZylb(code)
		{
			winOpen('<%=request.getContextPath()%>/Proxy/Servlet?servlet=HrHiPerson&method=list4this&cpsnzylb='+code);
		}
		
		function listByZykm(code)
		{
			winOpen('<%=request.getContextPath()%>/Proxy/Servlet?servlet=HrHiPerson&method=list4this&cpsnzykm='+code);
		}
		
		function listByDutname(code)
		{
			winOpen('<%=request.getContextPath()%>/Proxy/Servlet?servlet=HrHiPerson&method=list4this&cpsndutname='+code);
		}
		
		function listByDept(code)
		{
			if(code.length==1)
			{
				winOpen('<%=request.getContextPath()%>/Proxy/Servlet?servlet=HrHiPerson&method=list4this&otherWhere=cdept_num like \''+code+'%\'');
			}
			else
			{
				winOpen('<%=request.getContextPath()%>/Proxy/Servlet?servlet=HrHiPerson&method=list4this&cdept_num=multi:'+code);
			}
		}
		</script>
	</body>
</html>

