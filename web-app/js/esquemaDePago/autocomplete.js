$(function() {
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
          var concepts = [];
          $.each(data, function(){
            var paymentScheme;
            paymentScheme = {
              concept: this.value.concepto,
              toString: function(){
                return JSON.stringify(this); 
              },
              replace: function(string){
                var value = '';
                value += this.name;
                if(typeOf(this.level) != 'undefined'){
                  value += '<span class="pull-right muted">'+this.level+'</span>'; 
                }
                return String.prototype.replace.apply('<div style="padding: 0.5px; font-size: 1em;">' + value +   '</div>', arguments);
              }
            }
            concepts.push(paymentScheme)
          });
         
          return process(concepts);
        }); 
    },
    property: 'value',
    items:10,
    updater: function(item){
      alert(item);
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


