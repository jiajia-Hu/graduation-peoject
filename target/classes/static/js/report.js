$(function(){
	$('#myModal1').on('hide.bs.modal', function () {
		var value = $("#reportRId").val();
		alert(value);
		if(value == " "){
			alert("请填写举报原因");
		}
		$.get("/article/report",{
			articleId:$("#articleId").val(),
			reportReason:value
		},function(data){
			alert("举报成功,请等待管理员处理!");
			location.reload();
		});
    });
});
