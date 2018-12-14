register = function() {
	const url = 'http://localhost:8083/addUser';
	var request = new Request(url, {
		method : 'POST',
		headers : {
			'Content-Type' : 'application/json',
		},
		body : JSON.stringify({
			username : document.getElementById("username").value,
			password : document.getElementById("password").value,
			confirmPassword : document.getElementById("confirmPassword").value,
			enabled : true,
			role : "ROLE_TRAINEE"
		})
	});
	console.log("performing post request");
	fetch(request);
	document.getElementById('username').value = "";
	document.getElementById('password').value = "";
	window.location.href = "/login";
}
