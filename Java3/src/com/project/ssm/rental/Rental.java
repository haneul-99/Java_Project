package com.project.ssm.rental;

import java.util.Calendar;

/**
 * 시설 대여 클래스입니다.
 * @author yangha-eun
 *
 */
public class Rental {
	
	private String date;
	private String time;
	private String facility;
	private String reserve;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	


}
