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
    },
    initCobroUnitario : function(){
      var selectors = {
        conceptoDePagoSelector: $('#conceptoDePago'),
        cantidadDePagoSelector: $('#cantidadDePago'),
        fechaDeVencimientoSelector: $("#fechaDeVencimiento"), 
        tabsDivSelector: $('.tabsUnitario')
      };
      this.cobroUnitario = new CobroUnitario(selectors);
    },
    initCobroRecurrente : function(){
      var selectors = {
        conceptoDePagoRecurrenteSelector: $('#conceptoDePagoRecurrente'),
        diasVencimientoSelector: $('#diasVencimientoPago'),
        cantidadDePagoRecurrenteSelector: $('#cantidadDePagoRecurrente'),
        tabsDivSelector:$('.tabsRecurrente')
      };
      this.cobroRecurrente = new CobroRecurrente(selectors);
    },
    initDescuentoUnitario: function(){
      var selectoresOperacion = {
        nombreDescuento: $("#nombreDeDescuento"),
        cantidadDescuento: $("#cantidad"),
        porcentajeDescuento: $("#porcentaje"),
        diasPreviosParaCancelarDescuento: $("#diasPreviosParaCancelarDescuento")
      };
      var operacionDescuento = new OperacionDescuento(selectoresOperacion);

      var selectoresDescuento = {
        fechaExpiracion: $("#fechaDeVencimientoDesc"),
        formulario:$("#descuentoUnitarioForm")
      };

      this.descuentoUnitario = new DescuentoUnitario(selectoresDescuento,operacionDescuento);
    },
    initDescuentoRecurrente: function(){
      var selectoresOperacion = {
        nombreDescuento: $("#nombreDeDescuentoRecurrente"),
        cantidadDescuento: $("#cantidadRecurrente"),
        porcentajeDescuento: $("#porcentajeRecurrente"),
        diasPreviosParaCancelarDescuento: $("#diasPreviosParaCancelarDescuentoRecurrente")
      };        
      
      var operacionDescuento = new OperacionDescuento(selectoresOperacion);

      var selectoresDescuento = {
        diaVencimiento:$("#diaVencimientoDescuento"),
        formulario:$("#descuentoRecurrenteForm")   
      }

      this.descuentoRecurrente = new DescuentoRecurrente(selectoresDescuento,operacionDescuento);

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
    }
  };
  App.init();
});

