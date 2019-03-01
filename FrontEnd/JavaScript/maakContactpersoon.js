$(document).ready(function(){
    $("#registreerContactpersoonForm").submit(function(event) {
        event.preventDefault();
        var naam = $("#naamTextBox").val();
        var email = $("#emailTextBox").val();
        var telefoonnummer = $("#telefoonnummerTextBox").val();
        var afdeling = $("#afdelingTextBox").val();
        var dataJson = '{"naam":"'+naam+'", "email":"'+email+'", "telefoonnummer":"'+telefoonnummer+'", "afdeling":"'+afdeling+'"}';
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8082/api/contactpersoon/create", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(dataJson);
        alert(naam + " is toegevoegd.");
    });
});