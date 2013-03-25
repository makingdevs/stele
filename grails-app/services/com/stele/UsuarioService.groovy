package com.stele

import com.stele.seguridad.Usuario

class UsuarioService {

    def obtenerUsuarioDesdeCommand(FilaExcelCommand filaExcelCommand) {
      def usuario = new Usuario()
      def perfil = new Perfil()
      usuario.username = filaExcelCommand.correoElectronico
      usuario.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
      usuario.enabled = true
      usuario.perfil = perfil
      usuario.perfil.nombre = filaExcelCommand.tutorNombre
      usuario.perfil.apellidoPaterno = filaExcelCommand.tutorApellidoPaterno
      usuario.perfil.apellidoMaterno = filaExcelCommand.tutorApellidoMaterno
      usuario
    }
}
