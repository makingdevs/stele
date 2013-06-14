<h3>Ciclo escolar: ${distribucionDeCicloEscolar.key}</h3>
<div class="row-fluid ">
  
    ${conteosDeEstructuraInstitucionalDelCicloEscolar}
    <div class="span3 well">
      <h3>Niveles</h3>
      <ul>
        <g:each in="${alumnosPorNivel.sort()}" var="nivel">
          <li>${nivel.key.toLowerCase().capitalize()} <span class="badge badge-info">${nivel.value}</span></li>
        </g:each>
      </ul>
      <h3>Grados por nivel</h3>
      <ul>
        <g:each in="${alumnosPorGrado.sort()}" var="nivel">
          <li>${nivel.key.toLowerCase().capitalize()}</li>
          <ul>
            <g:set var="grados" value="${nivel.value}"/>
            <g:each in="${grados.sort()}" var="grado">
              <li>${grado.key}ª <span class="badge badge-info">${grado.value}</span></li>
            </g:each>
          </ul>
        </g:each>
      </ul>
      <h3>Turnos</h3>
      <ul>
        <g:each in="${alumnosPorTurno.sort()}" var="nivel">
          <li>${nivel.key.toLowerCase().capitalize()}</li>
          <ul>
            <g:set var="grados" value="${nivel.value}"/>
            <g:each in="${grados.sort()}" var="grado">
              <li>${grado.key}ª</li>
              <g:set var="turnos" value="${grado.value}"/>
              <ul>
                <g:each in="${turnos.sort()}" var="turno">
                  <li>${turno.key.toLowerCase().capitalize()} <span class="badge badge-info">${turno.value}</span></li>
                </g:each>
              </ul>
            </g:each>
          </ul>
        </g:each>
      </ul>
    </div>
    
    <div class="span9 well">
      <h3>Grado, turno y grupo</h3>
      <g:set var="niveles" value="${distribucionDeCicloEscolar.value}" />
      <g:each in="${niveles.sort()}" var="nivel">
        <div class="span3">
          <ul>
            <li>${nivel.key.toLowerCase().capitalize()}</li>
            <ul>
              <g:set var="grados" value="${nivel.value}"/>
              <g:each in="${grados.sort()}" var="grado">
                <li>${grado.key}ª</li>
                <g:set var="turnos" value="${grado.value}"/>
                <ul>
                  <g:each in="${turnos.sort()}" var="turno">
                    <li>${turno.key}</li>
                    <g:set var="grupos" value="${turno.value}"/>
                    <ul>
                    <g:each in="${grupos.sort()}" var="grupo">
                      <li>${grupo.key} <span class="badge badge-info">${grupo.value.size()}</span></li>
                    </g:each>
                    </ul>
                  </g:each>
                </ul>
              </g:each>
            </ul>
          </ul>
        </div>
      </g:each>
    </div>
    
  

</div>
