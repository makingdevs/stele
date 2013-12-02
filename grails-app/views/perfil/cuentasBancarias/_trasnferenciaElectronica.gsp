<div class="span4">
  <g:formRemote name="transferenciaElectronica" update="transferencia" url="[controller : 'cuentasBancarias', action : 'crearCuentaBancaria', params : [tipoTransferencia:'TRANSFERENCIAELECTRONICA ']]">
    <div class="profile-user-info profile-user-info-striped">
      <div class="profile-contact-info">
        <div class="profile-contact-links center">
          Transferencia Electronica
        </div>
      </div>  
      <div class="profile-info-row ">
      <div class="profile-info-name"> 
        Banco 
      </div>
      <div class="profile-info-value  align-left">
        <input type="text" id="nombreDeBanco" name="nombreDeBanco" placeholder="banco" />
      </div>
      </div>
      <div class="profile-info-row ">
      <div class="profile-info-name"> 
        Cuenta 
      </div>
      <div class="profile-info-value  align-left">
        <input type="text" id="numeroDeCuenta" name="numeroDeCuenta" placeholder="cuenta" />
      </div>
      </div>
      <div class="profile-info-row ">
      <div class="profile-info-name"> 
        Beneficiario 
      </div>
      <div class="profile-info-value  align-left">
        <g:textArea class="span12 limited" name="beneficiario" rows="3" cols="40"/>
      </div>
      </div>                              
      <div class="profile-info-row ">
      <div class="profile-info-name"> 
        Cuenta Interbancaria
      </div>
      <div class="profile-info-value  align-left">
        <input type="text" id="cuentaInterbancaria" name="cuentaInterbancaria" placeholder="cuenta clabe" />
      </div>
      </div>
      <div class="profile-info-row">
      <div class="profile-info-name">  </div>
      <div class="profile-info-value center">
      <button type="submit" class="btn btn-mini btn-success ">
        Agregar
        <i class="icon-arrow-right  icon-on-right"></i>
      </button>
      </div>
      </div>
    </div>
  </g:formRemote>
</div>  
<div class="span8" id="transferencia">
  <table id="sample-table-1" class="table table-striped table-bordered table-hover">
    <thead >
      <tr>
        <th>Banco</th>
        <th>Cuenta</th>
        <th>Beneficiario</th>
        <th>Cuenta Interbancaria</th>   
        <th></tr>
    </thead>
    <tbody>
      <tr>
        <td>Bancomer</td>
        <td>1234567890</td>
        <td>Instituto Makingdevs SC</td>
        <td>12345678901234567890</td>
        <td >
          <div class="action-buttons center">
            <a class="red" href="#">
              <i class="icon-trash bigger-130"></i>
            </a>
          </div>
        </td>
      </tr>                  
    </tbody>
  </table>
</div>
<div class="row-fluid"> 
  <div class="span12">                        
    <div class="hr dotted"></div>
  </div>
</div>