window.Comprobante = (function(){

  Comprobante.prototype.fechaComprobante = '';

  function Comprobante(selectores){
    this.fechaComprobante = selectores.fechaComprobanteSelector;
    this.initDatePicker();      
  }

  Comprobante.prototype.initDatePicker = function(){
    this.fechaComprobante.datepicker({
      format:"dd/mm/yyyy",
      language: "es",      
      todayHighlight: true,
      autoclose: true
    });
  }

  return Comprobante;
})();