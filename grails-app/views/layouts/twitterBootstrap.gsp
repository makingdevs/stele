<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>. : Stele - <g:layoutTitle default="Escolar"/> : .</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <r:require modules="bootstrap-js,bootstrap-css,bootstrap-responsive-css" />
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
    <g:layoutHead/>
    <r:layoutResources />
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Stele</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <!-- BEGIN: Menu de opciones -->
              <sec:ifAllGranted roles="ROLE_DIRECTOR">
                <li><g:link controller="inicio">Cargar layout</g:link></li>
                <li><a href="#">Generar pagos</a></li>
                <li><a href="#">Pagos generados</a></li>
              </sec:ifAllGranted>
              <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
                <li><a href="#">Mis pagos</a></li>
              </sec:ifAllGranted>
              <sec:ifLoggedIn>
                <li><g:link controller="perfil">Mi perfil</g:link></li>
              </sec:ifLoggedIn>
              <!-- END: Menu de opciones -->
            </ul>
          </div><!--/.nav-collapse -->
          <sec:ifLoggedIn>
          <ul class="nav pull-right">
            <li class="divider-vertical"></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <sec:loggedInUserInfo field="username"/> <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <g:link controller="logout">Salir / Logout</g:link>
                </li>
              </ul>
            </li>
          </ul>
          </sec:ifLoggedIn>
        </div>
      </div>
    </div>

    <div class="container">

      <g:layoutBody/>

      <hr>
      <div class="footer">
        <p>&copy; Stele 2013</p>
      </div>

    </div> <!-- /container -->
    <r:layoutResources />
  </body>
</html>
