$(document).ready(function(){
    $.getJSON('http://localhost:8082/api/contactpersoon', function(data) {
        //alert(data); 
        $.each(data, function(key, val) {
           
            $('#contactpersonenTable tr:first').after(
                '<tr>'+
                '<td>'+val.naam+'</td>' +
                '<td>'+val.telefoonnummer+'</td>'+
                '<td>'+val.email+'</td>'+
                '<td></td>'+
                '<td>'+val.afdeling+'</td>'+
                '<td class="tableButtonHolder"><a class="wijzigButton" href="wijzigContactpersoon.html">&#9998;</a></td>' +
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