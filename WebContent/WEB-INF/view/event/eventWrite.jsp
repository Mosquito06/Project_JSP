<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?v=2">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/event/writeStyle.css?v=2">	
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script> 
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
<script>
	$(function(){
		$("#addEventForm").submit(function() {
			if(CKEDITOR.instances.noticeContent.getData().length < 1){
				alert("내용을 입력해 주세요.");
				return false;
			}else{
	 			var content =  CKEDITOR.instances.noticeContent.getData()
				$("#hiddenContent").val(content);
			}
		}); 
	});
</script>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<section id="section">
		<div id="contentWrap">
			<%@ include file="leftMenu.jsp"%>
				
				<form action="${pageContext.request.contextPath}/event/eventWrite.do" id="addEventForm" method="post" enctype="multipart/form-data" >
					<table id="editerTd">
						<tr>
							<td>
								<span class="titleTxt">제목</span><input type="text" name="title" class="inputTxt">
							</td>
						</tr>
						<tr> 
							<td>
								<span class="titleTxt">시작 날짜</span>
								<input type="date" name="startDate" class="inputTxt date"/>
								<i class="bar">-</i>
								<span class="titleTxt">종료 날짜</span>
								<input type="date" name="endDate" class="inputTxt date"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="titleTxt">이벤트 소개</span>
								<input type="text" name="introduce" class="inputTxt intro"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="titleTxt">배너 이미지 업로드</span>
								<input type="file" name="imgpath" class="inputTxt banner" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="form-group">
									<textarea class="form-control" name="noticeContent"
										id="noticeContent" cols="100" rows="15"></textarea>
									<script>
										CKEDITOR.replace('noticeContent');
									</script>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="저장">
								<input type="reset" value="돌아가기">
							</td>
						</tr>
					</table>
					<textarea  name="hiddenContent" id="hiddenContent">
					</textarea>
				</form>
			</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
