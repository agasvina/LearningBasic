
var geocodeAPI = 'https://maps.googleapis.com/maps/api/geocode/json?address=';
var geocodeKey = '&key=AIzaSyCsSTtLd4ThP8xleny93jhTyx3jD8DUgKM';
var forecast =  'https://api.forecast.io/forecast/6fd61f79599ec5433797dad83429f757/';

var https = require("https");

function getForecast(location) {
  var geoUrl= geocodeAPI+encodeURIComponent(location)+geocodeKey;
  var request = https.get(geoUrl, function(response) {
    
    var body="";
    //reading the data. This data is JSON
    response.on('data', function(chunk) {
    	body += chunk;
    });

    response.on('end', function(){
    	//doing something when we finish reading all the data
    	var loc = JSON.parse(body);
      //console.log(body);
      var latitude = loc.results[0].geometry.location.lat;
      var longitude= loc.results[0].geometry.location.lng;

      var forecastUrl = forecast+latitude+","+longitude;
      //request the Forecast.io:
        https.get(forecastUrl, function(response) {
            var jsonResponse = "";
            response.on('data', function(chunk){
                jsonResponse += chunk;
            });
            response.on('end', function() {
                var jsonForecast = JSON.parse(jsonResponse);
                console.log("Today is " + jsonForecast.currently.summary + " in " + location);
            });
        });


    });

  }).on('error', function(error) {
    console.error(error.message);
  });

};

module.exports.getForecast = getForecast;