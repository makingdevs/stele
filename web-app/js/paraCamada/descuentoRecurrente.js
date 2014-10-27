window.DescuentoRecurrente = (function(){

  DescuentoRecurrente.prototype.diaVencimiento = '';
  DescuentoRecurrente.prototype.formulario = '';
  DescuentoRecurrente.prototype.operacionDescuento = '';

  function DescuentoRecurrente(selectores,operacionDescuento){
    this.diaVencimiento = selectores.diaVencimiento;
    this.formulario = selectores.formulario;
    this.operacionDescuento = operacionDescuento;
    this.initFormAction();
  }

  DescuentoRecurrente.prototype.initFormAction = function(){
    var that = this;
    
    this.formulario.submit(function(event){
      event.stopPropagation();
     
      $.ajax({
        type: "POST",
        url:$(this).attr("action"),
        data:$(this).serialize()+"&referenceDay="+$("#diasVencimientoPago").val(),
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

      return false

    }); 
  }

  return DescuentoRecurrente;
})();
