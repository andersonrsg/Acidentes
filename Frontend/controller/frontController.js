var defaultUrl = "http://localhost:8080/acidentes/";

function getAll() {
    $.ajax({
        url: defaultUrl + "getAll",
        type: "GET",
        success: function (data) {
            document.getElementById("testRest").innerHTML = data;
        }, error: function () {
            console.log("x")
        }
    });
}

function findRadarById() {
    $.ajax({
        type : "GET",
        url : defaultUrl + "getRadar/1",
        success : function (data) {
            console.log(data)
            document.getElementById("testRest").innerHTML = data;
        }, error: function () {
            console.log("x")
        }
    });
}

function mudaop(){
    document.getElementById("testRest").innerHTML = "Paragraph changed!";
}
