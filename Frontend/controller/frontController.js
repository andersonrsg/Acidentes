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

function getRadar() {
    $.ajax({
        type : "GET",
        url : defaultUrl + "getRadar",
        success : function (data) {
            console.log(data)
            var radar = JSON.parse(JSON.stringify(data))
            let limites = [0,0,0,0,0] // km30,40,60,80,99
            for (i = 0; i < radar.length; i++) {
                if(radar[i].limite == 30) limites[0]++;
                else if(radar[i].limite == 40) limites[1]++;
                else if(radar[i].limite == 60) limites[2]++;
                else if(radar[i].limite == 80) limites[3]++;
                else limites[4]++;
                newMapMark(radar[i].latitude, radar[i].longitude, '', 'radar')
            }
            graficoRadares(limites);
            console.log(limites)
        }, error: function () {
            console.log("x")
        }
    });
}

function getPlaca() {
    $.ajax({
        type : "GET",
        url : defaultUrl + "getPlaca",
        success : function (data) {
            console.log(data)
            //console.log("mah oe")
            var placa = JSON.parse(JSON.stringify(data))
            for (i = 0; i < placa.length; i++) {
                if(placa[i].descricao == "PARADA OBRIGATORIA")
                    newMapMark(placa[i].latitude, placa[i].longitude, '', 'pare')
                else if(placa[i].descricao == "DE A PREFERENCIA")
                    newMapMark(placa[i].latitude, placa[i].longitude, '', 'preferencia')
                else newMapMark(placa[i].latitude, placa[i].longitude, '', 'escola')
            }
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

function findAccidentSpeedMonitor() {
    var fromDate = document.getElementById("fromDate").value.replaceAll("/", "-");
    var toDate = document.getElementById("toDate").value.replaceAll("/", "-");
    // $.ajax({
    //     type : "GET",
    //     url : defaultUrl + "getWeatherAccidentsGraph/" + fromDate + "/" + toDate,
    //     success : function (data) {
    //         console.log(data)
    //         var weatherAccident = JSON.parse(JSON.stringify(data))
            
            // newDataPoint(weatherAccident);
    //     }, error: function () {
    //         console.log("x")
    //     }
    // });
}

function findAges() {
    var selected = document.getElementById("accidentSelect").value
    var fromDate = document.getElementById("fromDate").value.replaceAll("/", "-");
    var toDate = document.getElementById("toDate").value.replaceAll("/", "-");
    $.ajax({
        type : "GET",
        url : defaultUrl + "getAccidentsByAgeGroup/" + selected,// + "/" + fromDate + "/" + toDate,
        success : function (data) {
            console.log(data)
            var ages = JSON.parse(JSON.stringify(data))
            
            graficoIdade(ages);
        }, error: function () {
            console.log("x")
        }
    });
}


function mudaop(){
    document.getElementById("testRest").innerHTML = "Paragraph changed!";
}
