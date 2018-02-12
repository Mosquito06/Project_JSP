$(function() {
	var submit = false;
	
	$("#addEventForm").submit(function() { 
		submit = true;
		if (CKEDITOR.instances.noticeContent.getData().length < 1) {
			alert("내용을 입력해 주세요.");
			return false;
		} else {
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
			}else{
				backClick = false;
			}
		}else{
			history.go(-1);
		}
	});

	window.onbeforeunload = function(e) {
		if (!checkExistsValue() && !backClick && !submit) {
			return false;
		}
	};

	/*
	 * $(window).bind("pageshow", function(e) { if (e.originalEvent.persisted) {
	 *  } });
	 */
})

function checkExistsValue() {
	var content = CKEDITOR.instances.noticeContent.getData();

	if ($('input[type]').val()) {
		return false;
	}
	if ($('input[type="date"]').val()) {
		return false;
	}
	if ($('input[type="file"]').val()) {
		return false;
	}

	if (content.length > 0) {
		return false;
	}
	
	return true;
}