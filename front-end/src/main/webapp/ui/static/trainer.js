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
			output += "<tr>" + "<th>ID</th>" + "<th>CV</th>" + "<th>Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + data[i].id + "</td>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].cvPath + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
			}
			
			output += "</table>";
				
				document.getElementById("cvList").innerHTML = output;
		}
		
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
			output += "<tr>" + "<th>User</th>" + "<th>CV</th>" + "<th>Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + data[i].id + "</td>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].cvPath + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
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
				output += "<tr>" + "<th>User</th>" + "<th>CV</th>" + "<th>Flag</th>" + "</tr>";
				var i;
				
				for (var i in data) {
					output += "<tr>" + "<td>" + data[i].id + "</td>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].cvPath + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
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
			output += "<tr>" + "<th>User</th>" + "<th>CV</th>" + "<th>Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + data[i].id + "</td>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].cvPath + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
			}
			
			output += "</table>";
				
				document.getElementById("cvList").innerHTML = output;
		}
		
	}