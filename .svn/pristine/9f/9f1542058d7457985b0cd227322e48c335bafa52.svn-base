package kr.or.ddit.bnb.prod.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.bnb.prod.service.IProdService;
import kr.or.ddit.bnb.prod.service.ProdServiceImpl;
import kr.or.ddit.bnb.prod.vo.ReviewVO;

public class ReviewController {
	private Scanner scan = new Scanner(System.in);
	private IProdService service;
	
	public ReviewController() {
		service = ProdServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new ReviewController().start();
	}

	private void start() {
		while (true) {
			System.out.print("1. 리뷰 조회 >> ");
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1: 
				review(); // 리뷰
				break;
			case 0: // 작업 끝
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
		
	}

	private void review() {
		System.out.print("숙소 아이디 >> ");
		String prodId = scan.next();
		
		List<ReviewVO> revList = new ArrayList<ReviewVO>();
		revList = service.selectRev(prodId);
		
		System.out.println("---------------------------------");
		for(ReviewVO vo: revList) {
			System.out.println("번호 : " + vo.getReview_id());
			System.out.println("작성자 : " + vo.getMem_id());
			System.out.println("제목 : " + vo.getReview_title());
			System.out.print("평점 : ");
			for(int i = 1; i <= vo.getReview_star(); i++) {
				System.out.print("*");
			}
			System.out.println();
			System.out.println("내용 : " + vo.getReview_con());
			System.out.println("작성날짜 : " + vo.getReview_date());
			System.out.println("---------------------------------");
		}
		System.out.print("리뷰번호 입력 >> ");
		String revId = scan.next();
		
		System.out.print("1. 수정  2. 삭제  3. 추가 >> ");
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1: 
			update(revId); 
			break;
		case 2: 
			delete(revId);
			break;
		case 3: 
			insert(prodId);
			break;
		default:
			System.out.println("작업 번호를 잘못 입력했습니다.");
			System.out.println("다시 입력하세요.");
		}			
	}

	private void insert(String prodId) {
		scan.nextLine();
		System.out.print("제목 >> ");
		String title = scan.nextLine();
		
		System.out.print("내용 >> ");
		String con = scan.nextLine();
		
		System.out.print("별점 >> ");
		int star = scan.nextInt();
		
		ReviewVO revVo = new ReviewVO();
		revVo.setProd_id(prodId);
		revVo.setReview_title(title);
		revVo.setReview_con(con);
		revVo.setReview_star(star);
		
		int cnt = service.insertRev(revVo);
		
		if(cnt > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}

	private void delete(String revId) {
		int cnt = service.deleteRev(revId);
		
		if(cnt > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	private void update(String revId) {
		scan.nextLine();
		System.out.print("수정할 제목 >> ");
		String title = scan.nextLine();
		
		System.out.print("수정할 내용 >> ");
		String con = scan.nextLine();
		
		System.out.print("수정할 별점 >> ");
		int star = scan.nextInt();
		
		ReviewVO revVo = new ReviewVO();
		revVo.setReview_id(revId);
		revVo.setReview_title(title);
		revVo.setReview_con(con);
		revVo.setReview_star(star);
		
		int cnt = service.updateRev(revVo);

		if(cnt > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}	
	}

}
