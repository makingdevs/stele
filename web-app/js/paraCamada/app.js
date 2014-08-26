jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initCobroUnitario();
    },
    initCobroUnitario : function(){
      var selectors = {
        conceptoDePagoSelector : '#conceptoDePago,#conceptoDePagoRecurrente',
        tabsSelector: 'a[href=#faq-tab-333],a[href=#faq-tab-444]',
        fechaDeVencimientoSelector: $("#fechaDeVencimiento"), 
        cantidadDePagoSelector: '#cantidadDePago,#cantidadDePagoRecurrente',
        tablaDeDescuentosSelector: ''
      };
      this.cobroUnitario = new CobroUnitario(selectors);
    }
  };
  App.init();
});

window.CobroUnitario = (function() {

  CobroUnitario.prototype.maxItems = 10;
  CobroUnitario.prototype.conceptoDePagoSelector = '';
  CobroUnitario.prototype.paymentSchemas = [];
  CobroUnitario.prototype.tabsSelector = '';
  CobroUnitario.prototype.fechaDeVencimientoSelector = '';
  CobroUnitario.prototype.cantidadDePagoSelector = '';
  CobroUnitario.prototype.tablaDeDescuentosSelector = '';

  function CobroUnitario(selectores){
    this.conceptoDePagoSelector = selectores.conceptoDePagoSelector;
    this.tabsSelector = selectores.tabsSelector;
    this.fechaDeVencimiento = selectores.fechaDeVencimientoSelector;
    this.cantidadDePagoSelector = selectores.cantidadDePagoSelector;
    this.tablaDeDescuentosSelector = selectores.tablaDeDescuentosSelector;
    this.initDatePickerParaFechaDeVencimiento();
    this.initTypeaheadParaConceptos();
  }
  
  CobroUnitario.prototype.renderDiscountsTable = function(item){
    var source   = $("#descuento-template").html();
    var template = Handlebars.compile(source);
    var html = template(item.descuentos);
    $(".descuentosTableBody").append(html);
  }

  CobroUnitario.prototype.setExpirationDateForDiscount = function(dueDate){
    if(dueDate.datepicker("getDate") != "Invalid Date"){  
      date = dueDate.datepicker("getDate");
      timeDiff = date.getTime() - new Date().getTime();
      diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
      $('#fechaDeVencimientoDesc').datepicker("setEndDate",(diffDays >= 0 ? "+"+diffDays : diffDays)+"d");
    }
  }
  
  CobroUnitario.prototype.initDatePickerParaFechaDeVencimiento = function(){
    that = this;

    this.fechaDeVencimiento.datepicker({
      format:"dd/mm/yy",
      language: "es",
      orientation: "top auto",
      todayHighlight: true,
      autoclose: true 
    }).on('changeDate',function(event){    
      if($(this).attr("class").indexOf("vencimiento") != -1){
        that.setExpirationDateForDiscount($(this)); 
        if($(this).datepicker("getDate") != "Invalid Date")
          $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().show();
        else
          $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().hide();
      }
    });

  }
  
  CobroUnitario.prototype.initTypeaheadParaConceptos = function(){
    that = this;

    $(this.conceptoDePagoSelector).typeahead({
      source: function( id, process ) {      
        var $direccion = $('#urlConcepto').val();
        var $url = $direccion+'/'+ id;
        $(this.fechaDeVencimientoSelector).addClass("vencimiento");        
        $(this.tabsSelector).parent().show();
        $(this.cantidadDePagoSelector).val("");
        
        $(".descuentosDiv table, .porcentajeRecargo, .cantidadRecargo").addClass("hidden");        
        that.setExpirationDateForDiscount(that.fechaDeVencimiento);
        return $.getJSON(
          $url,
          function(data){
            that.paymentSchemas = data
            var concepts = [];
            $.each(data, function(index, item){
              concepts.push(item.value.concepto);
            });
           
            return process(concepts);
          }); 
      },
      items:10,
      updater: function (concept){
        $.each(that.paymentSchemas, function(i,item){
          if(item.value.concepto == concept){
            $(that.fechaDeVencimientoSelector).removeClass("vencimiento");
            $('#conceptoDePagoRecurrente').val(concept);   
            $(".cantidadDePago").val(item.cantidadDePago); 
            if(item.recargo != null)
              $("#idRecargo").val(item.recargo.id)
          
            if(item.recargo != null){
              if(item.recargo.cantidad != null){
                $("input.cantidadRecargo").val(item.recargo.cantidad);
                $(".cantidadRecargo").removeClass("hidden");
                $("input.porcentajeRecargo").val();
                $(".porcentajeRecargo").addClass("hidden");
              }
              else if(item.recargo.porcentaje != null){
                $("input.porcentajeRecargo").val(item.recargo.porcentaje);
                $(".porcentajeRecargo").removeClass("hidden");
                $("input.cantidadRecargo").val();
                $(".cantidadRecargo").addClass("hidden");
              }
            }
            else{
              $('.porcentajeRecargo,.cantidadRecargo').addClass("hidden");
            }

            $("#idsDescuentos").val(item.descuentosIds);
            $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().hide();
            $(".descuentosTableBody").html("");
            $('.descuentosDiv table').removeClass("hidden"); 

            that.renderDiscountsTable(item);

            return;
          } 
        }); 
        return concept;
      }
    });

  }
  
  return CobroUnitario;

})();
