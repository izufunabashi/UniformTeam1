<!--
 * プログラム名：
 * プログラムの説明：
 *
 * 作成者：佐久間　優
 * 作成日：2022年6月日
 -->

  <!-- http://localhost:8080/UniformTeam1/view/inputUser.jsp -->
<%@page contentType="text/html; charset=UTF-8" %>
<%

%>

<html>
<head>
<meta charset="UTF-8">
<link rel=" stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>個人情報入力</title>
</head>
<body>
	<!-- ユーザー用ヘッダーをインクルード -->
	<%@include file = "/common/headerUser.jsp" %>

	<div align="center" id="main" class="container">
		<h2 class="user">個人情報入力</h2>
		<hr class="userhr">
		<table class="ctable">
			<tr>
				<td width="200"><a href="<%=request.getContextPath()%>/showCart">カート内容に戻る</a></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			<tr>
		</table>
		<hr class="userhr">

		<form action="<%=request.getContextPath() %>/inputUser" name="form1" onSubmit="return check()">
			<table>
				<tr>
					<th>名前</th>
					<td>
						<input type=text size="30" name="name" class="text" ></input><br>
					</td>
				</tr>

				<tr>
					<th>郵便番号</th>
					<td>
						<input type=text size="30" name="number" class="text"></input>
					</td>
				</tr>
				<tr>
					<th>住所</th>
					<td>
						<textarea  name="address"  rows="5" cols="40" class="text" ></textarea><br>
					</td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td>
						<input type=text size="30" name="mail" class="text" ></input><br>
					</td>
				</tr>

				<tr>
					<td colspan ="2">　　　</td>
				</tr>
				<tr>
					<td colspan ="2">
					<input type="submit" value="個人情報を確定" >

					</td>
				</tr>
			</table>
		</form>
	</div>

	<br>
	<br>
	<p>
		<a href="<%=request.getContextPath()%>/view/login.jsp">ログイン</a>
	</p>

	<br>
	<!-- ユーザー用フッターをインクルード -->
	<%@include file = "/common/footerUser.jsp" %>

	<script type="text/javascript">
	function check(){

		var flag = 0;
		// 入力チェック設定開始（必須にする項目を設定してください）

		if(document.form1.name.value == ""){ // 「お名前」の入力をチェック

			flag = 1;

		}
		else if(document.form1.number.value == ""){ // 「パスワード」の入力をチェック

			flag = 1;

		}
		else if(document.form1.address.value == ""){ // 「住所」の入力をチェック

			flag = 1;

		}
		else if(document.form1.mail.value == ""){ // 「メールアドレス」の入力をチェック

			flag = 1;

		}

		// ↑未入力チェック


		if(flag){

			window.alert('未入力の項目があります。'); // 入力漏れがあれば警告ダイアログを表示
			return false; // 送信を中止

		}
		else{

			return true; // 送信を実行

		}

	}
	</script>

</body>
</html>