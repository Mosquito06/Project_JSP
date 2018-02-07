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
	href="${pageContext.request.contextPath }/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/activity/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<style>
	/*페이지 타이틀*/
	#title{
		display:inline-block;
		font-size: 23px;
		color:#9c875c;
	}
	
	#wrap_home{
		margin-top:10px;
		display: inline-block;
		float: right;
		font-size: 12px;
		
	}
	#board{
		color: #865009;
		text-decoration: underline;
	}
	
	#wrap_title{
		border-bottom: #432c10 solid 5px;
		height: 47px;
		width:866px;
		margin:0px auto;
		margin-bottom:40px;
		overflow: hidden;
	}
	/*입력 form문 style*/
	
	#addEventForm{
		background: #f8f8f8;
		padding:20px;
		border:1px solid #d1d1d1;
		border-radius:5px;
	}
	
	#editerTd{
		width: 826px;
		margin: 0 auto;
	}
	#editerTd td{
		padding-bottom: 10px;
	}  
	#editerTd tr:last-child td{
		padding-bottom: 0px;
	}  
	.evenTitle{
		border:1px solid #ddd;
		height:18px;
		width:754px; 
		border-left: none;
		border-radius:0 5px 5px 0;
		padding:5px;
		float: left;
	}
	.titleTxt{  
		display:inline-block;
		width:50px;
		height:18px;
		background:#fff;
		line-height:18px;
		border:1px solid #ddd;
		border-radius:5px 0 0 5px;
		border-right:none;
		padding:5px 0px 5px 10px;
		font-size:14px;
		float: left;
	}
	
	.dateTxt{
		display:inline-block;
		width:70px;
		height:18px;
		background:#eee;
		line-height:18px;
		border:1px solid #ddd;
		border-radius:5px 0 0 5px;
		padding:5px 0px 5px 10px;
		font-size:14px; 
		float: left;
	}
	
	.date{
		border:1px solid #ddd;
		height:18px; 
		border-left: none;
		border-radius:0 5px 5px 0;
		padding:5px;
		float: left;
	}
	i.bar{	
		display:inline-block;
		height:30px;
		line-height:30px;
		text-transform:none; 
		color:#ddd;
		float: left;
		margin-left: 10px;
		margin-right: 10px;
	}
	
</style>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<section id="section">
		<div id="contentWrap">
			<%@ include file="leftMenu.jsp"%>

			<div id="rightArea">
				<div id="wrap_title">
					<h1 id="title">게시판</h1>
					<div id="wrap_home">
						<img src="../img/common/locaton.gif" id="home">
						> <span id="board">게시판</span>
					</div>
					
					
				</div>
				<form action="" id="addEventForm">
					<table id="editerTd">
						<tr>
							<td>
								<span class="titleTxt">제목</span><input type="text" name="title" class="evenTitle">
							</td>
						</tr>
						<tr> 
							<td>
								<span class="dateTxt">시작 날짜</span>
								<input type="date" name="startDate" class="date"/>
								<i class="bar">-</i>
								<span class="dateTxt">종료 날짜</span>
								<input type="date" name="endDate" class="date"/>
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
								<input type="submit" value="돌아가기">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
