package servlet;

/*
* プログラム名：ユニフォーム受注管理システム
* プログラムの説明：購入者情報入力画面か購入確認画面に遷移させるサーブレット
* 作成者：佐久間　優
* 作成日：2022年6月24日
*/

import java.io.*;
import java.util.ArrayList;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラー用変数
		String error = null;
		String cmd = null;

		try {

			// セッション準備
			HttpSession session = request.getSession();

			// セッションからカート内容を取得
			ArrayList<Sale> sale_list = (ArrayList<Sale>) session.getAttribute("sale_list");

			// カートの中身が空か判定(エラー処理)
			if (sale_list == null || sale_list.size() == 0) {
				error = "カートの中に何もなかったので購入は出来ません。";
				cmd = "listUniform";
				return;
			}

			// 文字エンコーディング
			request.setCharacterEncoding("UTF-8");

			// カート内容に備考欄を格納
			for (int i = 0; i < sale_list.size(); i++) {
				String remark = request.getParameter("remark" + i);
				sale_list.get(i).setRemark(remark);
			}
			session.setAttribute("sale_list", sale_list);

			// セッションから会員情報を取得
			Registrant registrant = (Registrant) session.getAttribute("registrant");

			// 会員情報を取得できなかった場合は購入者入力画面へ
			if (registrant == null) {
				cmd = "input";
				return;
			}

			// 会員情報からアカウント情報を取得
			AccountDAO accountDao = new AccountDAO();
			Account account = accountDao.selectById(registrant.getAccount_id());

			request.setAttribute("account", account);

		} catch (IllegalStateException e) {// DB接続エラー
			error = "DB接続エラーの為、一覧表示は行なえませんでした。";

		} catch (Exception e) {// 予期せぬエラー
			error = "予期せぬエラーが発生しました。<br>" + e;

		} finally {
			// エラーの有無の判定
			if (error != null) { // エラー画面に遷移
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
				if (cmd != null) {// 購入者情報入力画面に遷移
					request.getRequestDispatcher("/view/inputUser.jsp").forward(request, response);
				} else {// 購入確認画面に遷移
					request.getRequestDispatcher("/view/buyConfirmation.jsp").forward(request, response);
				}
			}
		}
	}
}
