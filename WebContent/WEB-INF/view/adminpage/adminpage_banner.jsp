<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script>
	$(function(){
		$("#f1").submit(function(){
				var imgPath = $("input[name='file']").val();
				var linkPath = $("input[name='link']").val(); 
				
				console.log("test");
				$.ajax({ 
			        url: contextPath + "/adminBanner.do?set=insert",	
			        type:"post",
			        data:{"imgPath":imgPath,"linkPath":linkPath},
			        dataType : "json",  
			        success: function(json){
			        	console.log(json);
			        }
			    })  
			    return false; 
		});
		
	})
	function delBtn(){	
			if (!confirm("삭제하시겠습니까?")) {
		        return;
		    }
			  
			$(".checkbox").each(function(i,obj){
				if($(this).prop("checked")){ 
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
			})    
		}
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
						<h1 id="title">문의관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">문의관리</span>
						</div>
					</div>
					<div id="addForm"> 
						<form method="post" id="f1">
							<p>이미지 업로드 : <input type="file" name="file"></p>
							<p>링크 주소 : <input type="text" name="link"> </p>
							<input type="submit" class="btn_admin" value="추가">
						</form> 
					</div>
					<div id="wrap_admin_btn">
							<a href="#" class="btn_admin" onclick="delBtn()">선택 삭제</a></div>
					<div> 
						<table id="t1">
							<tr>
								<th></th>
								<th>배너번호</th>
								<th>링크경로</th>
								<th>이미지경로</th> 
							</tr>
							<c:forEach items="${list}" var="item">
								<tr> 
									<td><input type="checkbox" class="checkbox"></td>
									<td class="banNo">${item.no}</td>
									<td>${item.linkPath}</td>
									<td>${item.imgPath}</td>
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