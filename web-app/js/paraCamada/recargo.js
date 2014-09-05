window.Recargo = (function(){

  Recargo.prototype.cantidad = '';
  Recargo.prototype.porcentaje = '';  
  Recargo.prototype.formulario = ''; 

  function Recargo(selectores){
    this.cantidad = selectores.cantidadRecargo;
    this.porcentaje = selectores.porcentaRecargo;
    this.formulario = selectores.formulario;
    this.initFormAction();
  }

  Recargo.prototype.initFormAction = function(){

    this.formulario.submit(function(event){
      event.stopPropagation();
      var url = $(this).attr('action');
      var data = $(this).serialize();
      
      $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(data){
          $(".recargoCreado").html(data);
        }  
      });

      return false;
    });    
  }

  return Recargo;

})();
