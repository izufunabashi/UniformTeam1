package dao;

import java.sql.*;
import java.util.*;

import bean.Sale;

public class OrderDetailDAO {

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

	// 購入品をデータベースに登録するメソッド
	public int insert(Sale sale, int order_management_id) {

		String sql = "INSERT INTO order_detail_info VALUES("
		+ null + "," + order_management_id + ",'"
		+ sale.getUniformName() + "'," + sale.getQuantity() + ","
		+ sale.getPrice() + ",'" + sale.getRemark() + "')";

		int count = 0;

		Connection con = null;
		Statement smt = null;

		try {
			con = OrderDetailDAO.getConnection();
			smt = con.createStatement();

			count = smt.executeUpdate(sql);

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
		return count;

	}

}
