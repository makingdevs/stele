class Perfil < ActiveRecord::Base
  attr_accessible :perfil

  has_and_belongs_to_many :usuarios
end
