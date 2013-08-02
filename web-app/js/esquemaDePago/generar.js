$(document).ready(function(){
  $("#pagoGeneracion").validate({
    // TODO: Refactor de funciones comunes en la validación
    errorPlacement: function(error, element) {
      console.log(error);
      $(element).parents(".control-group").first().addClass("error");
      error.addClass("help-inline");
      if($(element).parents(".input-prepend,.input-append").size() > 0){
        error.insertAfter(element.parent());
      }else{
        error.insertAfter(element);
      }
    },
    success: function(element) {
      $(element).parents(".control-group").first().addClass("success");
    },
    highlight: function(element, errorClass, validClass){
      $(element).parents(".control-group").first().addClass(errorClass).removeClass(validClass);
    },
    unhighlight: function(element, errorClass, validClass) {
      $(element).parents(".control-group").first().removeClass(errorClass).addClass(validClass);
    },
    rules: {
      'conceptoDePago':{
        required: true
      },
      'cantidadDePago': {
        required: true, 
        number: true
      }, 
    },
    messages: {
      'conceptoDePago': {
        required: "El concepto es requerido"
      },
      'cantidadDePago': {
        required: "El monto es requerido",
        number: "El campo solo accepta Numeros"
      }
    }, 
    validClass: "success",
    errorClass: "error",
    errorElement: "span"
  });

  $("#descuentosForm").submit(function(event){
    event.stopPropagation();
    var url = $(this).attr('action');
    var data = $(this).serialize()
    var descuentosIds = $("input#descuentos").val();

    $.ajax({
      type: "POST",
      url: url + "?descuentosIds=" + descuentosIds,
      data: data,
      success: function(data) {
        $("#descuentoCreado").html(data)
        $('#descuentoModal').modal('hide');
      }
    });
    
    return false;
  });
});












