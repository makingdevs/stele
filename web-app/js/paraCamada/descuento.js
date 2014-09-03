window.Descuento = (function(){
  
  Descuento.prototype.nombreDescuento = '';
  Descuento.prototype.descuentos = [];  
  Descuento.prototype.form = ' ';

  function Descuento(selectores){
    this.nombreDescuento = selectores.nombreDescuento;
    this.form = selectores.form;
    this.initFormAction();
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

  Descuento.prototype.initFormAction = function(){
    var that = this;
    this.form.submit(function(event){
      event.stopPropagation();
      
      $.ajax({
        type: "POST",
        url:$(this).attr("action"),
        data:$(this).serialize(),
        success: function(data){
          $(".descuentoCreado").html();
        }  
      });

      return false
    });  
  }

  return Descuento;
})();
