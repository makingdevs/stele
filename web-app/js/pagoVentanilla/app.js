jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initPagoInmediato();
    },
    initPagoInmediato : function(){
      var selectores = {
        fechaComprobanteSelector:$("#fechaDePago")
      };      
      this.pagoInmediato = new PagoInmediato(selectores);      
    }
  };
  App.init();
});