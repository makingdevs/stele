<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Registro de escuela</title>

  </head>

  <body>
  <header class="jumbotron subhead" id="overview">
    <div class="container">
      <h1>Registra tu escuela</h1>
      <p class="lead">Date de alta con un correo y el nombre de tu institución.</p>
    </div>
  </header>

  <div class="container">
    <div class="row">
      <div class="span12">
        <section id="basic-info">
          <h2 id="headings">Datos básicos</h2>
          <g:form controller="registro" action="crear" class="form-horizontal">
            <div class="control-group">
              <label class="control-label" for="inputInstitucion">Institución : </label>
              <div class="controls">
                <input id="inputInstitucion" placeholder="Nombre de la escuela" type="text" class="input-xxlarge">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputEmail">Correo electrónico : </label>
              <div class="controls">
                <input id="inputEmail" placeholder="your@mail.com" type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputPassword">Contraseña : </label>
              <div class="controls">
                <input id="inputPassword" placeholder="Password" type="password">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="inputConfirmPassword">Confirmar contraseña : </label>
              <div class="controls">
                <input id="inputConfirmPassword" placeholder="Confirm Password" type="password">
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <button type="submit" class="btn">Registrar mis datos</button>
              </div>
            </div>
          </g:form>
        </section>
      </div>
    </div>
  </div>

  </body>
</html>
