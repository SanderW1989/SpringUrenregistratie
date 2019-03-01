$(document).ready(function(){
    $.getJSON('http://localhost:8082/api/kandidaat', function(data) {
        //alert(data);
        $.each(data, function(key, val) {
            
            $('#kandidatenTable tr:first').after(
                '<tr>'+
                '<td>'+val.naam+'</td>' +
                '<td>'+val.telefoonnummer+'</td>'+
                '<td>TO DO</td>'+
                '<td>TO DO</td>'+
                '<td>'+val.email+'</td>'+
                '<td></td>'+
                '<td class="tableButtonHolder"><a class="wijzigButton" href="wijzigKandidaat.html">&#9998;</a></td>' +
                '<td class="tableButtonHolder"><input type="button" class="verwijderButton" value="&#10006;"></td>' +
                '</tr>'
            );
            /*
            $.each(val, function(k, v) {
                alert(k + ' --- ' + v);
            });
            */
        });
    });

});