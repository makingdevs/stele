class Perfil < ActiveRecord::Base
  attr_accessible :apellidoMaterno, :apellidoPaterno, :curp, :fechaDeNacimiento, :genero, :nombre

  has_one :usuario
  has_one :dependiente
end
