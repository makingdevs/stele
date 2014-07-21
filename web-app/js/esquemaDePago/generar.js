    
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
       }
      },
      messages: {
        'conceptoDePago': {
          required: "Es necesario ingresar un concepto"
        },
        'cantidadDePago':{
          required: "Ingrese un monto",
          number: "Solo se aceptan numeros"
        },
        'fechaDeVencimiento': {
         required: "Seleccione la fecha de vencimiento"
       }
      }, 
      validClass: "success",
      errorClass: "error",
      errorElement: "span"
    });
    $("#pagoGeneracionrecurrente").validate({
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
       'conceptoDePagoRecurrente': {
          required: true
       },
       'diasVencimientoPago': {
          required: true
       },
       'cantidadDePagoRecurrente': {
          required:true,
          number: true
       },
       'meses':{
         required:true
       }
      },
      messages: {
       'conceptoDePagoRecurrente': {
          required: "Es necesario ingresar un concepto"
       },
       'diasVencimientoPago': {
          required: "Seleccione el numero del dia en que vence el pago"
       },
       'cantidadDePagoRecurrente': {
          required: "Ingrese un monto",
          number: "Solo se aceptan numeros"
       },
       'meses': {
          required: ""
       }
      }, 
      validClass: "success",
      errorClass: "error",
      errorElement: "span"
    });
    $("#descuentosForm").validate({
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
        'nombreDeDescuento': {
          required: true
        },
        'cantidad': {
          number: true
        },
       'porcentaje': {
         number : true
       },
      },
      messages: {
        'conceptoDePago': {
          required: "Es requerida ingresar un concepto"
        },
        'cantidad':{
          number: "Solo se aceptan numeros"
        },
        'porcentaje': {
          number: "Solo se aceptan numeros"
       }
      }, 
      validClass: "success",
      errorClass: "error",
      errorElement: "span"
    });
    $("#recargoForm").validate({
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
        'recCantidad': {
          number : true
        },
       'recPorcentaje': {
          number : true
       }
      },
      messages: {
        'recCantidad':{
          number: "Solo se aceptan numeros"
        },
        'recPorcentaje': {
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
    var $fecha = $("#fechaDeVencimiento").val();
    console.log($fecha);
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
  $(document).ready(function() {
    $('#descuentoButton').click(function() { 
      var $cantDesc = $('#cantidad')
      var $porcDesc = $('#porcentaje')
      var $fecha = $('#fechaDeVencimientoDesc')
      var $dias = $('#diasPreviosParaCancelarDescuento')
      console.log($fecha[0].value)

      if ($cantDesc[0].value != "" && $porcDesc[0].value != "" ){
          $('#cantidad').parents(".control-group").first().addClass("error").removeClass("success");
          $('#porcentaje').parents(".control-group").first().addClass("error").removeClass("success");
          alert("Solo puede seleccionar Cantidad o Porcentaje ");
          $('#cantidad').parents(".control-group").first().addClass("error");
          $('#porcentaje').parents(".control-group").first().addClass("error");
        } 
        if ($fecha[0].value != "" && $dias[0].value != "") {
         $('#fechaDeVencimientoDesc').parents(".control-group").first().addClass("error").removeClass("success");
          $('#diasPreviosParaCancelarDescuento').parents(".control-group").first().addClass("error").removeClass("success");
          alert("Solo puede seleccionar fecha de vencimiento o dias antes de vencimiento");
          $('#fechaDeVencimientoDesc').parents(".control-group").first().addClass("error");
          $('#diasPreviosParaCancelarDescuento').parents(".control-group").first().addClass("error");
        }
        if ($cantDesc[0].value != "" && $porcDesc[0].value == "" ) {
          if (($fecha[0].value != "" && $dias[0].value == "") || ($fecha[0].value == "" && $dias[0].value != "")){
            $("#descuentosForm").submit();
          }
        }
        if ($cantDesc[0].value == "" && $porcDesc[0].value != "" ) {
          if (($fecha[0].value != "" && $dias[0].value == "") || ($fecha[0].value == "" && $dias[0].value != "")){
            $("#descuentosForm").submit();
          }
        }

    });
  });  
  $(document).ready(function() {
    $('#recargoButton').click(function() { 
      var $cantRec = $('#recCantidad')
      var $porcRec = $('#recPorcentaje')

      if ($cantRec[0].value != "" && $porcRec[0].value != "" ){
          $('#recCantidad').parents(".control-group").first().addClass("error").removeClass("success");
          $('#recPorcentaje').parents(".control-group").first().addClass("error").removeClass("success");
          alert("Solo puede seleccionar Cantidad o Porcentaje ");
          $('#recCantidad').parents(".control-group").first().addClass("error");
          $('#recPorcentaje').parents(".control-group").first().addClass("error");
        } 
        if ($cantRec[0].value != "" && $porcRec[0].value == "" ) {
          $("#recargoForm").submit();
        }
        if ($cantRec[0].value == "" && $porcRec[0].value != "" ) {
          $("#recargoForm").submit();
        }

    });
  });
