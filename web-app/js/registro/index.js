$(document).ready(function(){
  $("#registroBasico").validate({
    errorPlacement: function(error, element) {
      $(element).parent().parent().addClass("error");
      error.addClass("help-inline").appendTo(element.parent());
      error.insertAfter(element);
    },
    rules: {
      'perfil.nombre': {
        required: true,
        minlength: 2,
        alphabetical: true
      }
    },
    messages: {
      'perfil.nombre': {
        required: "El Campo Nombre es Requerido",
        minlength: "No es válido"
      }
    }
  });
  errorElement: "span"
}); 