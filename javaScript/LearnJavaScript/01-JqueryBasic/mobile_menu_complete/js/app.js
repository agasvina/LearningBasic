/*
We need to add select to our html:
<select>
  <option></option>
</select>
*/

var $select = $('<select></select>');
//var $option = $('<option></option>');
var $defaultOption = $('<option></option>');
$defaultOption.text("Google search");
$defaultOption.val("http://www.google.com");
$select.append($defaultOption);

//for each menu we put the value into the select.
$("#menu li").each(function() {
   var optionText = $(this).children("a").text();
   var $anchor = $(this).children("a");
   //create a new option and append to the $select:
   var $option = $('<option></option>');
   //$option.prop( "value", optionText);
   $option.val($anchor.attr("href"));
   //if the current element is selected, we select and put it in the
   //first display of our selected.
   if($(this).hasClass("selected")) {
      $option.prop("selected", true);
   }
   $option.text(optionText);
   $select.append($option);
});

$('#menu').append($select);

//on the option selected we change
$select.change(function() {
  if($select.val() === "http://www.google.com") {
    window.open($select.val());
  } else {
    window.location = $select.val();
  }
});