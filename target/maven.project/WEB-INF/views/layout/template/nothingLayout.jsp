<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/WEB-INF/views/layout/include/layoutCommon.jsp"%>
<%@ page import="com.yun.common.entity.Constants" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta id="myViewport" name="viewport" content="width=480,target-densitydpi=device-dpi,user-scalable=yes"/>
    <link rel="shortcut icon" href="/web/favicon.png?ver=${formatNowDateTime}">
    <!-- subpage_head [2019-05-23] -->
    <link rel="stylesheet" type="text/css" href="/web/front/styles/reset.css?ver=${formatNowDateTime}"/>
    <link rel="stylesheet" type="text/css" href="/web/front/styles/jquery-ui.css?ver=${formatNowDateTime}"/>
    <link rel="stylesheet" type="text/css" href="/web/front/styles/common.css?ver=${formatNowDateTime}"/>
    <link rel="stylesheet" type="text/css" href="/web/front/styles/subpage.css?ver=${formatNowDateTime}"/>
    <link rel="stylesheet" type="text/css" href="/web/front/styles/ui.css?ver=${formatNowDateTime}"/>
    <link rel="stylesheet" type="text/css" href="/web/front/styles/popup.css?ver=${formatNowDateTime}"/>

    <script type="text/javascript" src="/web/js/jquery-3.3.1.min.js?ver=${formatNowDateTime}"></script>

    <script type="text/javascript" src="/web/front/scripts/reset.js?ver=${formatNowDateTime}"></script>
    <script type="text/javascript" src="/web/front/libs/jquery.extend.js?ver=${formatNowDateTime}"></script>
    <%--    <script type="text/javascript" src="/web/front/libs/additional-methods.js?ver=${formatNowDateTime}"></script>--%>

    <script type="text/javascript" src="/web/front/libs/jquery-ui.js?ver=${formatNowDateTime}"></script>
    <script type="text/javascript" src="/web/front/scripts/common.js?ver=${formatNowDateTime}"></script>
    <script type="text/javascript" src="/web/front/scripts/ui.js?ver=${formatNowDateTime}"></script>
    <script type="text/javascript" src="/web/js/common/lib_global.js?ver=${formatNowDateTime}"></script>

    <!-- jQuery validation -->
    <script src="/web/js/jquery.validate.min.js?${formatNowTime}"></script>
    <script src="/web/js/additional-methods.min.js?${formatNowTime}"></script>
    <script src="/web/js/localization/messages_ko.min.js?${formatNowTime}"></script>

    <!-- commonUtil.js -->
    <script src="/web/js/commonUtil.js?${formatNowTime}"></script>


    <!-- jquery validation alert으로 뜨게-->
    <script>
        $.validator.setDefaults({
            onkeyup: false,
            onclick: false,
            onfocusout: false,
            showErrors: function(errorMap,errorList){
                if(this.numberOfInvalids()){ // 에러가 있으면
                    alert(errorList[0].message); // 경고창으로 띄움
                }
            }
        });
    </script>

    <title><%=Constants.APP_NAME%>
    </title>

</head>
	<tiles:insertAttribute name="body"></tiles:insertAttribute>
