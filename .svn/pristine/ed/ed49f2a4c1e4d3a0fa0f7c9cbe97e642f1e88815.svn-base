/* API */
$(function(){	
	$('#signUp').click(function(){	
		$.ajax({
			url :'/dditBnb/register.do',
			type : 'get',
			success : function(res){
				str = '<img src="/dditBnb/CaptchaImgDownload.do?filename=' + res + '">';
				
				$('#captchaImg').html(str);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType:'json'
		})
	})
	
	const signUpBtn = document.querySelector('#signUpBtn');
	
	
	signUpBtn.addEventListener('click', function(){
		if($('#password').val().trim() != $('#pwdCheck').val().trim()){
			alert("비밀번호를 다시 확인해주세요.")
		}else{
			if($('#imgAnswer').val().trim() == ""){
				alert("자동가입방지 문자를 입력해주세요.")
			}else{				
				$.ajax({
					url : '/dditBnb/register.do',
					type: 'post',
					data : {
						"uname" : $('#uname').val().trim(),
						"uid" : $('#uid').val().trim(),
						"password" : $('#password').val().trim(),
						"pwdCheck" : $('#pwdCheck').val().trim(),
						"ubirth" : $('#ubirth').val().trim(),
						"email" : $('#email').val().trim(),
						"tel" : $('#tel').val().trim(),
						"addr" : $('#addr').val().trim(),
						"findPwd" : $('#findPwd').val(),
						"answer" : $('#findPwdAns').val().trim(),
						"imgAnswer" : $('#imgAnswer').val().trim()
					},
					success : function(res){
						alert(res);
						location.reload();
					},
					error : function(xhr){
						alert("상태 : " + xhr.status);
					},
					dataType:'text'
				})
			}
		}
	})
})

