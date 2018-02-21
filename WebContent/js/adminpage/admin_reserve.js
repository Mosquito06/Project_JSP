$(function(){
	
	$("#del_list").click(function(){
		var leng = $(".check input:checked").length;

		if(leng==0){
			alert("삭제내용이 없습니다.");
			return false;
		}
		var yes=confirm("정말 삭제 하시겠습니까?");
		if(!yes){
			return false;
		}
		
		var str = "";
		$(".check input:checked").each(function(i){
			str += $(this).val()+",";
		})
		location.href="adminReserveDelete.do?set=2&list="+str;
	
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
		
		
		$(".date").each(function(j,obj){
			if($(this).val()==""){
				err = false;
			}
		})
		
		if($("#id").val()!=""){
			err = true;
		}
		return err;
	}