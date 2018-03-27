package com.rcb.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Docter;
import com.rcb.model.Special;

public class DocterService {
	private static final Logger LOG = Logger.getLogger(DocterService.class);
	DbConnection db = new DbConnection();

	// insert Docter details
	public boolean putDocterData(Docter docter) {
		Special special = new Special();
		try {
			String insertDocterSQL = "INSERT INTO tbl_docters(tbl_docters.d_fname,\r\n" + "tbl_docters.d_lname,\r\n"
					+ "tbl_docters.d_dob,\r\n" + "tbl_docters.d_email,\r\n" + "tbl_docters.d_special,\r\n "
					+ "tbl_docters.img_path)VALUES(" + "'" + docter.getD_FName() + "'," + "'" + docter.getD_LName()
					+ "'," + "'" + docter.getD_dob() + "'," + "'" + docter.getD_email() + "'," + "'"
					+ docter.getD_special() + "','" + docter.getImg_path() + "') ";

			db.putData(insertDocterSQL);

			System.out.println("sucessfully docter Added!!!");
			LOG.info("Sucessfully Added Docter ! ");
			return true;

		} catch (Exception e) {
			LOG.warn("Exception in  putDocterData(Docter docter)  -> DocterService :", e);
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
			LOG.info("Sucessfully Loaded  Docter " + special + " ! ");

		} catch (Exception e) {
			LOG.warn("Exception in getSpecialId(Special special)  -> DocterService :", e);
		}
		return sp_idDb;

	}

	public boolean deleteDocter(int did) {
		try {
			String deleteDocterSql = "DELETE FROM tbl_docters WHERE d_id='" + did + "'";
			db.putData(deleteDocterSql);
			LOG.info("Sucessfully Delete  Docter " + did + " ! ");
			return true;

		} catch (Exception e) {
			LOG.warn("Exception in deleteDocter(int did)  -> DocterService :", e);
		}
		return false;
	}

	public ArrayList<Docter> getAllDocters() {
		ArrayList<Docter> docters = new ArrayList<Docter>();

		try {
			String sql = "SELECT tbl_docters.d_id,tbl_docters.img_path, tbl_docters.d_fname, tbl_docters.d_lname, tbl_docters.d_dob, tbl_docters.d_email, tbl_docters.d_special, tbl_docters.create_date,tbl_docters.edit_date, tbl_special.sp_name FROM tbl_docters Inner Join tbl_special ON tbl_special.sp_id = tbl_docters.d_special ";

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
				docter.setImg_path(rs.getString("tbl_docters.img_path"));
				docters.add(docter);
				LOG.info("Sucessfully Loaded  Docter " + docter.getD_FName() + " " + docter.getD_LName() + "!" + " "
						+ docter.getImg_path());
			}
			rs.close();
			LOG.info("Sucessfully Completed Load All Docters ! ");

		} catch (Exception e) {
			LOG.warn("Exception in getAllDocters()  -> DocterService :", e);

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
