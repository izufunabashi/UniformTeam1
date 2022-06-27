package servlet;

/*
 * プログラム名：ユニフォーム受注管理システム　LoginServlet.java
 * プログラムの説明：ログイン処理用サーブレット
 * 作成者：播磨瑠夏
 * 作成日：2022年6月24日
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Account;
import bean.Registrant;
import dao.AccountDAO;
import dao.RegistrantDAO;

public class LoginServlet extends HttpServlet {

	// ログイン
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String registrant_id = "";
		String password = "";
		Registrant registrant = null;

		try {
			// フォームから受け取るデータの文字コードを指定
			request.setCharacterEncoding("UTF-8");

			// registrant_id、passwordのパラメータを取得する
			registrant_id = request.getParameter("registrant_id");
			password = request.getParameter("password");

			// RegistrantDAOクラスのオブジェクトを生成
			RegistrantDAO objRegistrantDao = new RegistrantDAO();

			// RegistrantDAOクラスのselectById(String registrant_id, String password)メソッドを呼び出す
			registrant = objRegistrantDao.selectById(registrant_id, password);

			// registrant_idがない場合
			if (registrant.getRegistrant_id() == null) {
				error = "入力データが間違っています！";
				cmd = "login";
				return;
			}

			// registrant_id用クッキー
			Cookie registrant_idCookie = new Cookie("registrant_id", registrant.getRegistrant_id());
			registrant_idCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(registrant_idCookie);

			// password用クッキー
			Cookie passwordCookie = new Cookie("password", registrant.getPassword());
			passwordCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(passwordCookie);

			// AccountDAOクラスのオブジェクトを生成
			AccountDAO objAccountDao = new AccountDAO();

			// AccountDAOクラスのselectById(int account_id)メソッドを呼び出す
			Account account = objAccountDao.selectById(registrant.getAccount_id());

			// registrantに権限を格納
			registrant.setAuthority(account.getAuthority());

			// 取得したregistrantオブジェクトをセッションスコープに登録
			HttpSession session = request.getSession();
			session.setAttribute("registrant", registrant);

			// 権限によって、フォワード先を分ける
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
			cmd = "logout";

		} finally {
			// エラーがない場合
			if (error.equals("")) {
				if (registrant.getAuthority().equals("m")) {
					request.getRequestDispatcher("/view/menuAdmin.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/listUniform").forward(request, response);
				}

				// エラーがある場合
			} else {
				request.setAttribute("error", error);
				if (cmd.equals("login")) {
					request.getRequestDispatcher("/view/login.jsp").forward(request, response);

				} else {
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);

				}

			}

		}
	}

}
