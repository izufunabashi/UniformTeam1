package dao;

/*
 * プログラム名：ユニフォーム受注管理システム SalesStateDAO
 * プログラムの説明：売上げ状況関連のデータアクセスを管理するDAOクラス
 * 作成者：佐久間優
 * 作成日：2022/06/27
 */

import java.sql.*;
import java.util.*;

import bean.*;

public class SalesStateDAO {

	// 接続用の情報をフィールドに定数として定義
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/kandauniformdb";
	private static String USER = "root";
	private static String PASSWD = "root123";

	// データベース接続を行なうメソッド
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}



	// データベースから売上げ状況の検索を行うメソッド
	public ArrayList<SalesState> selectAll() {

		ArrayList<SalesState> list = new ArrayList<SalesState>();
		String sql = "SELECT a.order_detail_id, a.uniform_name, a.price, a.quantity, a.price * a.quantity,b.order_date "
				+ "FROM order_detail_info a INNER JOIN order_management_info b ON "
				+ "a.order_management_id = b.order_management_id ORDER BY a.order_detail_id DESC;";

		Connection con = null;
		Statement smt = null;

		try {
			con = SalesStateDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				SalesState sales = new SalesState();
				sales.setOrder_detail_id(rs.getInt("order_detail_id"));
				sales.setUniform_name(rs.getString("uniform_name"));
				sales.setPrice(rs.getInt("price"));
				sales.setQuantity(rs.getInt("quantity"));
				sales.setTotal(rs.getInt("a.price * a.quantity"));
				sales.setOrder_date(rs.getString("order_date"));

				list.add(sales);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return list;
	}

}
