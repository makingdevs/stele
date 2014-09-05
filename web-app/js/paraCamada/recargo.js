window.Recargo = (function(){

  Recargo.prototype.cantidad = '';
  Recargo.prototype.porcentaje = '';  
  Recargo.prototype.form = ''; 

  function Recargo(selectores){
    this.cantidad = selectores.cantidadRecargo;
    this.porcentaje = selectores.porcentajeRecargo;
    this.form = selectores.form;
    this.initializeRecargoForm();
  }

  Recargo.prototype.initializeRecargoForm = function(){

    this.form.submit(function(event){
      //event.stopPropagation();
      var url = $(this).attr('action');
      var data = $(this).serialize();
      /* 
      $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(data){
          $("recargoCreado").html(data);
        }  
      });*/

      return false;
    });    
  }

  return Recargo;

})();
