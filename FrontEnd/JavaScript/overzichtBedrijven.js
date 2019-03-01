$(document).ready(function(){
    $.getJSON('http://localhost:8082/api/testclass', function(data) {
        //alert(data);
        $.each(data, function(key, val) {
            
            $('#bedrijvenTable tr:first').after(
                '<tr><td>'+val.naam+'</td><td>Landsmeer 12</td><td class="tableButtonHolder"><a class="wijzigButton" href="wijzigBedrijf.html">&#9998;</a></td><td class="tableButtonHolder"><input type="button" class="verwijderButton" value="&#10006;"></td></tr>'
            );
            /*
            $.each(val, function(k, v) {
                alert(k + ' --- ' + v);
            });
            */
        });
    });

});