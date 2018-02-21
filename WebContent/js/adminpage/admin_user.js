$(function(){
	
	
	$("#t1 tr td").not(".check").click(function(){
		var num=$(this).parent().find(".client_num").html();
		location.href="adminUser_read.do?num="+num;
	});
	
	
	
		
	$("#del_list").click(function(){
		var leng = $("input:checked").length;
		if(leng==0){
			alert("삭제내용이 없습니다.");
			return false;
		}
		var yes=confirm("정말 삭제 하시겠습니까?");
		if(!yes){
			return false;
		}
		
		var str = "";
		$("input:checked").each(function(i){
			str += $(this).val()+",";
		})
		location.href="adminUserDelete.do?set=2&list="+str;
	
		return false;
		
	})
	
	$(".submit").click(function(){

		var empty = isEmpty();
		
		if(empty==false){
			alert("빈칸이 존재합니다.");
			return false;
		}

		if(empty){
			$("#f").submit();
		}
		
	})
})
function isEmpty(){
		var err = true;

		if($("#id").val()==""){
			err = false;
		}
		return err;
	}