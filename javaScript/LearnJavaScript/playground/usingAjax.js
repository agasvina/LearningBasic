var flickAPI = "http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?";

var ulPhoto = $("#photos");
 //submit the form
$("form").submit(function(event) {
  event.preventDefault();
  var searchKey = $("#search").val();
  var dataFlicker = {
    tags: searchKey,
    format:"json"
  };
  $.getJSON(flickAPI, dataFlicker, function(jsonFlicker) {
    $.each(jsonFlicker.items, function(i, data) {
      var liPhoto = $('<li class="grid-25 tablet-grid-50"></li>');
      var anchor = $('<a></a>');
      anchor.attr("href",data.link);
      var image = $('<img>');
      image.attr("src",data.media.m);
      anchor.append(image);
      liPhoto.append(anchor);
      ulPhoto.append(liPhoto);
    });
  });
  
});//eosubmit
