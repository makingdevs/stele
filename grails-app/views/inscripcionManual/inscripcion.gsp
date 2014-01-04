<%@ page import="com.stele.NivelDeEstudio" %>
<%@ page import="com.stele.CicloEscolar" %>

<html >
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="inscripcion" />
  </head>
  <body>
     <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="icon-home home-icon"></i>
              <a href="#">Colegio</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>

            <li>
              <a href="#">Inscripcion</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            </li>
            <li class="active">Manual</li>
          </ul><!--.breadcrumb-->
        </div>

        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Inscripcion Manual
              <small>
                <i class="icon-double-angle-right"></i>
                Inscripcion Manual de un Alumno y Padre o Tutor
              </small>
            </h1>
          </div>

            <g:if test="${flash.success}">  
              <div id="message"class="alert alert-success">
                ${flash.success}
              </div>
            </g:if>

          <div class="row-fluid">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->
              <h3>
                <div class="control-group">
                  <div class="controls">
                  &nbsp; &nbsp; &nbsp;
                    <small> Nombre del Alumno</small>
                      <input  type="text" id="nombreDependienteBusqueda" name="nombreDependienteBusqueda" placeholder="nombre alumno" >
                        <button class="btn btn-purple btn-small">
                          Buscar
                          <i class="icon-search icon-on-right bigger-110"></i>
                        </button>
                  &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                    <small> Nombre del Papa</small>
                      <input  type="text" id="nombreTutorBusqueda" name="nombreTutorBusqueda" placeholder="nombre padre" >
                        <button class="btn btn-purple btn-small" >
                          Buscar
                          <i class="icon-search icon-on-right bigger-110"></i>
                        </button>
                   </div>
                  <input type="hidden" value="${createLink(controller:'dependiente', action:'buscarDependienteInscripcion')}" id="urlDependiente" />
                 </div>
              </h3>
              <g:form id="registroAlumno" name="registroAlumno" url="[controller: 'inscripcionManual', action: 'crearUsuarioCondependiente']" class="form-horizontal">
                <h3 class="header smaller lighter orange">
                  Alumno
                  <small> >>Datos del Alumno</small>
                </h3>
                <div class="control-group">
                  <label class="control-label" for="txtNombreAlumno">Alumno</label>
                  <div class="controls">
                    <span class="input-icon">
                      <input type="text" id="nombreAlumno" name="nombreAlumno" placeholder="nombre" />
                    </span>
                    <span class="input-icon">
                      <input type="text" id="apellidoPaternoAlumno" name="apellidoPaternoAlumno" placeholder="apellido paterno" />
                    </span>
                    <span class="input-icon">
                      <input type="text" id="apellidoMaternoAlumno" name="apellidoMaternoAlumno" placeholder="apellido materno" />
                    </span>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="selectCiclo">Ciclo escolar</label>
                  <div class="controls">
                    <g:select id="cicloEscolar" name="cicloEscolar" noSelection="['':'-Ciclo escolar-']" from="${CicloEscolar.list()}" optionKey="clave" optionValue="clave" />
                  </div>
                </div>
                    <table class="table table-condensed" border="0"  cellpadding="0" cellspacing="0">
                      <td>
                        <div class="control-group">
                          <div class="controls">
                            <label>Ubicacion academica</label>
                            <g:select id="nivelDeEstudio" name="nivelDeEstudio" from="${NivelDeEstudio.values()}" noSelection="['':'-Nivel-']" optionKey="key" />
                          </div>
                        </div>
                      </td>
                      <td>
                        <div class="control-group">
                          <div class="controls">
                            <label>Grado</label>
                            <span class="form-field-select">
                              <input id="grado" name="grado" type="text" placeholder="Grado">
                            </span>
                          </div>
                        </div>
                      </td>
                      <td>
                        <div class="control-group">
                          <div class="controls">
                            <label>Grupo</label>
                            <span class="form-field-select-1">
                              <input id="grupo" name="grupo" type="text" placeholder="Grupo">
                            </span>
                          </div>
                        </div>
                      </td>
                    </table>

                <div class="row-fluid">
                  <div class="span4">
                    <div class="control-group">
                      <label class="control-label" for="selectGrupo">Turno</label>
                      <div class="controls">
                        <g:radioGroup id="turno" name="turno" labels="['Matutino','Vespertino']" values="['Matutino','Vespertino']">
                          <p>${it.radio} <g:message code="${it.label}" /></p>
                        </g:radioGroup>
                      </div>
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <label>Matricula</label>
                      <span class="form-field-select-1">
                        <input type="text" id="matricula" name="matricula" placeholder="matricula" />
                      </span>
                    </div>
                  </div>
                </div>
                <!--Alumno Fin-->
                <!--Padre Inicia-->
                <div class="row-fluid">
                  <div class="span12">
                    <h3 class="header smaller lighter purple">
                      Padre o Tutor
                      <small> >>Datos del Padre o Tutor</small>
                    </h3>

                    <div class="control-group">
                      <label class="control-label" for="txtNombreTutor">Padre o Tutor</label>

                      <div class="controls">
                        <span class="input-icon">
                          <input type="text" id="nombrePadre" name="nombrePadre" placeholder="nombre" />
                        </span>
                        <span class="input-icon">
                          <input type="text" id="apellidoPaternoPadre" name="apellidoPaternoPadre" placeholder="apellido paterno" />
                        </span>
                        <span class="input-icon">
                          <input type="text" id="apellidoMaternoPadre" name="apellidoMaternoPadre" placeholder="apellido materno" />
                        </span>
                      </div>
                    </div>

                    <div class="control-group">
                      <label class="control-label" for="txtNombreTutor">Contacto</label>
                      <div class="controls">
                        <span class="input-icon">
                          <input type="text" id="telefono" name="telefono" placeholder="telefono" />
                          <i class="icon-phone"></i> 
                        </span>
                        <span class="input-icon">
                          <input type="email" id="email" name="email" placeholder="email" data-placement="bottom" data-rel="tooltip" data-original-title="la cuenta de correo sera su usuario para el sistema" />
                          <i class="icon-envelope"></i>
                        </span>
                      </div>
                    </div>
                  </div>
                </div>
                <!--Padre Fin-->
                <div class="form-actions">
                  <button class="btn btn-danger" data-toggle="modal" href="#modal-formConfirmar" type="btn-danger">
                    <i class="icon-trash bigger-110"></i>
                    Eliminar
                  </button>
                  &nbsp; &nbsp; &nbsp;
                  <button class="btn btn-info"  type="submit">
                    <i class="icon-ok bigger-110"></i>
                    Aceptar
                  </button>
                  &nbsp; &nbsp; &nbsp;
                  <button class="btn" type="reset">
                    <i class="icon-undo bigger-110"></i>
                    Limpiar
                  </button>
                </div>
              </g:form>
              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->
      </div><!--/.main-content-->

     
  </body>
</html>
