window.DescuentoUnitario = (function(){

  DescuentoUnitario.prototype.fechaExpiracion = '';
  DescuentoUnitario.prototype.operacionDescuento = '';
 
  function DescuentoUnitario(selectores,operacionDescuento){
    this.operacionDescuento = operacionDescuento;
    this.fechaExpiracion = selectores.fechaExpiracion;
    this.initDatePickerForFechaExpiracion();
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

  return DescuentoUnitario;

})();
