window.CobroRecurrente = (function(){

  CobroRecurrente.prototype.conceptoDePagoRecurrente = '';
  CobroRecurrente.prototype.cantidadDePagoRecurrente = '';
  CobroRecurrente.prototype.diasVencimiento = '';
  CobroRecurrente.prototype.tabsDiv = '';

  function CobroRecurrente(selectores){    
    this.conceptoDePagoRecurrente = selectores.conceptoDePagoRecurrenteSelector;
    this.diasVencimiento = selectores.diasVencimientoSelector;
    this.cantidadDePagoRecurrente = selectores.cantidadDePagoRecurrenteSelector;
    this.tabsDiv = selectores.tabsDivSelector;
    this.initTypeaheadParaCobroRecurrente();    
    this.initExpirationDay();
  }

  CobroRecurrente.prototype.renderDiscountsTable = function(paymentScheme){    
    this.tabsDiv.hide();
    $(".discountsFromPaymentSchemaRecurrente").show();
    var source = $("#descuentoRecurrente-template").html();
    var template = Handlebars.compile(source);
    var html = template(paymentScheme.discounts);    
    $(".cobroRecurrenteDescuentosTableBody").html(html);
    this.setExpirationDayForDiscount($(".diaVencimientoDescuento"),parseInt(this.diasVencimiento.val()));
  }

  CobroRecurrente.prototype.setExpirationDayForDiscount = function(discount,expirationDay){    
    discount.each(function(){
      var firstItem = discount.find("option:eq(0)");
      $(this).html("");
      $(this).append(firstItem);
    });

    if(!isNaN(expirationDay)){      
      var source = $("#diaVencimiento-template").html();
      var template = Handlebars.compile(source);
       
      discount.each(function(){
        for(var i=1;i<=expirationDay;i++)
          $(this).append(template({number:i}));
       
        $(this).prop("disabled",false);
      });      
    }
    else{
      discount.each(function(){        
        $(this).prop("disabled",true);
      });
    }
  }

  CobroRecurrente.prototype.initExpirationDay = function(){
    var that = this;
    this.diasVencimiento.change(function(){
      that.setExpirationDayForDiscount($(".diaVencimientoDescuento"),parseInt($(this).val()));
    });
  }

  CobroRecurrente.prototype.showSurchargeFromPaymentSchema = function(paymentSchema){    
    
    if(paymentSchema.surcharge != null){

      $("#recargoRecurrente").val(paymentSchema.surcharge.id);
      $("div.recargosRecurrentesDiv table").removeClass("hidden");
      if(paymentSchema.surcharge.amount != null){
        $("p.cantidadRecargoRecurrente").text("\$"+paymentSchema.surcharge.amount);
        $(".cantidadRecargoRecurrente").removeClass("hidden");
        $("p.porcentajeRecargoRecurrente").text();
        $(".porcentajeRecargoRecurrente").addClass("hidden");
      }
      else if(paymentSchema.surcharge.percentage != null){ 
        $("p.porcentajeRecargoRecurrente").text("%"+paymentSchema.surcharge.percentage);
        $(".porcentajeRecargoRecurrente").removeClass("hidden");
        $("p.cantidadRecargoRecurrente").text();
        $(".cantidadRecargoRecurrente").addClass("hidden");
      }
      else
        $('.porcentajeRecargoRecurrente,.cantidadRecargoRecurrente').addClass("hidden");
    }

  }

  CobroRecurrente.prototype.initTypeaheadParaCobroRecurrente = function(){
    var that = this;
     
    this.conceptoDePagoRecurrente.typeahead({
      source: function( id, process ){
        var $direccion = $('#urlConcepto').val();
        var $url = $direccion+'/'+ id;        
        that.tabsDiv.show();     
        that.cantidadDePagoRecurrente.val("");
        $(".discountsFromPaymentSchemaRecurrente").hide();
        $(".porcentajeRecargoRecurrente, .cantidadRecargoRecurrente").addClass("hidden");
      
        that.setExpirationDayForDiscount($(".diaVencimientoDescuento"),parseInt(that.diasVencimiento.val()));
      
        return $.getJSON(
          $url,
          function(data){
            that.paymentSchemas = data
            var concepts = [];
            $.each(data, function(index, item){
              concepts.push(item.value.description);
            });
           
            return process(concepts);
          }); 
      },
      items:10,
      updater: function(concept){
        $.each(that.paymentSchemas, function(i,paymentSchema){
          if(paymentSchema.value.description == concept){
            that.cantidadDePagoRecurrente.val(paymentSchema.paymentAmount);             
            that.showSurchargeFromPaymentSchema(paymentSchema);
            that.renderDiscountsTable(paymentSchema);
            return;
          }
        });
        return concept.trim();
      }
    });
  }

  return CobroRecurrente;

})();
