<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>
	<style>
<!--
html,body {
	height: 98%;
}

td {
	border: 0px solid red;
	color: #000000;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

#main {
	border: 0px solid red;
	width: 100%;
	height: 100%;
	overflow: hidden !important;
	overflow: visible;
	filter:alpha(opacity=20); /*IE滤镜，透明度50%*/
	-moz-opacity:0.2; /*Firefox私有，透明度50%*/
	opacity:0.2;/*其他，透明度50%*/
}
-->
</style>
	<body>
		<table id="main">
			<tr>
				<td style="vertical-align: middle;text-align:center">
					<img style="vertical-align: middle" src="images/index_bg.jpg">
				</td>
			</tr>
		</table>
	</body>
</html>