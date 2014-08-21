$(function() {
  var paymentSchemas
  $('#conceptoDePago,#conceptoDePagoRecurrente').typeahead({
    source: function( id, process ) {
      var $direccion = "/stele/esquemaDePago/obtenerEsquemaDePagoPorConcepto"
      var $url = $direccion+'/'+ id;      
      $(".descuentosDiv table").addClass("hidden");
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
          $('#conceptoDePagoRecurrente').val(concept);   
          $(".cantidadDePago").val(item.cantidadDePago); 
         
          if(item.recargo != null)
            $("#idRecargo").val(item.recargo.id)
        
          if(item.recargo != null){
            $(".cantidadRecargo").val(item.recargo.cantidad);
            $(".cantidadRecargo").removeClass("hidden"); 
            $(".labelRecargoCantidad").removeClass("hidden");
          } 
             
          $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().hide();
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


