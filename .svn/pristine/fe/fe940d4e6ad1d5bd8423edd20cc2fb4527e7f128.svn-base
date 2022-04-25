package kr.or.ddit.bnb.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.bnb.admin.service.NoticeService;
import kr.or.ddit.bnb.admin.service.NoticeServiceImpl;
import kr.or.ddit.bnb.admin.vo.NoticeVO;

public class NoticeController {
	private Scanner scan = new Scanner(System.in);
	private NoticeService service;
	
	public NoticeController() {
		service = NoticeServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new NoticeController().start();
	}

	private void start() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: 
				notice(); // 공지사항
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

	private void notice() { // 공지사항 목록
		List<NoticeVO> noList = new ArrayList<NoticeVO>();
		noList = service.selectNo();
		
		System.out.println("---------------------------------");
		for(NoticeVO vo: noList) {
			System.out.println("번호 : " + vo.getNoti_id());
			System.out.println("제목 : " + vo.getNoti_title());
			System.out.println("날짜 : " + vo.getNoti_date());
			System.out.println("---------------------------------");
		}
		
		System.out.print("1. 상세조회 2. 공지사항 추가 >> ");
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1: 
			detail(); 
			break;
		case 2: 
			insert();
			break;
		default:
			System.out.println("작업 번호를 잘못 입력했습니다.");
			System.out.println("다시 입력하세요.");
		}	
	}

	private void detail() { // 공지사항 상세
		System.out.print("번호 >> ");
		String noId = scan.next();
		
		NoticeVO noVo = new NoticeVO();
		noVo = service.selectDNo(noId);
		
		System.out.println("---------------------------------");
		System.out.println("제목 : " + noVo.getNoti_title());
		System.out.println("내용 : " + noVo.getNoti_con());
		System.out.println("날짜 : " + noVo.getNoti_date());
		System.out.println("---------------------------------");

		System.out.print("1. 수정 2. 삭제 0. 뒤로가기 >> ");
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1: 
			update(noId); 
			break;
		case 2: 
			delete(noId); 
			break;
		case 0: 
			notice(); 
			break;
		default:
			System.out.println("작업 번호를 잘못 입력했습니다.");
			System.out.println("다시 입력하세요.");
		}	
	}

	private void delete(String noId) { // 공지사항 삭제
		
		int cnt = service.deleteNo(noId);
		
		if(cnt > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
	}

	private void update(String noId) { // 수정
		scan.nextLine();
		System.out.print("수정할 제목 >> ");
		String title = scan.nextLine();
		
		System.out.print("수정할 내용 >> ");
		String content = scan.nextLine();
		
		NoticeVO noVo = new NoticeVO();
		noVo.setNoti_id(noId);
		noVo.setNoti_title(title);
		noVo.setNoti_con(content);
		
		int cnt = service.updateNo(noVo);
		
		if(cnt > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}	
	}

	private void insert() { // 추가
		scan.nextLine();
		System.out.print("제목 >> ");
		String title = scan.nextLine();
		
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		NoticeVO noVo = new NoticeVO();
		noVo.setNoti_title(title);
		noVo.setNoti_con(content);
		
		int cnt = service.insertNo(noVo);
		
		if(cnt > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}		
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println(" == 작 업 선 택 ==");
		System.out.println("1. 공지사항");
		System.out.println("---------------------------");
		System.out.print("원하는 작업번호 >> ");
		return scan.nextInt();
	}


}
