window.CobroUnitario = (function() {

  CobroUnitario.prototype.conceptoDePago = '';
  CobroUnitario.prototype.importe = '';
  CobroUnitario.prototype.fecheDeVencimiento = '';
  CobroUnitario.prototype.maxItems = 10;
  CobroUnitario.prototype.paymentSchemas = [];
  CobroUnitario.prototype.tabs = '';
  CobroUnitario.prototype.tablaDeDescuentos = '';
  CobroUnitario.prototype.fechaDeVencimientoDescuento = ''; 

  function CobroUnitario(selectores){
    this.conceptoDePago = selectores.conceptoDePagoSelector;
    this.importe = selectores.cantidadDePagoSelector;
    this.fechaDeVencimiento = selectores.fechaDeVencimientoSelector;
    this.tabs = selectores.tabsSelector;
    this.tablaDeDescuentos = selectores.tablaDeDescuentosSelector;
    this.initDatePickerParaFechaDeVencimiento();
    this.initTypeaheadParaConceptos();
  }
  
  CobroUnitario.prototype.renderDiscountsTable = function(item){
    var source   = $("#descuento-template").html();
    var template = Handlebars.compile(source);
    var html = template(item.descuentos);
    $(".descuentosTableBody").append(html);
    this.initDatePickerParaDescuento($('.expiracionDescuento'));
  }

  CobroUnitario.prototype.setExpirationDateForDiscount = function(discount){
    if(this.fechaDeVencimiento.datepicker("getDate") != "Invalid Date"){  
      date = this.fechaDeVencimiento.datepicker("getDate");
      timeDiff = date.getTime() - new Date().getTime();
      diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
      discount.datepicker("setEndDate",(diffDays >= 0 ? "+"+diffDays : diffDays)+"d");
    }
  }
  
  CobroUnitario.prototype.initDatePickerParaDescuento = function(descuentoField){
    this.fechaDeVencimientoDescuento = descuentoField;
    this.fechaDeVencimientoDescuento.datepicker({
      format:"dd/mm/yy",
      language: "es",
      orientation: "top auto",
      autoclose:true
    }); 
    this.setExpirationDateForDiscount(descuentoField);
  }

  CobroUnitario.prototype.initDatePickerParaFechaDeVencimiento = function(){
    var that = this;

    this.fechaDeVencimiento.datepicker({
      format:"dd/mm/yy",
      language: "es",
      orientation: "top auto",
      todayHighlight: true,
      autoclose: true 
    }).on('changeDate',function(event){    
      if($(this).attr("class").indexOf("vencimiento") != -1){
        that.setExpirationDateForDiscount($('#fechaDeVencimientoDesc')); 
        if($(this).datepicker("getDate") != "Invalid Date")
          that.tabs.parent().show();
        else
          that.tabs.parent().hide();
      }
    });
  }
  
  CobroUnitario.prototype.initTypeaheadParaConceptos = function(){    
    var that = this;

    this.conceptoDePago.typeahead({
      source: function( id, process ) {      
        var $direccion = $('#urlConcepto').val();
        var $url = $direccion+'/'+ id;
        that.fechaDeVencimiento.addClass("vencimiento");        
        that.tabs.parent().show();
        that.importe.val("");
        
        $(".descuentosDiv table, .porcentajeRecargo, .cantidadRecargo").addClass("hidden");        
        that.setExpirationDateForDiscount($('#fechaDeVencimientoDesc'));
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
            that.fechaDeVencimiento.removeClass("vencimiento");
            that.importe.val(item.cantidadDePago); 
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
            else
              $('.porcentajeRecargo,.cantidadRecargo').addClass("hidden");

            $("#idsDescuentos").val(item.descuentosIds);
            that.tabs.parent().hide();
            $(".descuentosTableBody").html("");
            that.tablaDeDescuentos.removeClass("hidden"); 
            that.renderDiscountsTable(item);

            return;
          } 
        }); 
        return concept.trim();
      }
    });

  }
  
  return CobroUnitario;

})();