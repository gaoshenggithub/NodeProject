//注册
$(function(){
	$("#regist_button").click(function(){
		$("#warning_1 span").html("");
		$("#warning_1").show();
		$("#warning_2 span").html("");
		$("#warning_2").show();
		$("#warning_3 span").html("");
		$("#warning_3").show();
		//获取用户提交的信息
		var username = $("#regist_username").val().trim();
		var nickname = $("#nickname").val().trim();
		var password = $("#regist_password").val().trim();
		var final_password = $("#final_password").val().trim();
		var ok = true;
		if(username=="".trim()){
			$("#warning_1 span").html("用户名不能为空");
			ok = false;
		}
		if(password.length<=4){
			$("#warning_2 span").html("密码长度过短").css("color","red");
			$("#warning_2").show();
			ok = false; 
		}
		if(password=="".trim() || final_password=="".trim()){
			$("#warning_2 span").html("密码不能为空").css("color","red");
			$("#warning_2").show();
			ok = false; 
		}
		if(password!==final_password){
			$("#warning_2 span").html("两次密码不一致").css("color","red");
			$("#warning_2").show();
			ok = false; 
		}
		if(ok){
		//使用Ajax发送请求信息
		$.ajax({
			url:"http://localhost:8080/cloud_note/user/regist.do",
			type:"post",
			data:{"username":username,"password":password,"nickName":nickname},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);
					$("#back").click();
				}else if(result.status==1){
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show(); 
				}
			},
			error:function(){
				alert("网络繁忙,请稍后再试!");
			}
		});
	}
	});
});