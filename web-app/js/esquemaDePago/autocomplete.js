$(function() {
  $( '.typeahead' ).typeahead({
    source: function( query, process ) {
      var $url = '/stele/listaConcepto/' + query;
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
            group = {
              id: data.id,
              name: data.value.concepto,
              cantidadDePago: data.cantidadDePago, 
              alterno: 1000,
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
        $('#cantidadDePago').val(item.cantidadDePago);
        return item.name;
    }     
  });
});


$(function() {
  $( '.typeahead2' ).typeahead({
    source: function( query, process ) {
      var $url = '/stele/listaDescuento/' + query;
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
            group = {
              id: data.id,
              name: data.value,
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
        console.log(item.name); 
        $('#hiddenID').val(item.id);       
        return item.name;
    }     
  });
});


