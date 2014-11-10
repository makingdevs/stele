jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initPagoInmediato();
    },
    initPagoInmediato : function(){
      var selectores = {
        fechaComprobanteSelector:$(".input-append.date"),
        formularioSelector:$("#pagoInmediato"),
        comprobanteSelector:$("#comprobante")
      };      
      this.pagoInmediato = new PagoInmediato(selectores);      
    }
  };
  App.init();
});