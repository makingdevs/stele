$(function() {
  var paymentSchemas

  $('#conceptoDePago,#conceptoDePagoRecurrente').typeahead({
    source: function( id, process ) {      
      var $direccion = $('#urlConcepto').val();
      var $url = $direccion+'/'+ id;      
      $("#fechaDeVencimiento").addClass("vencimiento");
      $(".descuentosDiv table, .porcentajeRecargo, .cantidadRecargo").addClass("hidden");
      $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().show();
      $("#cantidadDePago,#cantidadDePagoRecurrente").val("");

      return $.getJSON(
        $url,
        function(data){
          paymentSchemas = data
          var concepts = [];
          $.each(data, function(index, item){
            concepts.push(item.value.concepto);
          });
         
          return process(concepts);
        }); 
    },
    items:10,
    updater: function (concept){
      $.each(paymentSchemas, function(i,item){
        if(item.value.concepto == concept){
          $('#fechaDeVencimiento').removeClass("vencimiento");
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

          if(item.descuentos.length){ 
            $.each(item.descuentos,function(index,value){
              $(".descuentosTableBody").append('<tr><td>'+value.descuento+'</td><td>'+value.cantidad+'</td></tr>');
            }); 
          }
          else{
            $(".descuentosTableBody").append('<tr><td colspan="2">El concepto no tiene descuentos</td></tr>'); 
          }

          return;
        } 
      }); 
      return concept;
    }
  });
});


$(function() {
  $( '#nombreDeDescuento' ).typeahead({
    source: function( query, process ) {
      var $address = $('#urlDescuento');
      var $url = $address[0].value+ '/' + query;
      var $items = new Array;
      $items = [""];      
      $.ajax({
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        url: $url,
        date: "{}",
        success: function(data){
          console.log(data.value);
          $.map(data, function(data){
            var group;
            group = {
              id: data.id,
              name: data.value,
              cantidad: data.cantidad,
              porcentaje: data.porcentaje,
              dias: data.dias,
              toString: function () {
                return JSON.stringify(this);
              },
              toLowerCase: function () {
                return this.name.toLowerCase();
              },
              indexOf: function (string) {
                return String.prototype.indexOf.apply(this.name, arguments);
              },
              replace: function (string) {
                var value = '';
                value +=  this.name;
                if(typeof(this.level) != 'undefined') {
                  value += ' <span class="pull-right muted">';
                  value += this.level;
                  value += '</span>';
              }
                return String.prototype.replace.apply(
                  '<div style="padding: 0.5px; font-size: 1em;">' + value + '</div>', arguments);
              }
            };
            $items.push(group);
          });
        process($items);
        }


      });
    }, 
    property: 'value',
    items: 10,
    minLength: 2,
    updater: function (item) {
        var item = JSON.parse(item);
        $('#cantidad').val(item.cantidad);
        $('#porcentaje').val(item.porcentaje);
        $('#diasPreviosParaCancelarDescuento').val(item.dias);
        return item.name;
    }     
  });
});


