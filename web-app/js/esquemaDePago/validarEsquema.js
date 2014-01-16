jQuery.validator.addMethod("alphabetical", (function(value, element){
   return /^[\D]+$/.test(value);
}), "No se permiten caracteres especiales y/o numericos");

$(document).ready(function(){
  $("#esquemaDePagoForm").validate({
    errorPlacement: function(error, element) {
      $(element).parent().parent().parent().addClass("error");
      error.addClass("help-inline").appendTo(element.parent());
      error.insertAfter(element);
    },
    success: function(element) {
        $(element).parent().parent().parent().addClass("success");
    },
    highlight: function(element, errorClass, validClass){
      $(element).parent().parent().parent().addClass(errorClass).removeClass(validClass);
    },
    unhighlight: function(element, errorClass, validClass) {
      $(element).parent().parent().parent().removeClass(errorClass).addClass(validClass);
    },
    rules: {
      'nombreConcepto': {
        required: true
      },
      'importeEsquemaDePago': {
        required: true,
        number: true
      }
    },
    messages: {
      'nombreConcepto': {
        required: "El nombre del concepto es requerido"
      },
      'importeEsquemaDePago':{
        required: "El monto del esquema es requerido",
        number: "Solo se aceptan numeros"
      }
   },
    validClass: "success",
    errorClass: "error",
    errorElement: "span"
  });
});

