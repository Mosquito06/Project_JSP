<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/adminpage/admin_banner.css?ver=1">
	
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script>
	function delBtn(){	
		var checkSize = $(".checkbox:checked").length;

		if(checkSize==0){
			alert("삭제내용이 없습니다.");
			return false;
		}
			if (!confirm("삭제하시겠습니까?")) {
		        return;
		    }
			 
			var leng = $(".checkbox").size();
			 
			for(var i=leng-1; i>-1; i--){
				if($(".checkbox").eq(i).prop("checked")){ 
					var no = $(".banNo").eq(i).text();  
					
					$.ajax({ 
				        url: contextPath + "/adminBanner.do?set=delete&no="+no,
				        type:"post",
				        dataType : "json",
				        success: function(json){
				        	console.log(json);
				        	var res = json.result
				        	if(res == 1){
				        		$(".checkbox").eq(i).parents("tr").remove();
				        	}else{    
				        		console.log("삭제실패");
				        	}
				        }
				    })  
				}
			}
		}
	
	function isEmpty(){
		var err = true;
		
		$(".import").each(function(j,obj){
			if($(this).val()==""){
				err = false;
			}
		})
		
		return err;
	}
	
	
	$(function(){
		$("#submit").click(function(){

			var empty = isEmpty();
			
			if(empty==false){
				alert("빈칸이 존재합니다.");
				return false;
			}

			if(empty){
				$("#f1").submit();
			}
			
		})
	})
</script>
</head>
<body> 
	<div> 
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="admin_leftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">메인 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">메인 관리</span>
						</div>
					</div>
					<div id="addForm"> 
						<form method="post" id="f1" enctype="multipart/form-data" action="adminBanner.do?set=insert">
							<table>
								<tr>
									<th colspan="2">배너 업로드</th>
								</tr>
								<tr>
									<th>이미지 파일</th>
									<td><input type="file" name="imgPath" class="import"></td>
								</tr>
								<tr>
									<th>링크 업로드</th>
									<td><input type="text" name="linkPath" class="import"></td> 
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" class="btn_admin" id="submit" value="추가">
									</td>
								</tr>
							</table> 
						</form> 
					</div>
					<div id="wrap_admin_btn">
							<a href="#" class="btn_admin" onclick="delBtn()">선택 삭제</a></div>
					<div> 
						<table id="t1">
							<tr>
								<th width="25px"></th> 
								<th width="75px">배너번호</th>
								<th >링크경로</th>
								<th width="220px">이미지경로</th>   
							</tr>
							<c:forEach items="${list}" var="item">
								<tr> 
									<td><input type="checkbox" class="checkbox"></td>
									<td class="banNo">${item.no}</td>
									<td>${item.linkPath}</td>
									<td ><img src="${item.imgPath}" width="200px"></td>
								</tr>
							</c:forEach> 
						</table>
					</div>  
				</div>
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>