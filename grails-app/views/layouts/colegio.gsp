<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <title>Colegio ABC</title>

    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <r:require module="colegio" />
    

    <!--[if IE 7]>
      <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!--page specific plugin styles-->

    <!--fonts-->

    <!--ace styles-->

    <!--[if lte IE 8]>
      <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!--inline styles related to this page-->

    <!--ace settings handler-->

    <g:layoutTitle/>
    <r:layoutResources/>
  </head>

  <body>
    <div class="navbar" id="navbar">
      <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
      </script>

      <div class="navbar-inner">
        <div class="container-fluid">
          <a href="#" class="brand">
            <small>
              <i class="icon-cloud"></i>
              <strong>Colegio ABC</strong>
            </small>
          </a><!--/.brand-->

          <ul class="nav ace-nav pull-right">
            <li class="white">  
                  <strong> &nbsp &nbsp &nbsp ${new Date().format('dd MMMM yyyy')} &nbsp &nbsp &nbsp</strong>
            </li>
            <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
              <li class="grey">
                <g:link controller="estadoDeCuenta" action="show" class="dropdown-toggle">
                  <i class="icon-home icon-large"></i>                
                </g:link>
              </li>
            </sec:ifAllGranted>
            <li class="light-blue">
              <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                <span class="user-info">
                  <small>
                    Bienvenido
                  </small>
                  <sec:loggedInUserInfo field="username"/> 
                </span>

                <i class="icon-caret-down"></i>
              </a>

              <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
                <li>
                  <sec:ifAllGranted roles="ROLE_DIRECTOR">
                    <g:link controller="perfil" action="administrador">
                        <i class="icon-user"></i>
                        Perfil
                      </g:link>
                    </sec:ifAllGranted>
                  <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
                    <g:link controller="perfil">
                      <i class="icon-user"></i>
                      Perfil
                    </g:link>
                  </sec:ifAllGranted>
                </li>
                <li class="divider"></li>
                <li>
                  <g:link controller="logout">
                    <i class="icon-off"></i>
                    Salir
                  </g:link>
                </li>
              </ul>
            </li>
          </ul><!--/.ace-nav-->
        </div><!--/.container-fluid-->
      </div><!--/.navbar-inner-->
    </div>

  <sec:ifAllGranted roles="ROLE_DIRECTOR">
    <div class="main-container container-fluid">
      <a class="menu-toggler" id="menu-toggler" href="#">
        <span class="menu-text"></span>
      </a>

        <div class="sidebar" id="sidebar">
        
<!--#Menu stele-->
          <ul class="nav nav-list">
          <li class="active open">
            <a href="#" class="dropdown-toggle">
              <i class="icon-edit"></i>
              <span class="menu-text"> Inscripcion </span>
              <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
              <li>
                <g:link controller="inicio" action="index" params="[cobro:false]">
                  <i class="icon-double-angle-right"></i>
                  Archivo
                </g:link>
              </li>
              <li>
                 <g:link controller="inicio" action="index" params="[cobro:true]">
                  <i class="icon-double-angle-right"></i>
                  Archivo + Cobro
                </g:link>
              </li>
              <li>
                <g:link controller="inscripcionManual" action="inscripcion" params="[accion:'manual']">
                  <i class="icon-double-angle-right"></i>
                  Manual
                </g:link>
              </li>
            </ul>
          </li>
          <li>
            <a href="#" class="dropdown-toggle">
              <i class="icon-usd"></i>
              <span class="menu-text"> Cobros </span>
              <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
              <li>
                <g:link controller="pago" action="generarPagoEnVentanilla">
                  <i class="icon-double-angle-right"></i>
                  Manual
                </g:link>
              </li>
              <li>
                <g:link controller="esquemaDePago" action="nuevo">
                  <i class="icon-double-angle-right"></i>
                  Esquema de Pago
                </g:link>
              </li>
              <li>
                <g:link controller="dependiente" action="busqueda">
                  <i class="icon-double-angle-right"></i>
                  Busqueda
                </g:link>
              </li>
            </ul>
          </li>
          <li>
            <g:link controller="pago" action="mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos" >
              <i class="icon-random"></i>
              <span class="menu-text">Cociliacion</span>
            </g:link>
          </li>
          </ul><!--/.nav-list-->
        
<!--#Menu stele-->


        <div class="sidebar-collapse" id="sidebar-collapse">
          <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
        </div>

        <script type="text/javascript">
          try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
        </script>
      </div>
 </sec:ifAllGranted>

    <!--basic scripts-->
    

    <r:script>
      if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </r:script>

    <!--inline scripts related to this page-->


    <!--inline scripts related to this page-->

    <r:script>
      jQuery(function($) {

        $('#datosEscolares').ace_file_input({
          style:'well',
          btn_choose:'Arrastre el archivo o click',
          btn_change:null,
          no_icon:'icon-cloud-upload pink',
          droppable:true,
          thumbnail:'small'
          //,icon_remove:null//set null, to hide remove/reset button
          /**,before_change:function(files, dropped) {
            //Check an example below
            //or examples/file-upload.html
            return true;
          }*/
          /**,before_remove : function() {
            return true;
          }*/
          ,
          preview_error : function(filename, error_code) {
            //name of the file that failed
            //error_code values
            //1 = 'FILE_LOAD_FAILED',
            //2 = 'IMAGE_LOAD_FAILED',
            //3 = 'THUMBNAIL_FAILED'
            //alert(error_code);
          }
      
        }).on('change', function(){
          //console.log($(this).data('ace_input_files'));
          //console.log($(this).data('ace_input_method'));
        });
        
      });
    </r:script>


    <g:layoutBody/>
    <r:layoutResources/> 

  </body>
</html>
