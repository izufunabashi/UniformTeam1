package servlet;

/*
* プログラム名：ユニフォーム受注管理システム
* プログラムの説明：購入者情報入力画面の情報をDBに登録し、購入確認画面に遷移させる。
* 作成者：佐久間　優
* 作成日：2022年6月24日
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Account;
import dao.*;

public class InputUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//エラー用変数
		String error = null;
		String cmd = "inputUser";

		try {

			//オブジェクト生成
			request.setCharacterEncoding("UTF-8");

			//パラメータを取得
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			String address = request.getParameter("address");
			String mail = request.getParameter("mail");

			//空文字のチェック(エラー処理)
			if (name.equals("")) {
				error = "名前が入力されていない為、購入確認画面には遷移できません。";
				return;
			} else if (number.equals("")) {
				error = "郵便番号が入力されていない為、購入確認画面には遷移できません。";
				return;
			} else if (address.equals("")) {
				error = "住所が入力されていない為、購入確認画面には遷移できません。";
				return;
			} else if (mail.equals("")) {
				error = "メールアドレスが入力されていない為、購入確認画面には遷移できません。";
				return;
			} else {

			}

			//AccountDTOにデータを格納
			Account guest = new Account();
			guest.setName(name);
			guest.setPostal_code(number);
			guest.setAddress(address);
			guest.setEmail(mail);
			guest.setAuthority("g");

			//DB登録
			AccountDAO accountDao = new AccountDAO();
			accountDao.insert(guest);

			//idの取得
			int id = accountDao.selectById(name, mail);

			//idを格納
			guest.setId(id);

			//セッション準備
			HttpSession session = request.getSession();

			//セッションに登録
			session.setAttribute("guest", guest);


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
			} else {//購入確認画面に遷移
				request.getRequestDispatcher("/view/buyConfirmation.jsp").forward(request, response);
			}
		}
	}
}
