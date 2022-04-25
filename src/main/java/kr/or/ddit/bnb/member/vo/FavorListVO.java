package kr.or.ddit.bnb.member.vo;

import java.util.List;

public class FavorListVO {
	private List<String> img_link;
	private String prod_name;
	private String prod_add1;
	private int prod_price;
	private String prod_id;
	
	//민규 추가
	private String fav_id;
	private String mem_id;
	
	public String getFav_id() {
		return fav_id;
	}
	
	public void setFav_id(String fav_id) {
		this.fav_id = fav_id;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public List<String> getImg_link() {
		return img_link;
	}
	public void setImg_link(List<String> img_link) {
		this.img_link = img_link;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_add1() {
		return prod_add1;
	}
	public void setProd_add1(String prod_add1) {
		this.prod_add1 = prod_add1;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
}
