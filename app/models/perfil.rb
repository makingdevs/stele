class Perfil < ActiveRecord::Base
  attr_accessible :apellidoMaterno, :apellidoPaterno, :nombre, :usuario_id
end
