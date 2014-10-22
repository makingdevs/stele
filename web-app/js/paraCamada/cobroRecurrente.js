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
  }

  CobroRecurrente.prototype.renderDiscountsTable = function(paymentScheme){    
    this.tabsDiv.hide();
    $(".discountsFromPaymentSchemaRecurrente").show();
    var source = $("#descuentoRecurrente-template").html();
    var template = Handlebars.compile(source);
    var html = template(paymentScheme.discounts);    
    $(".cobroRecurrenteDescuentosTableBody").html(html);
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
        that.cantidadDePagoRecurrente.val("");

        $(".crTable, .porcentajeRecargoRecurrente, .cantidadRecargoRecurrente").addClass("hidden");
        //that.setExpirationDateForDiscount($('#fechaDeVencimientoDesc'));
      
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
