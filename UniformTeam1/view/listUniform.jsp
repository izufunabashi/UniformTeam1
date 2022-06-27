<!--
プログラム名		：ユニフォーム受注管理システム E組チーム１  listUniform.jsp
プログラムの説明	：ユニフォーム受注管理システムの商品一覧画面です。
作成者				：松本 楓
作成日				：2022年6月24日
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.*"%>

<%
ArrayList<Uniform> list = (ArrayList<Uniform>) request.getAttribute("uniform_list");
%>

<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<title>商品一覧</title>
</head>


<body>
	<!-- ヘッダー部分 -->
	<%@ include file="/common/headerAdmin.jsp"%>

	<!-- メニュー部分 -->

		<h2 class="user">商品一覧</h2>
		<hr class="userhr">



		<table class="ctable">
			<tr>
				<td width="200"><a href="<%=request.getContextPath()%>/logout"><button>ログアウト</button></a></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width="50"><a href="<%=request.getContextPath()%>/login"><button>ログイン</button></a></td>
				<td width="50"><a href="<%=request.getContextPath()%>/showCart"><button>カートを確認</button></a></td>
			<tr>
		</table>


		<hr class="userhr">
		<br>


		<!-- 商品一覧のコンテンツ部分 -->
		<table class="uniformList">
			<tr>
				<td class="solidtd">商品名</td>
				<td class="solidtd">商品画像</td>
				<td class="solidtd">価格</td>
				<td class="solidtd">数量</td>
				<td class="solidtd">&nbsp;</td>
			</tr>

			<%
                 //商品の数だけ繰り返す
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Uniform uniform = (Uniform) list.get(i);
			%>

			<tr>
				<td class="solidtd"><a href="<%=request.getContextPath()%>/detailUniform"><%=uniform.getUniformName()%></a></td>
				<td class="solidtd"><img src="<%=request.getContextPath()%>/image/tmp/<%=uniform.getImage() %>"
					alt="<%=uniform.getUniformName()%>" width="100"></td>
				<td class="solidtd"><%=uniform.getPrice()%>円</td>
				<td  class="solidtd">
					<select name="uniformQuantity">
						<%
							//在庫数の数だけ繰り返す
							int j = 0;
							for (j = 1; j <= uniform.getStock(); j++) {
						%>
						<option value=<%=j%>><%=j%></option>

						<%
							}
						%>
					</select>着
				</td>
				<td  class="solidtd">
					<form action = "<%=request.getContextPath()%>/insertIntoCart" >
						<input type="hidden" value="<%=uniform.getId()%>" name="uniform_id">
						<input type="submit" value ="カートに追加" class = "button">

					</form>
				</td>
					<%
						}
							%>
			</tr>

			<%
					}
			%>
		</table>
		<br> <br>

		<!-- フッター部分 -->
		<hr class="userhr">
		<h4 class="user">Copyright (C) 2022 All Rights Reserved.</h4>
</body>
</html>