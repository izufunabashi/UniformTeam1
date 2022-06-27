package servlet;

/*
 * プログラム名：ユニフォーム受注管理システム　LogoutServlet.java
 * プログラムの説明：ログアウト処理用サーブレット
 * 作成者：播磨瑠夏
 * 作成日：2022年6月24日
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

	// ログアウト
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッション情報をクリア
		HttpSession session = request.getSession();

		if(session != null) {
			session.invalidate();
		}

		// login.jspにフォワードする
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	}

}
