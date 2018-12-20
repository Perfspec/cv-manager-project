getAllCVs = function() {
		const Http = new XMLHttpRequest();
		const url='http://localhost:8086/cv/getAll';
		
		Http.onreadystatechange = function() {
		
		const jsonData = JSON.parse(Http.responseText);
		
		showCVs(jsonData);
		
		}
		
		Http.open("GET", url);
		Http.send();
		
		function showCVs(data) {
			var output = "<table>";
			output += "<tr>" + "<th>CVs</th>" + "<th>Flag</th>" + "<th>Change Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].username + "'s CV" + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "<td>" + "<button onclick='removeFlag(" + data[i].id + ")'>Remove Flag</button>"+ "<button onclick='updateMediumFlag(" + data[i].id + ")'>Flag: Medium</button>"+ "<button onclick='updateBadFlag(" + data[i].id + ")'>Flag: Bad</button>" + "</td>" + "</tr>";

			}
			
			output += "</table>";
				
				document.getElementById("cvList").innerHTML = output;
		}		
	}

updateMediumFlag= function(id) {
	console.log(id);
	const http = new XMLHttpRequest();
	const url = 'http://localhost:8086/cv/updateFlag';
		
	const param1 = id;
	const param2 = 1;
	
	console.log(url + "/" + param1 + "/" + param2);
	
	http.open("PUT", url + "/" + param1 + "/" + param2, true);
	http.send();
}

updateBadFlag= function(id) {
	console.log(id);
	const http = new XMLHttpRequest();
	const url = 'http://localhost:8086/cv/updateFlag';
		
	const param1 = id;
	const param2 = 2;
	
	console.log(url + "/" + param1 + "/" + param2);
	
	http.open("PUT", url + "/" + param1 + "/" + param2, true);
	http.send();
}

removeFlag= function(id) {
	console.log(id);
	const http = new XMLHttpRequest();
	const url = 'http://localhost:8086/cv/updateFlag';
		
	const param1 = id;
	const param2 = 0;
	
	console.log(url + "/" + param1 + "/" + param2);
	
	http.open("PUT", url + "/" + param1 + "/" + param2, true);
	http.send();
}
	
getAllFlaggedCVs = function() {
	
	const Http = new XMLHttpRequest();
	const url='http://localhost:8086/cv/getAllFlagged';
	
	Http.onreadystatechange = function() {
		
		const jsonData = JSON.parse(Http.responseText);
		
		showCVs(jsonData);
		}
		
		Http.open("GET", url);
		Http.send();
		
		function showCVs(data) {
			var output = "<table>";
			output += "<tr>" + "<th>CVs</th>" + "<th>Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].username + "'s CV" + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
			}
			
			output += "</table>";
				
				document.getElementById("cvList").innerHTML = output;
		}
		
	}
getAllMediumFlaggedCVs = function() {
		const Http = new XMLHttpRequest();
		const url='http://localhost:8086/cv/getAllMediumFlagged';
		
		Http.onreadystatechange = function() {
			
			const jsonData = JSON.parse(Http.responseText);
			
			showCVs(jsonData);
			}
			
			Http.open("GET", url);
			Http.send();
			
			function showCVs(data) {
				var output = "<table>";
				output += "<tr>" + "<th>CVs</th>" + "<th>Flag</th>" + "</tr>";
				var i;
				
				for (var i in data) {
					output += "<tr>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].username + "'s CV" + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
				}
				
				output += "</table>";
					
					document.getElementById("cvList").innerHTML = output;
			}
			
		}

getAllBadFlaggedCVs = function() {
	const Http = new XMLHttpRequest();
	const url='http://localhost:8086/cv/getAllBadFlagged';
	
	Http.onreadystatechange = function() {
		
		const jsonData = JSON.parse(Http.responseText);
		
		showCVs(jsonData);
		}
		
		Http.open("GET", url);
		Http.send();
		
		function showCVs(data) {
			var output = "<table>";
			output += "<tr>" + "<th>CVs</th>" + "<th>Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].username + "'s CV" + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
			}
			
			output += "</table>";
				
				document.getElementById("cvList").innerHTML = output;
		}
		
	}










