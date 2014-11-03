window.Dependiente = (function(){
  
  Dependiente.prototype.allCheckBox = '';
  Dependiente.prototype.dependientes = '';
  Dependiente.prototype.form = '';
  
  function Dependiente(){    
  }

  Dependiente.prototype.setSelectores = function(selectores){
    this.allCheckBox = selectores.allCheckBox; 
    this.dependientes = selectores.dependientes; 
    this.form = selectores.formSelector;
    this.initCheckAllInput();
    this.initValidation();
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

  Dependiente.prototype.initValidation = function(){
    var that = this;
    this.form.submit(function(){
      if(that.dependientes.is(':checked'))
        return true;
      else
        return false;
    }); 
  }

  return Dependiente;

})();
