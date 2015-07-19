//Selecting the related element:
var $password = $("#password");
var $confirmPassword = $("#confirmPassword");

//Hide the span:
$("form span").hide();

function isValid() {
	return $password.val().length < 5;
}

function isMatch() {
	return $password.val() === $confirmPassword.val();
}

function canSubmit() {
	return !isValid() && isMatch();
}

function validPassword() {
	if(isValid()) {
		$password.next().show();
	} else {
		$password.next().hide();
	}
}

function passwordMatch() {
	if(isMatch()) {
		$confirmPassword.next().hide();
	} else {
		$confirmPassword.next().show();
	}

}

//enable and disable submit button
function enableSubmit() {
	console.log(canSubmit());
	$("#submit").prop("disabled", !canSubmit());
}

//focus is one of the form event
$password.focus(validPassword).keyup(validPassword).keyup(passwordMatch).keyup(enableSubmit);
$confirmPassword.focus(passwordMatch).keyup(passwordMatch).keyup(enableSubmit);

enableSubmit();
