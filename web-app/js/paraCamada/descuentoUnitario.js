window.DescuentoUnitario = (function(){

  DescuentoUnitario.prototype.fechaExpiracion = '';
  DescuentoUnitario.prototype.formulario = '';
  DescuentoUnitario.prototype.operacionDescuento = '';
 
  function DescuentoUnitario(selectores,operacionDescuento){
    this.fechaExpiracion = selectores.fechaExpiracion;
    this.formulario = selectores.formulario; 
    this.operacionDescuento = operacionDescuento;
    this.initDatePickerForFechaExpiracion();
    this.initDatePicker();
    this.initFormAction();
    this.initValidationsForFields();
  }

  DescuentoUnitario.prototype.initDatePickerForFechaExpiracion = function(){
    this.fechaExpiracion.prop("disabled",true);
    this.fechaExpiracion.datepicker({
      format:"dd/mm/yyyy",
      language: "es",
      orientation: "top auto",
      autoclose:true
    });
  }

  DescuentoUnitario.prototype.initDatePicker = function(){
    var that = this; 
    this.fechaExpiracion.focus(function(){
      if($("#fechaDeVencimiento").datepicker("getDate") == "Invalid Date")
        $(this).prop("disabled",true); 
    });
  }
  
  DescuentoUnitario.prototype.initFormAction = function(){    
    var that = this;
    this.formulario.submit(function(event){
      event.stopPropagation();
      that.fechaExpiracion.prop("disabled",false);
      return false; 
    });
  }

  DescuentoUnitario.prototype.initValidationsForFields = function(){
    var that = this;

    this.formulario.validate({
      errorPlacement: function(error, element) {
        $(element).parent().parent().parent().addClass("error");
        error.addClass("help-inline").appendTo(element.parent());
        error.insertAfter(element.parent());
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
        'discountName': {
          required: true
        },
        'amount': {
          required: true,
          number: true
        },
        'expirationDate':{
          required: true
        }
      },
      messages: {
        'discountName': {
          required: "Escribe un concepto"
        },
        'amount':{
          required: "Escribe una cantidad",
          number: "Escribe una cantidad valida"
        },
        'expirationDate':{
          required: "Escribe una fecha de expiración"
        }
      },
      submitHandler:function(){
        $.ajax({
          type: "POST",
          url:that.formulario.attr("action"),
          data:that.formulario.serialize()+"&referenceDate="+$("#fechaDeVencimiento").val(),
          success: function(data){
            $(".descuentoCreado").html(data);
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

  return DescuentoUnitario;

})();
