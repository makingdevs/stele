window.Busqueda = (function(){

  Busqueda.prototype.turno = '';
  Busqueda.prototype.nivel = '';  
  Busqueda.prototype.grado = '';
  Busqueda.prototype.grupo = ''; 

  function Busqueda(selectores){
    this.turno = selectores.turnoSelector;
    this.nivel = selectores.nivelSelector;
    this.grado = selectores.gradoSelector;
    this.grupo = selectores.grupoSelector;
    this.initFunctionForTurno();
  }
  
  Busqueda.prototype.initFunctionForTurno = function(){
    var that = this;
    var niveles = []
    this.turno.change(function(){
      that.getNiveles($(this).val(),$("input[name=getNivelUrl]").val(),that.renderNiveles);
    });  

  } 

  Busqueda.prototype.getNiveles = function(turno,url,callbackFunction){
    $.ajax({
      dataType:"json",
      url:url,
      data:{turno:turno},
      success:function(data){
        callbackFunction(data); 
      }
    });
  }
  
  Busqueda.prototype.renderNiveles = function(data){
    var source = $("#nivel-template").html()
    var template = Handlebars.compile(source)
    var html = template(data);
    $("select[name=nivel]").html(html);
  }

  return Busqueda;
})();


$(document).ready(function(){
  
  $("#listaResultados").on("click","input[name=idDependiente],input[name=listaDependientes]",function(){
    if($(this).is(':checked')){
      if($(this).attr("name") == 'idDependiente'){
        $("#searchButtonDiv").html('<button id="iniciarBusqueda" class="btn-small  btn-info">Buscar cobros<i class="icon-search icon-on-right bigger-110"></i></button>');
      }
      else{
        $("#searchButtonDiv").html('<button type="submit" id="listaDependientes" class="btn btn-success pull-right">Generar cobro<i class="icon-arrow-right icon-on-right"></i></button>');
      }
    } 
    else{
      if($(this).attr("name") == 'idDependiente'){
        $("#searchButtonDiv").html('<div class="alert alert-warning">Seleccione un alumno para buscar sus cobros pendientes</div>');
      }
      else{
        $("#searchButtonDiv").html('<div class="alert alert-warning">Seleccione un alumno para generar un cobro</div>');
      }
    }
  });

});


