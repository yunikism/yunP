<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<div class="section">
    <div class="bs-docs-section" style="width: 1000px">
        <input type="hidden" id="prizeNo0" name="prizeNo0" value="${prizeNo[0]}">
        <input type="hidden" id="prizeNo1" name="prizeNo1" value="${prizeNo[1]}">
        <input type="hidden" id="prizeNo2" name="prizeNo2" value="${prizeNo[2]}">
        <input type="hidden" id="prizeNo3" name="prizeNo3" value="${prizeNo[3]}">
        <input type="hidden" id="prizeNo4" name="prizeNo4" value="${prizeNo[4]}">
        <input type="hidden" id="poppop" name="poppop" value="N">
        <table class="table table-hover" style="text-align: center;">
            <thead>
            <tr>
                <th scope="col">등수</th>
                <th scope="col">당첨횟수</th>
                <th scope="col" style="width: 50%">당첨기준(확률)</th>
                <th scope="col" >당첨번호</th>
            </tr>
            </thead>
            <tbody>
            <tr class="table-secondary">
                <td>1등</td>
                <td><h4>${prize[0]}</h4></td>
                <td>6개 번호 일치(1 / 8,145,060)</td>
                <td><input class="btn btn-outline-primary" type="button" value="당첨번호" onclick="fn_layer_popup(1)"></td>
            </tr>
            <tr class="table-primary">
                <td>2등</td>
                <td><h4>${prize[1]}</h4></td>
                <td>5개 번호 일치 + 보너스 번호 일치(1 / 1,357,510)</td>
                <td><input class="btn btn-outline-primary" type="button" value="당첨번호" onclick="fn_layer_popup(2)"></td>
            </tr>
            <tr class="table-secondary">
                <td>3등</td>
                <td><h4>${prize[2]}</h4></td>
                <td>5개 번호 일치(1 / 35,724)</td>
                <td><input class="btn btn-outline-primary" type="button" value="당첨번호" onclick="fn_layer_popup(3)"></td>
            </tr>
            <tr class="table-primary">
                <td>4등</td>
                <td><h4>${prize[3]}</h4></td>
                <td>4개 번호 일치(1 / 733)</td>
                <td><input class="btn btn-outline-primary" type="button" value="당첨번호" onclick="fn_layer_popup(4)"></td>
            </tr>
            <tr class="table-secondary">
                <td>5등</td>
                <td><h4>${prize[4]}</h4></td>
                <td>3개 번호 일치(1 / 45)</td>
                <td><input class="btn btn-outline-primary" type="button" value="당첨번호" onclick="fn_layer_popup(5)"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

    <div id="popup_layer" style="position:absolute;  top:100px; left:100px;
width:140px;height:auto;z-index:1;visibility:hidden;background-color:white; border-style:dashed">
<%--       <input type="textarea" id="popInput" value="">--%>
    </div>

<%--<div class="card border-primary mb-3" id="popup_layer" style="background-color:white;position:absolute;visibility:hidden; top:100px; left:100px;width:140px;height:auto; overflow:auto">--%>
<%--    <div class="card-header">당첨된 번호</div>--%>
<%--    <div class="card-body" id="popup_layer_txt">--%>
<%--    </div>--%>
<%--</div>--%>