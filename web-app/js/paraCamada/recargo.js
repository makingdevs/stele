window.Recargo = (function(){

  Recargo.prototype.cantidad = '';
  Recargo.prototype.porcentaje = '';  
  Recargo.prototype.formulario = ''; 
  Recargo.prototype.divResultados = '';
  Recargo.prototype.idRecargo = '';

  function Recargo(selectores){
    this.cantidad = selectores.cantidadRecargo;
    this.porcentaje = selectores.porcentaRecargo;
    this.formulario = selectores.formulario;
    this.divResultados = selectores.divResultados;
    this.idRecargo = selectores.idRecargo;
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
          that.divResultados.html(data);
          that.formulario.each(function(){
            this.reset();
          });
        }  
      }).then(function(){
        var recargoId = that.divResultados.find("#recargoId"); 
        that.idRecargo.val(recargoId);
      });

      return false;
    });    
  }

  Recargo.prototype.initDeleteFunction = function(){
    var that = this;
    this.divResultados.on("click","a.deleteRecargo",function(event){
      event.stopPropagation(); 
      $.ajax({
        type: "POST",
        url:$(this).attr("href"),
        success: function(data){
          that.divResultados.html(data);
        } 
      }).then(function(){
        that.idRecargo.val("");
      });

      return false;
    });

  } 

  return Recargo;

})();
