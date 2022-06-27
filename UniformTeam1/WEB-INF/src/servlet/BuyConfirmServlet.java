package servlet;

/*
* プログラム名：ユニフォーム受注管理システム
* プログラムの説明：購入確認の情報をDBに登録し、購入完了画面に遷移させる
* 作成者：佐久間　優
* 作成日：2022年6月24日
*/

import java.io.*;
import java.util.ArrayList;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;

//import util.SendMail;
import bean.*;
import dao.*;

public class BuyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//エラー用変数
		String error = null;
		String cmd = null;

		try {

			//パラメータから合計金額を取得
			int total = Integer.parseInt(request.getParameter("total"));

			//セッション準備
			HttpSession session = request.getSession();

			//会員情報を取得
			Registrant registrant = (Registrant)session.getAttribute("registrant");

			//AccountDAOオブジェクト生成
			AccountDAO accountDao = new AccountDAO();

			//アカウント情報を格納するための変数
			Account account;

			//会員か判定
			if (registrant != null) {
				//会員のアカウント情報を格納
				account = accountDao.selectById(registrant.getAccount_id());
			} else {
				//ゲストのアカウント情報を格納
				account = (Account)session.getAttribute("guest");
			}

			//セッション切れか判定(エラー処理)
			if (account == null) {
				error = "セッション切れの為購入は出来ません。";
				cmd = "login";
				return;
			}

			//OrderManagementDAOオブジェクト生成
			OrderManagementDAO orderManagementDao = new OrderManagementDAO();

			//受注情報をDBに登録して、受注IDを取得
			int id = orderManagementDao.insert(account.getId(), total);

			//カート内容を取得
			ArrayList<Sale> sale_list = (ArrayList<Sale>)session.getAttribute("sale_list");

			//OrderDetailDAOオブジェクト生成
			OrderDetailDAO orderDetailDao = new OrderDetailDAO();

			//カート内容(購入品)をDBに登録
			for (int i = 0; i < sale_list.size(); i++) {
				orderDetailDao.insert(sale_list.get(i), id);
			}

			//リクエストスコープにカート内容(購入品)を格納
			request.setAttribute("sale_list", sale_list);
			//セッションからカート内容を削除
			session.setAttribute("sale_list", null);

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
			} else {// 購入確定画面に遷移
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);
			}
		}
	}
}
