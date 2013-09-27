$(document).ready(function() {
  console.log("wizart"); 
  var $validation = false;
    $('#fuelux-wizard').ace_wizard().on('change' , function(e, info){
      if(info.step == 1 && $validation) {
        if(!$('#validation-form').valid()) return false;
          }
        }).on('finished', function(e) {
          bootbox.dialog("Gracias!, Su informacion ha sido guardada satisfactoriamente!", [{
            "label" : "OK",
            "class" : "btn-small btn-primary",
            }]
          );
        }).on('stepclick', function(e){
          //return false;//prevent clicking on steps
        });
});
