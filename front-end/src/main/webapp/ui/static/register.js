register = function() {
	const url = 'http://localhost:9999/user-creation-api/addUser';
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
	fetch(request).then(function(response) {
		if (response.status === 409) {
			 window.alert("User already exsists");
		} else if (response.status === 200) {
			response.json().then(function(object) {
				window.alert("Account Succesfully Created");
			})
		} else if (response.status === 400) {
			response.json().then(function(object) {
				 message = document.getElementById("message");
				 message.innerHTML = "Please ensure the password is atleast 8 letters and contains at least three the following: uppercase, lowercase, number and special character.";
			})
		}
	
	})
}
