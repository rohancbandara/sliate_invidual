package com.rcb.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Appinment;
import com.rcb.model.Table;
import com.rcb.model.TimeIntervel;

public class AppoinmentService {
	private static final Logger LOG = Logger.getLogger(AppoinmentService.class);

	public static boolean createTable(TimeIntervel tI) {
		DbConnection db = new DbConnection();
		try {
			String sql = "INSERT INTO tbl_tables values('" + tI.getTbl_id() + "','" + tI.getdId() + "','" + tI.getDate()
					+ "','" + tI.getFromTime() + "','" + tI.getToTime() + "','" + tI.getIntervel() + "')";
			db.putData(sql);

			LOG.info("Sucessfully Created intavels table !");
			return true;
		} catch (Exception e) {

			LOG.warn("Exception in  createTable(TimeIntervel tI)  -> CreateTimeIntervelService :" + e);

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
							+ "','" + intervels + "','" + 1 + "','" + null + "') ";
					db.putData(sql);

					LOG.info("sucessfully Created Time Intervels");
				} catch (Exception e) {
					LOG.warn("Exception in  intervals(TimeIntervel tI)  -> CreateTimeIntervelService :" + e);
					e.printStackTrace();
				}

			}
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<Appinment> getAllAppoinment(String tblId) {
		ArrayList<Appinment> appinments = new ArrayList<Appinment>();
		DbConnection db = new DbConnection();
		try {
			String sql = "SELECT tbl_special.sp_name, tbl_docters.d_fname, tbl_docters.d_lname, tbl_tables.tbl_id, tbl_tables.`date`, tbl_tables.`from`, tbl_tables.`to`, tbl_appoinment.id, tbl_appoinment.dsp, tbl_appoinment.patient, tbl_tables.d_id, tbl_appoinment.intervels, tbl_patient.p_fname, tbl_patient.p_lname FROM tbl_tables Inner Join tbl_docters ON tbl_docters.d_id = tbl_tables.d_id Inner Join tbl_special ON tbl_special.sp_id = tbl_docters.d_special Inner Join tbl_appoinment ON tbl_appoinment.tbl_id = tbl_tables.tbl_id Inner Join tbl_patient ON tbl_appoinment.patient = tbl_patient.p_id  where tbl_appoinment.tbl_id ='"
					+ tblId + "'";
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
				appoinment.setP_id(rs.getInt("tbl_appoinment.patient"));
				appoinment.setD_id(rs.getInt("tbl_tables.d_id"));
				appoinment.setIntavel(rs.getString("tbl_appoinment.intervels"));
				appoinment.setP_fname(rs.getString("tbl_patient.p_fname"));
				appoinment.setP_lname(rs.getString("tbl_patient.p_lname"));

				appinments.add(appoinment);
				LOG.info("Sucessfully Loaded  Appoinment " + appoinment.getD_id() + " ! ");

			}
			LOG.info("Sucessfully Completed Load All Appoinments ! ");

		} catch (Exception e) {
			LOG.warn("Exception in  getAllAppoinment()  -> CreateTimeIntervelService :" + e);
		}

		return (appinments);
	}

	public ArrayList<Table> getAllTable() {
		ArrayList<Table> tables = new ArrayList<Table>();
		DbConnection db = new DbConnection();
		try {
			String sql = "SELECT tbl_tables.tbl_id, tbl_tables.d_id, tbl_tables.date, tbl_tables.from, tbl_tables.to, tbl_docters.d_fname, tbl_docters.d_lname, tbl_docters.d_special, tbl_special.sp_name FROM tbl_tables Inner Join tbl_docters ON tbl_docters.d_id = tbl_tables.d_id Inner Join tbl_special ON tbl_special.sp_id = tbl_docters.d_special  ";
			ResultSet rs = db.getData(sql);
			while (rs.next()) {

				Table table = new Table();

				table.setTbl_id(rs.getString("tbl_tables.tbl_id"));
				table.setD_id(rs.getInt("tbl_tables.d_id"));
				table.setDate(rs.getString("tbl_tables.date"));
				table.setFrom(rs.getInt("tbl_tables.from") / 60);
				table.setTo(rs.getInt("tbl_tables.to") / 60);
				table.setD_fname(rs.getString("tbl_docters.d_fname"));
				table.setD_lname(rs.getString("tbl_docters.d_lname"));
				table.setD_special(rs.getInt("tbl_docters.d_special"));
				table.setSp_name(rs.getString("tbl_special.sp_name"));

				tables.add(table);

				LOG.info("Sucessfully Loaded  Tables " + table.getTbl_id() + " ! ");

			}
			LOG.info("Sucessfully Completed Load All Tables ! ");

		} catch (Exception e) {
			LOG.warn("Exception in  getAllTable()  -> CreateTimeIntervelService :" + e);
		}

		return (tables);
	}

	public boolean setPatient(Appinment appoinment) {
		DbConnection db = new DbConnection();
		try {
			String sql = "UPDATE  tbl_appoinment set patient='" + appoinment.getP_id() + "' WHERE id='"
					+ appoinment.getId() + "'";
			db.putData(sql);

			LOG.info("Sucessfully Added Patient to Appoinment !");
			return true;
		} catch (Exception e) {

			LOG.warn("Exception in  setPatient(Appinment appoinment)  -> AppoinmentService :" + e);

		}

		return false;
	}

	// public static void main(String args[]) {
	// CreateTimeIntervelService cc = new CreateTimeIntervelService();
	// ArrayList<Appinment> appoimentList = cc.getAllAppoinment("2018-03-24");
	//
	// for (int i = 0; i < appoimentList.size(); i++) {
	//
	// System.out.println(appoimentList.get(i).getIntavel());
	// System.out.println(appoimentList.get(i).getP_fname());
	// }
	//
	// }

}
