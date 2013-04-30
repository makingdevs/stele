$ ->

  DependienteModel = Backbone.Model.extend

  DependienteView = Backbone.View.extend
    tagName: 'li',

    render : ->
      template = Handlebars.compile( ($ "#dependienteCard").html() )
      html     = template(@.model)
      @.$el.html( html )
      @
  
  Dependientes = Backbone.Collection.extend
    model: DependienteModel,
    initialize : (models, options) ->
      this.id = options.id

    url: ->
      "http://localhost:8080/stele/usuario/#{this.id}/dependientes"
  
  DependientesView = Backbone.View.extend
    tagName : 'ul',

    render : ->
      @.collection.each (dependiente)->
        dependienteView = new DependienteView( model : dependiente )
        ($ @.el).prepend( dependienteView.render().el )
      , @

      @
