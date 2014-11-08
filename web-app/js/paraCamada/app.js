jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initButtonActions();
      this.initRecargoUnitario();      
      this.initRecargoRecurrente();
      this.initDescuentoUnitario();
      this.initDescuentoRecurrente();
      this.initCobroUnitario();
      this.initCobroRecurrente();      
    },
    initCobroUnitario : function(){
      var selectors = {
        conceptoDePagoSelector: $('#conceptoDePago'),
        cantidadDePagoSelector: $('#cantidadDePago'),
        fechaDeVencimientoSelector: $(".input-append.date.fechaDeVencimientoDatePicker"), 
        tabsDivSelector: $('.tabsUnitario'),
        formSelector: $("#cobroUnitarioForm")
      };
      this.cobroUnitario = new CobroUnitario(selectors);
    },
    initCobroRecurrente : function(){
      var selectors = {
        conceptoDePagoRecurrenteSelector: $('#conceptoDePagoRecurrente'),
        diasVencimientoSelector: $('#diasVencimientoPago'),
        cantidadDePagoRecurrenteSelector: $('#cantidadDePagoRecurrente'),
        tabsDivSelector:$('.tabsRecurrente'),
        formSelector:$("#cobroRecurrenteForm")
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
    initRecargoUnitario: function(){
      var selectors = {
        cantidadRecargo: $("#recargoUnitarioCantidad"),
        porcentajeRecargo: $("#recargoUnitarioPorcentaje"),
        formulario: $("#recargoForm"),
        divResultados: $(".listaRecargosUnitarios"),
        idRecargo:$("#recargoUnitario") 
      };
      this.recargoUnitario = new Recargo(selectors);
    },
    initRecargoRecurrente: function(){
      var selectors = {
        cantidadRecargoRecurrente: $("#recargoRecurrenteCantidad"),
        porcentajeRecargo: $("#recargoRecurrentePorcentaje"),
        formulario:$("#recargoRecurrenteForm"),
        divResultados: $(".listaRecargosRecurrentes"),
        idRecargo:$("#recargoRecurrente") 
      }                    
      this.recargoRecurrente = new Recargo(selectors);
    },
    initButtonActions: function(){
      $("#submitFormPayout").click(function(){
        if($('a[href=#faq-tab-111]').parent().attr("class") == 'active')
          $("#cobroUnitarioForm").submit();
        else if($('a[href=#faq-tab-222]').parent().attr("class") == 'active')
          $("#cobroRecurrenteForm").submit();

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

