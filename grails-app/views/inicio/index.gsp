<html >
  <head>
  <meta name="layout" content="steleDashboardTwitterBootstrap"/>
    <title>Colegio ABC</title>
    <r:require modules="inscripcionArchivo" />
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
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->

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

                        <button class="btn btn-success btn-next" data-last="Finalizar">
                          Siguiente
                          <i class="icon-arrow-right icon-on-right"></i>
                        </button>
                      </div>
                      <div id="fuelux-wizard" class="row-fluid hide" data-target="#step-container">
                        <ul class="wizard-steps">
                          <li data-target="#step1" class="active">
                            <span class="step">1</span>
                            <span class="title">Importe el archivo</span>
                          </li>

                          <li data-target="#step2">
                            <span class="step">2</span>
                            <span class="title">Verifique</span>
                          </li>

                          <li data-target="#step3"> 
                            <span class="step">3</span>
                            <span class="title">Procesar Incripción</span>
                          </li>

                          <li data-target="#step4">
                            <span class="step">4</span>
                            <span class="title">Resultado</span>
                          </li>
                        </ul>

                      </div>

                      <hr />
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
                                  <div class="widget-body">
                                    <div class="widget-main">
                                      <input  type="file" id="id-input-file-3" />
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>  
                          </div>

                          <div class="step-pane" id="step2">

                            <div class="row-fluid">
                              <div class="span12 infobox-container">
                                <div class="infobox infobox-blue  ">
                                  <div class="infobox-icon">
                                    <i class="icon-file-text blue icon-2x"></i>
                                  </div>

                                  <div class="infobox-data">
                                    <span class="infobox-data-number">1,000</span>
                                    <div class="infobox-content">Total Registros Archivo</div>
                                  </div>
                                </div>

                                <div class="infobox infobox-green  ">
                                  <div class="infobox-icon">
                                    <i class="icon-smile  icon-large green"></i>
                                  </div>

                                  <div class="infobox-data">
                                    <span class="infobox-data-number">998</span>
                                    <div class="infobox-content">Registros Correctos</div>
                                  </div>
                                </div>

                                <div class="infobox infobox-red  ">
                                  <div class="infobox-icon ">
                                    <i class="icon-frown red"></i>
                                  </div>

                                  <div class="infobox-data">
                                    <span class="infobox-data-number">2</span>
                                    <div class="infobox-content">Registros Erroneos</div>
                                  </div>
                                </div>

                                <div class="space-6"></div>

                              </div>
                            </div>
                            <div class="row-fluid">
                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">

                                      <div class="dd-handle">Kinder - Matutino 
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Kinder - Vespertino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>

                              <div class="vspace-12"></div>

                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Primaria - Matutino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Primaria - Vespertino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>

                              <div class="vspace-12"></div>

                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Secundaria - Matutino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Secundaria - Vespertino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>

                              <div class="vspace-12"></div>

                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Preparatoria - Matutino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Preparatoria - Vespertino
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A 
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>
                            </div><!--PAGE EDN CIFRA-->

                            <!--Inica DEtalleRA-->
                            <h3 class="header smaller lighter purple">Detalle alumnos</h3>
                            <div class="row-fluid">
                              <div class="span12">
                                <div class="tabbable">
                                  <ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab">
                                    <li class="active">
                                      <a data-toggle="tab" href="#faq-tab-1">
                                        <i class="green icon-group   bigger-120"></i>
                                        Kinder
                                      </a>
                                    </li>

                                    <li>
                                      <a data-toggle="tab" href="#faq-tab-2">
                                        <i class="blue icon-group   bigger-120"></i>
                                        Primaria
                                      </a>
                                    </li>

                                    <li>
                                      <a data-toggle="tab" href="#faq-tab-3">
                                        <i class="pink icon-group  bigger-120"></i>
                                        Secundaria
                                      </a>
                                    </li>
                                    <li>
                                      <a data-toggle="tab" href="#faq-tab-3">
                                        <i class="orange icon-group   bigger-120"></i>
                                        Secundaria
                                      </a>
                                    </li>
                                  </ul>
                                  <div class="tab-content no-border padding-24">
                                    <div id="faq-tab-1" class="tab-pane fade in active">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>
                                              
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>
                                    <div id="faq-tab-2" class="tab-pane fade">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>
                                              
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>

                                    <div id="faq-tab-3" class="tab-pane fade">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>  
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>

                                    <div id="faq-tab-4" class="tab-pane fade">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>  
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>  

                          <div class="step-pane" id="step3">
                            <form class="form-horizontal" id="sample-form">
                              <div class="center">
                                <div class="alert alert-block alert-info">
                                  <p>
                                    <strong>
                                      <i class="icon-ok"></i>
                                      Confirmar!
                                    </strong>
                                    Este proceso registra la informacion en el sistema, por lo que importante que de <strong> click </strong> en procesar.
                                  </p>

                                  <p>
                                    <span class="btn btn-app btn-success " href="#">
                                      <i class="icon-cogs bigger-230 "></i>
                                      <strong>  Procesar  </strong>
                                    <br>
                                    </span>
                                  </p>
                                </div>
                              </div>
                            </form>
                          </div>

                          <div class="step-pane" id="step4">
                            <h3 class="header  green ">Alumnos Inscritos</h3>
                            <div class="row-fluid">
                              <div class="span12 infobox-container">
                                <div class="infobox infobox-blue  ">
                                  <div class="infobox-icon">
                                    <i class="icon-file-text blue icon-2x"></i>
                                  </div>

                                  <div class="infobox-data">
                                    <span class="infobox-data-number">1,000</span>
                                    <div class="infobox-content">Total Registros Archivo</div>
                                  </div>
                                </div>

                                <div class="infobox infobox-green  ">
                                  <div class="infobox-icon">
                                    <i class="icon-smile  icon-large green"></i>
                                  </div>

                                  <div class="infobox-data">
                                    <span class="infobox-data-number">998</span>
                                    <div class="infobox-content">Registros Correctos</div>
                                  </div>
                                </div>

                                <div class="infobox infobox-red  ">
                                  <div class="infobox-icon ">
                                    <i class="icon-frown red"></i>
                                  </div>

                                  <div class="infobox-data">
                                    <span class="infobox-data-number">2</span>
                                    <div class="infobox-content">Registros Erroneos</div>
                                  </div>
                                </div>

                                <div class="space-6"></div>

                              </div>
                            </div>
                            <div class="row-fluid">
                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">

                                      <div class="dd-handle">Kinder - Matutino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Kinder - Vespertino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>

                              <div class="vspace-12"></div>
                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">

                                      <div class="dd-handle">Primaria - Matutino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Primaria - Vespertino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>

                              <div class="vspace-12"></div>
                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">

                                      <div class="dd-handle">Secundaria - Matutino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Secundaria - Vespertino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>

                              <div class="vspace-12"></div>
                              <div class="span3">
                                <div class="dd" id="nestable">
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">

                                      <div class="dd-handle">Preparatoria - Matutino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                  <ol class="dd-list">
                                    <li class="dd-item" data-id="1">
                                      <div class="dd-handle">Preparatoria - Vespertino <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                        <span class="sticker">
                                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                                            <span class="label arrowed-in label-pink tooltip-info"> 
                                              <strong>50</strong>
                                            </span>
                                          </a>
                                        </span>
                                      </div>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed " data-id="2">

                                          <div class="dd-handle ">
                                            Grado 1ro <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>30</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>15</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>8</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                      <ol class="dd-list">
                                        <li class="dd-item dd-collapsed" data-id="2">
                                          <div class="dd-handle">
                                            Grado 2do <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                            <span class="sticker">
                                              <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                <span class="label arrowed-in label-purple tooltip-info"> 
                                                  <strong>20</strong>
                                                </span>
                                              </a>
                                            </span>
                                          </div>

                                          <ol class="dd-list">
                                            <li class="dd-item item-orange" data-id="3">
                                              <div class="dd-handle"> Grupo A <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>7</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-red" data-id="4">
                                              <div class="dd-handle">Grupo B <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>5</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>

                                            <li class="dd-item item-blue2" data-id="5">
                                              <div class="dd-handle">Grupo C <i class="icon-cog icon-large orange"></i> <i class="icon-ok icon-large green"></i>
                                                <span class="sticker">
                                                  <a data-rel="tooltip" data-placement="left" title="inscritos">
                                                    <span class="label arrowed-in label-grey tooltip-info"> 
                                                    <strong>4</strong>
                                                    </span>
                                                  </a>
                                                </span>
                                              </div>
                                            </li>
                                          </ol>
                                        </li>
                                      </ol>
                                    </li>
                                  </ol>
                                </div>
                              </div>
                            </div><!--PAGE EDN CIFRA-->

                            <!--Inica DEtalleRA-->
                            <h3 class="header smaller lighter purple">Detalle alumnos</h3>
                            <div class="row-fluid">
                              <div class="span12">
                                <div class="tabbable">
                                  <ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab">
                                    <li class="active">
                                      <a data-toggle="tab" href="#faq-tab-1">
                                        <i class="green icon-group   bigger-120"></i>
                                        Kinder
                                      </a>
                                    </li>

                                    <li>
                                      <a data-toggle="tab" href="#faq-tab-2">
                                        <i class="blue icon-group   bigger-120"></i>
                                        Primaria
                                      </a>
                                    </li>

                                    <li>
                                      <a data-toggle="tab" href="#faq-tab-3">
                                        <i class="pink icon-group  bigger-120"></i>
                                        Secundaria
                                      </a>
                                    </li>
                                    <li>
                                      <a data-toggle="tab" href="#faq-tab-3">
                                        <i class="orange icon-group   bigger-120"></i>
                                        Secundaria
                                      </a>
                                    </li>
                                  </ul>
                                  <div class="tab-content no-border padding-24">
                                    <div id="faq-tab-1" class="tab-pane fade in active">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>
                                              
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>
                                    <div id="faq-tab-2" class="tab-pane fade">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>
                                              
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>

                                    <div id="faq-tab-3" class="tab-pane fade">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>  
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>

                                    <div id="faq-tab-4" class="tab-pane fade">
                                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead >
                                          <tr>
                                            <th>  
                                              <i class="icon-screenshot blue"></i>
                                              Ciclo Escolar
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Padre
                                            </th>
                                            <th>
                                              <i class="icon-envelope blue"></i>
                                              Email
                                            </th>
                                            

                                            <th>
                                              <i class="icon-phone blue"></i>
                                              Telefono
                                            </th>
                                            <th>
                                              <i class="icon-user blue"></i>
                                              Nombre Alumno
                                            </th>
                                            <th>
                                              <i class="icon-compass blue"></i>
                                              Ubicacion
                                            </th>   
                                            <th>
                                              <i class="icon-adjust blue"></i>
                                              Turno
                                            </th>
                                          </tr>
                                        </thead>

                                        <tbody>
                                          <tr>
                                            <td>2012/2013</td>
                                            <td>SegioRodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 1 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR1 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 2 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 3 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR3 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 4 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR4 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                            <tr>
                                            <td>2012/2013</td>
                                            <td>Segio 5 Rodriguez de Reyes</td>
                                            <td>sergio@makingdevs.com</td>
                                            <td>1234567890</td>
                                            <td>Sergio JR5 Reyes Rodriguez</td>
                                            <td>4to A</td>
                                            <td>Vespertino</td>
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>  
                        </div>
                      <hr />
                    </div>
                  </div><!--/widget-main-->
                </div><!--/widget-body-->
              </div>



              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->
      </div><!--/.main-content-->
    <script type="text/javascript">
      jQuery(function($) {
        console.log("camiza")
        var $validation = false;
        $('#fuelux-wizard').ace_wizard().on('change' , function(e, info){
        console.log("camiza2")

          if(info.step == 1 && $validation) {
            if(!$('#validation-form').valid()) return false;
          }
        }).on('finished', function(e) {
          bootbox.dialog("Gracias!, Su informacion ha sido guardada satisfactoriamente!", [{
            "label" : "OK",
            "class" : "btn-small btn-primary",
            }]
          );
        }).on('stepclick', function(e){
          //return false;//prevent clicking on steps
        });
      })
    </script>

  </body>
</html>