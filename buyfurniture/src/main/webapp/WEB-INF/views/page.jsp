<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
    
    <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> Buy Furniture  ${title }</title>
    
    <script>
     
       window.menu='${title}' ;
    
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- bootstrap readable theme -->
 <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">   

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>

		<!-- page content -->

		<div class="content">

			<!-- home.jsp -->

			<c:if test="${userClickHome == true}">

				<%@include file="./home.jsp"%>

			</c:if>

			<!-- load only when user clicks about -->
			<c:if test="${userClickAbout == true}">

				<%@include file="./about.jsp"%>

			</c:if>

			<!-- load only when user clicks conatct -->
			<c:if test="${userClickContact == true}">

				<%@include file="./contact.jsp"%>

			</c:if>
			
			<!-- load only when user clicks all products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">

				<%@include file="listProduct.jsp"%>

			</c:if>


		</div>


		<!--footer  -->

		<%@include file="./shared/footer.jsp"%>



		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js }/bootstrap.min.js"></script>

		<!-- self coded javascript -->

		<script src="${js }/myapp.js"></script>

	</div>

</body>

</html>
