$ ->

  DependienteModel = Backbone.Model.extend({})

  DependienteView = Backbone.View.extend
    tagName: 'li',

    render : ->
      template = Handlebars.compile( ($ "#dependienteCard").html() )

      context = {
        imagen : @.model.get('imagen')
        matricula : @.model.get('matricula')
        nombreCompleto : @.model.get('nombreCompleto')
        nivel : @.model.get('nivel')
        grado : @.model.get('grado')
        grupo : @.model.get('grupo')
      }

      html     = template(context)
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
    success : (collection) ->
      ($ '#dependienteContainer').html( usuarioDependientesView.render().el )
