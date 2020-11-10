
let map, heatmap;

var mapOptions = {
  center: { lat: -30.059573, lng: -51.164712 },
  zoom: 12,
  styles: [ 
    { 
      "featureType": "poi", 
      "stylers": [ 
        { "visibility": "off" } 
      ] 
    } 
  ] 
}

function initMap() {
  map = new google.maps.Map(document.getElementById("map"), mapOptions);
}

markersRadares = []
markersPlacas = []

function newMapMark(lat,lng,label,icon) {

  var myLatLng = new google.maps.LatLng(lat, lng);

  var myMarkerOptions = {
    position: myLatLng,
    label: label,
    icon: 'assets/images/map/' + icon + '.png',
    map: map
  }
  //console.log("pingou mapa " + icon)
  var myMarker = new google.maps.Marker(myMarkerOptions);
  
  if (icon == "radar") {
    markersRadares.push(myMarker);
  } else {
    markersPlacas.push(myMarker);
  }
}

function heatMap() {
  heatmap = new google.maps.visualization.HeatmapLayer({
    data: getHeatPoints()
  });
  heatmap.setMap(map);
}

// Radares
function esconderRadares() {
    for (let i = 0; i < markersRadares.length; i++) {
      markersRadares[i].setMap(null);
    }
  }
  
  function mostrarRadares() {
    for (let i = 0; i < markersRadares.length; i++) {
      markersRadares[i].setMap(map);
    }
  }
  
  
  // Placas
  function esconderPlacas() {
    for (let i = 0; i < markersPlacas.length; i++) {
      markersPlacas[i].setMap(null);
    }
  }
  
  function mostrarPlacas() {
    for (let i = 0; i < markersPlacas.length; i++) {
      markersPlacas[i].setMap(map);
    }
  }
  