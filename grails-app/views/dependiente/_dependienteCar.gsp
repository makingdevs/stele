<%@ page import="com.stele.Turno" %>
<div class="span8 widget-container-span">
  <div class="widget-box">
    <div class="widget-header">
      <h5> Lista de Cobros </h5>
    </div>

    <div class="widget-body">
      <div class="widget-main no-padding">
        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
          <thead >
            <tr>
              <th></th>
              <th>
                <i class="icon-compass blue"></i>
                Turno
              </th>
              <th>
                <i class="icon-compass blue"></i>
                Nivel
              </th>
              <th>
                <i class="icon-compass blue"></i>
                Grado
              </th>
              <th>
                <i class="icon-compass blue"></i>
                Grupo
              </th>                   
              <th>
                <i class="icon-compass blue"></i>
                Alumnos
              </th>
            </tr>
          </thead>

          <tbody>
            <g:each in="${dependiente}">
              <tr>
                <td class="center">
                  <label>
                    <g:checkBox name="listaDependientes" value="${it.dependiente*.id}" checked="false" />
                    <span class="lbl"></span>
                  </label>
                </td>
                <td>${it.distribucionInstitucional.turno.first()}</td>
                <td>${it.distribucionInstitucional.nivelDeEstudio.first()}</td>
                <td>${it.distribucionInstitucional.grado.first()}</td>
                <td>${it.distribucionInstitucional.grupo.first()}</td>
                <td >
                  ${it.size()}
                </td>
              </tr>
            </g:each>
          </tbody>
        </table>
      </div>

      <div class="widget-toolbox padding-8 clearfix">
        <g:link controller="esquemaDePago" action="paraCamada" params="[camada:'${institucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")}']" class="btn btn-primary   btn-success">
          Generar cobro
          <i class="icon-arrow-right icon-on-right"></i>
        </g:link>
      </div>
    </div>
  </div>
</div><!--/span-->