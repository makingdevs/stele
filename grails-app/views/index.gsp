<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="twitterBootstrapMain"/>
		<title>Principal</title>

    <r:require modules="handlebars, backbone" />

    <script id="entry-template" type="text/x-handlebars-template">
      <div class="entry">
        <h1>{{title}}</h1>

        {{#with author}}
          <h2>By {{firstName}} {{lastName}}</h2>
        {{/with}}
      </div>
    </script>

    <r:script>
      $(function() {

        var IndexView = new Backbone.View.extend( {
          el:$('content-template'),

          initialize : function() {
            this.render();
          },

          render : function() {
            var source   = $("#entry-template").html();
            var template = Handlebars.compile(source);
            var context = {
              title: "My first post!",
              author: {
                firstName: "Charles",
                lastName: "Jolley"
              }
            }
            var html = template(context);
            this.el.html( template );
          }
        });

        var Rutas = new Backbone.Routes.extend({

          

        })

      })
    </r:script>
	</head>

	<body>
    <div class="masthead">
      <ul class="nav nav-pills pull-right">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Acerca</a></li>
        <li><a href="#">Contacto</a></li>
      </ul>
      <h3 class="muted">Stele</h3>
    </div>

    <div id="content-template"></div>

    <hr>

    <div class="jumbotron">
      <h1>Controla la operación de tu institución escolar<h1>
      <p class="lead">Conoce los flujos de efectivos actuales y esperados de todos los pagos generados por eventos, actividades y/o servicios ofrecidos en tu institución.</p>
      <g:link controller="inicio" class="btn btn-large btn-success">Entra ya!</g:link>
    </div>

    <hr>

    <div class="row-fluid marketing">
      <div class="span6">
        <h4>Recepción de pagos</h4>
        <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

        <h4>Carga de información</h4>
        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

        <h4>Generación de pagos</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
      </div>

      <div class="span6">
        <h4>Promociones en pagos</h4>
        <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

        <h4>Historial de pagos</h4>
        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

        <h4>Conciliación</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
      </div>
    </div>

    <hr>
	</body>
</html>
