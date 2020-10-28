var chart;
var config;

function initChart() {
  chart = new CanvasJS.Chart("chartContainer", config);
  // newDataPoint(new Date(), 3);
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

    var dataPoints1 = [{ x: jsonData.weathers[0].data, y: jsonData.weathers[0].hora }, { x: jsonData.weathers[1].data, y: jsonData.weathers[1].hora }, { x: jsonData.weathers[2].data, y: jsonData.weathers[2].hora }]
    var dataPoints2 = [{ x: jsonData.weathers[0].data, y: jsonData.weathers[0].hora }, { x: jsonData.weathers[1].data, y: jsonData.weathers[1].hora }, { x: jsonData.weathers[2].data, y: jsonData.weathers[2].hora }]
    console.log(dataPoints1);

    var config = {
      animationEnabled: true,
      theme: "light2",
      title:{
        text: "Site Traffic"
      },
      axisX:{
        valueFormatString: "DD MMM",
        crosshair: {
          enabled: true,
          snapToDataPoint: true
        }
      },
      axisY: {
        title: "Number of Visits",
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
        name: "Total Visit",
        markerType: "square",
        xValueFormatString: "DD MMM, YYYY",
        color: "#F08080",
        dataPoints: dataPoints1 
      },
      {
        type: "line",
        showInLegend: true,
        name: "Unique Visit",
        lineDashType: "dash",
        dataPoints: [
          { x: new Date(2017, 0, 3), y: 510 },
          { x: new Date(2017, 0, 4), y: 560 },
          { x: new Date(2017, 0, 5), y: 540 }
        ]
      }]
    }

    chart = new CanvasJS.Chart("chartContainer", config);
    chart.render();

}



