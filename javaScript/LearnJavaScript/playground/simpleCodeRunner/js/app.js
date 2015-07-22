
"use strict";
$( document ).ready(function () {

//create tabs using jquery-ui
$(function() {
    $( "#tabs" ).tabs();
  });

$("#button").click(function( event ) {
	 var htmlContent = $("#htmlCode textarea").val();
	 var cssContent = $("#cssCode textarea").val();
	 var jsContent = $("#jsCode textarea").val();

	 //inject the content to iframe:
	 injectCodeToIframe(htmlContent, cssContent, jsContent);;
});

function injectCodeToIframe(htmlCode, cssCode, jsCode) {
     var cssStyle = '<style>' + cssCode + '</style>';
 	 $("#resultCode").contents().find('html').html(cssStyle + htmlCode);
	 document.getElementById('resultCode').contentWindow.eval(jsCode);
}

});
	