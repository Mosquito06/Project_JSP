<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<style>
	#phone{
		margin-top:30px;
	}
	#wrap_bus1, #wrap_bus2{
		width:100%;
		background: #f4f4f4;
		margin-bottom:10px;	
	}
	#wrap_bus1 a, #wrap_bus2 a{
		width:100%;
		display: inline-block;
	}
	#wrap_bus1 b, #wrap_bus2 b{
		float: right;
		margin-right:40px;
		line-height: 46px;
		font-size: 20px;
		color:#aaa;
	}
	#wrap_bus1 img{
		padding:15px;
	}
	#wrap_bus2 img{
		padding:15px;
	}
	#hide1,#hide2{
		display: none;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#wrap_bus1").click(function(){
			$("#hide2").hide();
			$("#wrap_bus2").find("b").text("▼");
			$("#hide1").toggle();
			if($(this).find("b").text() == "▼"){
				$(this).find("b").text("▲");
			}else{
				$(this).find("b").text("▼");
			}
			return false;
		})
		
		$("#wrap_bus2").click(function(){
			$("#hide1").hide();
			$("#wrap_bus1").find("b").text("▼");
			$("#hide2").toggle();
			if($(this).find("b").text() == "▼"){
				$(this).find("b").text("▲");
			}else{
				$(this).find("b").text("▼");
			}
			return false;
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
				<jsp:include page="leftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">오시는길</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath }/img/common/locaton.gif" id="home"> > <span
								id="board">오시는길</span>
						</div>	
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/img/info/map1.jpg">
					</div>
					<div id="phone">
						<img src="${pageContext.request.contextPath }/img/info/map2.jpg">
					</div>
					
					<div id="wrap_bus1">
						<a href="#"><img src="${pageContext.request.contextPath }/img/info/bus.gif"><b>▼</b></a>
					</div>
					
					<div id="hide1">
						<img src="${pageContext.request.contextPath }/img/info/bus2.jpg">
					</div>
					
					<div id="wrap_bus2">
						<a href="#"><img src="${pageContext.request.contextPath }/img/info/bus1.jpg"><b>▼</b></a>
					</div>
					
					<div id="hide2">
						<img src="${pageContext.request.contextPath }/img/info/bus3.jpg">
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