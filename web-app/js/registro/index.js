jQuery.validator.addMethod("alphabetical", (function(value, element){
   return /^[\D]+$/.test(value);
}), "No se permiten caracteres especiales y/o numericos");


$(document).ready(function(){
  $("#registroBasico").validate({
    // TODO: Refactor de funciones comunes en la validación
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
        email: true  
     },
     'perfil.apellidoMaterno': {
        required: false,
        minlength: 2
     },
     'usuario.password': {
        required: true,
        minlength: 8
     },
     'inputConfirmPassword': {
        required: true,
        minlength: 8,
        equalTo: "input.passwordOrigin"
     },
     'telefono': {
        required: true,
        minlength: 8,
        maxlength: 10,
        number: true
     }
    },
    messages: {
      'perfil.nombre': {
        required: "El nombre es requerido",
        minlength: "No es válido"
      },
      'institucion.nombre':{
        required: "La institucion es requerida",
        minlength: "No es válido"
      },
      'perfil.apellidoPaterno': {
       required: "El apellido paterno es requerido",
       minlength: "No es válido"
     },
     'usuario.username': {
        required: "Es requerido un email válido",
        email: "Introduzca una direccion de email válida"
     },
     'perfil.apellidoMaterno': {
        minlength: "No es válido"
     },
     'usuario.password': {
        required: "Es requerida una contraseña",
        minlength: "La contraseña debe de tener 8 caracteres como minimo"
     },
     'inputConfirmPassword': {
        required: "Se requiere confirmar la contraseña",
        equalTo: "La contraseña no coincide, favor de verificarla"
     },
     'telefono': {
        required: "Un numero telefonico es requerido",
        minlength: "El numero debe de contener 8 caracteres minimo",
        number: "Solo se aceptan numeros",
        maxlength: "El numero solo debe contener 10 caracteres"
     }
    },
      validClass: "success",
      errorClass: "error",
      errorElement: "span"
  });
}); 