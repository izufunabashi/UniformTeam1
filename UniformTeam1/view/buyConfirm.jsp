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
ArrayList<Sale> list = (ArrayList<Sale>)request.getAttribute("sale_list");

%>

<html>
<head>
<meta charset="UTF-8">
<title>購入確定</title>
<link rel=" stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ユーザー用ヘッダーをインクルード -->
	<%@include file = "/common/headerUser.jsp" %>

	<div align="center" id="main" class="container">
		<h2 class = "user">購入確定</h2>
		<hr class = "userhr">
		<h3>以下の商品を購入しました。</h3>

		<table>
			<tr>
				<th>商品名</th>
				<th>数量</th>
				<th>小計</th>
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
			</tr>
			<%
					}
				}
			%>

		</table>

		<hr>
		<p>合計金額　<%=total %>円</p>

		<br><br>

	</div>
	<p>
	ご購入ありがとうございます。購入確認メールを送信しました。<br>確認メールに商品代金入金先情報を記載しております。
	入金期限にご注意ください。<br>メールが届かない等ございましたら、下記メールアドレスまで
	お願いいたします。<br><br>
	お問い合わせ連絡先:kandaUniform@mail.com</p>
	<br>
	<p><a href = "<%=request.getContextPath() %>/listUniform">商品一覧に戻る</a></p>
</body>

<!-- ユーザー用フッターをインクルード -->
	<%@include file = "/common/footerUser.jsp" %>
</html>
