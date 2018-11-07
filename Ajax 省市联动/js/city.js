
$(function(){
	
	// 1.找到省份的元素
	$("#province").change(function(){
		// 2.一旦里面的值发生了改变，立马请求该省份数据
		var pid = $(this).val();
		$.post("CityServlet", {pid:pid}, function(data, status){
			// alert("回来数据了："+data)
			// 先清空以前的值
			$("#city").html("<option value="+">--未选择")
			// 从data数据里找出所有的city，然后遍历所有的city
			$(data).find("city").each(function(){
				var id = $(this).children("id").text();
				var cname = $(this).children("cname").text();
				// alert("id="+id+"---cname"+cname);
				$("#city").append("<option value="+ id +">" + cname)
			});
		});
	})
	
});



