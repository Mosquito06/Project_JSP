$(function(){
	
	$(document).on("click",".data",function(){
		
		var num = $(this).find(".hiddenNum").text();
		
		location.href="adminQnaRead.do?num="+num;
	})
	
	$("#total_btn").click(function(){
		location.href="adminQnA.do";
	})
	
	$("#complete").click(function(){
		$.ajax({
			url:"completeReply.do",
			type:"get",
			dataType:"json",
			success:function(data){
				
				$(".data").remove();
				
				$("#total").text("Total : "+data.length);
				
				var list ="";
				
				if(data.length==0){
					list="<tr class='data'><td colspan='9'>완료 내역이 없습니다</td></tr>";
					$("#t1").append(list);
				}else{
					for(var i=0;i<data.length;i++){
						list = "<tr class='data'>";
						list+="<td class='hiddenNum'>"+data[i].num+"</td>";
						list+="<td>"+data[i].id+"</td>";
						list+="<td>"+data[i].name+"</td>";
						list+="<td>"+data[i].title+"</td>";
						list+="<td>"+data[i].tel+"</td>";
						list+="<td>"+data[i].email+"</td>";
						var date = new Date(data[i].date);
						var month = date.getMonth()+1;
						
						if(month.length=1){
							list+="<td>"+date.getFullYear()+"-0"+(month)+"-"+date.getDate()+"</td>";
						}else{
							list+="<td>"+date.getFullYear()+"-"+(month)+"-"+date.getDate()+"</td>";
						}
						
						list+="<td>"+data[i].clientGrade+"</td>";
						list+="<td>완료</td>";
						list+="</tr>";
						$("#t1").append(list);
					}
					
				
				}
				
			}
		})
	})
	
	$("#incomplete").click(function(){
		$.ajax({
			url:"completeReply.do",
			type:"post",
			dataType:"json",
			success:function(data){
				
				$(".data").remove();
				
				$("#total").text("Total : "+data.length);
				
				var list ="";
				
				if(data.length==0){
					list="<tr class='data'><td colspan='9'>미완료 내역이 없습니다</td></tr>";
					$("#t1").append(list);
				}else{
					for(var i=0;i<data.length;i++){
						list = "<tr class='data'>";
						list+="<td class='hiddenNum'>"+data[i].num+"</td>";
						list+="<td>"+data[i].id+"</td>";
						list+="<td>"+data[i].name+"</td>";
						list+="<td>"+data[i].title+"</td>";
						list+="<td>"+data[i].tel+"</td>";
						list+="<td>"+data[i].email+"</td>";
						var date = new Date(data[i].date);
						var month = date.getMonth()+1;
						
						if(month.length=1){
							list+="<td>"+date.getFullYear()+"-0"+(month)+"-"+date.getDate()+"</td>";
						}else{
							list+="<td>"+date.getFullYear()+"-"+(month)+"-"+date.getDate()+"</td>";
						}
						
						list+="<td>"+data[i].clientGrade+"</td>";
						list+="<td>대기중</td>";
						list+="</tr>";
						$("#t1").append(list);
					}
					
				
				}
				
			}
		})
	})
})