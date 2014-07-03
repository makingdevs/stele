<%@ page import="com.stele.NivelDeEstudio" %>
                        <div class="step-content row-fluid  position-relative" id="step-container">
                          <div class="step-pane active" id="step5">
                            <div class="tabbable3">
                                <ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab3">
                                  <li class="active">
                                    <a data-toggle="tab" href="#faq-tab-011">
                                      <i class="grey icon-group   bigger-120"></i>
                                      Maternal
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-111">
                                      <i class="pink icon-group   bigger-120"></i>
                                      Preescolar
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-222">
                                      <i class="blue icon-group   bigger-120"></i>
                                      Primaria
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-333">
                                      <i class="red icon-group   bigger-120"></i>
                                      Secundaria
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-444">
                                      <i class="green icon-group   bigger-120"></i>
                                      Preparatoria
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-555">
                                      <i class="orange icon-group   bigger-120"></i>
                                      Estudios Superiores
                                    </a>
                                  </li>
                                </ul>
                                
                                <div class="tab-content">                                                                    
                                  <div id="faq-tab-011" class="tab-pane active">
                                    <table width="100%" class="table table-condensed table-hover table-striped">
                                      <thead>
                                        <tr>
                                          <th>Nombre del padre/tutor</th>
                                          <th>Matrícula</th>
                                          <th>Nombre del estudiante</th>
                                          <th>Nivel de Estudios</th>
                                          <th>Grado</th>
                                          <th>Grupo</th>
                                          <th>Turno</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <g:findAll in="${historial}" expr="it.distribucionInstitucional.nivelDeEstudio == NivelDeEstudio.MATERNAL">
                                        <tr>

                                          <td>${it.dependiente.usuario.perfil.nombre} ${it.dependiente.usuario.perfil.apellidoPaterno} ${it.dependiente.usuario.perfil.apellidoMaterno}</td>
                                          <td>${it.dependiente.matricula}</td>
                                          <td>${it.dependiente.perfil.nombre} ${it.dependiente.perfil.apellidoPaterno} ${it.dependiente.perfil.apellidoMaterno}</td>
                                          <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                                          <td>${it.distribucionInstitucional.grado}</td>
                                          <td>${it.distribucionInstitucional.grupo}</td>
                                          <td>${it.distribucionInstitucional.turno}</td>
                                        </tr>
                                        </g:findAll>
                                      </tbody>
                                    </table>
                                  </div>
                                  <div id="faq-tab-111" class="tab-pane">
                                    <table width="100%" class="table table-condensed table-hover table-striped">
                                      <thead>
                                        <tr>
                                          <th>Nombre del padre/tutor</th>
                                          <th>Matrícula</th>
                                          <th>Nombre del estudiante</th>
                                          <th>Nivel de Estudios</th>
                                          <th>Grado</th>
                                          <th>Grupo</th>
                                          <th>Turno</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <g:findAll in="${historial}" expr="it.distribucionInstitucional.nivelDeEstudio == NivelDeEstudio.PREESCOLAR">
                                        <tr>

                                          <td>${it.dependiente.usuario.perfil.nombre} ${it.dependiente.usuario.perfil.apellidoPaterno} ${it.dependiente.usuario.perfil.apellidoMaterno}</td>
                                          <td>${it.dependiente.matricula}</td>
                                          <td>${it.dependiente.perfil.nombre} ${it.dependiente.perfil.apellidoPaterno} ${it.dependiente.perfil.apellidoMaterno}</td>
                                          <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                                          <td>${it.distribucionInstitucional.grado}</td>
                                          <td>${it.distribucionInstitucional.grupo}</td>
                                          <td>${it.distribucionInstitucional.turno}</td>
                                        </tr>
                                        </g:findAll>
                                      </tbody>
                                    </table>
                                  </div>
                                  <div id="faq-tab-222" class="tab-pane">
                                    <table width="100%" class="table table-condensed table-hover table-striped">
                                      <thead>
                                        <tr>

                                          <th>Nombre del padre/tutor</th>
                                          <th>Matrícula</th>
                                          <th>Nombre del estudiante</th>
                                          <th>Nivel de Estudios</th>
                                          <th>Grado</th>
                                          <th>Grupo</th>
                                          <th>Turno</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <g:findAll in="${historial}" expr="it.distribucionInstitucional.nivelDeEstudio == NivelDeEstudio.PRIMARIA">
                                        <tr>

                                          <td>${it.dependiente.usuario.perfil.nombre} ${it.dependiente.usuario.perfil.apellidoPaterno} ${it.dependiente.usuario.perfil.apellidoMaterno}</td>
                                          <td>${it.dependiente.matricula}</td>
                                          <td>${it.dependiente.perfil.nombre} ${it.dependiente.perfil.apellidoPaterno} ${it.dependiente.perfil.apellidoMaterno}</td>
                                          <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                                          <td>${it.distribucionInstitucional.grado}</td>
                                          <td>${it.distribucionInstitucional.grupo}</td>
                                          <td>${it.distribucionInstitucional.turno}</td>
                                        </tr>
                                        </g:findAll>
                                      </tbody>
                                    </table>
                                  </div>
                                  <div id="faq-tab-333" class="tab-pane">
                                    <table width="100%" class="table table-condensed table-hover table-striped">
                                      <thead>
                                        <tr>

                                          <th>Nombre del padre/tutor</th>
                                          <th>Matrícula</th>
                                          <th>Nombre del estudiante</th>
                                          <th>Nivel de Estudios</th>
                                          <th>Grado</th>
                                          <th>Grupo</th>
                                          <th>Turno</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <g:findAll in="${historial}" expr="it.distribucionInstitucional.nivelDeEstudio == NivelDeEstudio.SECUNDARIA">
                                        <tr>

                                          <td>${it.dependiente.usuario.perfil.nombre} ${it.dependiente.usuario.perfil.apellidoPaterno} ${it.dependiente.usuario.perfil.apellidoMaterno}</td>
                                          <td>${it.dependiente.matricula}</td>
                                          <td>${it.dependiente.perfil.nombre} ${it.dependiente.perfil.apellidoPaterno} ${it.dependiente.perfil.apellidoMaterno}</td>
                                          <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                                          <td>${it.distribucionInstitucional.grado}</td>
                                          <td>${it.distribucionInstitucional.grupo}</td>
                                          <td>${it.distribucionInstitucional.turno}</td>
                                        </tr>
                                        </g:findAll>
                                      </tbody>
                                    </table>
                                  </div>
                                  <div id="faq-tab-444" class="tab-pane">
                                    <table width="100%" class="table table-condensed table-hover table-striped">
                                      <thead>
                                        <tr>

                                          <th>Nombre del padre/tutor</th>
                                          <th>Matrícula</th>
                                          <th>Nombre del estudiante</th>
                                          <th>Nivel de Estudios</th>
                                          <th>Grado</th>
                                          <th>Grupo</th>
                                          <th>Turno</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <g:findAll in="${historial}" expr="it.distribucionInstitucional.nivelDeEstudio == NivelDeEstudio.BACHILLERATO">
                                        <tr>

                                          <td>${it.dependiente.usuario.perfil.nombre} ${it.dependiente.usuario.perfil.apellidoPaterno} ${it.dependiente.usuario.perfil.apellidoMaterno}</td>
                                          <td>${it.dependiente.matricula}</td>
                                          <td>${it.dependiente.perfil.nombre} ${it.dependiente.perfil.apellidoPaterno} ${it.dependiente.perfil.apellidoMaterno}</td>
                                          <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                                          <td>${it.distribucionInstitucional.grado}</td>
                                          <td>${it.distribucionInstitucional.grupo}</td>
                                          <td>${it.distribucionInstitucional.turno}</td>
                                        </tr>
                                        </g:findAll>
                                      </tbody>
                                    </table>
                                  </div>
                                  <div id="faq-tab-555" class="tab-pane">
                                    <table width="100%" class="table table-condensed table-hover table-striped">
                                      <thead>
                                        <tr>

                                          <th>Nombre del padre/tutor</th>
                                          <th>Matrícula</th>
                                          <th>Nombre del estudiante</th>
                                          <th>Nivel de Estudios</th>
                                          <th>Grado</th>
                                          <th>Grupo</th>
                                          <th>Turno</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <g:findAll in="${historial}" expr="it.distribucionInstitucional.nivelDeEstudio == NivelDeEstudio.EDUCACION_SUPERIOR">
                                        <tr>

                                          <td>${it.dependiente.usuario.perfil.nombre} ${it.dependiente.usuario.perfil.apellidoPaterno} ${it.dependiente.usuario.perfil.apellidoMaterno}</td>
                                          <td>${it.dependiente.matricula}</td>
                                          <td>${it.dependiente.perfil.nombre} ${it.dependiente.perfil.apellidoPaterno} ${it.dependiente.perfil.apellidoMaterno}</td>
                                          <td>${it.distribucionInstitucional.nivelDeEstudio}</td>
                                          <td>${it.distribucionInstitucional.grado}</td>
                                          <td>${it.distribucionInstitucional.grupo}</td>
                                          <td>${it.distribucionInstitucional.turno}</td>
                                        </tr>
                                        </g:findAll>
                                      </tbody>
                                    </table>
                                  </div>  
                                </div>
                            </div>
                          </div>
                        </div>