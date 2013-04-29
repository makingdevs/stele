$ ->
  toType = (obj) ->
    ({}).toString.call(obj).match(/\s([a-zA-Z]+)/)[1].toLowerCase()

  PerfilModel = Backbone.Model.extend
    url : ->
      "http://localhost:8080/stele/usuario/obtenerPerfilUsuario/"

  PerfilView = Backbone.View.extend
    render: ->
      template = Handlebars.compile( ($ "#encabezadoUsuario").html())
      html     = template(@.model)
      @.$el.html( html )
      @

  DependienteModel = Backbone.Model.extend
    imagen : null,
    matricula : null,
    nombreCompleto : null,
    nivel : null,
    grado : null,
    grupo : null

  
  DependienteView = Backbone.View.extend
    tagName : "li",
    render : ->
      template = Handlebars.compile( ($ "#dependienteCard").html() )
      html     = template(@.model)
      @.$el.html( html )
      @

  Dependientes = Backbone.Collection.extend
    model : DependienteModel,
    initialize : (models) ->

  DependientesView = Backbone.View.extend
    tagName : "ul"
    render : ->
      @.collection.each (dependienteModelo) ->
        console.log dependienteModelo.get("matricula")
        @
      @

  modelo = new PerfilModel
  modelo.fetch
    success : (model, response, options) ->
      perfilView = new PerfilView( model : response )
      ($ '#encabezadocontainer').html(perfilView.render().el)

      dependientes = new Dependientes( response.dependientes )
      dependientesViews = new DependientesView( {collection : dependientes} )
      ($ '#dependienteContainer').html( dependientesViews.render().el )















