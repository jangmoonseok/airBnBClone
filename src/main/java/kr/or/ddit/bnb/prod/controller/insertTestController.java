package kr.or.ddit.bnb.prod.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import kr.or.ddit.bnb.prod.service.IProdService;
import kr.or.ddit.bnb.prod.service.ProdServiceImpl;
import kr.or.ddit.bnb.prod.vo.ProdConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdImgVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;



public class insertTestController {
	

		private Scanner scan=new Scanner(System.in);
	    private IProdService service;
	    
	    //생성자
	    public insertTestController() {
	    	
	    	//service=new MemberServiceImpl();
	    	service=ProdServiceImpl.getInstance();
	    }
		
		//시작 메서드
		private void startMember() {

			while (true) {

				int choice = displayMenu();
				switch (choice) {

				case 1:
					insertMember(); // 추가
					break;
				case 2:
					updateMember(); // 수정
					break;
				
				case 0: // 작업 끝
					System.out.println("작업을 마칩니다.");
					return;

				default:
					System.out.println("번호를 잘못 입력했습니다.");

				}
			}

		}
		
		// 메뉴를 출력하고 선택한 작업번호를 반환하는 메서드
		private int displayMenu() {
			System.out.println();
			System.out.println("==작업 선택==");
			System.out.println("1.자료 추가");
			System.out.println("2.자료 수정");
			System.out.println("3.자료 삭제");
			System.out.println("4.전체 자료 출력");
			System.out.println("5.자료 수정 2");
			System.out.println("0.작업 끝...");
			System.out.println("-----------------------------------");
			System.out.println("원하는 작업번호>>");
			return scan.nextInt();

		}
		
		// 회원 정보를 추가(입력)하는 메서드
			public void insertMember() {

			

				// 자료 추가해서 '회원Id'는 중복되지 않는다.
				// (중복되면 다시 입력받는다.)


				// 회원id가 저장될 변수
                 String prodId=null;
				//String hostid=null;

			
			//	System.out.println("상품 유형(호텔,아파트,주택,게스트하우스,펜션) 입력:");
			//	String prodtype = scan.next();

				
			//	System.out.println("상품 종류(공간전체,호텔객실,개인실,다인실) 입력:");
			//	String prodpart = scan.next();

			
				
				//scan.nextLine();
				 // 입력버퍼 비우기
				//System.out.println("상품 주소 입력:");
				//String prodadd1 = scan.nextLine();

			
				//System.out.println("상품 상세주소 입력:");
				//String prodadd2 = scan.nextLine();

		
				//System.out.println("상품 이름 입력:");
				//String prodname = scan.nextLine();
				
			
				//System.out.println("상품 설명 입력:");
				//String proddes = scan.nextLine();
				
		
				
				
				//System.out.println("인원 입력:");
		       // int per = scan.nextInt();
		        
		    	
				//System.out.println("상품 날짜(등록일시) 입력:");
				//String proddate = scan.next();
		    
				
			
				//System.out.println("가격입력:");
				//int price = scan.nextInt();

		
			
				//System.out.println("이미지 링크:");
				//String imglink = scan.next();
				
				scan.nextLine();
				
			
				
			
				System.out.println("편의시설 이름(을)치면 아이디 나온다:");
				String convename = scan.nextLine();
				
				
			
				
				//System.out.println("회원아이디 치세요:");
			//	String memId= scan.next();
				
				
				

				//입력한 데이터를 VO객체에 저장한다.
				ProdVO prodvo=new ProdVO();
				ProdImgVO prodimgvo=new ProdImgVO();
				ProdConvenVO prodconvenvo=new ProdConvenVO();
			   // prodvo.setProd_id(prodId);
			  //  prodvo.setProd_type(prodtype);
			  //  prodvo.setProd_part(prodpart);
			
			  //  prodvo.setProd_add1(prodadd1);
			  //  prodvo.setProd_add2(prodadd2);
			   // prodvo.setProd_name(prodname);
			  //  prodvo.setProd_des(proddes);
			   // prodvo.setProd_per(per);
			  //   prodvo.setProd_date(proddate);
			   // prodvo.setProd_price(price);
			    
			
			    
			 //  prodimgvo.setProd_id(prodId);
			   
			  //  prodimgvo.setImg_link(imglink);
			        
			    
			    
			    prodconvenvo.setProd_id("p011");
			    
			    
			    prodconvenvo.setConven_name(convename);	
			    
			   
			    
			    
			 //   prodvo.setHost_id(memId);
			    
	            
	            int cnt=service.insertProdConven(prodconvenvo);
	            
	            if(cnt>0) {
	            	
	            	System.out.println("회원정보 추가 성공");
	            }else {
	            	System.out.println("회원정보 추가 실패");
	            }
			}
			
			private void updateMember() {
				System.out.println();
				System.out.println("수정할 회원 정보를 입력하세요..");
				System.out.println("등록취소하고 싶은 상품Id >>");
				String prodId = scan.next();
				
			    System.out.println("등록취소할꺼에요?");
			    String remove=scan.next();
			    
			    if(remove.equals("y")) {
			    	
			    	ProdVO prodVo=new ProdVO();
					prodVo.setProd_id(prodId);

		            int cnt = service.updateProd(prodVo);
			    
			    
		        	if (cnt > 0) {
						System.out.println(prodId + "회원 정보 수정 완료~");
					} else {
						System.out.println(prodId + "회원 정보 수정 실패!");
					}

			    }

			

				
	        

				
			}
			
			
		public static void main(String[] args) {
			
	       new insertTestController().startMember();
		}

	}

