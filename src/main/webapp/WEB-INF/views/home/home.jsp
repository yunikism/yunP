<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/web/js/views/home/home.js"></script>
<html>
<head>
  <title>yunikism.com</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/web/img/monGol3.png"/>
<h1>${memo}</h1>
<a>DB 가져오기</a>
<%--<img src="img/yunikismCom.png"></img>--%>
<button type="button" class="btnui" onclick="fn_test_move()"><span>이동</span></button>
<%--<button type="button" class="btnui" onclick=""><span>이동</span></button>--%>
</body>
</html>

<script>
</script>