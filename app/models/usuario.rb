class Usuario < ActiveRecord::Base
  attr_accessible :email, :password
  attr_protected :perfil_id

  belongs_to :perfil
  has_and_belongs_to_many :dependientes
  has_and_belongs_to_many :autoridads
end
