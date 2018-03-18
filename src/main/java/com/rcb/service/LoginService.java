package com.rcb.service;

import java.sql.ResultSet;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.User;

public class LoginService {
	static DbConnection db = new DbConnection();

	public static boolean authenticate(User user) {
		try {

			EncriptionAndDecription en_and_de = new EncriptionAndDecription();
			String user_name_db = "";
			String user_password_db = "";
			System.out.println(user_password_db);
			String sql = "Select * from tbl_user where user_name='" + user.getUser_name() + "' and user_password='"
					+ user.getUser_password() + "'";
			ResultSet rs = db.getData(sql);
			while (rs.next()) {
				// database value
				user_name_db = rs.getString("user_name");
				user_password_db = rs.getString("user_password");
				if (user_name_db.equals(user.getUser_name()) && user_password_db.equals(user.getUser_password())) {
					System.out.println("true");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("false");
		return false;
	}

	public String logType = null;

	public static String getUserType(User user) {
		String user_type_db = "";
		try {
			String selectUsertypeSql = "SELECT tbl_account_type.type_name FROM tbl_account_type Inner Join tbl_user ON tbl_account_type.type_id = tbl_user.type_id where  user_name='"
					+ user.getUser_name() + "'";
			ResultSet rs = db.getData(selectUsertypeSql);
			while (rs.next()) {
				user_type_db = rs.getString("type_name");
				System.out.println("type = " + user_type_db);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro in gettype...");

		}

		return user_type_db;

	}

	public String getPage(String userType) {

		if (userType.equals("admin")) {
			return "DashBoard.jsp";
		}
		if (userType.equals("docter")) {
			return "DashBoardDocter.jsp";
		}
		if (userType.equals("patient")) {
			return "DashBoardPatient.jsp";
		}
		if (userType.equals("reception")) {
			return "DashBoardReception.jsp";
		}
		return "index.jsp";

	}
}
