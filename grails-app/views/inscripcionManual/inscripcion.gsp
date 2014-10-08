<html> 
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="inscripcion" />
    <r:script>
      $(function(){
        $("#listaAlumnos").on( "click", "#alumnosForm", function(){
          $("#dependientesCoincidentesForm").submit();
        });
      });
      $(function(){
        $("#listaTutor").on("click","#tutorForm", function(){
          $("#tutorCoincidentesForm").submit();
        })
      });
    </r:script>
  </head>
  <body>
     <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="icon-home home-icon"></i>
              <a href="#">Colegio</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>

            <li>
              <a href="#">Inscripción</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            </li>
            <li class="active">Manual</li>
          </ul><!--.breadcrumb-->
        </div>

        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Inscripción Manual
              <small>
                <i class="icon-double-angle-right"></i>
                Inscripción Manual de un Alumno y Padre o Tutor
              </small>
            </h1>
          </div>

            <g:if test="${messages?.error}">  
              <div id="message" class="alert alert-error">
                ${messages.error}
              </div>
            </g:if>
            <g:elseif test="${messages}">
              <div id="message" class="alert alert-success">
                ${messages?.message}
              </div>
            </g:elseif>
          <div class="row-fluid">
            <div class="span12">
              <g:form id="registroAlumno" name="registroAlumno" url="[controller: 'inscripcionManual', action: 'crearUsuarioCondependiente']" class="form-horizontal">
                <input type="hidden" id="urlValidarDependiente" value="${g.createLink(action:'validarDependienteExistente', controller:'inscripcionManual')}" />
                <div id="alumnosPart">
                  <g:render template="seccionAlumno"/>
                </div>
                <input type="hidden" id="urlValueUsername" value="${g.createLink(action:'validarUsuarioExistente', controller:'inscripcionManual')}" />
                <div class="row-fluid" id="tutorPart">
                  <g:render template="seccionTutor" />
                </div>
                <!--Padre Fin-->
                <div id="seccionBotones" class="form-actions">
                  &nbsp; &nbsp; &nbsp;
                  <button id="inscripcionForm"  class="btn btn-info"  type="button">
                    <i class="icon-ok bigger-110"></i>
                    Aceptar
                  </button>
                  &nbsp;&nbsp; &nbsp;
                  <button class="btn" type="reset" type="button">
                    <i class="icon-undo bigger-110"></i>
                    Limpiar
                  </button>
                </div>
              </g:form>
              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->
      </div><!--/.main-content-->

     
  </body>
</html>
