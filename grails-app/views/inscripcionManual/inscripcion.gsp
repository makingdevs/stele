<html >
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
      $("#dependientesCoincidentesForm").submit(function(event){
        event.stopPropagation();
        alert("perra");
        var url = $(this).attr('action');
        var data = $(this).serialize()
        $.ajax({
          type: "GET",
          url: url,
          dataType: "json",
          contentType: "application/json",
          data: data,
          success: function(data) {
            console.log(data);
            $("#listaAlumnos").html(data)  
          }
        });
        return false;
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
              <a href="#">Inscripcion</a>
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
              Inscripcion Manual
              <small>
                <i class="icon-double-angle-right"></i>
                Inscripcion Manual de un Alumno y Padre o Tutor
              </small>
            </h1>
          </div>

            <g:if test="${flash.success}">  
              <div id="message"class="alert alert-success">
                ${flash.success}
              </div>
            </g:if>
            <g:if test="${flash.error}">  
              <div id="message"class="alert alert-error">
                ${flash.error}
              </div>
            </g:if>
          <div class="row-fluid">
            <div class="span12">
              <g:form id="registroAlumno" name="registroAlumno" url="[controller: 'inscripcionManual', action: 'crearUsuarioCondependiente']" class="form-horizontal">
                <div id="alumnosPart">
                  <g:render template="seccionAlumno"/>
                </div>
                <!--Alumno Fin-->
                <!--Padre Inicia-->
                <div class="row-fluid" id="tutorPart">
                  <g:render template="seccionTutor" />
                </div>
                <!--Padre Fin-->
                <div class="form-actions">
                  <button class="btn btn-danger" data-toggle="modal" href="#modal-formConfirmar" type="btn-danger">
                    <i class="icon-trash bigger-110"></i>
                    Eliminar
                  </button>
                  &nbsp; &nbsp; &nbsp;
                  <button class="btn btn-info"  type="submit">
                    <i class="icon-ok bigger-110"></i>
                    Aceptar
                  </button>
                  &nbsp; &nbsp; &nbsp;
                  <button class="btn" type="reset">
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
