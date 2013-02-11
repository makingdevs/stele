class DatoPersonal < ActiveRecord::Base
  attr_accessible :apellidoMaterno, :apellidoPaterno, :curp, :fechaDeNacimiento, :genero, :nombre
end
