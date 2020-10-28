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
        url : defaultUrl + "getRadar/" + document.getElementById("idRadar").value,
        success : function (data) {
            console.log(data)
            var radar = JSON.parse(JSON.stringify(data))
            newMapMark(radar.latitude, radar.longitude, radar.logradouro + ", " + radar.numero)
        }, error: function () {
            console.log("x")
        }
    });
}

function findWeatherAccident() {
    var fromDate = document.getElementById("fromDate").value.replaceAll("/", "-");
    var toDate = document.getElementById("toDate").value.replaceAll("/", "-");
    $.ajax({
        type : "GET",
        url : defaultUrl + "getWeatherAccidentsGraph/" + fromDate + "/" + toDate,
        success : function (data) {
            console.log(data)
            var weatherAccident = JSON.parse(JSON.stringify(data))
            
            newDataPoint(weatherAccident);
        }, error: function () {
            console.log("x")
        }
    });
}

function mudaop(){
    document.getElementById("testRest").innerHTML = "Paragraph changed!";
}
