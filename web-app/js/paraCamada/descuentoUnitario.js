window.DescuentoUnitario = (function(){

  DescuentoUnitario.prototype.fechaExpiracion = '';
  DescuentoUnitario.prototype.formulario = '';
  DescuentoUnitario.prototype.operacionDescuento = '';
 
  function DescuentoUnitario(selectores,operacionDescuento){
    this.fechaExpiracion = selectores.fechaExpiracion;
    this.formulario = selectores.formulario; 
    this.operacionDescuento = operacionDescuento;
    this.initDatePickerForFechaExpiracion();
    this.initFormAction();
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

  DescuentoUnitario.prototype.initFormAction = function(){
    var that = this;
    this.formulario.submit(function(event){
      event.stopPropagation();
      $.ajax({
        type: "POST",
        url:$(this).attr("action"),
        data:$(this).serialize()+"&referenceDate="+$("#fechaDeVencimiento").val(),
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

      return false

    }); 
  }

  return DescuentoUnitario;

})();
