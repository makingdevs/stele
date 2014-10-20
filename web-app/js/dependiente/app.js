jQuery(function ($) {
  'use strict';

  window.App = {
    init : function(){
      this.initListDependiente(); 
    },
    initListDependiente : function(){
      $("body").on("click","input[name=allDependientes]",function(){
        if($(this).is(':checked'))
          $("input[name=dependientes]").prop("checked",true);
        else
          $("input[name=dependientes]").prop("checked",false);
      }); 
    }
  };
  App.init();
});
