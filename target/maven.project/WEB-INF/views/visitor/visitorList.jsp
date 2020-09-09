<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/web/js/views/visitor/visitorList.js"></script>
<!DOCTYPE html>
<div class="bs-docs-section" style="margin-left: 10px; margin-right: 10px" style="width: 90%">
    <button type="button" class="btn btn-outline-primary" style="float : right; margin-top:15px; margin-bottom:15px; margin-right:15px;"  onclick="fn_write_move()">쓰기</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">no</th>
            <th scope="col">작성자</th>
            <th scope="col">내용</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${records}" var="dataList" varStatus="status">
        <tr class="table-secondary">
            <td>${dataList.visitor_no}</td>
            <td>${dataList.visitor_nm}</td>
            <td>${dataList.visitor_content}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>