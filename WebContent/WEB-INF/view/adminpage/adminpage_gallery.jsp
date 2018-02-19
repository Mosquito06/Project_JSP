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
	var sel_files = [];
	var upload_files = [];
	var delete_files = [];
	$(function(){
		 $("#fileList").on("change", handleImgFileSelect);	
		 
		 $("#checkAll").on("change", checkAll);
		 
		 $("#f1").submit(function(e){
			 var selFileName = [];
			 var upFileName = [];
			 
			 for(var i=0; i<upload_files.length; i++){
				 upFileName.push(upload_files[i].name);
			 }
			 
			 $("#uploadFiles").val(upFileName);
			 
			 $("#deleteFiles").val(delete_files);
			 
			 var titleArr = [];
			 var contentArr = [];
			 var typeArr = [];
			 
			 $(".titleName").each(function(i,obj){
				 titleArr.push($(this).val());
			 });
			 $(".content").each(function(i,obj){  
				 contentArr.push($(this).val());
			 });
			 $(".type").each(function(i,obj){
				 typeArr.push($(this).find("option:selected").index());
			 }); 
			 
			 $("#titleArr").val(titleArr); 
			 $("#contentArr").val(contentArr); 
			 $("#typeArr").val(typeArr);
			 
		 }) 
	})
	
	function checkAll(){
		var checked = $("#checkAll").is(":checked");
		if(checked){
			console.log(checked);
			$(".checklist").prop("checked",true);
		}else{ 
			console.log(checked);
			$(".checklist").prop("checked",false);
		} 
	} 
 
	function fileUploadAction() { 
            console.log("fileUploadAction");  
            $("#fileList").trigger('click'); 
    }

	function handleImgFileSelect(e) {
            // 이미지 정보들을 초기화
            sel_files = [];
            upload_files = [];
            $(".imgs_wrap").empty();
 
            var files = e.target.files;
            var filesArr = Array.prototype.slice.call(files);
            
            var index = 0;  
            filesArr.forEach(function(f) {
                if(!f.type.match("image.*")) {
                    alert("확장자는 이미지 확장자만 가능합니다."); 
                    return; 
                } 
                sel_files.push(f);
                upload_files.push(f);
                var reader = new FileReader();
                reader.onload = function(e) {
                	  var html = "<li>"
                	  + "<div><input type='checkbox' class='checklist'></div>"
             		  + "<div><img src=\"" + e.target.result + "\" data-file='"+f.name+"' class='selProductFile' width='100px' height='50px'></div>"
             		  + "<div><input type='text' class='titleName'></div>"
             		  + "<div><input type='text' class='content'></div>"
             		  + "<div><select class='type'></div>" 
             		  + "<option>객실</option>" 
             		  + "<option>다이닝</option>"
             		  + "<option>액티비티</option>"
             		  + "<option>부대시설</option>"
             		  + "<option>기타</option>" 
             		  + "</select></div>"
             		  +"</li>";
       				console.log("인풋 html")
                    $(".imgs_wrap").append(html);  
                    index++;                
                } 
                reader.readAsDataURL(f);
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/Mosquito06/Project_JSP.git
            }); 
           
        }    
	
     // 이미지 삭제
	 function deleteImageAction(index) {
         console.log("index : "+index);
         delete_files.push(upload_files[index].name);
         upload_files.splice(index, 1);  
          
         $(".imgs_wrap li").eq(index).remove();
         console.log(upload_files);
     }

     //체크된 모든 이미지 삭제
	 function deleteImage(){
		 var size = $(".checklist").size();
		 
		 for(var i=size-1; i>-1; i--){
			 if($(".checklist").eq(i).is(":checked")){
				 deleteImageAction(i);
			 } 
		 }
		 
		 $("#checkAll").prop("checked",false); 
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
						<form method="post" id="f1" enctype="multipart/form-data" action="${pageContext.request.contextPath }/adminGallery.do">
							<table>
								<tr> 
									<th>갤러리 업로드</th>
								</tr>   
								<tr> 
									<td style='padding: 10px 0px;'>
										<input class="btn_admin" value="이미지 추가" onclick="fileUploadAction()" type="button"/>
										<input class="btn_admin" value="이미지 삭제" onclick="deleteImage()" type="button"/>
										<input type="file" name="file" multiple="multiple" id="fileList" style="display:none;">
										<input type="hidden" name='uploadFiles' id="uploadFiles" >
										<input type="hidden" name='deleteFiles' id="deleteFiles" >
										<input type="hidden" name='titleArr' id="titleArr" >
										<input type="hidden" name='contentArr' id="contentArr">
										<input type="hidden" name='typeArr' id="typeArr">
										<div  class='imgBox'>
											<div class="imgHead"> 
												<div><input type="checkbox" id="checkAll"></div>
												<div>이미지</div>
												<div>타이틀</div> 
												<div>내용</div>
												<div>종류</div>
											</div>
											<ul class="imgs_wrap">  
									 		 
											</ul>
										</div>  
									</td>     
								</tr>    
								<tr>
									<td colspan="3">
										<input type="submit" class="btn_admin" value="저장">
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