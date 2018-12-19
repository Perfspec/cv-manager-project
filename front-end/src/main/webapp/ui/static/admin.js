function populateTable(jsonT) {
	var jsonTest = jsonT;
	var myObj = JSON.parse(jsonTest);
	var table = document.getElementById("data_table");
	for (x in myObj) {
		var username = myObj[x].username;
		var email = myObj[x].email.email;
		var enabled = myObj[x].enabled;
		var role = myObj[x].role.role;
		var table_len = (table.rows.length) - 1;
		var row = table.insertRow(table_len).outerHTML = "<tr id='row"
				+ table_len
				+ "'><td id='name_row"
				+ table_len
				+ "'>"
				+ username
				+ "</td><td id='email_row"
				+ table_len
				+ "'>"
				+ email
				+ "</td><td id='role_row"
				+ table_len
				+ "'>"
				+ role.replace('ROLE_', '').split('_').join(' ').toLowerCase()
						.capitalize()
				+ "</td><td id='status_row"
				+ table_len
				+ "'><div>"
				+ ((enabled.toString() == "true") ? 'Active' : 'Suspended')
				+ "<div ></td><td><a href='#' class='delete' title='Delete' data-toggle='tooltip' onclick='delete_row("
				+ table_len
				+ ")'><i class='material-icons'>&#xE872;</i></a></td></tr>";
	}
}

function listAllUsers() {
	populateTable(getHttp('http://localhost:8080/user-creation-api/getAll'));
}

 function getHttp(url) {
 var xmlHttp = new XMLHttpRequest();
 xmlHttp.open("GET", url, false);
 xmlHttp.send(null);
 return xmlHttp.responseText;
 }


String.prototype.capitalize = function() {
	return this.charAt(0).toUpperCase() + this.slice(1);
}

var tableToExcel = (function() {
	var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
			s) {
		return window.btoa(unescape(encodeURIComponent(s)))
	}, format = function(s, c) {
		return s.replace(/{(\w+)}/g, function(m, p) {
			return c[p];
		})
	}
	return function(table, name) {
		if (!table.nodeType)
			table = document.getElementById(table)
		var ctx = {
			worksheet : name || 'Worksheet',
			table : table.innerHTML
		}
		window.location.href = uri + base64(format(template, ctx))
	}
})()

function delete_row(no) {
	var name = document.getElementById("name_row" + no);
	var auth = btoa('admin','Password1');
	var url = 'http://localhost:8080/user-creation-api/deleteUser/'+ name.innerHTML;

	xml = new XMLHttpRequest();
	xml.open('DELETE',url)
	xml.setRequestHeader('Authorization', auth);
	
	xml.send();
	document.getElementById("row" + no + "").outerHTML = "";
}



