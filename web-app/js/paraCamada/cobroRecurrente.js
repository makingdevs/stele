window.CobroRecurrente = (function(){

  CobroRecurrente.prototype.conceptoDePagoRecurrente = '';
  CobroRecurrente.prototype.cantidadDePagoRecurrente = '';
  CobroRecurrente.prototype.idRecargo = '';
  CobroRecurrente.prototype.cantidadRecargoRecurrente = '';
  CobroRecurrente.prototype.porcentajeRecargoRecurrente = '';
  CobroRecurrente.prototype.tabs = '';
  CobroRecurrente.prototype.tablaDeDescuentos = '';
  CobroRecurrente.prototype.paymentSchemas = [];

  function CobroRecurrente(selectores){    
    this.conceptoDePagoRecurrente = selectores.conceptoDePagoRecurrente;
    this.cantidadDePagoRecurrente = selectores.cantidadDePagoRecurrente;
    this.idRecargo = selectores.idRecargo
    this.cantidadRecargoRecurrente = selectores.cantidadRecargoRecurrente;
    this.porcentajeRecargoRecurrente = selectores.porcentajeRecargoRecurrente;
    this.tabs = selectores.tabsSelector;
    this.tablaDeDescuentos = selectores.tablaDeDescuentos;
    this.initTypeaheadParaCobroRecurrente();
  }

  CobroRecurrente.prototype.renderDiscountsTable = function(paymentScheme){
    this.tablaDeDescuentos.removeClass("hidden");
    var source = $("#descuento-template").html();
    var template = Handlebars.compile(source);
    var html = template(paymentScheme.discounts);    
    $(".cobroRecurrenteDescuentosTableBody").html(html);
  }

  CobroRecurrente.prototype.showSurchargeFromPaymentSchema = function(paymentSchema){    
    
    if(paymentSchema.surcharge != null){

      this.idRecargo.val(paymentSchema.surcharge.id);

      if(paymentSchema.surcharge.amount != null){
        this.cantidadRecargoRecurrente.val(paymentSchema.surcharge.amount);
        $(".cantidadRecargoRecurrente").removeClass("hidden");
        this.porcentajeRecargoRecurrente.val();
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
        that.tabs.parent().show();
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
            that.tabs.parent().hide();
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
