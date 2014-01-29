<!DOCTYPE html>
<html lang="en"> 
<head>
  <meta charset="utf-8">
  <title>Stele.mx | Bienvenido...</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="${createLinkTo(dir: 'images', file: 'favicon.ico')}"/> 
  <r:require modules="steleCss,steleJs,bootstrap-js" />  
  <g:layoutHead/>
  <r:layoutResources />
</head> 
<body>
  <!--=== Top ===-->    
<div class="top">
    <div class="container">         
        <ul class="loginbar pull-right">
            <li> 
            </li>
 
        </ul>
    </div>      
</div><!--/top-->
<!--=== End Top ===-->    

<!--=== Header ===-->    
<div class="header">
    <div class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <g:link uri="/">
                  <g:img dir="/new/assets/img"  file="logo1-default.png" alt="Logo" />
                </g:link>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                      <g:link uri="/">
                        Inicio                            
                      </g:link>
                    </li>
                    <li >
                      <g:link controller="utilidades" action="precio">
                        Precios                            
                      </g:link>
                    </li>
                    <li >
                      <g:link controller="registro">
                        Registro                            
                      </g:link>
                    </li>
                    <li >
                      <g:link controller="utilidades" action="servicios">
                        Servicios                            
                      </g:link>
                    </li>                     
                    <li >
                      <g:link controller="utilidades" action="contacto">
                        Contacto                            
                      </g:link>
                    </li>
                    <li >
                      <g:link controller="login">
                        Ingresar                            
                      </g:link>
                    </li>                  
                </ul>
            </div><!-- /navbar-collapse -->
        </div>    
    </div>    
</div><!--/header-->
<g:layoutBody/>
<div class="footer">
  <div class="container">
    <div class="row">
      <div class="col-md-6 md-margin-bottom-20">
        <div class="headline"><h2>Contáctanos</h2></div> 
        <address class="md-margin-bottom-20">
          Av. México 145, Int. 404, Col. Del Carmen Coyoacán
          Del. Coyoacán. México, D.F.<br />
          Telefono:  (55) 6363 - 8147 <br />
          Email: <a href="mailto:info@stele.com.mx" class="">info@stele.com.mx</a>
        </address>         
      </div><!--/col-md-6-->  
      <div class="col-md-6">
      </div><!--/col-md-4-->
    </div><!--/row-->   
  </div><!--/container--> 
</div><!--/footer-->    
<div class="copyright">
  <div class="container">
    <div class="row">
      <div class="col-md-6">                      
        <p class="copyright-space">
          2014 &copy; - Stele. Derechos Reservados. 
          <a href="steleterminos.html">Términos y Condiciones</a>
        </p>
      </div>
      <div class="col-md-6">  
        <g:link uri="/">
          <g:img dir="/new/assets/img"  class="pull-right" file="logo2-default.png" />
        </g:link>
      </div>
    </div><!--/row-->
  </div><!--/container--> 
</div><!--/copyright--> 
  <r:layoutResources />
</body>
</html> 
