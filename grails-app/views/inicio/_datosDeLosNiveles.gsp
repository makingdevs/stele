<g:set var="niveles" value="${distribucionDeCicloEscolar.value}" />
<g:each in="${niveles.sort()}" var="nivel">
  <div class="span3">
  <div class="dd" id="nestable">
    <ol class="dd-list">
      <li class="dd-item" data-id="1">
        <div class="dd-handle">${nivel.key.toLowerCase().capitalize()}
          <span class="sticker">
            <a data-rel="tooltip" data-placement="left" title="inscritos">
              <span class="label arrowed-in label-pink tooltip-info"> 
                <strong>${nivel.value.size()}</strong>
              </span>
            </a>
          </span>
        </div>
          <g:set var="grados" value="${nivel.value}"/>
          <g:each in="${grados.sort()}" var="grado"> 
            <ol class="dd-list">
            <li class="dd-item dd-collapsed " data-id="2">

            <div class="dd-handle ">
              Grado ${grado.key}ª
              <span class="sticker">
                <a data-rel="tooltip" data-placement="left" title="inscritos">
                  <span class="label arrowed-in label-purple tooltip-info"> 
                    <strong>${grado.value.size()}</strong>
                  </span>
                </a>
              </span>
            </div>
            <g:set var="turnos" value="${grado.value}"/> 
            <g:each in="${turnos.sort()}" var="turno">
                <g:set var="grupos" value="${turno.value}"/>
                <g:each in="${grupos.sort()}" var="grupo">
                  <ol class="dd-list">
                    <li class="dd-item item-orange" data-id="3">
                      <div class="dd-handle"> Grupo ${grupo.key} - ${turno.key}
                        <span class="sticker">
                          <a data-rel="tooltip" data-placement="left" title="inscritos">
                            <span class="label arrowed-in label-grey tooltip-info"> 
                            <strong>${grupo.value.size()}</strong>
                            </span>
                          </a>
                        </span>
                      </div>
                    </li>
                  </ol>
                </g:each>
            </g:each>
            </li>
            </ol>
          </g:each>
      </li>
    </ol>
  </div>
  </div>
  <div class="vspace-12"></div>
</g:each>