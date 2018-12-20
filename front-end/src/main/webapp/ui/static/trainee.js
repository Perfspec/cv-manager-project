/**
 * 
 */

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
			output += "<tr>" + "<th>CVs</th>" + "<th>Flag</th>" + "</tr>";
			var i;
			
			for (var i in data) {
				output += "<tr>" + "<td>" + "<a href='" + data[i].cvPath + "'>" + data[i].username + "'s CV" + "</a>" + "</td>" + "<td>" + data[i].flag + "</td>" + "</tr>";
			}
			
			output += "</table>";
				
				document.getElementById("cvList").innerHTML = output;
		}
		
	}



showAlert = function(){
	
	alert("Hello");
}

