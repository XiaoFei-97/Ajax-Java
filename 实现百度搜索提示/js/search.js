

//$(document).ready(function(){
//	
//})
$(function(){
	// 1.捕捉键盘弹起事件
	$("#word").keyup(function(){
		// alert("键盘弹起了...");
		// 2.获取输入框的值
		var word = $("#word").val();
		if(word == ""){
			$("#div01").hide();
		}else{
			// 3.请求数据
			$.post("/baiduSearch/FindWordsServlet", {word:word}, function(data, status){
				// alert(data);
				$("#div01").html(data);
				$("#div01").show();
			})
		}
	});
});



