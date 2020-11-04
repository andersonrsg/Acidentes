let map;


function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: -30.027955, lng: -51.163046 },
    zoom: 13,
  });
}


function newMapMark(lat,lng,label,icon) {

  var myLatLng = new google.maps.LatLng(lat, lng);

  var myMarkerOptions = {
    position: myLatLng,
    label: label,
    icon: 'assets/images/map/' + icon + '.png',
    map: map
  }
  console.log("pingou mapa " + icon)
  var myMarker = new google.maps.Marker(myMarkerOptions);
}