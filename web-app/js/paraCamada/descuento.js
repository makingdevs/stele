window.Descuento = (function(){
  
  Descuento.prototype.nombreDescuento = '';
  Descuento.prototype.descuentos = [];  

  function Descuento(selectores){
    console.log("It has been initialized");
    this.nombreDescuento = selectores.nombreDescuento;
    this.initTypeaheadParaDescuento();
  }

  Descuento.prototype.initTypeaheadParaDescuento = function(){
    var that = this;

    this.nombreDescuento.typeahead({
      source: function(id, process){
        var $direccion = $('#urlDescuento').val();
        var $url = $direccion+'/'+id;
        /*
        return $.getJSON(
          $url,
          function(data){
            that.descuentos = data;
          });*/
      }
    });

  }

})();
