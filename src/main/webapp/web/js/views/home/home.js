$(document).ready(function() {
    fn_home_init();

});

/**
 * 첫 진입시 실행할 함수.
 */
fn_home_init = function(){
    //fn_lotto_api();

    var $form = $( "#form" );
    var $input = $form.find( "input" );

    $input.on( "keyup", function( event ) {

        // 1.
        var selection = window.getSelection().toString();
        if ( selection !== '' ) {
            return;
        }

        // 2.
        if ( $.inArray( event.keyCode, [38,40,37,39] ) !== -1 ) {
            return;
        }

        // 3
        var $this = $( this );
        var input = $this.val();

        // 4
        var input = input.replace(/[\D\s\._\-]+/g, "");

        // 5
        input = input ? parseInt( input, 10 ) : 0;

        // 6
        $this.val( function() {
            return ( input === 0 ) ? "" : input.toLocaleString( "en-US" );
        });

    } );

};

/**
 *
 */
fn_test_move = function(){
    location.href = "/test/test.do";
};


/**
 * api
 */
fn_lotto_api = function(){

    var param = {
        visitor_nm : $("#visitor_nm").val()
        ,visitor_password : $("#visitor_password").val()
        ,visitor_content : $("#visitor_content").val()
        ,visitor_hidden_yn : $("input:radio[name=visitor_hidden_yn]:checked").val()
    };
        $.ajax({
            url: "/home/lottoApi.do",
            data: param,
            type: 'POST',
            success: function (data) {
                alert("저장성~공!.");
                location.href = "/visitor/visitorList.do";
            },
            error: function (error) {
                alert("관리자에게 문의");
            }
        })

};


/**
 * api
 */
fn_lotto_cal = function(){

    var lottoBuy = $('#lottoBuy').val()
    lottoBuy = lottoBuy.replace(/,/gi,"");

    var cnt = lottoBuy / 1000;

    if(cnt>10000){
        alert("1,000만원 이하만 구매가 가능합니다.");
        return false;
    }

    if(cnt<1){
        alert("1,000원 이상 구매 가능합니다.");
        return false;
    }

    alert(cnt + " 개 구매.");

    var param = {
        cnt : cnt
        ,drwtNo1 : $("#drwtNoArr1").val()
        ,drwtNo2 : $("#drwtNoArr2").val()
        ,drwtNo3 : $("#drwtNoArr3").val()
        ,drwtNo4 : $("#drwtNoArr4").val()
        ,drwtNo5 : $("#drwtNoArr5").val()
        ,drwtNo6 : $("#drwtNoArr6").val()
        ,bnusNo : $("#bnusNo").val()
    };

    $.ajax({
        url: "/home/lottoResult.do",
        data: param,
        dataType : "html",
        type: 'POST',
        success: function (data) {

            alert("완료.");
            $("#view_con").html(data);
        },
        error: function (error) {
            alert("관리자에게 문의");
        }
    })

};


function fn_layer_popup(prize){

    var pop =$("#poppop").val();

    if(pop=="N"){
        if(prize==1){
            $("#popup_layer").text($("#prizeNo0").val());
        }else if(prize==2){
            $("#popup_layer").text($("#prizeNo1").val());
        }else if(prize==3){
            $("#popup_layer").text($("#prizeNo2").val());
        }else if(prize==4){
            $("#popup_layer").text($("#prizeNo3").val());
        }else if(prize==5){
            $("#popup_layer").text($("#prizeNo4").val());
        }

        var _x = event.clientX + document.body.scrollLeft;
        var _y = event.clientY + document.body.scrollTop;
        var layer = document.getElementById("popup_layer");

        if(_x < 0) _x = 0;
        if(_y < 0) _y = 0;

        layer.style.left = _x+"px";
        layer.style.top = _y+"px";

        $("#poppop").val("Y");

        layer.style.visibility="visible";
    }else{

        $("#poppop").val("N");
        var layer = document.getElementById("popup_layer");
        layer.style.visibility="hidden";
    }
}