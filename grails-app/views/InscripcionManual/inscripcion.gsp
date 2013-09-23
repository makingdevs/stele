<%@ page import="com.stele.NivelDeEstudio" %>
<%@ page import="com.stele.CicloEscolar" %>

<html >
  <head>
  <meta name="layout" content="steleDashboardTwitterBootstrap"/>
    <title>Colegio ABC</title>
    <r:require modules="assetsDashBoard, inscripcion" />
  </head>
  <body>
    <div class="main-container container-fluid">
     <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
          </script>

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
              <g:form id="registroAlumno" name="registroAlumno" url="[controller: 'inscripcionManual', action: 'crearUsuarioCondependiente']" class="form-horizontal">
                <h3 class="header smaller lighter orange">
                  Alumno
                  <small> >>Datos del Alumno</small>
                </h3>
                <div class="control-group">
                  <div class="controls">
                    <input  type="text" id="txtBusquedaAlumno" placeholder="nombre alumno" >
                    <a  data-toggle="modal" href="#modal-table">
                    <button class="btn btn-purple btn-small" >
                      Buscar
                    <i class="icon-search icon-on-right bigger-110"></i>
                    </button>
                    </a>
                  </div>
                </div>

                <div class="control-group">

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

                  <label class="control-label" for="selectCiclo">Ciclo escolar</label>

                  <div class="controls">
                    <g:select id="cicloEscolar" name="cicloEscolar" noSelection="['':'-Ciclo escolar-']" from="${CicloEscolar.list()}" optionKey="clave" optionValue="clave" />
                  </div>
                </div>

                <div class="control-group">
                  <label class="control-label" for="selectNivel">Ubicacion academica</label>

                  <div class="controls">
                    <table class="table table-condensed" border="0"  cellpadding="0" cellspacing="0">
                      <td>
                        <span class="form-field-select-1">
                          <g:select id="nivelDeEstudio" name="nivelDeEstudio" from="${NivelDeEstudio.values()}" optionKey="key" />
                        </span>
                      </td>
                      <td><label>Grado</label></td>
                      <td>
                        <span class="form-field-select">
                          <input id="grado" name="grado" type="text" placeholder="Grado">
                        </span>
                      </td>
                      <td><label>Grupo</label></td>
                      <td>
                        <span class="form-field-select-1">
                          <input id="grupo" name="grupo" type="text" placeholder="Grupo">
                        </span>
                      </td>
                    </table>
                  </div>
                </div>

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
                  <div class="row-fluid">
                    <div class="span5">
                      <div class="control-group">
                        <label class="control-label" for="txtNumLista">Matricula</label>

                        <div class="controls">
                          <input type="text" id="matricula" name="matricula" placeholder="matricula" />
                        </div>
                      </div>
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
                      <div class="controls">
                        <input  type="text" id="txtBusquedaPadre" placeholder="nombre padre" >
                        <a  data-toggle="modal" href="#modal-tablePadre">
                          <button class="btn btn-purple btn-small" >
                            Buscar
                            <i class="icon-search icon-on-right bigger-110"></i>
                          </button>
                        </a>
                      </div>
                    </div>

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


              <div id="modal-table" class="modal hide" tabindex="-1">
                <div class="modal-header no-padding">
                  <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    Resultados para "Busqueda de Alumos"
                  </div>
                </div>

                <div class="modal-body no-padding">
                  <div class="row-fluid">
                    <table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
                      <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Nivel</th>
                          <th>Grado</th>
                          <th>Grupo</th>
                        </tr>
                      </thead>

                      <tbody>
                        <tr>
                          <td>
                            <li class="blue">
                            Sergio Reyes Rodriguez
                            </li>
                          </td>
                          <td>Primaria</td>
                          <td>6to</td>
                          <td>A</td>
                        </tr>

                        <tr>
                          <td>
                            <li class="blue">
                            Sergio2 Reyes Rodriguez2
                            </li>
                          </td>
                          <td>Secundaria</td>
                          <td>1ro</td>
                          <td>A</td>
                        </tr>

                        <tr>
                          <td>
                            <li class="blue">
                            Sergio3 Reyes Rodriguez3
                            </li>
                          </td>
                          <td>Kinder</td>
                          <td>1</td>
                          <td>A</td>
                        </tr>                   
                      </tbody>
                    </table>
                  </div>
                </div>

                <div class="modal-footer">
                  <button class="btn btn-small btn-danger pull-left" data-dismiss="modal">
                    <i class="icon-remove"></i>
                    Close
                  </button>

                  <div class="pagination pull-right no-margin">
                    <ul>
                      <li class="prev disabled">
                        <a href="#">
                          <i class="icon-double-angle-left"></i>
                        </a>
                      </li>

                      <li class="active">
                        <a href="#">1</a>
                      </li>

                      <li>
                        <a href="#">2</a>
                      </li>

                      <li>
                        <a href="#">3</a>
                      </li>

                      <li class="next">
                        <a href="#">
                          <i class="icon-double-angle-right"></i>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="modal-tablePadre" class="modal hide" tabindex="-1">
                <div class="modal-header no-padding">
                  <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    Resultados para "Busqueda de Padres"
                  </div>
                </div>

                <div class="modal-body no-padding">
                  <div class="row-fluid">
                    <table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
                      <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Email</th>
                          <th>Hijo</th>
                        </tr>
                      </thead>

                      <tbody>
                        <tr>
                          <td>
                            <li class="blue">
                              Sergio Reyes
                            </li>
                          </td>
                          <td>sergio@gmail.com</td>
                          <td>Sergio Jr.</td>
                        </tr>

                        <tr>
                          <td>
                            <li class="blue">
                              Sergio Reyes1
                            </li>
                          </td>
                          <td>sergio1@gmail.com</td>
                          <td>Sergio1 Jr.</td>
                        </tr>

                        <tr>
                          <td>
                            <li class="blue">
                              Sergio Reyes2
                            </li>
                          </td>
                          <td>sergio2@gmail.com</td>
                          <td>Sergio2 Jr.</td>
                        </tr>

                        <tr>
                          <td>
                            <li class="blue">
                              Sergio Reyes3
                            </li>
                          </td>
                          <td>sergio3@gmail.com</td>
                          <td>Sergio3 Jr.</td>
                        </tr>                     
                      </tbody>
                    </table>
                  </div>
                </div>

                <div class="modal-footer">
                  <button class="btn btn-small btn-danger pull-left" data-dismiss="modal">
                    <i class="icon-remove"></i>
                    Close
                  </button>

                  <div class="pagination pull-right no-margin">
                    <ul>
                      <li class="prev disabled">
                        <a href="#">
                          <i class="icon-double-angle-left"></i>
                        </a>
                      </li>

                      <li class="active">
                        <a href="#">1</a>
                      </li>

                      <li>
                        <a href="#">2</a>
                      </li>

                      <li>
                        <a href="#">3</a>
                      </li>

                      <li class="next">
                        <a href="#">
                          <i class="icon-double-angle-right"></i>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>

              <div id="modal-formConfirmar" class="modal hide" tabindex="-1">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="red bigger" >Confirmar Eliminar?</h4>
                </div>

                <div class="modal-body overflow-visible">
                  <div class="row-fluid">
                    <div class="span5">
                      <label class="control-label">Sergio Reyes Rodriguez</label>
                    </div>
                  </div>
                </div>

                <div class="modal-footer">
                  <button class="btn btn-small" data-dismiss="modal">
                    <i class="icon-remove"></i>
                    Cancelar
                  </button>

                  <button class="btn btn-small btn-primary">
                    <i class="icon-ok"></i>
                    Confirmar
                  </button>
                </div>
              </div>

              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->
      </div><!--/.main-content-->
    </div>
     
  </body>
</html>
