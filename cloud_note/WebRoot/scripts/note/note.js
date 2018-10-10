function loadNotes(){
	//显示区域
	$("#pc_part_1").show();
	$("#pc_part_2").show();
	$("#pc_part_3").show();
	//隐藏区域
	$("#pc_part_5").hide();
	$("#pc_part_6").hide();
	$("#pc_part_4").hide();
	$("#pc_part_7").hide();
	$("#pc_part_8").hide();
				//点击笔记本加载列表(给现有的或者未来的元素匹配)
				//动态绑定事件处理
				$("#book_list li a").removeClass("checked");
				$(this).find("a").addClass("checked");
				
				//获取noteBookId	
				var noteIds = $(this).data("noteIds");
				//发送ajax请求
				$.ajax({
					url:basePath+"/note/loadnotes.do",
					type:"post",
					data:{"noteId":noteIds},
					dataType:"json",
					success:function(result){
						$("#note_list").empty();
						if(result.status==0){
							var datas = result.data;
							for (var index = 0; index < datas.length; index++) {
								var note_Title = datas[index].cn_note_title;
								var note_Id = datas[index].cn_note_id;
								var li_s = 
									"<li class='online'>"+
										"<a>"+
											"<i class='fa fa-file-text-o' title='online' rel='tooltip-bottom'>"+
											"</i>"+note_Title+
												"<button type='button' class='btn btn-default btn-xs btn_position btn_slide_down'>"+
												"<i class='fa fa-chevron-dow'></i>"+
												"</button>"+
										"</a>"+
										"<div class='note_menu' tabindex='-1'>"+
											"<dl>"+
												"<dt><button type='button' class='btn btn-default btn-xs btn_move' title='移动至...'><i class='fa fa-random'></i></button></dt>"+
												"<dt><button type='button' class='btn btn-default btn-xs btn_share' title='分享'><i class='fa fa-sitemap'></i></button></dt>"+
												"<dt><button type='button' class='btn btn-default btn-xs btn_delete' title='删除'><i class='fa fa-times'></i></button></dt>"+
											"</dl>"+
										"</div>"+
									"</li>";
									//创建节点
									var $lis = $(li_s);
									//藏值
									$lis.data("note_Id",note_Id);
									//拼接节点
									$("#note_list").append($lis);
							}
						}
					},
					error:function(){
						alert("网络繁忙,请稍后再试!");
					}
				});
			}

//添加笔记
function addNotes(){
	//获取笔记内容
	var noteTitle = $("#input_note").val().trim();
	//获取笔记本的Id
	var $li_s_a = $("#book_list li a.checked").parent();
	var bookIds = $li_s_a.data("noteIds");
	var ok = true; 
	//检测用户是否选择笔记本
	if(bookIds==undefined){
		$("#modalBasicLabel_2").html("请选择笔记本").css("color","red");
		return;
	}
	//检测用户笔记本是否为空
	if(noteTitle==""){
		$("#modalBasicLabel_2").html("笔记内容不能为空").css("color","red");
		ok=false;
	}
	if(ok){
		$.ajax({
			url:basePath+"note/addnote.do?",
			type:"post",
			data:{"noteTitle":noteTitle,"bookId":bookIds,"userId":uId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//关闭窗口
					closeWindow();
					//获取笔记ID
					var noteId = result.data;
					var li_s = 
						"<li class='online'>"+
						"<a>"+
							"<i class='fa fa-file-text-o' title='online' rel='tooltip-bottom'>"+
							"</i>"+noteTitle+
								"<button type='button' class='btn btn-default btn-xs btn_position btn_slide_down'>"+
								"<i class='fa fa-chevron-dow'></i>"+
								"</button>"+
						"</a>"+
						"<div class='note_menu' tabindex='-1'>"+
							"<dl>"+
								"<dt><button type='button' class='btn btn-default btn-xs btn_move' title='移动至...'><i class='fa fa-random'></i></button></dt>"+
								"<dt><button type='button' class='btn btn-default btn-xs btn_share' title='分享'><i class='fa fa-sitemap'></i></button></dt>"+
								"<dt><button type='button' class='btn btn-default btn-xs btn_delete' title='删除'><i class='fa fa-times'></i></button></dt>"+
							"</dl>"+
						"</div>"+
					"</li>";
					//创建节点
					var $lis = $(li_s);
					//藏值笔记ID
					$lis.data("noteId",noteId);
					$("#note_list").prepend($lis);
					setTimeout("flushPage()", 0);
				}
			},
			error:function(){
				alert("网络异常,请稍后再试!");
			}
		});
	}
}

function showNote(){
	$("#note_list li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取笔记ID
	var noteId = $(this).data("note_Id");
	//发送ajax请求
	$.ajax({
		url:basePath+"note/findnote.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var note = result.data;
				//获取标题
				var noteTitleName = note.cn_note_title;
				//获取笔记内容
				var noteBody = note.cn_note_body;
				//设置标题
				$("#input_note_title").val(noteTitleName);
				//设置笔记内容
				um.setContent(noteBody);
			}
		},
		error:function(){
			alert("网络繁忙,请稍后再试!");
		}
	});
}
//编辑笔记
function upateNotes(){
	//获取标题
	var noteTitle = $("#input_note_title").val();
	
	//获取笔记内容
	var noteBody = um.getContent();
	//获取笔记ID
	var $noteli = $("#note_list li a.checked").parent();
	var noteId = $noteli.data("note_Id");
	//发送ajax请求
	$.ajax({
		url:basePath+"/note/updateNote.do",
		type : "post",
		data : {"noteTitle":noteTitle,"noteBody":noteBody,"noteId":noteId},
		dataType : "json",
		success : function(result){
			if(result.status==0){
				//如果标题改变,修改列表标题
				var newTitle = $("#note_list a.checked").text().trim();
				if(newTitle!=noteTitle){
					var news = "<i class='fa fa-file-text-o' title='online' rel='tooltip-bottom'>"+
					"</i>"+noteTitle+
					"<button type='button' class='btn btn-default btn-xs btn_position btn_slide_down'>"+
					"<i class='fa fa-chevron-dow'></i>"+
					"</button>";
					$("#note_list a.checked").html(news);
				}
					alert("保存成功!");
			}
		},
		error : function(){
			alert("操作失败");	
		}
	});
}

function resysle(){
	//显示背景颜色
	$(".opacity_bg").show();
	//触发对话框
	$("#can").load("alert/alert_delete_note.html");
	//点击删除触发函数
	$("#can").on("click","#recycle_note",recycleNote);
}

//进入回收站
function recycleNote(){
	//获取笔记ID
	var $lis = $("#note_list li a.checked").parent();
	//var $lis = $(this).parents("li");
	var noteId = $lis.data("note_Id");
	//发送ajax请求
	$.ajax({
		url: basePath+"note/noteStatus.do",
		type : "post",
		data : {"noteId":noteId},
		dataType : "json",
		success : function(result){
			if(result.status==0){
				//删除列表
				$lis.remove();
				//清空编辑区和标题
				um.setContent("");
				$("#input_note_title").val("");
				//提示删除
				//删除成功自动触发关闭按钮  
			}
			alert("删除成功!");
		},
		error : function(){
			alert("删除失败!")
		}
	});
}


//分享笔记
function shareNote(){
	//获取ID
	var $lis =  $("#note_list li a.checked").parent();
	var noteId = $lis.data("note_Id");
	//发送ajax请求
	$.ajax({
		url : basePath+"note/sharenote.do",
		type : "post",
		data :{"noteId":noteId},
		dataType : "json",
		success : function(result){
			if(result.status==0){
				alert(result.msg);
			}else{
				alert(result.msg);
			}
		},
		error : function(){
			alert("分享失败");
		}
	});
}

//搜索回收站分享笔记
function searchRecycle(){
	$("#search_recycle li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var key = event.keyCode;
	//用户按下之后开始检索
	if(key==13){
		$("#search_recycle").empty();
		//获取用户输入的搜索内容
		var keyText = 
				$("#search_note").val().trim();
		//开始ajax请求
		$.ajax({
			url : basePath+"note/searchnote.do",
			type : "post",
			data : {"keyNote":keyText},
			dataType : "json",
			success : function(result){
				if(result.status==0){
					var noteData 
						= result.data;
					for (var index = 0; index < noteData.length; index++) {
						var noteShareTitle = noteData[index].cn_share_title;
						var shareId = noteData[index].cn_share_id;
						var li_s = 
							"<li class='online'>"+
								"<a>"+
									"<i class='fa fa-file-text-o' title='online' rel='tooltip-bottom'>"+
									"</i>"+noteShareTitle+
										"<button type='button' class='btn btn-default btn-xs btn_position btn_slide_down'>"+
									"<i class='fa fa-chevron-dow'></i>"+
									"</button>"+
								"</a>"+
							"</li>";
						//创建节点
						var $lis = $(li_s);
						//藏值
						$lis.data("shareId",shareId);
						//拼接节点
						$("#search_recycle").append($lis);
					}
					//隐藏全部笔记
					$("#pc_part_1").show();
					$("#pc_part_6").show();
					$("#pc_part_5").show();
					$("#pc_part_2").hide();
					$("#pc_part_3").hide();
					//展示搜索笔记
					$("#pc_part_4").hide();
					$("#pc_part_7").hide();
					$("#pc_part_8").hide();
				}
			},
			error : function(){
				alert("网络繁忙,请稍后再试!");
			}
		});
	}
}

function showShareNote(){
		//获取检索笔记Id
		var shareId = $(this).data("shareId");
		//发送ajax请求
		$.ajax({
			url : basePath+"note/shareshow.do",
			type : "post",
			data : {"shareId":shareId},
			dataType : "json",
			success : function(result){
				if(result.status==0){
					var shareData = result.data;
					$("#noput_note_title").text(shareData.cn_share_title);
					$("#noput_note_body").text(shareData.cn_share_body);
				}
				//显示区域
				$("#pc_part_5").show();
				$("#pc_part_6").show();
				//隐藏区域
				$("#pc_part_3").hide();
				$("#pc_part_2").hide();
			},
			error : function(){
				alert("网络繁忙,请稍后再试!");
			}
		});
}

//展示回收站笔记
function recycleShowNote(){
	$("#pc_part_4").show();
	$("#pc_part_2").hide();
	$("#pc_part_6").hide();
	$("#pc_part_7").hide();
	$("#pc_part_8").hide();
	$("#replayNoteInput").empty();
	$.ajax({
		url : basePath+"note/recycleNote.do",
		type : "post",
		data : {"userId":uId}, 
		dataType : "json",
		success : function(result){
			if(result.status==0){
				var noteData = result.data;
				for (var index = 0; index < noteData.length; index++) {
					var noteTitle = noteData[index].cn_note_title;
					var noteId = noteData[index].cn_note_id;
					//节点初始化
					var lis = 
							"<li class='disable'>"+
								"<a>"+
									"<i class='fa fa-file-text-o' title='online' rel='tooltip-bottom'>"+
									"</i>"+noteTitle+""+
									"<button type='button' class='btn btn-default btn-xs btn_position btn_delete'>"+
									"<i class='fa fa-times'></i>"+
									"</button>"+
									"<button type='button' class='btn btn-default btn-xs btn_position_2 btn_replay' id ='show_replay'>"+
									"<i class='fa fa-reply'></i>"+
									"</button>"+
								"</a>"+
							"</li>";
					//创建节点
					var $li_s = $(lis);
					//藏值
					$li_s.data("noteId",noteId);
					//拼接节点
					$("#replayNoteInput").append($li_s);
				}
			}
		},
		error : function(){
			alert("网络繁忙,请稍后再试!");
		}
	});				
}

//打开笔记恢复按钮
function replayNoteInput(){
	
	//获取笔记Id
	var $li = $(this).parent().parent("li");
	var noteId = $li.data("noteId");
	$(".opacity_bg").show();
	$("#can").load("alert/alert_replay.html",function(){
	$.ajax({
		url:basePath+"notebook/loadbooks.do",
		type:"post",
		data:{"userId":uId},
		dataType:"json",
		success : function(result){
			if(result.status==0){
				var dataNote = result.data;
				for (var index = 0; index < dataNote.length; index++) {
					var noteTitle = dataNote[index].cn_notebook_name;
					var noteData = dataNote[index].cn_notebook_id;
					var options ='<option value = '+noteData+'>'+noteTitle+'</option>' ;
					var $option = $(options);
					//
					$option.data("booknoteId",noteData);
					//将获取的笔记Id放于恢复按钮中
					$("#sure_replay").data("noteId",noteId);
					$("#replaySelect").append($option);
				}
			}
		},
		error : function(){
			alert("网络繁忙,请稍后再试!");
		}
	});
});
}
//恢复笔记
function replayNote(){
	//获取笔记Id
	var noteId = $("#sure_replay").data("noteId");
	//获取笔记本Id
	var bookNoteId = $("#replaySelect option:checked").val();
	//将回收站恢复的笔记删除
	//发送ajax请求
	$.ajax({
		url : basePath+"note/replayNote.do",
		type : "post",
		data : {"noteId":noteId,"bookNoteId":bookNoteId},
		dataType : "json",
		success : function(result){
			if(result.status==0){
				//关闭恢复窗口
				closeNoteWindows();
				alert("操作成功!");
				//再次点击页面.自动触发一次请求
				setTimeout(function(){
					$("#rollback_button").trigger("click");
				}, 0);						
			}
		},
		error : function(){
			alert("网络繁忙,请稍后再试!");
		}
	});
}

//获取回收站的noteId
function getRecycleNoteId(){
}

//打开笔记窗口
function showNoteWindows(){
	$("#can").load("alert/alert_note.html");
	$(".opacity_bg").show();
}

//关闭笔记窗口
function closeNoteWindows(){
	$("#can").empty();
	$(".opacity_bg").hide();
}
function flushPage(){
	window.location.reload(true);
}