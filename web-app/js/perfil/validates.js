
$(document).ready(function(){
  $("#passwordForm").validate({
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
      'actualContraseña': {
        required: true,
        minlength: 8
      },
      'nuevaContrasenia': {
        required: true,
        minlength: 8
      },
     'confirmaContrasenia': {
       required: true,
       minlength: 8,
       equalTo: "input.passwordNuevo"
     }
    },
    messages: {
      'actualContraseña': {
        required: "La cantraseña actual es requerida",
        minlength: "El numero debe de contener 8 caracteres minimo"
      },
      'nuevaContrasenia':{
        required: "La nueva contraseña es requerida",
        minlength: "El numero debe de contener 8 caracteres minimo"
      },
      
      'confirmaContrasenia': {
        required: "Se requiere confirmar la contraseña",
        minlength: "El numero debe de contener 8 caracteres minimo",
        equalTo: "La contraseña no coincide, favor de verificarla"
     }
    },
      validClass: "success",
      errorClass: "error",
      errorElement: "span"
  });
}); 