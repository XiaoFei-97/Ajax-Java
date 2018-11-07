$(function(){
	$("#province").change(function(){
		var pid = $(this).val();
		
		$.post("CityServlet02", {pid:pid}, function(data, status){
			
			$("#city").html("<option value=" + ">--请选择--")
			
			$(data).each(function(index, c){
				// alert(c.cname);
				$("#city").append("<option value=" +c.id + ">" +c.cname);
			})
		}, "json");
	});
});