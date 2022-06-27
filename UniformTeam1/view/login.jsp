<!--
プログラム名：ユニフォーム受注管理システム login.jsp
プログラムの説明：ログイン画面のjsp
作成者：播磨瑠夏
作成日：2022年6月24日
 -->

<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Registrant"%>

<%
	//各データをセッションから取得
	String registrant_id = "";
	String password = "";
	String error = (String) request.getAttribute("error");
	Cookie[] cookieList = request.getCookies();

	//クッキーがあるか判定
	if (cookieList != null) {
		for (Cookie cookie : cookieList) {
			//クッキーからID情報の取得
			if (cookie.getName().equals("registrant_id")) {
				registrant_id = cookie.getValue();
			}
			//クッキーからパスワード情報の取得
			if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
	}
	if (error == null) {
		error = "";
	}
%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>ログイン</title>
</head>
<body>

<!-- ヘッダー部分 -->
<%@ include file="/common/headerUser.jsp" %>

	<!-- メニュー部分 -->
	<div align="center" id="main" class="container">
	<h2 class = "user">ログイン</h2>
	<hr class = "userhr">
	<br>

		<!-- メイン部分 -->
		<p><%=error %></p>
		<form action="<%=request.getContextPath()%>/login" method="POST">
			<table>
				<tr>
					<th>ID</th>
					<td><input type=text size="30" name="registrant_id" value="<%=registrant_id %>" class="text"></input><br></td>
				</tr>

				<tr>
					<th>パスワード</th>
					<td><input type=password size="30" name="password" value="<%=password %>" class="text"></input></td>
				</tr>
			</table>

			<input type="submit" name="login" value="ログイン" class="button" >
			<br><br><br>

			<a href="<%=request.getContextPath()%>/insertMember" class="a" >新規登録</a>
		</form>
	</div>

<br><br><br>

<!-- フッター部分 -->
<%@ include file="/common/footerUser.jsp" %>

</body>
</html>