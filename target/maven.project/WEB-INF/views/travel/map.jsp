<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/web/js/views/travel/map.js"></script>
<!DOCTYPE html>
<div id="map" style="width:500px;height:400px;"></div>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b73a939c05de3edbb44943a6e08ea0d5"></script>
<%--<h1>${memo}</h1>--%>
<div id="clickLatlng"></div>
<button type="button" class="btn btn-primary" id="trafficBtn" value="0" onclick="fn_map_traffic()" style="margin-top: 15px">교통정보</button>