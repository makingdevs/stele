<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Registro de escuela</title>
    <r:require module="registrar"/>
  </head>
  <body>
  <header class="jumbotron subhead" id="overview">
    <div class="container">
      <h1>Registra tu escuela</h1>
      <p class="lead">Date de alta con un correo y el nombre de tu institución.</p>
    </div>
  </header>
  <div class="container">
      <g:if test="${flash.error}">  
        <div class="alert alert-error">
          ${flash.error}
        </div>
      </g:if>
  </div>
  <div class="container">
    <div class="row">
      <div class="span12">
        <section id="basic-info">
          <h2 id="headings">Datos básicos</h2>
          <g:form id="registroBasico" name="registroBasico" controller="registro" action="crear" class="form-horizontal">
            <div class="control-group">
              <label class="control-label" for="inputInstitucion">Institución : </label>
              <div class="controls">
                <input id="institucion.nombre" value="${params?.institucion?.nombre}" name="institucion.nombre" placeholder="Nombre de la escuela" type="text" class="input-xxlarge">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputInstitucion">Nombre : </label>
              <div class="controls">
                <input id="perfil.nombre" name="perfil.nombre" placeholder="Tu nombre" type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputInstitucion">Apellido paterno : </label>
              <div class="controls">
                <input id="perfil.apellidoPaterno" name="perfil.apellidoPaterno" placeholder="Tu primer apellido" type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputInstitucion">Apellido materno : </label>
              <div class="controls">
                <input id="perfil.apellidoMaterno" name="perfil.apellidoMaterno" placeholder="( No obligatorio )" type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputEmail">Correo electrónico : </label>
              <div class="controls">
                <input id="usuario.username" name="usuario.username" placeholder="your@mail.com" type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputPassword">Contraseña : </label>
              <div class="controls">
                <input id="usuario.password" class="passwordOrigin" name="usuario.password" placeholder="Password" type="password">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputConfirmPassword">Confirmar contraseña : </label>
              <div class="controls">
                <input id="inputConfirmPassword" name="inputConfirmPassword" placeholder="Confirm Password" type="password">
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <recaptcha:ifEnabled>
                  <recaptcha:recaptcha theme="red"/>
                </recaptcha:ifEnabled>
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <button type="submit" class="btn btn-primary"><i class="icon-thumbs-up"></i> Registrar mis datos</button>
              </div>
            </div>
          </g:form>
        </section>
      </div>
    </div>
  </div>
  </body>
</html>
