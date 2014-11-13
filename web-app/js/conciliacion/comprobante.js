window.Comprobante = (function(){

  Comprobante.prototype.fechaComprobante = '';
  Comprobante.prototype.tipoPago = '';
  Comprobante.prototype.referencia = '';
  Comprobante.prototype.form = '';

  function Comprobante(selectores){
    this.fechaComprobante = selectores.fechaComprobanteSelector;
    this.form = selectores.form;
    this.initDatePicker();
    this.initValidationsForTheForm(); 
  }

  Comprobante.prototype.initDatePicker = function(){
    this.fechaComprobante.datepicker({
      format:"dd/mm/yyyy",
      language: "es",      
      todayHighlight: true,
      autoclose: true
    });
  }

  Comprobante.prototype.initValidationsForTheForm = function(){

    this.form.validate({
      errorPlacement: function(error, element) {
        $(element).parent().addClass("error");
        $(element).parents(".control-group").first().removeClass("success");
        error.addClass("help-inline")
        if($(element).parents(".input-prepend,.input-append").size() > 0){
          error.insertAfter(element.parent());
        }
        else{
          error.insertAfter(element);
        }
      },
      success: function(element){
        $(element).parents(".control-group").first().addClass("success");
        $(element).remove();
      },
      highlight: function(element, errorClass, validClass){
        $(element).parents(".control-group").first().addClass(errorClass).removeClass("success");
      },
      unhighlight: function(element, errorClass, validClass) {
        $(element).parents(".control-group").first().removeClass(errorClass).addClass(validClass);
      },
      rules:{
        'fechaDePago':{
          required: true
        },
        'tipoDePago':{
          required:true,
        },
        'folioBanco':{
          required:true
        }        
      },
      messages:{
        'fechaDePago':{
          required: "Selecciona una fecha"
        },
        'tipoDePago':{
          required: "Selecciona un tipo de pago"
        },
        'folioBanco':{
          required:"Escribe un folio"
        },        
        validClass: "success",
        errorClass: "error", 
        errorElement: "span"
      }
    });    

  }

  return Comprobante;
})();
