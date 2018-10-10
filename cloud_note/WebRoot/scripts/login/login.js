$(function(){
		//给登录按钮追加单击处理事件
		$("#login").click(function(){
			//清除原有的信息
			$("#user_mgs").html("");
			$("#pass_mgs").html("");
			//获取请求的数据
			var username = $("#count").val().trim();
			var password = $("#password").val().trim();
			//检查数据格式
			var ok = true;
			if(username=="".trim()){
				$("#user_mgs").html("用户名不能为空");
				 ok = false;
			}
			if(password=="".trim()){
				$("#pass_mgs").html("密码不能为空");
				 ok = false;
			}
			//发送Ajax请求
			if(ok){
			$.ajax({
				url:basePath+"user/login.do",
				type:"post",
				data:{"username":username,"password":password},
				dataType:"json",
				success:function(result){
					//result式服务器返回的JSON结果
					//UserName和PassWord验证通过
					if(result.status==0){
					   //获取用户Id..写入cookie
					    var userId = result.data;
					    addCookie("uId",userId,2);
					    addCookie("name",username,2);
						window.location.href = "edit.html";
					}
					//Username错误	
					else if(result.status==1){
						$("#user_mgs").html(result.msg);
					}
					//密码错误
					else if(result.status==2){
						$("#pass_mgs").html(result.msg);
					}
				},
				error:function(){
					alert("网络繁忙,请稍后再试!");
				}
			});
		}
		});
	});

