<!DOCTYPE html>
<html >
  <head>
    <meta charset="utf-8" />
    <title>Colegio ABC</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="">
    <r:require modules="bootstrap-js,bootstrap-css,bootstrap-responsive-css,font-awesome,assetsDashBoard" />
    <style type="text/css"> 
    .slider {
      width: 300px;
      height: 400px;
    }
    .slide {
      float: left;
      width: 190px;
      height: 500px;
    }
    .holder {
      width: 300%;
    }
    div#menu {
      border:2px solid green;
      width:150px;
      float:left;
      margin:10px 0 10px 5px;
      height:500px;
    }
    </style>
  <g:layoutHead/>
  <r:layoutResources />
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
            <li class="green">
              <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <i class="icon-envelope icon-animated-vertical"></i>
                <span class="badge badge-success">5</span>
              </a>

              <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
                <li class="nav-header">
                  <i class="icon-envelope-alt"></i>
                  5 Messages
                </li>

                <li>
                  <a href="#">
                    <img src="assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
                    <span class="msg-body">
                      <span class="msg-title">
                        <span class="blue">Alex:</span>
                        Ciao sociis natoque penatibus et auctor ...
                      </span>

                      <span class="msg-time">
                        <i class="icon-time"></i>
                        <span>a moment ago</span>
                      </span>
                    </span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    <img src="assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
                    <span class="msg-body">
                      <span class="msg-title">
                        <span class="blue">Susan:</span>
                        Vestibulum id ligula porta felis euismod ...
                      </span>

                      <span class="msg-time">
                        <i class="icon-time"></i>
                        <span>20 minutes ago</span>
                      </span>
                    </span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    <img src="assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
                    <span class="msg-body">
                      <span class="msg-title">
                        <span class="blue">Bob:</span>
                        Nullam quis risus eget urna mollis ornare ...
                      </span>

                      <span class="msg-time">
                        <i class="icon-time"></i>
                        <span>3:15 pm</span>
                      </span>
                    </span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    See all messages
                    <i class="icon-arrow-right"></i>
                  </a>
                </li>
              </ul>
            </li>

            <li class="light-blue">
              <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" />
                <span class="user-info">
                  <small>Bienvenido,</small>
                  ${usuario.perfil.nombre}
                </span>

                <i class="icon-caret-down"></i>
              </a>

              <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
                <li>
                  <a href="#">
                    <i class="icon-cog"></i>
                    Settings
                  </a>
                </li>

                <li>
                  <a href="#">
                    <i class="icon-user"></i>
                    Profile
                  </a>
                </li>

                <li class="divider"></li>

                <li>
                  <a href="#">
                    <i class="icon-off"></i>
                    Logout
                  </a>
                </li>
              </ul>
            </li>
          </ul><!--/.ace-nav-->
        </div><!--/.container-fluid-->
      </div><!--/.navbar-inner-->
    </div>
    <div id="menu">
      <div class="slider" id="slider">
          <div class="slide">
            <ul class="nav nav-list">
              <li class="active">
                <a href="index.html">
                  <i class="icon-dashboard"></i>
                  <span class="menu-text"> Colegio </span>
                </a>
              </li>
              <li >
                <a href="#" class="dropdown-toggle">
                  <i class="icon-edit"></i>
                  <span class="menu-text"> Inscripcion </span>
                  <b class="arrow icon-angle-down"></b>
                </a>

                <ul class="submenu">
                  <li>
                    <a href="inscripcionmanual.html">
                      <i class="icon-double-angle-right"></i>
                      Manual
                    </a>
                  </li>
                  <li>
                    <a href="inscripcionarchivo.html">
                      <i class="icon-double-angle-right"></i>
                      Archivo
                    </a>
                  </li>
                  <li>
                    <a href="inscripcionarchivocobro.html">
                      <i class="icon-double-angle-right"></i>
                      Archivo + Cobro
                    </a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="cobros.html">
                  <i class="icon-book"></i>
                  <span class="menu-text">Configurar cobros </span>
                </a>
              </li>
              <li>
                <a href="#" class="dropdown-toggle">
                  <i class="icon-usd"></i>
                  <span class="menu-text"> Cobros </span>
                  <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                  <li>
                    <a href="cobromanual.html">
                      <i class="icon-double-angle-right"></i>
                      Manual
                    </a>
                  </li>
                  <li>
                    <a href="cobroarchivo.html">
                      <i class="icon-double-angle-right"></i>
                      Archivo
                    </a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="conciliacion.html">
                  <i class="icon-random"></i>
                  <span class="menu-text">Cociliacion</span>
                </a>
              </li>
            </ul><!--/.nav-list-->
          </div>
        </div>
    </div>   
  <g:layoutBody/>
  <r:layoutResources />
  
  </body>
</html>
