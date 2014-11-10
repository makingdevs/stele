jQuery(function ($){
  'use strict';

  window.App = {
    init : function(){
      this.initComprobante();
    },
    initComprobante: function(){
      var selectores = {
        fechaComprobanteSelector:$(".input-append.date")
      };
      this.comprobante = new Comprobante(selectores);
    }
  };
  App.init();
});