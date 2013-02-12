class Dependiente < ActiveRecord::Base
  attr_accessible :perfil_id

  belongs_to :perfil
  has_and_belongs_to_many :usuarios
end
