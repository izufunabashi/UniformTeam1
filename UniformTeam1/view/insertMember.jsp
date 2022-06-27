<%@page contentType="text/html; charset=UTF-8"%>

<%
String error = (String) request.getAttribute("error");
//エラーメッセージがない場合
if(error == null){
	error = "";
}
%>

<html>
	<head>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<title>新規登録</title>
	</head>
	<body>
		<!-- ヘッダー部分 -->
		<%@ include file="/common/headerUser.jsp" %>

		<!-- メニュー部分 -->
		<div align="center" id="main" class="container">
			<h2 class = "user">新規登録</h2>
			<hr class = "userhr">

			<!-- メイン部分 -->
			<table class = "ctable">
					<tr>
						<td width="200"><a href="<%=request.getContextPath()%>/view/login.jsp">ログイン画面に戻る</a></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					<tr>
			</table>

		<hr class = "userhr">
		<p class = "error"><%= error %></p>
		<form action ="<%=request.getContextPath()%>/insertMember">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="registrant_id"  class="text"></input></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><input type="text" name="name"  class="text"></input></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password"  class="text"></input></td>
				</tr>
				<tr>
				<th>パスワード確認用</th>
					<td><input type="password" name="password_check"  class="text"></input></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><input type="text" name="postal_code" class="text"></input></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><input type="text" name="address" class="text"></input></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="text" name="email" class="text"></input></td>
				</tr>
			</table>
			<br>

		<input type="submit"  value="登録">
		</form>
		</div>

	<br>
	<br>
	<br>

	<!-- フッター部分 -->
	<%@ include file="/common/footerUser.jsp" %>

	</body>
</html>
