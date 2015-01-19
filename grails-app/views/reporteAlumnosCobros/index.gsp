<%@ page import="com.stele.NivelDeEstudio"%>
<%@ page import="com.stele.Turno"%>
<html>
<head>
<meta name="layout" content="colegio" />
<%--<r:require modules="reporteAlumnosCobros" />--%>
</head>
<body>
	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
				    <i class="icon-home home-icon"></i> 
				    <a href="#">Reportes</a>
					<span class="divider"> 
					   <i class="icon-angle-right arrow-icon"></i>
				    </span>
				</li>
				<li class="active">Cobros Alumnos</li>
			</ul>
		</div>
		<div class="page-content">
			<div class="page-header position-relative">
				<h1>Reportes <small> <i class="icon-double-angle-right"></i> Cobros</small></h1>
			</div>
			<div class="page-content-area">
                <g:render template="filtro" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
		jQuery(function($) {

			$('.date-picker').datepicker().next().on(ace.click_event,
					function() {
						$(this).prev().focus();
					});
		});
	</script>
</body>
</html>
