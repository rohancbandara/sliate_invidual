package com.rcb.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Appinment;
import com.rcb.model.TimeIntervel;

public class CreateTimeIntervelService {

	public static boolean createTable(TimeIntervel tI) {
		DbConnection db = new DbConnection();
		try {
			String sql = "INSERT INTO tbl_tables values('" + tI.getTbl_id() + "','" + tI.getdId() + "','" + tI.getDate()
					+ "','" + tI.getFromTime() + "','" + tI.getToTime() + "','" + tI.getIntervel() + "')";
			db.putData(sql);
			System.out.println("sucess Create!! intavels table");
			return true;
		} catch (Exception e) {
			System.out.println("Error in cretae time createTable()");
			e.printStackTrace();
		}

		return false;
	}

	public static boolean intervals(TimeIntervel tI) {
		DbConnection db = new DbConnection();
		if (tI.getToTime() > tI.getFromTime()) {
			for (int time = tI.getFromTime(); time <= tI.getToTime(); time += tI.getIntervel()) {
				try {
					String intervels = String.format("%02d:%02d", time / 60, time % 60);
					System.out.println(intervels);
					String sql = "INSERT INTO tbl_appoinment(tbl_id,intervels,patient,dsp) values('" + tI.getTbl_id()
							+ "','" + intervels + "','" + 0 + "','" + null + "') ";
					db.putData(sql);
					System.out.println("Sucess create intervels");
				} catch (Exception e) {
					System.out.println("error intervals()");
					e.printStackTrace();
				}

			}
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<Appinment> getAllAppoinment() {
		ArrayList<Appinment> appinments = new ArrayList<Appinment>();
		DbConnection db = new DbConnection();
		try {
			String sql = "SELECT tbl_special.sp_name, tbl_docters.d_fname, tbl_docters.d_lname, tbl_tables.tbl_id, tbl_tables.`date`, tbl_tables.`from`, tbl_tables.`to`, tbl_appoinment.id, tbl_appoinment.dsp, tbl_patient.p_fname, tbl_patient.p_lname, tbl_appoinment.patient, tbl_tables.d_id, tbl_appoinment.intervels FROM tbl_tables Inner Join tbl_docters ON tbl_docters.d_id = tbl_tables.d_id Inner Join tbl_special ON tbl_special.sp_id = tbl_docters.d_special Inner Join tbl_appoinment ON tbl_appoinment.tbl_id = tbl_tables.tbl_id Inner Join tbl_patient ON tbl_appoinment.patient = tbl_patient.p_id ";
			ResultSet rs = db.getData(sql);
			while (rs.next()) {

				Appinment appoinment = new Appinment();

				appoinment.setSp_name(rs.getString("tbl_special.sp_name"));
				appoinment.setD_fname(rs.getString("tbl_docters.d_fname"));
				appoinment.setD_lname(rs.getString("tbl_docters.d_lname"));
				appoinment.setTbl_id(rs.getString("tbl_tables.tbl_id"));
				appoinment.setDate(rs.getString("tbl_tables.date"));
				appoinment.setFrom(rs.getInt("tbl_tables.from") / 60);
				appoinment.setTo(rs.getInt("tbl_tables.to") / 60);
				appoinment.setId(rs.getInt("tbl_appoinment.id"));
				appoinment.setDsp(rs.getString("tbl_appoinment.dsp"));
				appoinment.setP_fname(rs.getString("tbl_patient.p_fname"));
				appoinment.setP_lname(rs.getString("tbl_patient.p_lname"));
				appoinment.setP_id(rs.getInt("tbl_appoinment.patient"));
				appoinment.setD_id(rs.getInt("tbl_tables.d_id"));
				appoinment.setIntavel(rs.getString("tbl_appoinment.intervels"));

				appinments.add(appoinment);

			}

		} catch (Exception e) {
			System.out.println("getAllAppoinment()");
			e.printStackTrace();
		}

		return (appinments);
	}

	public static void main(String args[]) {
		CreateTimeIntervelService cc = new CreateTimeIntervelService();
		ArrayList<Appinment> appoimentList = cc.getAllAppoinment();
		String s[] = null;
		for (int i = 0; i < appoimentList.size(); i++) {

			System.out.println(appoimentList.get(i).getId());
			System.out.println(appoimentList.get(i).getIntavel());
		}

	}

}