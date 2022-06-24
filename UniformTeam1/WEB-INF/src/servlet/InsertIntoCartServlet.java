/*
プログラム名		：ユニフォーム受注管理システム E組チーム１ InsertIntoCartServlet.java
プログラムの説明	：ユニフォーム受注管理システム カート追加サーブレット
作成者				：野島千陽
作成日				：2022年6月24日
*/

package servlet;

import java.util.ArrayList;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class InsertIntoCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
	throws ServletException ,IOException{

		//例外処理用の文字列を宣言
		String error = "";
		String cmd = "";

		//エンコードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");

		try {

			//セッションオブジェクトを生成
			HttpSession session = request.getSession();

			Account account = (Account)session.getAttribute("account");

			 //パラメータの受け取りとint型に型変換(listUniformから)
			int uniformId =  Integer.parseInt(request.getParameter("uniform_id"));
			int quantity =  Integer.parseInt(request.getParameter("uniformQuantity"));

			//UniformDaoをインスタンス化し、selectByUniformIdメソッドを呼び出す
			UniformDAO uniDao = new UniformDAO();

			//uniformIdで検索
			Uniform uniform = uniDao.selectByUniformId(uniformId);

			//表示対象が存在しない例外
			if (uniform.getId() == 0) {
				error = "追加対象の商品が存在しない為、カートへの追加は行えませんでした。";
				cmd = "listUniform";
				return;
			}

			//注文情報をSaleに格納
			Sale sale = new Sale();	//インスタンス化
			sale.setId(uniform.getId());		//ユニフォームID
			sale.setUniformName(uniform.getUniformName());//ユニフォーム名
			sale.setPrice(uniform.getPrice());//価格
			sale.setQuantity(quantity);		//個数
			sale.setImage(uniform.getImage());//画像

			//リクエストスコープにSale情報を格納
			request.setAttribute("sale",sale);

			//セッションからカート情報を取得
			ArrayList<Sale> list = (ArrayList<Sale>)session.getAttribute("sale_list");

			//リストが生成されていない場合
			if(list == null) {
				list = new ArrayList<Sale>();
			}

			//セッションにsale_list配列を追加
			list.add(sale);
			session.setAttribute("sale_list", list);

		}catch (IllegalStateException e) {
			//DB接続エラー
			error = "DB接続エラーの為、カートに追加はできません。";
			cmd = "login";

		} catch(Exception e){
			error = "想定外のエラーが発生しました。\n" + e;
			cmd = "login";

		//フォワード処理
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/insertIntoCart.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
