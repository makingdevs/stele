jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initBusqueda();
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
    }
  };
  App.init();
});
