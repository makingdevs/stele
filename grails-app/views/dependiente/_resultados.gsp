<g:formRemote id="busquedaIndividual" name="busquedaIndividual" url="[controller:'estadoDeCuenta',action:'obtenerPagosPorDependiente']" update="listaPagos">
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
            Ubicacion
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
                <g:checkBox name="idDependiente" value="${it.id}" checked="false" />
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
  <div class="widget-toolbox padding-8 clearfix center">
    <button type="submit" id="iniciarBusqueda" class="btn-small  btn-info ">
      Buscar cobros...
      <i class="icon-search icon-on-right bigger-110"></i>
    </button>
  </div>
</g:formRemote>