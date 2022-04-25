<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	Cookie[] cookies = request.getCookies();
	
	String user = "";
	String check = "";
	
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")){
				user = cookie.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대덕비앤비:회원관리</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@1,900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;500&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../style/reset.css">
<link rel="stylesheet" href="../style/managementMember.css">
<!-- <link rel="stylesheet" href="../style/public.css"> -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="../js/kakaoLogin.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript" src="../js/util.js"></script>

<script type="text/javascript">
$(function(){
	//게스트 리스트
	$.ajax({
		url: '/dditBnb/guestList.do',
		type:'post',
		success: function(res){
			code = "";
			$.each(res, function(i, v) {
				code += "<tr class='guest' data-toggle='modal' data-target='#guestModal'><td class='tdf'>" + v.mem_id + "</td>";
				code += "<td class='tdf'>" + v.mem_name + "</td>";
				code += "<td class='tdf'>" + v.mem_email + "</td></tr>";			
			})
			$('#guestList').html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType:'json'
	})
	
	//호스트 리스트
	$.ajax({
		url: '/dditBnb/hostList.do',
		type:'post',
		success: function(res){
			code = "";
			$.each(res, function(i, v) {
				code += "<tr class='host' data-toggle='modal' data-target='#hostModal'><td class='tdf'>" + v.host_id + "</td>";
				code += "<td class='tdf'>" + v.mem_id + "</td>";
				code += "<td class='tdf'>" + v.host_date + "</td></tr>";			
			})
			$('#hosttList').html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType:'json'
	})
	
	//게스트 상세조회
	$(document).on('click','.guest', function() {
		mem_id = $('td:eq(0)', this).text();
		
		searchMem(mem_id);
	})
	
	//호스트 상세조회
	$(document).on('click','.host', function() {
		host_id = $('td:eq(0)', this).text();
		
		searchHost(host_id);
	})
	
	//게스트 검색
	$(document).on('click','#search', function() {
		mem_id = $('#idSearch').val();
		console.log(mem_id);
		searchMem(mem_id);
	})
	
	//호스트 검색
	$(document).on('click','#search2', function() {
		host_id = $('#hostSearch').val();
		console.log(host_id);
		searchHost(host_id);
	})
	
	$('.modal').on('hidden.bs.modal', function (e) {
		$(this).find('form')[0].reset();
	})
	
})

function searchMem(mem_id) {
	$.ajax({
		url: '/dditBnb/getGuest.do',
		data: {
			'mem_id': mem_id
		},
		type:'post',
		success: function(res){
			if(res.length != 0){
				incode = "";
				$.each(res, function(i, v) {
					incode += "<tr><td class='tdName'>회원ID</td>";
					incode += "<td>" + v.mem_id + "</td></tr>";			
					incode += "<tr><td class='tdName'>이름</td>";
					incode += "<td>" + v.mem_name + "</td></tr>";			
					incode += "<tr><td class='tdName'>비밀번호</td>";
					incode += "<td>" + v.mem_pass + "</td></tr>";			
					incode += "<tr><td class='tdName'>mail</td>";
					incode += "<td>" + v.mem_email + "</td></tr>";			
					incode += "<tr><td class='tdName'>전화번호</td>";
					incode += "<td>" + v.mem_tel + "</td></tr>";			
					incode += "<tr><td class='tdName'>주소</td>";
					incode += "<td>" + v.mem_addr + "</td></tr>";			
					incode += "<tr><td class='tdName'>생년월일</td>";
					incode += "<td>" + v.mem_birth + "</td></tr>";			
					incode += "<tr><td class='tdName'>가입일시</td>";
					incode += "<td>" + v.mem_join + "</td></tr>";	
					
					//게스트 별 예약내역 조회
					$.ajax({
						url: '/dditBnb/getGuestReser.do',
						data: {
							'mem_id': v.mem_id
						},
						type:'post',
						success: function(res){
							if(res.length != 0){
								outcode = "";
								$.each(res, function(i, v) {
									outcode += "<tr><td>" + v.reser_id + "</td>";
									outcode += "<td>" + v.prod_name + "</td>";
									outcode += "<td>" + v.check_in + "</td>";
									outcode += "<td>" + v.check_out + "</td></tr>";
								})
							} else {
								outcode = "<hr>예약 내역이 존재하지 않습니다.";
							}
							
							$('#result_reserList').html(outcode);
						},
						error : function(xhr){
							alert("상태 : " + xhr.status);
						},
						dataType:'json'
					})	
				})
				
			} else {
				incode = "검색 결과가 없습니다.";
				outcode = "";
			}
			$('#result1').html(incode);
			$('#result_reserList').html(outcode);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType:'json'
	})	
	
}

function searchHost(host_id) {
	$.ajax({
		url: '/dditBnb/getHost.do',
		data: {
			'host_id': host_id
		},
		type:'post',
		success: function(res){
			if(res.length != 0){
				$.each(res, function(i, v) {
					incode = "";
					incode += "<tr><td class='tdName'>호스트ID</td>";
					incode += "<td>" + v.host_id + "</td></tr>";			
					incode += "<tr><td class='tdName'>회원ID</td>";
					incode += "<td>" + v.mem_id + "</td></tr>";			
					incode += "<tr><td class='tdName'>최초 등록일</td>";
					incode += "<td>" + v.host_date + "</td></tr>";			
					incode += "<tr><td class='tdName'>호스트 소개</td>";
					incode += "<td>" + v.host_des + "</td></tr>";	
					
					//호스트 별 등록한 숙소
					$.ajax({
						url: '/dditBnb/getHostProd.do',
						data: {
							'host_id': v.host_id
						},
						type:'post',
						success: function(res){
							if(res.length != 0){
								outcode = "";
								$.each(res, function(i, v) {
									outcode += "<tr><td>" + v.prod_id + "</td>";
									outcode += "<td>" + v.prod_name + "</td>";
// 									outcode += "<td>" + v.prod_per + "명 </td>";
									outcode += "<td>" + v.prod_price + "원 </td></tr>";
								})
							} else {
								outcode = "<hr>등록한 숙소가 없습니다.";
							}
							$('#result_prodList').html(outcode);
						},
						error : function(xhr){
							alert("상태 : " + xhr.status);
						},
						dataType:'json'
					})	
				})
				
			} else {
				incode = "검색 결과가 없습니다.";
				outcode = "";
			}
			$('#result2').html(incode);
			$('#result_prodList').html(outcode);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType:'json'
	})	
}

</script>

</head>
<body>
<header>
	<div id="headerTop">
		<div id="logoContainer">
			<a href="./index.jsp">
				<svg width="35" height="32" fill="hotpink" style="display:block;">
					<path d="
						M 16 1 c 2.008 0 3.463 0.963 4.751 3.269 l 0.533 1.025 c 1.954 3.83 6.114 12.54 7.1 14.836 l 0.145 0.353 c 0.667 1.591 0.91 2.472 0.96 3.396 l 0.01 0.415 l 0.001 0.228 c 0 4.062 -2.877 6.478 -6.357 6.478 c -2.224 0 -4.556 -1.258 -6.709 -3.386 l -0.257 -0.26 l -0.172 -0.179 h -0.011 l -0.176 0.185 c -2.044 2.1 -4.267 3.42 -6.414 3.615 l -0.28 0.019 l -0.267 0.006 C 5.377 31 2.5 28.584 2.5 24.522 l 0.005 -0.469 c 0.026 -0.928 0.23 -1.768 0.83 -3.244 l 0.216 -0.524 c 0.966 -2.298 6.083 -12.989 7.707 -16.034 C 12.537 1.963 13.992 1 16 1 Z m 0 2 c -1.239 0 -2.053 0.539 -2.987 2.21 l -0.523 1.008 c -1.926 3.776 -6.06 12.43 -7.031 14.692 l -0.345 0.836 c -0.427 1.071 -0.573 1.655 -0.605 2.24 l -0.009 0.33 v 0.206 C 4.5 27.395 6.411 29 8.857 29 c 1.773 0 3.87 -1.236 5.831 -3.354 c -2.295 -2.938 -3.855 -6.45 -3.855 -8.91 c 0 -2.913 1.933 -5.386 5.178 -5.42 c 3.223 0.034 5.156 2.507 5.156 5.42 c 0 2.456 -1.555 5.96 -3.855 8.907 C 19.277 27.766 21.37 29 23.142 29 c 2.447 0 4.358 -1.605 4.358 -4.478 l -0.004 -0.411 c -0.019 -0.672 -0.17 -1.296 -0.714 -2.62 l -0.248 -0.6 c -1.065 -2.478 -5.993 -12.768 -7.538 -15.664 C 18.053 3.539 17.24 3 16 3 Z m 0.01 10.316 c -2.01 0.021 -3.177 1.514 -3.177 3.42 c 0 1.797 1.18 4.58 2.955 7.044 l 0.21 0.287 l 0.174 -0.234 c 1.73 -2.385 2.898 -5.066 2.989 -6.875 l 0.006 -0.221 c 0 -1.906 -1.167 -3.4 -3.156 -3.421 h -0.001 Z
					">
					</path>
				</svg>
				<span id="logoTitle">
					dditBnB
				</span>
			</a>
		</div>
		
		<div class="userContent">
<!-- 			<button class="hostingBtn"><a href="./hosthome.jsp">호스트 되기</a></button> -->
			<button class="userMenu">
				<span class="material-icons">
					reorder
				</span>
				<span class="material-icons" style="font-size:35px;">
					account_circle
				</span>
			</button>
		</div>
		<%
			if(user.equals("")){	
		%>
				<ul id="userMenu_list" style="display: none;">
					<li class="userMenu_item" id="signUp" data-toggle="modal" data-target="#signUpForm">회원가입</li>
					<li class="userMenu_item" id="login" data-toggle="modal" data-target="#loginForm">로그인</li>
					<hr>
					<li class="userMenu_item" id="doHost"><a href="./hosthome.jsp">숙소 호스트 되기</a></li>
					<li class="userMenu_item" id="help"><a href="./helpBoard.jsp">도움말</a></li>
				</ul>
		<%		
			}else if(user.equals("admin")) {
		%>
				<ul id="userMenu_list" style="display: none;">
					<li class="userMenu_item" id="memberManage"><a href="./managementMember.jsp">회원관리</a></li>
					<li class="userMenu_item" id="prodManage"><a href="./managementProd.jsp">숙소관리</a></li>
					<li class="userMenu_item" id="help"><a href="./helpBoard.jsp">고객센터관리</a></li>
					<li class="userMenu_item" id="logOut">로그아웃</li>
				</ul>
		<%
			}else{
				%>
				<ul id="userMenu_list" style="display: none;">
					<li class="userMenu_item" id="message">메세지</li>
					<li class="userMenu_item" id="myPage"><a href="./myPage.jsp">마이페이지</a></li>
					<hr>
					<li class="userMenu_item" id="prodManage"><a href="./manageHostprod.jsp">숙소관리</a></li>
					<li class="userMenu_item" id="help"><a href="./helpBoard.jsp">도움말</a></li>
					<li class="userMenu_item" id="logOut">로그아웃</li>
				</ul>
		<%
			}
		%>
	</div>
	<hr>
</header>


<main>
	<h2 id="mainTitle" class="title">회원관리 페이지</h2>
	<hr>
		
	<div id="guestBoard">
		<div>
			<span id="guest_title" class="title se">Guest 조회</span>
			<div class="sese">
				<input type="text" name="idSearch" id="idSearch" size='15' placeholder = "게스트 ID 검색">
				<button type="button" id="search" class="btn btn-danger btn-sm mb-2 mr-sm-2" data-toggle="modal" data-target="#guestModal">검색</button>
			</div>
		</div>
		<hr>
		<div class="container" id="searchList">
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>게스트 ID</th>
		        <th>이름</th>
		        <th>Email</th>
		      </tr>
		    </thead>
		    <tbody id="guestList">
		    	<!-- 리스트 출력 -->
		    </tbody>
		  </table>
		</div>
	</div>
	
	<div id="hostBoard">
		<div>
			<span id="host_title" class="title se">Host 조회</span>
			<div class="sese">
				<input type="text" name="hostSearch" id="hostSearch" size='15' placeholder = "게스트 ID 검색">
				<button type="button" id="search2" class="btn btn-danger btn-sm mb-2 mr-sm-2" data-toggle="modal" data-target="#guestModal">검색</button>
			</div>
		</div>
		<hr>
		<div class="container" id="searchList2">
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>호스트 ID</th>
		        <th>게스트 ID</th>
		        <th>최초 등록일시</th>
		      </tr>
		    </thead>
		    <tbody id="hosttList">
		    	<!-- 리스트 출력 -->
		    </tbody>
		  </table>
		</div>
	</div>

</main>

<!-- guest모달 -->
<div class="modal fade" id="guestModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
      	   <h4 class="modal-title title2">Guest 상세조회</h4>
      	   <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
   		<div class="container">
		  <table class="table table-hover">
		    <tbody id="result1">
		    	<!-- 내용 출력 -->
		    </tbody>
		  </table>
		  <table class="table table-hover">
		    <tbody id="result_reserList">
		    	<!-- 리스트 출력 -->
		    </tbody>
		  </table>
		</div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	   <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<!-- host모달 -->
<div class="modal fade" id="hostModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
      	   <h4 class="modal-title title2">Host 상세조회</h4>
      	   <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
   		<div class="container">
   		
		  <table class="table table-hover">
		    <tbody id="result2">
		    	<!-- 내용-->
		    </tbody>
		  </table>
		  
		  <table class="table table-hover">
		    <tbody id="result_prodList">
		    	<!-- 리스트 출력 -->
		    </tbody>
		  </table>
		</div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	   <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<!-- login modal -->
<div class="modal" id="loginForm">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">로그인</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
        <form>
		  <div class="form-group">
		    <label for="loginId">아이디:</label>
		    <input type="text" class="form-control" placeholder="Enter email" id="loginId" autocomplete="off">
		  </div>
		  <div class="form-group">
		    <label for="loginPwd">비밀번호:</label>
		    <input type="password" class="form-control" placeholder="Enter password" id="loginPwd" autocomplete="off">
		  </div>
		  <div class="form-group form-check">
		    <label class="form-check-label">
		      <input class="form-check-input" type="checkbox"> 아이디 기억하기
		    </label>
		  </div>
		  <button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
		  <a class="btn btn-warning" style="margin-left: 100px;" data-toggle="modal" href="#findIdForm" id="findId" >아이디 찾기</a>
		  <a class="btn btn-warning" data-toggle="modal" href="#findPwdForm">비밀번호 찾기</a>
		  
		  <ul>			  
			<li onclick="kakaoLogin();">
		      <a href="javascript:void(0)">
		          <img alt="" src="../image/kakao_login_medium_wide.png">
		      </a>
			</li>
			<li onclick="kakaoLogout();">
		      <a href="javascript:void(0)">
		          <span>카카오 로그아웃</span>
		      </a>
			</li>
		  </ul>
		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<!-- findId Modal -->
<div class="modal" id="findIdForm" data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">아이디 찾기</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
        <form action="">
		  <div class="form-group">
		    <label for="uname">이름</label>
		    <input type="text" class="form-control" placeholder="이름을 입력하세요" id="uname" autocomplete="off">
		  </div>
		  <div class="form-group">
		    <label for="tel">전화번호</label>
		    <input type="text" class="form-control" placeholder="전화번호를 입력하세요" id="tel" autocomplete="off">
		  </div>
		  <button type="button" class="btn btn-primary" id="findIdBtn">찾기</button>		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<!-- findPwd Modal -->
<div class="modal" id="findPwdForm" data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">비밀번호 찾기</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
        <form action="">
		  <div class="form-group">
		    <label for="uname">이름</label>
		    <input type="text" class="form-control" placeholder="이름을 입력하세요" id="uname" autocomplete="off">
		  </div>
		  <div class="form-group">
		    <label for="uid">아이디</label>
		    <input type="text" class="form-control" placeholder="아이디를 입력하세요" id="uid" autocomplete="off">
		  </div>
		  <div class="form-group">
		    <label>힌트</label>
		    <input type="text" class="form-control" placeholder="질문에 대한 정답을 입력하세요" id="answer" autocomplete="off">
		  </div>
		  <button type="button" class="btn btn-primary" id="findPwdBtn">찾기</button>		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<footer id="footer">
	<div id="footer_list">
		<div id="footer_support">
			<h3>대덕비앤비 지원</h3>
			<ul>
				<li>도움말 센터</li>
				<li>안전 정보</li>
				<li>예약 취소 옵션</li>
				<li>에어비앤비의 코로나19 대응 방안</li>
				<li>장애인 지원</li>
				<li>이웃 민원 신고</li>
			</ul>
		</div>
		<div id="footer_community">
			<h3>커뮤니티</h3>
			<ul>
				<li>dditBnB.org:재난 구호 숙소</li>
				<li>아프간 난민 지원</li>
				<li>차별 철폐를 위한 노력</li>
			</ul>
		</div>
		<div id="footer_hosting">
			<h3>호스팅</h3>
			<ul>
				<li>호스팅 시작하기</li>
				<li>커뮤니티 포럼 방문하기</li>
				<li>에어커버:호스트를 위한 보호 프로그램</li>
				<li>책임감 있는 호스팅</li>
				<li>호스팅 자료 둘러보기</li>
			</ul>
		</div>
		<div id="footer_introduce">
			<h3>소개</h3>
			<ul>
				<li>뉴스룸</li>
				<li>채용정보</li>
				<li>새로운 기능에 대해 알아보기</li>
				<li>투자자 정보</li>
				<li>대덕비앤비 공동창업자의 메시지</li>
				<li>대덕비앤비 Luxe</li>
			</ul>
		</div>
	</div>
	<div id="footer_mark">
		<span>
			&copy; 2022 dditBnB,Inc
		</span>
	</div>
</footer>

</body>
</html>