window.Dependiente = (function(){
  
  Dependiente.prototype.allCheckBox = ''
  Dependiente.prototype.dependientes = ''
  
  function Dependiente(){    
  }

  Dependiente.prototype.setSelectores = function(selectores){
    this.allCheckBox = selectores.allCheckBox; 
    this.dependientes = selectores.dependientes; 
    this.initCheckAllInput();
  }

  Dependiente.prototype.initCheckAllInput = function(){
    var that = this;
    this.allCheckBox.click(function(){
      if($(this).is(':checked'))
        that.dependientes.prop("checked",true);
      else
        that.dependientes.prop("checked",false);
    }); 
  } 

  return Dependiente;

})();
