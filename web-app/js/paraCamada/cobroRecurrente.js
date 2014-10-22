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
    var source = $("#descuento-template").html();
    var template = Handlebars.compile(source);
    var html = template(paymentScheme.discounts);    
    $(".cobroRecurrenteDescuentosTableBody").html(html);
  }

  CobroRecurrente.prototype.showSurchargeFromPaymentSchema = function(paymentSchema){    
    
    if(paymentSchema.surcharge != null){

      $("#recargoRecurrente").val(paymentSchema.surcharge.id);

      if(paymentSchema.surcharge.amount != null){
        //this.cantidadRecargoRecurrente.val(paymentSchema.surcharge.amount);
        $(".cantidadRecargoRecurrente").removeClass("hidden");
        //this.porcentajeRecargoRecurrente.val();
        $(".porcentajeRecargoRecurrente").addClass("hidden");
      }
      else if(paymentSchema.surcharge.percentage != null){ 
        this.porcentajeRecargoRecurrente.val(paymentSchema.surcharge.percentage);
        $(".porcentajeRecargoRecurrente").removeClass("hidden");
        this.cantidadRecargoRecurrente.val();
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
