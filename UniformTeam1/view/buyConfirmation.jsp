<!--
 * プログラム名：
 * プログラムの説明：
 *
 * 作成者：佐久間　優
 * 作成日：2022年6月日
 -->
<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.*,java.util.ArrayList" %>
<%
//カート内容を取得
ArrayList<Sale> list = (ArrayList<Sale>)session.getAttribute("sale_list");
//会員情報を取得
Registrant registrant = (Registrant)session.getAttribute("registrant");
//アカウント情報変数
Account account;
//会員か判定
if (registrant != null) {
	account = (Account)request.getAttribute("account");
} else {
	account = (Account)session.getAttribute("guest");
}

%>

<html>
<head>
<meta charset="UTF-8">
<title>購入確認</title>
<link rel=" stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ユーザー用ヘッダーをインクルード -->
	<%@include file = "/common/headerUser.jsp" %>

	<div align="center" id="main" class= "container">
		<h2 class = "user">購入確認</h2>
		<hr class = "userhr">
		<h3 class = "blue">※購入はまだ完了しておりません。購入内容が正しければ購入ボタンをクリックしてください。</h3>
		<h3>購入者情報</h3>
		<table class = "userInfo">
		<tr>
		<td>購入者名</td>
		<td><%=account.getName() %></td>
		</tr>
		<tr>
		<td>郵便番号</td>
		<td><%=account.getPostal_code() %></td>
		</tr>
		<tr>
		<td>住所</td>
		<td><%=account.getAddress() %></td>
		</tr>
		<tr>
		<td>ご連絡先メールアドレス</td>
		<td><%=account.getEmail() %></td>
		</tr>
		</table>
		<br>
		<h3>購入商品情報</h3>
		<form action="<%=request.getContextPath() %>/buyConfirm" method="get">
		<table class = "uniformInfo">
			<tr>
				<th>商品名</th>
				<th>数量</th>
				<th>小計</th>
				<th>備考</th>
			</tr>
			<%
				int total = 0;
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Sale uniforms = (Sale) list.get(i);
						total += uniforms.getPrice() * uniforms.getQuantity();
			%>
			<tr>
				<td><%=uniforms.getUniformName() %></td>
				<td><%=uniforms.getQuantity() %>枚</td>
				<td><%=uniforms.getPrice() * uniforms.getQuantity() %>円</td>
				<td><%=uniforms.getRemark() %></td>
			</tr>
			<%
					}
				}
			%>
		</table>

		<hr class="line"></hr>
		<p>合計金額　<%=total %>円</p>
		<input type="hidden" name="total" value="<%=total %>">

		<br>
		<p><input type="submit" name="buyConfirm" value="購入確定" class="button"> </p>

		<p><a href = "<%=request.getContextPath() %>/showCart">カート内容の確認に戻る</a></p>
		</tr>
		</form>

		<br><br>

	</div>
</body>

<!-- ユーザー用フッターをインクルード -->
	<%@include file = "/common/footerUser.jsp" %>
</html>
