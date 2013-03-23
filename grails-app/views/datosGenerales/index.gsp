<html>
<head>
  <meta name="layout" content="twitterBootstrapMain"/>
  <title>Datos Generales</title>
</head>
<body>
  <form class="form-horizontal">
    <div class="control-group">
      <label class="control-label" for="inputEmail">FOTO</label>
      <div class="controls">
        <h1>Nombre y foto de usuario</h1>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="inputEmail">Contraseña actual</label>
      <div class="controls">
        <g:textField name="myField" value="${myValue}" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="inputPassword">Password</label>
      <div class="controls">
        <input type="password" id="inputPassword" placeholder="Password">
      </div>
    </div>
    <div class="control-group">
      <div class="controls">
        <label class="checkbox">
          <input type="checkbox"> Remember me
        </label>
        <button type="submit" class="btn">Sign in</button>
      </div>
    </div>
  </form>
</body>
</html>