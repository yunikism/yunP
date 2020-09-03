<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="ctx" value="${req.contextPath}"/>
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:formatDate 	value="${now}" 					type="date" var="formatNowDateTime" 		pattern="yyyyMMddHH"/>
<fmt:formatDate 	value="${now}" 					type="date" var="formatNowTime" 		pattern="yyyyMMddHHmmssSS"/>