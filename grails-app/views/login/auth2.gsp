<html>
<head>
  <meta name="layout" content="twitterBootstrapAuth"/>
  <title>Inicia tu sesión</title>
  <r:require module="auth"/>
</head>

<body>

  <g:if test='${flash.message}'>
    <div class="alert alert-error">
      <button type="button" class="close" data-dismiss="alert">×</button>
      <div class='login_message'><strong>Cuidado!</strong> Nombre de usuario o contraseña incorrectos</div>
    </div>
  </g:if>

  <form class="form-signin" action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
    <h2 class="form-signin-heading">Inicia sesión</h2>
    <input type="text" class="input-block-level" placeholder="Correo electrónico" name='j_username' id='username'>
    <input type="password" class="input-block-level" placeholder="Contraseña" name='j_password' id='password'>
    <label class="checkbox">
      <input type='checkbox' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
      Recordarme
    </label>
    <button class="btn btn-large btn-primary" type="submit">Iniciar sesión</button>
  </form>

  <script type='text/javascript'>
    <!--
    (function() {
      document.forms['loginForm'].elements['j_username'].focus();
    })();
    // -->
  </script>
</body>
</html>
