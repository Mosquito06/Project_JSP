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
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/adminpage/admin_banner.css?ver=1">
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
					var img = $(".img").eq(i).attr("src");
					$.ajax({ 
				        url: contextPath + "/adminActivityList.do?no="+no+"&img="+img,
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
						<h1 id="title">액티비티 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">액티비티 관리</span>
						</div>
					</div> 
					<div id="wrap_admin_btn">
							<a href="#" class="btn_admin" onclick="delBtn()">선택 삭제</a>
							<a href="${pageContext.request.contextPath}/adminActivityWrite.do" class="btn_admin" >추가</a>
					</div>
					<div>
						<table id="t1">
							<tr> 
								<th></th> 
								<th>번호</th>
								<th>메뉴명</th>
								<th>배너이미지</th> 
								<th>분류</th>
							</tr>
							<c:if test="${error!=null}">
							<tr>
								<td colspan="6">
									${error }
								</td>
							</tr>
							</c:if>  
							<c:if test="${list!=null}">
								<c:forEach items="${list}" var="item"> 
									<tr> 
										<td><input type="checkbox" class="checkbox"></td> 
										<td class="galNo">${item.num}</td>
										<td><a href="#">${item.name}</a></td>
										<td><img src="${item.imgPath}" class="img" width="150"></td>
										<td>${item.type}</td> 
									</tr>
								</c:forEach>
							</c:if>
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