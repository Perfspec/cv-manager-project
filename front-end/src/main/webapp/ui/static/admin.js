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
    var row = table.insertRow(table_len).outerHTML = "<tr id='row" + table_len + "'><td id='id_row" + table_len + "'>" + id + "</td><td id='title_row" + table_len + "'>" + title + "</td><td id='genre_row" + table_len + "'>" + genre + "</td><td id='rating_row" + table_len + "'>" + rating + "</td><td><input type='button' id='edit_button" + table_len + "' value='Edit' class='edit' onclick='edit_row(" + table_len + ")'> <input type='button' id='save_button" + table_len + "' value='Save' class='save' onclick='save_row(" + table_len + ")'> <input type='button' value='Delete' class='delete' onclick='delete_row(" + table_len + ")'></td></tr>";
  }
}

function listAllUsers() {
	  console.log("listing users")
	  populateTable(getHttp('http://localhost:8080/user-creation-api/addUser'));

	}

function getHttp(url) {
	  var xmlHttp = new XMLHttpRequest();
	  xmlHttp.open("GET", url, false); // false for synchronous request
	  xmlHttp.send(null);
	  return xmlHttp.responseText;

}