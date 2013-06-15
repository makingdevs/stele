package com.stele

class NotificacionController {

  def index() {
    render(view: ((params.vista) ?: 'procesamiento'))
  }
}
