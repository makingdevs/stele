<div class="span12 ">
	<div class="pull-right">
		<p>
			<button class="btn btn-small btn-success">
				<i class="icon-cloud-download"></i> EXCEL
			</button>
			<button class="btn btn-small btn-danger">
				<i class="icon-cloud-download "></i> PDF
			</button>
		</p>
	</div>
</div>
<div class="row-fluid">
	<table id="tableCobrosVencidos"
		class="table table-striped table-bordered table-hover">
		<thead>
		    <tr>
				<th>Nombre</th>
				<th>Ubicacion</th>
				<th>Concepto de Cobro</th>
				<th>Importe de </br> Cobro</th>
				<th>Fecha </br> Vencimiento</th>
				<th>Descuentos</th>
				<th>Recargo</th>
				<th>Periodos </br> Vencidos</th>
				<th>Dias </br> Vencidos</th>
			</tr>
		</thead>
		<tbody>
		    <g:each in="${listaCobrosVencidos}" var="dependiente">
			    <tr>
					<td>
                        ${dependiente.alumno.perfil.apellidoPaterno} ${dependiente.alumno.perfil.apellidoMaterno} ${dependiente.alumno.perfil.nombre}
                    </td>
                    <td>
                        ${dependiente.alumno.historialAcademico.distribucionInstitucional.nivelDeEstudio[0]}
                        - ${dependiente.alumno.historialAcademico.distribucionInstitucional.grado[0]}º
                        ${dependiente.alumno.historialAcademico.distribucionInstitucional.grupo[0]}
                    </td>
                    <td>
                        ${dependiente.pago.paymentConcept}
                    </td>
                    <td>
                        <g:formatNumber number="${dependiente.pago.paymentAmount}" type="currency" />
                    </td>
                    <td>
                        <g:formatDate format="dd-MMM-yyyy" date="${dependiente.pago.dueDate}" />
                    </td>
					<td>
                        <g:each in="${dependiente.pago.applicableDiscounts}" var="descuento">
                            <g:formatDate format="dd-MMM-yyyy" date="${descuento.expirationDate}" /> -- ${descuento.discount.discountName}
                            <g:if test="${descuento.discount.amount != null}">
                                <g:formatNumber number="${descuento.discount.amount}" type="currency" />
                            </g:if>
                            <g:if test="${descuento.discount.amount == null}">
                                ${descuento.discount.percentage}%
                            </g:if>
                        </g:each>
                    </td>
					<td>
                        <g:if test="${dependiente.pago.surcharge != null}">
                            <g:if test="${dependiente.pago.surcharge.amount != null}">
                                <g:formatNumber number="${dependiente.pago.surcharge.amount}" type="currency" />
                            </g:if>
                            <g:if test="${dependiente.pago.surcharge.amount == null}">
                                ${dependiente.pago.surcharge.percentage}%
                            </g:if>
                        </g:if>
                    </td>
					<td>2</td>
					<td>33</td>
				</tr>
			</g:each>
		</tbody>
	</table>
</div>
<script type="text/javascript">
	var oTable5 = $('#tableCobrosVencidos')
			.dataTable(
					{
						bAutoWidth : false,
						"aoColumns" : [ null, null, null, {
							"bSortable" : false
						}, null, {
							"bSortable" : false
						}, null, {
							"bSortable" : false
						}, null, null ],
						"aaSorting" : [],
						"language" : {
							"sProcessing" : "Procesando...",
							"sLengthMenu" : "Mostrar _MENU_ registros",
							"sZeroRecords" : "No se encontraron resultados",
							"sEmptyTable" : "Ningún dato disponible en esta tabla",
							"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
							"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
							"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
							"sInfoPostFix" : "",
							"sSearch" : "Buscar:",
							"sUrl" : "",
							"sInfoThousands" : ",",
							"sLoadingRecords" : "Cargando...",
							"oPaginate" : {
								"sFirst" : "Primero",
								"sLast" : "Último",
								"sNext" : "Siguiente",
								"sPrevious" : "Anterior"
							},
							"oAria" : {
								"sSortAscending" : ": clic para ordenar la columna de manera ascendente",
								"sSortDescending" : ": clic para ordenar la columna de manera descendente"
							}
						}
					});
</script>