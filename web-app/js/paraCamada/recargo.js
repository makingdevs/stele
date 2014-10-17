window.Recargo = (function(){

  Recargo.prototype.cantidad = '';
  Recargo.prototype.porcentaje = '';  
  Recargo.prototype.formulario = ''; 

  function Recargo(selectores){
    this.cantidad = selectores.cantidadRecargo;
    this.porcentaje = selectores.porcentaRecargo;
    this.formulario = selectores.formulario;
    this.initDeleteFunction();
    this.initFormAction();
  }

  Recargo.prototype.initFormAction = function(){
    var that = this;

    this.formulario.submit(function(event){
      event.stopPropagation();
      
      $.ajax({
        type: "POST",
        url: $(this).attr('action'),
        data: $(this).serialize(),
        success: function(data){
          $(".listaRecargos").html(data);
          that.formulario.each(function(){
            this.reset();
          });
        }  
      });

      return false;
    });    
  }

  Recargo.prototype.initDeleteFunction = function(){

    $(".listaRecargos").on("click","a.deleteRecargo",function(event){
      event.stopPropagation(); 
      $.ajax({
        type: "POST",
        url:$(this).attr("href"),
        success: function(data){
          $(".listaRecargos").html(data);
        } 
      });

      return false;
    });
    
  } 

  return Recargo;

})();
