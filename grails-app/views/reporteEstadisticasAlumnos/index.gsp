<%@ page import="com.stele.NivelDeEstudio"%>
<%@ page import="com.stele.Turno"%>
<html>
<head>
<meta name="layout" content="colegio" />
<r:require modules="graficacion" />
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
				<li class="active">Estadisticas Alumnos</li>
			</ul>
		</div>
		<div class="page-content">
			<div class="page-header position-relative">
				<h1>Alumnos Inscritos <small> <i class="icon-double-angle-right"></i> Estadisticas Alumnos</small></h1>
			</div>
			<div class="page-content-area">
			    <g:if test="${flash.error}">
                  <div class="alert alert-error ">
                    ${flash.error}
                  </div> 
                </g:if>
                <g:if test="${!flash.error}">
				    <div id="graficaNiveles" style="height: 300px" class="chart"></div>
				    <script type="text/javascript">
                    $(function () {
                        $('#graficaNiveles').highcharts({
                            chart: {
                                type: 'pie',
                                options3d: {
                                    enabled: true,
                                    alpha: 45
                                }
                            },
                            title: {
                                text: '${estadisticas.titulo}'
                            },
                            subtitle: {
                                text: '<span style="font-size: 13px; color: #007AFF; font-weight: bold">${estadisticas.totalAlumno} Estudiantes  -  </span> <span style="font-size: 12px; color: #F75353; font-weight: bold"> ${estadisticas.fecha}</span>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    innerSize: 75,
                                    depth: 35
                                }
                            },
                            series: [{
                                name: 'Porcentaje',
                                data: [
                                    <g:each in="${estadisticas.niveles}">
                                       ['${it.nivel} - ${it.totalNivel}', ${it.porcentaje}],
                                    </g:each>
                                ]
                            }]
                        });
                    });
                    </script>
				    <div class="spacer"></div>
				    
                    <div id="graficaGrados" style="height: 300px" class="chart"></div>
				    <script type="text/javascript">
				    $(function () {
				        $('#graficaGrados').highcharts({
				            chart: {
				                type: 'bar'
				            },
				            title: {
				                text: '${estadisticasPorGradoYNivel.titulo}',
				                style: {
				                    fontWeight: 'bold',
				                    color: '#FF9500'
				                    }
				            },
                            subtitle: {
                                text: '<span style="font-size: 13px; color: #007AFF; font-weight: bold">${estadisticas.totalAlumno} Estudiantes  -  </span> <span style="font-size: 12px; color: #F75353; font-weight: bold"> ${estadisticas.fecha}</span>'
                            },
				            xAxis: {
				                categories: [<g:each in="${listaNiveles}">
			                                    '${it}',
			                                </g:each>'',],
	                            title: {
	                                text: 'NIVEL',
	                                style: {
	                                fontWeight: 'bold',
	                                color: '#6600CC'
	                                }
	                            },
				                stackLabels: {
				                    enabled: true,
				                    style: {
				                        fontWeight: 'bold',
				                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
				                    }
				                }
				            },
				            yAxis: {
				                tickInterval: 5,
				                min: 0,
				                title: {
				                    text: 'NUMERO DE ESTUDIANTES',
				                    style: {
				                    fontWeight: 'bold',
				                    color: '#6600CC'
				                    }
				                },
				                stackLabels: {
				                    enabled: true,
				                    style: {
				                        fontWeight: 'bold',
				                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'blue'                    
				                    },
				                    formatter: function () {
				                        return this.total + " Estudiantes";
				                    }
				                }
				            },
				            legend: {
						                title: {
						                    text: 'GRADOS', 
						                },
				                        align: 'left',
				                        x: 130,
				                        verticalAlign: 'top',
				                        y: 0,
				                        floating: true,
				                        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
				                        borderColor: '#CCC',
				                        borderWidth: 1,
				                        shadow: false,
				                        reversed: true
				                    },
				            plotOptions: {
				                series: {
				                    stacking: 'normal',
				                        dataLabels: {
				                        enabled: true,
				                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
				                        style: {
				                            textShadow: '0 0 3px black, 0 0 3px black'
				                        },
				                    }
				                },
				                column: {
				                    stacking: 'normal',

				                }
				            },
				            series: [<g:each var="grado" in="${estadisticasPorGradoYNivel.grados}">
							            {name: '${grado.grado}º',
							            data: [
									       <g:each var="nivel" in="${grado.niveles}">
									       ${nivel.total} == 0 ? null : ${nivel.total},
									       </g:each>
									            ]},
		                            </g:each>
                            ]
				        });
				    });
				    </script>
                    <div class="spacer"></div>
                    <g:each var="nivel" in="${estadisticasPorNivelGradoYGrupo.niveles}">
	                    <div id="graficaGrupos${nivel.nivel}" style="height: 300px" class="chart"></div>
	                    <script type="text/javascript">
	                    $(function () {
                        	$("#graficaGrupos${nivel.nivel}").highcharts({
                                chart: {
                                    type: 'column'
                                },
                                title: {
                                    text: '${estadisticasPorNivelGradoYGrupo.titulo}${nivel.nivel}',
                                    style: {
                                        fontWeight: 'bold',
                                        color: '#CB79E6'
                                        }
                                },
                                subtitle: {
                                    text: '<span style="font-size: 13px; color: #007AFF; font-weight: bold"> ${nivel.totalNivel} Estudiantes  -  </span>  <span style="font-size: 12px; color: #F75353; font-weight: bold"> ${estadisticasPorNivelGradoYGrupo.fecha} </span>  '
                                },
                                xAxis: {
                                    title: {
	                                    text: 'GRADOS',
	                                    style: {
	                                    fontWeight: 'bold',
	                                    color: '#6600CC'
	                                    }
	                                },
                                    categories: [<g:each var="grado" in="${nivel.listaGrados}">
                                    '${grado}º',
                                    </g:each>'',]
                                },
                                yAxis: {
                                	min: 0,
                                    tickInterval: 10,
                                    title: {
                                        text: 'Num. Estudiantes',
                                        style: {
                                        fontWeight: 'bold',
                                        color: '#6600CC'
                                        }
                                    }
                                },
                                tooltip: {
                                    headerFormat: '<span style="font-size:12px;font-weight: bold">GRADO {point.key}</span><table>',
                                    pointFormat: '<tr><td style="font-weight: bold; color:{series.color};padding:0">{series.name}: </td>' +
                                        '<td style="padding:0"><b>{point.y} </b></td></tr></tbody></table>',
                                    shared: true,
                                    useHTML: true
                                },
                                legend: {
                                            align: 'right',
                                            x: -70,
                                            verticalAlign: 'top',
                                            y: 20,
                                            floating: true,
                                            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                                            borderColor: '#CCC',
                                            borderWidth: 1,
                                            shadow: false
                                        },
                                plotOptions: {
                                    column: {
                                        pointPadding: 0.2,
                                        borderWidth: 0
                                    }
                                },
                                series: [
                                    <g:each var="grupo" in="${nivel.grupos}">
	                                    {
		                                    name: '"GRUPO ${grupo.grupo}"',
		                                    data: [
                                                <g:each var="grado" in="${grupo.grados}">
                                                    ${grado.total} > 0 ? ${grado.total} : null,
                                                </g:each>
		                                    ],
		                                    dataLabels: {
		                                        enabled: true,
		                                        rotation: -90,
		                                        color: '#FFFFFF',
		                                        align: 'right',
		                                        x: 4,
		                                        y: 10,
		                                        style: {
		                                            fontSize: '11px',
		                                            fontFamily: 'Verdana, sans-serif',
		                                            textShadow: '0 0 2px black'
		                                        }
		                                    }
		                                }, 
		                            </g:each>
			                    ],
                            }); 
	                    });
	                    </script>
	                    <div class="spacer"></div>
	               </g:each>
                </g:if>
			</div>
		</div>
	</div>
</body>
</html>
