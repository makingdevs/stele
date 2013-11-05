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
                <td>${it.distribucionInstitucional.turno}</td>
                <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                <td>${it.distribucionInstitucional.grado}</td>
                <td>${it.distribucionInstitucional.grupo}</td>
                <td >
                  <div class="action-buttons">
                    <a class="blue" href="#">
                      <i class="icon-zoom-in bigger-130"></i>
                    </a>
                    <a class="red" href="#">
                      <i class="icon-trash bigger-130"></i>
                    </a>
                  </div>
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