register = function() {
	const url = 'http://localhost:8080/user-creation-api/addUser';
	var request = new Request(url, {
		method : 'POST',
		headers : {
			'Content-Type' : 'application/json',
		},
		body : JSON.stringify({
			username : document.getElementById("username").value,
			email : document.getElementById("email").value,
			password : document.getElementById("password").value,
			confirmPassword : document.getElementById("confirmPassword").value,
			enabled : true,
			role : "ROLE_TRAINEE"
		})
	});
	fetch(request).then(function() {
		message = document.getElementById("message");
		message.innerHTML = "This account may already exsit and please ensure the password contains at least one uppercase, number and special character.";
      	document.getElementById('username').value = "";
    	document.getElementById('email').value = "";
    	document.getElementById('password').value = "";
    }).catch(function() {	
    	document.getElementById('username').value = "";
    	document.getElementById('email').value = "";
    	document.getElementById('password').value = "";
    	window.location.href = "/login";
    });
}
