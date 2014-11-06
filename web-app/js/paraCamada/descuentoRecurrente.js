window.DescuentoRecurrente = (function(){

  DescuentoRecurrente.prototype.diaVencimiento = '';
  DescuentoRecurrente.prototype.formulario = '';
  DescuentoRecurrente.prototype.operacionDescuento = '';

  function DescuentoRecurrente(selectores,operacionDescuento){
    this.diaVencimiento = selectores.diaVencimiento;
    this.formulario = selectores.formulario;
    this.operacionDescuento = operacionDescuento;
    this.initFormAction();    
    this.initValidationForFields();
    this.initExpirationDay();
  }


  DescuentoRecurrente.prototype.initExpirationDay = function(){
    var that = this; 
    this.diaVencimiento.focus(function(){      
      if(isNaN(parseInt($("#diasVencimientoPago").val())))
        $(this).prop("disabled",true);
    });
  }

  DescuentoRecurrente.prototype.initFormAction = function(){
    var that = this;
    
    this.formulario.submit(function(event){
      event.stopPropagation();
      that.diaVencimiento.prop("disabled",false);
      return false
    }); 
  }

  DescuentoRecurrente.prototype.initValidationForFields = function(){
    var that = this;  
    
    this.formulario.validate({
      errorPlacement: function(error, element) {
        $(element).parents(".control-group").first().addClass("error");
        $(element).parents(".control-group").first().removeClass("success");
        error.addClass("help-inline");
        if($(element).parents(".input-prepend,.input-append").size() > 0){
          error.insertAfter(element.parent());
        }
        else{
          error.insertAfter(element);
        }
      },
      success: function(element) {
        $(element).parents(".control-group").first().removeClass("error").addClass("success");
      },
      highlight: function(element, errorClass, validClass){
        $(element).parent().parent().parent().addClass(errorClass).removeClass(validClass);
      },
      unhighlight: function(element, errorClass, validClass) {
        $(element).parent().parent().parent().removeClass(errorClass).addClass(validClass);
      },
      rules: {
        'discountName': {
          required: true
        },
        'amount': {        
          number: true,
          onlyOne: this.operacionDescuento.porcentaje
        },
        'percentage':{
          number: true,
          onlyOne: this.operacionDescuento.cantidad
        },
        'previousDaysForCancelingDiscount':{
          expirationDateOrDay:that.diaVencimiento          
        },
        'diaVencimientoDescuento':{          
          expirationDateOrDay:that.operacionDescuento.diasPreviosParaCancelarDescuento 
        }
      },
      messages: {
        'discountName': {
          required: "Escribe un concepto"
        },
        'amount':{
          required: "Escribe una cantidad",
          number: "Escribe una cantidad valida"
        }
      },
      submitHandler:function(){

        $.ajax({
          type: "POST",
          url:that.formulario.attr("action"),
          data:that.formulario.serialize()+"&referenceDay="+$("#diasVencimientoPago").val(),
          success: function(data){
            $(".descuentoRecurrenteCreado").html(data);
            that.formulario.each(function(){
              this.reset();
            });
          }
        }).then(function(){
          var discounts = $(".descuentoCreado input[name=discount]");
          $(".descuentosIdDiv").html(discounts);
        });

      },
        validClass: "success",
        errorClass: "error",
        errorElement: "span"
    });

  }

  return DescuentoRecurrente;
})();
