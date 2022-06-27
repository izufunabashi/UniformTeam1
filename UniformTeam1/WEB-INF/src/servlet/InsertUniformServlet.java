package servlet;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import bean.Uniform;
import dao.UniformDAO;

//イメージ処理必須アノテーション
@MultipartConfig
public class InsertUniformServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラー用変数
		String error = null;

		//エラー時遷移先用変数(船橋追加(06,24,13:38))
		String cmd = null;


		// 文字コード指定
		request.setCharacterEncoding("utf-8");
		// UniformDAOオブジェクト
		UniformDAO uniformDao = new UniformDAO();
		try {
			// パラメータ取得
			String uniformName = request.getParameter("uniformName");
			int price=Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			String description = request.getParameter("description");

			// 画像取得
			Part part = request.getPart("image");
			// ファイル名取得
			String image = Paths.get(part.getSubmittedFileName()).getFileName().toString();

			// 全image検索処理呼び出し
			ArrayList<String> image_list = uniformDao.selectImage();
			for (int i = 0; i < image_list.size(); i++) {
				if (image.equals(image_list.get(i))) {
					error = "既に存在するファイル名です。";
					return;
				}
			}

			// Uniformオブジェクト作成
			Uniform uniform = new Uniform();
			uniform.setUniformName(uniformName);
			uniform.setPrice(price);
			uniform.setStock(stock);
			uniform.setDescription(description);
			uniform.setImage(image);

			// 登録処理呼び出し
			uniformDao.insert(uniform);

			// アップロードするフォルダ
			String path = getServletContext().getRealPath("/img");

			// イメージをimgフォルダに保存
			part.write(path + File.separator + image);

		}catch (Exception e) {
			error = e.toString();
		}finally{
			if(error == null) {
				request.getRequestDispatcher("listUniform").forward(request, response);

			} else {
				//エラー時遷移先指定(船橋追加(06,24,13:39))
				if(cmd == null) {
					cmd = "uniformManagementMenu";
				}
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error").forward(request, response);
			}
		}
	}
}
