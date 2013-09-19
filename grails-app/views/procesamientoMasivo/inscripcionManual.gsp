<html >
  <head>
  <meta name="layout" content="steleDashboardTwitterBootstrap"/>
    <title>Colegio ABC</title>
    <r:require modules="assetsDashBoard" />
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
          <div class="row-fluid">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->
              <form class="form-horizontal">
                

                <!--Alumno Inicia-->
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
                  <label class="control-label" for="selectCiclo">Ciclo escolar</label>

                  <div class="controls">
                    <select id="form-field-select-1">
                      <option value="">ciclo</option>
                      <option value="2013">2013 Agosto-2014 Julio</option>
                      <option value="2014">2014 Agosto-2015 Julio</option>
                      <option value="2015">2015 Agosto-2015 Julio</option>
                      <option value="2016">2016 Agosto-2017 Julio</option>
                    </select>
                  </div>
                </div>

                <div class="control-group">
                  <label class="control-label" for="selectNivel">Ubicacion academica</label>

                  <div class="controls">
                    <span class="form-field-select-1">
                      <select id="form-field-select-1">
                        <option value="">nivel</option>
                        <option value="1">Maternal</option>
                        <option value="2">Kinder</option>
                        <option value="3">Primaria</option>
                        <option value="4">Secundaria</option>
                      </select>
                    </span>
                    <span class="form-field-select">
                      <select id="form-field-select-2">
                        <option value="">grado</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                      </select>
                    </span>
                    <span class="form-field-select-1">
                      <select id="form-field-select-1">
                        <option value="">grupo</option>
                        <option value="1">A</option>
                        <option value="2">B</option>
                        <option value="3">C</option>
                        <option value="4">D</option>
                      </select>
                    </span>
                  </div>
                </div>

                <div class="row-fluid">
                  <div class="span4">
                    <div class="control-group">
                      <label class="control-label" for="selectGrupo">Turno</label>

                      <div class="controls">
                        <input class="ace" type="radio" name="form-field-radio">
                        <span class="lbl"> Matutino</span>
                        <input class="ace" type="radio" name="form-field-radio">
                        <span class="lbl"> Vespertino</span>
                      </div>
                    </div>
                  </div>
                  <div class="row-fluid">
                    <div class="span5">
                      <div class="control-group">
                        <label class="control-label" for="txtNumLista">Numero de lista</label>

                        <div class="controls">
                          <input type="text" id="txtNombreAlumno" placeholder="num lista" />
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
                      <label class="control-label" for="txtNombreAlumno">Padre o Tutor</label>

                      <div class="controls">
                        <span class="input-icon">
                          <input type="text" id="txtNombrePadre" placeholder="nombre" />
                        </span>
                        <span class="input-icon">
                          <input type="text" id="txtApellidoPaterno" placeholder="apellido paterno" />
                        </span>
                        <span class="input-icon">
                          <input type="text" id="txtApellidoMaterno" placeholder="apellido materno" />
                        </span>
                      </div>
                    </div>

                    <div class="control-group">
                      <label class="control-label" for="txtNombreAlumno">Contacto</label>
                      <div class="controls">
                        <span class="input-icon">
                          <input type="text" id="txtTelefono" placeholder="telefono" />
                          <i class="icon-phone"></i> 
                        </span>
                        <span class="input-icon">
                          <input type="email" id="txtemail" placeholder="email" data-placement="bottom" data-rel="tooltip" data-original-title="la cuenta de correo sera su usuario para el sistema" />
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
                  <button class="btn btn-info"  type="button">
                    <i class="icon-ok bigger-110"></i>
                    Aceptar
                  </button>
                  &nbsp; &nbsp; &nbsp;
                  <button class="btn" type="reset">
                    <i class="icon-undo bigger-110"></i>
                    Limpiar
                  </button>
                </div>

              </form>


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
