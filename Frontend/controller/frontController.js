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
            for (i = 0; i < radar.length; i++) {
                newMapMark(radar[i].latitude, radar[i].longitude, '', 'radar')
            }
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
            var placa = JSON.parse(JSON.stringify(data))
            for (i = 0; i < placa.length; i++) {
                if(placa.descricao == '1ADA OBRIGATÓRIA')
                newMapMark(placa[i].latitude, placa[i].longitude, '', 'pare')
                else if(placa.descricao == 'pref ....')
                newMapMark(placa[i].latitude, placa[i].longitude, '', 'preferencia')
            }
        }, error: function () {
            console.log("x")
        }
    });
}

function mudaop(){
    document.getElementById("testRest").innerHTML = "Paragraph changed!";
}
