$ ->

  DependienteModel = Backbone.Model.extend({})

  DependienteView = Backbone.View.extend
    tagName: 'li',

    render : ->
      template = Handlebars.compile( ($ "#dependienteCard").html() )
      html     = template(@.model)
      @.$el.html( html )
      @
  
  Dependientes = Backbone.Collection.extend
    model: DependienteModel,
    url: ->
      "http://localhost:8080/stele/usuario/dependientes"
  
  DependientesView = Backbone.View.extend
    tagName : 'ul',

    render : ->
      @.collection.each (dependiente)->
        dependienteView = new DependienteView( model : dependiente )
        ($ @.el).prepend( dependienteView.render().el )
      , @

      @
  
  usuarioDependientes = new Dependientes
  usuarioDependientesView = new DependientesView( collection : usuarioDependientes )

  usuarioDependientes.fetch
    sucess : (collection) ->
      console.log "collection : #{collection}"
