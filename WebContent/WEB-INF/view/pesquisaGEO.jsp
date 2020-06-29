<!DOCTYPE html>
<!-- <html xmlns:th="http://www.thymeleaf.org"> -->
<head>
  <meta charset="UTF-8" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
  <title>Busca GEO</title>
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 
</head>
<body class="grey lighten-3" >
  <div id="formularioGeolocalizacao" class="container">
    <h3 class="main-title center">GEO Localização dos Robos</h3>
    <div class="row">

      <div id="map" style="width: 100%; height: 500px;"></div>
      
   <script type="text/javascript">      
        function initMap() {
    var poa = {
        lat :  -30.1087954,
        lng : -51.3175698
    };
   
    var map = new google.maps.Map(document.getElementById('map'), {
        center : poa,
        scrollwheel : false,
        zoom : 8
    });

    var marker = new google.maps.Marker({
        position : poa,
        label:"R1"
    });
    marker.setMap(map);
}
        </script>   
    </div>
  </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

 
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBfkB-U2jb53ACFhVgtBYhPCQ4ohhcqVEk&callback=initMap&libraries=&v=weekly"
      defer
    ></script>
  
</body>
</html>