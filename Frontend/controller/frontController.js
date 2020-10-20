var defaultUrl = "http://localhost:8080/acidentes/";




function getAll() {
    $.ajax({
        url: defaultUrl + "getAll",
        type: "GET",
        dataType : "json",
        success: function (data) {
            console.log("GET DATA API RESPONSE - ID::"+data.id);
            console.log("GET DATA API RESPONSE - NAME::"+data.name);
        }, error: function () {
            console.log("x")
        }
    });
}



function findRadarByIdx() {
    $.ajax({
        type : 'GET',
        url : defaultUrl + "gerRadar/" + 1,
        dataType : "json",
        success : function (result) {
            document.getElementById("testRest").innerHTML = result;
        },
        error : function (error) {
            document.getElementById("testRest").innerHTML = "deu radar rui2m3";
        }
    });
}


function mudaop(){
    document.getElementById("testRest").innerHTML = "Paragraph changed!";
}
