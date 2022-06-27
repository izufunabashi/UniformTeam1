/*
 * プログラム名		：ユニフォーム受注管理システム E組チーム１  ListUniformServlet.java
   プログラムの説明	：ユニフォーム受注管理システムの商品一覧画面です。
   作成者				：松本 楓
   作成日				：2022年6月24日
*/

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Uniform;
import dao.UniformDAO;

public class ListUniformServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {

			// オブジェクトの生成
			UniformDAO objDao = new UniformDAO();

			//selectAllメソッドで全ての商品を呼び出す
			ArrayList<Uniform> list = objDao.selectAll();

			// リクエストスコープへのUniformオブジェクトの登録
			request.setAttribute("uniform_list", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "menu";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はlistUniform.jspにフォワード
				request.getRequestDispatcher("/view/listUniform.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// フォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}

	}
}
