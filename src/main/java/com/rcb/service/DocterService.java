package com.rcb.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Docter;
import com.rcb.model.Special;

public class DocterService {
	DbConnection db = new DbConnection();

	// insert Docter details
	public boolean putDocterData(Docter docter) {
		Special special = new Special();
		try {
			String insertDocterSQL = "INSERT INTO tbl_docters(tbl_docters.d_fname,\r\n" + "tbl_docters.d_lname,\r\n"
					+ "tbl_docters.d_dob,\r\n" + "tbl_docters.d_email,\r\n" + "tbl_docters.d_special)VALUES(" + "'"
					+ docter.getD_FName() + "'," + "'" + docter.getD_LName() + "'," + "'" + docter.getD_dob() + "',"
					+ "'" + docter.getD_email() + "'," + "'" + docter.getD_special() + "') ";

			db.putData(insertDocterSQL);

			System.out.println("sucessfully docter Added!!!");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error docter Added!!!");
		}
		return false;
	}

	public int getSpecialId(Special special) {
		String getSpecialSQL = "SELECT sp_id FROM tbl_special WHERE sp_name='" + special.getSp_name() + "' ";
		int sp_idDb = 0;
		try {
			ResultSet rs = db.getData(getSpecialSQL);
			while (rs.next()) {
				sp_idDb = rs.getInt("sp_id");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp_idDb;

	}

	public boolean deleteDocter(int did) {
		try {
			String deleteDocterSql = "DELETE FROM tbl_docters WHERE d_id='" + did + "'";
			db.putData(deleteDocterSql);
			System.out.println("sucessfully delete docter");
			return true;
		} catch (Exception e) {
			System.out.println("error delete docter");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Docter> getAllDocters() {
		ArrayList<Docter> docters = new ArrayList<Docter>();

		try {
			String sql = "SELECT tbl_docters.d_id, tbl_docters.d_fname, tbl_docters.d_lname, tbl_docters.d_dob, tbl_docters.d_email, tbl_docters.d_special, tbl_docters.create_date,tbl_docters.edit_date, tbl_special.sp_name FROM tbl_docters Inner Join tbl_special ON tbl_special.sp_id = tbl_docters.d_special ";

			ResultSet rs = db.getData(sql);
			while (rs.next()) {
				Docter docter = new Docter();

				docter.setD_id(rs.getInt("tbl_docters.d_id"));
				docter.setD_FName(rs.getString("tbl_docters.d_fname"));
				docter.setD_LName(rs.getString("tbl_docters.d_lname"));
				docter.setD_dob(rs.getString("tbl_docters.d_dob"));
				docter.setD_email(rs.getString("tbl_docters.d_email"));
				docter.setD_special(rs.getInt("tbl_docters.d_special"));
				docter.setCreate_date(rs.getString("tbl_docters.create_date"));
				docter.setEdit_date(rs.getString("tbl_docters.edit_date"));
				docter.setD_specileName(rs.getString("tbl_special.sp_name"));
				docters.add(docter);

			}

		} catch (Exception e) {
			System.out.println("getAllDocters()");
			e.printStackTrace();
		}

		return (docters);
	}

	// public static void main(String args[]) {
	// DocterService dc = new DocterService();
	// ArrayList<Docter> doctersList = dc.getAllDocters();
	// String s[] = null;
	// for (int i = 0; i < doctersList.size(); i++) {
	//
	// System.out.println(doctersList.get(i).getD_id());
	// System.out.println(doctersList.get(i).getD_FName());
	// }
	//
	// }
}
