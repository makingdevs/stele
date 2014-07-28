<g:if test="${dependientes}">
<g:form id="pagosUnitarios" name="pagosUnitarios" controller="esquemaDePago" action="paraCamada" params="[camada:'${institucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")}']">
  <div class="widget-body">
    <div class="widget-main no-padding">
      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
        <thead >
          <tr>
            <th class="center">
              <label>
                <span class="lbl"></span>
              </label>
            </th>
            <th>
              <i class="icon-user blue"></i>
              Nombre 
            </th>
            <th>
              <i class="icon-compass blue"></i>
              Ubicación
            </th>
            <th>
              <i class="icon-compass blue"></i>
              Turno
            </th>
          </tr>
        </thead>
        <tbody>
          <g:each in="${dependientes}">
            <tr>
              <td class="center">
                <label>
                  <g:checkBox name="listaDependientes" value="${it.id}" checked="false" />
                  <span class="lbl"></span>
                </label>
              </td>
              <td>${it.perfil.nombre}   ${it.perfil.apellidoPaterno}  ${it.perfil.apellidoMaterno}</td>
              <td><g:ubicacionDependiente idDependiente="${it.id}"> </g:ubicacionDependiente></td>
              <td><g:turnoDependiente idDependiente="${it.id}"></g:turnoDependiente></td>
            </tr>                    
          </g:each>
        </tbody>
      </table>
    </div>
    <div class="widget-toolbox padding-8 clearfix center" id="searchButtonDiv">
      <div class="alert alert-warning">
        Seleccione un alumno para generar un cobro   
      </div>
    </div>
  </div>
</g:form>
</g:if>

