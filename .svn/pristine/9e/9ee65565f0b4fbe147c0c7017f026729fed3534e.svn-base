package kr.or.ddit.bnb.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.bnb.admin.vo.NoticeVO;
import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.FavorListVO;
import kr.or.ddit.bnb.member.vo.MemberVO;
import kr.or.ddit.bnb.member.vo.ReserDetailVO;
import kr.or.ddit.bnb.member.vo.ReserListVO;

public class memberController {
	private Scanner scan = new Scanner(System.in);
	private IMemberService service;
	
	public memberController() {
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new memberController().startMember();
	}

	private void startMember() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: 
				join(); // 회원가입, 아이디 중복체크
				break;
			case 2: 
				login(); // 로그인
				break;
			case 3:  
				findid(); // 아이디 찾기
				break;
			case 4: 
				findpass(); // 비번 찾기
				break;
			case 5: 
				selectMem(); // 마이페이지/회원정보조회
				break;	
			case 6:
				updateMem(); // 마이페이지/회원정보수정
				break;
			case 7: 
				deleteMem(); // 마이페이지/회원탈퇴
				break;
			case 8: 
				selectRes(); // 마이페이지/예약내역 목록조회 -> 상세
				break;
			case 9: 
				selectFav(); // 마이페이지/찜 목록조회 -> 삭제
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

	private void selectFav() { // 찜 목록 조회
		System.out.print("아이디 >> ");
		String memId = scan.next();
		
		List<FavorListVO> favList = new ArrayList<FavorListVO>();
		favList = service.favorList(memId);
		
		System.out.println("---------------------------------");
		for(FavorListVO vo: favList) {
			System.out.println("상품아이디 : " + vo.getProd_id());
			System.out.println("숙소사진 : " + vo.getImg_link());
			System.out.println("숙소이름 : " + vo.getProd_name());
			System.out.println("주소 : " + vo.getProd_add1());
			System.out.println("가격 : " + vo.getProd_price());
			System.out.println("---------------------------------");
		}
		
		System.out.print("1. 찜 삭제 >> ");
		int choice = scan.nextInt();
		
		if(choice == 1) {	
			deleteFav(memId);	
		}
	}

	private void deleteFav(String memId) { // 찜 삭제
		
		System.out.print("상품아이디 >> ");
		String prodId = scan.next();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", memId);
		map.put("prod_id", prodId);
		
		int cnt = service.deleteFavor(map);
		
		if(cnt > 0) {
			System.out.println("찜 삭제 성공");
		} else {
			System.out.println("찜 삭제 실패");
		}
	}

	private void selectRes() { // 예약 내역 목록 조회
		System.out.print("아이디 >> ");
		String memId = scan.next();
		
		List<ReserListVO> resLvo = new ArrayList<ReserListVO>();
		resLvo = service.reserList(memId);
		
		System.out.println("---------------------------------");
		for(ReserListVO vo: resLvo) {
			System.out.println("숙소사진 : " + vo.getImg_link());
			System.out.println("예약아이디 : " + vo.getReser_id());
			System.out.println("숙소이름 : " + vo.getProd_name());
			System.out.println("주소 : " + vo.getProd_add1());
			System.out.println("체크인 : " + vo.getCheck_in());
			System.out.println("체크아웃 : " + vo.getCheck_out());
			System.out.println("---------------------------------");
		}
		
		selectResD(memId);
	}
	
	private void selectResD(String memId) { // 예약 내역 상세
		System.out.print("예약아이디 >> ");
		String resId = scan.next();
		
		Map<String, Object> resmap = new HashMap<String, Object>();
		resmap.put("mem_id", memId);
		resmap.put("reser_id", resId);
		
		ReserDetailVO resvo = new ReserDetailVO();
		resvo = service.reserDetail(resmap);
		
		System.out.println("숙소상태 : " + resvo.getReser_stat());
		System.out.println("예약한 날짜 : " + resvo.getReser_date());
		System.out.println("숙소사진 : " + resvo.getImg_link());
		System.out.println("숙소명 : " + resvo.getProd_name());
		System.out.println("호스트아이디 : " + resvo.getHost_id());
		System.out.println("숙소주소 : " + resvo.getProd_add1() + resvo.getProd_add2());
		System.out.println("체크인 날짜 : " + resvo.getCheck_in());
		System.out.println("체크아웃 날짜 : " + resvo.getCheck_out());
		System.out.println("인원 : " + resvo.getReser_per());
		System.out.println("요청사항 : " + resvo.getReser_req());
		System.out.println("숙소금액 : " + resvo.getReser_price());	
		
		System.out.print("1. 예약 수정   2. 예약 취소");
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1: updateResD(resId); break;
		case 2: deleteResD(resId); break;
		}		
	}
	
	private void updateResD(String resId) { // 예약 내역 수정
		// TODO Auto-generated method stub
		
	}

	private void deleteResD(String resId) { // 예약 취소 --> 상태가 '결제전' 일때만 reser테이블에서 삭제
		Map<String, Object> resmap = new HashMap<String, Object>();
		
		resmap.put("reser_id", resId);
		
		int cnt = service.deleteReser(resmap);
		
		if(cnt > 0) {
			System.out.println("예약 취소 완료");
		} else {
			System.out.println("예약 취소 실패");
		}
	}

	private void updateMem() { // 회원정보수정
		System.out.print("아이디 >> ");
		String memId = scan.next();
		
		System.out.print("비번 >> ");
		String memPass = scan.next();
		
		System.out.print("이메일 >> ");
		String memMail = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		System.out.print("주소 >> ");
		String memAddr = scan.next();
		
		System.out.print("힌트 >> ");
		String memHint = scan.next();
		
		System.out.print("정답 >> ");
		String memAns = scan.next();
		
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(memId);
		memVO.setMem_pass(memPass);
		memVO.setMem_email(memMail);
		memVO.setMem_tel(memTel);
		memVO.setMem_addr(memAddr);
		memVO.setMem_hint(memHint);
		memVO.setMem_ans(memAns);
				
		int cnt = service.updateMember(memVO);
		
		if(cnt > 0) {
			System.out.println("회원정보 수정 완료");
		} else {
			System.out.println("회원정보 수정 실패");
		}
		
	}

	private void deleteMem() { // 회원 탈퇴
		System.out.print("아이디 >> ");
		String memId = scan.next();
		
		int cnt = service.deleteMember(memId);
		
		if(cnt > 0) {
			System.out.println("회원 탈퇴 완료");
		} else {
			System.out.println("회원 탈퇴 실패");
		}
		
	}

	private void selectMem() { // 회원정보조회
		System.out.print("아이디 >> ");
		String memId = scan.next();
		
		MemberVO memVO = service.getMemberList(memId);
		
		System.out.println("이름 : " + memVO.getMem_name());
		System.out.println("이메일 : " + memVO.getMem_email());
		System.out.println("전화번호 : " + memVO.getMem_tel());
		System.out.println("주소 : " + memVO.getMem_addr());
		System.out.println("생년월일 : " + memVO.getMem_birth());
		
	}

	private void findpass() { // 비밀번호 찾기
		System.out.print("아이디 >> ");
		String memId = scan.next();
		
		System.out.print("이름 >> ");
		String memName = scan.next();
		
		System.out.print("힌트질문 >> ");
		String memHint = scan.next();
		
		System.out.print("답변 >> ");
		String memAns= scan.next();
		
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(memId);
		memVO.setMem_name(memName);
		memVO.setMem_hint(memHint);
		memVO.setMem_ans(memAns);
		
		memVO = service.findPass(memVO);
		
		//System.out.println(memVO.getMem_pass());
		
		if (memVO.getMem_pass() != null) {
			System.out.println("정보 일치 확인");
			
			System.out.print("새로 설정할 비번 >> ");
			String memPass = scan.next();
			
			int cnt = service.updatePass(memVO);
			
			if(cnt > 0) {
				System.out.println("비밀번호 변경 완료");
			} else {
				System.out.println("비밀번호 변경 실패");
			}
			
		} else if(memVO.getMem_pass() == null){
			System.out.println("정보 불일치");
		}
	}

	private void findid() { // 아이디 찾기
		String findId = null;
		
		do {
		System.out.print("이름 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		MemberVO memVO = new MemberVO();
		memVO.setMem_name(memName);
		memVO.setMem_tel(memTel);
		
		findId = service.findId(memVO);
		
		if(findId != null) {
			System.out.println(findId);
		} else {
			System.out.println("일치하는 정보가 없습니다.");
		}
		
		} while(findId == null);	
	}

	private void login() { // 로그인
		System.out.print("ID >> ");
		String memId = scan.next();

		System.out.print("비밀번호 >> ");
		String memPass = scan.next();

		MemberVO memVO = new MemberVO();
		MemberVO memVO2 = new MemberVO();
		
		memVO.setMem_id(memId);
		memVO.setMem_pass(memPass);

		memVO2 = service.getMember(memVO);

		if (memVO2.getMem_addr() == null) {
			System.out.println("다시 로그인해주세요.");
		} else {
			System.out.println("로그인 완료!!");
		}
	}

	private void join() { // 회원가입
		int cnt = 0;
		String memId = null;
		
		do {
			System.out.print("ID >> ");
			memId = scan.next();
			
			cnt = service.idCheck(memId);
			
			if(cnt == 1) {
				System.out.println("이미 등록된 아이디 입니다.");
				System.out.println("다시 입력해주세요.");
			} else if(cnt == 0) {
				System.out.println("아이디 중복 체크 완료");
			}
			
		} while(cnt == 1);
		
		System.out.print("이름 >> ");
		String memName = scan.next();
		
		System.out.print("비밀번호 >> ");
		String memPass = scan.next();
		
		System.out.print("이메일 >> ");
		String memMail = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		System.out.print("주소 >> ");
		String memAddr = scan.next();
		
		System.out.print("생년월일 >> ");
		String memBirth = scan.next();
		
		System.out.print("힌트질문 >> ");
		String memHint = scan.next();

		System.out.print("힌트정답 >> ");
		String memAns = scan.next();
		
		MemberVO memVO = new MemberVO();
		
		memVO.setMem_id(memId);
		memVO.setMem_name(memName);
		memVO.setMem_pass(memPass);
		memVO.setMem_email(memMail);
		memVO.setMem_tel(memTel);
		memVO.setMem_addr(memAddr);
		memVO.setMem_birth(memBirth);
		memVO.setMem_hint(memHint);
		memVO.setMem_hint(memHint);
		memVO.setMem_ans(memAns);
		
		service.insertMember(memVO);			
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println(" == 작 업 선 택 ==");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비번찾기");
		System.out.println("5. 회원정보조회");
		System.out.println("6. 회원정보수정");
		System.out.println("7. 회원탈퇴");
		System.out.println("8. 예약내역조회");
		System.out.println("9. 찜목록조회");
		System.out.println("---------------------------");
		System.out.print("원하는 작업번호 >> ");
		return scan.nextInt();
	}

}
