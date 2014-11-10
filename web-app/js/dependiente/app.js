jQuery(function ($){
  'use strict';

  window.App = {
    init : function(){
      this.initBusqueda();
      this.initBusquedaAlumno();
    },
    initBusqueda : function(){
      var selectores = {
        turnoSelector: $("#turno"),
        nivelSelector:$("#nivel"),
        gradoSelector:$("#grado"),
        grupoSelector:$("#grupo"),
        formularioSelector:$("#busquedaDependientes")
      };
      this.busqueda = new Busqueda(selectores);
      this.dependiente = new Dependiente();
      this.busqueda.setDependiente(this.dependiente)
    },
    initBusquedaAlumno : function(){
      var selectores = {
        alumnoSeleccionadoSelector:$("input[name=idDependiente],table.busqueda input[name=dependientes]"),
        listaResultadosSelector:$("#listaResultados")
      };                      
      this.busquedaAlumno = new BusquedaAlumno(selectores);
    }
  };
  App.init();
});
