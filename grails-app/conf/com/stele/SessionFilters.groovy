package com.stele

class SessionFilters {

  def filters = {
   
    removeListFromSession(controller:'inicio|procesamientoMasivo',action:'procesar|inicio',invert:true){
      before = {
        if(session.listaDeMapaDeDominios)   
          session.removeAttribute('listaDeMapaDeDominios')
      }
    } 
  }
  
}
