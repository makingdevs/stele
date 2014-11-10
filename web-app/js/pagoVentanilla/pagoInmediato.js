window.PagoInmediato = (function() {

  PagoInmediato.prototype.fechaComprobante = '';
  PagoInmediato.prototype.formulario = '';
  PagoInmediato.prototype.comprobante = '';

  function PagoInmediato(selectores){    
    this.fechaComprobante = selectores.fechaComprobanteSelector;
    this.formulario = selectores.formularioSelector;    
    this.comprobante = selectores.comprobanteSelector;
    this.initDatePicker();
    this.initComprobanteAction();
    this.initFormAction();
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

  PagoInmediato.prototype.initFormAction = function(){
    this.formulario.submit(function(event){
      event.preventDefault();
      $.ajax({
        url:"../../pago/pagoInmediatoVentanilla",
        data:$(this).serialize(),
        success:function(data){
          $("form").each(function(){ 
            this.reset();
          });
          $("div.form-actions").html(data);
        }
      });
    });
  }

  PagoInmediato.prototype.initComprobanteAction = function(){
    var urlValue = $("input#url").val() 
    this.comprobante.dropzone({
      url : urlValue,
      maxFilesize : .5,
      addRemoveLinks : false
    });
  }

  return PagoInmediato;
})();