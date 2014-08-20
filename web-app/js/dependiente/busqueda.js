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