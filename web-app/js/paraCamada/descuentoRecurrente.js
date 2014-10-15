window.DescuentoRecurrente = (function(){

  DescuentoRecurrente.prototype.diaVencimiento = '';
  DescuentoRecurrente.prototype.operacionDescuento = '';

  function DescuentoRecurrente(selectores,operacionDescuento){
    this.operacionDescuento = operacionDescuento; 
    this.diaVencimiento = selectores.diaVencimiento;
  }

  return DescuentoRecurrente;
})();
