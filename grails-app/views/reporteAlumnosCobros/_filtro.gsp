<div class="row-fluid">
    <div class="span12">
        <form class="form-horizontal">
        <div class="row-fluid">
            <div class="span12">
                <div class="control-group">
                    <label class="control-label">Tipo de Fecha </label>
                    <div class="controls">
                        <div class="span2">
                            <input class="ace" type="radio" name="form-field-radio"> 
                            <label class="lbl"> Vencimiento</label>
                        </div>
                        <div class="span3">
                            <input class="ace" type="radio" name="form-field-radio"> 
                            <label class="lbl"> Envio comprbante</label>
                        </div>
                        <div class="span2">
                            <input class="ace" type="radio" name="form-field-radio"> 
                            <label class="lbl"> Conciliacion</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="span12">
                <div class="span3">
                    <label for="form-field-select-1">Fecha inicio</label> <input
                        type="text" id="form-field-1" placeholder="poner un calendar" />
                </div>
                <div class="span3">
                    <label for="form-field-select-1">Fecha Fin</label> <input
                        type="text" id="form-field-1" placeholder="poner un calendar" />
                </div>
                <div class="span3">
                    <label for="form-field-select-4">Concepto</label> <select
                        id="form-field-select-4" data-placeholder="Concepto">
                        <option value="0">Todos</option>
                        <option value="1">Colegiatura</option>
                        <option value="2">Colergiatuara 2</option>
                    </select>
                </div>
                <div class="span3">
                    <label for="form-field-select-4"></br></label>
                    <button class="btn btn-purple btn-small">
                        <i class="icon-search icon-on-right"></i> Buscar
                    </button>
                </div>
            </div>
        </div>
        <div class="hr hr-10 dotted hr-double"></div>
        <div class="row-fluid">
            <div class="span12">
                <div id="accordion" class="accordion">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a href="#collapseOne" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed"> Filtro Avanzado (click) </a>
                        </div>
                        <div class="accordion-body collapse" id="collapseOne">
                            <div class="accordion-inner">
                                <div class="span3">
                                    <label for="form-field-select-1">Nivel</label> <select
                                        id="form-field-select-1"
                                        data-placeholder="Seleccione un nivel...">
                                        <option value="0">Todos</option>
                                        <option value="1">Maternal</option>
                                        <option value="2">Kinder</option>
                                        <option value="3">Preprimaria</option>
                                        <option value="4">Primaria</option>
                                        <option value="5">Secundaria</option>
                                    </select>
                                </div>
                                <div class="span3">
                                    <label for="form-field-select-2">Grado</label> <select
                                        id="form-field-select-2"
                                        data-placeholder="Seleccione un grado...">
                                        <option value="0">Todos</option>
                                        <option value="1">Maternal</option>
                                        <option value="2">Kinder</option>
                                        <option value="3">Preprimaria</option>
                                        <option value="4">Primaria</option>
                                        <option value="5">Secundaria</option>
                                    </select>
                                </div>
                                <div class="span3">
                                    <label for="form-field-select-3">Grupo</label> <select
                                        id="form-field-select-3"
                                        data-placeholder="Seleccione un grupo...">
                                        <option value="0">Todos</option>
                                        <option value="1">Maternal</option>
                                        <option value="2">Kinder</option>
                                        <option value="3">Preprimaria</option>
                                        <option value="4">Primaria</option>
                                        <option value="5">Secundaria</option>
                                    </select>
                                </div>
                                <div class="span3">
                                    <label for="form-field-select-4">turno</label> <select
                                        id="form-field-select-4"
                                        data-placeholder="Seleccione un turno...">
                                        <option value="0">Todos</option>
                                        <option value="1">Matutino</option>
                                        <option value="2">Vespertino</option>
                                    </select>
                                </div>
                                <div class="span12"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <g:render template="contenido" />
    </div>
</div>
