package kr.or.ddit.bnb.reservation.vo;

import java.util.Date;

public class SchedulVO {
	private String sche_id    ;
	private String prod_id    ;
	private String mem_id     ;
	private String check_in   ;
	private String check_out  ;
	private int sche_price ;
	
	public String getSche_id() {
		return sche_id;
	}
	public void setSche_id(String sche_id) {
		this.sche_id = sche_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public int getSche_price() {
		return sche_price;
	}
	public void setSche_price(int sche_price) {
		this.sche_price = sche_price;
	}

	
	
	
}
