package kr.or.ddit.bnb.admin.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.bnb.admin.service.IManagementService;
import kr.or.ddit.bnb.admin.service.IQnAansService;
import kr.or.ddit.bnb.admin.service.IviewRoomService;
import kr.or.ddit.bnb.admin.service.ManagementService;
import kr.or.ddit.bnb.admin.service.QnAansService;
import kr.or.ddit.bnb.admin.service.viewRoomService;
import kr.or.ddit.bnb.admin.vo.BuyerVO;
import kr.or.ddit.bnb.admin.vo.HostVO;
import kr.or.ddit.bnb.admin.vo.PickBuyerVO;
import kr.or.ddit.bnb.admin.vo.PickHostVO;
import kr.or.ddit.bnb.admin.vo.PickRoomVO;
import kr.or.ddit.bnb.admin.vo.QNAVO;
import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;
import kr.or.ddit.bnb.admin.vo.RoomVO;

public class RoomviewController {

	private Scanner scan = new Scanner(System.in);
	private IviewRoomService service;
	private IManagementService service1;
	private IQnAansService service2;
	private String sysdate;
	
	public RoomviewController() {
		service = viewRoomService.getInstance();
		service1 = ManagementService.getInstance();
		service2 = QnAansService.getInstance();
		
	}
	
	public static void main(String[] args) {
		new RoomviewController().start();
	}
	private int displayMenu() {
		System.out.println(" == 작 업 선 택 ==");
		System.out.println(" 1. 숙소조회 V");
		System.out.println(" 2. 숙소삭제 V");
		System.out.println();
		System.out.println(" 3. 호스트리스트 V");
		System.out.println(" 4. 호스트 선택 V");

		System.out.println();
		System.out.println(" 6. 구매자리스트 V");
		System.out.println(" 7. 구매자선택 V");

		System.out.println(" 9. 등록요청된 숙소리스트 V");
		System.out.println(" 10. 숙소 등록승인 V");
		System.out.println(" 11. 숙소 등록거절 V");
		System.out.println();
		System.out.println(" 12. QnA목록 V");
		System.out.println("13. 답변작성 V");
		System.out.println("14 QnA삭제 V");
		System.out.println();
		System.out.println("15 회원용 게시판 조회 V");
		System.out.println("16 회원용 게시판 작성 V");

		System.out.println();
		System.out.print("원하는 작업번호 >> ");
		return scan.nextInt();
	}

	public void start() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1: //숙소 조회
					viewRoom(); break;
				case 2://숙소 삭제
					deleteRoom(); break;
					
				case 3://호스트 정보조회리스트
					managehost(); break;
				case 4:
					managehostpick(); break;
		
					
				case 6:
					managebuyer(); break;
				case 7:
					managebuyerpick(); break;
				
				case 9:
					waitingRoom(); break;
				case 10:
					permissionRoom(); break;
				case 11:
					denyRoom(); break;
					
				case 12:
					QuestionList(); break;
				case 13:
					Answer(); break;
				case 14:
					deleteQuestion(); break;
						
				case 15:
					memberQuestionList(); break;
				case 16:
					memberQuestionWrite(); break;
				case 0:
					room(); break;
				case 30:
					SeeQuestion(); break;	
			}
		}
	}


	

	private void room() {
		
		scan.nextLine();	
		System.out.println();
		
		System.out.print("방번호 >> ");
		String prodId = scan.nextLine();
				//.trim();

		PickRoomVO roomVo = new PickRoomVO();
		roomVo.setProd_id(prodId);
		
		List<PickRoomVO> room = service.room(prodId);
		
		// 입력한 정보로 검색한 내용을 출력하기
		System.out.println();
		System.out.println("--------------------------------------");
			
		for(PickRoomVO roomVO : room) {		
			System.out.println(roomVO.getImg_link()+ "\t" + roomVO.getProd_id() + "\t"
					+ roomVO.getProd_type()+ "\t\t" + roomVO.getProd_part() +"\t"+
					roomVo.getProd_add1()+"\t"+roomVo.getProd_add2()+"\t"+
					roomVo.getProd_name()+"\t"+roomVo.getProd_des()+"\t"+
					roomVo.getProd_per()+"\t"+roomVo.getProd_date()+"\t"+
					roomVo.getProd_price()+"\t"+roomVo.getHost_id()
					);
		}
		
		System.out.println("--------------------------------------");
	
	}

	private void memberQuestionWrite() { //회원용
		
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
		
		QNAVO qnaVo = new QNAVO();
		
		qnaVo.setMem_id(writer);
		qnaVo.setQna_title(title);
		qnaVo.setQna_con(content);
		
		
		int cnt = service2.insertQuestion(qnaVo);
		
		if(cnt>0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글 추가 실패!!!");
		}
		
		
	}

	private void deleteQuestion() {
		scan.nextLine();
		System.out.print("삭제할 qna ID를 입력하세요> ");
		String qna_id = scan.nextLine();
		
		int qna = service2.deleteQuestion(qna_id);
		
		if(qna>0) {
			System.out.println(qna_id+"삭제 성공");
		}else {
			System.out.println(qna_id+"삭제 실패");
		}
	}

	private void denyRoom() {
		System.out.print("등록거절할 숙소 ID를 입력하세요> ");
		String prod_id = scan.next();
		
		int host = service.deleteRoom(prod_id);
		
		if(host>0) {
			System.out.println(prod_id+"삭제 성공");
		}else {
			System.out.println(prod_id+"삭제 실패");
		}
		
	}

	private void permissionRoom() {
		System.out.print("등록승인할 숙소 ID를 입력하세요> ");
		String prod_id = scan.next();
		
		int permission = service.permissionRoom(prod_id);
		
		if(permission>0) {
			System.out.println(prod_id+"승인 성공");
		}else {
			System.out.println(prod_id+"승인 실패");
		}
		
	}


	private void deleteRoom() {
		System.out.println();
		System.out.println("삭제할 정보를 입력하세요.");
		System.out.print("삭제할 숙소ID >> ");
		String prod_id = scan.next();
		
		int room = service.deleteRoom(prod_id);
		if(room>0) {
			System.out.println(prod_id + "삭제 성공");
		}else {
			System.out.println(prod_id + "삭제 실패");
		}
		
	}
	
	private void memberQuestionList() { 
		
		List<QNAVO> QuestionList = service2.QuestionList();
		
		System.out.println();
		System.out.println("------------------------");
		
		if(QuestionList==null || QuestionList.size()==0) {
			System.out.println("없음");
		}else {
			for(QNAVO qnaVo:QuestionList) {
				System.out.println(qnaVo.getQna_id()+"\t"+qnaVo.getQna_title()+"\t"
						+qnaVo.getMem_id()+"\t"+qnaVo.getQna_date());
			}
		}
	
	}
	
	
	private void managehostpick() {	
		scan.nextLine();
		
		System.out.print("호스트ID >> ");
		String hostId = scan.nextLine();

		List<PickHostVO> hostList = service1.getHost(hostId);
		
		// 입력한 정보로 검색한 내용을 출력하기
		
		System.out.println("--------------------------------------");
		for(PickHostVO hostVo : hostList) {		
			System.out.println(hostVo.getMem_id()+ "\t" + hostVo.getHost_id() + "\t"
					+ hostVo.getHost_des()+ "\t\t" + hostVo.getHost_date());
		}
		System.out.println();		
		System.out.println("--------------------------------------");
		
	}
	
	private void SeeQuestion() {
		scan.nextLine();	
		
		System.out.print("QNA_ID >> ");
		String qnaId = scan.nextLine();
		
		List<QNA_ANSVO> qna = service2.SeeQuestion(qnaId);
		
		// 입력한 정보로 검색한 내용을 출력하기
		System.out.println();
		System.out.println("--------------------------------------");
				
		for(QNA_ANSVO qnaVo : qna) {		
			System.out.println(qnaVo.getQna_id()+ "\t" + qnaVo.getMem_id() + "\t"
			+ qnaVo.getQna_title()+ "\t" + qnaVo.getQna_con()+"\t"+
					qnaVo.getQna_date()+"\t"+qnaVo.getAdmin_id()+"\t"+
					qnaVo.getAns_con()+"\t"+qnaVo.getAns_date());
		}			
		System.out.println("--------------------------------------");
	}
	
	private void managebuyerpick() {		
		scan.nextLine();	
		System.out.print("회원ID >> ");
		String memId = scan.nextLine();

		List<PickBuyerVO> buyerList = service1.getbuyer(memId);
		
		// 입력한 정보로 검색한 내용을 출력하기
		System.out.println();
		System.out.println("--------------------------------------");
	
		for(PickBuyerVO buyerVo1 : buyerList) {		
			System.out.println(buyerVo1.getMem_id()+ "\t" + buyerVo1.getMem_name() + "\t"
					+ buyerVo1.getMem_tel()+ "\t" + buyerVo1.getMem_addr());
		}
		
		System.out.println("--------------------------------------");

	}

	
	private void waitingRoom() {
//		System.out.println();
//		System.out.println("등록요청된 숙소 리스트");
//		
//		List<RoomVO> waitingroomList = service.waitingRoomList();
//		System.out.println();
//		System.out.println("-----------------------------------");
//		if(waitingroomList==null || waitingroomList.size()==0) {
//			System.out.println("없음");
//		}else {
//			for(RoomVO roomVo:waitingroomList) {
//				
//				System.out.println("숙소 ID: "+ roomVo.getProd_id());
//				System.out.println("숙소가격: "+ roomVo.getProd_price());
//				System.out.println("주소: "+ roomVo.getProd_add1());
//				System.out.println("상세주소: "+ roomVo.getProd_add2());
//			}
//		}
	}
	
	private void Answer() {
		System.out.println("답변할 ID를 입력하세요>");
		String qna_Id= scan.next();
		
		System.out.print("답변 >> ");
		String answer = scan.next();
		
		QNA_ANSVO ansVo = new QNA_ANSVO();
		ansVo.setQna_id(qna_Id);
		ansVo.setAns_con(answer);
		
		int cnt = service2.insertAnswer(ansVo);
		
		if(cnt>0) {
			System.out.println("답변성공");
		}else {
			System.out.println("답변실패");
		}
	}

	
	private void QuestionList() {
		List<QNAVO> QuestionList = service2.QuestionList();
		
		System.out.println();
		System.out.println("------------------------");
		
		if(QuestionList==null || QuestionList.size()==0) {
			System.out.println("없음");
		}else {
			for(QNAVO qnaVo:QuestionList) {
				System.out.println(qnaVo.getQna_id()+"\t"+qnaVo.getQna_title()+"\t"
						+qnaVo.getMem_id()+"\t"+qnaVo.getQna_date());			
			}
		}	
	}
	private void managebuyer() {
		List<BuyerVO> buyerList = service1.getBuyerList();

		System.out.println();
		System.out.println("-----------------------------------");
		if(buyerList==null ||buyerList.size()==0) {
			System.out.println("없음");
		}else {
			for(BuyerVO buyerVo:buyerList) {
				
				System.out.println("구매자ID : " + buyerVo.getMem_id());
				System.out.println("구매자 이름 : " + buyerVo.getMem_name());
				System.out.println("숙소ID : " + buyerVo.getProd_id());
				System.out.println("스케줄ID : " + buyerVo.getSche_id());
				System.out.println("체크인 : " + buyerVo.getCheck_in());
				System.out.println("체크아웃 : " + buyerVo.getCheck_out());
				System.out.println();
			}
		}
	}

	private void managehost() {
		List<HostVO> hostList = service1.getHostList();
		
		System.out.println();
		System.out.println("-----------------------------------");
		if(hostList==null ||hostList.size()==0) {
			System.out.println("없음");
		}else {
			for(HostVO hostVo:hostList) {
				System.out.println("호스트 ID :"+hostVo.getHost_id());
				System.out.println("회원 ID :"+hostVo.getMem_id());
				System.out.println("숙소 ID :"+hostVo.getProd_id());
				System.out.println("숙소 등록일 :"+hostVo.getHost_date());
				System.out.println("숙소 설명 :"+hostVo.getHost_des());
				System.out.println("숙소 이름 :"+hostVo.getProd_name());
				System.out.println();				
			}
		}
	}
	
	private void viewRoom() {
		System.out.println();

		List<RoomVO> roomList = service.getRoomList();
		System.out.println();
		System.out.println("-----------------------------------");
		
		if(roomList ==null || roomList.size()==0) {
			System.out.println("없음");
		}else {
			for(RoomVO roomVo : roomList) {
				
				System.out.println("숙소ID "+roomVo.getProd_id());
				System.out.println("가격 "+roomVo.getProd_price());
				System.out.println("숙소주소 "+roomVo.getProd_add1());
				System.out.println("상세주소 "+roomVo.getProd_add2());
				System.out.println();

			}
		}

	}
}
