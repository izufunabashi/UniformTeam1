<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>管理者メニュー</title>
</head>
<%@ include file="/common/headerAdmin.jsp"%>
<body>


	<div align="center" id="main" class="container">
		<h1 class="admin">管理者メニュー</h1>
		<hr class="adminhr">
		<br> <br>

		<table>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/view/uniformManagementMenu.jsp">商品管理メニュー</a></td>
			</tr>
			<tr>
				<td><br>
				<a href="<%=request.getContextPath()%>/view/orderManagementMenu.jsp">受注管理メニュー</a></td>
			</tr>
			<tr>
				<td><br>
				<br>
				<a href="<%=request.getContextPath()%>/login">ログアウト</a></td>
			</tr>
		</table>

		<br>
		<br>
		<br>
	</div>
</body>

<%@ include file="/common/footerAdmin.jsp"%>
</html>
