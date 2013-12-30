<%@ page import="com.makingdevs.Sexo" %>
<%@ page import="com.makingdevs.TipoDeTelefono" %>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="telefono, uploadImg,bootstrap-js,bootstrapDatePicker,upload"/>
  </head>

  <body>
    <r:script type="text/javascript">
      $(document).ready(function() {
        $('.fechaNacimiento').datepicker({
          format : "dd/mm/yyyy",
          language : 'es',
          autoclose : true
        });
      });
      $(function() {
        var urlValue = $("input#url").val() 
        $("#imagenAdministrador").dropzone({
          url : urlValue,
          maxFilesize : .5,
          addRemoveLinks : false
        });
      });
    </r:script>
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
          </script>

          <ul class="breadcrumb">
            <li>
              <i class="icon-home home-icon"></i>
              <a href="#">Colegio</a>

              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>

            <li>
              <a href="#">Inscripcion</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            </li>
            <li class="active">Archivo</li>
          </ul><!--.breadcrumb-->


        </div>

    <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Editar perfil
            </h1>
          </div><!--/.    row-fluidpage-header-->

          <div class="row-fluid">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->
                <div id="user-profile-1" class="user-profile row-fluid">
                    <div class="tabbable">
                      <ul class="nav nav-tabs padding-18">
                        <li class="active">
                          <a data-toggle="tab" href="#home">
                            <i class="green icon-user bigger-120"></i>
                            Perfil
                          </a>
                        </li>

                        <li>
                          <a data-toggle="tab" href="#feed">
                            <i class="orange icon-rss bigger-120"></i>
                            Informacion de contacto
                          </a>
                        </li>

                        <li>
                          <a data-toggle="tab" href="#banco">
                            <i class="green icon-building  bigger-120"></i>
                            Bancarios
                          </a>
                        </li>


                        <li>
                          <a data-toggle="tab" href="#password">
                            <i class="pink icon-key bigger-120"></i>
                            Contraseña 
                          </a>
                        </li>
                      </ul>

                      <div class="tab-content no-border ">
                        <div id="home" class="tab-pane in active">
                          <div class="row-fluid">
                          <div class="span12">
                            <div class="span3 center">

                              <input type="hidden" value="${createLink(controller:'perfil', action:'uploadImage', id: usuarioAdministrador.perfil.id)}" id="url" />
                              <g:if test="${usuarioAdministrador.perfil.avatar}">
                              <img  src="${usuarioAdministrador.perfil.avatar.url()}" width="100" height="500" id="imagenPrincipal" />
                              </g:if>
                              <g:else>
                              <input type="file" id="imagenAdministrador" class="dropzone"       />
                              </g:else>
                              <div class="space-4"></div>
                              <div class="width-80 label label-info label-large arrowed-in arrowed-in-right">
                                <div class="inline position-relative">
                                  <span class="white middle bigger-120">
                                  ${usuarioAdministrador.perfil.nombre} ${usuarioAdministrador.perfil.apellidoPaterno} ${usuarioAdministrador.perfil.apellidoMaterno}
                                  </span>
                                </div>
                              </div>
                            </div>

                            <div class="span9">
                              <div class="profile-user-info profile-user-info-striped">
                                <div class="profile-contact-info">
                                  <div class="profile-contact-links center">
                                    <a class="btn btn-link" href="#">
                                      <i class="icon-envelope bigger-120 pink"></i>
                                      ${usuarioAdministrador.username}
                                    </a>

                                    <a class="btn btn-link" href="#">
                                      <i class="icon-phone bigger-125 blue"></i>
                                      <g:findAll in="${usuarioAdministrador.perfil.telefonos}" expr="it.principal ==  true">
                                      ${it.numeroTelefonico}
                                  </g:findAll>
                                    </a>
                                  </div>
                                </div>  
                              
                                <div class="profile-info-row ">
                                  <div class="profile-info-name"> Nombre </div>
                                  <div class="profile-info-value  align-left">
                                   <input type="text" id="form-field-1" placeholder="${usuarioAdministrador.perfil.nombre}" readonly/>
                                   <input type="text" id="form-field-1" placeholder="${usuarioAdministrador.perfil.apellidoPaterno}" readonly/>
                                   <input type="text"  placeholder="${usuarioAdministrador.perfil.apellidoMaterno}" readonly/>
                                  </div>
                                </div>


                                <div class="profile-info-row">
                                  <div class="profile-info-name"> Sexo </div>

                                  <g:formRemote name="sexoUsuario" update="sexoDiv" url="[controller:'perfil', action:'actialuzarSexo', params:[id: "${usuarioAdministrador.perfil.id}"]]">
                                     <div class="profile-info-value" id="sexoDiv">
                                     <g:radioGroup name="sexo" labels="['Femenino','Masculino']" values="['Femenino','Masculino']" value="${usuarioAdministrador.perfil.sexo}" >
                                      <p>${it.label} ${it.radio}</p>
                                     </g:radioGroup>
                                      <p></p>
                                         <button type="submit" class="btn btn-mini">
                                          Actualizar
                                         </button>
                                    </div>
                                  </g:formRemote>
                                </div>

                                <div class="profile-info-row">
                                  <div class="profile-info-name"> Fecha Nacimiento </div>
                                    <g:formRemote name="fechaDeNacimiento" update="fechaNacimientoDiv" url="[controller:'perfil', action:'actualizarFechaNacimiento', params:[id: "${usuarioAdministrador.perfil.id}"]]">
                                      <div class="profile-info-value" id="fechaNacimientoDiv">
                                        <div id="fechaNamiciento" class="input-append date" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                                         <input id="fechaNacimiento" name="fechaNacimiento" class="fechaNacimiento" data-format="yyyy-mm-dd" type="text" placeholder="${usuarioAdministrador.perfil?.fechaDeNacimiento?.format("dd/MM/yyyy") ?: ''}"></input>
                                         <span class="add-on">
                                         <i class="icon-calendar"></i>
                                         </span>
                                         <p></p>
                                         <button type="submit" class="btn btn-mini">
                                          Actualizar
                                         </button>
                                        </div>
                                      </div>
                                    </g:formRemote>
                                  </div>
                                </div>

                            </div>
                          </div>
                          </div>
                        </div><!--#home-->
                        <div id="feed" class="tab-pane">
                          <div id="feed" class="tab-pane">
                            <g:render template="/telefono/list" model="[telefonos:usuarioAdministrador.perfil.telefonos]" />
                          </div>
                        </div>
                        <div id="banco" class="tab-pane">
                          <div class="span4">
                            <g:render template="/cuentasBancarias/trasnferenciaElectronica"  />
                          </div>
                          <div class="span8" id="transferencia">
                            <g:render template="/cuentasBancarias/listaTransferenciaElectronica" model="[electronica:electronica]" />
                          </div>
                          <div class="row-fluid"> 
                            <div class="span12">                        
                              <div class="hr dotted"></div>
                            </div>
                          </div>
                          <div class="row-fluid">
                            <div class="span12">
                              <g:render template="/cuentasBancarias/cheque" />
                              <div class="span8" id="listaCheque">
                                <g:render template="/cuentasBancarias/listaCheque" model="[cheque:cheque]"/>
                              </div>
                            </div>
                          </div>

                          <div class="row-fluid"> 
                          <div class="span12">                        
                            <div class="hr dotted"></div>
                          </div>
                          </div>

                          <div class="row-fluid">
                            <div class="span12">
                              <div class="span4">
                                <g:render template="/cuentasBancarias/ficha"/>
                              </div>
                              <div class="span8" id="listaFicha">
                              <g:render template="/cuentasBancarias/listaFicha" model="[ficha:ficha]" />
                              </div>
                            </div>
                          </div>
                        </div>

                        <div id="password" class="tab-pane">
                  <g:form name="password" controller="perfil" action="actualizarPassword">
                    <div class="profile-user-info profile-user-info-striped">
                      <div class="profile-info-row ">
                        <div class="profile-info-name"> Nueva contraseña </div>

                        <div class="profile-info-value  align-left">
                          <input type="password" id="nuevaContrasenia" name="nuevaContrasenia" placeholder="Nueva contraseña">
                        </div>
                      </div>
                      <div class="profile-info-row ">
                        <div class="profile-info-name"> Confirmar  </div>
                        <div class="profile-info-value  align-left">
                          <input type="password" id="confirmaContrasenia" name="confirmaContrasenia" placeholder="Confirma contraseña">
                        </div>
                      </div>
                      <div class="profile-info-value  align-left" style="text-align:right;">
                        <button type="submit" class="btn btn-primary" >
                          Actualizar contraseña
                        </button>
                      </div>
                    </div>
                  </g:form>
                </div>

                      </div>
                    </div>



                    <div class="form-actions center">
                      <!--<button class="btn btn-info" type="button">
                        <i class="icon-ok bigger-110"></i>
                        Guarda
                      </button>
                      &nbsp; &nbsp; &nbsp;
                      <button class="btn" type="reset">
                        <i class="icon-undo bigger-110"></i>
                        Limpiar
                      </button>-->
                    </div>

                </div>
              </div>
              <!--PAGE CONTENT ENDS-->
  </body>
</html>
