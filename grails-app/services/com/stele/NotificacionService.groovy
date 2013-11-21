package com.stele

import com.stele.Dependiente

class NotificacionService {

    def mailService

    def notificarRegistroUsuarioAdministrador(def remitente) {
    	mailService.sendMail {
        to remitente
        from "says.rodriguez@gmail.com"
        subject "New user"
        text "A new user has been created"
      }
    }

    def notificarPagosVencidos(List<Dependiente> dependientes) {
    	dependientes.each{ dependiente ->
    		mailService.sendMail {
        	to dependiente.usuario.username
        	from "says.rodriguez@gmail.com"
        	subject "Pago Vencido"
        	text "A new user has been created"
      	}
    	}
    }

    def notificarRegistroUsuarioTutor(def remitente) {
      mailService.sendMail {
        to remitente
        from "says.rodriguez@gmail.com"
        subject "New user tutor"
        text "A new user has been created"
      } 
    }

    def notificarPagosCreados(List<Dependiente> dependientes) {
      dependientes.each{ dependiente ->
        mailService.sendMail {
          to dependiente.usuario.username
          from "says.rodriguez@gmail.com"
          subject "Pago Creado"
          text "A new user has been created"
        }
      }
    }

    def notificarPagoAprovado(def dependiente) {
      mailService.sendMail {
          to dependiente.usuario.username
          from "says.rodriguez@gmail.com"
          subject "Pago Validado"
          text "A new user has been created"
      }
    }

    def notificarPagoRechazado(def dependiente) {
      mailService.sendMail {
          to dependiente.usuario.username
          from "says.rodriguez@gmail.com"
          subject "Pago Validado"
          text "A new user has been created"
      }
    } 

}
