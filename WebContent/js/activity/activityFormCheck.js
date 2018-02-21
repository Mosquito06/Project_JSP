
$(function() {
	var submit = false;

	$("#addEventForm").submit(function() {
		submit = true;

		if(checkExistsValue()){
			alert("내용을 입력해 주세요.");
			return false;
		}else {
			var content = CKEDITOR.instances.noticeContent.getData();
			$("#hiddenContent").val(content);
		}
		
	});
	var backClick = false; 

	$("input[type='button']").click(function() {
		backClick = true;
		if (!checkExistsValue()) {
			var res = confirm("저장하지 않고 나가겠습니까?");
			if (res) {
				location.replace(contextPath + "/fileDelete.do");
			} else {
				backClick = false;
			}
		} else {
			history.go(-1);
		}
	});

	window.onbeforeunload = function(evt) {
		if (!checkExistsValue() && !backClick && !submit) {
			$.ajax({
				url : contextPath + "/fileDelete.do",
				type : "get",
				dataType : "xml"
			});
			return "";
		}
	}; 
	 
})


function checkExistsValue() {
	var content = CKEDITOR.instances.noticeContent.getData();
	
	$('input[type]').not('input[type="hidden"]').each(function(i,obj){
		console.log($(this).val())
		if($(this).val() == ""){
			$(this).focus();
			return false;
		}
	})
	
	if (content.length > 0) {
		return false;
	}

	return true;
}