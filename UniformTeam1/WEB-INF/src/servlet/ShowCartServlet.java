package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;

public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// 文字列型変数エラーを作成
		String error = "";
		String cmd = "";

		try {

			//セッションオブジェクトを生成
			HttpSession session = request.getSession();

			//delnoの入力パラメータを取得(削除用)
			String delno = request.getParameter("delno");

			//セッションからsale_listを取得する
			ArrayList<Sale> sale_list = (ArrayList<Sale>)session.getAttribute("sale_list");

			//カート情報の削除処理
			if(delno != null) {
				sale_list.remove(Integer.parseInt(delno));
			}

			//リクエストスコープにsaleListを追加
			request.setAttribute("sale_list", sale_list);

			//商品が何種類あるのかを確認
			UniformDAO unidao = new UniformDAO();
			ArrayList<Uniform> uniList = unidao.selectAll();

			//リクエストスコープにuniListを追加
			request.setAttribute("uniList", uniList);

			// DB接続エラーの例外
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、カート状況は確認できません。";
			cmd = "login";

		} catch (Exception e) {
			error = "想定外のエラーが発生しました。\n" + e;
			cmd = "login";

		// フォワード処理
		} finally {
			if (error.equals("")) {
			request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);
			} else {
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
