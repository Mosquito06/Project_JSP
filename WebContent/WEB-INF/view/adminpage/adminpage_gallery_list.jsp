<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/adminpage/admin_banner.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/adminpage/admin_gallery.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script> 
<script>
	function delBtn(){	
			if (!confirm("삭제하시겠습니까?")) {
		        return;
		    }
			 
			var leng = $(".checkbox").size();
			
			for(var i=leng-1; i>-1; i--){
				if($(".checkbox").eq(i).prop("checked")){  
					var no = $(".galNo").eq(i).text();  
					var img = $(".img").eq(i).text();
					$.ajax({ 
				        url: contextPath + "/adminGalleryList.do?no="+no+"&img="+img,
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
						<h1 id="title">갤러리 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">갤러리 관리</span>
						</div>
					</div>
					<div id="wrap_admin_btn">
							<a href="#" class="btn_admin" onclick="delBtn()">선택 삭제</a></div>
					<div> 
						<table id="t1">
							<tr>
								<th></th> 
								<th>갤러리번호</th>
								<th>타이틀</th>
								<th>내용</th> 
								<th>이미지</th> 
								<th>타입</th> 
							</tr>
							<c:if test="${error }!=null">
							<tr>
								<td colspan="6">
									${error }
								</td>
							</tr>
							</c:if>
							<c:forEach items="${list}" var="item">
								<tr> 
									<td><input type="checkbox" class="checkbox"></td>
									<td class="galNo">${item.num}</td>
									<td>${item.name}</td>
									<td>${item.content}</td>
									<td class="img">${item.path}</td>
									<td>${item.type}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>