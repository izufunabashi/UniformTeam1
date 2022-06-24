<%@page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>商品管理メニュー</title>
</head>
<body>


	<%@ include file="/common/headerAdmin.jsp" %>
	<div align="center" id="main" class="container">
		<h1 class = "admin">商品管理メニュー</h1>
		<hr class = "adminhr">
		<br>
		<table>
			<tr><td><a href="<%=request.getContextPath() %>/listUniform">商品一覧</a></td></tr>
			<tr><td></td></tr>
			<tr><td><a href="<%=request.getContextPath() %>/view/insertUniform.jsp">商品追加</a></td></tr>
			<tr><td></td></tr>
			<tr><td></td></tr>
			<tr><td><a href="<%=request.getContextPath() %>/view/menuAdmin.jsp">管理者メニューへ</a></td></tr>
			<tr><td></td></tr>
			<tr><td><a href="<%=request.getContextPath() %>/view/orderManagementMenu.jsp">受注管理メニューへ</a></td></tr>
		</table>

		<br><br><br>
	</div>
</body>

<%@ include file="/common/footerAdmin.jsp" %>
</html>
