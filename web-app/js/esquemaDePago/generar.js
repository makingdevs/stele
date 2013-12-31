$(document).ready(function(){
  $("#pagoGeneracion").validate({
    // TODO: Refactor de funciones comunes en la validación
    errorPlacement: function(error, element) {
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
      'conceptoDePago': {
        required: true
      },
      'cantidadDePago': {
        required: true,
        number: true
      },
     'fechaDeVencimiento': {
       required: true
     },
     'conceptoDePagoRecurrente': {
        required: true
     },
     'diasVencimientoPago': {
        required: true
     },
     'cantidadDePagoRecurrente': {
        required:true,
        number: true
     }
    },
    messages: {
      'conceptoDePago': {
        required: "Es requerida ingresar un concepto"
      },
      'cantidadDePago':{
        required: "Ingrese un monto",
        number: "Solo se aceptan numeros"
      },
      'fechaDeVencimiento': {
       required: "Seleccione la fecha de vencimiento"
     },
     'conceptoDePagoRecurrente': {
        required: "Es requerida ingresar un concepto"
     },
     'diasVencimientoPago': {
        required: "seleccione el numero del dia en que vence el pago"
     },
     'cantidadDePagoRecurrente': {
        required: "Ingrese un monto",
        number: "Solo se aceptan numeros"
     }
    }, 
    validClass: "success",
    errorClass: "error",
    errorElement: "span"
  });
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
        $("#descuentoCreado2").html(data)
        $("#descuentoCreado3").html(data)
      }
    });
    
    return false;
  });

  $("#recargoForm").submit(function(event){
    event.stopPropagation();
    var url = $(this).attr('action');
    var data = $(this).serialize()
    var recargoid = $("input#recargoid").val();

    $.ajax({
      type: "POST",
      url: url + "?recargoid=" + recargoid,
      data: data,
      success: function(data) {
        $("#recargoCreado").html(data)
        $("#recargoCreado2").html(data)
        $("#recargoCreado3").html(data)
      }
    });
    return false;
  });
