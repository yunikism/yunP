<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/web/js/views/home/home.js"></script>
<!DOCTYPE html>


<%--    <img src="${pageContext.request.contextPath}/web/img/monGol3.png"/>--%>
<%--    <h1>${memo}</h1>--%>
<div>
    <div style="margin-top:15px;">
        <h2>제&nbsp;${drwNo}&nbsp;회 Lotto 당첨번호</h2>
<%--        <h4>추첨일자 : ${drwNoDate} / 1등 당첨자 수 : ${firstPrzwnerCo} 명 / 1등 당첨금액 : <fmt:formatNumber value="${firstWinamnt}" pattern="#,###"/> 원</h4>--%>
        <h4>추첨일자 : ${drwNoDate}</h4>
        <h4>1등 당첨자 수 : ${firstPrzwnerCo} 명</h4>
        <h4>1등 당첨금액 : <fmt:formatNumber value="${firstWinamnt}" pattern="#,###"/> 원</h4>
    </div>
    <input type="hidden" id="drwtNoArr1" name="drwtNoArr1" value="${drwtNoArr[1]}">
    <input type="hidden" id="drwtNoArr2" name="drwtNoArr2" value="${drwtNoArr[2]}">
    <input type="hidden" id="drwtNoArr3" name="drwtNoArr3" value="${drwtNoArr[3]}">
    <input type="hidden" id="drwtNoArr4" name="drwtNoArr4" value="${drwtNoArr[4]}">
    <input type="hidden" id="drwtNoArr5" name="drwtNoArr5" value="${drwtNoArr[5]}">
    <input type="hidden" id="drwtNoArr6" name="drwtNoArr6" value="${drwtNoArr[6]}">
    <input type="hidden" id="bnusNo" name="bnusNo" value="${bnusNo}">
    <div style="margin-top:15px;">
        <c:choose>
            <c:when test="${drwtNoColArr[1] == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[1]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[1] == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[1]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[1] == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[1]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[1] == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[1]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[1] == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[1]}&nbsp;</h1></span>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${drwtNoColArr[2] == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[2]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[2] == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[2]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[2] == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[2]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[2] == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[2]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[2] == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[2]}&nbsp;</h1></span>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${drwtNoColArr[3] == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[3]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[3] == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[3]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[3] == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[3]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[3] == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[3]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[3] == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[3]}&nbsp;</h1></span>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${drwtNoColArr[4] == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[4]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[4] == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[4]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[4] == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[4]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[4] == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[4]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[4] == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[4]}&nbsp;</h1></span>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${drwtNoColArr[5] == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[5]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[5] == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[5]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[5] == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[5]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[5] == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[5]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[5] == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[5]}&nbsp;</h1></span>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${drwtNoColArr[6] == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[6]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[6] == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[6]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[6] == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[6]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[6] == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[6]}&nbsp;</h1></span>
            </c:when>
            <c:when test="${drwtNoColArr[6] == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${drwtNoArr[6]}&nbsp;</h1></span>
            </c:when>
        </c:choose>
        <h1 style="float:left">&nbsp;+&nbsp; </h1>
        <c:choose>
            <c:when test="${bnusNoCol == '0'}">
                <span class="badge badge-pill badge-danger" style="float:left;margin-right:10px;"><h1>&nbsp;${bnusNo}&nbsp;</h1></span>
            </c:when>
            <c:when test="${bnusNoCol == '1'}">
                <span class="badge badge-pill badge-info" style="float:left;margin-right:10px;"><h1>&nbsp;${bnusNo}&nbsp;</h1></span>
            </c:when>
            <c:when test="${bnusNoCol == '2'}">
                <span class="badge badge-pill badge-primary" style="float:left;margin-right:10px;"><h1>&nbsp;${bnusNo}&nbsp;</h1></span>
            </c:when>
            <c:when test="${bnusNoCol == '3'}">
                <span class="badge badge-pill badge-warning" style="float:left;margin-right:10px;"><h1>&nbsp;${bnusNo}&nbsp;</h1></span>
            </c:when>
            <c:when test="${bnusNoCol == '4'}">
                <span class="badge badge-pill badge-success" style="float:left;margin-right:10px;"><h1>&nbsp;${bnusNo}&nbsp;</h1></span>
            </c:when>
        </c:choose>
    </div>
    <br>
    <br>
    <form id="form" method="post" action="">
    <div style="margin-top:50px;">
        <h5>로또 구매 시뮬레이션</h5>
        <input type="text" class="form-control" placeholder="구입할금액" id="lottoBuy" style="width: 300px; float:left;margin-right:1px;" pattern="#,###" >
        <small class="text-muted" style="float:left;margin-right:10px;">원</small>
        <button type="button" class="btn btn-primary" onclick="fn_lotto_cal()" style="float:left;">구입하기</button>
        <br>
        <br>
    </div>
    </form>
<%--    <br>--%>
<%--    <br>--%>
<%--    <div class="bs-docs-section" style="width: 400px">--%>
<%--        <table class="table table-hover" id = "boardList" border = "1" style="text-align: center;"></table>--%>
<%--    </div>--%>
    <br>
    <br>
    <div class="view_con" id="view_con">
    </div>
</div>