var chart;
var config;

function initChart() {
  chart = new CanvasJS.Chart("chartContainer", config);
  // newDataPoint("");
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

    //var dataPoints1 = [{ x: jsonData.weathers[0].data, y: jsonData.weathers[0].hora }, { x: jsonData.weathers[1].data, y: jsonData.weathers[1].hora }, { x: jsonData.weathers[2].data, y: jsonData.weathers[2].hora }]
    // var dataPoints2 = [{ x: jsonData.weathers[0].data, y: jsonData.weathers[0].hora }, { x: jsonData.weathers[1].data, y: jsonData.weathers[1].hora }, { x: jsonData.weathers[2].data, y: jsonData.weathers[2].hora }]

    // var dataPoints1 = [{ x: new Date(2017, 0, 3), y: 1 }, { x: new Date(2017, 0, 4), y: 3 }, { x: new Date(2017, 0, 5), y: 4 }]
    // var dataPoints2 = [{ x: new Date(2017, 0, 2), y: 4 }, { x: new Date(2017, 0, 3), y: 6 }, { x: new Date(2017, 0, 4), y: 8 }, { x: new Date(2017, 0, 5), y: 9 }]

    var dataPoints1 = [];
    for (precip of jsonData.weathers) {
      var split = precip.data.split("-");
      var timeStamp = precip.timestamp * 1000;
      var d = new Date();
      d.setTime(timeStamp);
      console.log(d);
      dataPoints1.push( { x:d , y: precip.precipitacaoTotal } );
    }

    var dataPoints2 = [];
    for (precip of jsonData.weathers) {
      var split = precip.data.split("-");
      var timeStamp = precip.timestamp * 1000;
      var d = new Date();
      d.setTime(timeStamp);
      console.log(d);
      dataPoints1.push( { x:d , y: precip. } );
    }


    console.log(dataPoints1);

    var config = {
      animationEnabled: true,
      theme: "light2",
      title:{
        text: "Acidentes por precipitação total"
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
        xValueFormatString: "DD MMM, YYYY - HH:mm",
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
// [
//           { x: new Date(2017, 0, 3), y: 510 },
//           { x: new Date(2017, 0, 4), y: 560 },
//           { x: new Date(2017, 0, 5), y: 540 }
//         ]
}



