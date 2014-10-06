<%@ page import="com.stele.Turno" %>
<g:if test="${dependientesPorEstructura}" >
<div class="span8 widget-container-span">
  <div class="widget-box">
    <div class="widget-header">
      <h5> Lista de Cobros </h5>
    </div>
    <g:form id="searchDependientes" name="searchDependientes" controller="esquemaDePago" action="paraCamada" >
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
              <input type="hidden" name="message" value="Generar Cobros"/>
              <input type="hidden" id="camada" name="camada", value="dependientesSearch_${new Date().format('dd-MM-yyyy')}">
              <g:each in="${dependientesPorEstructura}" var="dependiente" status="i">
              <tr>
                <td class="center">
                  <label>                    
                    <g:checkBox name="dependientes" value="${dependiente.dependiente.id[0]}" checked="false" />
                    <span class="lbl"></span>
                  </label>
                </td>
                <td>${dependiente.distribucionInstitucional.turno.first()}</td>
                <td>${dependiente.distribucionInstitucional.nivelDeEstudio.first()}</td>
                <td>${dependiente.distribucionInstitucional.grado.first()}</td>
                <td>${dependiente.distribucionInstitucional.grupo.first()}</td>
                <td >
                  ${dependiente.size()}
                </td>
              </tr>
              </g:each>            
          </tbody>
        </table>
      </div>

      <div class="widget-toolbox padding-8 clearfix">
        <input type="button" id="searchDependientesButton" name="searchDependientesButton" class="btn btn-primary btn-success" value="Generar Cobro">
      </div>
    </div>
    </g:form>    
  </div>
</div>
</g:if>

<!--/span-->
