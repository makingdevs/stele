window.CobroUnitario = (function() {

  CobroUnitario.prototype.conceptoDePago = '';
  CobroUnitario.prototype.importe = '';
  CobroUnitario.prototype.fechaDeVencimiento = '';
  CobroUnitario.prototype.maxItems = 10;
  CobroUnitario.prototype.paymentSchemas = [];  
  CobroUnitario.prototype.tabsDiv = '';
  CobroUnitario.prototype.fechaDeVencimientoDescuento = ''; 
  CobroUnitario.prototype.form = '';

  function CobroUnitario(selectores){
    this.conceptoDePago = selectores.conceptoDePagoSelector;
    this.importe = selectores.cantidadDePagoSelector;
    this.fechaDeVencimiento = selectores.fechaDeVencimientoSelector;    
    this.tabsDiv = selectores.tabsDivSelector;
    this.form = selectores.formSelector;
    this.initDatePickerParaFechaDeVencimiento();
    this.initTypeaheadParaConcepto();
    this.initValidationsForTheForm();
    this.prepareInputsToValidate();
  }
  
  CobroUnitario.prototype.renderDiscountsTable = function(item){
    this.tabsDiv.hide();
    $(".discountsFromPaymentSchema").show();
    var source = $("#descuento-template").html();
    var template = Handlebars.compile(source);
    var html = template(item.discounts);
    $(".cobroUnitarioDescuentosTableBody").html(html);
    this.initDatePickerParaDescuento($('.expiracionDescuento'));  
    this.prepareInputsToValidate();  
  }

  CobroUnitario.prototype.setExpirationDateForDiscount = function(discount){
    if(this.fechaDeVencimiento.datepicker("getDate") != "Invalid Date"){  
      discount.prop("disabled",false) 
      date = this.fechaDeVencimiento.datepicker("getDate");
      timeDiff = date.getTime() - new Date().getTime();
      diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
      discount.datepicker("setEndDate",(diffDays >= 0 ? "+"+diffDays : diffDays)+"d");
    }
    else{
      discount.prop("disabled",true);
      discount.val("");
    } 
  }
  
  CobroUnitario.prototype.initDatePickerParaDescuento = function(descuentoField){
    descuentoField.datepicker({
      format:"dd/mm/yyyy",
      language: "es",
      orientation: "top auto",
      autoclose:true
    }); 
    this.setExpirationDateForDiscount(descuentoField);
  }

  CobroUnitario.prototype.initDatePickerParaFechaDeVencimiento = function(){
    var that = this;

    this.fechaDeVencimiento.datepicker({
      format:"dd/mm/yyyy",
      language: "es",
      orientation: "top auto",
      todayHighlight: true,
      autoclose: true
    }).on('changeDate',function(event){    
      if($(this).attr("class").indexOf("vencimiento") != -1){
        that.setExpirationDateForDiscount($('#fechaDeVencimientoDesc'));        
      }
      else{
        that.setExpirationDateForDiscount($('.expiracionDescuento'));
      }
    });
  }
  
  CobroUnitario.prototype.initTypeaheadParaConcepto = function(){    
    var that = this;

    this.conceptoDePago.typeahead({
      source: function( id, process ) {      
        var $direccion = $('#urlConcepto').val();
        var $url = $direccion+'/'+ id;
        that.fechaDeVencimiento.addClass("vencimiento");        
        that.tabsDiv.show();
        that.importe.val("");
        $(".discountsFromPaymentSchema").hide();
        $(".porcentajeRecargo,.cantidadRecargo,.rTable").addClass("hidden");        
        
        that.setExpirationDateForDiscount($('#fechaDeVencimientoDesc'));

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
      updater: function (concept){
        $(".listaRecargos,.descuentosIdDiv").html("");
        $("#recargoUnitario").val("");
        
        $.each(that.paymentSchemas, function(i,item){
          if(item.value.description == concept){
            that.fechaDeVencimiento.removeClass("vencimiento");
            that.importe.val(item.paymentAmount); 
            
            if(item.surcharge != null){
              $("#recargoUnitario").val(item.surcharge.id)
              $("div.recargosDiv table").removeClass("hidden");
              if(item.surcharge.amount != null){
                $("p.cantidadRecargo").text("\$"+item.surcharge.amount);
                $(".cantidadRecargo").removeClass("hidden");
                $("p.porcentajeRecargo").text();
                $(".porcentajeRecargo").addClass("hidden");
              }
              else if(item.surcharge.percentage != null){
                $("p.porcentajeRecargo").text("%"+item.surcharge.percentage);
                $(".porcentajeRecargo").removeClass("hidden");
                $("p.cantidadRecargo").text();
                $(".cantidadRecargo").addClass("hidden");
              }
            }
            else
              $('.porcentajeRecargo,.cantidadRecargo,div.recargosDiv table').addClass("hidden");

            $("#idsDescuentos").val(item.discountIds);
            that.tabsDiv.hide();          
            that.renderDiscountsTable(item);
            return;
          } 
        });
        return concept.trim();
      }
    });

  }
  
  CobroUnitario.prototype.prepareInputsToValidate = function(){    
    $("input.expiracionDescuento").each(function(){
      $(this).rules("add",{
        required:true,
        messages:{
          required:"Seleccione una fecha de vencimiento"
        }        
      });
    });
    
  }

  CobroUnitario.prototype.initValidationsForTheForm = function(){
    var that = this;

    this.form.validate({
      errorPlacement: function(error, element) {
        $(element).parents(".control-group").first().addClass("error");
        error.addClass("help-inline");
        if($(element).parents(".input-prepend,.input-append").size() > 0){
          error.insertAfter(element.parent());
        }else{
          error.insertAfter(element);
        }
      },
      success: function(element) {
        $(element).parents(".control-group").first().addClass("success");
      },
      highlight: function(element, errorClass, validClass){
        $(element).parents(".control-group").first().addClass(errorClass).removeClass(validClass);
      },
      unhighlight: function(element, errorClass, validClass) {
        $(element).parents(".control-group").first().removeClass(errorClass).addClass(validClass);
      },
      rules:{
        'conceptoDePago':{
          required: true
        },
        'cantidadDePago':{
          required:true,
          number:true
        },
        'fechaDeVencimiento':{
          required:true
        }        
      },
      messages:{
        'conceptoDePago':{
          required: "Escribe un concepto"
        },
        'cantidadDePago':{
          required: "Ingresa un monto",
          number: "Escribe una cantidad valida"
        },
        'fechaDeVencimiento':{
          required:"Selecciona una fecha de vencimiento" 
        },        
        validClass: "success",
        errorClass: "error", 
        errorElement: "span"
      }
    });    
    
  }  
  
  return CobroUnitario;

})();
