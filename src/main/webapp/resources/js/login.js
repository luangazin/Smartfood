


function showMessage() {
	$.notify({
		icon : 'glyphicon glyphicon-remove',
		title : "<strong>Access Denied: </strong> ",
		message : "Username or password are word.Try again"
	}, {
		type : 'danger'
	});
}