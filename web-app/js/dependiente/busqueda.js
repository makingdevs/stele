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
    this.initFunctionForNivel();
    this.initFunctionForGrado();
  }
  
  Busqueda.prototype.initFunctionForTurno = function(){
    var that = this;
    this.turno.change(function(){
      that.getNiveles($(this).val(),$("input[name=getNivelUrl]").val(),that.renderData);
    });  
  } 

  Busqueda.prototype.initFunctionForNivel = function(){
    var that = this;
    this.nivel.change(function(){
      that.getGrados(that.turno.val(),$(this).val(),$("input[name=getGrupoUrl]").val(),that.renderData)
    });
  }

  Busqueda.prototype.initFunctionForGrado = function(){
    var that = this;
    this.grado.change(function(){
      that.getGrupos(that.turno.val(),that.nivel.val(),$(this).val(),$("input[name=getGradoUrl]").val(),that.renderData) 
    }); 
  }

  Busqueda.prototype.getNiveles = function(turno,url,callbackFunction){
    $.ajax({
      dataType:"json",
      url:url,
      data:{turno:turno},
      success:function(data){
        callbackFunction(data,$("#nivel-template"),$("select[name=nivel]")); 
      }
    });
  }

  Busqueda.prototype.getGrados = function(turno,nivel,url,callbackFunction){
    $.ajax({
      dataType:"json",
      url:url,
      data:{turno:turno,nivel:nivel},
      success:function(data){
        callbackFunction(data,$("#grado-template"),$("select[name=grado]"));   
      }
    }); 
  }

  Busqueda.prototype.getGrupos = function(turno,nivel,grado,url,callbackFunction){
    $.ajax({
      dataType:"json",
      url:url,
      data:{turno:turno,nivel:nivel,grado:grado},
      success:function(data){
        callbackFunction(data,$("#grupo-template"),$("select[name=grupo]"));
      } 
    }); 
  }
  
  Busqueda.prototype.renderData = function(data,template,selector){
    var source = template.html()
    var template = Handlebars.compile(source)
    var html = template(data);
    selector.html(html);
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


