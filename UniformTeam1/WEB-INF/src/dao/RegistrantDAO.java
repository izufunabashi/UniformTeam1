package dao;

/*
 * プログラム名：RegistrantDAO
 * プログラムの説明：Registrantデータ関連のデータアクセスを管理するDAOクラス
 * 作成者：鵜飼大樹
 * 作成日：2022/06/23
 */

import java.sql.*;

import bean.Registrant;

public class RegistrantDAO {

	// DB情報
	private static String RDB_DRIVE="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost/kandauniformdb";
	private static String USER="root";
	private static String PASSWD="root123";

	// DB接続
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// 登録処理
	public int insert(Registrant registrant) {

		Connection con = null;
		Statement smt = null;

		int count=0;

		try{
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "INSERT INTO registrant_info VALUES('"+registrant.getRegistrant_id()+"',"+ registrant.getAccount_id() +",'"+ registrant.getPassword() +"')";
			// SQL文発行
			count = smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			// リソースの開放
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return count;
	}

	// Registrant取得処理(引数:1)
	public Registrant selectById(int account_id) {

		Connection con = null;
		Statement smt = null;

		Registrant registrant = new Registrant();

		try {
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "select * from registrant_info where account_id=" + account_id;
			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果取得
			while (rs.next()) {
				registrant.setRegistrant_id(rs.getString("registrant_id"));
				registrant.setAccount_id(rs.getInt("account_id"));
				registrant.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// リソースの開放
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
		return registrant;
	}

	// Registrant取得処理(引数:2)
	public Registrant selectById(String registrant_id, String password) {

		Connection con = null;
		Statement smt = null;

		Registrant registrant = new Registrant();

		try {
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "select * from registrant_info where registrant_id='" + registrant_id + "'and password='"
					+ password + "'";
			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果取得
			while (rs.next()) {
				registrant.setRegistrant_id(rs.getString("registrant_id"));
				registrant.setAccount_id(rs.getInt("account_id"));
				registrant.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// リソースの開放
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
		return registrant;
	}
}
