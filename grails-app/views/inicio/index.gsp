<html >
  <head>
  <meta name="layout" content="steleDashboardTwitterBootstrap"/>
    <title>Colegio ABC</title>
    <r:require modules="upload" />
    <script language="javascript">
      function check() {
        if (document.layout.datosEscolares.value == '') {
          alert('No existe un archivo pra procesar !!');
          return false;
        } 
      }
    </script>
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
            <li class="active">Archivo</li>
          </ul><!--.breadcrumb-->
        </div>

        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Inscripcion Archivo
              <small>
                <i class="icon-double-angle-right"></i>
                Inscripcion Archivo de Alumnos y su Padre o Tutor
              </small>
            </h1>
          </div>
          <div class="row-fluid">
            <g:uploadForm name="layout" controller="inicio" action="preview" onsubmit="return check()">   
              <div class="span12">
                <div class="widget-box">
                  <div class="widget-header widget-header-blue widget-header-flat">
                </div>
                  <div class="widget-body">
                    <div class="widget-main">
                      <div class="row-fluid">
                        <div class="row-fluid wizard-actions">
                          <button class="btn btn-prev">
                            <i class="icon-arrow-left"></i>
                            Previo
                          </button>
                          <button class="btn btn-success btn-next" type="submit">
                            Siguiente
                            <i class="icon-arrow-right icon-on-right"></i>
                          </button>
                        </div>
                       
                        <div class="span10">
                          <table width="100%">
                            <th>
                              <td align="CENTER"><i class="icon-file icon-3x"></i></td>
                            </th>
                            <th>
                              <td align="CENTER"><i class="icon-search icon-3x"></i></td>
                            </th>
                            <th>
                              <td align="CENTER"><i class="icon-cogs icon-3x"></i></td>
                            </th>
                            <th>
                              <td align="CENTER"><i class="icon-ok icon-3x"></td>
                            </th>
                          </table>
                          <div class="progress">
                              <div class="bar progress-info" style="width: 11%;"></div>
                              
                          </div>
                          <table width="120%">
                            <th>
                              &nbsp;  
                              &nbsp;
                              &nbsp;
                              <td>Importe el archivo</td>
                            </th>
                            <th>
                              <td>Verifique</i></td>
                            </th>
                            <th>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              <td>   Procesar Incripción</td>
                            </th>
                            <th>
                              <td>Resultado</td>
                            </th>
                          </table>
                          <hr />
                        </div>
                        
                          <div class="step-content row-fluid  position-relative" id="step-container">
                            <div class="step-pane active" id="step1">
                              <div class="row-fluid">
                                <div class="span12">
                                  <div class="widget-box">
                                    <div class="widget-header blue">
                                      <h4>Plantilla</h4>
                                    </div>
                                    <div class="widget-body">
                                      <div class="widget-main">
                                        <div class="center">
                                          <span class="control-group warning">
                                            <a class="btn btn-app btn-info btn-mini blue" href="${resource(dir: 'template', file: 'plantilla.xls')}">
                                              <i class="icon-file-text bigger-160"></i>
                                              Plantilla
                                            </a>
                                            <span class=" help-inline ">
                                              Necesita descargar la plantilla y llenarla correctamente, todos los campos son obligatorios
                                            </span>
                                          </span>
                                        </div>
                                      </div>
                                    </div>
                                  </div>

                                  <div class="widget-box">
                                    <div class="widget-header blue">
                                      <h4><strong>Importar plantilla</strong></h4>
                                    </div>
                                    <div class="span6" align="CENTER">
                                      <p></p>
                                        <input type="file" name="datosEscolares" />
                                        <p></p>
                                    </div>
                                  </div>

                                </div>
                              </div>  
                            </div>    
                    </div><!--/widget-main-->
                  </div><!--/widget-body-->
                </div>
                <!--PAGE CONTENT ENDS-->
              </div><!--/.span-->
            </g:uploadForm>   
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->
      </div><!--/.main-content-->

  </body>
</html>