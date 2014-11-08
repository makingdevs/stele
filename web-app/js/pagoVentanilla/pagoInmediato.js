window.PagoInmediato = (function() {

  PagoInmediato.prototype.fechaComprobante = '';

  function PagoInmediato(selectores){    
    this.fechaComprobante = selectores.fechaComprobanteSelector;
    this.initDatePicker();    
  }

  PagoInmediato.prototype.initDatePicker = function(){
        
    this.fechaComprobante.datepicker({
      format:"dd/mm/yyyy",
      language: "es",
      orientation: "top auto",
      todayHighlight: true,
      autoclose: true
    });
  }

  return PagoInmediato;
})();