
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
						record+="<td class='center_table'>"+(i+1)+"</td>";
						record+="<td><a href='qnaRead.do?num="+data[i].num+"'>"+data[i].title+"</a></td>";
						var date = new Date(data[i].date);	
						
						var d = date.toLocaleDateString();
						
						record+="<td class='center_table'>"+d+"</td>";
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
})