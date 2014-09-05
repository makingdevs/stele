$(document).ready(function(){

  $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().hide();
  
  $("#submitFormPayout").click(function(){
    if($('a[href=#faq-tab-111]').parent().attr("class") == 'active'){
      $("#pagoGeneracion").submit();
    }
    else if($('a[href=#faq-tab-222]').parent().attr("class") == 'active'){
      $("#pagoGeneracionrecurrente").submit();
    }
    $('#imagenCarga').removeClass("hidden");
  });

  $('#fechaDeVencimientoDesc').datepicker({
    format: "dd/mm/yy",
    language: "es",
    orientation: "top auto",
    autoclose: true
  });

  $('#fechaDeVencimiento').datepicker({
    format: "dd/mm/yy",
    language: "es",
    orientation: "top auto",
    todayHighlight: true,
    autoclose: true
  }).on('changeDate',function(event){    
    if($(this).attr("class").indexOf("vencimiento") != -1){
      setExpirationDateForDiscount($(this)); 
      if($(this).datepicker("getDate") != "Invalid Date")
        $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().show();
      else
        $("a[href=#faq-tab-333],a[href=#faq-tab-444]").parent().hide();
    }
  });

});
