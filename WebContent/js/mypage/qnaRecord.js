
$(function(){
	$.ajax({
		url:"qnaRecord.do",
			type:"post",
			data:{"id":$("#hiddenId").val()},
			dataType:"json",
			success:function(data){
				
				var record ="";
				
				if(data.length==0){
					record+="<tr><td colspan='4' id='noRecord'>문의내역이 없습니다.</td></tr>";
				
				}else{
					
					for(var i=0;i<data.length;i++){
						record+="<tr>";
						record+="<td>"+(i+1)+"</td>";
						record+="<td><a href='#'>"+data[i].title+"</a></td>";
						record+="<td>"+data[i].date+"</td>";
						record+="<td>"+(i+1)+"</td>";
					}
					
				}
				
				$("#tableRecord").append(record);
		}
	})
})