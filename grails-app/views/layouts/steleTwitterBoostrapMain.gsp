<!DOCTYPE html>
<html lang="en"> 
<head>
  <meta charset="utf-8">
  <title>. : Bienvenido a Stele - <g:layoutTitle default="Principal"/> : .</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <r:require modules="bootstrap-js,bootstrap-css,bootstrap-responsive-css,stele" />

  <g:layoutHead/>
  <r:layoutResources />
</head> 
<body>
 
<div class="top">
    <div class="container">         
        <ul class="loginbar pull-right">
            <li> 
            </li>
 
        </ul>
    </div>      
</div><!--/top-->    

  <!--=== Header ===-->
  <div class="header">               
    <div class="container"> 
      <!-- Logo -->       
      <div class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">
                    <img id="logo-header" src="new/assets/img/logo1-default.png" alt="Logo">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="navbar-header">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active">
                        <a href="inicio.html">
                            Inicio                            
                        </a>
                    </li>
                    <li >
                        <a href="steleprecio.html">
                            Precios                            
                        </a>
                    </li>
                    <li >
                        <g:link controller="registro">
                            Registro                            
                        </g:link>
                    </li>
                    <li >
                        <a href="steleservicios.html" >
                            Servicios                            
                        </a>
                    </li>                     
                    <li >
                        <a href="stelecontacto.html" >
                            Contacto                            
                        </a>
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
                        
    </div><!-- /container -->               
  </div><!--/header -->    

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
                <!-- Monthly Newsletter -->

            </div><!--/col-md-4-->
        </div><!--/row-->   
    </div><!--/container--> 
</div><!--/footer-->    
<!--=== End Footer ===-->

<!--=== Copyright ===-->
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
                <a href="index.html">
                    <img id="logo-footer" src="new/assets/img/logo2-default.png" class="pull-right" alt="" />
                </a>
            </div>
        </div><!--/row-->
    </div><!--/container--> 
</div><!--/copyright--> 
  <r:layoutResources />
</body>
</html> 