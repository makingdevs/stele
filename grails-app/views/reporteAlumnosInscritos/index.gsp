<%@ page import="com.stele.NivelDeEstudio"%>
<%@ page import="com.stele.Turno"%>
<html>
<head>
<meta name="layout" content="colegio" />
<r:require modules="reporteAlumnosInscritos" />
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
				</li>
				<li>
				    <a href="#">Reportes</a> 
				    <span class="divider"> 
				        <i class="icon-angle-right arrow-icon"></i>
				    </span>
				</li>
				<li class="active">Alumnos Inscritos</li>
			</ul>
		</div>
		<div class="page-content">
			<div class="page-header position-relative">
				<h1>Alumnos Inscritos <small> <i class="icon-double-angle-right"></i> Reporte de Alumnos inscritos</small></h1>
			</div>
			<div class="page-content-area">
			    <g:if test="${flash.error}">
                  <div class="alert alert-error ">
                    ${flash.error}
                  </div> 
                </g:if>
                <g:if test="${!flash.error}">
				<div class="row-fluid">
					<div class="span12">
						<div class="row-fluid">
							<g:form controller="reporteAlumnosInscritos" action="index">
								<div class="span12">
									<div class="span3">
										<label for="nivel">Nivel</label>
										<g:select id="nivel" name="nivel" value="${params?.nivel}"
											noSelection="${['':'Todos los Niveles']}"
											from="${listaNiveles}" optionKey="key"></g:select>
									</div>
									<div class="span3">
										<label for="grado">Grado</label>
										<g:select id="grado" name="grado" value="${params?.grado}"
											noSelection="${['':'Todos los Grados']}"
											from="${listaGrados}"></g:select>
									</div>
									<div class="span3">
										<label for="grupo">Grupo</label>
										<g:select id="grupo" name="grupo" value="${params?.grupo}"
											noSelection="${['':'Todos los Grupos']}"
											from="${listaGrupos}"></g:select>
									</div>
									<div class="span3">
										<label for="duration">Turno</label>
										<g:select id="turno" name="turno" value="${params?.turno}"
											noSelection="${['':'Todos los Turnos']}"
											from="${listaTurnos}" optionKey="key"></g:select>
									</div>
								</div>
								<div class="span3">
									<button type="submit" id="submitForm" class="btn btn-purple btn-block">
										<i class="ace-icon icon-search"></i> Buscar
									</button>
								</div>
								<div class="span3">
									<g:link controller="reporteAlumnosInscritos" action="index">
										<button type="button" class="btn btn-default btn-block">
											<i class="ace-icon icon-undo"></i> Limpiar
										</button>
									</g:link>
								</div>
							</g:form>
							<div class="span1"></div>
							<div class="span3">
								<div class="span6">
								    <g:form controller="reporteAlumnosInscritos" action="generaReporte">
                                        <g:hiddenField id="nivel" name="nivel" value="${params?.nivel}" />
                                        <g:hiddenField id="grado" name="grado" value="${params?.grado}" />
                                        <g:hiddenField id="grupo" name="grupo" value="${params?.grupo}" />
                                        <g:hiddenField id="turno" name="turno" value="${params?.turno}" />
                                        <button class="btn btn-small btn-warning " type="submit">
                                            <i class="ace-icon icon-download-alt "></i> Descargar Excel
                                        </button>
                                    </g:form>
								</div>
								<div class="span6">
								    <g:form controller="reporteAlumnosInscritos" action="generaReportePdf">
                                        <g:hiddenField id="nivel" name="nivel" value="${params?.nivel}" />
                                        <g:hiddenField id="grado" name="grado" value="${params?.grado}" />
                                        <g:hiddenField id="grupo" name="grupo" value="${params?.grupo}" />
                                        <g:hiddenField id="turno" name="turno" value="${params?.turno}" />
                                        <button class="btn btn-small btn-warning " type="submit">
                                            <i class="ace-icon icon-download-alt "></i> Descargar PDF
                                        </button>
                                    </g:form>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<div class="hr hr-18 dotted hr-double"></div>
								<table id="tablaReporteAlumnos" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
										    <th>Matricula</th>
										    <th>Estudiante</th>
											<th>Padre o Tutor</th>
                                            <th>Teléfono</th>
											<th>Correo</th>
											<th>Nivel</th>
											<th>Grado</th>
											<th>Grupo</th>
											<th>Turno</th>
										</tr>
									</thead>
									<tbody>
										<g:each in="${dependientes}">
											<tr>
											    <td>${it.matricula}</td>
											    <td>${it.perfil.nombre} ${it.perfil.apellidoPaterno} ${it.perfil.apellidoMaterno}</td>
												<td>${it.usuario.perfil.nombre} ${it.usuario.perfil.apellidoPaterno} ${it.usuario.perfil.apellidoMaterno}</td>
                                                <td>${it.usuario.perfil.telefonos.lada[0]} ${it.usuario.perfil.telefonos.numeroTelefonico[0]}</td>
												<td>${it.usuario.username}</td>
												<td>${it.historialAcademico.distribucionInstitucional.nivelDeEstudio[0]}</td>
												<td>${it.historialAcademico.distribucionInstitucional.grado[0]}</td>
												<td>${it.historialAcademico.distribucionInstitucional.grupo[0]}</td>
												<td>${it.historialAcademico.distribucionInstitucional.turno[0]}</td>
											</tr>
										</g:each>
									</tbody>
								</table>
							</div>
						</div>
						</g:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
