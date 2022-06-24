<!-- /*
プログラム名		：ユニフォーム受注管理システム E組チーム１ insertIntoCart.jsp
プログラムの説明	：ユニフォーム受注管理システム カート追加のjsp
作成者				：野島千陽
作成日				：2022年6月24日
*/ -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.*" %>

<!-- http://localhost:8080/UniformTeam1/view/insertIntoCart.jsp -->
<%
//Saleオブジェクトをリクエストスコープから受け取る
Sale sale = (Sale)request.getAttribute("sale");

%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
		<title>カートに追加</title>
	</head>
	<body>
		<!-- ヘッダーをインクルード -->
		<%@ include file="/common/headerUser.jsp"%>

		<!-- 機能名 -->
		<h2 class = "user">カート追加</h2>
		<hr class = "userhr">
		<div style ="text-align:center;">
		<h4>以下商品をカートに追加しました。</h4>
		</div>

		<!-- 商品情報 -->
			<table>
				<tr>
				<th>商品名</th>
					<td><%=sale.getUniformName() %></td>
				</tr>
				<tr>
					<th>価格</th>
					<td><%=sale.getPrice() %>円</td>
				</tr>
				<tr>
					<th>数量</th>
					<td><%=sale.getQuantity() %>着</td>
				</tr>
			</table>
			<br>
			<hr>
			<p>合計　　<%=sale.getPrice() *  sale.getQuantity()%>円</p>

			<br>
			<!-- リンク先指定 -->
			<table>
				<tr>
					<td>
						<a href ="<%=request.getContextPath()%>/listUniform"><button class = "button ">商品一覧へ</button></a>
					</td>
					<td>
						<form action="<%=request.getContextPath()%>/showCart">
						<input type="submit" value="カート確認"  class = "button">
						</form>
					</td>
				</tr>
			</table>

			<br>
			<br>
			<br>
			<br>
			<br>
			<br>

		<!-- フッターをインクルード -->
		<%@ include file="/common/footerUser.jsp"%>
	</body>
</html>
