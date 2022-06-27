<!--
プログラム名		：ユニフォーム受注管理システム E組チーム１ ShowCart.jsp
プログラムの説明	：ユニフォーム受注管理システム カート一覧のjsp
作成者				：野島千陽
作成日				：2022年6月24日
 -->

 <!-- http://localhost:8080/UniformTeam1/view/showCart.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.* , java.util.ArrayList" %>
<!-- 一つ下の値を参照してるっぽい -->

<%
	//リクエストスコープから商品情報の受けとり
	ArrayList<Sale> sale_list = (ArrayList<Sale>)request.getAttribute("sale_list");

	//商品の種類数
	ArrayList<Uniform> uniList = (ArrayList<Uniform>)request.getAttribute("uniList");
	int unitype = uniList.size();

%>
<html>
	<head>
		<title>カート内容</title>
	</head>
	<body>
	<!-- ヘッダー部分 -->
	<!-- ユーザー用ヘッダーをインクルード -->
	<%@include file = "/common/headerUser.jsp" %>
		<h2 class = "user">カート内容</h2>
		<hr class = "userhr">

	<!-- リンクテーブル -->
		<table class = "cartList">
		<tr>
		<td>
		<button id = "list">商品一覧へ</button></td>
		<td style= "width:600;">　　</td>
		<td><button id = "log">ログイン</button></td>
		</tr>
		</table>
		<hr class = "userhr">

<!-- 注意事項 -->
<p>※備考部分に書いた文章は購入以外の画面に移動すると、消えてしまいます。画面を移動する際はお気をつけ下さい。</p>

	<!-- 一覧表示 -->
	<div>
		<form action="<%=request.getContextPath()%>/LoginCheckServlet.java " method="get">
		<table class= "cartList">
			<tr>
				<th>商品名</th>
				<th>商品画像</th>
				<th>価格</th>
				<th>数量</th>
				<th>備考</th>
				<th></th>
			</tr>
				<%
				int[] stockCheck = new int[unitype];

				int total = 0;

				if( sale_list != null){
					for(int i = 0; i <  sale_list.size() ; i++){
						Sale sale  = (Sale)sale_list.get(i);

						total += sale.getQuantity() * sale.getPrice();

						for (int j = 0 ; j <= unitype ; j++){
							if(j+1 == sale.getId()){
								stockCheck[j] += sale.getQuantity();
							}
						}

				%>
						<tr>
							<td><a href = "<%=request.getContextPath()%>/detailUniform?id=<%=sale.getId()%>&cmd=detailUniform"><%=sale.getUniformName() %></a></td>
							<td><img src = "<%=request.getContextPath()%>/img/<%=sale.getImage()%>" alt ="<%=sale.getUniformName() %>" width = "100"></td>
							<td><%=sale.getPrice()%>円</td>
							<td><%=sale.getQuantity()%>着</td>
							<td class = "text"><textarea name = "remark<%=i%>" rows = "5" cols = "30" id = "text"></textarea></td>
							<td><a href="<%=request.getContextPath()%>/showCart?delno=<%=i%>">削除</a></td>
						</tr>
					<%} %>
				<%} else {%>
			<tr>
				<td>　　</td>
				<td>　　</td>
				<td>　　</td>
				<td>　　</td>
				<td>　　</td>
				<td>　　</td>
			</tr>
			<%} %>
		</table>
		<textarea name = "remark" rows = "5" cols = "30" id = "text"  style="display:none;"></textarea>

		<%for (int j = 0 ; j < unitype ; j++){
			Uniform uni = uniList.get(j);

			if(stockCheck[j] > uni.getStock()) { %>
				<p style = "color:red;"><%=uni.getUniformName() %>の購入希望数が在庫数を超えています。注文は可能ですが、通常よりもお時間をいただきます。ご了承下さい。</p>

		<% } else { %>
		<p style= "display:none;"></p>
		<%
			}
		}
		%>

		<p>
		<button id = "sum" value = "<%=total%>" type = "button">合計金額</button>
		</p>
		<br><br><br>
		<p>
		<input type = "submit" value = "購入" name="buy" class="button">
		</p>
		</form>
	</div>
		<br><br><br>

	<!-- ユーザー用フッターをインクルード -->
	<%@include file = "/common/footerUser.jsp" %>

<script type="text/javascript">
	document.getElementById('list').onclick = function(){
		var element = document.getElementById('text');
		if (element.value != ""){
			var con = confirm('このまま画面を移動した場合、備考の入力情報が消えてしまいます。画面を移動してもよろしいですか?');
			if (con){
				window.location.href='<%=request.getContextPath()%>/listUniform';
			}else{
				return;
			}
		}else{
		window.location.href='<%=request.getContextPath()%>/listUniform';
		}
	}

	document.getElementById('log').onclick = function(){
		var element = document.getElementById('text');
		if (element.value != ""){
			var con = confirm('このまま画面を移動した場合、備考の入力情報が消えてしまいます。画面を移動してもよろしいですか?');
			if (con){
				window.location.href='<%=request.getContextPath()%>/login';
			}else{
				return;
			}
		}else{
		window.location.href='<%=request.getContextPath()%>/login';
		}
	}

	document.getElementById('sum').onclick = function(){

		alert("現在、カート内商品の合計金額は" + sum.value + "円です。");
	}

</script>
</body>

</html>
