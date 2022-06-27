package dao;

import java.sql.*;
import java.util.*;

import bean.BankNumber;

public class BankNumberDAO {

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
	public BankNumber selectByBankNumberId(int bankNumberId) {

		BankNumber bank = new BankNumber();

		String sql = "SELECT * FROM bank_number_info WHERE bank_number_id = " + bankNumberId;

		Connection con = null;
		Statement smt = null;

		try {
			con = BankNumberDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				bank.setId(rs.getInt("bank_number_id"));
				bank.setBankNumber(rs.getString("bank_number"));
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
		return bank;

	}

}
