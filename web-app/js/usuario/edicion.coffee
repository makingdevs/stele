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
  
  DependienteView = Backbone.View.extend
    tagName : "li",
    render : ->
      template = Handlebars.compile( ($ "#dependienteCard").html() )
      html     = template(@.model)
      @.$el.html( html )
      @

  Dependientes = Backbone.Collection.extend
    model : DependienteModel

  DependientesView = Backbone.View.extend
    tagName : "ul"
    render : ->

      console.log @
      console.log @.collection

      @.collection.each (dependienteModelo) ->
        console.log dependienteView
        @

      $.each @.collection, (index, value)->
        dependienteView = new DependienteView( model : value )
        @.$el.prepend( dependienteView.render().el )
      @

  modelo = new PerfilModel
  modelo.fetch
    success : (model, response, options) ->
      perfilView = new PerfilView( model : response )
      ($ '#encabezadoContainer').html(perfilView.render().el)

      
      dependientes = new Dependientes( { models : response.dependientes },  )
      dependientesView = new DependientesView( collection : dependientes )
      ($ '#dependienteContainer').html( dependientesView.render().el )






