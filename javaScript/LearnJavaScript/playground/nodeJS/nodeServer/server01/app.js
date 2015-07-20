
var forecast = require("./forecast"); 

var LocationList = process.argv.slice(2);
LocationList.forEach( function(location, index) {
	var report = forecast.getForecast(location);
});