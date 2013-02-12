class Usuario < ActiveRecord::Base
  attr_accessible :email, :password, :perfil_id

  belongs_to :perfil
end
