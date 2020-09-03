<!-- Header -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="bs-component">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">yunikism</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" value="0" id="navbarColor033" onclick="fn_test_test()" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="navbarColor03" style="">
            <ul class="navbar-nav mr-auto">
                    <!-- 개발에서 넣어줘야할 부분 [2019-05-27] -->
                    <%@include file="/WEB-INF/views/layout/header/gnb_data.jsp"%>
                    <!-- // 개발에서 넣어줘야할 부분 [2019-05-27] -->
            </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                </form>
        </div>
    </nav>
</div>
<div class="bs-docs-section" style="margin-left: 10px">


<script>

    fn_test_test = function(){

        var val = $('#navbarColor033').val();

        if(val==1){
            $('#navbarColor033').attr("aria-expanded",false);
            document.getElementById("navbarColor033").className = "navbar-toggler collapsed";
            document.getElementById("navbarColor03").className = "navbar-collapse collapse";
            $('#navbarColor033').val(0);
        }else{

            $('#navbarColor033').attr("aria-expanded",true);
            document.getElementById("navbarColor033").className = "navbar-toggler";
            document.getElementById("navbarColor03").className = "navbar-collapse collapse show";
            $('#navbarColor033').val(1);

        }

    };
</script>
