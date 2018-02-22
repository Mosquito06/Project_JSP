
$(function(){
	
	$.ajax({
		url:"qnaRecord.do",
			type:"post",
			data:{"id":$("#hiddenId").val()},
			dataType:"json",
			success:function(data){
				
				var record ="";
				$("#total").text("Total : "+data.length);
				$(".content_list").remove();
				if(data.length==0){
					record+="<tr class='content_list'><td colspan='4' id='noRecord'>문의내역이 없습니다.</td></tr>";
				
				}else{
					
					for(var i=0;i<data.length;i++){
						record+="<tr class='content_list' id='"+data[i].num+"'>";
						record+="<td class='center_table'>"+(i+1)+"</td>";
						record+="<td><a href='qnaRead.do?num="+data[i].num+"'>"+data[i].title+"</a></td>";
					
						var date = new Date(data[i].date);
						var month = date.getMonth()+1;
						
						if(month.length=1){
							record+="<td class='center_table'>"+date.getFullYear()+"-0"+month+"-"+date.getDate()+"</td>";
						}else{
							record+="<td class='center_table'>"+date.getFullYear()+"-"+month+"-"+date.getDate()+"</td>";
						}
						
						if(data[i].content==null){
							record+="<td class='notyet center_table'>답변대기</td>";
						}else{
							record+="<td class='yes center_table'>답변완료</td>";
						}
						
					}
					
				}
				
				$("#tableRecord").append(record);
		}
	})
	
	$(document).on("click",".content_list",function(){
		
		var num = $(this).attr("id");
		location.href="qnaRead.do?num="+num;
	})
	
	$(document).on("click","#recoment_redy",function(){
	
		$.ajax({
			url:"qnaCommend.do",
				type:"get",
				data:{"id":$("#hiddenId").val()},
				dataType:"json",
				success:function(data){
					var record ="";
					$("#total").text("Total : "+data.length);
					$(".content_list").remove();
					if(data.length==0){
						record+="<tr class='content_list'><td colspan='4' id='noRecord'>답변대기 내역이 없습니다.</td></tr>";
					
					}else{
						
						for(var i=0;i<data.length;i++){
							record+="<tr class='content_list' id='"+data[i].num+"'>";
							record+="<td class='center_table'>"+(i+1)+"</td>";
							record+="<td><a href='qnaRead.do?num="+data[i].num+"'>"+data[i].title+"</a></td>";
						
							var date = new Date(data[i].date);
							var month = date.getMonth()+1;
							
							if(month.length=1){
								record+="<td class='center_table'>"+date.getFullYear()+"-0"+month+"-"+date.getDate()+"</td>";
							}else{
								record+="<td class='center_table'>"+date.getFullYear()+"-"+month+"-"+date.getDate()+"</td>";
							}
							
								record+="<td class='notyet center_table'>답변대기</td>";
						}
						
					}
					
					$("#tableRecord").append(record);
				}
		})
		
		
		return false;
	})
	
	
	
	$(document).on("click","#recoment_okay",function(){
		
		$.ajax({
			url:"qnaCommend.do",
				type:"post",
				data:{"id":$("#hiddenId").val()},
				dataType:"json",
				success:function(data){
					var record ="";
					$("#total").text("Total : "+data.length);
					$(".content_list").remove();
					if(data.length==0){
						record+="<tr class='content_list'><td colspan='4' id='noRecord'>답변완료 내역이 없습니다.</td></tr>";
					
					}else{
						
						for(var i=0;i<data.length;i++){
							record+="<tr class='content_list' id='"+data[i].num+"'>";
							record+="<td class='center_table'>"+(i+1)+"</td>";
							record+="<td><a href='qnaRead.do?num="+data[i].num+"'>"+data[i].title+"</a></td>";
						
							var date = new Date(data[i].date);
							var month = date.getMonth()+1;
							
							if(month.length=1){
								record+="<td class='center_table'>"+date.getFullYear()+"-0"+month+"-"+date.getDate()+"</td>";
							}else{
								record+="<td class='center_table'>"+date.getFullYear()+"-"+month+"-"+date.getDate()+"</td>";
							}
							
								record+="<td class='notyet center_table'>답변완료</td>";
						}
						
					}
					
					$("#tableRecord").append(record);
				}
		})
		
		
		return false;
	})
	
})