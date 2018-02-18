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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script>
	var sel_files = [];
	var files;
	var filesArr;
	 
	$(function(){
		 $("#fileList").on("change", handleImgFileSelect);		
	})

	function fileUploadAction() {
            console.log("fileUploadAction");  
            $("#fileList").trigger('click'); 
    }

	function handleImgFileSelect(e) {
 
            // 이미지 정보들을 초기화
            sel_files = [];
            $(".imgs_wrap").empty(); 
 
            files = e.target.files;
            filesArr = Array.prototype.slice.call(files);
  
            var index = 0; 
            filesArr.forEach(function(f) {
                if(!f.type.match("image.*")) {
                    alert("확장자는 이미지 확장자만 가능합니다."); 
                    return; 
                }
 
                sel_files.push(f);

                var reader = new FileReader();
                reader.onload = function(e) {
                	  var html = "<li><a onclick=\"deleteImageAction("+index+")\" id=\"img_id_"+index+"\">삭제</a>"
             		 + "<img src=\"" + e.target.result + "\" data-file='"+f.name+"' class='selProductFile' title='Click to remove' width='150px'>"
             		 +"</li>";
                    $(".imgs_wrap").append(html); 
                    index++; 
  
                }
                reader.readAsDataURL(f);
                
            }); 
           
        }    
	
	 function deleteImageAction(index) {
         console.log("index : "+index);
         sel_files.splice(index, 1);  
         filesArr.splice(index, 1);  
         var img_id = "#img_id_"+index;
         
         $(img_id).remove(); 
		 
         console.log(sel_files);
         console.log(filesArr);
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
						<h1 id="title">메인 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">갤러리 관리</span>
						</div>
					</div>
					<div id="addForm"> 
						<form method="post" id="f1" enctype="multipart/form-data" action="adminGallery.do">
							<table>
								<tr>
									<th colspan="3">갤러리 업로드</th>
								</tr> 
								<tr> 
									<th width="150px">이미지 파일</th>
									<td colspan="2">
										<input class="btn_admin" value="이미지 추가" onclick="fileUploadAction()" type="button"/>
										<input type="file" name="imgPath" multiple="multiple" id="fileList" style="display:none;">
									</td>
								</tr>
								<tr> 
									<td colspan="3">
										<ul class="imgs_wrap">  
											<li>
												
											</li> 
										</ul>
									</td>    
								</tr> 
								<tr>
									<td colspan="3">
										<input type="submit" class="btn_admin" value="추가">
									</td>
								</tr>
							</table>
						</form> 
					</div>
					<%-- <div id="wrap_admin_btn">
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
				</div> --%>
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>