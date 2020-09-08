$(document).ready(function() {
    fn_map_init();

});

/**
 * 첫 진입시 실행할 함수.
 */
fn_map_init = function(){
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(37.474650, 126.809595), //지도의 중심좌표.
        level: 4 //지도의 레벨(확대, 축소 정도)
    };


    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    var iwContent = '<div style="padding:5px;">우리집!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(37.474650, 126.809595), //인포윈도우 표시 위치입니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다


    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
    var mapTypeControl = new kakao.maps.MapTypeControl();

    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);


    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

    var marker = new kakao.maps.Marker({
        // 지도 중심좌표에 마커를 생성합니다
        position: map.getCenter()
    });
// 지도에 마커를 표시합니다
    marker.setMap(map);
    marker.setDraggable(true);

    var infowindow = new kakao.maps.InfoWindow({
        map: map, // 인포윈도우가 표시될 지도
        position : iwPosition,
        content : iwContent,
        removable : iwRemoveable
    });

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
    kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

        // 클릭한 위도, 경도 정보를 가져옵니다
        var latlng = mouseEvent.latLng;

        // 마커 위치를 클릭한 위치로 옮깁니다
        marker.setPosition(latlng);

        var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
        message += '경도는 ' + latlng.getLng() + ' 입니다';

        var resultDiv = document.getElementById('clickLatlng');
        resultDiv.innerHTML = message;

    });

    fn_map_traffic = function(){

        if($("#trafficBtn").val() ==0){
            map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
            $("#trafficBtn").val(1);
        }else{
            map.removeOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
            $("#trafficBtn").val(0);
        }
    }

};


// fn_map_traffic = function(){
//
//     var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
//     var options = { //지도를 생성할 때 필요한 기본 옵션
//         center: new kakao.maps.LatLng(37.474650, 126.809595), //지도의 중심좌표.
//         level: 4 //지도의 레벨(확대, 축소 정도)
//     };
//     var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
//
//     if($("#trafficBtn").val() ==0){
//         map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
//         $("#trafficBtn").val(1);
//     }else{
//         map.removeOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
//         $("#trafficBtn").val(0);
//     }
// }

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
                location.href = "/visitor/visitorList.do";
            },
            error: function (error) {
                alert("관리자에게 문의");
            }
        })
    }

};



