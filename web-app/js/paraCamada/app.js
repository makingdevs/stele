jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initButtonActions();
      this.initCobroUnitario();
      this.initCobroRecurrente();
    },
    initCobroUnitario : function(){
      var selectors = {
        conceptoDePagoSelector: $('#conceptoDePago'),
        tabsSelector: $('a[href=#faq-tab-333],a[href=#faq-tab-444]'),
        fechaDeVencimientoSelector: $("#fechaDeVencimiento"), 
        cantidadDePagoSelector: $('#cantidadDePago'),
        tablaDeDescuentosSelector: $('.cuTable')
      };
      this.cobroUnitario = new CobroUnitario(selectors);
    },
    initCobroRecurrente : function(){
      var selectors = {
        conceptoDePagoRecurrente: $('#conceptoDePagoRecurrente'),
        cantidadDePagoRecurrente: $('#cantidadDePagoRecurrente'),
        cantidadRecargoRecurrente: $('input.cantidadRecargoRecurrente'),
        porcentajeRecargoRecurrente: $('input.porcentajeRecargoRecurrente'),
        idRecargo: $("#idRecargo"),
        tabsSelector: $('a[href=#faq-tab-333],a[href=#faq-tab-444]'),
        tablaDeDescuentos: $('.crTable')
      };
      this.cobroRecurrente = new CobroRecurrente(selectors);
    },
    initButtonActions: function(){
      $("#submitFormPayout").click(function(){
        if($('a[href=#faq-tab-111]').parent().attr("class") == 'active')
          $("#pagoGeneracion").submit();
        else if($('a[href=#faq-tab-222]').parent().attr("class") == 'active')
          $("#pagoGeneracionrecurrente").submit();

        $('#imagenCarga').removeClass("hidden");
      });                       

      $("#descuentosForm").submit(function(event){
        event.stopPropagation();
        return false;
      });
    }
  };
  App.init();
});


