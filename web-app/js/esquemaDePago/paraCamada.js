$(function(){
  $("select").css({'width':'100px'});
  $("p select").css({'width':'220px'});
});

function muestraMensajeDePagosGenerados(data){
  console.log(data);
  var mensajeSuccess = $("div.alert-success");
  mensajeSuccess.find('span.message').text("Se han generado " + data.length + " pagos!").delay(3000).fadeOut();
  mensajeSuccess.fadeIn();
 
};