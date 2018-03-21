package com.rcb.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Patient;

public class PatientService {
	private static final Logger LOG = Logger.getLogger(PatientService.class);
	DbConnection db = new DbConnection();

	public ArrayList<Patient> allPatient() {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		try {
			String sql = "SELECT tbl_patient.p_id, tbl_patient.p_fname, tbl_patient.p_lname, tbl_patient.p_nic, tbl_patient.p_email, tbl_patient.p_gender, tbl_patient.p_dob, tbl_patient.p_blood_group, tbl_patient.p_marital, tbl_patient.p_haddress, tbl_patient.p_tel, tbl_patient.p_status, tbl_patient.is_delete, tbl_patient.create_date FROM tbl_patient ";
			ResultSet rs = db.getData(sql);
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setP_id(rs.getInt("tbl_patient.p_id"));
				patient.setP_fname(rs.getString("tbl_patient.p_fname"));
				patient.setP_lname(rs.getString("tbl_patient.p_lname"));
				patient.setP_nic(rs.getString("tbl_patient.p_nic"));
				patient.setP_email(rs.getString("tbl_patient.p_email"));
				patient.setP_gender(rs.getString("tbl_patient.p_gender"));
				patient.setP_dob(rs.getString("tbl_patient.p_dob"));
				patient.setP_blood(rs.getString("tbl_patient.p_blood_group"));
				patient.setP_marital(rs.getString("tbl_patient.p_marital"));
				patient.setP_haddress(rs.getString("tbl_patient.p_haddress"));
				patient.setP_tel(rs.getString("tbl_patient.p_tel"));
				patient.setP_status(rs.getString("tbl_patient.p_status"));
				patient.setId_delete(rs.getInt("tbl_patient.is_delete"));
				patient.setP_cDate(rs.getString("tbl_patient.create_date"));
				patients.add(patient);
				LOG.info("Sucessfully Loaded  Docter " + patient.getP_id() + " " + patient.getP_fname() + "  "
						+ patient.getP_lname() + "!");
			}
			LOG.info("Sucessfully Completed Load All Patients ! ");

		} catch (Exception e) {
			LOG.warn("Exception in getAllDocters()  -> DocterService :", e);

		}
		return (patients);
	}

}
