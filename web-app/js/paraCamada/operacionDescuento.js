window.OperacionDescuento = (function(){

  OperacionDescuento.prototype.nombreDescuento = '';
  OperacionDescuento.prototype.cantidad = '';
  OperacionDescuento.prototype.porcentaje = '';
  OperacionDescuento.prototype.diasPreviosParaCancelarDescuento = '';
  OperacionDescuento.prototype.descuentos = [];  

  function OperacionDescuento(selectores){
    this.nombreDescuento = selectores.nombreDescuento;
    this.cantidad = selectores.cantidadDescuento;
    this.porcentaje = selectores.porcentajeDescuento;
    this.diasPreviosParaCancelarDescuento = selectores.diasPreviosParaCancelarDescuento;
    this.initTypeaheadParaDescuento();
  }

  OperacionDescuento.prototype.initTypeaheadParaDescuento = function(){
    var that = this;

    this.nombreDescuento.typeahead({
      source: function(id, process){
        var $direccion = $('#urlDescuento').val();
        var $url = $direccion+'/'+id;
        
        return $.getJSON(
          $url,
          function(data){
            that.descuentos = data;
            var nombresDescuento = [];
            $.each(data, function(index,descuento){ 
              nombresDescuento.push(descuento.value);  
            });
            
            return process(nombresDescuento);
          });
      },
      updater:function(descuento){
        $.each(that.descuentos,function(i,item){
          if(item.value == descuento){
            that.cantidad.val(item.cantidad);
            that.porcentaje.val(item.porcentaje);
            that.diasPreviosParaCancelarDescuento.val(item.dias); 
            return; 
          }
        });
        return descuento;
      } 
    });
  }

  return OperacionDescuento;
})();
