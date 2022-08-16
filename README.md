# 중간프로젝트 - AirBnB 클론코딩

## 개요
대덕인재개발원 중간프로젝트로 5명의 팀원과 개발한 DDitBnB입니다.
JSP/Servlet을 배워 DB를 연동해 데이터를 출력하는 수업을 배워 실습해본 프로젝트 입니다.
* 개발기간 : 2022-04-11 ~ 2022-04-22

## 사용기술
* BackEnd : Java Servlet
* FrontEnd : javascript, Jquery, JSP
* 버전관리/배포 : svn
* DB : Oracle, iBatis

## ERD
 ![05 논리ERD](https://user-images.githubusercontent.com/64582209/184781371-c2e74c0d-fda9-4075-a39d-8902ea0bf159.png)

## 개발
### 메인페이지 - 연관검색 자동완성기능, 이전 검색기록기능
![메인페이지](https://user-images.githubusercontent.com/64582209/184784036-ea9033c5-0659-44ae-a4a9-3886271f30f5.png)
* 검색기능 소스코드
```
$('.searchBtn').click(function(){
		if($('#where').val().trim() != ""){			
			searchSubmit();
		}
	})
	
	const searchSubmit = () => {
		where = $('#where').val().trim();
		
		
		if(searchHistory.length == 0){
			searchHistory.push(where);			
		}else{
			if(searchHistory.indexOf(where) == -1){
				if(searchHistory.length >= 4){
					searchHistory.shift();
					searchHistory.push(where);
				}else{
					searchHistory.push(where);
				}					
			}
		}
		
		saveHistory();
	} 
	
	const saveHistory = () => {
		sessionStorage.setItem("history", JSON.stringify(searchHistory));
	}
	historyObj = JSON.parse(sessionStorage.getItem("history"));
	
	if(historyObj != null){		
		historyObj.forEach((item) => {		
			searchHistory.push(item);
			const historyItem = document.createElement('li');
			const historyImg = document.createElement('span');
			const historyText = document.createElement('span');
			historyImg.classList.add("material-icons");
			historyImg.classList.add("historyIcon");
			historyImg.innerText = "schedule";
			historyText.classList.add("historyText")
			historyText.innerText = item;
			
			historyItem.addEventListener('click', function(e){
				$('#where').val($('.historyText', this).text());
				hideSearchHis();
				checkInput();
			})
			
			historyItem.appendChild(historyImg);
			historyItem.appendChild(historyText);
			document.querySelector('#searchHistoryList').appendChild(historyItem);
		})
	}
	
	$('.searchWhere').click(function(){		
		if($('#where').val().trim() == ""){			
			if(searchHistory.length > 0){
				showSearchHis();
			}
		}
	})
	
	const historyList = document.querySelector('#searchHistory');
	
	const showSearchHis = () => {
		historyList.style.display = 'block';
	}
	
	const hideSearchHis = () => {		
		historyList.style.display = 'none';
	}
	
	$('#searchHisClose').click(function(){
		hideSearchHis();
	})
	

/* --------------------------------------------------------------------------------------------------------------- */

	/* searchAuto */
	
	const autoSearchCon = document.querySelector("#autoSearchContainer");
	const searchInput = document.querySelector('#where');
	const autoSearchList = document.querySelector('#autoSearchList');
	
	const checkInput = () => {
		const beforeVal = searchInput.value.trim();
		timerCheck(beforeVal);
	}
	
	const timerCheck = (beforeVal) => {
		setTimeout(() => {
			if(searchInput.value.trim() === beforeVal){
				if(searchInput.value.trim() != ""){				
					loadData(searchInput.value.trim());
				}
			}else{
				checkInput();
			}
			
			if(searchInput.value.trim() == ""){
				autoSearchCon.style.display = 'none';
			}
		}, 500)
	}
	
	const loadData = (inputVal) => {
		$.ajax({
			url : '/dditBnb/autoSearch.do',
			type : 'post',
			data : {
				"addr" : inputVal
			},
			success : function(res){
				if(res.length != 0 ){					
					setResult(res);
					autoSearchCon.style.display = 'block';
				}
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
		})
	}
	
	
	
	let autoSearchResult = new Array();
	const setResult = (res) => {
		res.forEach((item) => {
			let addr = item.prod_add1;
			const result = addr.split(" ", 2);
			addr = result[0] + " " +  result[1];
			
			if(autoSearchResult.indexOf(addr) == -1){
				autoSearchResult.push(addr);
			}

		})
		outPrint();
		autoSearchResult.splice(0, autoSearchResult.length);
	}
	
	const outPrint = () => {
		if(autoSearchResult.length > 0){
			autoSearchList.innerHTML = "";		
			autoSearchResult.forEach((item) => {				
				const autoSearchItem = document.createElement('li');
				const autoSearchImg = document.createElement('span');
				const autoSearchText = document.createElement('span');
				autoSearchImg.classList.add("material-icons");
				autoSearchImg.classList.add("autoSearchIcon");
				autoSearchImg.innerText = "room";
				
				
				autoSearchText.innerText = item;
				autoSearchText.classList.add('autoItem');
				
				autoSearchItem.classList.add('autoSearchItem');
				autoSearchItem.appendChild(autoSearchImg);
				autoSearchItem.appendChild(autoSearchText);
				
				autoSearchList.appendChild(autoSearchItem);
			})	
		}
	}
	
	searchInput.addEventListener('input', function(){
		hideSearchHis();		
		checkInput();
	});
 ```
### 검색결과페이지 - 예약내역없는 날짜필터기능, 가격&평점&숙소유형별 필터기능, 네이버지도API
![검색결과](https://user-images.githubusercontent.com/64582209/184784086-4c792034-c8ad-4036-a4b0-c406e95dadfc.png)
### 숙소상세정보페이지 - 일정에따른 결제가격출력기능
![숙소상세정보](https://user-images.githubusercontent.com/64582209/184784125-ccb89f49-1bab-4d16-a178-cb9fa488f3db.png)
### 결제페이지
![결재](https://user-images.githubusercontent.com/64582209/184784187-18fe8eec-d3bf-4ef3-bbe7-76f06e1965d7.png)
### 마이페이지 - 예약한숙소목록&상세정보 기능, 찜한숙소목록&상세정보 기능
![마이페이지](https://user-images.githubusercontent.com/64582209/184784245-a3cc4081-fdfd-4ad5-ab8a-8715b878d6a3.png)
### 내숙소페이지 - 내가 호스팅한 숙소목록&상세정보 기능, 일정이예약된 숙소관리기능
![숙소페이지](https://user-images.githubusercontent.com/64582209/184784365-a55825c8-9bf0-4a0c-82c8-882014865714.png)
