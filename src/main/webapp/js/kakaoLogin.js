Kakao.init('ef859961b758a16d0d5a9a2b80a10e74'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response.id)
        	  console.log(response.kakao_account.email)
        	  console.log(response.properties.nickname)
        	  
        	$.ajax({
				url: '/dditBnb/KaKaoLogin.do',
				type:'post',
				data : {
					"id" : response.id,
					"name" : response.properties.nickname,
					"mail" : response.kakao_account.email
				},
				success: function(res){		
					alert(res);	
					location.reload();		
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : 'text'
		})	
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  