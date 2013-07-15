jQuery.validator.addMethod("alphabetical", (function(value, element){
   return /^[\D]+$/.test(value);
}), "Entrada no valida");


$(document).ready(function(){
  $("#registroBasico").validate({
    errorPlacement: function(error, element) {
      $(element).parent().parent().addClass("error");
      error.addClass("help-inline").appendTo(element.parent());
      error.insertAfter(element);
    },
    success: function(element) {
        $(element).parent().parent().addClass("success");
    },
    highlight: function(element, errorClass, validClass){
      $(element).parent().parent().addClass(errorClass).removeClass(validClass);
    },
    unhighlight: function(element, errorClass, validClass) {
      $(element).parent().parent().removeClass(errorClass).addClass(validClass);
    },
    rules: {
      'institucion.nombre': {
        required: true,
        minlength: 2
      },
      'perfil.nombre': {
        required: true,
        minlength: 2,
        alphabetical: true
      },
     'perfil.apellidoPaterno': {
       required: true,
       minlength: 2,
       alphabetical: true
     },
     'usuario.username': {
        required: true,
        minlength: 2
     }
    },
    messages: {
      'perfil.nombre': {
        required: "El Nombre es Requerido",
        minlength: "No es válido"
      },
      'institucion.nombre':{
        required: "La Institucion es Requerida",
        minlength: "No es válido"
      }
    },
      validClass: "success",
      errorClass: "error",
      errorElement: "span"
  });
}); 