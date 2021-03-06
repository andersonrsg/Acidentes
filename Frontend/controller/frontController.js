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

var fetchedRadar = false;
function getRadar() {
    var selected = document.getElementById("radarCheckbox").checked
    if (fetchedRadar) {
        if (selected) {
            mostrarRadares()
        } else {
            esconderRadares()
        }
    } else {
        $.ajax({
            type : "GET",
            url : defaultUrl + "getRadar",
            success : function (data) {
                fetchedRadar = true;
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
                // console.log(limites)
            }, error: function () {
                console.log("x")
            }
        });
    }
    
    console.log("SELECTED");
    console.log(selected);
    
}

var fetchedPlacas = false;
function getPlaca() {
    var selected = document.getElementById("placasCheckbox").checked
    if (fetchedPlacas) {
        if (selected) {
            mostrarPlacas()
        } else {
            esconderPlacas()
        }
    } else {
        $.ajax({
            type : "GET",
            url : defaultUrl + "getPlaca",
            success : function (data) {
                fetchedPlacas = true;
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
        url : defaultUrl + "getAccidentsByAgeGroup/" + selected + "/" + fromDate + "/" + toDate,
        success : function (data) {
            console.log("Ages")
            console.log(data)
            var ages = JSON.parse(JSON.stringify(data))
            
            graficoIdade(ages);
        }, error: function () {
            console.log("x")
        }
    });
}

function findAccidentType() {
    var selected = document.getElementById("accidentSelect").value
    var fromDate = document.getElementById("fromDate").value.replaceAll("/", "-");
    var toDate = document.getElementById("toDate").value.replaceAll("/", "-");
    $.ajax({
        type : "GET",
        url : defaultUrl + "getAccidentsType/" + selected + "/" + fromDate + "/" + toDate,
        success : function (data) {
            console.log(data)
            var types = JSON.parse(JSON.stringify(data))
            
            accidentType(types);
        }, error: function () {
            console.log("x")
        }
    });
}

var fetchedAcidentes = false;
function getAccidentsLocation(flag) {
    var selected = document.getElementById("acidentesCheckbox").checked
    if (!flag && fetchedAcidentes) {
        if (selected) {
            mostrarAcidentes()
        } else {
            esconderAcidentes()
        }
    } else {
        limpaMarcasAcidentes();
        var selected = document.getElementById("accidentSelect").value
        var fromDate = document.getElementById("fromDate").value.replaceAll("/", "-");
        var toDate = document.getElementById("toDate").value.replaceAll("/", "-");
        $.ajax({
            type : "GET",
            url : defaultUrl + "getAccidentsLocation/" + selected + "/" + fromDate + "/" + toDate,
            success : function (data) {
                fetchedAcidentes = true;
                $( "#acidentesCheckbox" ).prop( "disabled", false );
                console.log(data)
                var coords = JSON.parse(JSON.stringify(data))
                for (i = 0; i < coords.length; i++) {
                    newMapMark(coords[i].latitude, coords[i].longitude, '', 'acidente')
                    document.getElementById("acidentesCheckbox").checked = true;

                }
            }, error: function () {
                console.log("x Acid Loc")
            }
        });
    }
}

function mudaop(){
    document.getElementById("testRest").innerHTML = "Paragraph changed!";
}


