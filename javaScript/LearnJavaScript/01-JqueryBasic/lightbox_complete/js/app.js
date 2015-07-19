//getting image element:
//adding new division to the body (with the ID: overlay):
var $overlay = $('<div id="overlay"> </div>');
var $image = $('<img>');
var $caption = $('<p></p>');

//magic of javascript:
  $overlay.append($image);
  $overlay.append($caption);
  $('body').append($overlay);


//$('body'); the body element
//getting each anchor element of the image:
$("#imageGallery a").click(function(event){
  //prevent the default image:
  event.preventDefault();
  //getting the href element of image:
  //$(this) equals to the $("#imageGallery a")!!
  var href = $(this).attr("href");
  //getting the children of anchor element: img
  /*
  <li>
    <a href="images/refferal_machine.png">
      <img src="images/refferal_machine.png" width="100" alt="Refferal Machine By Matthew Spiel">
    </a>
  </li>
  img is the children of a:
  $(this).children("img").attr("alt");
  */
  var captionText = $(this).children("img").attr("alt");
  //adding attribute to the JQUERY:
  //$('#someid').attr('name', 'value');
  $image.attr('src',href);
  $caption.text(captionText);
  //at the first time (from the CSS file:
  //the overlay is set to be none --> display:none;
  //hence we need to show it
  //)
  $overlay.show();
});

$overlay.click( function(event) {
  $overlay.hide();
})
