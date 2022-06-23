package dao;

import java.sql.*;
import java.util.*;

import bean.Uniform;

public class UniformDAO {

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

	// データベースからすべての情報の検索を行うメソッド
	public ArrayList<Uniform> selectAll() {

		ArrayList<Uniform> list = new ArrayList<Uniform>();
		String sql = "SELECT * FROM uniform_info";

		Connection con = null;
		Statement smt = null;

		try {
			con = UniformDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Uniform uniforms = new Uniform();
				uniforms.setId(rs.getInt("uniform_id"));
				uniforms.setUniformName(rs.getString("uniform_name"));
				uniforms.setPrice(rs.getInt("price"));
				uniforms.setStock(rs.getInt("stock"));
				uniforms.setImage(rs.getString("uniform_image"));
				uniforms.setDescription(rs.getString("description"));

				list.add(uniforms);
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

	// 対象の商品情報を取得するメソッド
	public Uniform selectByUniformId(int uniform_id) {

		Connection con = null;
		Statement smt = null;

		Uniform uniform = new Uniform();

		String sql = "SELECT * FROM uniform_info WHERE uniform_id = " + uniform_id;

		try {

			con = UniformDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				uniform.setId(rs.getInt("uniform_id"));
				uniform.setUniformName(rs.getString("uniform_name"));
				uniform.setPrice(rs.getInt("price"));
				uniform.setStock(rs.getInt("stock"));
				uniform.setImage(rs.getString("uniform_image"));
				uniform.setDescription(rs.getString("description"));
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
		return uniform;
	}

}
