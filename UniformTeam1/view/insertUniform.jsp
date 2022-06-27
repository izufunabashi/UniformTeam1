<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>商品追加</title>
<link rel="stylesheet"href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<h2  class = "admin">ユニフォーム受注管理システム</h2>
	<hr class = "adminhr">

	<div align="center" id="main" class="container">
		<h1 class = "admin">商品追加</h1>
		<hr class = "adminhr">
			<table class = "ctable">
			<tr>
				<td width="150"><a href="<%=request.getContextPath()%>/view/uniformManagementMenu.jsp">商品管理メニューへ</a></td>
				<td width="200"><a href="<%=request.getContextPath()%>/listUniform">商品一覧へ</a></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			<tr>
		</table>
		<hr class = "adminhr">

		<br><br>

		<form action="<%=request.getContextPath()%>/insertUniform" method="POST" enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td>商品名</td>
					<td><input type="text" name="uniformName"></td>
				</tr>
				<tr>
					<td>価格</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>在庫</td>
					<td><input type="text" name="stock"></td>
				</tr>
				<tr>
					<td>商品説明</td>
					<td><textarea name="description" rows="3" cols="40"></textarea></td>
				</tr>
				<tr>
					<td>商品画像</td>
					<td><input type="file" name="image"></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">追加</button>
			</div>
		</form>

		<br><br><br>
	</div>

<hr class="adminhr">
<h4  class = "admin">Copyright (C) 2022 All Rights Reserved.</h4>
</body>

</html>
