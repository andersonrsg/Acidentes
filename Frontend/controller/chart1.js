var chart;
var config;

function initChart() {
  chart = new CanvasJS.Chart("chartContainer", config);
}

function toogleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  } else{
    e.dataSeries.visible = true;
  }
  chart.render();
}

function newDataPoint(jsonData) {

    var dataPoints1 = [];
    for (precip of jsonData.weathers) {
      var split = precip.data.split("-");
      var timeStamp = precip.timestamp * 1000;
      var d = new Date();
      d.setTime(timeStamp);
      // console.log(d);
      dataPoints1.push( { x:d , y: precip.precipitacaoTotal } );
    }

    var dataPoints2 = [];
    var dates = new Set(); 

    for (dateC of jsonData.dateCount) {
      var d = new Date(dateC.date);

      dataPoints2.push( { x:d , y: dateC.count } );
    }

    // console.log(dataPoints1);

    var config = {
      animationEnabled: true,
      theme: "light2",
      title:{
        text: "Relação de acidentes com precipitação no horário"
      },
      axisX:{
        valueFormatString: "DD MMM YYYY",
        crosshair: {
          enabled: true,
          snapToDataPoint: true
        }
      },
      axisY: {
        title: "",
        crosshair: {
          enabled: true
        }
      },
      toolTip:{
        shared:true
      },  
      legend:{
        cursor:"pointer",
        verticalAlign: "bottom",
        horizontalAlign: "left",
        dockInsidePlotArea: true,
        itemclick: toogleDataSeries
      },
      data: [{
        type: "line",
        showInLegend: true,
        name: "Acidentes",
        markerType: "square",
        xValueFormatString: "DD MMM, YYYY",
        color: "#F08080",
        dataPoints: dataPoints2
      },
      {
        type: "line",
        showInLegend: true,
        name: "Precipitação",
        lineDashType: "dash",
        xValueFormatString: "DD MMM, YYYY - HH:mm",
        color: "#338DFF",
        dataPoints: dataPoints1
      }]
    }

    chart = new CanvasJS.Chart("chartContainer", config);
    chart.render();

}



