package kr.or.ddit.bnb.admin.vo;

public class PickBuyerVO {
	private String mem_id    ;
	private String mem_name  ;
	private String mem_pass  ;
	private String mem_email ;
	private String mem_tel   ;
	private String mem_addr  ;
	private String mem_birth ;
	private String mem_hint  ;
	private String mem_ans   ;
	private String mem_join  ;
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_hint() {
		return mem_hint;
	}
	public void setMem_hint(String mem_hint) {
		this.mem_hint = mem_hint;
	}
	public String getMem_ans() {
		return mem_ans;
	}
	public void setMem_ans(String mem_ans) {
		this.mem_ans = mem_ans;
	}
	public String getMem_join() {
		return mem_join;
	}
	public void setMem_join(String mem_join) {
		this.mem_join = mem_join;
	}
	
	@Override
	public String toString() {
		return "PickBuyerVO [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pass=" + mem_pass + ", mem_email="
				+ mem_email + ", mem_tel=" + mem_tel + ", mem_addr=" + mem_addr + ", mem_birth=" + mem_birth
				+ ", mem_hint=" + mem_hint + ", mem_ans=" + mem_ans + ", mem_join=" + mem_join + "]";
	}
	
	


}
