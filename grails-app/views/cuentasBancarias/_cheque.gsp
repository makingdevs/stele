<div class="span4">
  <g:formRemote name="cheque" update="listaCheque" url="[controller : 'cuentasBancarias', action : 'crearCuentaBancariaCheque', params : [tipoTransferencia:'CHEQUE']]">
    <div class="profile-user-info profile-user-info-striped">
      <div class="profile-contact-info">
        <div class="profile-contact-links center">
          Cheque
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
          <g:textArea class="span12 limited" name="beneficiario" rows="3" cols="40" style="resize: none;"/>
        </div>
      </div>
      <div class="profile-info-row">
        <div class="profile-info-name">  </div>
        <div class="profile-info-value center">
          <button type="submit" class="btn btn-mini">
            Agregar
            <i class="icon-arrow-right  icon-on-right"></i>
          </button>
        </div>
      </div>        
    </div>
 </g:formRemote>
</div>