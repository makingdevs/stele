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
      width: 300%;
      height: 200px;
    }
    .slide {
      float: left;
      width: 190px;
      height: 0px;
    }
    .holder {
      width: 300%;
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




  <g:layoutBody/>
  <r:layoutResources />
  
  </body>
</html>
