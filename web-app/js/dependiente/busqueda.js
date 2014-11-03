window.Busqueda = (function(){

  Busqueda.prototype.turno = '';
  Busqueda.prototype.nivel = '';  
  Busqueda.prototype.grado = '';
  Busqueda.prototype.grupo = ''; 
  Busqueda.prototype.form = '';
  Busqueda.prototype.dependiente = '';

  function Busqueda(selectores){
    this.turno = selectores.turnoSelector;
    this.nivel = selectores.nivelSelector;
    this.grado = selectores.gradoSelector;
    this.grupo = selectores.grupoSelector;
    this.form = selectores.formularioSelector;
    this.initFunctionForTurno();
    this.initFunctionForNivel();
    this.initFunctionForGrado();
    this.initFormAction();
  }

  Busqueda.prototype.setDependiente = function(dependiente){
    this.dependiente = dependiente; 
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
    var that = this;
    $.ajax({
      dataType:"json",
      url:url,
      data:{turno:turno},
      success:function(data){
        callbackFunction(data,$("#nivel-template"),$("select[name=nivel]")); 
      }
    }).then(function(){
      that.nivel.trigger("change"); 
      that.grado.trigger("change");
    });
  }

  Busqueda.prototype.getGrados = function(turno,nivel,url,callbackFunction){
    var that = this;
    $.ajax({
      dataType:"json",
      url:url,
      data:{turno:turno,nivel:nivel},
      success:function(data){
        callbackFunction(data,$("#grado-template"),$("select[name=grado]"));   
      }
    }).then(function(){
      that.grado.trigger("change");
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

  Busqueda.prototype.initFormAction = function(){
    var that = this;
    this.form.submit(function(event){
      event.stopPropagation(); 
      that.getAllDependientes($(this).attr("action"),$(this).serialize());
      return false;
    });
  }

  Busqueda.prototype.getAllDependientes = function(url,data){
    var that = this;

    $.ajax({
      type:"GET",
      url:url,
      data:data,
      success:function(data){
        $("#dependientes").html(data);
      } 
    }).then(function(){
      var selectores = {
        allCheckBox:$("input[name=allDependientes]"),
        dependientes:$('input[name="dependientes"]'),
        formSelector:$('#searchDependientes') 
      }
      that.dependiente.setSelectores(selectores);
    });  
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


