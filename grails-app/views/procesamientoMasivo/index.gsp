<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Resumen, información procesada</title>
  </head>

  <body>

    <div class="row">
      <div class="span12 label label-info">
        <h5>Resúmen de información procesada</h5>
      </div>
    </div>
    <br />

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
          <g:form name="resumen" controller="procesamientoMasivo" action="index">
            <div class="control-group">
              <label for="" class="control-label">Usuarios procesados: </label>
              <div class="controls">
                ${usariosProcesados}
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Dependientes procesados: </label>
              <div class="controls">
                ${dependientesProcesados}
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Ciclos escolares procesados: </label>
              <div class="controls">
                ${ciclosEcolaresProcesados} ${camadaGenerada}
              </div>
            </div>
            <div class="form-actions">
              <button type="submit" class="btn btn-large btn-block btn-primary">Generar pago para este procesamiento</button>
              <button type="submit" class="btn btn-large btn-block btn-primary">Ver dependientes de este procesamiento</button>
            </div>
          </g:form>
        </div>
      </div>
    </div>

  </body>
</html>
