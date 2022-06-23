package dao;

/*
 * プログラム名：AccountDAO
 * プログラムの説明：Accountデータ関連のデータアクセスを管理するDAOクラス
 * 作成者：鵜飼大樹
 * 作成日：2022/06/23
 */

import java.sql.*;

import bean.Account;

public class AccountDAO {

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
	public int insert(Account account) {

		Connection con = null;
		Statement smt = null;

		int count=0;

		try{
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "INSERT INTO account_info VALUES(null,'" + account.getName() + "','" + account.getEmail()
					+ "','" + account.getPostal_code() + "','" + account.getAddress() + "','" + account.getAuthority()
					+ "')";
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

	// account_id取得処理(Registrant作成用)
	public int selectById(String name,String email) {

		Connection con = null;
		Statement smt = null;

		int id=0;
		try{
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "select max(account_id) as account_id from account_info where name='"+name+"'and email='"+email+"'";
			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果取得
			while (rs.next()) {
				id = rs.getInt("account_id");
			}

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
		return id;
	}

	// Account取得処理
	public Account selectById(int account_id) {

		Connection con = null;
		Statement smt = null;

		Account account = new Account();
		try {
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "select * from account_info where account_id=" + account_id;
			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果取得
			while (rs.next()) {
				account.setId(rs.getInt("account_id"));
				account.setName(rs.getString("name"));
				account.setEmail(rs.getString("email"));
				account.setPostal_code(rs.getString("postal_code"));
				account.setAddress(rs.getString("address"));
				account.setAuthority(rs.getString("authority"));
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
		return account;
	}
}
