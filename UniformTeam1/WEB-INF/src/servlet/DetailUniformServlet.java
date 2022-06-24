package servlet;

/*
 * プログラム名：DetailUniformServlet
 * プログラムの説明：1つの商品情報を取得し、
 * 					 リクエストスコープに登録するサーブレットクラス
 * 取得するパラメータ：uniform_id パラメータ名id
 *					   cmd パラメータ名cmd
 *リクエストスコープ：uniform 登録名uniform
 * 作成者：鵜飼大樹
 * 作成日：2022/06/24
 */

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Uniform;
import dao.UniformDAO;

public class DetailUniformServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラー用変数
		String error = null;
		String errorCmd = null;

		// UniformDAOオブジェクト
		UniformDAO uniformDao = new UniformDAO();

		// 文字コード指定
		request.setCharacterEncoding("UTF-8");

		// パラメータ取得
		int uniform_id=Integer.parseInt(request.getParameter("id"));
		String cmd=request.getParameter("cmd");

		try {
			// Uniform取得処理呼び出し
			Uniform uniform = uniformDao.selectByUniformId(uniform_id);

			// リクエストスコープ登録
			request.setAttribute("uniform", uniform);

		} catch (IllegalStateException e) {
			if (cmd.equals("detailUniform")) {
				error = "DB接続エラー";
			} else if (cmd.equals("updateUniform")) {
				error = "DB接続エラー";
			}
			errorCmd = "logout";
		} catch (Exception e) {
			error = e.toString();
		} finally {
			if (error == null) {
				if (cmd.equals("detailUniform")) {
					request.getRequestDispatcher("/view/detailUniform.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/view/updateUniform.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", errorCmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
