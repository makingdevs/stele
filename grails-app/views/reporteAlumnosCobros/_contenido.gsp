<div class="row-fluid">
	<div class="span12">
		<div class="row-fluid">
			<div class="span12">
				<div class="tabbable">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
						  <a data-toggle="tab" href="#generados">Generados <span class="badge ">${listaCobrosGenerados != null ? listaCobrosGenerados.size : 0}</span></a>
						</li>
						<li>
						  <a data-toggle="tab" href="#xconciliar"> Por Conciliar <span class="badge badge-warning">${listaCobrosPorCanciliar != null ? listaCobrosPorCanciliar.size : 0}</span></a>
						</li>
						<li>
						  <a data-toggle="tab" href="#conciliados"> Conciliados <span class="badge badge-success">${listaCobrosConcialiados != null ? listaCobrosConcialiados.size : 0}</span></a>
						</li>
						<li>
						  <a data-toggle="tab" href="#rechazados"> Rechazados <span class="badge badge-purple">${listaCobrosRechazados != null ? listaCobrosRechazados.size : 0}</span></a>
						</li>
						<li>
						  <a data-toggle="tab" href="#vencidos"> Vencidos <span class="badge badge-important">${listaCobrosVencidos != null ? listaCobrosVencidos.size : 0}</span></a>
						</li>
						<li>
						  <a data-toggle="tab" href="#todos"> Todos <span class="badge badge-info">${listaCobrosTodos != null ? listaCobrosTodos.size : 0}</span></a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="generados" class="tab-pane in active">
							<g:render template="cobrosGenerados" />
						</div>
						<div id="xconciliar" class="tab-pane">
						    <g:render template="cobrosPorConciliar" />
						</div>
						<div id="conciliados" class="tab-pane ">
							<g:render template="cobrosConciliados" />
						</div>
						<div id="rechazados" class="tab-pane ">
                            <g:render template="cobrosRechazados" />
						</div>
						<div id="vencidos" class="tab-pane">
                            <g:render template="cobrosVencidos" />
						</div>
						<div id="todos" class="tab-pane">
                            <g:render template="cobrosTodos" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>