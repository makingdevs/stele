$ ->
  PerfilModel = Backbone.Model.extend
    url : ->
      "http://localhost:8080/stele/usuario/obtenerPerfilUsuario/"

  PerfilView = Backbone.View.extend
    render: ->
      template = Handlebars.compile( ($ "#encabezadoUsuario").html())
      html     = template(@.model)
      this.$el.html( html )
      return @

  modelo = new PerfilModel
  modelo.fetch
    success : (model, response, options) ->
      perfilView = new PerfilView( model : response )
      $('#encabezadoContainer').html(perfilView.render().el)
