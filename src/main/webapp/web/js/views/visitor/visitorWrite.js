// $(document).ready(function() {
//     alert("ㅎㅇ1111");
//
//     fn_admin_init();
//
// });

/**
 * 첫 진입시 실행할 함수.
 */
fn_admin_init = function(){

};

/**
 * 등록
 */
fn_visitor_write = function(){

    var param = {
        visitor_nm : $("#visitor_nm").val()
        ,visitor_password : $("#visitor_password").val()
        ,visitor_content : $("#visitor_content").val()
        ,visitor_hidden_yn : $("input:radio[name=visitor_hidden_yn]:checked").val()
    };
    if(confirm("저장 하시겠습니까?")) {
        $.ajax({
            url: "/visitor/insertVisitor.do",
            data: param,
            type: 'POST',
            success: function (data) {
                alert("저장성~공!.");
                location.href = "/home/home.do";
            },
            error: function (error) {
                alert("관리자에게 문의");
            }
        })
    }

};



