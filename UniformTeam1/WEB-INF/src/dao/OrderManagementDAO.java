package dao;

import java.sql.*;
import java.util.*;

import bean.OrderManagement;

public class OrderManagementDAO {

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

	// 受注情報を登録するメソッド
	public int insert(int account_id, int total_price) {

		int id = 0;

		String sql = "INSERT INTO order_management_info VALUES(" + null + "," + account_id + "," + total_price
				+ ", CURDATE(), '0', '0')";

		String search = "SELECT MAX(order_management_id) as order_management_id FROM order_management_info";

		Connection con = null;
		Statement smt = null;

		try {
			con = OrderManagementDAO.getConnection();
			smt = con.createStatement();

			smt.executeUpdate(sql);

			ResultSet rs = smt.executeQuery(search);

			while (rs.next()) {
				id = rs.getInt("order_management_id");
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
		return id;

	}

	// データベースからすべての情報の検索を行うメソッド
	/*
	 * public ArrayList<OrderManagement> selectAll() {
	 *
	 * ArrayList<OrderManagement> list = new ArrayList<OrderManagement>(); String
	 * sql = "SELECT * FROM order_management_info";
	 *
	 * Connection con = null; Statement smt = null;
	 *
	 * try { con = UniformDAO.getConnection(); smt = con.createStatement();
	 *
	 * ResultSet rs = smt.executeQuery(sql);
	 *
	 * while (rs.next()) { OrderManagement orderManagements = new OrderManagement();
	 * orderManagements.setOrder_management_id(rs.getInt("order_management_id"));
	 * orderManagements.setOrder_management_id(rs.getInt("order_management_id"));
	 *
	 * list.add(orderManagements); }
	 *
	 * } catch (Exception e) { throw new IllegalStateException(e); } finally { if
	 * (smt != null) { try { smt.close(); } catch (SQLException ignore) { } } if
	 * (con != null) { try { con.close(); } catch (SQLException ignore) { } } }
	 * return list;
	 *
	 * }
	 */

}
