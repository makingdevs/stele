<script id="dependienteCard" type="text/x-handlebars-template">
  <div class="media">
    <span class="pull-left">
      <img class="media-object" src="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}" style="width: 114px; height: 114px;">
    </span>
    <div class="media-body">
      <p><strong>Matricula :</strong> <small> {{matricula}} </small></p>
      <p><strong>Nombre :</strong> <small> {{nombreCompleto}} </small></p>
      <p><strong>Nivel :</strong> <small> {nivel}} </small></p>
      <p><strong>Grado :</strong> <small> {{grado}} </small></p>
      <p><strong>Grupo :</strong> <small> {{grupo}} </small></p>
    </div>
  </div>
</script>
