/*
 * プログラム名:InsertMemberServlet
 * プログラム説明: 会員のアカウント登録サーブレット
 * 作成者:鶴田雄也
 * 作成日:2022/6/24
 */

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Registrant;
import dao.AccountDAO;
import dao.RegistrantDAO;

public class InsertMemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラーチェック用変数
		String error = "";
		String cmd = "";

		try {
			// 入力文字のエンコード設定
			request.setCharacterEncoding("UTF-8");

			// 入力情報を格納
			String registrant_id = request.getParameter("registrant_id");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String password_check = request.getParameter("password_check");
			String postal_code = request.getParameter("postal_code");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String authority = "u"; // 会員用権限「u」

			// 入力エラーチェック処理
			if (registrant_id.equals("")) {
				error = "無記入の項目があります";
				cmd = "insertMember";
				return;
			} else if (name.equals("")) {
				error = "無記入の項目があります";
				cmd = "insertMember";
				return;
			} else if (password.equals("")) {
				error = "無記入の項目があります";
				cmd = "insertMember";
				return;
			} else if (postal_code.equals("")) {
				error = "無記入の項目があります";
				cmd = "insertMember";
				return;
			} else if (address.equals("")) {
				error = "無記入の項目があります";
				cmd = "insertMember";
				return;
			} else if (email.equals("")) {
				error = "無記入の項目があります";
				cmd = "insertMember";
				return;
			} else {
			}

			// パスワードチェック
			if (!(password.equals(password_check))) {
				error = "パスワードが正しくありません";
				cmd = "insertMember";
				return;
			}

			// アカウントテーブル用のオブジェクト生成
			Account account = new Account();

			// メソッドを使うDAOクラスのインスタンス化
			AccountDAO accountDao = new AccountDAO();

			// 登録者テーブル用のオブジェクト作成
			Registrant registrant = new Registrant();

			// メソッドを使うDAOクラスのインスタンス化
			RegistrantDAO registrantDao = new RegistrantDAO();

			// 入力IDが重複していないかの判別処理
			registrant = registrantDao.selectById(registrant_id);
			if (registrant.getRegistrant_id()!=null) {
				error = "入力IDは既に使用されています";
				cmd = "insertMember";
				return;
			}

			// 入力されたパラメータをデータ格納
			account.setName(name);
			account.setEmail(email);
			account.setPostal_code(postal_code);
			account.setAddress(address);
			account.setAuthority(authority);

			// メソッドを呼び出してデータベースに登録
			accountDao.insert(account);

			// 登録情報に紐づいたID番号を取得
			int id = accountDao.selectById(name, email);

			// オブジェクトに取得したデータを格納
			registrant.setRegistrant_id(registrant_id);
			registrant.setAccount_id(id);
			registrant.setPassword(password);
			registrant.setAuthority(authority);

			// DBに登録
			registrantDao.insert(registrant);

			// セッションに保存
			HttpSession session = request.getSession();
			session.setAttribute("registrant", registrant);

			//単体テストでのチェック用 問題なければ消してください
			//session.setAttribute("account", account);


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、新規登録は行えませんでした。";
			cmd = "insertMember";
		} finally {
			// フォワード処理
			if (error.equals("")) {
				request.getRequestDispatcher("/listUniform").forward(request, response);

				// 単体テストでのチェック用 request.setAttribute("message", "登録成功");
				//request.getRequestDispatcher("/view/test.jsp").forward(request, response);

			} else if (cmd.equals("insertMember")) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/insertMember.jsp").forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

				//単体テストでのチェック用
				//request.setAttribute("message", "登録失敗");
				//request.getRequestDispatcher("/view/test.jsp").forward(request, response);
			}
		}
	}
}
