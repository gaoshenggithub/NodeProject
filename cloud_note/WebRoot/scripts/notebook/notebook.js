function noteBookLoads(){
			//加载该页面就直接生成用户的信息
			$.ajax({
				url:basePath+"notebook/loadbooks.do",
				type:"post",
				data:{"userId":uId},
				//async:false,
				dataType:"json",
				success:function(result){
					if(result.status==0){
						//笔记JSON集合
						var bookDatas = result.data;
						//迭代生成一个笔记本li列表
						for (var index = 0; index < bookDatas.length; index++) {
							//笔记名称
							var noteBookName = 
									bookDatas[index].cn_notebook_name;
							//笔记ID
							var noteBookId = 
									bookDatas[index].cn_notebook_id;
							
							var li_s="<li class='online'>"+
									 "<a>"+
									 "<i class='fa fa-book' title='online' rel='tooltip-bottom'>"+
								 	"</i>"+noteBookName+"</a></li>";
							//将字符串对象转换为jQuery(创建节点)
							var $lis = $(li_s);
							//藏值
							$lis.data("noteIds",noteBookId);
							$("#book_list").append($lis);
						}
					}
				},
				error:function(){
					alert("网络繁忙,请稍后再试!");
				}
			});			
		}	


//校验和传递数据
function addNoteBookNames(){
	//获取笔记名
	var noteBook = $("#input_notebook").val().trim();
	//检查noteBook是否为空
	var ok = true;
	if(noteBook==""){
		$("#modalBasicLabel").html("笔记本不能为空").css("color","red");
		ok = false;
	}
	//发送请求
	if(ok){
		$.ajax({
		url:basePath+"notebook/add.do",
		type:"post",
		data:{"bookName":noteBook,"userId":uId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				//关闭窗口
				closeWindow();
					//获取笔记本Id
				var bookDataIds = result.data;
				var li_s = "<li class='online'>"+
						   "<a>"+
				           "<i class='fa fa-book' title='online' rel='tooltip-bottom'>"+
			 	           "</i>"+noteBook+"</a></li>";
			 	      
			 	//创建节点
			 	var $lis = $(li_s);
			 	$lis.data("bookDataIds",bookDataIds);
			 	//拼接节点
			 	$("#book_list").prepend($lis);
			 		setTimeout("flushPage()", 0);
				}
			},
			error:function(){
				alert("网络繁忙,请稍后再试!");
		}
	});
	}
}

//加载恢复选项
function loadOptions(){
	$.ajax({
		url : basePath+"notebook/loadbooks.do",
		type : "post",
		data : {"userId":uId},
		dataType : "json",
		success : function(result){
			if(result.status==0){
				var noteData = result.data;
				for (var index = 0; index < noteData.length; index++) {
					var bookNoteId = noteData[index].cn_notebook_id;
					var bookTitle = noteData[index].cn_notebook_name;
					var $option= "<option value = "+bookNoteId+">"+bookTitle+"</option>";
					var $options = $($option);
					$options.data("noteBookId",bookNoteId);
					$("#replaySelect").append($options);
				}
			}
		},
		error : function(){
			alert("网络繁忙,请稍后再试!");
		}
	});
}

//打开对话框
function showAddBookWindow(){
	//触发对话框
	$("#can").load("alert/alert_notebook.html");
	//加载背景颜色
	$(".opacity_bg").show();
}

//关闭对话框
function closeWindow(){
	//清空对话框元素
	$("#can").empty();
	//隐藏背景颜色
	$(".opacity_bg").hide();
}

function flushPage(){
	window.location.reload(true);
}