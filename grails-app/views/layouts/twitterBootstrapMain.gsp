<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>. : Bienvenido a Stele - <g:layoutTitle default="Principal"/> : .</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <r:require modules="bootstrap-js,bootstrap-css,bootstrap-responsive-css" />
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

      /* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 700px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 60px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 72px;
        line-height: 1;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
    </style>

		<g:layoutHead/>
		<r:layoutResources />
  </head>

  <body>

    <div class="container-narrow">
      
		  <g:layoutBody/>

      <div class="footer">
        <p>&copy; Stele 2013</p>
      </div>

    </div> <!-- /container -->

		<r:layoutResources />
  </body>
</html>

