package dao;

import java.sql.*;
import java.util.*;

import bean.*;

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

	public ArrayList<OrderName> selectAll() {

		ArrayList<OrderName> list = new ArrayList<OrderName>();
		String sql = "SELECT a.order_management_id, b.name, a.total_price, a.order_date, a.payment, a.shipping "
				+ "FROM order_management_info a INNER JOIN account_info b "
				+ "ON a.account_id = b.account_id ORDER BY a.order_management_id DESC;";

		Connection con = null;
		Statement smt = null;

		try {
			con = UniformDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				OrderName orderNames = new OrderName();
				orderNames.setId(rs.getInt("order_management_id"));
				orderNames.setName(rs.getString("name"));
				orderNames.setTotal_price(rs.getInt("total_price"));
				orderNames.setOrder_date(rs.getString("order_date"));
				orderNames.setPayment(rs.getString("payment"));
				orderNames.setShipping(rs.getString("shipping"));

				list.add(orderNames);
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
