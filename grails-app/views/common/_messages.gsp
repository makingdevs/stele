<div class="row">
    <g:if test="${flash.error}">  
    <div class="alert hide alert-error">
      <strong>Oh snap!</strong> <span class="message"> Change a few things up and try submitting again.</span>
    </div>
  </g:if>
  <g:elseif test="${flash.success}">
    <div class="alert hide alert-success">
      <strong>Bien hecho!</strong> <span class="message"> You successfully read this important alert message.</span>
    </div>
  </g:elseif>
  <g:elseif test="${flash.info}">  
    <div class="alert hide alert-info">
      <strong>Heads up!</strong> <span class="message"> This alert needs your attention, but it's not super important.</span>
    </div>
  </g:elseif>
  <g:elseif test="${flash.warning}" >
    <div class="alert hide alert-block">
      <h4>Warning!</h4>
      <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
    </div>
  </g:elseif>
</div>