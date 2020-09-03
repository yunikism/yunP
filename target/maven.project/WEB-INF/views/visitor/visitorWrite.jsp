<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/web/js/views/visitor/visitorWrite.js"></script>
<!DOCTYPE html>

<div class="bs-docs-section" style="margin-left: 50px">
    <div class="row">
        <div class="form-group">
            <label class="col-form-label" for="visitor_nm">이름</label>
            <input type="text" class="form-control" placeholder="이름" id="visitor_nm" name="visitor_nm" style="width: 500px">
        </div>
    </div>
    <div class="row">
        <div class="form-group">
            <label for="visitor_password">비밀번호</label>
            <input type="password" class="form-control" id="visitor_password" name="visitor_password" placeholder="비밀번호" style="width: 500px">
        </div>
    </div>
    <div class="row">
        <div class="form-group">
            <label for="visitor_content">내용</label>
            <textarea class="form-control" id="visitor_content" name="visitor_content" rows="5" style="margin-top: 0px; margin-bottom: 0px; height: 149px; width: 500px" ></textarea>
        </div>
    </div>
    <div class="row">
        <fieldset class="form-group">
            <legend>공개 여부</legend>
            <div class="custom-control custom-radio">
                <input type="radio"  name="visitor_hidden_yn" id = "hi" class="custom-control-input" value="N" >
                <label class="custom-control-label" for="hi" >공개</label>
            </div>
            <div class="custom-control custom-radio">
                <input type="radio"  name="visitor_hidden_yn" id = "hi1" class="custom-control-input" value="Y" checked="">
                <label class="custom-control-label" for="hi1">비공개</label>
            </div>
        </fieldset>
    </div>
    <div class="row">
        <button type="button" class="btn btn-primary" onclick="fn_visitor_write()">저장</button>
    </div>
</div>