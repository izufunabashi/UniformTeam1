<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>受注管理メニュー</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ヘッダー部分 -->
		<%@ include file="/common/headerAdmin.jsp" %>

		<!-- メニュー部分 -->
		<h1 class = "admin">受注管理メニュー</h1>
		<hr class = "adminhr">
		<br>
		<br>

		<!-- メイン部分 -->
		<table>
			<tr>
				<td><a href="<%=request.getContextPath() %>/listOrderManagement">受注一覧</a></td>
			</tr>
			<tr>
			<td>　　</td>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath() %>/showSales">売り上げ状況</a></td>
			</tr>
		</table>
		<br>
		<br>
		<table>
			<tr>
				<td><a href="<%=request.getContextPath() %>/view/menuAdmin.jsp">管理者メニューへ</a></td>
			</tr>
			<tr>
			<td>　　</td>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath() %>/view/uniformManagementMenu.jsp">商品管理メニューへ</a></td>
			</tr>
		</table>
		<br><br>

	<!-- ヘッダー部分 -->
	<%@ include file="/common/footerAdmin.jsp" %>

	</body>
</html>