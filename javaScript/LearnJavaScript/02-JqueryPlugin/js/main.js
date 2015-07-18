$(".animsition").animsition({
    inClass               :   'flip-in-y',
    outClass              :   'flip-out-y',
    inDuration            :    1500,
    outDuration           :    800,
    linkElement           :   'header a',
});

$(".animsitionAbout").animsition({
    inClass               :   'flip-in-y',
    outClass              :   'flip-out-y',
    inDuration            :    1500,
    outDuration           :    800,
    linkElement           :   '.animsition-link',
});

$(".animsitionContact").animsition({
    inClass               :   'flip-in-y',
    outClass              :   'flip-out-y',
    inDuration            :    1500,
    outDuration           :    800,
    linkElement           :   'a',
});

$(".slides").slick({
        dots: true,
        slidesToShow: 4,
        slidesToScroll: 4,
        autoplay: true,
        autoplaySpeed: 5000,
        speed: 888
      });
      


//create an overlay:
var $overlay = $('<div id="overlay"></div>');
var $image = $("<img>");
var $caption = $("<p></p>");

$overlay.append($image); 

//Add overlay
$("body").append($overlay);

//Capture the click event on a link to an image
$(".grid-fifth img").click(function(event){
  event.preventDefault();
  var imageLocation = $(this).attr("src");
  imageLocation  = "images/"+imageLocation;
  //Update overlay with the image linked in the link
  $image.attr("src", imageLocation);
  $image.addClass("overlayImage");
  //Show the overlay.
  $overlay.show();
});

//When overlay is clicked
$overlay.click(function(){
  //Hide the overlay
  $overlay.hide();
});























