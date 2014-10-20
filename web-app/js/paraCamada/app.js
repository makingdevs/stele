jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initButtonActions();
      this.initDescuentoUnitario();
      this.initDescuentoRecurrente();
      this.initCobroUnitario();
      this.initCobroRecurrente();
      this.initRecargo();
      this.initDivs();
    },
    initCobroUnitario : function(){
      var selectors = {
        conceptoDePagoSelector: $('#conceptoDePago'),
        tabsDivSelector: $('.tabs'),
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
    initDescuentoUnitario: function(){
      var selectoresOperacion = {
        nombreDescuento: $("#nombreDeDescuento"),
        cantidadDescuento: $("#cantidad"),
        porcentajeDescuento: $("#porcentaje"),
        diasPreviosParaCancelarDescuento: $("#diasPreviosParaCancelarDescuento"),
        form: $("#descuentoUnitarioForm")
      };
      var operacionDescuento = new OperacionDescuento(selectoresOperacion);

      var selectoresDescuento = {
        fechaExpiracion: $("#fechaDeVencimientoDesc")
      };

      this.descuentoRecurrente = new DescuentoUnitario(selectoresDescuento,operacionDescuento);
    },
    initDescuentoRecurrente: function(){
      var selectoresOperacion = {
        //diaVencimiento:  
      };        

    },
    initRecargo: function(){
      var selectors = {
        cantidadRecargo: $("#cantidadRecargo"),
        porcentajeRecargo: $("#porcentajeRecargo"),
        formulario: $("#recargoForm")  
      };
      this.recargo = new Recargo(selectors);
    },
    initButtonActions: function(){
      $("#submitFormPayout").click(function(){
        if($('a[href=#faq-tab-111]').parent().attr("class") == 'active')
          $("#cobroUnitarioForm").submit();
        else if($('a[href=#faq-tab-222]').parent().attr("class") == 'active')
          $("#pagoGeneracionrecurrente").submit();

        $('#imagenCarga').removeClass("hidden");
      });                       

      $("#descuentosForm").submit(function(event){
        event.stopPropagation();
        return false;
      });          
    },
    initDivs: function(){      
      $(".discountsFromPaymentSchema").hide();
    }
  };
  App.init();
});

