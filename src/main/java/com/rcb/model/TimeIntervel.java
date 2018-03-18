package com.rcb.model;

public class TimeIntervel {
	private String tbl_id;
	private int dId;
	private String date;
	private int intervel;
	private int fromTime;
	private int toTime;

	public String getTbl_id() {
		return tbl_id;
	}

	public void setTbl_id(String tbl_id) {
		this.tbl_id = tbl_id;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIntervel() {
		return intervel;
	}

	public void setIntervel(int intervel) {
		this.intervel = intervel;
	}

	public int getFromTime() {
		return fromTime;
	}

	public void setFromTime(int fromTime) {
		this.fromTime = fromTime;
	}

	public int getToTime() {
		return toTime;
	}

	public void setToTime(int toTime) {
		this.toTime = toTime;
	}

}
