package com.rcb.model;

public class Docter {
	private int d_id;
	private String d_FName;
	private String d_LName;
	private String d_dob;
	private String d_email;
	private int d_special;
	private String d_specileName;
	private String create_date;
	private int is_delete;

	public String getD_specileName() {
		return d_specileName;
	}

	public void setD_specileName(String d_specileName) {
		this.d_specileName = d_specileName;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public int getD_special() {
		return d_special;
	}

	public void setD_special(int d_special) {
		this.d_special = d_special;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public String getD_email() {
		return d_email;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_FName() {
		return d_FName;
	}

	public void setD_FName(String d_FName) {
		this.d_FName = d_FName;
	}

	public String getD_LName() {
		return d_LName;
	}

	public void setD_LName(String d_LName) {
		this.d_LName = d_LName;
	}

	public String getD_dob() {
		return d_dob;
	}

	public void setD_dob(String d_dob) {
		this.d_dob = d_dob;
	}

	public String toString() {
		return "Docter [userid=" + d_id + ", d_FName=" + d_FName + ", d_LName=" + d_LName + ", d_dob=" + d_dob
				+ ", d_email=" + d_email + "]";
	}

}
