$(function() {
  $('#conceptoDePago,#conceptoDePagoRecurrente').typeahead({
    source: function( id, process ) {
      var $direccion = $('#urlConcepto')
      console.log($direccion[0].value);
      var $url = $direccion[0].value+'/'+ id;      
      var $items = new Array;
      $items = [""];
      $.ajax({
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        url: $url,
        date: "{}",
        success: function(data){
          console.log(data);
          $.map(data, function(data){
            var group;
            if (data.recargo != null){
              group = {
                id: data.id,
                name: data.value.concepto[0],
                cantidadDePago: data.cantidadDePago, 
                nombredescuentos: data.nombresDescuentos,
                descuentosIds: data.descuentosIds,
                idRecargo: data.recargo.id ,
                recargoCantidad: data.recargo.cantidad,
                recargoPorcentaje: data.recargo.porcentaje,
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
            } else {
              group = {
                id: data.id,
                name: data.value.concepto,
                cantidadDePago: data.cantidadDePago, 
                nombredescuentos: data.nombresDescuentos,
                descuentosIds: data.descuentosIds,
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
            }

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
        var descuentos = item.nombredescuentos.replace("[","").replace("]","").split(",")
        $('#conceptoDePagoRecurrente').val(item.name);
        $('#cantidadDePago').val(item.cantidadDePago);
        $('#cantidadDePagoRecurrente').val(item.cantidadDePago);
        if (item.idRecargo != null){
          $('#idRecargo').val(item.idRecargo);
        }
        if (item.recargoCantidad != null){
          $('#cantidadRecargo').val(item.recargoCantidad);
          $('#cantidadRecargo').removeClass("hidden");
          $('#labelRecargoCantidad').removeClass("hidden");
          $('#cantidadRecargo1').val(item.recargoCantidad);
          $('#cantidadRecargo1').removeClass("hidden");
          $('#labelRecargoCantidad1').removeClass("hidden");
        } else if (item.recargoPorcentaje != null) {
          $('#recargoPorcentaje').val(item.recargoPorcentaje);
          $('#recargoPorcentaje').removeClass("hidden");
          $('#labelRecargoPorcentaje').removeClass("hidden");
          $('#recargoPorcentaje1').val(item.recargoPorcentaje);
          $('#recargoPorcentaje1').removeClass("hidden");
          $('#labelRecargoPorcentaje1').removeClass("hidden");
        }
        $('#idsDescuentos').val(item.descuentosIds);        
        
        $(".descuentosList").html("");
        $.each(descuentos,function(index,value){          
          $(".descuentosList").append('<input value="'+value.trim()+'" name="nombreDescuentos'+index+'" readonly>');
        });
        $('#nombreDescuentos').val();
        $('#nombreDescuentos').removeClass("hidden");
        $('#labelDescuentos').removeClass("hidden");
        $('#nombreDescuentos1').val(item.nombredescuentos);
        $('#nombreDescuentos1').removeClass("hidden");
        $('#labelDescuentos1').removeClass("hidden");
        return item.name;
    }     
  });
});


$(function() {
  $( '#nombreDeDescuento' ).typeahead({
    source: function( query, process ) {
      var $address = $('#urlDescuento')
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


