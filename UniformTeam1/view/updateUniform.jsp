<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Uniform,bean.Registrant"%>
<%
	Uniform uniform = (Uniform)request.getAttribute("uniform");

	/*Registrant registrant = (Registrant)session.getAttribute("registrant");

	String authority = "ゲスト";

	if (registrant != null) {
		if(registrant.getAuthority().equals("u")){
			authority = "会員";
		}else if(registrant.getAuthority().equals("m")){
			authority = "管理者";
		}
	}*/
%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet"href="<%=request.getContextPath()%>/css/style.css">
		<title>商品更新</title>
	</head>
	<body>
		<hr class="adminhr">
		<h2 class = "admin">ユニフォーム受注管理システム</h2>
		<hr class = "adminhr">

		<div align="center" id="main" class="container">
			<h1 class = "admin">商品更新</h1>
			<hr class = "adminhr">
			<a href = "<%=request.getContextPath()%>/listUniform">商品一覧</a>
			<hr class = "adminhr">

			<form action = "<%=request.getContextPath()%>/updateUniform" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="id" value="<%= uniform.getId() %>">
			<input type="hidden" name="oldImage" value="<%= uniform.getImage() %>">
			<table>
				<tr>
					<td>&nbsp;</td>
					<th>変更前</th>
					<th>変更後</th>
				</tr>
				<tr>
					<th>商品名</th>
					<td><%= uniform.getUniformName() %></td>
					<td><input type=text size="30" name="uniformName"  class="text" value="<%= uniform.getUniformName() %>"></input></td>
				</tr>
				<tr>
					<th>価格</th>
					<td><%= uniform.getPrice() %></td>
					<td><input type=text size="30" name="price"  class="text"value="<%= uniform.getPrice() %>"></input></td>
				</tr>
				<tr>
					<th>在庫</th>
					<td><%= uniform.getStock() %></td>
					<td><input type=text size="30" name="stock" class="text" value="<%= uniform.getStock() %>"></input></td>
				</tr>
				<tr>
					<th>商品説明</th>
					<td><%=uniform.getDescription() %></td>
					<td><textarea name="description" rows="5" cols="45"><%=uniform.getDescription() %></textarea></td>
				</tr>
				<tr>
					<th>画像</th>
					<td><img src ="<%=request.getContextPath()%>/img/<%=uniform.getImage() %>" alt = "<%=uniform.getUniformName() %>" width ="300"></td>
					<td>
						<input type="file" name="image">
						<p>画像を変更を行わない場合は<br>選択する必要はありません</p>
					</td>
				</tr>
			</table>
			<input type="submit"  value="変更" class="button"  >
			</form>
		</div>
		<br>
		<br>
		<br>
		<hr  class = "adminhr"></hr>
		<h4  class = "admin">Copyright (C) 2022 All Rights Reserved.</h4>
	</body>
</html>
