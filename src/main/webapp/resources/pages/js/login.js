
function showErrorMessage(titleText, messageText) {

	$.notify({
		icon : 'glyphicon glyphicon-remove',
		title : '<strong>' + titleText + '</strong> ',
		message : messageText
	},

	{
		type : 'danger',
		animate : {
			enter : 'animated fadeInDown',
			exit : 'animated fadeOutUp'
		}
	});
}

function login() {
	console.log('Working');
	var userName = $('#login-username').val();
	var password = $('#login-password').val();

	console.log('USer: ' + userName);
	console.log('Pass: ' + password);

	if (userName == '' || password == '') {
		console.log('IF');
		showErrorMessage('Error', 'Login or Password are wrong.')
	} else {
		console.log('ELSE');
	}
}