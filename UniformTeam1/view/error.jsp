<!--
プログラム名		：ユニフォーム受注管理システム E組チーム１  error.jsp
プログラムの説明	：ユニフォーム受注管理システムのエラー画面です。
作成者				：船橋 生澄
作成日				：2022年6月23日
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%
	//エラー内容をリクエストスコープから取得
	String error = (String) request.getAttribute("error");
	//遷移先をリクエストスコープから取得
	String cmd = (String) request.getAttribute("cmd");

	//各値が取得できなかった場合に空文字を代入
	if(error == null){
		error = "";
	}
	if(cmd == null){
		cmd = "";
	}
%>

<html>
<head>
<title>エラー画面</title>
<link rel="stylesheet"href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<!-- ヘッダ -->
<%@ include file="/common/headerAdmin.jsp" %>

<div align="center" id="main" class="container">
	<h1>エラー画面</h1>
	<hr>
	<h2>●エラー●</h2>
</div>

<br>

<!-- コンテンツ部分 -->
<div align="center"  id="main" class="container">

	<!-- エラーメッセージ  -->
	<p class="error-msg"><%=error %></p>

	<br>

	<!--
	リンク先(cmdの値によって変化)
	一覧画面はサーブレットに、その他画面はjspに遷移
	 -->

	<% if(cmd.equals("login")){ %>
			<a href="<%=request.getContextPath() %>/view/login.jsp">[ログイン画面に戻る]</a>
	<% } else if(cmd.equals("listUniform")){ %>
			<a href="<%=request.getContextPath() %>/listUniform">[商品一覧に戻る]</a>
	<% } else if(cmd.equals("showCart")){ %>
			<a href="<%=request.getContextPath() %>/showCart">[カート一覧に戻る]</a>
	<% } else if(cmd.equals("inputUser")){ %>
			<a href="<%=request.getContextPath() %>/view/inputUser.jsp">[購入者情報入力に戻る]</a>
	<% } else if(cmd.equals("insertMember")){ %>
			<a href="<%=request.getContextPath() %>/view/insertMember.jsp">[新規登録画面に戻る]</a>
	<% } else if(cmd.equals("menuAdmin")){ %>
			<a href="<%=request.getContextPath() %>/view/menuAdmin.jsp">[管理者メニューに戻る]</a>
	<% } else if(cmd.equals("uniformManagementMenu")){ %>
			<a href="<%=request.getContextPath() %>/view/uniformManagementMenu">[商品管理メニューに戻る]</a>
	<% } else if(cmd.equals("orderManagementMenu")){ %>
			<a href="<%=request.getContextPath() %>/view/orderManagementMenu">[受注管理メニューに戻る]</a>
	<% } else if(cmd.equals("listOrderManagement")){ %>
			<a href="<%=request.getContextPath() %>/listOrderManagement">[受注一覧に戻る]</a>
	<% } else if(cmd.equals("showSales")){ %>
			<a href="<%=request.getContextPath() %>/showSales">[売り上げ状況に戻る]</a>
	<% } else { %>
			<!-- cmdが空か上記に引っかからなかった場合などはログイン画面のリンクを表示 -->
			<a href="<%=request.getContextPath() %>/view/login.jsp">[ログイン画面に戻る]</a>
	<% } %>

</div>

<br>
<br>
<br>

<!-- フッター -->
<%@ include file="/common/footerAdmin.jsp" %>

</body>
</html>
