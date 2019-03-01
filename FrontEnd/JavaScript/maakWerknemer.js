$(document).ready(function(){
    $("#registreerWerknemerForm").submit(function(event) {
        event.preventDefault();
        var naam = $("#naamTextBox").val();
        var email = $("#emailTextBox").val();
        var dataJson = '{"naam":"'+naam+'", "email":"'+email+'"}';
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8082/api/werknemer/create", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(dataJson);
        alert(naam + " is toegevoegd.");
    });
});