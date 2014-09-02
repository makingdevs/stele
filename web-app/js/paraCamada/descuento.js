window.Descuento = (function(){
  
  Descuento.prototype.nombreDescuento = '';
  Descuento.prototype.descuentos = [];  

  function Descuento(selectores){
    this.nombreDescuento = selectores.nombreDescuento;
    this.initTypeaheadParaDescuento();
  }

  Descuento.prototype.initTypeaheadParaDescuento = function(){
    var that = this;

    this.nombreDescuento.typeahead({
      source: function(id, process){
        var $direccion = $('#urlDescuento').val();
        var $url = $direccion+'/'+id;

        return $.getJSON(
          $url,
          function(data){
            that.descuentos = data;
            var descuentos = [];
            $.each(data, function(index,descuento){ 
              descuentos.push(descuento.value);  
            });

            return process(descuentos);
          });
      }
    });

  }
  return Descuento;
})();
