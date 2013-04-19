<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="twitterBootstrapMain"/>
		<title>Principal</title>

    <r:require modules="handlebars, backbone" />

    <script id="index_template" type="text/x-handlebars-template">
      <div class="entry">
        <h1>{{title}}</h1>
        {{#with author}}
        <h2>By {{firstName}} {{lastName}}</h2>
        {{/with}}
      </div>
    </script>

    <r:script>
      window.IndexView = Backbone.View.extend({
        initialize: function(){
            this.render();
        },
        render: function(){
          var context = {
            title: "My first post!",
            author: {
              firstName: "Charles",
              lastName: "Jolley"
            }
          }

          var template = Handlebars.compile($("#index_template").html());
          var html     = template(context);

          this.$el.html( html );
        }
      });

      var AppRouter = Backbone.Router.extend({

        routes : {
          '':'home',
          'mostrarTemplate':'template'
        },

        home: function() {
          var $container = $("#index_container");
          $container.empty();
        },

        template : function() {
          new IndexView({ el: $("#index_container") });
        }

      });

      Backbone.history.start();
      var app_router = new AppRouter;

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

    <div id="index_container"></div>
    <a href="#" class="btn btn-warning"> home </a>
    <a href="#mostrarTemplate" class="btn btn-warning"> spoiler </a>

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
