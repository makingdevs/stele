class Usuario < ActiveRecord::Base
  attr_accessible :email, :password, :perfil_id

  belongs_to :perfil
  has_and_belongs_to_many :dependientes
end
