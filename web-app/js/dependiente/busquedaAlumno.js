window.BusquedaAlumno = (function(){
  
  BusquedaAlumno.prototype.alumnoSeleccionado = '';
  BusquedaAlumno.prototype.listaResultados = '';

  function BusquedaAlumno(selectores){
    this.alumnoSeleccionado = selectores.alumnoSeleccionadoSelector;
    this.listaResultados = selectores.listaResultadosSelector; 
    this.initFunctionForCheck();
  }

  BusquedaAlumno.prototype.initFunctionForCheck = function(){
    var that = this;
    var source = '';
    var template = '';
    var html = '';
    this.listaResultados.on("click",that.alumnoSeleccionado.selector,function(){
      source = $("#buttonForSearch").html();
      template = Handlebars.compile(source)

      if($(this).is(':checked'))
        html = template({checked:true});
      else
        html = template()
            
      $("#searchButtonDiv").html(html);

    }); 
  }

  return BusquedaAlumno;
})();
