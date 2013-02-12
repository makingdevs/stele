class Dependiente < ActiveRecord::Base
  attr_accessible :perfil_id

  belongs_to :perfil
end
