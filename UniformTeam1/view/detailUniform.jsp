<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Uniform,bean.Registrant"%>
<%
	Uniform uniform = (Uniform)request.getAttribute("uniform");

	Registrant registrant = (Registrant)session.getAttribute("registrant");

	String authority = "ゲスト";

	if (registrant != null) {
		if(registrant.getAuthority().equals("u")){
			authority = "会員";
		}else if(registrant.getAuthority().equals("m")){
			authority = "管理者";
		}
	}
%>
<html lang ="ja">
	<head>
		<meta charset = "UTF-8">
		<title>商品詳細</title>
		<link rel="stylesheet"href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
	<%if(authority.equals("管理者")) {%>
		<h1 class = "admin">株式会社 神田ユニフォーム</h1>

		<hr class = "adminhr">

		<h2 class = "admin">商品詳細</h2>

		<hr class = "adminhr">

		<div align="center">
			<h2><%=uniform.getUniformName() %></h2>
			<p><img src ="<%=request.getContextPath()%>/img/<%=uniform.getImage() %>" alt = "<%=uniform.getUniformName() %>" width ="300"></p>
			<table align="center">
				<tr>
					<td class="index">値段</td>
					<td><%=uniform.getPrice() %>円</td>
				</tr>
				<tr>
					<td class="index">在庫数</td>
					<td><%=uniform.getStock() %>着</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/detailUniform?id=<%=uniform.getId()%>&cmd=updateUniform">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/deleteUniform?id=<%=uniform.getId()%>">削除</a>
					</td>
				</tr>
				<tr>
					<td class="index">商品説明</td>
					<td class = "explanation"><%=uniform.getDescription() %></td>
				</tr>
			</table>
			<br>
			<p><a href = "<%=request.getContextPath()%>/listUniform">商品一覧へ戻る</a></p>
		</div>

		<hr  class = "adminhr"></hr>

		<h4 class = "admin">Copyright (C) 2022 All Rights Reserved.</h4>
	<%}else{ %>
		<h1 class = "user">株式会社 神田ユニフォーム</h1>

		<hr class = "userhr">

		<h2 class = "user">商品詳細</h2>

		<hr class = "userhr">

		<div align="center">
			<h2><%=uniform.getUniformName() %></h2>
			<p><img src ="<%=request.getContextPath()%>/img/<%=uniform.getImage() %>" alt = "<%=uniform.getUniformName() %>" width ="300"></p>
			<form action ="<%=request.getContextPath()%>/insertIntoCart">
				<table align="center">
					<tr>
						<td class="index">値段</td>
						<td><%=uniform.getPrice() %>円</td>
					</tr>
					<tr>
						<td class="index">在庫数</td>
						<td><%=uniform.getStock() %>着</td>
					</tr>
					<tr>
						<td>購入</td>
						<td>
						<select>
						<%if(uniform.getStock()<=0){ %>
							<option value = "0">在庫切れ</option>
						<%}else{ %>
							<%for(int i = 1;i<=uniform.getStock();i++){ %>
								<option value = "<%= i %>"><%=i%></option>
							<%} %>
						<%} %>
						</select>着
						<input type = "submit" value="カートに追加">
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td class="index">商品説明</td>
						<td class = "explanation"><%=uniform.getDescription() %></td>
					</tr>
				</table>
			</form>
			<br>
			<p><a href = "<%=request.getContextPath()%>/listUniform">商品一覧へ戻る</a></p>
		</div>

		<hr  class = "userhr"></hr>

		<h4 class = "user">Copyright (C) 2022 All Rights Reserved.</h4>
	<%} %>
	</body>
</html>