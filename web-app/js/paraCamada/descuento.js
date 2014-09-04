window.Descuento = (function(){
  
  Descuento.prototype.nombreDescuento = '';
  Descuento.prototype.fechaExpiracion = '';
  Descuento.prototype.cantidad = '';
  Descuento.prototype.porcentaje = '';
  Descuento.prototype.diasPreviosParaCancelarDescuento = '';
  Descuento.prototype.descuentos = [];  
  Descuento.prototype.form = ' ';

  function Descuento(selectores){
    this.nombreDescuento = selectores.nombreDescuento;
    this.fechaExpiracion = selectores.fechaExpiracion;
    this.cantidad = selectores.cantidadDescuento;
    this.porcentaje = selectores.porcentajeDescuento;
    this.diasPreviosParaCancelarDescuento = selectores.diasPreviosParaCancelarDescuento;
    this.form = selectores.form;
    this.initFormAction();
    this.initTypeaheadParaDescuento();
    this.initDatePickerForFechaExpiracion();
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

  Descuento.prototype.initFormAction = function(){
    var that = this;
    this.form.submit(function(event){
      event.stopPropagation();

      $.ajax({
        type: "POST",
        url:$(this).attr("action"),
        data:$(this).serialize(),
        success: function(data){
          $(".descuentoCreado").html(data);
          that.form.each(function(){
            this.reset();
          }); 
        }  
      });

      return false
    });  
  }

  Descuento.prototype.initDatePickerForFechaExpiracion = function(){
    this.fechaExpiracion.prop("disabled",true);
    this.fechaExpiracion.datepicker({
      format:"dd/mm/yy",
      language: "es",
      orientation: "top auto",
      autoclose:true
    }); 
  }

  return Descuento;
})();
