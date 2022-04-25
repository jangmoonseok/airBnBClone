package kr.or.ddit.bnb.member.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.bnb.member.service.IQnAService;
import kr.or.ddit.bnb.member.service.QnAServiceImpl;
import kr.or.ddit.bnb.member.vo.QuestionVO;

public class QnA {
	private Scanner scan = new Scanner(System.in);
	
	private IQnAService service;
	private String sysdate;
	
	public QnA() {
		service = QnAServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new QnA().start();
	}
	
	private int displayMenu() {
		//회원용 게시판 조회
		System.out.println("1. 회원용 게시판 조회");
		//회원용 게시판 작성
		System.out.println("2. 회원용 게시판 작성");
		//게시판 상세보기
		System.out.println("3. 게시판 상세보기");
		
		//예약 카테고리
		System.out.println("4. 예약 카테고리");
		
		return scan.nextInt();
		
	}
	public void start() {
		int choice = displayMenu();
		switch(choice) {
		case 1:
			QuestionList(); break;
		case 2:
			WriteQuestion(); break;
		case 3:
			SeeQuestion(); break;
		case 4:
			Q_Reser(); break;	
	}
}

	private void Q_Reser() {
		scan.nextLine();	
		
		System.out.print("카테고리 >> ");
		String qna_cate = scan.nextLine();
		
		List<QuestionVO> qna = service.QuestionCate(qna_cate);
		// 입력한 정보로 검색한 내용을 출력하기
		System.out.println();
		System.out.println("--------------------------------------");						
		System.out.println(qna.toString());		
		System.out.println("--------------------------------------");
		
	}

	private void SeeQuestion() {
		scan.nextLine();	
		
		System.out.print("QNA_ID >> ");
		String qnaId = scan.nextLine();
		
//		QuestionVO qna = service.SeeQuestion(qnaId);
		// 입력한 정보로 검색한 내용을 출력하기
		System.out.println();
		System.out.println("--------------------------------------");						
//		System.out.println(qna.toString());		
		System.out.println("--------------------------------------");
	
	}

	private void WriteQuestion() {
		scan.nextLine(); // 버퍼 비우기
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		
		System.out.print("- 작성자 : ");
		String writer = scan.nextLine();
		
		System.out.print("- 제 목 : ");
		String title = scan.nextLine();
		
		System.out.print("- 내 용 : ");
		String content = scan.nextLine();
		
		System.out.print("- 카 테 고 리 : ");
		String category = scan.nextLine();
		
		QuestionVO qnaVo = new QuestionVO();
		
		qnaVo.setMem_id(writer);
		qnaVo.setQna_title(title);
		qnaVo.setQna_con(content);
		qnaVo.setQna_cate(category);
	
		int cnt = service.insertQuestion(qnaVo);
		
		if(cnt>0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글 추가 실패!!!");
		}

	}

	private void QuestionList() {
		
		List<QuestionVO> Question = service.MemQuestionList();
		
		System.out.println();
		System.out.println("------------------------");
		
		if(Question==null || Question.size()==0) {
			System.out.println("없음");
		}else {
			for(QuestionVO qnaVo:Question) {
				System.out.println(qnaVo.getQna_id()+"\t"+qnaVo.getQna_title()+"\t"
						+qnaVo.getMem_id()+"\t"+qnaVo.getQna_date()+"\t"+qnaVo.getQna_con()+
						"\t"+qnaVo.getQna_cate());
			}
		}
	
	}
}
