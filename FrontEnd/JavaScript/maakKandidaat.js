$(document).ready(function(){
    $("#registreerKandidaatForm").submit(function(event) {
        event.preventDefault();
        var naam = $("#naamTextBox").val();
        var email = $("#emailTextBox").val();
        var telefoonnummer = $("#telefoonnummerTextBox").val();
        var dataJson = '{"naam":"'+naam+'", "email":"'+email+'", "telefoonnummer":"'+telefoonnummer+'"}';
		console.log(dataJson);
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8082/api/kandidaat", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(dataJson);
        alert(naam + " is toegevoegd.");
    });
});