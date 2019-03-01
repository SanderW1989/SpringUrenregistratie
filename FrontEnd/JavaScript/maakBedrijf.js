$(document).ready(function(){
    $("#registreerBedrijfForm").submit(function(event) {
        event.preventDefault();
        var naam = $("#bedrijfsnaamTextBox").val();
        var adres = $("#adresTextBox").val();
        var dataJson = '{"naam":"'+naam+'", "adres":"'+adres+'"}';
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8082/api/testclass", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(dataJson);
        alert(naam + " is toegevoegd.");
    });
});