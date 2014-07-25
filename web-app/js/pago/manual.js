$(document).ready(function(){

  $("#listaResultados").on("click","input[name=idDependiente]",function(){
    if($(this).is(':checked')){
      $("#searchButtonDiv").html('<button id="iniciarBusqueda" class="btn-small  btn-info">Buscar cobros<i class="icon-search icon-on-right bigger-110"></i></button>');
    } 
    else
      $("#searchButtonDiv").html('<div class="alert alert-warning">Seleccione un alumno para buscar sus cobros pendientes</div>');

  });

});
