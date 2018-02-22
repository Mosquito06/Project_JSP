<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="leftArea">
			 	<div id="lnbWrap">
			 		
			 		
			 		<h2 class="title">액티비티</h2>
			 		<ul class="leftMenu">
						 <li class="bMenu">
						 	<a><span>${menuType.cammping[0] }</span></a> 
				 			<c:forEach var="menu" items="${menuList }"> 
						 		<ul class="sMenu">
						 			<c:if test="${menu.type == menuType.cammping[1]}">
						 				<li><a href="${pageContext.request.contextPath }/activity.do?no=${menu.num }">${menu.name }</a></li>
						 			</c:if>
						 		</ul>
				 			</c:forEach> 
				 		</li>
				 		 
				 		<li class="bMenu">
						 	<a><span>${menuType.kidzone[0] }</span></a> 
				 			<c:forEach var="menu" items="${menuList }"> 
						 		<ul class="sMenu">
						 			<c:if test="${menu.type == menuType.kidzone[1]}">
						 				<li><a href="${pageContext.request.contextPath }/activity.do?no=${menu.num }">${menu.name }</a></li>
						 			</c:if>
						 		</ul>
				 			</c:forEach> 
				 		</li>
				 		
				 		<li class="bMenu"> 
						 	<a><span>${menuType.fitness[0] }</span></a> 
				 			<c:forEach var="menu" items="${menuList }"> 
						 		<ul class="sMenu">
						 			<c:if test="${menu.type == menuType.fitness[1]}">
						 				<li><a href="${pageContext.request.contextPath }/activity.do?no=${menu.num }">${menu.name }</a></li>
						 			</c:if>
						 		</ul>
				 			</c:forEach> 
				 		</li>
			 		</ul>
			 	</div>
			 	
			 </div>
			 
			 