window.Recargo = (function(){

  Recargo.prototype.cantidad = '';
  Recargo.prototype.porcentaje = '';  
  Recargo.prototype.formulario = ''; 
  Recargo.prototype.divResultados = '';
  Recargo.prototype.idRecargo = '';

  function Recargo(selectores){
    this.cantidad = selectores.cantidadRecargo;
    this.porcentaje = selectores.porcentajeRecargo;
    this.formulario = selectores.formulario;
    this.divResultados = selectores.divResultados;
    this.idRecargo = selectores.idRecargo;
    this.initDeleteFunction();
    this.initValidationForTheFields();
  }

  Recargo.prototype.initDeleteFunction = function(){
    var that = this;
    this.divResultados.on("click","a.deleteRecargo",function(event){
      event.stopPropagation(); 
      $.ajax({
        type: "POST",
        url:$(this).attr("href"),
        success: function(data){
          that.divResultados.html(data);
        } 
      }).then(function(){
        that.idRecargo.val("");
      });

      return false;
    });
  } 

  Recargo.prototype.initValidationForTheFields = function(){
    var that = this; 

    jQuery.validator.addMethod("onlyOne",(function(value,element,params){
      return (params[0].value != "" && element.value == "" || params[0].value == "" && element.value != "")
    }), "Escribe un recargo o porcentaje");

    this.formulario.validate({    
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
        'amount': {
          number: true,
          onlyOne: that.porcentaje
        },
        'percentage': {
          number: true,
          onlyOne: that.cantidad
        }
      },
      messages: {
        'amount': {
          number: "Sólo se aceptan números" 
        },
        'percentage':{
          number: "No se aceptan letras en este campo"
        }
      },
      submitHandler:function(){
        $.ajax({
          type: "POST",
          url: that.formulario.attr('action'),
          data: that.formulario.serialize(),
          success: function(data){
            that.divResultados.html(data);
            that.formulario.each(function(){
              this.reset();
            });
          }  
        }).then(function(){
          var recargoId = that.divResultados.find("#recargoId"); 
          that.idRecargo.val(recargoId.val());
        });
      },
        validClass: "success",
        errorClass: "error",
        errorElement: "span"
      }); 
  }

  return Recargo;

})();
