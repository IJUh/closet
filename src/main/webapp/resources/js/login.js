/*function multiply(num1, num2) {
	var total = num1 * num2;
	alert(total);	
}

//multiply(10,2);

function convertToCelsius(temp) {
		var result = temp - 32;
		result = result / 1.8;
		return result; b n	
}
*/
function singUp() {
	var source = aHref.getAttribute("href");
	
	var placeholder = document.getElementById("placeholder");
	
	placeholder.setAttribute("src",source);
	
	var titletext = whichpic.getAttribute("title");
	return false;
}

window.onload = function() {
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	//if(!document.getElementById("sign_btn")) return false;
	//if(!document.getElementById("sform")) return false;
	
	var signUp = document.getElementById("sign_up");
	if(signUp != null) {
		singUp.onclick = function() {
		var aHref = signUp.getElementsByTagName("a");
		signUp(aHref);	
		}
	}
	
	var signComp = document.getElementById("regiForm");
	if(signComp != null) {
		var inputComp = signComp.getElementsByTagName("input");
		var correct;
		for(var i = 0; i < inputComp.length; i++) {
			if(inputComp[i].getAttribute('id') == "sign_up_id") {
				inputComp[i].addEventListener("change", function () {
					var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
					if(regExp.test(this.value) === false) {
						alert("이메일주소형식이 잘 못 되었습니다.");
						this.value = "";
					}
				});
			} else if(inputComp[i].getAttribute('id') == "sign_up_password") {
				inputComp[i].addEventListener("change", function () {
					var regExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합
					if(regExp.test(this.value) === false) {
						alert("비밀번호형식이 잘 못 되었습니다.");
						this.value = "";
					}
				});
			} else if(inputComp[i].getAttribute('id') == "sign_up_phone") {
				inputComp[i].addEventListener("change", function () {
					var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
					if(regExp.test(this.value) === false) {
						alert("핸드폰번호 형식이 잘 못 되었습니다.");
						this.value = "";
					}
				});
			}
		}
	}
	
	var check =  document.getElementById("check_id");
	if(check != null) {
		check.addEventListener("click", function() {
		var userId =  document.getElementById("sign_up_id").value;
		var param = {"userId" : userId};
		  $.ajax({
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    url: "check/duplicate/user",
		    type: "POST",
		    cache: false,
		    dataType: "JSON",
		    data: JSON.stringify(param), 
		    contentType:"application/json;charset=UTF-8",
		    success: function(response){
		    	$("#is_checked").val('1');
		    	alert(response.message);
		    },   
		    error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
		  });
		});
	}

	var signUpComp = document.getElementById("sign_up_btn");
	if(signUpComp != null) {
		signUpComp.addEventListener("click", function(e) {
			
			var userId =  document.getElementById("sign_up_id");
			var sign_up_password =  document.getElementById("sign_up_password");
			var sign_up_phone =  document.getElementById("sign_up_phone");
			var is_checked =  document.getElementById("is_checked");
			
			if(regiForm.userId.value.length == 0) {
				alert("아이디를 입력하세요."); 
				e.preventDefault();
			}
			if(regiForm.password.value.length == 0) {
				alert("비밀번호를 입력하세요."); 
				e.preventDefault();
			}
			if(!regiForm.phone.value) {
				alert("전화번호를 입력하세요."); 
				e.preventDefault();
			}
			if(is_checked.value != 1) {
				alert("아이디 중복체크 후 회원가입이 가능합니다.");
				e.preventDefault();
			}
		});
	}
};


