$(document).ready(function(){

  $("#submitFormPayout").click(function(){
    if($('a[href=#faq-tab-111]').parent().attr("class") == 'active'){
      $("#pagoGeneracion").submit();
    }
    else if($('a[href=#faq-tab-222]').parent().attr("class") == 'active'){
      $("#pagoGeneracionrecurrente").submit();
    }
    $('#imagenCarga').removeClass("hidden");
  });

  $('#fechaDeVencimiento').datepicker({
    format: "dd/mm/yy",
    language: "es",
    orientation: "top auto",
    todayHighlight: true,
    autoclose: true
  }).on('changeDate',function(event){
    date = $(this).datepicker("getDate");
    timeDiff = date.getTime() - new Date().getTime();
    diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24))-1;

    if(diffDays > 0)
      $('#fechaDeVencimientoDesc').datepicker("setEndDate","+"+diffDays+"d");
    else if(diffDays < 0)
      $('#fechaDeVencimientoDesc').datepicker("setEndDate",diffDays+"d");
    else
      $('#fechaDeVencimientoDesc').datepicker("setEndDate","+0d");
    });

  $('#fechaDeVencimientoDesc').datepicker({
    format: "dd/mm/yy",
    language: "es",
    orientation: "top auto",
    autoclose: true
  });

});