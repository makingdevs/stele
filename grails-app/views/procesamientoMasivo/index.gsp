<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Resumen, información procesada</title>
  </head>

  <body>

    <div class="page-header">
      <h1><i class="icon-tasks"></i> · Resumen <small>Información procesada</small></h1>
    </div>

    
    <div class="row">
      <div class="span4 text-success">
        <h1>${usariosProcesados}</h1>
        <h4><i class="icon-user"></i> Usuarios procesados</h4>
      </div>
      <div class="span4 text-success">
        <h1>${dependientesProcesados}</h1>
        <h4><i class="icon-group"></i> Dependientes procesados</h4>
      </div>
      <div class="span4 text-success">
        <h1>${ciclosEcolaresProcesados}</h1>
        <h4><i class="icon-calendar"></i> Ciclos escolares</h4>
      </div>
    </div>
    <hr/>
    <div class="row">
      <g:form name="resumenProcesamiento" controller="camada" action="show">
        <g:hiddenField name="camada" value="${camadaGenerada}" />
        <div class="form-actions">
          <g:link controller="esquemaDePago" action="paraCamada" class="btn btn-large btn-success" params="[camada:camadaGenerada]">
            <i class="icon-dollar"></i> Crear un pago para estos alumnos
          </g:link>
          <g:link controller="camada" action="show" class="btn btn-large btn-primary" params="[camada:camadaGenerada]">
            <i class="icon-eye-open"></i> Ver los alumnos
          </g:link>
        </div>
      </g:form>
    </div>
        


  </body>
</html>
