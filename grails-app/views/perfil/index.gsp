<%@ page import="com.payable.TipoDeTelefono" %>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="telefono"/>
  </head>

  <body>
    <div class="page-content">
     <div class="page-header position-relative">
       <h1>
         Editar perfil
       </h1>
     </div><!--/.page-header-->

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
                         <input type="file" />
                         <div class="space-4"></div>
                         <div class="width-80 label label-info label-large arrowed-in arrowed-in-right">
                           <div class="inline position-relative">
                             <span class="white middle bigger-120">${usuarioActual.perfil.nombre} ${usuarioActual.perfil.apellidoPaterno} ${usuarioActual.perfil.apellidoMaterno}</span>
                           </div>
                         </div>
                       </div>

                       <div class="span9">
                         <div class="profile-user-info profile-user-info-striped">
                           <div class="profile-contact-info">
                             <div class="profile-contact-links center">
                                 <i class="icon-envelope bigger-120 pink"></i>
                                 ${usuarioActual.username}
                                 <i class="icon-phone bigger-125 blue"></i>
                                  <g:findAll in="${usuarioActual.perfil.telefonos}" expr="it.principal ==  true">
                                    ${it.numeroTelefonico}
                                  </g:findAll>
                             </div>
                           </div>  
                         
                           <div class="profile-info-row ">
                             <div class="profile-info-name"> Nombre </div>

                             <div class="profile-info-value  align-left">
                                 <input type="text" id="form-field-1" placeholder="${usuarioActual.perfil.nombre}" readonly/>
                                   <input type="text" id="form-field-1" placeholder="${usuarioActual.perfil.apellidoPaterno}" readonly/>
                                   <input type="text"  placeholder="${usuarioActual.perfil.apellidoMaterno}" readonly/>
                             </div>
                           </div>




                           <div class="profile-info-row">
                             <div class="profile-info-name"> Sexo </div>

                             <div class="profile-info-value">
                                 <input class="ace" type="radio" name="form-field-sexo" >
                                 <span class="lbl"> Femenino</span>
                                 <input class="ace" type="radio"   name="form-field-sexo">
                                 <span class="lbl"> Masculino</span> 
                             </div>
                           </div>

                           <div class="profile-info-row">
                             <div class="profile-info-name"> Fecha Nacimiento </div>

                             <div class="profile-info-value">
                               <div class="input-append">
                                 <input type="text" id="datepicker" class="input-medium" placeholder="fecha nacimiento"  />
                                 <span class="add-on">
                                   <i class="icon-calendar"></i>
                                 </span>
                               </div>
                             </div>
                           </div>
                         </div>
                       </div>
                     </div>
                     </div>

                 <div class="row-fluid">                           
                    <div class="hr dotted"></div>
                     </div>
                    <g:each in="${usuarioActual.dependientes}"> 
                      <div class="row-fluid">
                      <div class="span12">
                       <div class="span3 center">
                         <input type="file" />
                         <div class="space-4"></div>
                         <div class="width-80 label label-purple label-large arrowed-in arrowed-in-right">
                           <div class="inline position-relative">
                               <span class="white middle bigger-120">${it.perfil.nombre} ${it.perfil.apellidoPaterno} ${it.perfil.apellidoMaterno}</span>
                           </div>
                         </div>
                       </div>

                       <div class="span9">
                         <div class="space-6"></div>
                         <div class="profile-user-info profile-user-info-striped">
                           <div class="profile-info-row ">
                             <div class="profile-info-name"> Grado </div>

                             <div class="profile-info-value  align-left">
                             <span>${it.historialAcademico.distribucionInstitucional.nivelDeEstudio.first()}</span>
                             </div>
                           </div>

                           <div class="profile-info-row">
                             <div class="profile-info-name"> Grupo </div>

                             <div class="profile-info-value">
                                 <span>${it.historialAcademico.distribucionInstitucional.grado.first()}° ${it.historialAcademico.distribucionInstitucional.grupo.first()}</span>
                             </div>
                           </div>

                           <div class="profile-info-row">
                             <div class="profile-info-name"> Fecha Nacimiento </div>

                             <div class="profile-info-value">
                               <div class="input-append">
                                 <input type="text" id="datepicker" class="input-medium" placeholder="fecha nacimiento"  />
                                 <span class="add-on">
                                   <i class="icon-calendar"></i>
                                 </span>
                               </div>
                             </div>
                           </div>
                         </div>
                         </div>
                       </div>
                      </div>
                    </g:each>
                   </div><!--#home-->

                <div id="feed" class="tab-pane">
                   <div class="row-fluid">
                    <div class="span12">
                      <div class="span4">
                       <div class="profile-user-info profile-user-info-striped">
                         <div class="profile-info-row ">
                           <div class="profile-info-name"> 
                           <i class="icon-phone"></i>
                             Telefono 
                           </div>

                           <div class="profile-info-value  align-left">
                             <input type="text" class="input-mini" maxlength="3" name="lada"></input>
                           </div>

                           <div class="profile-info-value  align-left">
                             <input type="text" class="input-small" maxlength="10" name="numeroTelefonico"></input>
                           </div>
                           <div class="profile-info-value  align-left">
                             <input type="text" class="input-mini" maxlength="6" name="extension"></input>
                           </div>
                         </div>
                         <div class="profile-info-row">
                           <div class="profile-info-name"> Tipo </div>
                           <div class="profile-info-value">
                             <input class="ace" type="radio" name="form-field-radio-tel">
                             <span class="lbl"> Personal</span>
                             <input class="ace" type="radio" name="form-field-radio-tel">
                             <span class="lbl"> Celular</span>   
                             <input class="ace" type="radio" name="form-field-radio-tel">
                             <span class="lbl"> Trabajo</span>
                           </div>
                         </div>
                         <div class="profile-info-row">
                           <div class="profile-info-name">  </div>
                           <div class="profile-info-value center">
                            <button class="btn btn-primary" style="text-align:center;">
                              <i class="icon-plus-sign icon-white"></i>
                            </button>
                           </div>
                         </div>
                       </div>
                      </div>
                     <div class="span8" id="listaTelefono">
                      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                         <thead >
                           <tr>
                             <th class="center">
                               <i class="icon-ok-circle blue"></i>
                               Principal 
                             </th>
                             <th>
                               <i class="icon-bookmark-empty blue"></i>
                               Tipo
                             </th>
                             <th>
                               <i class="icon-phone blue"></i>
                               Telefono
                             </th> <th>                  
                           </tr>
                         </thead>

                         <tbody>
                          <g:each in="${usuarioActual.perfil.telefonos}">
                            <tr>
                             <td class="center">
                              <g:if test="it.principal == true">
                                <i class="fa fa-check"></i>
                              </g:if>
                             </td>
                             <td class="center">
                              
                             </td>
                             <td class="center">
                              
                             </td>
                            </tr>     
                          </g:each>
                         </tbody>
                       </table>
                     </div>
                   </div>
                  </div>
                </div>



                <div id="password" class="tab-pane">
                     <div class="space-6"></div>
                     <div class="profile-user-info profile-user-info-striped">

                       <div class="profile-info-row ">
                         <div class="profile-info-name"> Actual contraseña </div>

                         <div class="profile-info-value  align-left">
                           <input type="password" id="form-field-pass" />
                         </div>
                       </div>

                       <div class="profile-info-row ">
                         <div class="profile-info-name"> Nueva contraseña </div>

                         <div class="profile-info-value  align-left">
                           <input type="password" id="form-field-pass1" />
                         </div>
                       </div>
                       <div class="profile-info-row ">
                         <div class="profile-info-name"> Confirmar  </div>
                         <div class="profile-info-value  align-left">
                           <input type="password" id="form-field-pass2" />
                         </div>
                       </div>
                     </div>
                </div>

               <div class="form-actions center">
                 <button class="btn btn-info" type="button">
                   <i class="icon-ok bigger-110"></i>
                   Guarda
                 </button>

                 &nbsp; &nbsp; &nbsp;
                 <button class="btn" type="reset">
                   <i class="icon-undo bigger-110"></i>
                   Limpiar
                 </button>
               </div>


           </div>
         </div>

         <!--PAGE CONTENT ENDS-->
       </div><!--/.span-->
     </div><!--/.row-fluid-->
    </div><!--/.page-content-->
  </body>
</html>
