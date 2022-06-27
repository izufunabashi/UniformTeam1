package servlet;

/*
 * プログラム名：UpdateUniformServlet
 * プログラムの説明：ユニフォームの更新処理を行うサーブレットクラス
 * 取得するパラメータ：uniform_id パラメータ名id
 * 					   uniformName パラメータ名uniformName
 *					   price パラメータ名price
 *					   stock パラメータ名stock
 *					   description パラメータ名description
 *					   newImage パラメータ名newImage
 *					   oldImage パラメータ名oldImage
 * 作成者：鵜飼大樹
 * 作成日：2022/06/24
 */

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import bean.Uniform;
import dao.UniformDAO;

//イメージ処理必須アノテーション
@MultipartConfig
public class UpdateUniformServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラー用変数
		String error = null;
		// 文字コード指定
		request.setCharacterEncoding("utf-8");
		// UniformDAOオブジェクト作成
		UniformDAO uniformDao = new UniformDAO();
		try {
			// パラメータ取得
			int uniform_id=Integer.parseInt(request.getParameter("id"));
			String uniformName=request.getParameter("uniformName");
			int price=Integer.parseInt(request.getParameter("price"));
			int stock=Integer.parseInt(request.getParameter("stock"));
			String description = request.getParameter("description");
			String oldImage = request.getParameter("oldImage");

			// アップロードするフォルダ
			String imgPath = getServletContext().getRealPath("/img");

			// 旧画像移動
			Path p1 = Paths.get(imgPath + "/" + oldImage);
			Path p2 = Paths.get(imgPath + "/tmp/" + oldImage);
			Files.move(p1, p2);

			// 画像取得
			Part part = request.getPart("image");
			// ファイル名取得
			String newImage = Paths.get(part.getSubmittedFileName()).getFileName().toString();

			if (!newImage.equals(oldImage)) {
				// 全filename検索処理呼び出し
				ArrayList<String> image_list = uniformDao.selectImage();
				for (int i = 0; i < image_list.size(); i++) {
					if (newImage.equals(image_list.get(i))) {
						error = "別のファイル名と同じです。";
						// 旧画像移動
						Files.move(p2, p1);
						return;
					}
				}
			}

			// Uniformオブジェクト作成
			Uniform uniform = new Uniform();
			uniform.setId(uniform_id);
			uniform.setUniformName(uniformName);
			uniform.setPrice(price);
			uniform.setStock(stock);
			uniform.setDescription(description);
			if(newImage.equals("")) {
				uniform.setImage(oldImage);
			}else {
				uniform.setImage(newImage);
			}

			// エラー用Uniformオブジェクト
			Uniform tmpUniform = uniformDao.selectByUniformId(uniform_id);

			try {
				// 更新処理呼び出し
				uniformDao.update(uniform);
				if(!newImage.equals("")) {
					// イメージをimgフォルダに保存
					part.write(imgPath + File.separator + newImage);

					// パス取得
					Path p = Paths.get(imgPath + File.separator + "tmp" + File.separator + oldImage);
					// イメージ削除
					Files.delete(p);
				}else {
					// 旧画像移動
					Files.move(p2, p1);
				}

			} catch (IllegalStateException e) {
				error = e.toString();
				// 旧画像移動
				Files.move(p2, p1);
			}catch (Exception e) {
				error = e.toString();
				// 情報修正
				uniformDao.update(tmpUniform);
				// 旧画像移動
				Files.move(p2, p1);
			}

		} catch (Exception e) {
			error = e.toString();
		} finally {
			request.setAttribute("error", error);
			if(error==null) {
				request.getRequestDispatcher("listUnifrom").forward(request, response);
			}else {
				request.getRequestDispatcher("/view/result.jsp").forward(request, response);
			}
		}
	}
}
