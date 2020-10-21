let map;

function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: -30.027955, lng: -51.163046 },
    zoom: 13,
  });
}


function newMapMark(lat,lng,label) {

  var myLatLng = new google.maps.LatLng(lat, lng);

  var myMarkerOptions = {
    position: myLatLng,
    label: label,
    map: map
  }
  console.log("pingou mapa")
  var myMarker = new google.maps.Marker(myMarkerOptions);
}