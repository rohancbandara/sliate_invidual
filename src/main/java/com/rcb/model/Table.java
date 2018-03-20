package com.rcb.model;

public class Table {

	private String tbl_id;
	private int d_id;
	private String date;
	private int from;
	private int to;
	private String d_fname;
	private String d_lname;
	private int d_special;
	private String sp_name;

	public String getTbl_id() {
		return tbl_id;
	}

	public void setTbl_id(String tbl_id) {
		this.tbl_id = tbl_id;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getD_fname() {
		return d_fname;
	}

	public void setD_fname(String d_fname) {
		this.d_fname = d_fname;
	}

	public String getD_lname() {
		return d_lname;
	}

	public void setD_lname(String d_lname) {
		this.d_lname = d_lname;
	}

	public int getD_special() {
		return d_special;
	}

	public void setD_special(int d_special) {
		this.d_special = d_special;
	}

	public String getSp_name() {
		return sp_name;
	}

	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}

}
