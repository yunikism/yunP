<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.yun.common.entity.Constants" %>
<%@include file="../include/layoutCommon.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<%--    <meta id="myViewport" name="viewport" content="width=480,target-densitydpi=device-dpi,user-scalable=yes"/>--%>
    <link type="text/css" href="${pageContext.request.contextPath}/web/ample/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <script data-ad-client="ca-pub-6056528810711682" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <!-- jquery validation alert으로 뜨게-->
<%--    <script>--%>
<%--        $.validator.setDefaults({--%>
<%--            onkeyup: false,--%>
<%--            onclick: false,--%>
<%--            onfocusout: false,--%>
<%--            showErrors: function(errorMap,errorList){--%>
<%--                if(this.numberOfInvalids()){ // 에러가 있으면--%>
<%--                    alert(errorList[0].message); // 경고창으로 띄움--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    </script>--%>

    <title><%=Constants.APP_NAME%>
    </title>

</head>
    <body>
        <div id="page">
            <tiles:insertAttribute name="header"></tiles:insertAttribute>
            <div id="body">
<%--                <tiles:insertAttribute name="left"></tiles:insertAttribute>--%>
                <tiles:insertAttribute name="body"></tiles:insertAttribute>
            </div>
            <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </div>


    </body>
</html>