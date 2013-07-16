$(function(){
  $("select").css({'width':'100px'});
});

function muestraMensajeDePagosGenerados(data){
  console.log(data);
  var mensajeSuccess = $("div.alert-success");
  mensajeSuccess.find('span.message').text("Se han generado " + data.length + " pagos!");
  mensajeSuccess.fadeIn();
  $("form#pagoGeneracion").each(function(){
    this.reset();
  });
};