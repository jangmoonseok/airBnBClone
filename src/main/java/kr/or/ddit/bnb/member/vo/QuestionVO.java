package kr.or.ddit.bnb.member.vo;

public class QuestionVO {
	
	private String ans_id    ;
	private String admin_id  ;
	private String qna_id    ;
	private String ans_con   ;
	private String ans_date  ;
	private String mem_id;
	private String qna_title;
	private String qna_con;
	private String qna_date;
	private String qna_cate;
	public String getAns_id() {
		return ans_id;
	}
	public void setAns_id(String ans_id) {
		this.ans_id = ans_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getQna_id() {
		return qna_id;
	}
	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}
	public String getAns_con() {
		return ans_con;
	}
	public void setAns_con(String ans_con) {
		this.ans_con = ans_con;
	}
	public String getAns_date() {
		return ans_date;
	}
	public void setAns_date(String ans_date) {
		this.ans_date = ans_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_con() {
		return qna_con;
	}
	public void setQna_con(String qna_con) {
		this.qna_con = qna_con;
	}
	public String getQna_date() {
		return qna_date;
	}
	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}
	public String getQna_cate() {
		return qna_cate;
	}
	public void setQna_cate(String qna_cate) {
		this.qna_cate = qna_cate;
	}
	@Override
	public String toString() {
		return "QuestionVO [ans_id=" + ans_id + ", admin_id=" + admin_id + ", qna_id=" + qna_id + ", ans_con=" + ans_con
				+ ", ans_date=" + ans_date + ", mem_id=" + mem_id + ", qna_title=" + qna_title + ", qna_con=" + qna_con
				+ ", qna_date=" + qna_date + ", qna_cate=" + qna_cate + "]";
	}
	
	

}
