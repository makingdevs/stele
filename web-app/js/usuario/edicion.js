// Generated by CoffeeScript 1.4.0

$(function() {
  var PerfilModel, PerfilView, modelo;
  PerfilModel = Backbone.Model.extend({
    url: function() {
      return "http://localhost:8080/stele/usuario/obtenerPerfilUsuario/";
    }
  });
  PerfilView = Backbone.View.extend({
    render: function() {
      var html, template;
      template = Handlebars.compile(($("#encabezadoUsuario")).html());
      html = template(this.model);
      this.$el.html(html);
      return this;
    }
  });
  modelo = new PerfilModel;
  return modelo.fetch({
    success: function(model, response, options) {
      var perfilView;
      perfilView = new PerfilView({
        model: response
      });
      return $('#encabezadoContainer').html(perfilView.render().el);
    }
  });
});
