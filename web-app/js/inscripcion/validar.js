jQuery.validator.addMethod("alphabetical", (function(value, element){
   return /^[\D]+$/.test(value);
}), "No se permiten caracteres especiales y/o numericos");

$(document).ready(function(){
  $("#registroAlumno").validate({
    // TODO: Refactor de funciones comunes en la validación
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
      'cicloEscolar': {
        required: true
      },
      'nombreAlumno': {
        required: true,
        minlength: 2,
        alphabetical: true
      },
     'apellidoPaternoAlumno': {
       required: true,
       minlength: 2,
       alphabetical: true
     },
     'apellidoMaternoAlumno': {
       required: true,
       minlength: 2,
       alphabetical: true
     },
     'nivelDeEstudio': {
       required: true
     },
     'grado': {
       required: true,
       minlength: 1,
       number: true
     },
     'grupo': {
        required: true,
        minlength: 1,
        alphabetical: true  
     },
     'turno': {
        required: true
     },
     'matricula': {
        required: true,
        minlength: 5
     },
     'nombrePadre': {
        required: true,
        minlength: 2,
        alphabetical: true
      },
     'apellidoPaternoPadre': {
       required: true,
       minlength: 2,
       alphabetical: true
     },
     'apellidoMaternoPadre': {
       required: true,
       minlength: 2,
       alphabetical: true
     },
     'email': {
        required: true,
        email: true
     },
     'telefono': {
        required: true,
        minlength: 8,
        maxlength: 10,
        number: true
     }
    },
    messages: {
      'nombreAlumno': {
        required: "El nombre es requerido",
        minlength: "No es válido"
      },
      'apellidoPaternoAlumno':{
        required: "El apellido paterno es requerido",
        minlength: "No es válido"
      },
      'apellidoMaternoAlumno':{
        required: "El apellido materno es requerido",
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
     'cicloEscolar':{
        required: "Se requiere seleccionar un Ciclo Escolar"
     },
     'nivelDeEstudio':{
        required: "Se requiere seleccionar Nivel de Estudios"
     },
     'grado':{
        required: "Se requiere ingresar un Grado",
        minlength: "el grado debe de contener por lo menos 1 caracter",
        number: "Solo se aceptan numeros",
     },
     'grupo':{
        required: "Se requiere ingresar un Grupo",
        minlength: "el grupo debe de contener por lo menos 1 caracter"
     },
     'turno':{
        required: "Seleccione un turno"
     },
     'matricula':{
        required: "Se requiere ingresar la Matricula",
        minlength: "La Matricula debe contener 5 caracteres como minimo"
     },
     'email': {
        required: "Es requerido un email válido",
        email: "Introduzca una direccion de email válida"
     },
     'nombrePadre': {
        required: "El nombre es requerido",
        minlength: "No es válido"
     },
     'apellidoPaternoPadre': {
        required: "Es requerida el apellido Paterno",
        minlength: "el apellido debe de tener minimo 2 caracteres"
     },
     'apellidoMaternoPadre': {
        required: "Es requerida el apellido Materno",
        minlength: "el apellido debe de tener minimo 2 caracteres"
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

$(document).ready(function(){
  $("#seccionBotones").on("click","#inscripcionForm", function(){
    var $urlUser = $("#urlValueUsername").val();
    var $urlDependiente = $("#urlValidarDependiente").val();
    var $username = $("#email").val();
    var $matricula = $("#matricula").val();
    $.ajax({
      type: "GET",
      dataType: "json",
      contentType: "application/json",
      url: $urlUser + "?username=" + $username,
      success:function(result){
        if(result != null){
         var question = confirm("Ya existe un usuario con cuenta "+result.username+", desea continuar?");
          if(question == true){
            $.ajax({
              type:"GET",
              dataType: "json",
              contentType: "application/json",
              url: $urlDependiente + "?matricula=" + $matricula,
              success:function(result){
                if(result != null) {
                  var questions = confirm("Ya existe un dependiente con esta matricula, desea continuar?");
                  if (questions == true) {
                    $('#registroAlumno').submit();
                  } else {
                   return false;
                  }
                }
              }
            });
          } else {
            return false;
          }
        }
      }     
    });  
    $.ajax({
     type:"GET",
     dataType: "json",
     contentType: "application/json",
     url: $urlDependiente + "?matricula=" + $matricula,
      success:function(result){
        if(result != null) {
          var questions = confirm("Ya existe un dependiente con esta matricula, desea continuar?");
           if (questions == true) {
              $('#registroAlumno').submit();
           } else {
             return false;
           }
        }
      }
    }); 
    $('#registroAlumno').submit();
    return false;
  });
});
