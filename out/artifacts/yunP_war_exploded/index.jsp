<%--
  Created by IntelliJ IDEA.
  User: LeeYunik
  Date: 2020-08-19
  Time: 오전 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String url = "/home";
  String referrer = request.getHeader("referer");
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>

<script>

  $(document).ready(function() {
    alert('<%=referrer%>');
    goApp();
  });
  function goApp(){
    location.href='<%=url%>';
  }

</script>

<c:redirect url="<%=url%>"/>